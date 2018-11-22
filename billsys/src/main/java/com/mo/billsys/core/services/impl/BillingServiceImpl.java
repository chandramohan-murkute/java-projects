package com.mo.billsys.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mo.billsys.core.services.BillingService;
import com.mo.billsys.core.services.ProductService;
import com.mo.billsys.dto.Bill;
import com.mo.billsys.dto.BillItem;
import com.mo.billsys.dto.Customer;
import com.mo.billsys.dto.Order;
import com.mo.billsys.dto.OrderItem;
import com.mo.billsys.dto.Product;

@Service
public class BillingServiceImpl implements BillingService{

	@Autowired
	private ProductService productService;
	
	
	@Override
	public Bill calculateBill(Order order, Customer customer) {
		Bill bill = null;
		List<BillItem> billItems = new ArrayList<BillItem>();
		BillItem billItem = null;
		Float totalPrice=0F;
		Float totalTax=0F;
		Float amountPayble=0F;
		int cnt=0;

		List<OrderItem> items = order.getItems();
		for (OrderItem orderItem : items) {
			billItem = calculateBillItem(orderItem, ++cnt);
			billItems.add(billItem);
			totalPrice = totalPrice + billItem.getPrice();
			totalTax = totalTax + billItem.getTaxAmt();
			amountPayble = amountPayble + billItem.getAmount();
		}
		
		bill = new Bill(customer, billItems, totalPrice, totalTax, amountPayble);
		return bill;
	}

	private BillItem calculateBillItem(OrderItem orderItem, int cnt) {
		Product product = productService.getProduct(orderItem.getProductId());
		
		Float price = orderItem.getQuantity() * product.getCost();
		Float taxAmt = price * (product.getLevy()/100);
		Float amount = price + taxAmt;
		
		BillItem billItem = new BillItem(cnt, orderItem.getOrderItemId(), product, orderItem.getQuantity(), price, taxAmt, amount);
		return billItem;
	}

	
}

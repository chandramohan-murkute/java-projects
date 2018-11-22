package com.mo.billsys.web.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mo.billsys.controller.BillingController;
import com.mo.billsys.dto.Bill;
import com.mo.billsys.dto.BillItem;
import com.mo.billsys.dto.Customer;
import com.mo.billsys.dto.Order;
import com.mo.billsys.dto.OrderItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BillingControllerTest {

	@Autowired
	private BillingController billingController;
	
	@Test
	public void testDisplayBill() {
		Customer customer = new Customer(1,"Chandramohan");
		Order order1 = new Order(10L,loadOrderItems(),customer);
		ObjectMapper mapper= new ObjectMapper();
		try {

			String customerStr = mapper.writeValueAsString(customer);
			System.out.println("customerStr = "+customerStr);
			
			String orderStr = mapper.writeValueAsString(order1);
			System.out.println("orderStr = "+orderStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bill bill = billingController.displayBill(order1);
		assertNotNull(bill);
		assertNotNull(bill.getBillItems());
		assertEquals(9, bill.getBillItems().size());
		assertNotNull(bill.getAmountPayble());
		displayFormattedBill(bill);
	}

	private void displayFormattedBill(Bill bill) {
		System.out.println("\n\n============================================================================================================");
		System.out.println("Date 	:	" +bill.getDate());
		System.out.println("Name 	:	" +bill.getCustomer().getCustomerName());
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Sr.No.\t"+String.format("%-" + 30 + "." + 30 + "s","Item(category)")+"\tquantity\tcost\tprice\ttax(%)\tTaxAmt\tAmount");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for (BillItem billItem : bill.getBillItems()) {
			String productDispName = String.format("%-" + 30 + "." + 30 + "s", (billItem.getProduct().getName()+"("+billItem.getProduct().getCategory()+")"));
			System.out.println(billItem.getSerialNum()+"\t"+productDispName+"\t"+billItem.getQuantity()+"\t\t"+billItem.getProduct().getCost()+"\t"+billItem.getPrice()+"\t"+billItem.getProduct().getLevy()+"\t"+billItem.getTaxAmt()+"\t"+billItem.getAmount());
		}
		System.out.println("============================================================================================================");
		System.out.println("\t"+String.format("%-" + 30 + "." + 30 + "s","Total Payble")+"\t\t\t\t"+bill.getTotalPrice()+"\t\t"+bill.getTotalTax()+"\t"+bill.getAmountPayble());
		System.out.println("============================================================================================================\n\n");
	}

	private List<OrderItem> loadOrderItems() {
		List<OrderItem> items = new ArrayList<OrderItem>();
		items.add(new OrderItem(1L, 1, 2F));
		items.add(new OrderItem(2L, 2, 3F));
		items.add(new OrderItem(3L, 3, 4F));
		items.add(new OrderItem(4L, 4, 3F));
		items.add(new OrderItem(5L, 5, 5F));
		items.add(new OrderItem(6L, 6, 2F));
		items.add(new OrderItem(7L, 7, 1F));
		items.add(new OrderItem(8L, 8, 2F));
		items.add(new OrderItem(9L, 9, 3F));
		return items;
	}

}

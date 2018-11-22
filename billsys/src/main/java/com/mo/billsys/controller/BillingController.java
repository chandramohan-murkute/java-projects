package com.mo.billsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mo.billsys.core.services.BillingService;
import com.mo.billsys.dto.Bill;
import com.mo.billsys.dto.Customer;
import com.mo.billsys.dto.Order;


@RestController
@RequestMapping(value = "/bills")
public class BillingController {

	@Autowired
	private BillingService billingService;
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public Bill displayBill(Order order) {
		Bill bill =null;
		bill = billingService.calculateBill(order, order.getCustomer());
		return bill;
	}
}

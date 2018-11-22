package com.mo.billsys.core.services;

import com.mo.billsys.dto.Bill;
import com.mo.billsys.dto.Customer;
import com.mo.billsys.dto.Order;

public interface BillingService {
	public Bill calculateBill(Order order, Customer customer);
}

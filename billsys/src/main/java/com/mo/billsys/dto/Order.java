package com.mo.billsys.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Order {
	private Long orderId;
	private Customer customer;
	private List<OrderItem> items;
	
	public Order() {
	}
	
	public Order(Long orderId, List<OrderItem> items,Customer customer) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.customer = customer;
	}



	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}

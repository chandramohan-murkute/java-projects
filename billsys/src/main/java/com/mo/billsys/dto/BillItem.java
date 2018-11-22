package com.mo.billsys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class BillItem {
	private Long orderItemId;
	private Product product;
	private Float quantity;

	private Integer serialNum;
	private Float price;
	private Float taxAmt;
	private Float amount;
	
	
	
	public BillItem(Integer serialNum,Long orderItemId, Product product, Float quantity,
			 Float price, Float taxAmt, Float amount) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.quantity = quantity;
		this.serialNum = serialNum;
		this.price = price;
		this.taxAmt = taxAmt;
		this.amount = amount;
	}
	public Long getOrderItemId() {
		return orderItemId;
	}
	public Product getProduct() {
		return product;
	}
	public Float getQuantity() {
		return quantity;
	}
	public Integer getSerialNum() {
		return serialNum;
	}
	public Float getPrice() {
		return price;
	}
	public Float getTaxAmt() {
		return taxAmt;
	}
	public Float getAmount() {
		return amount;
	}
}

package com.mo.billsys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class OrderItem {
	private Long orderItemId;
	private Integer productId;
	private Float quantity;
	
	public OrderItem() {
	}
	
	public OrderItem(Long orderItemId, Integer productId, Float quantity) {
		super();
		this.orderItemId = orderItemId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
}

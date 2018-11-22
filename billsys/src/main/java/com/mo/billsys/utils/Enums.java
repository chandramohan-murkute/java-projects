package com.mo.billsys.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Enums {

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum ErrorCode {
		BILLING_INPUT_NULL(1001,"Customer or Order is null"),
		BILLING_INPUT_NULL_CUSTOMER(1002,"Customer name is null"),
		BILLING_INPUT_NULL_ORDERS(1003,"No OrderItems in Order"),
		BILLING_INPUT_INVALID_PRODUCTID(1004, "Invalid product id received in order item"),
		BILLING_INPUT_INVALID_QUANTITY(1005, "Invalid quantity received in order item");
		
		
		private Integer	id;
		private String	text;

		private ErrorCode(final Integer id, final String text) {
			this.id = id;
			this.text = text;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String name) {
			this.text = name;
		}
	}
}

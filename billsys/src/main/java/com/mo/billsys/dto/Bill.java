package com.mo.billsys.dto;

import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value = Include.NON_NULL)
public class Bill {
	private String billNumber;
	private Customer customer;
	private String date;
	private List<BillItem> billItems;
	private Float totalPrice;
	private Float totalTax;
	private Float amountPayble;
	
	public Bill(Customer customer, List<BillItem> billItems,Float totalPrice,Float totalTax,Float amountPayble) {
		this.date = formatDate(System.currentTimeMillis(), "dd-MMM-yyyy:HH-mm-ss", "Asia/Calcutta");
		this.billNumber = RandomStringUtils.random(12);
		this.customer = customer;
		this.billItems = billItems;
		this.totalPrice = totalPrice;
		this.totalTax = totalTax;
		this.amountPayble = amountPayble;
	}
	
	public static String formatDate(Long timeMillis, String format, String timeZone) {
		DateTime date = null;
		DateTimeZone dateTimeZone = DateTimeZone.UTC;
		if (timeZone != null) {
			TimeZone tz = TimeZone.getTimeZone(timeZone);
			dateTimeZone = DateTimeZone.forID(tz.getID());
		}
		if (timeMillis != null) {
			date = new DateTime(timeMillis, dateTimeZone);
		}
		DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(format);
		String result = dateFormatter.print(date);
		return result;
	}
	

	public String getBillNumber() {
		return billNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getDate() {
		return date;
	}

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public Float getTotalTax() {
		return totalTax;
	}

	public Float getAmountPayble() {
		return amountPayble;
	}
	
}

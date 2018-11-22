package com.mo.billsys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Product {
	private Integer	id;
	private String name;
	private	String category;
	private Float cost;
	private Float levy;
	public Product(Integer id, String name, String category, Float cost,Float levy) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.cost = cost;
		this.levy = levy;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public Float getCost() {
		return cost;
	}
	public Float getLevy() {
		return levy;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", category="
				+ category + ", cost=" + cost + ", levy=" + levy + "]";
	}
}
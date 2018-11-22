package com.mo.billsys.core.services;

import java.util.List;

import com.mo.billsys.dto.Product;

public interface ProductService {
	public List<Product> getProductList();
	public Product getProduct(Integer productId);
}

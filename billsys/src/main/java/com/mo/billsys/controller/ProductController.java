package com.mo.billsys.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mo.billsys.core.services.ProductService;
import com.mo.billsys.dto.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	private static final Logger		logger	= LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Product> listProducts() {
		List<Product> productList= productService.getProductList();
		return productList;
	}
}

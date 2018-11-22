package com.mo.billsys.web.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mo.billsys.controller.ProductController;
import com.mo.billsys.dto.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ProductControllerTest {
	private static final Logger		logger	= LoggerFactory.getLogger(ProductController.class);	
	
	@Autowired
	private ProductController productContoller;

	@Test
	public void testListProducts() {
		List<Product> productList = productContoller.listProducts();
		assertNotNull(productList);
		assertTrue(productList.size()>0);
		logger.info("Loaded products as : " + productList);
	}

}

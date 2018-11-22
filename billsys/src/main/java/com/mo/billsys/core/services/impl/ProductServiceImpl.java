package com.mo.billsys.core.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mo.billsys.core.services.ProductService;
import com.mo.billsys.dto.Product;
import com.mo.billsys.utils.Constants;
import com.mo.billsys.utils.PropertyUtil;

@Service
public class ProductServiceImpl implements ProductService {
	private final List<Product> productList = new ArrayList<>() ;
	private final Map<Integer,Product> productMap = new HashMap<>();
	
	@Override
	public List<Product> getProductList() {
		if(this.productList.size()==0){
			String strPropCategories = PropertyUtil.getProperty(Constants.PROP_PROD_CAT_LEVY);
			String[] arrPropCategories = strPropCategories.split(Constants.PROP_DELIMITER);
			
			for (String catLevy : arrPropCategories) {
				String[] propVals = catLevy.split(Constants.PROP_VAL_DELIMITER);
				String category = propVals[0];
				String tax = propVals[1];
				loadProducts(productList,category,tax);
			}
		}
		List<Product> copiedProductList = new ArrayList<>();
		copiedProductList.addAll(productList);
		return copiedProductList;
	}

	private void loadProducts(List<Product> productList, String category, String strTax) {
		String strProdNames = PropertyUtil.getProperty(Constants.PROP_PROD_NAMES+"."+category);
		String[] arrProducts = strProdNames.split(Constants.PROP_DELIMITER); 
		
		Product productDto = null;
		for (String strProduct : arrProducts) {
			String[] productDetail=strProduct.split(Constants.PROP_VAL_DELIMITER);
			Integer productId = Integer.valueOf(productDetail[0]);
			String productName = productDetail[1];
			Float productCost = Float.valueOf(productDetail[2]);
			Float productTax = Float.valueOf(strTax);
			
			productDto = new Product(productId, productName, category, productCost, productTax);
			productList.add(productDto);
			productMap.put(productId,productDto);
		}
	}

	@Override
	public Product getProduct(Integer productId) {
		if(this.productMap.size()==0){
			getProductList();
		}
		return productMap.get(productId);
	}
}

package com.mo.billsys.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.mo.billsys.core.services.ProductService;
import com.mo.billsys.dto.Customer;
import com.mo.billsys.dto.Order;
import com.mo.billsys.dto.OrderItem;
import com.mo.billsys.exceptions.BadRequestException;
import com.mo.billsys.utils.Enums.ErrorCode;


@Aspect
public class ValidatorAspect {
	private static final Logger	logger	= LoggerFactory.getLogger(ValidatorAspect.class);

	@Autowired
	private ProductService productService;

	@Before("execution( * com.mo.billsys.controller.displayBill(..))")
	public void validateDisplayBill(JoinPoint jp) {
		logger.debug("Validating Create Folder");
		if (jp.getArgs() != null && jp.getArgs().length > 0) {
			logger.debug("arguments" + jp.getArgs()[1]);
			Order order = (Order) jp.getArgs()[1];
			Customer customer = (Customer) order.getCustomer();
			
			if(customer==null || order==null){
				throw new BadRequestException(ErrorCode.BILLING_INPUT_NULL);
			}
			if(customer.getCustomerName()==null||customer.getCustomerName().isEmpty()){
				throw new BadRequestException(ErrorCode.BILLING_INPUT_NULL_CUSTOMER);
			}
			if(order.getItems()==null||order.getItems().size()==0){
				throw new BadRequestException(ErrorCode.BILLING_INPUT_NULL_ORDERS);
			}
			List<OrderItem> items = order.getItems();
			for (OrderItem orderItem : items) {
				if(orderItem.getProductId()==null||orderItem.getProductId()<0 || productService.getProduct(orderItem.getProductId())==null){
					throw new BadRequestException(ErrorCode.BILLING_INPUT_INVALID_PRODUCTID);
				}
				if(orderItem.getQuantity()==null||orderItem.getQuantity()<0){
					throw new BadRequestException(ErrorCode.BILLING_INPUT_INVALID_QUANTITY);
				}
			}
			
		}
	}

}

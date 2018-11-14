package com.bol.pageObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BolPageObjectFactory {

	@Autowired
	private ApplicationContext appContext;

	/**
	 * @return
	 */
	public BolLoginPage getBolLoginPage() {
		return (BolLoginPage) appContext.getBean("bolLoginPage");
	}

	/**
	 * @return
	 */
	public ProductPage getProductPage() {
		return (ProductPage) appContext.getBean("productPage");
	}
	/**
	 * @return
	 */
	public ShoppingCartPage getShoppingCartPage() {
		return (ShoppingCartPage) appContext.getBean("shoppingCartPage");
	}

}

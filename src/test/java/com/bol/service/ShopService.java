package com.bol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bol.pageObject.HomePage;
import com.bol.pageObject.ProductPage;
import com.bol.pageObject.TopNavigationPage;
import com.oc.pageObject.LoginPage;
import com.oc.pageObject.ResetPasswordPage;

/**
 * 
 * @author Jim Bonica
 *
 *         Nov 14, 2018
 */
@Service
public class ShopService {

	@Autowired
	HomePage homePage;

	@Autowired
	TopNavigationPage topNavigationPage;

	@Autowired
	ProductPage productPage;

	public void searchForItemInTopSearchField(String searchTerm) {
		homePage.navigateToWebApp();
		topNavigationPage.enterSearchTermInSearchField(searchTerm).clickEnterSearchButton();
	}

	/**
	 * 
	 */
	public void addItemToShoppingCart() {
		productPage.clickBuyButton();
	}

	/**
	 * @param quantity
	 */
	public void changeQuantityOfItemOnProductPpage(Integer quantity) {
		
		productPage.selectQuantity(quantity.toString());
						
	}

}

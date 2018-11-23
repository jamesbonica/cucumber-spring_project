package com.bol.pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oc.pageObject.AbstractPage;
import com.oc.pageObject.PageObjectFactory;

@Component
public class ProductPage extends AbstractPage {

	@Autowired
	EventFiringWebDriver driver;

	@Autowired
	BolPageObjectFactory bolPageObjectFactory;

	@FindBy(xpath="//div[@class='h-bottom--xs']/descendant::a[contains(@class, 'js_floating_basket_btn') and @data-button-type ='add_to_basket']")
	private WebElement buyButton;
	
	@FindBy(xpath="//div[contains(@class, 'basket-popup js_narrow_modal_window')]/p[@data-test='add-to-card-closeness']")
	private WebElement shoppingCartFreeDeliveryAlert;
	
	@FindBy(xpath="//select[@name='quantity']")
	private WebElement quantityDropdown;
	
	public ProductPage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage clickBuyButton() {
		waitForElement(buyButton);
	//	pause(5);
		buyButton.click();
		return this;
	}
	
	public String getShoppingCartFreeDeliveryAlert() {
		waitForElement(shoppingCartFreeDeliveryAlert);
		return shoppingCartFreeDeliveryAlert.getText().trim();
	}

	/**
	 * @param string
	 */
	public ProductPage selectQuantity(String string) {
		waitForElement(quantityDropdown);
		Select quantitySelect = new Select(quantityDropdown);
		List<WebElement> options = quantitySelect.getOptions();
		quantityDropdown.click();
		pause(.5);
		for(WebElement element: options) {
			if(element.getText().trim().equals(string)) {
				element.click();
				break;
			}
		}
	//	quantityDropdown.click();
		return this;
		
	}
	
	

}

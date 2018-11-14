package com.bol.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oc.pageObject.AbstractPage;

@Component
public class BolLoginPage extends AbstractPage {

	@Autowired
	EventFiringWebDriver driver;
	
	@FindBy(xpath="//input[@id='login_email']")
	private WebElement emailAddressField;

	@FindBy(xpath="//input[@id='login_password']")
	private WebElement passwordField;
	
	public BolLoginPage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public BolLoginPage enterEmailAddress(String email) {
		waitForElement(emailAddressField);
		emailAddressField.sendKeys(email);
		return this;
	}
	
	public BolLoginPage enterPassword(String password) {
		waitForElement(passwordField);
		passwordField.sendKeys(password);
		return this;
	}

	
}

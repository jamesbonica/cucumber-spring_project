package com.bol.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oc.pageObject.AbstractPage;

@Component
public class TopNavigationPage extends AbstractPage {

	@Autowired
	EventFiringWebDriver driver;
	
	@Autowired
	BolPageObjectFactory bolPageObjectFactory;

	@FindBy(xpath="//a[contains(@class, 'account-dropdown__link--login')]")
	private WebElement accountLoginLink;
	
	@FindBy(xpath="//input[@id='searchfor']")
	private WebElement searchField;
	
	@FindBy(xpath="//*[@data-test='search-button']")
	private WebElement enterSearchButton;

	public TopNavigationPage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public BolLoginPage clickAccountLogin() {
		waitForElement(accountLoginLink);
		accountLoginLink.click();
		return bolPageObjectFactory.getBolLoginPage() ;
	}
	
	public TopNavigationPage enterSearchTermInSearchField(String searchTerm) {
		waitForElement(searchField);
		searchField.sendKeys(searchTerm);
		return this;
	}
	
	public ProductPage clickEnterSearchButton() {
		waitForElement(enterSearchButton);
		enterSearchButton.click();
		return bolPageObjectFactory.getProductPage();
	}

}

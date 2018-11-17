package com.bol.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oc.pageObject.AbstractPage;
import com.oc.pageObject.PageObjectFactory;

/**
 * 
 * @author Jim Bonica
 *
 *         Nov 15, 2018
 */
@Component
public class DrugsAssociatedWithMechanismPage extends AbstractPage {

	@Autowired
	EventFiringWebDriver driver;

	@Autowired
	PageObjectFactory pageObjectFactory;

	@FindBy(xpath = "//...")
	private WebElement pageHeader;

	public DrugsAssociatedWithMechanismPage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageHeaderText() {
		waitForElement(pageHeader);
		return pageHeader.getText().trim();
	}
}

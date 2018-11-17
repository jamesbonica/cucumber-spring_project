package com.bol.pageObject;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oc.pageObject.AbstractPage;

/**
 * 
 * @author Jim Bonica
 *
 *         Nov 15, 2018
 */
@Component
public class DrugSearchPage extends AbstractPage {

	@Autowired
	EventFiringWebDriver driver;

	@Autowired
	GSPageObjectFactory gSPageObjectFactory;

	@FindBy(xpath = "//...")
	private WebElement searchField;

	@FindBy(xpath = "//...")
	private WebElement searchButton;

	// extended locator as a secondary confirmation the label is part of the larger
	// element that includes suggested drugs list
	@FindBy(xpath = "//.../")
	private WebElement suggestedDrugsLabel;

	@FindAll(@FindBy(xpath = "//..."))
	private List<WebElement> suggestedDrugsListElements;

	// extended locator as a secondary confirmation the label is part of the larger
	// element that includes suggested mechanisms list
	@FindBy(xpath = "//.../")
	private WebElement suggestedMechanismsLabel;

	@FindAll(@FindBy(xpath = "//..."))
	private List<WebElement> suggestedMechanismsListElements;

	public DrugSearchPage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public DrugSearchPage enterSearchTerm(String searchTerm) {
		waitForElement(searchField);
		searchField.sendKeys(searchTerm);
		return this;
	}

	public DrugSearchPage clickSearchButton() {
		waitForElement(searchButton);
		searchButton.click();
		return this;
	}

	public List<String> getSuggestedDrugs() {
		LinkedList<String> suggestedDrugList = new LinkedList<String>();

		for (WebElement element : suggestedDrugsListElements) {
			suggestedDrugList.add(element.getText().trim());
		}

		return suggestedDrugList;
	}

	public List<String> getSuggestedMechanisms() {
		LinkedList<String> suggestedMechanismsList = new LinkedList<String>();

		for (WebElement element : suggestedMechanismsListElements) {
			suggestedMechanismsList.add(element.getText().trim());
		}

		return suggestedMechanismsList;
	}

	public String getSuggestedDrugsHeaderText() {
		waitForElement(suggestedDrugsLabel);
		return suggestedDrugsLabel.getText().trim();
	}

	public String getSuggestedMechanismsHeaderText() {
		waitForElement(suggestedMechanismsLabel);
		return suggestedMechanismsLabel.getText().trim();
	}

	public DrugDetailsPage clickSuggestedDrugToGetDrugDetails(String drug) {
		for (WebElement element : suggestedDrugsListElements) {
			if (element.getText().trim().equals(drug)) {
				element.click();
				break;
			}
		}

		return gSPageObjectFactory.getDrugDetailsPage();
	}
	
	public DrugsAssociatedWithMechanismPage clickSuggestedMechanism(String mechanism) {
		for (WebElement element : suggestedMechanismsListElements) {
			if (element.getText().trim().equals(mechanism)) {
				element.click();
				break;
			}
		}

		return gSPageObjectFactory.getDrugsAssociatedWithMechanismPage();
	}

}

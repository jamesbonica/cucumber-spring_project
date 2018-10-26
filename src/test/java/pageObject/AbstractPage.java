package pageObject;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import config.PropertiesLoader;

public class AbstractPage {

	@Autowired
	EventFiringWebDriver driver;
	
	@Autowired
	PropertiesLoader propertiesLoader;

	public AbstractPage navigateToWebApp() {
		driver.navigate().to(propertiesLoader.getOcUrl());
		return this;
	}

	public AbstractPage pause(double d) {
		try {
			Thread.sleep((long) (d * 1000));
		} catch (InterruptedException e) {
		}
		return this;
	}

	public AbstractPage waitForElement(WebElement element) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.elementToBeClickable(element));
			} catch(TimeoutException t) {
			System.out.println("element not found");
		}
		return this;
	}

}

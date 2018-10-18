package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends AbstractPage {
	
	@Autowired
	EventFiringWebDriver driver;

	@FindBy(xpath = "//input[@id = 'username']")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@id='j_password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='loginbutton' and @name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='alertbox_center']")
	private WebElement loginError;
	
	public LoginPage(EventFiringWebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUsername(String s) {
		waitForElement(usernameField);
		usernameField.sendKeys(s);
		
		return this;
	}
	
	public LoginPage enterPassword(String s) {
		waitForElement(passwordField);
		passwordField.sendKeys(s);
		return this;
	}

	public void clickLoginButton() {
		waitForElement(submitButton);
		submitButton.click();		
	}
	
	public String getLoginErrorMessage() {
		return loginError.getText().trim();
	}

}

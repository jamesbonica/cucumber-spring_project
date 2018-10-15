package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id = 'username']")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@id='j_password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@class='loginbutton' and @name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='alertbox_center']")
	private WebElement loginError;
	
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

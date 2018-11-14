package com.oc.pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordPage extends AbstractPage {

	@Autowired
	EventFiringWebDriver driver;

	@Autowired
	PageObjectFactory pageObjectFactory;

	@FindBy(xpath = "//input[@name = 'oldPasswd']")
	private WebElement oldPasswordField;

	@FindBy(xpath = "//input[@name='passwd']")
	private WebElement newPasswordField;

	@FindBy(xpath = "//input[@name='passwd1']")
	private WebElement confirmNewPasswordField;

	@FindBy(xpath = "//select[@name = 'passwdChallengeQ']")
	private WebElement passwordChallengeQuestionSelect;

	@FindBy(xpath = "//input[@name='passwdChallengeA']")
	private WebElement passwordChallengeAnswerField;

	@FindBy(xpath = "//input[@class='button_xlong' and @name='submit']")
	private WebElement submitButton;

	public ResetPasswordPage(EventFiringWebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ResetPasswordPage enterOldPassword(String s) {
		waitForElement(oldPasswordField);
		oldPasswordField.sendKeys(s);
		return this;
	}

	public ResetPasswordPage enterNewPassword(String s) {
		waitForElement(newPasswordField);
		newPasswordField.sendKeys(s);
		return this;
	}

	public ResetPasswordPage enterConfirmNewPassword(String s) {
		waitForElement(confirmNewPasswordField);
		confirmNewPasswordField.sendKeys(s);
		return this;
	}

	public ResetPasswordPage selectPasswordChallengeQuestion() {
		waitForElement(passwordChallengeQuestionSelect);
		Select select = new Select(passwordChallengeQuestionSelect);
		List<WebElement> option = select.getOptions();

		for (WebElement element : option) {
			if (element.getText().trim().contains("Favorite Animal")) {
				element.click();
				break;
			}
		}

		return this;
	}

	public ResetPasswordPage enterpPsswordChallengeAnswer() {
		waitForElement(passwordChallengeAnswerField);
		passwordChallengeAnswerField.sendKeys("gireffe");
		return this;
	}

	public void clickChangePasswordButton() {
		waitForElement(submitButton);
		submitButton.click();
	}

}

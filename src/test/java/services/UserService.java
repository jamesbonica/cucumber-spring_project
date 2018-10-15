package services;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObject.LoginPage;

public class UserService {
	
	public void loginToOcApp(String username, String password, WebDriver webDriver) {
		LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		loginPage.enterUsername(username).enterPassword(password); 
		loginPage.clickLoginButton();	
		
	}
	
	
}

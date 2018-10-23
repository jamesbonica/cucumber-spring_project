package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pageObject.LoginPage;

/**
 * 
 * @author Jim Bonica
 *
 *         Oct 22, 2018
 */
@Service
public class UserService {

	@Autowired
	LoginPage loginPage;

	public void loginToOcApp(String username, String password) {
		loginPage.navigateToWebApp();

		loginPage.enterUsername(username).enterPassword(password);
		loginPage.clickLoginButton();

	}

}

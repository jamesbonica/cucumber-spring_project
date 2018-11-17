package com.bol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bol.pageObject.HomePage;
import com.bol.pageObject.TopNavigationPage;
import com.oc.pageObject.LoginPage;
import com.oc.pageObject.ResetPasswordPage;

/**
 * 
 * @author Jim Bonica
 *
 *         Nov 14, 2018
 */
@Service
public class AccountService {

	@Autowired
	HomePage homePage;

	@Autowired
	TopNavigationPage topNavigationPage;

	public void loginToExistingAccount() {
		homePage.navigateToWebApp();
		topNavigationPage.clickAccountLogin().enterEmailAddress("jamesbonica@gmail.com").enterPassword("Cucumber#1");

	}

}

package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
public class HelperService {

	@Autowired
	LoginPage loginPage;

	public void loginToOcApp(String username, String password) {
		loginPage.navigateToWebApp();

		loginPage.enterUsername(username).enterPassword(password);
		loginPage.clickLoginButton();

	}

	public String getStudyDate(String date) {
		String formattedDate = null;

		if (date.contains("+")) {

		} else if (date.contains("-")) {

		} else {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			formattedDate = now.format(formatter);
		}
		return formattedDate;
	}

}

package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.pageObject.LoginPage;
import com.oc.pageObject.ResetPasswordPage;

/**
 * 
 * @author Jim Bonica
 *
 *         Oct 22, 2018
 */
@Service
public class LoginService {

	@Autowired
	LoginPage loginPage;

	@Autowired
	ResetPasswordPage resetPasswordPage;

	public void loginToOcApp(String username, String password) {
		loginPage.navigateToWebApp();

		loginPage.enterUsername(username).enterPassword(password);

		loginPage.clickLoginButton();

	}

	/**
	 * @param tempPassword
	 * @param newPassword
	 */
	public void setNewPassword(String tempPassword, String newPassword) {
		resetPasswordPage.enterOldPassword(tempPassword).enterNewPassword(newPassword)
				.enterConfirmNewPassword(newPassword).selectPasswordChallengeQuestion().enterpPsswordChallengeAnswer()
				.clickChangePasswordButton();

	}

}

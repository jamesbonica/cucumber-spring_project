package services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.pageObject.LoginPage;
import com.oc.pageObject.MenuPage;

import static constants.Constants.STANDARD_PASSWORD;

import dto.UserDTO;

@Service
public class UserService {

	@Autowired
	MenuPage menuPage;

	@Autowired
	ApiService apiService;

	@Autowired
	LoginService loginService;

	public void initializeRootUser() {
		// TODO Auto-generated method stub

	}

	public void createUserViaApiAndSetPassword(String user, String password, UserDTO userDTO) {
		String tempPassword = null;

		HashMap<String, Object> createUserViaApiResultsMap = apiService.createUser(user, password, userDTO);

		Integer httpResponse = (Integer) createUserViaApiResultsMap.get("httpResponse");

		if (httpResponse == 200) {
			tempPassword = (String) createUserViaApiResultsMap.get("tempPassword");
			loginService.loginToOcApp(userDTO.getUsername(), tempPassword);
			loginService.setNewPassword(tempPassword, STANDARD_PASSWORD);
			menuPage.clickLogOutLink();
		}

	}

}

package steps;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import config.CrossScenarioCache;
import config.ScenarioSession;
import cucumber.api.java.en.Given;
import dto.UserDTO;
import pageObject.LoginPage;
import services.ApiService;
import services.UserService;

import static constants.Constants.STANDARD_PASSWORD;

import java.util.List;

@Scope("cucumber-glue")
public class ApiSteps {

	@Autowired
	LoginPage loginPage;

	@Autowired
	ScenarioSession scenarioSession;

	@Autowired
	CrossScenarioCache crossScenarioCache;

	@Autowired
	ApiService apiService;

	@Autowired
	UserService userService;

	@Given("^the OC Root User generates an API Key$")
	public void the_OC_root_user_is_initialized() throws Exception {
		userService.initializeRootUser();
	}

	@Given("^the OC Root User creates a study via REST API$")
	public void the_OC_Root_User_creates_a_study_via_REST_API() throws Exception {
		apiService.createStudy("root", STANDARD_PASSWORD, crossScenarioCache.getMainStudy());
	}

	@Given("^the OC Root User creates the following users via REST API$")
	public void the_OC_Root_User_creates_the_following_users_via_REST_API(List<UserDTO> userList) throws Exception {
		for (UserDTO user : userList) {
			userService.createUserViaApiAndSetPassword("root", STANDARD_PASSWORD, user);
		}
	}
}

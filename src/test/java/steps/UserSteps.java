package steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import config.ScenarioSession;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LoginPage;
import services.UserService;

@Scope("cucumber-glue")
public class UserSteps {

	@Autowired
	UserService userService;

	@Autowired
	LoginPage loginPage;
	
	@Autowired
	ScenarioSession scenarioSession;

	@When("^a user attempts to login using username \"([^\"]*)\"  with password \"([^\"]*)\"$")
	public void a_user_attempts_to_login_using_username_with_password(String username, String password)
			throws Exception {
		userService.loginToOcApp(username, password);
	
	}

	@Then("^OC must return the error message$")
	public void oc_must_return_the_error_message(String errorMessage) throws Exception {
		assertThat(loginPage.getLoginErrorMessage()).isEqualTo(errorMessage);
		scenarioSession.takeScreenShot();
		scenarioSession.writeToReport("This has been productive!!!!!!");
		
	
	}

}

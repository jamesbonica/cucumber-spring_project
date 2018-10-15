package steps;

import static org.assertj.core.api.Assertions.assertThat;


import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LoginPage;
import services.UserService;

public class UserSteps extends AbstractStepDefinitions {
	

	@When("^a user attempts to login using username \"([^\"]*)\"  with password \"([^\"]*)\"$")
	public void a_user_attempts_to_login_using_username_with_password(String username, String password)
			throws Exception {
		UserService userService = new UserService();
		userService.loginToOcApp(username, password, getDriver());
	}

	@Then("^OC must return the error message$")
	public void oc_must_return_the_error_message(String errorMessage) throws Exception {
		LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
		assertThat(loginPage.getLoginErrorMessage()).isEqualTo(errorMessage);
		Hooks hooks = new Hooks();
		hooks.takeScreenshot();
		hooks.writeToReport("This is the end.....");
	}

}

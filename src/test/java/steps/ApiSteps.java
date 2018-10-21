package steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import config.CrossScenarioCache;
import config.ScenarioSession;
import cucumber.api.java.en.Given;
import pageObject.LoginPage;
import services.ApiService;
import services.UserService;

@Scope("cucumber-glue")
public class ApiSteps {

	@Autowired
	UserService userService;

	@Autowired
	LoginPage loginPage;

	@Autowired
	ScenarioSession scenarioSession;

	@Autowired
	CrossScenarioCache crossScenarioCache;

	@Autowired
	ApiService apiService;

	@Given("^the OC root user is initialized$")
	public void the_OC_root_user_is_initialized() throws Exception {

	}

	@Given("^the OC root user retrieve the API Key via an API$")
	public void the_OC_root_user_retrieve_her_API_Key_via_an_API() throws Exception {
		apiService.getApiKey("root");
	}

	@Given("^the OC root user creates a study via an API$")
	public void the_OC_root_user_creates_a_study_via_an_API() throws Exception {

	}

}

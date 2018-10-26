package steps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import config.CrossScenarioCache;
import config.ScenarioSession;
import cucumber.api.java.en.Given;
import domain.Study;
import pageObject.LoginPage;
import services.LoginService;

@Scope("cucumber-glue")
public class StudySteps {

	@Autowired
	LoginService userService;

	@Autowired
	LoginPage loginPage;
	
	@Autowired
	ScenarioSession scenarioSession;
	
	@Autowired
	CrossScenarioCache crossScenarioCache;

	@Given("^there is a study that uses the following variables:$")
	public void there_is_a_study_that_uses_the_following_variables(List<Study> studies) throws Exception {
		for(Study study: studies) {
			Study mainStudy = new Study(study.getStudyId(), study.getStudyName(), study.getStudyManager(), study.getStudyOid());
			crossScenarioCache.setMainStudy(mainStudy);
		}
	}

}

package steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.oc.pageObject.LoginPage;

import config.CrossScenarioCache;
import config.ScenarioSession;
import cucumber.api.java.en.Given;
import domain.Study;
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
		for (Study study : studies) {
			Study mainStudy = new Study(study.getStudyId(), study.getStudyName(), study.getStudyManager(),
					study.getStudyOid());
			crossScenarioCache.setMainStudy(mainStudy);
		}
	}

	@Given("^I have this thing I need to do$")
	public void i_have_this_thing_I_need_to_do() throws Exception {
		List<Integer> numbers = new LinkedList<Integer>(Arrays.asList(3,1,1,2, 2, 1, 3, 4, 1, 4));
		List<Integer> numbers2 = new LinkedList<Integer>(numbers);
		int duplicates = 0;
		for (Integer number : numbers) {
			if ((Collections.frequency(numbers2, number) > 1)) {
				duplicates++;
			}
			// remove all occurrences of that number from numbers2
			numbers2.removeAll(Collections.singleton(number));

		}

		System.out.println("duplicates = " + duplicates);
	}

}

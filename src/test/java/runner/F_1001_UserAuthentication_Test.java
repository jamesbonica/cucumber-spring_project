package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@Initialize or @Scenario=1"},
		plugin = { "pretty", "html:target/html/1001_User_Authentication/", 
				"json:target/json/1001_User_Authentication.json" }, 
		features = {"src/test/resources/cucumber/1001_User_Authentication.feature" }, 
		glue = {"steps" }, 
		monochrome = true)
public class F_1001_UserAuthentication_Test {

}

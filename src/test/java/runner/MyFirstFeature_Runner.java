package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:target/html/User_Authentication/", 
				"json:target/json/User_Authentication.json" }, 
		features = {"src/test/resources/cucumber/user_authentication.feature" }, 
		glue = {"steps" }, 
		monochrome = true)
public class MyFirstFeature_Runner {

}

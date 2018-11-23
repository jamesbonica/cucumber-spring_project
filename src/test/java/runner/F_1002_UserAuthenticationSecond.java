package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@Initialize or @OC-1001"},
		plugin = { "pretty", "html:target/html/1002_User_Authentication_Second/", 
				"json:target/json/1002_User_Authentication_Second.json" }, 
		features = {"src/test/resources/cucumber/1002_User_Authentication_Second.feature" }, 
		glue = {"steps" }, 
		monochrome = true)
public class F_1002_UserAuthenticationSecond {

}

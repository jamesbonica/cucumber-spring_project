package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	//	tags = {"@Initialize or @OC-1001"},
		plugin = { "pretty", "html:target/html/Jenkins", 
				"json:target/json/Jenkins.json" }, 
		features = {"src/test/resources/cucumber/Jenkins.feature" }, 
		glue = {"steps", "com.bol.steps" }, 
		monochrome = true)
public class F_1004_Jenkins {

}

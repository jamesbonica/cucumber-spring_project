package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@Over_EURO_20"},
		plugin = { "pretty", "html:target/html/1001_EURO_20_for_Free_Delivery/", 
				"json:target/json/1001_EURO_20_for_Free_Delivery.json" }, 
		features = {"src/test/resources/cucumber/1001_EURO_20_for_Free_Delivery.feature" }, 
		glue = {"steps", "com.bol.steps" }, 
		monochrome = true)
public class F_1001_Euro20ForFreeDelivery_Assessment_Test {

}

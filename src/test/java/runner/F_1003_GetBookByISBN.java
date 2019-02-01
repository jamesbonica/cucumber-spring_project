package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	//	tags = {"@Initialize or @OC-1001"},
		plugin = { "pretty", "html:target/html/1003_Get_Book_by_ISBN", 
				"json:target/json/1003_Get_Book_by_ISBN.json" }, 
		features = {"src/test/resources/cucumber/1003_Get_Book_by_ISBN.feature" }, 
		glue = {"steps", "com.bol.steps" }, 
		monochrome = true)
public class F_1003_GetBookByISBN {

}

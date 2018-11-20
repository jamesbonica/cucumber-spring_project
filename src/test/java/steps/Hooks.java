package steps;

import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import com.oc.pageObject.LoginPage;

import config.PropertiesLoader;
import config.ScenarioSession;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * @author Jim Bonica
 *
 *         Oct 22, 2018
 */

@Scope("cucumber-glue")
public class Hooks {

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	PropertiesLoader propertiesLoader;

	@Autowired
	EventFiringWebDriver driver;

	@Autowired
	LoginPage loginPage;

	@Autowired
	ScenarioSession scenarioSession;

	@Before
	public void setUp(Scenario scenario) {
		scenarioSession.setScenario(scenario);
		driver.manage().deleteAllCookies();
		System.out.println("In before hook");
		String[] beans = appContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		// for (String bean : beans) {
		// System.out.println(bean);
		// }
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // stick it in the report
		}
		 
	}
	
	@After("@End_Feature_File")
	public void closeOut() {
		driver.quit();
	}

}

package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import config.ScenarioSession;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageObject.LoginPage;

public class Hooks extends AbstractStepDefinitions {

	WebDriver driver = getDriver();
	public static Scenario scenario;
	ScenarioSession scenarioSession;
	
	@Before
	public void setUp(Scenario scenario) {
		Hooks.scenario = scenario;
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToWebApp();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // stick it in the report
		}
		driver.quit();
	}
	
	public void takeScreenshot() {
	//	System.out.println("TEST " + scenario); System.exit(0);
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); // stick it in the report
	}
	
	public void writeToReport(String s) {
		scenario.write(s);
	}

}

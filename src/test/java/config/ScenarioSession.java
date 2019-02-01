package config;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import cucumber.api.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Configuration
@Scope("cucumber-glue")
public class ScenarioSession {

	@Autowired
	EventFiringWebDriver driver;
	
	private Scenario scenario;
	
	private RequestSpecification request;
	
	private Response response;
	
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	public Scenario getScenario() {
		return scenario;
	}
	
	public RequestSpecification getRequest() {
		return request;
	}

	public void setRequest(RequestSpecification request) {
		this.request = request;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public void takeScreenShot() {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); // stick it in the report

	}
	
	public void writeToReport(String s) {
		scenario.write(s);
	}

}

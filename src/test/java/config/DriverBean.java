package config;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import config.PropertiesLoader;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class DriverBean {

	@Autowired
	PropertiesLoader propertiesLoader;

	@Bean(name = "driver")
	// @Scope("cucumber-glue")
	public EventFiringWebDriver getEventFiringWebDriver() throws Exception {
		System.out.println("In driver method");
		String sauceName = "";
		EventFiringWebDriver eventFiringWebDriver = null;
		WebDriver driver = null;
		String browser = propertiesLoader.getBrowser().toLowerCase();
		String testEnvironment = propertiesLoader.getTestEnvironment().toLowerCase();

		ChromeOptions chromeOptions = new ChromeOptions();
		FirefoxOptions firefoxOptions = new FirefoxOptions();

		DesiredCapabilities desiredCapbilities = null;

		switch (testEnvironment) {
		case "local":
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
				driver = new FirefoxDriver(firefoxOptions);
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				// chromeOptions.
				driver = new ChromeDriver(chromeOptions);

				break;
			case "edge":
				System.out.println("Edge Driver....");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}
			break;
		case "sauce":
			switch (browser) {
			case "firefox":
				sauceName = "firefox test";
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("security.insecure_field_warning.contextual.enabled", false);
				desiredCapbilities = DesiredCapabilities.firefox();
				desiredCapbilities.setCapability(FirefoxDriver.PROFILE, profile);
				break;
			case "chrome":

				break;
			case "edge":

				break;
			}
			desiredCapbilities.setCapability("platform", "Windows 10");
		//	desiredCapbilities.setCapability("version", "63.0");
			desiredCapbilities.setCapability("recordVideo", "true");
			desiredCapbilities.setCapability("screenResolution", "1920x1080");
			desiredCapbilities.setCapability("name", sauceName);
			driver = new RemoteWebDriver(new URL(
					"https://jamesbonica:94d9e25b-9fee-4982-a3fa-fe8b1246ed44@ondemand.saucelabs.com:443/wd/hub"),
					desiredCapbilities);
			break;
		}

		if (driver == null) {
			throw new Exception("Invalid driver entry in properties file");
		}
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		Capabilities caps = eventFiringWebDriver.getCapabilities();
		System.out.println("Browser + version: " + caps.getBrowserName() + " " + caps.getVersion());
		return eventFiringWebDriver;
	}

}

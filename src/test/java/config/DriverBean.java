package config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class DriverBean {

	@Autowired
	PropertiesLoader propertiesLoader;

	@Bean(name = "driver")
	// @Scope("cucumber-glue")
	public EventFiringWebDriver getEventFiringWebDriver() throws Exception {
		System.out.println("In driver method");
		EventFiringWebDriver evetFiringWebDriver;
		WebDriver driver = null;
		String browser = propertiesLoader.getBrowser().toLowerCase();
		String testEnvironment = propertiesLoader.getTestEnvironment().toLowerCase();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		FirefoxOptions firefoxOptions = new FirefoxOptions();

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
			//	chromeOptions.
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

				break;
			case "chrome":

				break;
			case "edge":

				break;
			}
			break;
		}

		if (driver == null) {
			throw new Exception("Invalid driver entry in properties file");
		}
		
		evetFiringWebDriver = new EventFiringWebDriver(driver);
		Capabilities caps = evetFiringWebDriver.getCapabilities();
		System.out.println("Browser + version: "  + caps.getBrowserName() + " " + caps.getVersion());
		return evetFiringWebDriver;
	}

}

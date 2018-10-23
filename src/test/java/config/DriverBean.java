package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

		switch (testEnvironment) {
		case "local":
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
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
		return evetFiringWebDriver;
	}

}

package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.github.bonigarcia.wdm.WebDriverManager;

@Component
public class DriverBean {
	
	@Bean(name = "driver")
	public EventFiringWebDriver getEventFiringWebDriver() {
		EventFiringWebDriver evetFiringWebDriver;		
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		driver = new FirefoxDriver();
		
		evetFiringWebDriver = new EventFiringWebDriver(driver);
		return evetFiringWebDriver;
	}

}

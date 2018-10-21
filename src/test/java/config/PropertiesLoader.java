package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class PropertiesLoader {

	@Value("${oc.url}")
	private String ocUrl;
	
	@Value("${test.environment}")
	private String testEnvironment;
	
	@Value("${test.browser}")
	private String browser;

	public String getOcUrl() {
		return ocUrl;
	}

	public void setOcUrl(String ocUrl) {
		this.ocUrl = ocUrl;
	}

	public String getTestEnvironment() {
		return testEnvironment;
	}

	public void setTestEnvironment(String testEnvironment) {
		this.testEnvironment = testEnvironment;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

}

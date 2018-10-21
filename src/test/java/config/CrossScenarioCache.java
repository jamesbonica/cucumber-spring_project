package config;

import org.springframework.context.annotation.Configuration;

import domain.Study;

@Configuration
public class CrossScenarioCache {

	private Study mainStudy;
	private String rootApiKey;

	public Study getMainStudy() {
		return mainStudy;
	}

	public void setMainStudy(Study mainStudy) {
		this.mainStudy = mainStudy;
	}

	public String getRootApiKey() {
		return rootApiKey;
	}

	public void setRootApiKey(String rootApiKey) {
		this.rootApiKey = rootApiKey;
	}

}

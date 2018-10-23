package config;

import org.springframework.context.annotation.Configuration;

import domain.Study;

/**
 * 
 * @author Jim Bonica
 *
 * Oct 22, 2018
 */
@Configuration
public class CrossScenarioCache {

	private Study mainStudy;

	public Study getMainStudy() {
		return mainStudy;
	}

	public void setMainStudy(Study mainStudy) {
		this.mainStudy = mainStudy;
	}
	
}

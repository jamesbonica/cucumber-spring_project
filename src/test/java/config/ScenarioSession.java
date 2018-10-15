package config;

import cucumber.api.Scenario;

public class ScenarioSession {
	
	private Scenario scenario;
	
	public ScenarioSession(Scenario scenario){
		this.scenario = scenario;
		
	}
	
	public Scenario getScenario() {
		return this.scenario;
	}

}

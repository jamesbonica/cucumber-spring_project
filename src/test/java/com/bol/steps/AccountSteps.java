package com.bol.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.bol.service.AccountService;
import com.oc.pageObject.LoginPage;

import config.CrossScenarioCache;
import config.ScenarioSession;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import services.LoginService;

/**
 * 
 * @author Jim Bonica
 *
 *         Nov 14, 2018
 */
@Scope("cucumber-glue")
public class AccountSteps {

	@Autowired
	LoginPage loginPage;

	@Autowired
	ScenarioSession scenarioSession;

	@Autowired
	AccountService accountService;

	@When("^shopper James enters the correct email address and password$")
	public void shopper_James_enters_the_correct_email_address_and_password() throws Exception {
		accountService.loginToExistingAccount();
	}

}

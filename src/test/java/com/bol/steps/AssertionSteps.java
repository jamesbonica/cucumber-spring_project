package com.bol.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.bol.pageObject.ProductPage;
import com.bol.service.ShopService;

import config.ScenarioSession;
import cucumber.api.java.en.Then;

/**
 * 
 * @author Jim Bonica
 *
 *         Nov 14, 2018
 */
@Scope("cucumber-glue")
public class AssertionSteps {

	@Autowired
	ProductPage productPage;

	@Autowired
	ShopService shopService;
	
	@Autowired
	ScenarioSession scenarioSession;

	@Then("^the system must display following message:$")
	public void the_system_must_display_following_message(String expectedResponse) throws Exception {
		assertThat(productPage.getShoppingCartFreeDeliveryAlert()).isEqualTo(expectedResponse);
		scenarioSession.takeScreenShot();
	}
}
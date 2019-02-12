package com.bol.steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.bol.service.ShopService;
import com.oc.pageObject.LoginPage;

import config.ScenarioSession;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;

/**
 * 
 * @author Jim Bonica
 *
 *         Nov 14, 2018
 */
@Scope("cucumber-glue")
public class ShopSteps {

	@Autowired
	LoginPage loginPage;

	@Autowired
	ShopService shopService;

	@Autowired
	ScenarioSession scenarioSession;

	@Given("^a shopper searches for the \"([^\"]*)\" in the top search bar$")
	public void a_shopper_searches_for_the_in_the_top_search_bar(String searchTerm) throws Exception {
		shopService.searchForItemInTopSearchField(searchTerm);
	}

	@When("^a shopper adds the item to the shopping cart$")
	public void a_shopper_add_the_item_to_the_shopping_cart() throws Exception {
		shopService.addItemToShoppingCart();
	
	}

	@Given("^a shopper increases the quantity of the item to (\\d+)$")
	public void a_shopper_increases_the_quantity_of_the_item_to(int quantity) throws Exception {
		shopService.changeQuantityOfItemOnProductPpage(quantity);
	}

	@Then("^the response must return a (\\d+) status code$")
	public void the_response_must_return_a_status_code(int statusCode) throws Exception {
		ValidatableResponse json = scenarioSession.getResponse().then();
		// Assertion for HTTP Response
		json.statusCode(statusCode);
	}

	@Then("^the response must include the following:$")
	public void the_response_must_include_the_following(Map<String, String> responseFields) throws Exception {
		ValidatableResponse json = scenarioSession.getResponse().then();
		//System.out.println(scenarioSession.getResponse().prettyPrint());
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if (StringUtils.isNumeric(field.getValue())) {
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			} else {
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}
	
	@Then("^the response must include in any order:$")
	public void the_response_must_include_in_any_order(Map<String,String> responseFields) throws Exception {
		ValidatableResponse json = scenarioSession.getResponse().then();
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if (StringUtils.isNumeric(field.getValue())) {
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			} else {
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		}
	}

}

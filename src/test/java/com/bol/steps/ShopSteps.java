package com.bol.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.bol.service.AccountService;
import com.bol.service.ShopService;
import com.oc.pageObject.LoginPage;

import config.CrossScenarioCache;
import config.ScenarioSession;
import cucumber.api.java.en.Given;
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
public class ShopSteps {

	@Autowired
	LoginPage loginPage;

	@Autowired
	ShopService shopService;

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

}

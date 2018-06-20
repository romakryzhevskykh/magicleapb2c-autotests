package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.ShoppingCartPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ShoppingCartPageDefs extends AbstractStepDefs {
	final static Logger logger = Logger.getLogger(HomePageStepDefs.class);

	@Autowired
	public UserSessions userSessions;
	@Autowired
	public ShoppingCartPage shoppingCartPage;

	@Then("^Verify current page is Shopping Cart page.$")
	public void verifyShoppingCartPageURL() {
		shoppingCartPage.isCurrentPageUrlShoppingCartUrl();
	}
	@And ("^Verify h2 headers on Shopping cart.$")
	public void verifyH2Headers(){
		shoppingCartPage.verifyShoppingCartHeaders();
	}

}

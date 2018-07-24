package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.SavedCartsPage;
import com.template.storefront.pages.ShoppingCartPage;

import cucumber.api.java.en.Then;

public class SavedCartsPageStepDefs extends AbstractStepDefs {
	final static Logger logger = Logger.getLogger(SavedCartsPageStepDefs.class);

	@Autowired
	public UserSessions userSessions;
	@Autowired
	public ShoppingCartPage shoppingCartPage;
	@Autowired
	public SavedCartsPage savedCartsPage;

	@Then("^Verify current page is Saved Carts page.$")
	public void verifyCaurrentPageIsSavedCatrtsPage() {
		savedCartsPage.isCurrentPageUrlSavedCartsUrl();
	}
	
	@Then ("^Click on Saved Cart name on Saved Carts page.$")
	public void clickOnSavedCartName(){
		savedCartsPage.goToSavedCartDetails();
	}
	
	@Then("^Get number of saved carts on Saved Carts page.$")
	public void getNumberOfSavedCarts(){
		savedCartsPage.getSavedCartsNumber();
	}

}

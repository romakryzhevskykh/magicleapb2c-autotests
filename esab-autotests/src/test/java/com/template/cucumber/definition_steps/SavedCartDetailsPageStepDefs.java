package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.SavedCartDetailsPage;
import com.template.storefront.pages.SavedCartsPage;

import cucumber.api.java.en.Then;

public class SavedCartDetailsPageStepDefs extends AbstractStepDefs {
	final static Logger logger = Logger.getLogger(SavedCartDetailsPageStepDefs.class);
	
	@Autowired
	public UserSessions userSessions;
	@Autowired
	public SavedCartsPage savedCartsPage;
	@Autowired 
	public SavedCartDetailsPage savedCartDetailsPage;
	
	@Then("^Verify current page is Saved Cart Details Page.$")
	public void verifyCurrentPageIsSavedCartDetailsPage(){
		savedCartDetailsPage.isCurrentPageUrlSavedCartDetailsUrl();
	}
}

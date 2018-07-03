package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.ShippingAddressPage;

import cucumber.api.java.en.And;

public class ShippingAddressPageStepDefs extends AbstractStepDefs {

	final static Logger logger = Logger.getLogger(ShippingAddressPageStepDefs.class);

	@Autowired
	public UserSessions userSessions;
	@Autowired
	public ShippingAddressPage shippingAddressPage;

	@And("^Verify is Current page Shipping Address page.$")
	public void isCurrentPageShippingPage() {
		shippingAddressPage.isCurrentPageShippingAddrPage();
	}

	@And("^Verify is Current page Shipping Address page after validation error.$")
	public void isCurrentPAgeShippingAddrPAgeAfterValidationError() {
		shippingAddressPage.isCurrentPageShippingPageAfterError();
	}

	@And("^Fill in Shipping Instructions on Shipping Address page.$")
	public void fillInShippingInstructions() {
		shippingAddressPage.fillInShippingInstructions();
	}

	@And("^Click on Next Button on Shipping Address page.$")
	public void clickOnNextButton() {
		shippingAddressPage.clickOnNextButtonOnShippingAddrPage();
	}

	@And("^Fill in Requested Deliver Date on Shipping Address page.$")
	public void fillInDate() {
		shippingAddressPage.fillInRequestedDate();
	}

	@And("^Verify Shipping Instructions validation message on Shipping Address page.$")
	public void verifyShippingInstructionsValidationMessage() {
		shippingAddressPage.verifyShippingInstructionValidationMessage();
	}

	@And("^Clear Shipping Instructions field on Shipping Information page.$")
	public void clearShippingInstructions() {
		shippingAddressPage.clearSippingInstructions();
	}
}

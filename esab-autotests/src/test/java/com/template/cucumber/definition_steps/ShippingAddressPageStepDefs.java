package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.models.CheckoutDataModel;
import com.template.storefront.pages.ShippingAddressPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class ShippingAddressPageStepDefs extends AbstractStepDefs {

	final static Logger logger = Logger.getLogger(ShippingAddressPageStepDefs.class);

	@Autowired
	public UserSessions userSessions;
	@Autowired
	public ShippingAddressPage shippingAddressPage;

	@Given("^Checkout data model: Ship To Address_StreetName: \"(.*)\", Ship To Address_StreetNumber: \"(.*)\","
			+ " Ship To Address_PostalCode: \"(.*)\", Ship To Address_Town: \"(.*)\","
			+ " Ship To Address_Country: \"(.*)\", Requested Delivery Date: \"(.*)\","
			+ " Partial Delivery Allowed: \"(.*)\", Account: \"(.*)\", Packaging Instructions: \"(.*)\","
			+ " Shipping Instructions: \"(.*)\", Purchase Order Number: \"(.*)\".$")
	public void createCheckoutDataModel(String newStreetName, String newStreetNumber, String newPostalCode,
			String newTown, String newCountry, String newRequestedDeliveryDate, String newPartialDeliveryAllowed,
			String newAccount, String newPackagingInstructions, String newShippingInstructions,
			String newPurchaseOrderNumber) {
		shippingAddressPage.createCheckoutDataModel(newStreetName, newStreetNumber, newPostalCode, newTown, newCountry,
				newRequestedDeliveryDate, newPartialDeliveryAllowed, newAccount, newPackagingInstructions,
				newShippingInstructions, newPurchaseOrderNumber);
	}

	@And("^Verify is Current page Shipping Address page.$")
	public void isCurrentPageShippingPage() {
		shippingAddressPage.isCurrentPageShippingAddrPage();
	}

	@And("^Verify is Current page Shipping Address page after validation error.$")
	public void isCurrentPageShippingAddrPAgeAfterValidationError() {
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

	@And("^Fill in Packaging Instructions on Shipping Address page.$")
	public void fillInPAckagingInstructions() {
		shippingAddressPage.fillInPackagingInstructions();
	}

	@And("^Verify Shipping Instructions validation message on Shipping Address page.$")
	public void verifyShippingInstructionsValidationMessage() {
		shippingAddressPage.verifyShippingInstructionValidationMessage();
	}

	@And("^Clear Shipping Instructions field on Shipping Information page.$")
	public void clearShippingInstructions() {
		shippingAddressPage.clearShippingInstructions();
	}

	@And("^Click on Partial Delivery Radio Button YES on Shipping Address page.$")
	public void clickOnYesButton() {
		shippingAddressPage.clickOnYesButon();
	}

	@And("^Click on Partial Delivery Radio Button NO on Shipping Address page.$")
	public void clickOnNoButton() {
		shippingAddressPage.clickOnNoButton();
	}

	@And("^Click on Partial Delivery Radio Button According to Checkout Data Model on Shipping Address page.$")
	public void clickOnRadioButtonAccordingToDataModel() {
		shippingAddressPage.clickOnRadioButtonAccordingToDataModel();
	}

	@And("^Clear Packaging Instructions input on Shipping Address page.$")
	public void clearPackagingInstruction() {
		shippingAddressPage.clearPackagingInstructions();
	}

	@And("^Clear Requested Delivery Date on Shipping Address page.$")
	public void clearRequestedDElivery() {
		shippingAddressPage.clearRequestedDelivery();
	}

	@And("^Click on Modify Address button on Shipping Address page.$")
	public void clickOnModifyAddrButton() {
		shippingAddressPage.clickOnModifyAddressButton();
	}
	
	@And ("^Click on Close Modify Address button on Shipping Address page.$")
	public void clickOnCloseInModifyAddr(){
		shippingAddressPage.closeModifyAddrPopup();
	}
	
	@And ("^Verify Shipping address text in Modify address popup on Shipping Address page.$")
	public void getShippingAddr(){
		shippingAddressPage.verifyAddressData();
	}
	
	@And("^Click on Address in Popup on Shipping Address page.$")
	public void clickOnAddress(){
		shippingAddressPage.clickOnAddress();
	}
	
	@And ("^Verify Ship To Address on Shipping Address page.$")
	public void verifyShipToAddr(){
		shippingAddressPage.verifyShippingAddress();
	}
}

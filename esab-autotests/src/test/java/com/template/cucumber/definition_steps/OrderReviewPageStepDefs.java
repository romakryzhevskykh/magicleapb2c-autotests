package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.OrderReviewPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class OrderReviewPageStepDefs extends AbstractStepDefs {
	final static Logger logger = Logger.getLogger(OrderReviewPageStepDefs.class);

	@Autowired
	public UserSessions userSessions;
	@Autowired
	public OrderReviewPage orderReviewPage;

	@And("^Click on Place Order button on Order Review page.$")
	public void clickOnPlaceOrderButton() {
		orderReviewPage.clickOnPlaceOrderButton();
	}

	@Given("^Verify current page is Order Review page.$")
	public void isCurrentPageOrderReviewPage() {
		orderReviewPage.isCurrentPageOrderReviewPage();
	}

	@And("^Click on confirmation Checkbox on Order review page.$")
	public void clickOnConfirmationCheckbox() {
		orderReviewPage.clickOnConfirmationCheckbox();
	}

	@And("^Verify Place Order button is Disabled on Order Review page.$")
	public void isPlaceOrderButtonDisabled() {
		orderReviewPage.isPlaceOrderDisabled();
	}

	@And("^Verify Ship To, Sold To address on Order Review page.$")
	public void verifyShipToSoldToAddr() {
		orderReviewPage.verifyShipToSoldToAddr();
	}

	@And("^Verify Purchase order number on Order Review page.$")
	public void verifyPurchaseOrderNumber() {
		orderReviewPage.verifyPurchaseOrderNumber();
	}

	@And("^Verify header on Order Review page.$")
	public void verifyOrderReviewPageHeader() {
		orderReviewPage.verifyHeader();
	}

	@And("^Verify Account Number on Order Review page.$")
	public void verifyAccountNumber() {
		orderReviewPage.verifyAccountNumber();
	}

	@And("^Verify Requested Delivery Date on Order Review page.$")
	public void verifyRequestedDeliverDate() {
		orderReviewPage.verifyRequestedDeliveryDate();
	}

	@And("^Verify Allow Partial Delivery on Order Review page.$")
	public void verifyAllowPartialDelivery() {
		orderReviewPage.verifyAllowPartialDelivery();
	}

	@And("^Verify Packaging Instrictions on Order Review page.$")
	public void verifyPackagingInstructions() {
		orderReviewPage.verifyPackagingInstructions();
	}

	@And("^Verify Shipping Instructions on Order Review page.$")
	public void verifyShippingInstructions() {
		orderReviewPage.verifyShippingInstructions();
	}

	@And("^Verify Product Names on Oerder Review page.$")
	public void verifyProductNames() {
		orderReviewPage.verifyListOfProducts();
	}

	@And("^Verify Prices on Order Review page.$")
	public void verifyPrices() {
		orderReviewPage.verifyActualPrices();
	}

	@And("^Verify Total Prices on Order Review page.$")
	public void verifyTotalPrices() {
		orderReviewPage.verifyActualTotalPrices();
	}

	@And("^Verify Subtotal on Order Review page.$")
	public void verifySubtotal() {
		orderReviewPage.verifySubtotal();
	}
	
	@And("^Verify Product Qty on Order Review page.$")
	public void verifyQtyOrderReviewPage(){
		orderReviewPage.verifyQtyOrderReview();
	}
	
	@And ("^Verify Order Total on Order Review page.$")
	public void verifyOrderTotalPrice(){
		orderReviewPage.verifyOrderTotal();
	}
}

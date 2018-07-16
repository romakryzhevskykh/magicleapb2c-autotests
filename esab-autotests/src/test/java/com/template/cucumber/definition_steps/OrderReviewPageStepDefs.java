package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.OrderReviewPage;
import com.template.storefront.pages.OrderConfirmationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class OrderReviewPageStepDefs extends AbstractStepDefs {
	final static Logger logger = Logger.getLogger(OrderReviewPageStepDefs.class);

	@Autowired
	public UserSessions userSessions;
	@Autowired
	public OrderReviewPage orderReviewPage;
	@Autowired 
	public OrderConfirmationPage orderConfirmationPage;

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
	
	@And ("Verify OrderConfirmation page URL")
	public void verifyOrderConfirmationPageURL(){
		orderConfirmationPage.isCurrentPageOrderConfirmationPage();
	}
	
	@And ("^Verify Ship To address on Order Confirmation page.$")
	public void verifyShipToAddrOrderConfirmation(){
		orderConfirmationPage.verifyAddresses();
	}
	
	@And ("^Verify Order Purchase number on Order Confirmation page.$")
	public void verifyOrderPurchaseNumberOrderConfirmation(){
		orderConfirmationPage.verifyPurchaseOrderNumberOrderConfirmation();
	}
	
	@And ("^Verify Account Number on Order Confirmation page.$")
	public void verifyAccNumberOrderConfirmation(){
		orderConfirmationPage.verifyAccNumberOrderConfirmation();
	}
	
	@And ("^Verify Requested Delivery Date on Order Confirmation page.$")
	public void verifyRequestedDeliveryOrderConfirmation(){
		orderConfirmationPage.verifyRequestedDeliveryOrderConfirmation();
	}
	
	@And ("^Verify Allow Partial Delivery on Order Confirmation page.$")
	public void verifyAllowPArtialDeliveryOrderConfirmation(){
		orderConfirmationPage.verifyPartialDeliveryOrderConfirmation();;
	}
	
	@And ("^Verify Packaging Instructions on Order Confirmation page.$")
	public void verifyPackagingInstructionsOrderConfirmation(){
		orderConfirmationPage.verifyPackagingInstructionsOrderConfirmation();
	}
	
	@And ("^Verify Shipping Instructions on Order Confirmation page.$")
	public void verifyShipInstructionOrderConfirmation(){
		orderConfirmationPage.verifyShippingInstructionsOrderConfirmation();
	}
	
	@And ("^Verify Product Names on Order Confirmation page.$")
	public void verifyProdNameOrderConfirmation(){
		orderConfirmationPage.verifyProductNamesOrderConfirmation();
	}
	
	@And ("^Verify Product Qty on Order Confirmation page.$")
	public void verifyProdQtyOrderConfirmation(){
		orderConfirmationPage.verifyProductQtyOrderConfirmation();
	}
	
	@And ("^Verify Product Prices on Order Confirmation page.$")
	public void verifyProductPricesOrderConfirmation(){
		orderConfirmationPage.verifyPricesOrderConfirmation();
	}
	
	@And ("^Verify Product Total Prices on Order Confirmation page.$")
	public void verifyProductTotalPricesOrderConfirmation(){
		orderConfirmationPage.verifyTotalPricesOrderConfirmation();
	}
	
	@And ("^Verify Product Subtotal on Order Confirmation page.$")
	public void verifySubtotalOrderConfirmation(){
		orderConfirmationPage.verifySubtotalOrderConfirmation();
	}
	
	@And ("^Verify Order Total on Order Confirmation page.$")
	public void verifyOrderTotalOrderConfirmation(){
		orderConfirmationPage.verifyOrderTotalOrderConfirmation();
	}
	
	
}

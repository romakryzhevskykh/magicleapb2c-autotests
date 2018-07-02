package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.PaymentTypePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PaymentTypePageStepDefs extends AbstractStepDefs {
	
	final static Logger logger = Logger.getLogger(PaymentTypePageStepDefs.class);
	
	@Autowired
	public UserSessions userSessions;
	@Autowired
	public PaymentTypePage paymentTypePage;
	
	@Given ("^Verify Payment Type page opened.$")
	public void isCurrentPagePaymentType(){
		paymentTypePage.isCurrentPagePaymentTypePage();
	}
	
	@And ("^Fill in Purchase Order Number on Payment Type page.$")
	public void fillInPurchaseOrderNumber(){
		paymentTypePage.fillInOrderNumber();
	}
	
	@And ("^Click on Next on Payment Type page.$")
	public void clickOnNextButton(){
		paymentTypePage.cliclOnNextPaymentOrderPage();
	}
}

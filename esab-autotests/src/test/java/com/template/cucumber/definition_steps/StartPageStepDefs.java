package com.template.cucumber.definition_steps;

import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class StartPageStepDefs extends AbstractStepDefs {

	final static Logger logger = Logger.getLogger(StartPageStepDefs.class);

	@Autowired
	StartPage startPage;
	@Autowired
	HeaderRowPageBlock headerRowPageBlock;

	@Given("Opened Start page.")
	public void openLoginPage() {
		if (!startPage.isOpened()) {
			if (headerRowPageBlock.isUserLoggedIn()) {
				logger.warn("This is test log4j test Message");
				headerRowPageBlock.logoutFromStorefront();
			} else if (!startPage.isOpened()) {
				startPage.open();
			}
		}
	}

	@When("Click on Sign in button.")
	public void clickOnSignInButton() {
		startPage.clickOnSignInButton();
	}
}

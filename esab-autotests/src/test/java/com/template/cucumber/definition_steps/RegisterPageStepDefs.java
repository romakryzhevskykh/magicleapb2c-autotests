package com.template.cucumber.definition_steps;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.java.en.Then;

public class RegisterPageStepDefs extends AbstractStepDefs {

	final static Logger logger = Logger.getLogger(HomePageStepDefs.class);

	@Autowired
	UserSessions userSessions;
	@Autowired
	RegisterPage registerPage;

	@Then("Verify current page is Register page.")
	public void verifyRegisterPageOpened() {
		logger.info("Verify register page is Opened");
		assertTrue(registerPage.isCurrentUrlIsRegisterPageUrl(), "Current page is not registratin page");
	}
	@And ("Verify field label names on Register page.")
	public void verifyRegisterPageFieldLabels(){
		logger.info("Verify register page field labels");
		registerPage.verifyRegisterPageFieldLabels();
	}
	@And ("Verify headline text on Register page.")
	public void verifyHeadLineText(){
		logger.info("Verify register page headline text");
		registerPage.verifyRegisterPageHeadLineText();
	}
	@And ("Verify second line text on Register page.")
	public void verifySecondLineText(){
		logger.info("Verify register page second line text");
		registerPage.verifyRegisterPageSecondLineText();
	}
	@Then("^Input First name and LastName: (.*) into First and Last name field$")
	public void inputTextIntoFirstLastName(String firstLastName){
		registerPage.fillInFirstLastNameInput(firstLastName);
	}

}

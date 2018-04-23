package com.template.cucumber.definition_steps;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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

	@And("Verify field label names on Register page.")
	public void verifyRegisterPageFieldLabels() {
		logger.info("Verify register page field labels");
		registerPage.verifyRegisterPageFieldLabels();
	}

	@And("Verify headline text on Register page.")
	public void verifyHeadLineText() {
		logger.info("Verify register page headline text");
		registerPage.verifyRegisterPageHeadLineText();
	}

	@And("Verify second line text on Register page.")
	public void verifySecondLineText() {
		logger.info("Verify register page second line text");
		registerPage.verifyRegisterPageSecondLineText();
	}

	@Then("^Input First name and LastName: (.*) into First and Last name field.$")
	public void inputTextIntoFirstLastName(String firstLastName) {
		registerPage.fillInFirstLastNameInput(firstLastName);
	}

	@Then("^Select country: (.*) in Country dropdown.$")
	public void selectCountry(String countryValue) {
		registerPage.selectCountry(countryValue);
	}

	// Need to use title Id
	// ID: 0001 Value: Ms.
	// ID: 0002 Value: Mr.
	// ID: 0003 Value: Company
	// ID: 0004 Value: Mr. and Mrs.
	@Then("^Select title: (.*) in Title dropdown.$")
	public void selectTitle(String title) {
		registerPage.selectTitle(title);
	}

	@Then("^Input Company ID: (.*) into Company ID field.$")
	public void inputTextIntoCompanyIdField(String companyId) {
		registerPage.fillInCompanyId(companyId);
	}

	@Then("^Input Company Name: (.*) into Company Name field.$")
	public void inputTextIntoCompanyNameField(String companyName) {
		registerPage.fillInCompanyName(companyName);
	}

	@Then("^Input Address Line 1: (.*) into Address Line 1 field.$")
	public void inputTextIntoAddrLine1(String addrLine1) {
		registerPage.fillInAddrLine1(addrLine1);
		;
	}

	@Then("^Input Address Line 2: (.*) into Address Line 2 field.$")
	public void inputTextIntoAddrLine2(String addrLine2) {
		registerPage.fillInAddrLine2(addrLine2);
	}

	@Then("^Input City: (.*) into City field.$")
	public void inputTextIntoCity(String city) {
		registerPage.fillInCity(city);
	}

	@Then("^Input Post Code: (.*) into Post Code field.$")
	public void inputTextIntoPostCode(String postCode) {
		registerPage.fillInPostCode(postCode);
	}

	@Then("^Input Ypur Position: (.*) into Your Position field.$")
	public void inputTextIntoPosition(String position) {
		registerPage.fillInYourPosition(position);
	}

	@Then("^Input Telephone: (.*) into Telephone field.$")
	public void inputTextIntoTelephone(String telephone) {
		registerPage.fillInTelephone(telephone);
	}

	@Then("^Input Ext: (.*) into Ext field.$")
	public void inputTextIntoExt(String ext) {
		registerPage.fillInExt(ext);
	}

	@Then("^Input Email Address: (.*) into Email Address field.$")
	public void inputTextIntoEmailAddr(String emailAddr) {
		registerPage.fillInEmailAddr(emailAddr.trim());
	}

	@Then("^Confirm Email Address: (.*) in Confirm Email Address field.$")
	public void inputTextIntoConfirmEmailAddr(String emailAddr) {
		registerPage.fillInConfirmEmailAddr(emailAddr.trim());
	}

	@Then("^Input Comment: (.*) into Comment field.$")
	public void inputTextIntoComment(String comment) {
		registerPage.fillInComment(comment);
	}
	
	@Then ("^Confirm registration.$")
	public void clickOnRegisterButton(){
		registerPage.clickOnRegisterButton();
	}

}

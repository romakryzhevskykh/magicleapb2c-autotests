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
	public UserSessions userSessions;
	@Autowired
	public RegisterPage registerPage;

	@Then("Verify current page is Register page.")
	public void verifyRegisterPageOpened() {
		registerPage.isCurrentUrlIsRegisterPageUrl();
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

	@Given("^User model:" + "Country: '(.*)', " + "Title: '(.*)', " + "First and Last Name: '(.*)', "
			+ "Company ID: '(.*)', " + "Company Name: '(.*)', " + "Address 1: '(.*)', " + "Address 2: '(.*)', "
			+ "City: '(.*)', " + "Post Code: '(.*)', " + "Position: '(.*)', " + "Telephone: '(.*)', " + "Ext: '(.*)', "
			+ "Email address: '(.*)', " + "Confir email address: '(.*)', " + "Comment: '(.*)'.$")
	public void createUserModel(String newCountry, String newTitle, String newFirstLastName, String newCompanyId,
			String newCompanyName, String newAddr1, String newAddr2, String newCity, String newPostCode,
			String newPosition, String newTelephone, String newExt, String newEmailAddr, String newConfirmEmailaddr,
			String newComment) {
		registerPage.createUserModel(newCountry, newTitle, newFirstLastName, newCompanyId, newCompanyName, newAddr1,
				newAddr2, newCity, newPostCode, newPosition, newTelephone, newExt, newEmailAddr, newConfirmEmailaddr,
				newComment);

	}

	@Then("^Input First name and LastName into First and Last name field.$")
	public void inputTextIntoFirstLastName() {
		registerPage.fillInFirstLastNameInput();
	}

	@Then("^Select country in Country dropdown.$")
	public void selectCountry() {
		registerPage.selectCountry();
	}

	// Need to use title Id
	// ID: 0001 Value: Ms.
	// ID: 0002 Value: Mr.
	// ID: 0003 Value: Company
	// ID: 0004 Value: Mr. and Mrs.
	@Then("^Select title in Title dropdown.$")
	public void selectTitle() {
		registerPage.selectTitle();
	}

	@Then("^Input Company ID into Company ID field.$")
	public void inputTextIntoCompanyIdField() {
		registerPage.fillInCompanyId();
	}

	@Then("^Input Company Name into Company Name field.$")
	public void inputTextIntoCompanyNameField() {
		registerPage.fillInCompanyName();
	}

	@Then("^Input Address Line 1 into Address Line 1 field.$")
	public void inputTextIntoAddrLine1() {
		registerPage.fillInAddrLine1();
		;
	}

	@Then("^Input Address Line 2 into Address Line 2 field.$")
	public void inputTextIntoAddrLine2() {
		registerPage.fillInAddrLine2();
	}

	@Then("^Input City into City field.$")
	public void inputTextIntoCity() {
		registerPage.fillInCity();
	}

	@Then("^Input Post Code into Post Code field.$")
	public void inputTextIntoPostCode() {
		registerPage.fillInPostCode();
	}

	@Then("^Input Your Position into Your Position field.$")
	public void inputTextIntoPosition() {
		registerPage.fillInYourPosition();
	}

	@Then("^Input Telephone into Telephone field.$")
	public void inputTextIntoTelephone() {
		registerPage.fillInTelephone();
	}

	@Then("^Input Ext into Ext field.$")
	public void inputTextIntoExt() {
		registerPage.fillInExt();
	}

	@Then("^Input Email Address into Email Address field.$")
	public void inputTextIntoEmailAddr() {
		registerPage.fillInEmailAddr();
	}

	@Then("^Confirm Email Address in Confirm Email Address field.$")
	public void inputTextIntoConfirmEmailAddr() {
		registerPage.fillInConfirmEmailAddr();
	}

	@Then("^Input Comment into Comment field.$")
	public void inputTextIntoComment() {
		registerPage.fillInComment();
	}

	@Then("^Confirm registration.$")
	public void clickOnRegisterButton() {
		registerPage.clickOnRegisterButton();
	}

}

package com.magicleap.cucumber.definition_steps;

import com.magicleap.helpers.UIComponent;
import com.magicleap.helpers.managers.users.UserSessions;
import com.magicleap.storefront.page_blocks.HeaderRowPageBlock;
import static com.magicleap.helpers.UIComponent.*;
import com.magicleap.storefront.pages.LoginPage;
import com.magicleap.storefront.pages.QualificationPage;
import com.magicleap.storefront.pages.StartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class QualificationPageStepDefs extends AbstractStepDefs {

    @Autowired UserSessions userSessions;
    @Autowired StartPage startPage;
    @Autowired LoginPage loginPage;
    @Autowired QualificationPage qualificationPage;


    @And("Click on sign up button.")
    public void clickOnSignUpButton() {
        loginPage.clickOnSignUpButton();
    }

    @And("Check that Qualification page is opened.")
    public void checkThatQualificationPageIsOpened() {
        assertTrue(qualificationPage.isOpened());
    }
    @And("^Fill Legal Company name (.*) on the Qualification page.$")
    public void fillLegalCompanyName(String legalCompanyName) {
        qualificationPage.fillLegalCompanyName(legalCompanyName);
    }
    @And("^Fill DBA (.*) on the Qualification page.$")
    public void fillDba(String dbaName) {
        qualificationPage.fillDba(dbaName);
    }
    @And("^Fill website (.*) on the Qualification page.$")
    public void fillWebsite (String website) {
        qualificationPage.fillWebsite(website);
    }
    @And("^Fill years in business (.*) on the Qualification page.$")
    public void fillYearsInBusiness (String years) {
        qualificationPage.fillYearsInBusiness(years);
    }
    @And("^Click on type of business dropdown on the Qualification page.$")
    public void clickOnTypeOfBusiness () {
        qualificationPage.clickOnTypeOfBusinessDropdown();
    }
     @And("^Select type of business (.*) from dropdown on the Qualification page.$")
    public void selectTypeOfBusiness (String typeOfBusinessName) {
        qualificationPage.selectTypeOfBusinessDropdown(typeOfBusinessName);
    }
    @And("^Click on market segment dropdown on the Qualification page.$")
    public void clickOnMarketSegment () {
        qualificationPage.clickOnMarketSegmentDropdown();
    }
    @And("^Select market segment (.*) from dropdown on the Qualification page.$")
    public void selectMarketSegment (String marketSegment) {
        qualificationPage.selectMarketSegmentDropdown(marketSegment);
    }
    @And("^Click on type of ownership (.*) radio button on the Qualification page.$")
    public void clickOnTypeOfOwnershipRadioButton (String radioButton) {
        qualificationPage.clickOnTypeOfOwnershipRadioButton(radioButton);
    }
    @And("^Click on prior business dealings with Magic Leap (.*) radio button on the Qualification page.$")
    public void clickOnPriorBusinessDealingsRadioButton (String radioButton) {
        qualificationPage.clickOnPriorBusinessDealingsRadioButton(radioButton);
    }
    @And("^Click on the next button")
    public void clickOnNextButton () {
        qualificationPage.clickOnNextButton();
    }
    @And("^Fill full user name (.*) on the Qualification page.$")
    public void fillFullUserName(String fullName) {
        qualificationPage.fillFullName(fullName);
    }
    @And("^Fill title (.*) on the Qualification page.$")
    public void fillTitle(String title) {
        qualificationPage.fillTitle(title);
    }
    @And("Fill mail (.*) on the Qualification page.")
    public void fillEmail(String email) {
        qualificationPage.fillEmail(email);
    }
    @And("^Fill phoneNumber (.*) on the Qualification page.$")
    public void fillPhoneNumber (String phoneNumber) {
        qualificationPage.fillPhoneNumber(phoneNumber);
    }
    @And("^Fill Street Address Line 1 (.*) on the Qualification page.$")
    public void fillStreetAddress1 (String StreetAddress1) {
        qualificationPage.fillAddress1(StreetAddress1);
    }
    @And("^Fill Street Address Line 2 (.*) on the Qualification page.$")
    public void fillStreetAddress2 (String StreetAddress2) {
        qualificationPage.fillAddress2(StreetAddress2);
    }
    @And("^Fill City (.*) on the Qualification page.$")
    public void fillCity (String city) {
        qualificationPage.fillCity(city);
    }
    @And("^Select state (.*) from dropdown on the Qualification page.$")
    public void selectState (String state) {
        qualificationPage.clickOnStateDropdown();
        qualificationPage.selectStateDropdown(state);
    }
    @And("^Fill Zip code (.*) on the Qualification page.$")
    public void fillZipCode (String zipCode) {
        qualificationPage.fillZipcode(zipCode);
    }
    @And("Fill email to send invoice to (.*) on the Qualification page.")
    public void fillToSendInvoiceEmail(String emailToSendInvoice) {
        qualificationPage.emailAddressToSendInvoice(emailToSendInvoice);
    }
    @And("^Click on Are you Tax Exempt (.*) radio button on the Qualification page.$")
    public void clickOnTaxExemptRadioButton (String radioButton) {
        qualificationPage.clickOnTaxExemptRadioButton(radioButton);
    }
    @And("^Click on Is your billing address different from the one below (.*) radio button on the Qualification page.$")
    public void clickOnBillingAddressDifferentRadioButton (String radioButton) {
        qualificationPage.clickOnYourBillingAddressIsDifferentRadioButton(radioButton);
    }
    @And("^Click on Is your shipping address different from the one below (.*) radio button on the Qualification page.$")
    public void clickOnShippingAddressDifferentRadioButton (String radioButton) {
        qualificationPage.clickOnShippingAddressDifferentRadioButton(radioButton);
    }
    @And("^Click on Preferred form of payment (.*) radio button on the Qualification page.$")
    public void clickOnPreferredFormOfPaymentRadioButton (String radioButton) {
        qualificationPage.clickOnPreferredFormOfPaymentRadioButton(radioButton);
    }
    @And("^Click on the Get Qualified button")
    public void clickOnGetQualifiedButton () {
        qualificationPage.clickOnGetQualifiedButton();
    }
}

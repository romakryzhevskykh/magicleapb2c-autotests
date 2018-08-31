package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.UserNotActivePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserNotActiveStepDefs extends AbstractStepDefs {
    @Autowired
    private UserNotActivePage userNotActivePage;

    @Then("^User sees User not active page.$")
    public void isUserNotActivePageOpened() {
        assertTrue(userNotActivePage.isOpened());
    }

    @Then("^Is (.*) title displayed.$")
    public void isAccountManagementTitleDisplayed(String title) {
        assertEquals(title, userNotActivePage.getUserNotActivePageTitle());
    }

    @Then("^Is Appropriate text displayed in the main block.$")
    public void isAppropriateHelloMessageDisplayed() {
        String firstName = threadVarsHashMap.getString(TestKeyword.USER_FIRST_NAME);
        assertEquals("Hey " + firstName + ", it looks like you have a profile but no account to navigate empower.",
                userNotActivePage.getHelloMessage());
        assertEquals("How to find your account number:", userNotActivePage.getHowToFindText());
        assertEquals("1." + "\n" +
                "Invoice" + "\n" +
                ": check your invoice for an account number", userNotActivePage.getInvoiceText());
        assertEquals("2." + "\n" +
                "Account Manager" + "\n" +
                ": ask your account manager for the account number", userNotActivePage.getAccountManagementText());
    }

    @Then("^Is Appropriate text displayed in the footer block.$")
    public void isAppropriateTextDisplayedInTheFooterBlock() {
        assertEquals("Note: You must be an existing customer of Industrial Solutions in order to use empower." +
                " If you are not an existing customer:", userNotActivePage.getNoteFooterText());
        assertEquals("Locate a distributor", userNotActivePage.getFooterLocateAdistributorLinkText());
        assertEquals("Contact us", userNotActivePage.getFooterContactUsLinkText());
    }

    @When("^User clicks on Request Account button.$")
    public void userClicksOnRequestAccountButton() {
        userNotActivePage.userClicksOnRequestAccountButton();
    }

    @Then("^Is (.*) title displayed in request pop-up.$")
    public void isRequestAccountTitleDisplayedInRequestPopUp(String title){
        assertEquals(title, userNotActivePage.getRequestAccountTitlePopUp());
    }

    @And("^User closes Request Account pop-up.$")
    public void userClosesRequestAccountPopUp() {
        userNotActivePage.userClosesRequestAccountPopUp();
    }

    @When("^User clicks on Add New Account field button.$")
    public void userClicksOnAddNewAccountFieldButton(){
        userNotActivePage.userClicksOnAddNewAccountFieldButton();
    }

    @Then("^Is Appropriate (\\d+) account No fields displayed.$")
    public void isAppropriateQuantityOfTheAccountNoFieldsDisplayed(int count) {
        assertTrue(userNotActivePage.getAccountNoFields() == count);
    }
}
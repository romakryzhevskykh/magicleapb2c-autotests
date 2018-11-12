package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.UserNotActivePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

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
                userNotActivePage.getHelloMessageScreen1());
        assertEquals("How to find your account number:", userNotActivePage.getHowToFindTextScreen1());
        assertEquals("1." + "\n" +
                "Invoice" + "\n" +
                ": check your invoice for an account number", userNotActivePage.getInvoiceTextScreen1());
        assertEquals("2." + "\n" +
                "Account Manager" + "\n" +
                ": ask your account manager for the account number", userNotActivePage.getAccountManagementTextScreen1());
    }

    @Then("^Is Appropriate text displayed in the footer block.$")
    public void isAppropriateTextDisplayedInTheFooterBlock() {
        assertEquals("Note: You must be an existing customer of Industrial Solutions in order to use empower." +
                " If you are not an existing customer:", userNotActivePage.getNoteFooterTextScreen1());
        assertEquals("Locate a distributor", userNotActivePage.getFooterLocateAdistributorLinkTextScreen1());
        assertEquals("Contact us", userNotActivePage.getFooterContactUsLinkTextScreen1());
    }

    @When("^User clicks on Request Account button.$")
    public void userClicksOnRequestAccountButton() {
        userNotActivePage.userClicksOnRequestAccountButton();
    }

    @Then("^Is (.*) title displayed in request pop-up.$")
    public void isRequestAccountTitleDisplayedInRequestPopUp(String title) {
        assertEquals(title, userNotActivePage.getRequestAccountTitlePopUp());
    }

    @And("^User closes Request Account pop-up.$")
    public void userClosesRequestAccountPopUp() {
        userNotActivePage.userClosesRequestAccountPopUp();
    }

    @When("^User clicks on Add New Account field button.$")
    public void userClicksOnAddNewAccountFieldButton() {
        userNotActivePage.userClicksOnAddNewAccountFieldButton();
    }

    @Then("^Is Appropriate (\\d+) account No fields displayed.$")
    public void isAppropriateQuantityOfTheAccountNoFieldsDisplayed(int count) {
        assertTrue(userNotActivePage.getAccountNoFields() == count);
    }

    @When("^User sets (.*) to the Account Number field.$")
    public void userSetsAccountToTheAccountNumberField(String accountNo) {
        userNotActivePage.userSetsAccountToTheAccountNumberField(accountNo);
    }

    @And("^Click on Submit for Approval button.$")
    public void clickOnSubmitForApprovalButton() {
        userNotActivePage.clickOnSubmitForApprovalButton();
    }

    @Then("^Requested account fields contains (.*) account.$")
    public void requestedAccountFieldsContainsAccountAccount(String accountNo) {
        assertTrue(userNotActivePage.getRequestedAccountFields().allMatch(acc -> acc.getAttribute("value").contains(accountNo)));
        List<String> pendingAccounts = userNotActivePage.getRequestedAccountFields().map(WebElement::getText).collect(Collectors.toList());
        threadVarsHashMap.put(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS, pendingAccounts);
    }

    @Then("^Is Appropriate text displayed in the main block on the second screen.$")
    public void isAppropriateTextDisplayedInTheMainBlockOnTheSecondScreen() {
        String firstName = threadVarsHashMap.getString(TestKeyword.USER_FIRST_NAME);
        assertEquals("Hey " + firstName + ", it looks like you have a profile but no account to navigate empower,",
                userNotActivePage.getHelloMessage1Screen2());
        assertEquals("however we see your request below pending for approval.",
                userNotActivePage.getHelloMessage2Screen2());
        assertEquals("Requested accounts:", userNotActivePage.getRequestedAccountsTextScreen2());
        assertEquals("Optional: Do you have a pre authorization code? Yes", userNotActivePage.getAuthorizationTextScreen2());
        assertEquals("Please allow us 48 hours to process your request.", userNotActivePage.getPleaseAllowUsTextScreen2());
    }

    @When("^User clicks on Yes pre authorization code button.$")
    public void userClicksOnYesPreAuthorizationCodeButton() {
        userNotActivePage.userClicksOnYesPreAuthorizationCodeButton();
    }

    @Then("^Is (.*) title displayed in Pre Authorization Code pop-up.$")
    public void isPreAuthorizationCodeTitleDisplayedInPreAuthorizationCodePopUp(String title) {
        assertEquals(title, userNotActivePage.getPreAuthTitlePopUp());
    }

    @And("^User closes Pre Authorization Code pop-up.$")
    public void userClosesPreAuthorizationCodePopUp() {
        userNotActivePage.userClosesPreAuthorizationCodePopUp();
    }

    @When("^User clicks on the ABB logo on the userNotActive page.$")
    public void userClicksOnTheABBLogoOnTheUserNotActivePage() {
        userNotActivePage.userClicksOnAbbLogoToActivateHimself();
    }
}
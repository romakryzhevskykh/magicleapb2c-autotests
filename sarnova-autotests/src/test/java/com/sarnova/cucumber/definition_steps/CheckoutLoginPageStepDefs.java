package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.CheckoutLoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class CheckoutLoginPageStepDefs extends AbstractStepDefs {

    @Autowired private CheckoutLoginPage checkoutLoginPage;

    @When("^Enter email to guest email text field on Guest checkout login page.$")
    public void enterEmailToGuestEmailField() {
        String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com";
        threadVarsHashMap.put(TestKeyword.GUEST_EMAIL, randomEmail);
        checkoutLoginPage.fillGuestEmail(randomEmail);
    }

    @When("Click on Continue as guest button on Guest checkout login page.")
    public void clickOnContinueAsGuest() {
        checkoutLoginPage.clickOnContinueAsGuest();
    }

    @When("^Enter email to guest confirm email text field on Guest checkout login page.$")
    public void enterConfirmEmailToGuestEmailField() {
        String randomEmail = threadVarsHashMap.getString(TestKeyword.GUEST_EMAIL);
        checkoutLoginPage.fillConfirmGuestEmail(randomEmail);
    }

    @When("^Click on Check out as a Guest button on Guest checkout login page.$")
    public void clickOnCheckOutAsAGuestButton() {
        checkoutLoginPage.clickOnCheckOutAsAGuest();
    }

    @When("^Login as guest for checkout on Guest checkout login page.$")
    public void loginToCheckoutAsAGuest() {
        checkoutLoginPage.loginAsGuestWithRandomEmail();
    }

    @Then("^Check that Guest checkout login page is opened.$")
    public void checkThatGuestCheckoutLoginPageIsOpened() {
        assertTrue(checkoutLoginPage.isOpened());
    }
}

package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.MyCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyCartStepDefs extends AbstractStepDefs {
    @Autowired
    private MyCartPage myCartPage;

    @Then("(.*) title is displayed on My Cart page.")
    public void checkMyCartTitle(String myCartTitle) {
        assertEquals(myCartPage.getMyCartTitle(), myCartTitle);
    }

    @Then("^All necessary elements are displayed on the My Cart page.$")
    public void allNecessaryElementsAreDisplayedOnTheMyCartPage() {
        assertTrue(myCartPage.areOrderStepIconsDisplayed());
        assertTrue(myCartPage.isMainOrderDataDisplayedOnTheTopRight());
        assertTrue(myCartPage.isBuildOrderInformationInputPresent());
        assertTrue(myCartPage.isAddItemButtonPresent());
        assertTrue(myCartPage.isDeleteItemButtonPresent());
        assertTrue(myCartPage.isUpdatePriceAndAvailabilityButtonPresent());
        assertTrue(myCartPage.isNextBottomButtonPresent());
        assertTrue(myCartPage.isNextTopButtonPresent());
        assertTrue(myCartPage.isSaveItemsButtonPresent());
        assertTrue(myCartPage.isCancelButtonPresent());
    }

    @And("^User cancels the order by clicking on the Cancel button.$")
    public void userCancelsTheOrderByClickingOnTheCancelButton() {
        myCartPage.clickOnCancelButton();
    }

    @When("^User clicks on the Next top button on the My Cart page.$")
    public void userClicksOnTheNextTopButtonOnTheMyCartPage() {
        myCartPage.clickOnTheNextTopButton();
    }

}

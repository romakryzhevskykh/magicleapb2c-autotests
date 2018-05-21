package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.OrderHistoryPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class OrderHistoryPageStepDefs extends AbstractStepDefs {
    @Autowired OrderHistoryPage orderHistoryPage;

    @Then("^Check that Order History page is opened.$")
    public void checkThatOrderHistoryPageIsOpened() {
        assertTrue(orderHistoryPage.isOpened());
    }

}

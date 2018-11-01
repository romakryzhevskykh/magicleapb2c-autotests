package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import com.sarnova.storefront.pages.PurchaseRequestsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class PurchaseRequestsPageStepDefs extends AbstractStepDefs {

    @Autowired private PurchaseRequestsPage purchaseRequestsPage;

    @Given("^Purchase request page page is open.$")
    public void openHomePage() {
        purchaseRequestsPage.open();
    }
    @And("^Purchase request order number is present on the purchase request page.$")
    public void checkPurchaseRequestNumberIsPresent() {

    }



}

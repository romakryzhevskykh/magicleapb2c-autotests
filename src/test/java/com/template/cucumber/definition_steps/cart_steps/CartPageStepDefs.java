package com.template.cucumber.definition_steps.cart_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.storefront.pages.CartPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class CartPageStepDefs extends AbstractStepDefs {

    @Autowired private CartPage cartPage;

    @Given("^Cart page is opened.$")
    public void cartPageIsOpened() {
        if (!cartPage.isOpened()) {
            cartPage.open();
        }
    }

    @When("Open Cart page.")
    public void openCartPage() {
        cartPage.open();
    }

    @When("Click on Checkout button on Cart page.")
    public void clickOnCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

}

package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.Order.OrdersPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class OrdersStepDefs extends AbstractStepDefs {
    @Autowired
    OrdersPage ordersPage;

    @Then("(.*) title is displayed on Orders page.")
    public void checkMyCartTitle(String ordersTitle) {
        assertEquals(ordersPage.getOrdersTitle(), ordersTitle);
    }
}

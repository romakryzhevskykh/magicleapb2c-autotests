package com.template.cucumber.definition_steps;

import com.template.helpers.models.payments.Order;
import com.template.storefront.pages.OrderConfirmationPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class OrderConfirmationPageStepDefs extends AbstractStepDefs {

    @Autowired private OrderConfirmationPage orderConfirmationPage;

    @Then("^Check that Order confirmation page is opened.$")
    public void orderConfirmationPageIsOpened() {
        Order order = (Order) threadVarsHashMap.get(TestKeyword.ORDER);
        assertTrue(orderConfirmationPage.isOpened(order.getId()));
    }
}

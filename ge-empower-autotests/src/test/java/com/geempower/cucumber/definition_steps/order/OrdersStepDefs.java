package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.storefront.pages.order.OrdersPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class OrdersStepDefs extends AbstractStepDefs {
    @Autowired
    private OrdersPage ordersPage;

    @Then("(.*) title is displayed on Orders page.")
    public void checkMyCartTitle(String ordersTitle) {
        assertEquals(ordersPage.getOrdersTitle(), ordersTitle);
    }

    @When("^Admin opens order with status (.*).$")
    public void adminOpensOrderWithStatusShipped(String orderStatus) {
        ordersPage.openAppropriateOrderByStatus(orderStatus);
    }

    @When("^All orders were sorted by orderStatus.$")
    public void allOrdersWereSortedByOrderStatus() {
        ordersPage.sortOrdersTableByStatus();
    }
}

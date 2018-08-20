package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.helpers.managers.OrderManager;
import com.geempower.storefront.pages.order.OrdersPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.geempower.cucumber.definition_steps.TestKeyword.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrdersStepDefs extends AbstractStepDefs {
    @Autowired
    private OrdersPage ordersPage;

    @Autowired
    private OrderManager orderManager;

    @Then("(.*) title is displayed on Orders page.")
    public void checkMyCartTitle(String ordersTitle) {
        assertEquals(ordersTitle, ordersPage.getOrdersTitle());
    }

    @When("^Admin opens order with status (.*).$")
    public void adminOpensOrderWithStatusShipped(String orderStatus) {
        ordersPage.openAppropriateOrderByStatus(orderStatus);
    }

    @When("^All orders were sorted by orderStatus.$")
    public void allOrdersWereSortedByOrderStatus() {
        ordersPage.sortOrdersTableByStatus();
    }

    @Then("^Order by parameters page with appropriate (.*) is opened.$")
    public void pageWithAppropriateOrderNoIsOpened(String orderNo) {
        assertTrue(ordersPage.getCurrentUrl().contains("orderNum=" + orderNo));
    }

    @When("^User clicks on appropriate (.*).$")
    public void userClicksOnAppropriateOrderNo(String orderNo) {
        ordersPage.clickOnOrderByOrderNo(orderNo);
        threadVarsHashMap.put(GE_ORDER_NO, orderNo);
    }

    @When("^User clicks on random order No.$")
    public void userClickOnRandomOrderNo() {
        threadVarsHashMap.put(GE_ORDER_NO, ordersPage.userClickOnRandomOrderNo());
    }

}
package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.managers.OrderManager;
import com.geempower.helpers.models.Order;
import com.geempower.storefront.pages.order.OrderDetailsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class OrderDetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private OrderDetailsPage orderDetailsPage;
    @Autowired
    private OrderManager orderManager;

    private final double delta = 0.000001;

    @Then("^Orders Details page is opened.$")
    public void orderDetailsPageIsOpened() {
        assertTrue(orderDetailsPage.isOpened(threadVarsHashMap.get(TestKeyword.GE_ORDER_NO).toString()));
    }

    @Then("^GE Order No. is correct.$")
    public void GeOrderNoIsCorrect() {
        assertEquals(threadVarsHashMap.get(TestKeyword.GE_ORDER_NO), orderDetailsPage.getGeOrderNo());
    }

    @Then("^Total Net Price is equal to Extend Price.$")
    public void totalNetPriceIsEqualToExtendPrice() {
        Order order = orderManager.getOrderById(Long.parseLong((String) threadVarsHashMap.get(TestKeyword.GE_ORDER_NO)));
        assertEquals(order.getFinalOrderPrice(), Double.parseDouble(orderDetailsPage.getTotalNetPrice()), delta);
    }

}

package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.helpers.managers.OrderManager;
import com.geempower.storefront.pages.order.OrdersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.geempower.cucumber.definition_steps.TestKeyword.GE_ORDER_NO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrdersStepDefs extends AbstractStepDefs {
    @Autowired
    private OrdersPage ordersPage;
    @Autowired
    private Utils utils;

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

    @Then("^(.*) message is displayed.$")
    public void openOrderReportMessageIsDisplayed(String openOrderReportText) {
        assertEquals(openOrderReportText, ordersPage.getOpenOrderMessage());
    }

    @When("^User clicks on request open order report icon.$")
    public void userClicksOnRequestOpenOrderReportIcon() {
        ordersPage.clickOnOpenOrderReportWindowButton();
    }

    @Then("^Open Order Report window with appropriate title (.*) opened.$")
    public void openOrderReportWindowWithAppropriateTitleOpened(String openOrderReportWindowTitle) {
        assertEquals(openOrderReportWindowTitle, ordersPage.getOpenOrderReportWindowTitle());
    }

    @And("^User selects (.*) option.$")
    public void userSelectsPricingOption(String pricingOption) {
        ordersPage.selectPricingOption(pricingOption);
    }

    @And("^User clicks on generate now button.$")
    public void userClicksOnGenerateNowButton() {
        ordersPage.clickOnGenerateNowOpenOrderReportButton();
    }

    @Then("^Correct date is displayed in Post date column.$")
    public void correctDateIsDisplayedInPostDateColumn() {
        String postReportDate = ordersPage.getPostReportDate();
        threadVarsHashMap.put(TestKeyword.OPEN_ORDER_REPORT_DATE_CREATION, postReportDate);
        assertTrue(postReportDate.contains(utils.getLocalDateTimeStamp("MM/dd/yyyy")));
    }

    @Then("^Pricing value is the same as (.*).$")
    public void pricingValueIsTheSameAsPricingOption(String pricingOption) {
        assertEquals(pricingOption, ordersPage.getPostReportPricingOption());
    }

    @Then("^Comment is equal to (.*)(.*).$")
    public void commentIsEqualToTheRequestWillBeSentToUserEmail(String commentText, String userEmail) {
        assertEquals(commentText.concat(userEmail), ordersPage.getPostReportComment());
    }

    @When("^User closes the Open Order Report window.$")
    public void userClosesTheOpenOrderReportWindow() {
        ordersPage.closeTheOpenOrdersReportWindow();
    }

    @Then("^Open order report is displayed with appropriate date and time.$")
    public void openOrderReportIsDisplayedWithAppropriateDateAndTime() {
        assertEquals(threadVarsHashMap.get(TestKeyword.OPEN_ORDER_REPORT_DATE_CREATION), ordersPage.getPostReportDate());
    }
}
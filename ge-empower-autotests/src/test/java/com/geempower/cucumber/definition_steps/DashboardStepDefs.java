package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.page_blocks.HeaderBlock;
import com.geempower.storefront.page_blocks.OrderStatusWidget;
import com.geempower.storefront.page_blocks.PriceAndAvailabilityBlock;
import com.geempower.storefront.pages.DashboardPage;
import com.geempower.storefront.pages.order.OrdersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DashboardStepDefs extends AbstractStepDefs {
    @Autowired
    private DashboardPage dashboardPage;
    @Autowired
    private PriceAndAvailabilityBlock priceAndAvailabilityBlock;
    @Autowired
    private OrderStatusWidget orderStatusWidget;
    @Autowired
    private OrdersPage ordersPage;
    @Autowired
    private HeaderBlock headerBlock;

    @And("^Order Status widget is displayed.$")
    public void orderStatusWidgetIsDisplayed() {
        assertTrue(dashboardPage.orderStatusWidgetIsDisplayed());
    }

    @And("^Featured Updates widget is displayed.$")
    public void featuredUpdatesWidgetIsDisplayed() {
        assertTrue(dashboardPage.featuredUpdatesWidgetIsDisplayed());
    }

    @And("^Order Search widget is displayed.$")
    public void orderSearchWidgetIsDisplayed() {
        assertTrue(dashboardPage.orderSearchWidgetIsDisplayed());
    }

    @And("^Price and Availability widget is displayed.$")
    public void priceAndAvailabilityWidgetIsDisplayed() {
        assertTrue(dashboardPage.priceAndAvailabilityWidgetIsDisplayed());
    }

    @And("^Recent Orders widget is displayed.$")
    public void recentOrdersWidgetIsDisplayed() {
        assertTrue(dashboardPage.recentOrdersWidgetIsDisplayed());
    }

    @Then("^Recent Lists widget is displayed.$")
    public void recentListWidgetIsDisplayed() {
        assertTrue(dashboardPage.recentListWidgetIsDisplayed());
    }

    @When("^Click on Skip button.$")
    public void clickOnSkipButton() {
        dashboardPage.skipTrainingLevel();
    }

    @When("^Close cookies pop-up.$")
    public void clickOnCloseCookieButton() {
        dashboardPage.closeCookiesPopUp();
        dashboardPage.waitUntilPageIsFullyLoaded();
    }

    @Then("^Check that Dashboard page is opened.")
    public void isDashboardPageOpened() {
        assertTrue(dashboardPage.isOpened());
    }

    @Then("^Chosen account is displayed in account box on Dashboard page.$")
    public void chosenAccountIsDisplayedInAccountsBoxOnDashboardPage() {
        String chosenAccount = threadVarsHashMap.getString(TestKeyword.CHOSEN_ACCOUNT);
        assertTrue(dashboardPage.isSelectedAccountIsDisplayed().contains(chosenAccount));
    }

    @And("^Click on P&A button.$")
    public void clickOnPAButton() {
        priceAndAvailabilityBlock.clickOnCheckPAButton();
    }

    @When("^User set catalogueNo to Copy & Paste field.$")
    public void userSetCatalogueNoToCopyPasteField() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        priceAndAvailabilityBlock.setCatalogueNoToTheCopyAndPasteField(catalogueNo);
    }

    @When("^User set chosen catalogueNo to the Product Number field.$")
    public void userSetCatalogueNoToProductField() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        priceAndAvailabilityBlock.setCatalogueNoToProductField(catalogueNo);
    }

    @When("^User set (.*) to Product Number field.$")
    public void userSetCatalogueNoToProductField(String catalogNo) {
        priceAndAvailabilityBlock.setCatalogueNoToProductField(catalogNo);
    }

    @And("^Select address from address field.$")
    public void selectAddressFromAddressField() {
        threadVarsHashMap.put(TestKeyword.LA_SHIP_ADDRESS, dashboardPage.selectAddressFromAddressField());
    }

    @And("^Click on Submit button.$")
    public void clickOnSubmitButton() {
        dashboardPage.clickOnSubmitButton();
    }

    @Then("^User is able to use GE site.$")
    public void userIsAbleToUseGESite() {
        dashboardPage.open();
        assertTrue(dashboardPage.isOpened());
    }

    @When("^User add list of (.*) products to the Copy&Paste block.$")
    public void userAddProductsToTheCopyPasteBlock(List<String> products) {
        priceAndAvailabilityBlock.addItemsToTheCopyPasteBlock(products);
    }

    @Then("^(.*) title is displayed in the Order status widget.$")
    public void orderStatusTitleIsDisplayedInTheOrderStatusWidget(String title) {
        assertEquals(title, orderStatusWidget.getWidgetTitle());
    }

    @Then("^(.*) is displayed on the Order status widget.$")
    public void lastOrdersIsDisplayedOnTheOrderStatusWidget(String lastOrdersTitle) {
        assertEquals(lastOrdersTitle, orderStatusWidget.getLastCountOfOrdersTitle());
    }

    @Then("^(.*) has some orders.$")
    public void totalOrdersHasOrders(String totalOrdersStatus) {
        assertEquals(totalOrdersStatus, orderStatusWidget.getTotalOrdersStatus());
        assertTrue(orderStatusWidget.getCountOfTotalOrders() > 1);
    }

    @Then("^(.*) statuses are displayed in appropriates order wrappers.$")
    public void openShippedOnHoldCancelledStatusesAreDisplayedInAppropriatesOrderWrappers(List<String> statuses) {
        assertTrue(statuses.containsAll(orderStatusWidget.getOrderStatusesFromWrappers()));
    }

    @Then("^Total orders count equals to all count of orders in the different statuses.$")
    public void totalOrdersCountEqualsToAllCountOfOrdersInTheDifferentStatuses() {
        threadVarsHashMap.put(TestKeyword.OPENED_ORDERS_IN_ACCOUNT, orderStatusWidget.getOpenedOrdersCount());
        threadVarsHashMap.put(TestKeyword.SHIPPED_ORDERS_IN_ACCOUNT, orderStatusWidget.getShippedOrdersCount());
        threadVarsHashMap.put(TestKeyword.ON_HOLD_ORDERS_IN_ACCOUNT, orderStatusWidget.getOnHoldOrdersCount());
        threadVarsHashMap.put(TestKeyword.CANCELLED_ORDERS_IN_ACCOUNT, orderStatusWidget.getCancelledOrdersCount());
        assertTrue(orderStatusWidget.getCountOfTotalOrders() == orderStatusWidget.getSumOfAllOrdersInDifferentStatuses());
    }

    @When("^Admin clicks on (.*) orders.$")
    public void adminClicksOnAppropriateOrdersByStatus(String orderStatus) {
        orderStatusWidget.openAppropriateListOfOrdersByStatus(orderStatus);
    }

    @Then("^Appropriate count of Opened orders are displayed on the All orders page.$")
    public void appropriateCountOfOpenedOrdersAreDisplayedOnTheAllOrdersPage() {
        assertTrue((int) threadVarsHashMap.get(TestKeyword.OPENED_ORDERS_IN_ACCOUNT) == ordersPage.getActualCountOfOrders());
    }

    @Then("^Appropriate count of Shipped orders are displayed on the All orders page.$")
    public void appropriateCountOfShippedOrdersAreDisplayedOnTheAllOrdersPage() {
        assertTrue((int) threadVarsHashMap.get(TestKeyword.SHIPPED_ORDERS_IN_ACCOUNT) == ordersPage.getActualCountOfOrders());
    }

    @Then("^Appropriate count of On Hold orders are displayed on the All orders page.$")
    public void appropriateCountOfOnHoldOrdersAreDisplayedOnTheAllOrdersPage() {
        assertTrue((int) threadVarsHashMap.get(TestKeyword.ON_HOLD_ORDERS_IN_ACCOUNT) == ordersPage.getActualCountOfOrders());
    }

    @Then("^Appropriate count of Cancelled orders are displayed on the All orders page.$")
    public void appropriateCountOfCancelledOrdersAreDisplayedOnTheAllOrdersPage() {
        assertTrue((int) threadVarsHashMap.get(TestKeyword.CANCELLED_ORDERS_IN_ACCOUNT) == ordersPage.getActualCountOfOrders());
    }

    @And("^Search catalogueNo in the search product field.$")
    public void searchProductInTheSearchProductField() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        headerBlock.setProductToTheSearchProductField(catalogueNo);
        headerBlock.clickOnSearchProductIcon();
    }

    @When("^User create product with: product number (.*), product id(.*) and quantity (\\d+).$")
    public void userCreateProductWithProductRegionProductIdQuantity(String productNo, String id, int quantity) {
        HashMap<Product, Integer> selectedProducts = getSelectedProducts();
        Product product = new Product(productNo, (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION), id);
        selectedProducts.put(product, quantity);
    }

    @When("^User searches order by (.*) orderNo via Order Search field.$")
    public void userSetsOrderNoToTheOrderSearchField(String orderNo) {
        dashboardPage.searchOrderViaOrderSearchField(orderNo);
    }
}
package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.ProductManager;
import com.geempower.helpers.models.*;
import com.geempower.storefront.page_blocks.HeaderBlock;
import com.geempower.storefront.page_blocks.OrderStatusWidget;
import com.geempower.storefront.page_blocks.PriceAndAvailabilityBlock;
import com.geempower.storefront.pages.DashboardPage;
import com.geempower.storefront.pages.order.OrdersPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

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
    @Autowired
    private ProductManager productManager;

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
        assertTrue(dashboardPage.getAccountInfo().contains(chosenAccount));
    }

    @And("^Click on P&A button.$")
    public void clickOnPAButton() {
        priceAndAvailabilityBlock.clickOnCheckPAButton();
    }

    @When("^User set catalogueNo to Copy & Paste field.$")
    public void userSetCatalogueNoToCopyPasteField() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
        priceAndAvailabilityBlock.setCatalogueNoToTheCopyAndPasteField(catalogueNo);
    }

    @When("^User set chosen catalogueNo to the Product Number field.$")
    public void userSetCatalogueNoToProductField() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
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
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
        headerBlock.setProductToTheSearchProductField(catalogueNo);
        headerBlock.clickOnSearchProductIcon();
    }

    @When("^User searches order by (.*) orderNo via Order Search field.$")
    public void userSetsOrderNoToTheOrderSearchField(String orderNo) {
        dashboardPage.searchOrderViaOrderSearchField(orderNo);
    }

    @Then("^T&B Access widget is displayed.")
    public void tBAccessWidgetIsDisplayed() {
        assertTrue(dashboardPage.isTnBWidgetDisplayed());
    }

    @Then("^T&B Access widget title (.*) is correct.$")
    public void tBAccessWidgetTitleIsCorrect(String tAndBTitle) {
        assertEquals(tAndBTitle, dashboardPage.getTnBAccessWidgetTitle());
    }

    @Then("^User clicks on T&B Access button and T&B Access web site is successfully opened in new tab with correct url (.*).$")
    public void tBAccessWebSiteIsSuccessfullyOpenedInNewTabWithCorrectUrl(String tNbUrl) {
        assertTrue(dashboardPage.clickOnTandBAccessButtonAndGetSiteUrl().contains(tNbUrl));
    }

    @Then("^T&B Access widget is not displayed.")
    public void tBAccessWidgetIsNotDisplayed() {
        assertFalse(dashboardPage.isTnBWidgetDisplayed());
    }

    @Then("^(.*) title is displayed in the Featured Updates widget.$")
    public void featuredUpdatesTitleIsDisplayedInTheFeaturedUpdatesWidget(String featuredUpdatesTitle) {
        assertEquals(featuredUpdatesTitle, dashboardPage.getTitleFromFeaturesWidget());
    }

    @Then("^(.*) link is displayed with correct url (.*).$")
    public void viewAllLinkIsDisplayedWithCorrectUrlViewAllUrl(String viewAllLinkName, String viewAllUrl) {
        assertEquals(viewAllLinkName, dashboardPage.getViewAllLinkName());
        assertEquals(viewAllUrl, dashboardPage.getViewAllUrl());
    }

    @Then("^More than (\\d+) features are available in the Featured Updates widget.$")
    public void featuresAreAvailableInTheFeaturedUpdatesWidget(int countOfFeatures) {
        assertTrue(dashboardPage.getCountOfFeatures() > countOfFeatures);
    }

    @When("^User opens account info dropdown.$")
    public void userOpensAccountInfoDropdown() {
        dashboardPage.openAccountInfoDropdown();
    }

    @Then("^Correct count of favorite accounts is displayed in the account info dropdown.$")
    public void correctCountOfFavoriteAccountsIsDisplayedInTheAccountInfoDropdown() {
        int actualFavAccounts = (int) threadVarsHashMap.get(TestKeyword.FAVORITE_ACCOUNTS_COUNT_FAVORITES_TAB);
        assertTrue(dashboardPage.getCountOfFavoriteAccountsInAccountInfoDropdown() == actualFavAccounts + 1);
    }

    @Then("^Previously marked account is displayed in account info dropdown.$")
    public void previouslyMarkedAccountIsDisplayedInAccountInfoDropdown() {
        String previouslyMarkedFavAccount = threadVarsHashMap.getString(TestKeyword.JUST_MARKED_FAVORITE_ACCOUNT);
        assertTrue(dashboardPage.getListOfFavoriteAccountsFromAccountInfoDropdown().stream().anyMatch(account ->
                account.getAttribute("href").contains(previouslyMarkedFavAccount)));
    }

    @Then("^There is no favorite accounts in the account info dropdown.$")
    public void thereIsNoFavoriteAccountsInTheAccountInfoDropdown() {
        assertTrue(dashboardPage.getCountOfFavoriteAccountsInAccountInfoDropdown() == 0);
    }

    @Then("^Previously chosen account is displayed on the account info dropdown.$")
    public void previouslyChosenAccountIsDisplayedOnTheAccountInfoDropdown() {
        assertTrue(dashboardPage.getAccountInfo().contains(String.valueOf(threadVarsHashMap.get(TestKeyword.CHOSEN_FAVORITE_ACCOUNT))));
    }

    @Given("^Select test product for chosen region by catalogNo (.*).$")
    public void selectTestProductForChosenRegionByCatalogNo(String catalogNo) {
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        HashMap<Product, Integer> selectedProducts = getSelectedProducts();
        selectedProducts.put(productManager.getProductWithAllDataByRegionAndCatalogNo(userSessions.getActiveUserSession(), chosenRegion, catalogNo), 0);
        threadVarsHashMap.put(TestKeyword.SELECTED_PRODUCTS, selectedProducts);
    }

    @Then("Is account info drop down message (.*) displayed in red block.")
    public void isAppropriateAccountInfoDropDownMessageDisplayedInRedBlock(String dropDownMessage) {
        assertEquals(dropDownMessage, dashboardPage.getAccountInfoDropDownMessageInRedBlock());
    }

    @Then("^Is red triangle icon displayed near account no.$")
    public void isRedTriangleIconDisplayedNearAccountNo() {
        assertTrue(dashboardPage.isRedTriangleIconDisplayedNearAccountNo());
    }

    @Then("^Is title (.*) in expired tax pop up displayed.$")
    public void isExpiredTaxCertificateWithTitleDisplayed(String title) {
        assertTrue(dashboardPage.isExpiredTaxCertPopUpDisplayed());
        assertEquals(title, dashboardPage.getExpiredTaxCertPopUpTitle());
    }

    @When("^User clicks on HERE link.$")
    public void userClicksOnHereLink() {
        dashboardPage.userClicksOnHereLink();
    }

    @Then("^Is header text (.*), middle text (.*) and bottom text (.*) displayed in expired TAX Certificate pop up.$")
    public void isMainTextDisplayedInExpiredTAXCertificatePopUp(String mainText, String middleText, String bottomText) {
        assertTrue(dashboardPage.getMainTextInExpiredTAXCertificatePopUp().contains(mainText));
        assertTrue(dashboardPage.getMainTextInExpiredTAXCertificatePopUp().contains(middleText));
        assertTrue(dashboardPage.getMainTextInExpiredTAXCertificatePopUp().contains(bottomText));
    }

    @When("^User clicks on Dismiss button.$")
    public void userClicksOnDismissButton() {
        dashboardPage.userClicksOnDismissButton();
    }

    @Then("^Is expired tax pop up not displayed.$")
    public void isExpiredTaxPopUpNotDisplayed() {
        assertFalse(dashboardPage.isExpiredTaxCertPopUpDisplayed());
    }

    @Then("^AVR widget is displayed on the Dashboard page.$")
    public void avrWidgetIsDisplayedOnTheDashboardPage() {
        assertTrue(dashboardPage.isAvrWidgetDisplayed());
    }

    @Then("^(.*) title is displayed for AVR widget.$")
    public void volumeRebateAVRTitleIsDisplayedForAVRWidget(String avrTitle) {
        assertEquals(avrTitle, dashboardPage.getAvrWidgetTitle(), "AVR Titles are not equal.");
    }

    @Then("^Currency has correct value (.*) label.$")
    public void currencyHasCorrectValueValuesInEURLabel(String currencyLabel) {
        assertEquals(currencyLabel, dashboardPage.getAvrCurrencyLabel(), "AVR Currency are not equal.");
    }

    @And("^Minimal count of AVRs is stored to the threadVarsHashmap.$")
    public void countOfAVRsIsStoredToTheThreadVarsHashmap() {
        threadVarsHashMap.put(TestKeyword.MINIMAL_COUNT_OF_AVR_ON_DASHBOARD, dashboardPage.getMinCountOfAvrs());
    }

    @Then("^Rebate company name is displayed correctly.$")
    public void rebateCompanyNameIsDisplayedCorrectly() {
        String rebateCompanyName = dashboardPage.getAvrRebateCompanyName();
        assertTrue(rebateCompanyName.startsWith("AVR: 003000"));
        assertTrue(rebateCompanyName.contains("|"));
        assertTrue(rebateCompanyName.endsWith("2018"));
    }

    @Then("^(.*) current payout is displayed on the AVR widget.$")
    public void currentPayoutIsDisplayedOnTheAVRWidget(String currentPayoutTitle) {
        assertEquals(currentPayoutTitle, dashboardPage.isCurrentPayoutDisplayed());
    }

    @Then("^(.*) current volume is displayed on the AVR widget.$")
    public void currentVolumeIsDisplayedOnTheAVRWidget(String currentVolumeTitle) {
        assertEquals(currentVolumeTitle, dashboardPage.isCurrentVolumeDisplayed());
    }

    @Then("^(.*) ytd volume is displayed on the AVR widget.$")
    public void ytdVolumeIsDisplayedOnTheAVRWidget(String ytdVolumeTitle) {
        assertEquals(ytdVolumeTitle, dashboardPage.isYtdPayoutDisplayed());
    }

    @Then("^YTD Payout value is equal to Current volume.$")
    public void ytdPayoutValueIsEqualToCurrentVolume() {
        assertEquals(dashboardPage.getYtdPayout(), dashboardPage.getCurrentVolume());
    }

    @Then("^AVR type description is correct for each avr on the dashboard.$")
    public void avrTypeLabelIsCorrect() {
        for (int i = 1; i <= dashboardPage.getMinCountOfAvrs(); i++) {
            dashboardPage.selectAppropriateAvr(i);
            assertTrue(AVRType.getAVRTypes().stream().map(avrType -> avrType.getAvrTypeDescription()).collect(Collectors.toList()).contains(dashboardPage.getAvrTypeDescriptionWithoutPercentage(i)));
        }
    }

    @Then("^Next target label is correct for each avr on the dashboard.$")
    public void nextTargetValueIsCorrectForEachAvrOnTheDashboard() {
        for (int i = 1; i <= dashboardPage.getMinCountOfAvrs(); i++) {
            dashboardPage.selectAppropriateAvr(i);
            assertTrue(AVRTarget.getAVRTargets().stream().map(avrTarget -> avrTarget.getAvrTargetDescription()).collect(Collectors.toList()).contains(dashboardPage.getAvrTargetDescriptionWithoutPrice(i)));
        }
    }

    @When("^User clicks on active AVR.$")
    public void userClicksOnActiveOfTheAVR() {
        dashboardPage.clickToTheActiveAvrLink();
    }

    @Then("^(.*) AVR section is displayed in the header menu.$")
    public void avrSectionIsDisplayedInTheHeaderMenu(String sectionName) {
        assertTrue(headerBlock.isSectionAvailableToUser(sectionName));
    }
}
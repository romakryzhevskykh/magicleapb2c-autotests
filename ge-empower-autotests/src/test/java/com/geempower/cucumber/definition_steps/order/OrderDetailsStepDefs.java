package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.helpers.managers.OrderManager;
import com.geempower.helpers.managers.ProductManager;
import com.geempower.helpers.models.Order;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.order.OrderDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.geempower.cucumber.definition_steps.TestKeyword.GE_ORDER_NO;
import static org.testng.Assert.*;

public class OrderDetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private OrderDetailsPage orderDetailsPage;
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private Utils utils;

    private final double delta = 0.000001;

    @Then("^Orders Details page is opened.$")
    public void orderDetailsPageIsOpened() {
        assertTrue(orderDetailsPage.isOpened(threadVarsHashMap.get(TestKeyword.GE_ORDER_NO).toString()));
    }

    @Then("^GE Order No. is correct.$")
    public void geOrderNoIsCorrect() {
        assertEquals(threadVarsHashMap.get(TestKeyword.GE_ORDER_NO), orderDetailsPage.getGeOrderNo());
    }

    @Then("^Total Net Price is equal to Extend Price.$")
    public void totalNetPriceIsEqualToExtendPrice() {
        Order order = orderManager.getOrderById(Long.parseLong((String) threadVarsHashMap.get(TestKeyword.GE_ORDER_NO)));
        assertEquals(order.getFinalOrderPrice(), Double.parseDouble(orderDetailsPage.getTotalNetPrice()), delta);
    }

    @And("^Expands the order details area.$")
    public void expandsTheOrderDetailsArea() {
        orderDetailsPage.clickOnExpandOrderDetailsIcon();
    }

    @And("^Clicks on Invoice hyperlink.$")
    public void clicksOnInvoiceHyperlink() {
        orderDetailsPage.clickOnInvoiceHyperlink();
    }

    @Then("^(.*) pop-up is appear with correct text and header.$")
    public void invoiceDetailsPopUpIsAppearWithCorrectTextAndHeader(String popUpHeader) {
        assertTrue(orderDetailsPage.isPopUpAppears());
        assertEquals(popUpHeader, orderDetailsPage.getInvoiceDetailsPopUpHeader());
        assertTrue(orderDetailsPage.getPopUpBodyText().contains("For Invoice copy, please take it from") && orderDetailsPage.getPopUpBodyText().contains("logging in with your credentials. In case of any questions, please contact Customer Service"));
    }

    @And("^Admin closes the pop-up.$")
    public void adminClosesThePopUp() {
        orderDetailsPage.closeInvoiceDetailsPopUp();
    }

    @Then("^Tracking information is (.*).$")
    public void trackingInformationIsMultiple(String fieldName) {
        assertEquals(fieldName, orderDetailsPage.getTrackingInformationData());
    }


    @When("^User clicks on Multiple hyperlink.$")
    public void userClicksOnMultipleHyperlink() {
        orderDetailsPage.clickOnMultipleHyperlink();
    }

    @Then("^(.*) pop-up appears.$")
    public void bolAndTrackingNumbersPopUpAppears(String popUpTitle) {
        assertEquals(popUpTitle, orderDetailsPage.getBolAndTrackingNumbersPopUpTitle());
    }

    @Then("^More than one BOL are displayed in the pop-up.$")
    public void moreThanOneBOLAreDisplayedInThePopUp() {
        assertTrue(orderDetailsPage.getCountOfBillsInBOLPopUp() > 1);
    }

    @When("^User expands order details section.$")
    public void userExpandsOrderDetailsSection() {
        orderDetailsPage.expandFirstLineOrderDetails();
    }

    @Then("^Bill of landing is (.*).$")
    public void billOfLandingIsMultiple(String fieldName) {
        assertEquals(fieldName, orderDetailsPage.getBOLInformationData());
    }

    @When("^User clicks on Multiple hyperlink on BOL.$")
    public void userClicksOnMultipleHyperlinkOnBOL() {
        orderDetailsPage.clickOnBOLHyperlink();
    }

    @And("^User closes BOL and Tracking Numbers pop-up.$")
    public void userClosesBOLAndTrackingNumbersPopUp() {
        orderDetailsPage.closeBOLPopUp();
    }

    private void createOrderInstance() {
        long orderNo = Long.parseLong(threadVarsHashMap.getString(GE_ORDER_NO));
        String catalogNo = orderDetailsPage.getRandomCatalogNo();
        int quantity = Integer.parseInt(orderDetailsPage.getQuantityOfSelectedCatalogNoCheckbox(catalogNo));
        orderManager.createOrderInstance(orderNo, catalogNo, quantity);
    }

    @When("^User selects random catalog No checkbox on Orders Details page.$")
    public void userSelectsCatalogNoCheckboxOnOrdersDetailsPage() {
        createOrderInstance();
        Order randomOrder = orderManager.getOrderById(Long.parseLong(threadVarsHashMap.getString(GE_ORDER_NO)));
        orderDetailsPage.selectRandomCheckboxCatalogNo(randomOrder.getCatalogNo());
    }

    @And("^User clicks on Reorder button on Order Details page.$")
    public void userClicksOnAddToCartButtonOnOrderDetailsPage() {
        orderDetailsPage.clickOnAddToCartButtonOnOrderDetailsPage();
    }

    private ArrayList<Product> createProductsListInstance() {
        int productListSize = orderDetailsPage.getListOfCatalogNo().size();
        for (int i = 1; i <= productListSize; i++) {
            String catalogNo = orderDetailsPage.getCatalogNoByRow(String.valueOf(i));
            String description = orderDetailsPage.getDescriptionByRow(String.valueOf(i));
            productManager.createInstance(catalogNo, description);
        }
        return productManager.getProductsList();
    }

    @And("^User clicks on random status box.$")
    public void userClicksOnRandomStatusBox() {
        long orderNo = Long.parseLong(threadVarsHashMap.getString(GE_ORDER_NO));
        double totalNetPrice = Double.parseDouble(orderDetailsPage.getTotalNetPrice());
        orderManager.createOrderInstance(orderNo, totalNetPrice, createProductsListInstance());
        orderDetailsPage.userClicksOnRandomStatusBox();
    }

    @And("^User clicks on All status box.$")
    public void userClicksOnAllStatusBox() {
        orderDetailsPage.userClicksOnAllStatusBox();
    }

    @Then("^Is Total Net Price value correct after changing status boxes.$")
    public void isTotalNetPriceValueCorrectAfterChangingStatusBoxes() {
        double totalNetPrice = orderManager.getOrderById(Long.parseLong(threadVarsHashMap.getString(GE_ORDER_NO))).getTotalNetPrice();
        assertEquals(totalNetPrice, Double.parseDouble(orderDetailsPage.getTotalNetPrice()));
    }

    @Then("^Is Table with products displayed.$")
    public void isTableWithProductsDisplayed() {
        assertTrue(orderDetailsPage.isTableWithProductsDisplayed());
    }

    @When("^User expands Quote Details block.$")
    public void userExpandsQuoteDetailsBlock() {
        orderDetailsPage.userExpandsQuoteDetailsBlock();
    }

    @Then("^Is (.*) label contains date in Quote Details block.$")
    public void isOrderedRequestedOnLabelContainsDate(String label) {
        assertTrue(utils.isValidDate(orderDetailsPage.getLabelValueInQuoteDetailsBlock(label)));
    }

    @Then("^Is (.*) label contains (.*) value in Quote Details block.$")
    public void isOrderValueAndTaxTotalContainsUSDValue(String label, String currency) {
        assertTrue(orderDetailsPage.getLabelValueInQuoteDetailsBlock(label).contains(currency));
    }

    @Then("^Is (.*) label contains value in Quote Details block.$")
    public void isLabelContainsValue(String label) {
        assertFalse(orderDetailsPage.getLabelValueInQuoteDetailsBlock(label).isEmpty());
    }

    @Then("^Is (.*) label contains (.*) email character in Quote Details block.$")
    public void isCreatedByLabelContainsEmailCharacter(String label, String emailCharacter) {
        assertTrue(orderDetailsPage.getLabelValueInQuoteDetailsBlock(label).contains(emailCharacter));
    }

    @Then("^Is (.*) and (.*) labels displayed in Quote Details block.$")
    public void isUserNoAndQuoteNoLabelsDisplayed(String userNoLabel, String quoteNoLabel) {
        assertTrue(orderDetailsPage.isLabelInQuoteDetailsBlockDisplayed(userNoLabel));
        assertTrue(orderDetailsPage.isLabelInQuoteDetailsBlockDisplayed(quoteNoLabel));
    }

    @And("^User closes Quote Details block.$")
    public void userClosesQuoteDetailsBlock() {
        orderDetailsPage.userClosesQuoteDetailsBlock();
    }

    @When("^User expands/closes status boxes.$")
    public void userExpandsClosesStatusBoxes() {
        orderDetailsPage.userExpandsClosesStatusBoxes();
    }

    @Then("^Is (.*) .(.*) title displayed near reorder button.$")
    public void isSelectItemsAndAddToCartNewTitleDisplayedNearReorderButton(String firstPart, String secondPart) {
        assertEquals(firstPart, orderDetailsPage.getSelectItemsTextFirstPart());
        assertEquals(secondPart, orderDetailsPage.getSelectItemsTextSecondPart());
    }

    @Then("^Is Opened Quote Details (.*) is displayed.$")
    public void isOpenedQuoteDetailsBlockIsDisplayed(String block) {
        assertTrue(orderDetailsPage.getBottomRowInDetailsQuotesBlock().getAttribute("style").contains(block));
    }

    @Then("^Is Opened Quote Details (.*) is not displayed.$")
    public void isOpenedQuoteDetailsBlockIsNotDisplayed(String block) {
        assertFalse(orderDetailsPage.getBottomRowInDetailsQuotesBlock().getAttribute("style").contains(block));
    }

    @Then("^Is Expanded status box line displayed.$")
    public void isExpandedStatusBoxLineDisplayed() {
        assertTrue(orderDetailsPage.isExpandedStatusBoxLineDisplayed());
    }

    @Then("^Is Expanded status box line not displayed.$")
    public void isExpandedStatusBoxLineNotDisplayed() {
        assertFalse(orderDetailsPage.isExpandedStatusBoxLineDisplayed());
    }

    @Then("Is Correct (.*) statuses displayed in the status boxes.")
    public void isCorrectStatusesDisplayedInTheStatusBoxes(List<String> statuses) {
        assertTrue(orderDetailsPage.getAllStatusesInStatusBoxes().containsAll(statuses));
    }

    @Then("^Is Correct time statuses (.*) displayed near color status icons.$")
    public void isCorrectTimeStatusesListDisplayedNearColorStatusIcons(List<String> timeStatuses) {
        assertTrue(orderDetailsPage.getAllTimeStatusNearColorIcons().containsAll(timeStatuses));
    }

    @When("^User clicks on time status drop down field.$")
    public void userClicksOnTimeStatusDropDownField() {
        orderDetailsPage.userClicksOnTimeStatusDropDownField();
    }

    @Then("^Is Correct time statuses (.*) displayed in the time status drop down field.$")
    public void isCorrectTimeStatusesDisplayedInTheTimeStatusDropDownField(List<String> timeStatuses) {
        assertTrue(orderDetailsPage.getAllTimeStatusesInTimeStatusDropDown()
                .allMatch(statuses -> timeStatuses.stream().anyMatch(timeStatus -> statuses.getText().contains(timeStatus))));
    }

    @Then("^Is Detail Order table contains correct header (.*) titles.$")
    public void isDetailOrderTableContainsCorrectHeaderTableTitlesTitles(List<String> tableTitles) {
        orderDetailsPage.getAllDetailOrderTableHeaders().containsAll(tableTitles);
    }

    @When("^User opens random product detail block.$")
    public void userOpensRandomProductDetailBlock() {
        orderDetailsPage.userOpensRandomProductDetailBlock();
    }

    @When("^User closes opened product detail block.$")
    public void userClosesOpenedProductDetailBlock() {
        orderDetailsPage.userClosesOpenedProductDetailBlock();
    }

    @Then("^Is (.*) label contains value in Product Details block.$")
    public void isLabelContainsValueInProductDetailsBlock(String label) {
        assertFalse(orderDetailsPage.getLabelValueInProductDetailsBlock(label).isEmpty());
    }

    @Then("^Is (.*) label contains date in Product Details block.$")
    public void isRequestedDateLabelContainsDateInProductDetailsBlock(String label) {
        assertTrue(utils.isValidDate(orderDetailsPage.getLabelValueInProductDetailsBlock(label)));
    }

    @Then("^Is Correct (.*) labels displayed in Product Details block.$")
    public void isCorrectProductDetailLabelsDisplayedInProductDetailsBlock(List<String> productDetailLabels) {
        orderDetailsPage.getAllProductDetailLabels().containsAll(productDetailLabels);
    }

    @Then("^Is Total Net Price value is equal to sum of all ext. price in table.$")
    public void isTotalNetPriceValueIsEqualToSumOfAllExtPriceInTable() {
        assertEquals(Double.parseDouble(orderDetailsPage.getTotalNetPrice()), orderDetailsPage.getSumOfAllExtPrice(), delta);
    }

    @Then("^Tracking information has (.*) values.$")
    public void trackingInformationHasMULTIPLEValues(String trackingInfoValue) {
        assertEquals(trackingInfoValue, orderDetailsPage.getTrackingInformationData());
    }

    @When("^User clicks on tracking info hyperlink.$")
    public void userClicksOnTrackingInfoHyperlink() {
        orderDetailsPage.clickOnTrackingInfoHyperLink();
    }

    @When("^User click on random tracking number.$")
    public void userClickOnRandomTrackingNumber() {
        orderDetailsPage.clickOnRandomTrackingNumber();
    }

    @Then("^Tracking details slider appears.$")
    public void trackingDetailsSliderAppears() {
        assertTrue(orderDetailsPage.isTrackingSliderDisplayed());
    }

    @Then("^Tracking details slider contains all necessary texts and icons (.*), (.*), (.*), (.*), (.*).$")
    public void trackingDetailsSliderContainsAllNecessaryTextsAndIcons(String title, String errorMessage, String status1, String status2, String status3) {
        assertEquals(title, orderDetailsPage.getSliderTitle());
        assertEquals(errorMessage, orderDetailsPage.getTrackingErrorMessage());
        assertTrue(orderDetailsPage.getLineNoDetails().contains("Line No."));
        assertTrue(orderDetailsPage.getLineNoDetails().contains(orderDetailsPage.getRandomCatalogNo()));
        assertTrue(orderDetailsPage.areAllProgressBarsDisplayed());
        assertTrue(orderDetailsPage.isExclamationMarkIconDisplayed());
        assertEquals(orderDetailsPage.getShipmentInfoSentStatusText(), status1);
        assertEquals(orderDetailsPage.getDeliveredStatusText(), status3);
        assertEquals(orderDetailsPage.getInTransitStatusText(), status2);
    }

    @When("^User goes to the next Tracking Details.$")
    public void userGoesToTheNextTrackingDetails() {
        orderDetailsPage.goToTheNextTrackingInfo();
    }

    @When("^User goes to the previous Tracking Details.$")
    public void userGoesToThePreviousTrackingDetails() {
        orderDetailsPage.goToThePreviousTrackingInfo();
    }
}
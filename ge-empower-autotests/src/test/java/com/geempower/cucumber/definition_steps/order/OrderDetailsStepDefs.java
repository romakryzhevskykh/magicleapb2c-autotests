package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.managers.OrderManager;
import com.geempower.helpers.managers.ProductManager;
import com.geempower.helpers.models.Order;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.order.OrderDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.stream.Stream;

import static com.geempower.cucumber.definition_steps.TestKeyword.GE_ORDER_NO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderDetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private OrderDetailsPage orderDetailsPage;
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private ProductManager productManager;

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
        for (int i = 1; i <= productListSize; i++){
            String catalogNo = orderDetailsPage.getCatalogNoByRow(String.valueOf(i));
            String description  = orderDetailsPage.getDescriptionByRow(String.valueOf(i));
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
}
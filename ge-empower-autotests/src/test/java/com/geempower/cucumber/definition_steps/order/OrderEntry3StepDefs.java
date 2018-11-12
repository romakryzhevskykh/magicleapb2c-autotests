package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.helpers.managers.OrderManager;
import com.geempower.helpers.models.Order;
import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.pages.order.OrderEntry3Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static com.geempower.cucumber.definition_steps.TestKeyword.GE_ORDER_NO;
import static org.testng.Assert.*;

public class OrderEntry3StepDefs extends AbstractStepDefs {
    @Autowired
    private OrderEntry3Page orderEntry3Page;
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private Utils utils;

    private static double delta = 0.0001;

    private HashMap<String, String> shippingNotes = new HashMap<>();

    @Then("^Order Summary step is opened.$")
    public void orderSummaryStepIsOpened() {
        assertTrue(orderEntry3Page.isOrderSummaryStepOpened());
    }

    @Then("^PO no. is correct at the OE 3 page.$")
    public void poNoIsCorrect() {
        assertEquals(threadVarsHashMap.get(TestKeyword.PO_NO), orderEntry3Page.getPoNoFromOrderSummary());
    }

    @When("^User clicks on Place Order button at the OE 3 page.$")
    public void userClicksOnPlaceOrderButton() {
        orderEntry3Page.clickOnThePlaceOrderButton();
    }

    @And("^Terms and Conditions pop-up is confirmed.$")
    public void termsAndConditionsPopUpIsConfirmed() {
        orderEntry3Page.submitTermsAndConditions();
    }

    @SuppressWarnings("unchecked")
    @Then("^(.*) pop-up appears at the OE 3 page.$")
    public void orderSuccessfulPopUpAppears(String title) {
        String orderNo = orderEntry3Page.getGEOrderNoFromOrderSuccessPopUp(title);
        HashMap<Product, Integer> selectedProducts = getSelectedProducts();

        if (!shippingNotes.isEmpty() && !selectedProducts.isEmpty()) {
            createOrderInstance(orderNo, shippingNotes);
        } else if (!selectedProducts.isEmpty()) {
            createOrderInstance(orderNo);
        } else if (!threadVarsHashMap.getString(GE_ORDER_NO).isEmpty()) {
            Order randomOrder = orderManager.getOrderById(Long.parseLong(threadVarsHashMap.getString(GE_ORDER_NO)));
            createOrderInstance(orderNo, randomOrder.getCatalogNo(), randomOrder.getQuantity());
        }
        threadVarsHashMap.put(TestKeyword.GE_ORDER_NO, orderNo);
    }

    private void createOrderInstance(String orderNo) {
        HashMap<Product, Integer> selectedProducts = getSelectedProducts();
        orderManager.createOrderInstance(Long.parseLong(orderNo), selectedProducts);
    }

    private void createOrderInstance(String orderNo, HashMap<String, String> shippingNotes) {
        HashMap<Product, Integer> selectedProducts = getSelectedProducts();
        orderManager.createOrderInstance(Long.parseLong(orderNo), selectedProducts, shippingNotes);
    }

    private void createOrderInstance(String orderNo, String catalogNo, int quantity) {
        orderManager.createOrderInstance(Long.parseLong(orderNo), catalogNo, quantity);
    }

    @When("^User closes the pop-up.$")
    public void userClosesThePopUp() {
        orderEntry3Page.closeOrderConfirmationPopUp();
    }

    @SuppressWarnings("unchecked")
    @Then("^All necessary elements are displayed on the Product Details block at OE 3 page.$")
    public void allNecessaryElementsAreDisplayedOnTheProductDetailsBlock() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            assertEquals(product.getCatalogNo().toUpperCase(), orderEntry3Page.getCatalogNoFromTheProductDetailsBlock());
            assertEquals(product.getDescription(), orderEntry3Page.getDescriptionFromTheProductDetailsBlock());
            int quantity = selectedProducts.get(product);
            assertTrue(quantity == orderEntry3Page.getQuantityFromTheProductDetailsBlock());
            assertEquals((Double.parseDouble(product.getFinalNetPrice()) * quantity), orderEntry3Page.getExtendedPriceFromTheProductDetailsBlock(), delta);
            assertTrue(orderEntry3Page.getCurrencyFromTheProductDetailsBlock().length() > 0);
            assertEquals(orderEntry3Page.getEstDeliveryDateFromTheProductDetailsBlock(), orderEntry3Page.getReqDeliveryDateFromTheProductDetailsBlock());
        });
    }

    @Then("^All necessary elements are displayed on the Address Details block at OE 3 page.$")
    public void allNecessaryElementsAreDisplayedOnTheAddressDetailsBlockAtOE3Page() {
        assertTrue(orderEntry3Page.addressDetailsHeaderIsDisplayed());
        assertTrue(orderEntry3Page.shipmentAddressTitleIsDisplayed());
        assertEquals(threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS), orderEntry3Page.getShipmentAddressData());
    }

    @Then("^All necessary elements are displayed on the Shipment Details block at OE 3 page.$")
    public void allNecessaryElementsAreDisplayedOnTheShipmentDetailsBlockAtTheOE3Page() {
        assertTrue(orderEntry3Page.shipmentDetailsHeaderIsDisplayed());
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        if (!chosenRegion.getRegionType().getRegionName().equals("ASIA") &&
                (!chosenRegion.getRegionType().getRegionName().equals("EMEA"))) {
            assertTrue(orderEntry3Page.shipPaymentMethodTitleIsDisplayed());
        }
        assertTrue(orderEntry3Page.shippingNoteTitleIsDisplayed());
        assertTrue(orderEntry3Page.shipMethodTitleIsDisplayed());
        assertTrue(orderEntry3Page.requestedDeliveryDateTitleIsDisplayed());
        assertTrue(orderEntry3Page.partiallyShipmentAcceptedTitleIsDisplayed());
        assertTrue(orderEntry3Page.acceptEarlyDeliveryTitleIsDisplayed());
    }

    @Then("^All necessary elements are displayed on the Order Summary block on at OE 3 page.$")
    public void allNecessaryElementsAreDisplayedOnTheOrderSummaryBlockOnAtOEPage() {
        assertTrue(orderEntry3Page.orderSummaryTitleIsDisplayed());
        assertTrue(orderEntry3Page.orderNoteTitleIsDisplayed());
        assertTrue(orderEntry3Page.poNoTitleIsDisplayed());
        assertTrue(orderEntry3Page.jobNameTitleIsDisplayed());
        assertTrue(orderEntry3Page.payerTitleIsDisplayed());
        assertFalse(orderEntry3Page.payerInfoIsEmpty());
    }

    @Then("^Payer and Shipment Addresses are correct at the OE 3 page.$")
    public void payerAndShipmentAddressesAreCorrectAtTheOE3Page() {
        String shipmentAddress = (String) threadVarsHashMap.get(TestKeyword.LA_SHIP_ADDRESS);
        assertEquals(shipmentAddress, orderEntry3Page.getPayerAddress());
        assertEquals(shipmentAddress, orderEntry3Page.getShipmentAddress());
    }

    @Then("^Is (.*) blue block message displayed on the OE 3 page.$")
    public void isBlueBlockMessageDisplayedOnTheOE3Page(String text) {
        assertEquals(text, orderEntry3Page.getClaimbackMessageInBlueBlockOnOE3Page());
    }

    @Then("^Is Claimback icon displayed in Extended Price cell on the OE 3 page.$")
    public void isClaimbackIconDisplayedInExtendedPriceCellOnThe3OEPage() {
        assertTrue(orderEntry3Page.isClaimbackIconInExtndPriceCellOE3PageDisplayed());
    }

    @When("^Click on (.*) link on the OE 3 page.$")
    public void clickOnProductLinkOnThe3OEPage(String product) {
        orderEntry3Page.clickOnProductLinkOnOE3Page(product);
    }

    @Then("^Is Correct Country of Origin value is displayed on the OE 3 page.$")
    public void isCorrectCountryOfOriginValueIsDisplayedOnTheOEPage() {
        String countryHashmap = threadVarsHashMap.getString(TestKeyword.COUNTRY_OF_ORIGIN_CELA_PRODUCT);
        assertEquals(countryHashmap, orderEntry3Page.getCountryOfOriginValueOnOE3Page());
    }

    @Then("^Is Correct Shipping note displayed in Shipments Details block.$")
    @SuppressWarnings("unchecked")
    public void isCorrectShippingNoteDisplayedInShipmentsDetailsBlock() {
        shippingNotes = (HashMap<String, String>) threadVarsHashMap.get(TestKeyword.SHIPPING_NOTE);
        assertEquals(shippingNotes.get("shipDetails"), orderEntry3Page.getShippingNoteValueInShipmentDetailsBlock());
    }

    @Then("^Change Shipping note for the catalog No.$")
    public void isCorrectShippingNoteDisplayedForTheCatalogNoCatalogNo() {
        String timestamp = utils.generateUniqueTimestamp();
        setShippingNoteValueToTheCatalogNoOnOE3Step(timestamp);
        shippingNotes.put("note", timestamp);
    }

    private void setShippingNoteValueToTheCatalogNoOnOE3Step(String timestamp) {
        String catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
        orderEntry3Page.clickOnThreeDotIconOnOE3Page(catalogNo);
        orderEntry3Page.clickOnAddEditShippingNotePopUpButton();
        orderEntry3Page.changeShippingNoteValue(timestamp);
        orderEntry3Page.clickOnSaveButtonInAddEditShipNotePopUp();
    }
}
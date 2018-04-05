package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.pages.OrderEntry3Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.*;

public class OrderEntry3StepDefs extends AbstractStepDefs {
    @Autowired
    private OrderEntry3Page orderEntry3Page;

    private static double delta = 0.0001;

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
    public void termsAndConditionsPopUpIsConfirmed() throws Throwable {
        orderEntry3Page.submitTermsAndConditions();
    }

    @Then("^(.*) pop-up appears at the OE 3 page.$")
    public void orderSuccessfulPopUpAppears(String title) throws Throwable {
        threadVarsHashMap.put(TestKeyword.GE_ORDER_NO, orderEntry3Page.getGEOrderNoFromOrderSuccessPopUp(title));
    }

    @When("^User closes the pop-up.$")
    public void userClosesThePopUp() {
        orderEntry3Page.closeOrderConfirmationPopUp();
    }

    @Then("^All necessary elements are displayed on the Product Details block at OE 3 page.$")
    public void allNecessaryElementsAreDisplayedOnTheProductDetailsBlock() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            assertEquals(product.getCatalogueNo().toUpperCase(), orderEntry3Page.getCatalogNoFromTheProductDetailsBlock());
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
}

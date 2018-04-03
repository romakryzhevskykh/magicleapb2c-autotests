package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.OrderEntry2Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderEntry2StepDefs extends AbstractStepDefs {
    @Autowired
    private OrderEntry2Page orderEntry2Page;

    private final double delta = 0.0001;

    @When("^User fills PO no.$")
    public void userFillsPONo() {
        threadVarsHashMap.put(TestKeyword.PO_NO, orderEntry2Page.fillUniquePoNo());
    }

    @And("^Select Shipment Address.$")
    public void selectShipmentAddress() {
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, orderEntry2Page.chooseAppropriateAddressFromTheShippingAddressList());
    }

    @Then("^Selected Shipment address is equal to Ship to field value.$")
    public void selectedShipmentAddressIsEqualToShipToFieldValue() {
        assertEquals(threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS), orderEntry2Page.getShipToValue());
    }

    @When("^User clicks on the Bottom Next button.$")
    public void userClicksOnTheBottomNextButton() {
        orderEntry2Page.clickOnTheNextBottomButton();
    }

    @Then("^All necessary elements are displayed on the Product Details block.$")
    public void allNecessaryElementsAreDisplayedOnTheProductDetailsBlock() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            assertEquals(product.getCatalogueNo().toUpperCase(), orderEntry2Page.getCatalogNoFromTheProductDetailsBlock());
            assertEquals(product.getDescription(), orderEntry2Page.getDescriptionFromTheProductDetailsBlock());
            int quantity = selectedProducts.get(product);
            assertTrue(quantity == orderEntry2Page.getQuantityFromTheProductDetailsBlock());
            assertEquals((Double.parseDouble(product.getFinalNetPrice()) * quantity), orderEntry2Page.getExtendedPriceFromTheProductDetailsBlock(), delta);
            assertTrue(orderEntry2Page.getCurrencyFromTheProductDetailsBlock().length() > 0);
            assertEquals(orderEntry2Page.getEstDeliveryDateFromTheProductDetailsBlock(), orderEntry2Page.getReqDeliveryDateFromTheProductDetailsBlock());
        });
    }

    @Then("^Shipping And Billing step is opened.$")
    public void shippingAndBillingStepTitleIsOpen() {
        assertTrue(orderEntry2Page.shippingAndBillingStepTitleIsDisplayed());
    }

    @Then("^All necessary elements are displayed on the Order Details block at OE 2 page.$")
    public void allNecessaryElementsAreDisplayedOnTheOrderDetailsBlock() {
        assertTrue(orderEntry2Page.orderDetailsHeaderIsDisplayed());
        assertTrue(orderEntry2Page.jobNameFieldIsDisplayed());
        assertTrue(orderEntry2Page.payerTitleIsDisplayed());
    }

    @Then("^All necessary elements are displayed on the Address Details block at OE 2 page.$")
    public void allNecessaryElementsAreDisplayedOnTheAddressDetailsBlockAtOEPage() {
        assertTrue(orderEntry2Page.addressDetailsHeaderIsDisplayed());
        assertTrue(orderEntry2Page.manageAddressButtonIsDisplayed());
        assertTrue(orderEntry2Page.shipmentAddressTitleIsDisplayed());
    }

    @Then("^All necessary elements are displayed on the Shipment Details block at OE 2 page.$")
    public void allNecessaryElementsAreDisplayedOnTheShipmentDetailsBlockAtOEPage() {
        assertTrue(orderEntry2Page.shipmentDetailsHeaderIsDisplayed());
        assertTrue(orderEntry2Page.shipPaymentMethodTitleIsDisplayed());
        assertTrue(orderEntry2Page.shippingNoteTitleIsDisplayed());
        assertTrue(orderEntry2Page.shipMethodTitleIsDisplayed());
        assertTrue(orderEntry2Page.requestedDeliveryDateTitleIsDisplayed());
        assertTrue(orderEntry2Page.partiallyDeliveryTitleTitleIsDisplayed());
        assertTrue(orderEntry2Page.requestedDeliveryTitleTitleIsDisplayed());
    }
}


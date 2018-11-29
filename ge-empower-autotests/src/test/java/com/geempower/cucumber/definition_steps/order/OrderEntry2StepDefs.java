package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.page_blocks.ShortProductDetailsPopUpBlock;
import com.geempower.storefront.pages.order.OrderEntry2Page;
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

    @Autowired
    private ShortProductDetailsPopUpBlock shortProductDetailsPopUpBlock;

    @Autowired
    private Utils utils;

    private final double delta = 0.0001;

    @When("^User fills PO no. to the PO no. field on the OE 2 page.$")
    public void userFillsPONoOnOE2Page() {
        threadVarsHashMap.put(TestKeyword.PO_NO, orderEntry2Page.fillUniquePoNo(utils.generateUniqueTimestamp()));
    }

    @And("^Select Shipment Address from the existing addresses on the OE 2 page.$")
    public void selectShipmentAddressOnOE2Page() {
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, orderEntry2Page.chooseAppropriateAddressFromTheShippingAddressList());
    }

    @Then("^Selected Shipment address is equal to Ship to field value.$")
    public void selectedShipmentAddressIsEqualToShipToFieldValueAtOE2Page() {
        assertEquals(threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS), orderEntry2Page.getShipToValue());
    }

    @When("^User clicks on the Bottom Next button on the OE 2 page.$")
    public void userClicksOnTheBottomNextButtonAtOE2Page() {
        orderEntry2Page.clickOnTheNextBottomButton();
    }

    @SuppressWarnings("unchecked")
    @Then("^All necessary elements are displayed on the Product Details block at the OE 2 page.$")
    public void allNecessaryElementsAreDisplayedOnTheProductDetailsBlockAtOE2Page() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            assertEquals(product.getCatalogNo().toUpperCase(), orderEntry2Page.getCatalogNoFromTheProductDetailsBlock());
            assertEquals(product.getDescription(), orderEntry2Page.getDescriptionFromTheProductDetailsBlock());
            int quantity = selectedProducts.get(product);
            assertTrue(quantity == orderEntry2Page.getQuantityFromTheProductDetailsBlock());
            assertEquals((Double.parseDouble(product.getFinalNetPrice()) * quantity), orderEntry2Page.getExtendedPriceFromTheProductDetailsBlock(), delta);
            assertTrue(orderEntry2Page.getCurrencyFromTheProductDetailsBlock().length() > 0);
            assertEquals(orderEntry2Page.getEstDeliveryDateFromTheProductDetailsBlock(), orderEntry2Page.getReqDeliveryDateFromTheProductDetailsBlock());
        });
    }

    @Then("^Shipping And Billing step is displayed at the OE 2 page.$")
    public void shippingAndBillingStepTitleIsDisplayedAtOE2Page() {
        assertTrue(orderEntry2Page.shippingAndBillingStepTitleIsDisplayed());
    }

    @Then("^All necessary elements are displayed on the Order Details block at OE 2 page.$")
    public void allNecessaryElementsAreDisplayedOnTheOrderDetailsBlockAtOE2Page() {
        assertTrue(orderEntry2Page.orderDetailsHeaderIsDisplayed());
        assertTrue(orderEntry2Page.jobNameFieldIsDisplayed());
        assertTrue(orderEntry2Page.payerTitleIsDisplayed());
    }

    @Then("^All necessary elements are displayed on the Address Details block at OE 2 page.$")
    public void allNecessaryElementsAreDisplayedOnTheAddressDetailsBlockAtOE2Page() {
        assertTrue(orderEntry2Page.addressDetailsHeaderIsDisplayed());
        assertTrue(orderEntry2Page.manageAddressButtonIsDisplayed());
        assertTrue(orderEntry2Page.shipmentAddressTitleIsDisplayed());
    }

    @Then("^All necessary elements are displayed on the Shipment Details block at OE 2 page.$")
    public void allNecessaryElementsAreDisplayedOnTheShipmentDetailsBlockAtOE2Page() {
        assertTrue(orderEntry2Page.shipmentDetailsHeaderIsDisplayed());
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        if (!chosenRegion.getRegionType().getRegionName().equals("ASIA") &&
                (!chosenRegion.getRegionType().getRegionName().equals("EMEA"))) {
            assertTrue(orderEntry2Page.shipPaymentMethodTitleIsDisplayed());
        }
        assertTrue(orderEntry2Page.shippingNoteTitleIsDisplayed());
        assertTrue(orderEntry2Page.shipMethodTitleIsDisplayed());
        assertTrue(orderEntry2Page.requestedDeliveryDateTitleIsDisplayed());
        assertTrue(orderEntry2Page.partiallyDeliveryTitleTitleIsDisplayed());
        assertTrue(orderEntry2Page.requestedDeliveryTitleTitleIsDisplayed());
    }

    @Then("^Payer and Shipment Addresses are correct at the OE 2 page.$")
    public void payerAndShipmentAddressesAreCorrectAtTheOE2Page() {
        String shipmentAddress = (String) threadVarsHashMap.get(TestKeyword.LA_SHIP_ADDRESS);
        assertEquals(shipmentAddress, orderEntry2Page.getPayerAddress());
        assertEquals(shipmentAddress, orderEntry2Page.getShipmentAddress());
    }

    @When("^User selects Carrier from drop-down at the OE 2 page.$")
    public void userSelectsCarrierAtTheOEPage() {
        orderEntry2Page.selectCarrierFromDropDown();
    }

    @When("^User fill Carrier Account No. field at the OE 2 page.$")
    public void userFillCarrierAccountNo() {
        orderEntry2Page.fillCarrierAccountNo();
    }

    @And("^Click on Add More Items button in the Minimum Shipment Charges pop-up on the OE 2 page.$")
    public void clickOnAddMoreItemsButtonInTheMinimumShipmentChargesPopUpAtTheOEPage() {
        orderEntry2Page.clickOnAddMoreItemsButton();
    }

    @Then("^Is (.*) blue block message displayed on the OE 2 page.$")
    public void isBlueBlockMessageDisplayedOnTheOE2Page(String text) {
        assertEquals(text, orderEntry2Page.getClaimbackMessageInBlueBlockOn2OEPage());
    }

    @Then("^Is Claimback icon displayed in Extended Price cell on the OE 2 page.$")
    public void isClaimbackIconDisplayedInExtendedPriceCell() {
        assertTrue(orderEntry2Page.isClaimbackIconInExtndPriceCellOE2PageDisplayed());
    }

    @When("^Click on (.*) link on the OE 2 page.$")
    public void clickOnProductLinkOnThe2OEPage(String products) {
        orderEntry2Page.clickOnProductLinkOnOE2Page(products);
    }

    @Then("^Is (.*) message below Pricing Details title displayed in Short Product Details pop-up.$")
    public void isClaimbackMessageInShortProductDetailsPopUpDisplayed(String text) {
        assertEquals(text, shortProductDetailsPopUpBlock.getClaimbackMessageBelowPricingDetailsTitleField());
    }

    @Then("^Is Short Product Details pop-up on the displayed.$")
    public void isShortProductDetailsPopUpDisplayed() {
        assertTrue(shortProductDetailsPopUpBlock.isShortProductDetailPopUpDisplayed());
    }

    @When("^Close Short Product Details pop-up.$")
    public void closeShortProductDetailsPopUp() {
        shortProductDetailsPopUpBlock.closeShortProductsDetailPopUp();
    }

    @And("^Add Shipping Note to the catalog no and put shipping note to the Hashmap.$")
    public void addShippingNoteToTheCatalogNo() {
        String uniqueShippingNote = utils.generateUniqueTimestamp();
        String catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
        orderEntry2Page.setShippingNoteValueToTheCatalogNoOnOE2Step(uniqueShippingNote, catalogNo);
        threadVarsHashMap.put(TestKeyword.SHIPPING_NOTE_FOR_CATALOG_NO, uniqueShippingNote);
    }

    @And("User fills Shipping Note text to the Shipping Note field and put shipping note to the Hashmap.")
    public void userFillsShippingNoteTextToTheShippingNoteField() {
        String uniqueShippingNotes = utils.generateUniqueTimestamp();
        orderEntry2Page.fillUniqueShippingNote(uniqueShippingNotes);
        threadVarsHashMap.put(TestKeyword.MAIN_SHIPPING_NOTE, uniqueShippingNotes);
    }
}
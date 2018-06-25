package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.page_blocks.FullProductDetailsPopUpBlock;
import com.geempower.storefront.pages.PriceAndAvailabilityPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PriceAndAvailabilityStepDefs extends AbstractStepDefs {
    @Autowired private PriceAndAvailabilityPage priceAndAvailabilityPage;
    @Autowired private FullProductDetailsPopUpBlock fullProductDetailsPopUpBlock;

    private final double delta = 0.000001;

    @SuppressWarnings("unchecked")
    @When("^Quantity is changed to random quantity of items for each product.$")
    public void setRandomQuantityOfProduct() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            Random random = new Random();
            int randomQuantity = 400 + random.nextInt((1000 - 400) + 1);
            priceAndAvailabilityPage.setQuantityForProduct(product, randomQuantity);
            selectedProducts.put(product, randomQuantity);
        });
    }

    @And("^All products are selected on P&A page.$")
    public void allProductsAreSelectedOnPAPage() {
        priceAndAvailabilityPage.clickOnAllCheckboxes();
    }

    @And("^Update Price & Availability button is clicked.$")
    public void updatePriceAvailabilityIsClicked() {
        priceAndAvailabilityPage.clickOnUpdatePAButton();
    }

    @When("^User clicks on Add to Cart button.$")
    public void clickOnAddToCartButton() {
        priceAndAvailabilityPage.clickOnAddToCartButton();
    }

    @Then("^Check that count of added items is displayed on My Cart icon.$")
    public void counterIconIsDisplayed() {
        assertTrue(priceAndAvailabilityPage.counterIconIsDisplayed());
    }

    @When("^User clicks on My Cart icon.$")
    public void clickOnMyCartIcon() {
        priceAndAvailabilityPage.clickOnMyCartIcon();
    }

    @When("^User clicks on Checkout button.$")
    public void clickOnCheckoutButton() {
        priceAndAvailabilityPage.clickOnCheckoutButton();
    }

    @SuppressWarnings("unchecked")
    @Then("^Correct Line Items is displayed in the Checkout pop-up.$")
    public void checkoutLineItemValueIsCorrect() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        assertTrue(priceAndAvailabilityPage.getLineItemsValue() == selectedProducts.keySet().size());
    }

    @SuppressWarnings("unchecked")
    @Then("^Correct Order Value is displayed in the Checkout pop-up.$")
    public void checkoutOrderValueIsCorrect() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            double finalNetPrice = Double.parseDouble(product.getFinalNetPrice());
            double quantityOfEachProduct = (double) selectedProducts.get(product);
            double finalActualPrice = finalNetPrice * quantityOfEachProduct;
            assertEquals(finalActualPrice, Double.parseDouble(priceAndAvailabilityPage.getOrderValueFromCheckoutPopUp()), delta);
        });
    }

    @SuppressWarnings("unchecked")
    @Then("^Extend Price is changed to correct value.$")
    public void extendPriceIsChangedToCorrectValue() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            double finalNetPrice = Double.parseDouble(product.getFinalNetPrice());
            double quantityOfEachProduct = (double) selectedProducts.get(product);
            double finalActualPrice = finalNetPrice * quantityOfEachProduct;
            assertEquals(finalActualPrice, Double.parseDouble(priceAndAvailabilityPage.getNewExtendPrice(product)), delta);
        });
    }

    @SuppressWarnings("unchecked")
    @Then("^Check that default quantity is equals to (.*) on the Price&Availability page.$")
    public void checkQtyValue(String qtyValue) {
        priceAndAvailabilityPage.waitUntilPageIsFullyLoaded();
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> assertEquals(priceAndAvailabilityPage.getQtyValue(product), qtyValue));
    }

    @SuppressWarnings("unchecked")
    @Then("^Check that description, list price, final net price, availability are equal to data from PDP.$")
    public void checkThatDescriptionListPriceFinalNetPriceAvailabilityAreEqualToDataFromPDP() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String description = getSelectedProducts().keySet().stream().findAny().get().getDescription();
        String listPrice = getSelectedProducts().keySet().stream().findAny().get().getListPrice().trim();
        String finalNetPrice = getSelectedProducts().keySet().stream().findAny().get().getFinalNetPrice();
        String availability = getSelectedProducts().keySet().stream().findAny().get().getAvailability().replace("*", "");

        assertEquals(description, priceAndAvailabilityPage.getDescription());
        assertEquals(listPrice, priceAndAvailabilityPage.getListPrice());
        assertEquals(finalNetPrice, priceAndAvailabilityPage.getFinalNetPrice());
        selectedProducts.keySet().forEach(product -> assertTrue(priceAndAvailabilityPage.getAvailability(product).contains(availability)));
    }

    @SuppressWarnings("unchecked")
    @And("^Put (.*) to the hashmap on P&A page.$")
    public void putDefaultQuantityToTheHashmap(int defaultQuantity) {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> selectedProducts.put(product, defaultQuantity));
    }

    @Then("^Appropriate (\\d+) error messages are displayed on the P&A page.$")
    public void appropriateTwoErrorMessagesAreDisplayedOnThePAPage(int count) {
        assertTrue(priceAndAvailabilityPage.getCountOfProductErrorMessages() == count);
    }

    @Then("^All the products from (.*) are displayed on the P&A page.$")
    public void allTheProductsFromProductsAreDisplayedOnThePAPage(List<String> products) {
        products.forEach(product -> assertTrue(priceAndAvailabilityPage.areAllProductsPresent(product)));
    }

    @When("^User select (.*) Agreement No for all the product.$")
    public void userSelectAgreementNoForAllTheProduct(String agreementNo) {
        priceAndAvailabilityPage.userSelectAgreementNoForAllTheProduct(agreementNo);
    }

    @Then("^All the products have (.*) agreement no in the Agreement No field.$")
    public void allTheProductHaveAppropriateAgreementNoInTheSpecialPricingField(String agreementNo) {
        assertTrue(priceAndAvailabilityPage.getAgreementNoForTheProduct()
                .allMatch(agreement -> agreement.getAttribute("value").equals(agreementNo)));
    }

    @When("^User Add new item (.*) on the P&A page.$")
    public void userAddNewItemOnThePAPage(String catalogueNo) {
        priceAndAvailabilityPage.addNewItem(catalogueNo);
    }

    @Then("^Is (.*) message below Agreement No field displayed on P&A page.$")
    public void isClaimbackMessageBelowAgreementNoFieldDisplayed(String text) {
        assertEquals(text, priceAndAvailabilityPage.getClaimbackMessageBelowAgreementNoField());
    }

    @Then("^Is (.*) message below Pricing Details title displayed in Full Product Details pop-up.$")
    public void isClaimbackMessageBelowPricingDetailsDisplayed(String text) {
        assertEquals(text, fullProductDetailsPopUpBlock.getClaimbackMessageBelowPricingDetailsTitleField());
    }

    @When("^Click on (.*) link on P&A page.$")
    public void clickOnProductsLinkOnPaPage(String product) {
        priceAndAvailabilityPage.clickOnProductLinkOnPaPage(product);
    }

    @Then("^Is Full Product Details pop-up on Price and Availability page displayed.$")
    public void isDetailProductPopUpOnPApageDisplayed() {
        assertTrue(fullProductDetailsPopUpBlock.isProductDetailPopUpOnPApageDisplayed());
    }

    @When("^Click on Product Details tab in Full Product Details pop-up.$")
    public void clickOnProductDetailsTab() {
        fullProductDetailsPopUpBlock.clickOnProductDetailsTab();
    }

    @When("^Click on Availability Details tab in Full Product Details pop-up.$")
    public void clickOnAvailabilityDetailsTab() {
        fullProductDetailsPopUpBlock.clickOnAvailabilityDetailsTab();
    }

    @When("^Close Full Product Details pop-up.$")
    public void closeFullProductDetailsPopUp() {
        fullProductDetailsPopUpBlock.closeFullProductsDetailPopUp();
    }
}
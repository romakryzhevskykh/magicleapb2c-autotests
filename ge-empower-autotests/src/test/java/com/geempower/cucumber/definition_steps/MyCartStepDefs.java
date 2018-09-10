package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.OrderManager;
import com.geempower.helpers.models.Order;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.MyCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Random;

import static com.geempower.cucumber.definition_steps.TestKeyword.GE_ORDER_NO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyCartStepDefs extends AbstractStepDefs {
    @Autowired
    private MyCartPage myCartPage;
    @Autowired
    private OrderManager orderManager;

    private final double delta = 0.00001;

    @Then("(.*) title is displayed on My Cart page.")
    public void checkMyCartTitle(String myCartTitle) {
        assertEquals(myCartPage.getMyCartTitle(), myCartTitle);
    }

    @Then("^All necessary elements are displayed on the My Cart page.$")
    public void allNecessaryElementsAreDisplayedOnTheMyCartPage() {
        assertTrue(myCartPage.areOrderStepIconsDisplayed());
        assertTrue(myCartPage.isMainOrderDataDisplayedOnTheTopRight());
        assertTrue(myCartPage.isBuildOrderInformationInputPresent());
        assertTrue(myCartPage.isAddItemButtonPresent());
        assertTrue(myCartPage.isDeleteItemButtonPresent());
        assertTrue(myCartPage.isUpdatePriceAndAvailabilityButtonPresent());
        assertTrue(myCartPage.isNextBottomButtonPresent());
        assertTrue(myCartPage.isNextTopButtonPresent());
        assertTrue(myCartPage.isSaveItemsButtonPresent());
        assertTrue(myCartPage.isCancelButtonPresent());
    }

    @And("^User cancels the order by clicking on the Cancel button.$")
    public void userCancelsTheOrderByClickingOnTheCancelButton() {
        myCartPage.clickOnCancelButton();
    }

    @When("^User clicks on the Next top button on the My Cart page.$")
    public void userClicksOnTheNextTopButtonOnTheMyCartPage() {
        myCartPage.clickOnTheNextTopButton();
    }

    @SuppressWarnings("unchecked")
    @Then("^Check that default quantity is equals to (.*) on the My Cart page.$")
    public void checkThatDefaultQuantityIsEqualsToDefaultQuantityOnTheMyCartPage(String qtyValue) {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> assertEquals(myCartPage.getQtyValue(product), qtyValue));
    }

    @SuppressWarnings("unchecked")
    @When("^Quantity is changed to random quantity of items for each product on the My Cart page.$")
    public void setRandomQuantityOfProductOnTheMyCartPage() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            Random random = new Random();
            int randomQuantity = (10 + random.nextInt((20 - 10) + 1)) * 10;
            myCartPage.setQuantityForProduct(product, randomQuantity);
            selectedProducts.put(product, randomQuantity);
        });
    }

    @And("^All products are selected on the My Cart page.$")
    public void allProductsAreSelectedOnTheMyCartPagePage() {
        myCartPage.clickOnSelectAllCheckbox();
    }

    @And("^Update Price & Availability button is clicked on the My Cart page.$")
    public void updatePriceAvailabilityButtonIsClickedOnTheMyCartPage() {
        myCartPage.clickOnUpdatePAButton();
    }

    @SuppressWarnings("unchecked")
    @Then("^Extend Price is changed to correct value on the My Cart page.$")
    public void extendPriceIsChangedToCorrectValueOnTheMyCartPage() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            double finalNetPrice = Double.parseDouble(product.getFinalNetPrice());
            double quantityOfEachProduct = (double) selectedProducts.get(product);
            double finalActualPrice = finalNetPrice * quantityOfEachProduct;
            assertEquals(finalActualPrice, Double.parseDouble(myCartPage.getNewExtendPrice(product)), delta);
        });
    }

    @Then("^Is (.*) message below Agreement No field displayed on My Cart page.$")
    public void isClaimbackMessageBelowSpaNoFieldOnMyCartPageDisplayed(String text) {
        assertEquals(text, myCartPage.getClaimbackMessageBelowAgreementNoFieldOnMyCartPage());
    }

    @When("^Click on (.*) link on My Cart page.$")
    public void clickOnProductLinkOnMyCartPage(String products) {
        myCartPage.clickOnProductLinkOnMyCartPage(products);
    }

    @Then("^Correct Catalog No. is displayed on My Cart page.$")
    public void correctCatalogNoIsDisplayedOnMyCartPage() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
        assertEquals(catalogueNo, myCartPage.correctCatalogNoIsDisplayedOnMyCartPage());
    }

    @Then("^Is Correct Country of Origin value is displayed on My Cart Page.$")
    public void isCorrectCountryOfOriginValueIsDisplayedOnMyCartPage() {
        String countryHashmap = threadVarsHashMap.getString(TestKeyword.COUNTRY_OF_ORIGIN_CELA_PRODUCT);
        assertEquals(countryHashmap, myCartPage.getCountryOfOriginValueOnMyCartPage());
    }

    @Then("^Is Qty value equal to value on the Order page.$")
    public void isQtyValueEqualToValueOnTheOrderPage(){
        Order randomOrder = orderManager.getOrderById(Long.parseLong(threadVarsHashMap.getString(GE_ORDER_NO)));
        assertTrue(randomOrder.getQuantity() == myCartPage.getQtyValue(randomOrder.getCatalogNo()));
    }
}
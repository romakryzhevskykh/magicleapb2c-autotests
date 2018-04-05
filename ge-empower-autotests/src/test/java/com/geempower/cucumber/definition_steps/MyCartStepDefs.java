package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.MyCartPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyCartStepDefs extends AbstractStepDefs {
    @Autowired
    private MyCartPage myCartPage;

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
            int randomQuantity = 400 + random.nextInt((1000 - 400) + 1);
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
}

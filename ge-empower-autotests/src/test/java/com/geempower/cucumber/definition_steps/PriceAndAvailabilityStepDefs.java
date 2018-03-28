package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.PriceAndAvailabilityPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PriceAndAvailabilityStepDefs extends AbstractStepDefs{
    @Autowired
    private PriceAndAvailabilityPage priceAndAvailabilityPage;

    @SuppressWarnings("unchecked")
    @When("^Quantity is changed to random quantity of items for each product.$")
    public void setRandomQuantityOfProduct() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            Random random = new Random();
            int randomQuantity = 400 + random.nextInt((1000 - 400) +1);
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

    @SuppressWarnings("unchecked")
    @Then("^Extend Price is changed to correct value.$")
    public void extendPriceIsChangedToCorrectValue() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            double finalNetPrice = Double.parseDouble(product.getFinalNetPrice());
            double quantityOfEachProduct = (double) selectedProducts.get(product);
            double finalActualPrice = finalNetPrice * quantityOfEachProduct;
            assertEquals(finalActualPrice, Double.parseDouble(priceAndAvailabilityPage.getNewExtendPrice(product)));
        });
    }
}

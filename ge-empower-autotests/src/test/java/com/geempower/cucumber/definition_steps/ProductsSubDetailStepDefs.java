package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.ProductSubDetailPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsSubDetailStepDefs extends AbstractStepDefs {

    @Autowired
    private ProductSubDetailPage productSubDetailPage;

    private final double delta = 0.00001;

    @Then("^Product sub-detail page is opened.$")
    public void checkThatProductSubDetailPageIsOpened() {
        assertTrue(productSubDetailPage.isOpened());
    }

    @When("^User select the product by Catalog No. from the products list on the Product Sub-Detail page.$")
    public void userSelectTheProductOnTheProductSubDetailPage() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        productSubDetailPage.chooseSelectedProductsByCatalogNo(catalogNo);
    }

    @And("^Add all the chosen products to the My Cart.$")
    public void addAllSelectedProductsToMyCart() {
        productSubDetailPage.clickOnAddToCartButton();
    }


    @Then("^Correct Line Items is displayed in the Checkout pop-up on the Product Sub-Detail page.$")
    public void correctLineItemsIsDisplayedInTheCheckoutPopUpOnTheProductSubDetailPage() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        assertTrue(productSubDetailPage.getLineItemsValue() == selectedProducts.keySet().size());
    }

    @Then("^Correct Order Value is displayed in the Checkout pop-up on the Product Sub-Detail page.$")
    public void checkoutOrderValueIsCorrect() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            double finalNetPrice = Double.parseDouble(product.getFinalNetPrice());
            assertEquals(finalNetPrice, Double.parseDouble(productSubDetailPage.getOrderValueFromCheckoutPopUp()), delta);
        });
    }
}

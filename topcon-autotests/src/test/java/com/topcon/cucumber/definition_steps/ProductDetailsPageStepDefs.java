package com.topcon.cucumber.definition_steps;

import com.topcon.helpers.managers.ProductsManager;
import com.topcon.helpers.models.Product;
import com.topcon.storefront.pages.ProductDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static com.topcon.cucumber.definition_steps.TestKeyword.OPENED_PDP_PRODUCT;

public class ProductDetailsPageStepDefs extends AbstractStepDefs {
    @Autowired private ProductDetailsPage productDetailsPage;
    @Autowired private ProductsManager productsManager;

    @Given("^PDP for any product.$")
    public void openPDPForAnyProduct(){
        Product product = productsManager.getAnyProduct();
        threadVarsHashMap.put(OPENED_PDP_PRODUCT, product);
        productDetailsPage.open(product);
    }

    @And("^Set QTY values for products to (\\d+) on PDP.$")
    public void setQTYValuesFOrProductsTo (int qtyValueforAllProductsOnPDP) {
        productDetailsPage.setQTY(qtyValueforAllProductsOnPDP);
    }

    @Then("^Click on Add to cart button on PDP.$")
    public void clickOnAddToCartButtonOnPDP() {
        productDetailsPage.clickOnAddToCartButton();
    }

    @And("^Click on Checkout button in Add to cart pop-up on PDP.$")
    public void clickOnCheckoutButtonInAddToCartPopUpOnPDP() {
        productDetailsPage.clickOnCheckoutButtonInAddToCartPopUp();
    }
}

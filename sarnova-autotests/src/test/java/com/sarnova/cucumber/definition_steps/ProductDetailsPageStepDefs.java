package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.GroupProduct;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.ProductTestType;
import com.sarnova.storefront.pages.ProductDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ProductDetailsPageStepDefs extends AbstractStepDefs {

    @Autowired private ProductDetailsPage productDetailsPage;
    @Autowired private ProductsManager productsManager;

    @Given("^PDP for (.*) product.$")
    public void openPDPForProductType(String productType) {
        Product product = productsManager.getProductByProductTestType(ProductTestType.valueOf(productType));
        productDetailsPage.openPDPForProduct(product);
        threadVarsHashMap.put("opened pdp product", product);
    }

    @And("^Set QTY values for products to (\\d+).$")
    public void setQTYValuesForProductsTo(int qtyValueForAllProductsOnPDP) {
        Product product = (Product) threadVarsHashMap.get("opened pdp product");
        if (product instanceof IndividualProduct) {
            ((IndividualProduct) product).getUnitsOfMeasurement()
                    .forEach(uom -> productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAllProductsOnPDP));
        } else if (product instanceof GroupProduct) {
            ((GroupProduct) product).getIndividualProducts()
                    .stream()
                    .flatMap(individualProduct -> individualProduct.getUnitsOfMeasurement().stream())
                    .forEach(uom -> productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAllProductsOnPDP));
        }
    }

    @When("^Click on add to Supply list button.$")
    public void clickOnAddToSupplyListButton() {
        productDetailsPage.clickOnAddToSupplyListButton();
    }

    @Then("^Pop-up with (.*) message is opened.$")
    public void checkThatPopUpIsOpenedWithMessage(String message) {
        assertEquals(productDetailsPage.getAddToSupplyListPopUpContent(), message);
    }
}

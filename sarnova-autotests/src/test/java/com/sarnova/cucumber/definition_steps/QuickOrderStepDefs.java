package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.pages.QuickOrderPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class QuickOrderStepDefs extends AbstractStepDefs {
    @Autowired QuickOrderPage quickOrderPage;
    @Autowired ProductsManager productsManager;

    @Given("^Quick order page is opened.$")
    public void quickOrderPageIsOpened() {
        if (!quickOrderPage.isOpened()) {
            quickOrderPage.open();
        }
    }

    @When("^Open Quick order page.$")
    public void openQOPage() {
        if (!quickOrderPage.isOpened()) {
            quickOrderPage.open();
        }
    }

    @Then("^Check that Add to Supply list button is visible on Quick order page.$")
    public void checkThatAddToSupplyListButtonIsVisible() {
        assertTrue(quickOrderPage.isAddToSupplyListButtonVisible());
    }

    @Then("^Check that Add to Supply list button is enabled on Quick order page.$")
    public void checkThatAddToSupplyListButtonIsEnabled() {
        assertTrue(quickOrderPage.isAddToSupplyListButtonEnabled());
    }

    @Then("^Check that Add to Supply list button is not visible on Quick order page.$")
    public void checkThatAddToSupplyListButtonIsNotVisibleOnQuickOrderPage() {
        assertFalse(quickOrderPage.isAddToSupplyListButtonVisible());
    }

    @When("^Add (\\d+) (.*) product to Quick order list on Quick order page.$")
    public void addVALIDINDIVIDUALProductToQuickOrderListOnQuickOrderPage(int numberOfProductsToAdd, List<String> productType) {
        ArrayList<Product> products = productsManager.getUniqueProductsByProductsQuantityAndTestTypes(numberOfProductsToAdd, productType);
        products.forEach(product -> {
            quickOrderPage.fillProductIdToNextEmptySKURow(product);
            product.getUnitsOfMeasurement().forEach(unitOfMeasure -> getSelectedUOMS().put(unitOfMeasure, 0));
        });
    }

    @Then("^Check that only added UOMs displayed on Quick order page.$")
    public void checkThatOnlyAddedProductsDisplayedOnQuickOrderPage() {
        Map<UnitOfMeasure, Integer> uoms = quickOrderPage.getUomsWithQTYs();
        assertEquals(uoms.size(), getSelectedUOMS().size());
        assertTrue(getSelectedUOMS().keySet().containsAll(uoms.keySet()));
    }

    @And("^Check that all products have corresponding QTY\\(zero by default\\) values.$")
    public void checkThatAllProductsHaveCorrespondingQTYZeroByDefaultValues() {
        Map<UnitOfMeasure, Integer> uoms = quickOrderPage.getUomsWithQTYs();
        uoms.forEach((key, value) -> assertEquals(getSelectedUOMS().get(key), value));
    }
}

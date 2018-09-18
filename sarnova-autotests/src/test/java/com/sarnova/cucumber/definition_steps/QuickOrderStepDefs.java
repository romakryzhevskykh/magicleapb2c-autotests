package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.pages.QuickOrderPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

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
        quickOrderPage.open();
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
    public void addProductToQuickOrderListOnQuickOrderPage(int numberOfProductsToAdd, List<String> productType) {
        ArrayList<Product> products =
                productsManager.getUniqueProductsByProductsQuantityTestTypesAndExcludeProductList(numberOfProductsToAdd,
                        productType,
                        getSelectedUOMS().keySet().stream()
                                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                                .distinct()
                                .collect(Collectors.toList()));
        products.forEach(product -> {
            quickOrderPage.fillProductIdToNextEmptySKURow(product);
            product.getUnitsOfMeasurement().forEach(unitOfMeasure -> getSelectedUOMS().put(unitOfMeasure, 0));
            threadVarsHashMap.put(TestKeyword.QUICK_ADD_TEXT, product.getSku());
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

    @And("^Add already existed product to Quick order list on Quick order page.$")
    public void addAlreadyExistedProductToQuickOrderListOnQuickOrderPage() {
        getSelectedUOMS().keySet().stream().findAny().ifPresent(unitOfMeasure -> {
            Product productToAdd = productsManager.getProductByUOM(unitOfMeasure);
            quickOrderPage.fillProductIdToNextEmptySKURow(productToAdd);
            threadVarsHashMap.put(TestKeyword.QUICK_ADD_TEXT, productToAdd.getSku());
        });
    }

    @Then("^Check that (.*) error message is displayed for used row on Quick order page.$")
    public void checkThatErrorMessageErrorMessageIsDisplayedForUsedRow(String expectedErrorMessage) {
        String enteredText = threadVarsHashMap.getString(TestKeyword.QUICK_ADD_TEXT);
        String rowErrorMessage;
        try {
            rowErrorMessage = quickOrderPage.getErrorMessageForQuickAddRowWithEnteredValue(enteredText);
        } catch (NullPointerException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(rowErrorMessage, expectedErrorMessage);
    }

    @And("^Enter random text to any empty row on Quick order page.$")
    public void enterRandomTextToAnyEmptyRowOnSupplyListDetailsPage() {
        String randomText = RandomStringUtils.randomAlphanumeric(10);
        threadVarsHashMap.put(TestKeyword.QUICK_ADD_TEXT, randomText);
        quickOrderPage.fillTextToEmptyRow(randomText);
    }

    @And("^Set QTY (\\d+) to any UOM on Quick order page.$")
    public void setQTYToAnyUOMOnQuickOrderPage(int qtyToAnyProduct) {
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        selectedUOMs.entrySet().stream().findAny().ifPresent(unitOfMeasureIntegerEntry -> {
            quickOrderPage.setQTYToUOM(qtyToAnyProduct, unitOfMeasureIntegerEntry.getKey());
            unitOfMeasureIntegerEntry.setValue(qtyToAnyProduct);
        });
    }

    @And("^Set QTY (\\d+) to any UOM using plus/minus buttons on Quick order page.$")
    public void setQTYToAnyUOMUsingPlusMinusButtonsOnQuickOrderPage(int qtyToAnyProduct) {
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        selectedUOMs.entrySet().stream()
                .filter(unitOfMeasureIntegerEntry -> !unitOfMeasureIntegerEntry.getValue().equals(qtyToAnyProduct))
                .findAny().ifPresent(unitOfMeasureIntegerEntry -> {
            quickOrderPage.setQTYToUOMUsingPlusMinus(qtyToAnyProduct, unitOfMeasureIntegerEntry);
            unitOfMeasureIntegerEntry.setValue(qtyToAnyProduct);
        });
    }
}

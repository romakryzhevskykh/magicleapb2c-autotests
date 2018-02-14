package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.storefront.pages.SupplyListDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SupplyListDetailsPageStepDefs extends AbstractStepDefs {
    @Autowired private ProductsManager productsManager;
    @Autowired private SupplyListDetailsPage supplyListDetailsPage;
    @Autowired private SupplyListsManager supplyListsManager;

    @Then("^Check that Supply list details page is opened.$")
    public void checkThatSupplyListDetailsPageIsOpened() {
        supplyListDetailsPage.isOpened();
    }

    @Then("^Check that entered name is the name of Supply list on the Supply list details page.$")
    public void checkThatEnteredNameIsTheNameOfSupplyListOnTheSupplyListDetailsPage() {
        String nameOfCreatedSupplyList = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        assertEquals(supplyListDetailsPage.getSupplyListName(), nameOfCreatedSupplyList);
    }

    @SuppressWarnings("unchecked")
    @Then("^Check that selected product\\(s\\) is\\(are\\) displayed on the Supply list details page.$")
    public void checkThatSelectedProductsAreDisplayedOnTheSupplyListDetailsPage() {
        Set<IndividualProduct> addedIndividualProducts =
                ((HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP))
                        .keySet()
                        .stream()
                        .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                        .collect(Collectors.toSet());
        SupplyList supplyList = supplyListDetailsPage.getSupplyListFromPage(userSessions.getActiveUserSession().getUser());
        addedIndividualProducts.forEach(individualProduct ->
                assertTrue(supplyList.getSupplyProductsInList().stream()
                        .filter(SupplyListProduct::isActive)
                        .map(SupplyListProduct::getIndividualProduct)
                        .anyMatch(suppliedIndividualProduct -> suppliedIndividualProduct.equals(individualProduct))));
    }

    @Given("^Opened Supply list details page.$")
    public void openedSupplyListDetailsPage() {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList supplyList = supplyListsManager.getSupplyListByName(supplyListName);
        supplyListDetailsPage.openSupplyListDetailsPageForSupplyLIst(supplyList);
    }

    @SuppressWarnings("unchecked")
    @When("^Set QTY (\\d+) to any product\\(UOM\\) on the Supply list details page.$")
    public void setQTYToAnyProductUOMOnTheSupplyListDetailsPage(int qtyValueForAnyProductOnSLDP) {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList supplyList = supplyListsManager.getSupplyListByName(supplyListName);
        UnitOfMeasure randomUnitOfMeasure = supplyList.getSupplyProductsInList()
                .stream()
                .filter(SupplyListProduct::isActive)
                .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                .findAny().orElse(null);
        supplyListDetailsPage.setQTYForProductUOMToValue(randomUnitOfMeasure, qtyValueForAnyProductOnSLDP);
        HashMap<UnitOfMeasure, Integer> unitsOfMeasurement;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            unitsOfMeasurement = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, unitsOfMeasurement);
        } else {
            unitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        unitsOfMeasurement.put(randomUnitOfMeasure, qtyValueForAnyProductOnSLDP);
    }

    @When("^Set QTY (\\d+) to all products\\(UOMs\\) on the Supply list details page.$")
    public void setQTYToAllProductsUOMsOnTheSupplyListDetailsPage(int qtyValueForAllProductOnSLDP) {
        SupplyList supplyList = supplyListDetailsPage.getSupplyListFromPage(userSessions.getActiveUserSession().getUser());
        supplyList.getSupplyProductsInList()
                .stream()
                .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                .forEach(unitOfMeasure ->
                        supplyListDetailsPage.setQTYForProductUOMToValue(unitOfMeasure, qtyValueForAllProductOnSLDP)
                );
    }

    @SuppressWarnings("unchecked")
    @And("^Set QTY (\\d+) to any product\\(UOM\\) that hasn't been selected on the Supply list details page.$")
    public void setQTYToAnyProductUOMThatHasNotBeenSelectedOnTheSupplyListDetailsPage(int qtyOfUOMToBeSelected) {
        //TODO after adding UOMs to Supply list details page
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        HashMap<UnitOfMeasure, Integer> selectedUOMs;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            selectedUOMs = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, selectedUOMs);
        } else {
            selectedUOMs = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        ArrayList<IndividualProduct> selectedProducts = selectedUOMs.keySet()
                .stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .collect(Collectors.toCollection(ArrayList::new));
        SupplyList supplyList = supplyListsManager.getSupplyListByName(supplyListName);
        UnitOfMeasure unitOfMeasureThatHasNotBeenSelected = supplyList.getSupplyProductsInList()
                .stream()
                .filter(supplyListProduct -> supplyListProduct.isActive()
                        && !selectedProducts.contains(supplyListProduct.getIndividualProduct()))
                .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                .findAny().orElse(null);
        supplyListDetailsPage.setQTYForProductUOMToValue(unitOfMeasureThatHasNotBeenSelected, qtyOfUOMToBeSelected);
        selectedUOMs.put(unitOfMeasureThatHasNotBeenSelected, qtyOfUOMToBeSelected);
    }

    @And("^Click on Add to cart button on Supply list details page.$")
    public void clickOnAddToCartButtonOnSupplyListDetailsPage() {
        supplyListDetailsPage.clickOnAddToCartButton();
    }

    @And("^Click on Checkout button in Add to cart pop-up on Supply list details page.$")
    public void clickOnCheckoutButtonInAddToCartPopUpOnSupplyListDetailsPage() {
        supplyListDetailsPage.clickOnCheckoutButtonInAddToCartPopUp();
    }

    @Then("^Check that Add to cart pop-up displays (.*) message on Supply list details page.$")
    public void checkThatAddToCartPopUpDisplaysMessage(String message) {
        assertEquals(supplyListDetailsPage.getAddToCartPopUpMessage(), message);
    }
}

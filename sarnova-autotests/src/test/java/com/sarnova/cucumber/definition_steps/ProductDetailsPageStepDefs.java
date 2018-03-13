package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.*;
import com.sarnova.storefront.pages.ProductDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class ProductDetailsPageStepDefs extends AbstractStepDefs {

    @Autowired private ProductDetailsPage productDetailsPage;
    @Autowired private ProductsManager productsManager;
    @Autowired private SupplyListsManager supplyListsManager;

    @Given("^PDP for (.*) product.$")
    public void openPDPForProductType(List<String> productType) {
        Product product = productsManager.getProductByProductTestTypes(productType);
        productDetailsPage.openPDPForProduct(product);
        threadVarsHashMap.put(TestKeyword.OPENED_PDP_PRODUCT, product);
    }

    @And("^Set QTY values for products to (\\d+) on PDP.$")
    public void setQTYValuesForProductsTo(int qtyValueForAllProductsOnPDP) {
        Product product = (Product) threadVarsHashMap.get(TestKeyword.OPENED_PDP_PRODUCT);
        if (product instanceof IndividualProduct) {
            product.getUnitsOfMeasurement()
                    .forEach(uom -> productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAllProductsOnPDP));
        } else if (product instanceof GroupProduct) {
            product.getUnitsOfMeasurement()
                    .forEach(uom -> productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAllProductsOnPDP));
        }
    }

    @When("^Click on add to Supply list button on PDP.$")
    public void clickOnAddToSupplyListButton() {
        productDetailsPage.clickOnAddToSupplyListButton();
    }

    @Then("^Check that Add to Supply list pop-up displays (.*) message on PDP.$")
    public void checkThatAddToSupplyListPopUpIsOpenedWithMessage(String message) {
        assertEquals(productDetailsPage.getAddToSupplyListPopUpContent(), message);
    }

    @Then("^Check that Add to cart pop-up displays (.*) message on PDP.$")
    public void checkThatAddToCartPopUpIsOpenedWithMessage(String message) {
        assertEquals(productDetailsPage.getAddToCartPopUpContent(), message);
    }

    @SuppressWarnings("unchecked")
    @And("^Set QTY (\\d+) to any product\\(UOM\\) on the PDP.$")
    public void selectAnyProductUOMFromTheList(int qtyValueForAnyProductOnPDP) {
        Product product = (Product) threadVarsHashMap.get(TestKeyword.OPENED_PDP_PRODUCT);
        HashMap<UnitOfMeasure, Integer> unitsOfMeasurement;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            unitsOfMeasurement = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, unitsOfMeasurement);
        } else {
            unitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        product.getUnitsOfMeasurement()
                .stream()
                .findAny()
                .ifPresent(uom -> {
                    productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAnyProductOnPDP);
                    unitsOfMeasurement.put(uom, qtyValueForAnyProductOnPDP);
                });
    }

    @SuppressWarnings("unchecked")
    @And("^Set QTY (\\d+) to any product\\(UOM\\) that hasn't been selected on PDP.$")
    public void setQTYToAnyProductUOMThatHasNotBeenSelectedOnThePDP(int qtyOfUOMToBeSelected) {
        Product openedProduct = (Product) threadVarsHashMap.get(TestKeyword.OPENED_PDP_PRODUCT);
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            selectedUnitsOfMeasurement = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, selectedUnitsOfMeasurement);
        } else {
            selectedUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        UnitOfMeasure unitOfMeasureThatHasNotBeenSelected = openedProduct.getUnitsOfMeasurement()
                .stream()
                .filter(unitOfMeasure -> !selectedUnitsOfMeasurement.containsKey(unitOfMeasure))
                .findAny().orElse(null);
        productDetailsPage.setQTYForProductUOMToValue(unitOfMeasureThatHasNotBeenSelected, qtyOfUOMToBeSelected);
        selectedUnitsOfMeasurement.put(unitOfMeasureThatHasNotBeenSelected, qtyOfUOMToBeSelected);
    }

    @SuppressWarnings("unchecked")
    @And("^Set QTY (\\d+) to UOM from the same product that hasn't been selected on PDP.$")
    public void setQTYToUOMFromTheSameProductThatHasNotBeenSelectedOnThePDP(int qtyOfUOMToBeSelected) {
        Product openedProduct = (Product) threadVarsHashMap.get(TestKeyword.OPENED_PDP_PRODUCT);
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            selectedUnitsOfMeasurement = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, selectedUnitsOfMeasurement);
        } else {
            selectedUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        UnitOfMeasure unitOfMeasureThatHasNotBeenSelected = selectedUnitsOfMeasurement.keySet().stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .flatMap(individualProduct -> individualProduct.getUnitsOfMeasurement().stream())
                .filter(unitOfMeasure -> !selectedUnitsOfMeasurement.containsKey(unitOfMeasure))
                .filter(unitOfMeasure -> openedProduct.getUnitsOfMeasurement().contains(unitOfMeasure))
                .findAny().orElse(null);

        productDetailsPage.setQTYForProductUOMToValue(unitOfMeasureThatHasNotBeenSelected, qtyOfUOMToBeSelected);
        selectedUnitsOfMeasurement.put(unitOfMeasureThatHasNotBeenSelected, qtyOfUOMToBeSelected);
    }

    @And("^Select Create a Supply list radio button in Add to Supply list pop-up on PDP.$")
    public void selectCreateASupplyListRadioButtonInAddToSupplyListPopUp() {
        productDetailsPage.clickOnCreateNewSupplyListInAddToSupplyListPopUp();
    }

    @And("^Select Select a Supply list radio button in Add to Supply list pop-up on PDP.$")
    public void selectSelectASupplyListRadioButtonInAddToSupplyListPopUp() {
        productDetailsPage.clickOnSelectSupplyListInAddToSupplyListPopUp();
    }

    @And("^Enter alphanumeric text to name field in Add to Supply list pop-up on PDP.$")
    public void enterAlphanumericTextToNameFieldInAddToSupplyListPopUp() {
        String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, newSupplyListName);
        productDetailsPage.enterNewSupplyListNameText(newSupplyListName);
    }

    @SuppressWarnings("unchecked")
    @And("^Click on Add to Supply list in Add to Supply list pop-up on PDP.$")
    public void clickOnAddToSupplyListInAddToSupplyListPopUp() {
        productDetailsPage.clickOnAddToSupplyListButtonInAddToSupplyListPopUp();
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        if (supplyListName != null && !supplyListName.isEmpty() && supplyListsManager.getSupplyListByName(supplyListName) == null) {
            String supplyListId = productDetailsPage.getSupplyListId();
            HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
            ArrayList<IndividualProduct> selectedIndividualProducts = selectedUnitsOfMeasurement.keySet()
                    .stream()
                    .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                    .collect(Collectors.toCollection(ArrayList::new));
            supplyListsManager.createInstance(userSessions.getActiveUserSession().getUser(), supplyListName, supplyListId, selectedIndividualProducts);
        }
    }

    @And("^Click on View Supply list in Add to Supply list pop-up on PDP.$")
    public void clickOnViewSupplyListInAddToSupplyListPopUp() {
        productDetailsPage.clickOnViewSupplyListButtonInAddToSupplyListPopUp();
    }

    @And("^Select existing Supply list in Add to Supply list pop-up on PDP.$")
    public void selectExistingSupplyListInAddToSupplyListPopUp() {
        String existingSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        productDetailsPage.clickOnSelectExistingSupplyListDropDown();
        if (existingSupplyListName == null) {
            existingSupplyListName = productDetailsPage.getAnyExistingSupplyListNameFromDropDown();
            if (existingSupplyListName != null) {
                threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, existingSupplyListName);
            } else {
                throw new NullPointerException("Existing supply lists haven't been found for user: " + userSessions.getActiveUserSession().getUser());
            }
        }
        productDetailsPage.selectExistingSupplyListFromDropDownBySupplyListName(existingSupplyListName);
    }

    @And("^Click on Add to cart button on PDP.$")
    public void clickOnAddToCartButtonOnPDP() {
        productDetailsPage.clickOnAddToCartButton();
    }

    @And("^Click on Checkout button in Add to cart pop-up on PDP.$")
    public void clickOnCheckoutButtonInAddToCartPopUpOnPDP() {
        productDetailsPage.clickOnCheckoutButtonInAddToCartPopUp();
    }
}

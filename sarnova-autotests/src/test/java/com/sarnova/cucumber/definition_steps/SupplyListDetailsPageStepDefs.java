package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.storefront.pages.SupplyListDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

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
        Set<IndividualProduct> addedIndividualProducts = getSelectedUOMS()
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
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No UOMs for this condition!");
                });
        supplyListDetailsPage.setQTYForProductUOMToValue(randomUnitOfMeasure, qtyValueForAnyProductOnSLDP);
        HashMap<UnitOfMeasure, Integer> unitsOfMeasurement = getSelectedUOMS();
        unitsOfMeasurement.put(randomUnitOfMeasure, qtyValueForAnyProductOnSLDP);
    }

    @When("^Set QTY (\\d+) to all products\\(UOMs\\) on the Supply list details page.$")
    public void setQTYToAllProductsUOMsOnTheSupplyListDetailsPage(int qtyValueForAllProductOnSLDP) {
        SupplyList supplyList = supplyListDetailsPage.getSupplyListFromPage(userSessions.getActiveUserSession().getUser());
        supplyList.getSupplyProductsInList()
                .stream()
                .filter(SupplyListProduct::isActive)
                .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                .forEach(unitOfMeasure ->
                        supplyListDetailsPage.setQTYForProductUOMToValue(unitOfMeasure, qtyValueForAllProductOnSLDP)
                );
    }

    @SuppressWarnings("unchecked")
    @And("^Set QTY (\\d+) to any product\\(UOM\\) that hasn't been selected on the Supply list details page.$")
    public void setQTYToAnyProductUOMThatHasNotBeenSelectedOnTheSupplyListDetailsPage(int qtyOfUOMToBeSelected) {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        SupplyList supplyList = supplyListsManager.getSupplyListByName(supplyListName);
        UnitOfMeasure unitOfMeasureThatHasNotBeenSelected = supplyList.getSupplyProductsInList()
                .stream()
                .filter(SupplyListProduct::isActive)
                .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                .filter(unitOfMeasure -> !selectedUOMs.containsKey(unitOfMeasure))
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No UOMs for this condition!");
                });
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

    @When("^Click on deactivate button on Supply list details page.$")
    public void deactivateSupplyList() {
        if (supplyListDetailsPage.isSupplyListActive()) {
            supplyListDetailsPage.changeSupplyListStatus();
        }
    }

    @When("^Click on activate button on Supply list details page.$")
    public void activateSupplyList() {
        if (!supplyListDetailsPage.isSupplyListActive()) {
            supplyListDetailsPage.changeSupplyListStatus();
        }
    }

    @Then("^Check that Supply list is deactivated on Supply list details page.$")
    public void checkThatSupplyListIsDeactivatedOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isSupplyListInactive());
    }

    @Then("^Check that Supply list is activated on Supply list details page.$")
    public void checkThatSupplyListIsActivatedOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isSupplyListActive());
    }

    @SuppressWarnings("unchecked")
    @When("^Click on deactivate any product button on Supply list details page.$")
    public void clickOnDeactivateAnyProductButtonOnSupplyListDetailsPage() {
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        SupplyList currentSupplyList = supplyListsManager.getSupplyListByName(supplyListDetailsPage.getSupplyListName());
        SupplyListProduct activatedSupplyListProduct = currentSupplyList.getSupplyProductsInList()
                .stream()
                .filter(SupplyListProduct::isActive)
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No products for this condition!");
                });
        supplyListDetailsPage.deactivateProduct(activatedSupplyListProduct);
        selectedUOMs.putAll(activatedSupplyListProduct.getIndividualProduct().getUnitsOfMeasurement()
                .stream()
                .collect(Collectors.toMap(unitOfMeasure -> unitOfMeasure, unitOfMeasure -> 1))
        );
    }

    @SuppressWarnings("unchecked")
    @When("^Click on activate any product button on Supply list details page.$")
    public void clickOnActivateAnyProductButtonOnSupplyListDetailsPage() {
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        SupplyList currentSupplyList = supplyListsManager.getSupplyListByName(supplyListDetailsPage.getSupplyListName());
        SupplyListProduct deactivatedSupplyListProduct = currentSupplyList.getSupplyProductsInList()
                .stream()
                .filter(supplyListProduct1 -> !supplyListProduct1.isActive())
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No products for this condition!");
                });
        supplyListDetailsPage.activateProduct(deactivatedSupplyListProduct);
        selectedUOMs.putAll(deactivatedSupplyListProduct.getIndividualProduct().getUnitsOfMeasurement()
                .stream()
                .collect(Collectors.toMap(unitOfMeasure -> unitOfMeasure, unitOfMeasure -> 1))
        );
    }

    @Then("^Check that (.*) message is shown on Supply list details page.$")
    public void checkThatThereSNoActiveEntriesInThisSupplyListMessageIsShownOnSupplyListDetailsPage(String messageOnSLDP) {
        assertTrue(supplyListDetailsPage.checkThatTextContentMessageIsDisplayed());
        assertEquals(supplyListDetailsPage.getTextContentMessageInActiveProductsBlock(), messageOnSLDP);
    }

    @Then("^Click on Show inactivate entries checkbox on Supply list details page.$")
    public void clickOnShowInactivateEntriesCheckboxOnSupplyListDetailsPage() {
        supplyListDetailsPage.showInactiveSupplyProducts();
    }

    @SuppressWarnings("unchecked")
    @And("^Check that product is deactivated on Supply list details page.$")
    public void checkThatProductIsDeactivatedOnSupplyListDetailsPage() {
        List<IndividualProduct> deactivatedProducts = supplyListDetailsPage.getDeactivatedProducts();
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        List<IndividualProduct> testDeactivatedProducts = selectedUOMs.keySet()
                .stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .distinct()
                .collect(Collectors.toList());
        assertTrue(deactivatedProducts.containsAll(testDeactivatedProducts));
    }

    @SuppressWarnings("unchecked")
    @And("^Check that product is activated on Supply list details page.$")
    public void checkThatProductIsActivatedOnSupplyListDetailsPage() {
        List<IndividualProduct> activatedProducts = supplyListDetailsPage.getActivatedProducts();
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        List<IndividualProduct> testActivatedProducts = selectedUOMs.keySet()
                .stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .distinct()
                .collect(Collectors.toList());
        assertTrue(activatedProducts.containsAll(testActivatedProducts));
    }

    @SuppressWarnings("unchecked")
    @And("^Check that other activated products did not change their statuses on Supply list details page.$")
    public void checkThatOtherActivatedProductsDidNotChangeTheirStatusesOnSupplyListDetailsPage() {
        List<IndividualProduct> activatedProducts = supplyListDetailsPage.getActivatedProducts();
        List<IndividualProduct> expectedActiveProducts =
                supplyListsManager.getSupplyListByName(supplyListDetailsPage.getSupplyListName())
                        .getSupplyProductsInList().stream()
                        .filter(SupplyListProduct::isActive)
                        .map(SupplyListProduct::getIndividualProduct)
                        .collect(Collectors.toList());
        assertEquals(activatedProducts.size(), expectedActiveProducts.size());
        assertTrue(activatedProducts.containsAll(expectedActiveProducts));
    }

    @When("^Mark Supply list as favourite on Supply list details page.$")
    public void markSupplyListAsFavouriteOnSupplyListDetailsPage() {
        SupplyList currentSupplyList = supplyListsManager.getSupplyListByName(supplyListDetailsPage.getSupplyListName());
        supplyListDetailsPage.markAsFavorite();
        currentSupplyList.setFavorite(true);
    }

    @When("^Unmark Supply list as favourite on Supply list details page.$")
    public void unmarkSupplyListAsFavouriteOnSupplyListDetailsPage() {
        SupplyList currentSupplyList = supplyListsManager.getSupplyListByName(supplyListDetailsPage.getSupplyListName());
        supplyListDetailsPage.markAsUnFavorite();
        currentSupplyList.setFavorite(false);
    }

    @Given("^Open Quick add block on Supply list details page.$")
    public void openQuickAddBlockOnSupplyListDetailsPage() {
        supplyListDetailsPage.openQuickAddBlockOnSupplyListDetailsPage();
    }

    @And("^Enter not exist (.*) product SKU to any empty row on Supply list details page.$")
    public void enterNotExistProductSKUToAnyEmptyRowOnSupplyListDetailsPage(List<String> productTypes) {
        String testSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList currentSupplyList = supplyListsManager.getSupplyListByName(testSupplyListName);
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        List<Product> individualProductsInCurrentSL = currentSupplyList.getSupplyProductsInList().stream()
                .map(SupplyListProduct::getIndividualProduct)
                .collect(Collectors.toList());
        List<Product> selectedProducts = Stream.concat(individualProductsInCurrentSL.stream(),
                selectedUOMs.keySet()
                        .stream()
                        .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                        .distinct()
        ).distinct().collect(Collectors.toList());
        Product newProduct = productsManager.getUniqueProductsByProductsQuantityAndTestTypes(
                selectedProducts.size() + 1, productTypes).stream()
                .filter(product -> !selectedProducts.contains(product))
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No products for this condition!");
                });
        threadVarsHashMap.put(TestKeyword.QUICK_ADD_TEXT, newProduct.getSku());
        supplyListDetailsPage.enterSkuToEmptyQuickAddRow(newProduct.getSku());
        if (newProduct instanceof IndividualProduct)
            selectedUOMs.putAll(newProduct.getUnitsOfMeasurement()
                    .stream()
                    .collect(Collectors.toMap(unitOfMeasure -> unitOfMeasure, unitOfMeasure -> 1))
            );
    }

    @And("^Enter exist product SKU to any empty row on Supply list details page.$")
    public void enterExistProductSKUToAnyEmptyRowOnSupplyListDetailsPage() {
        String testSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList currentSupplyList = supplyListsManager.getSupplyListByName(testSupplyListName);
        IndividualProduct individualProductInCurrentSL = currentSupplyList.getSupplyProductsInList().stream()
                .map(SupplyListProduct::getIndividualProduct)
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("No products for this condition!");
                });
        threadVarsHashMap.put(TestKeyword.QUICK_ADD_TEXT, individualProductInCurrentSL.getSku());
        supplyListDetailsPage.enterSkuToEmptyQuickAddRow(individualProductInCurrentSL.getSku());
    }

    @And("^Enter random text to any empty row on Supply list details page.$")
    public void enterRandomTextToAnyEmptyRowOnSupplyListDetailsPage() {
        String randomText = RandomStringUtils.randomAlphanumeric(10);
        threadVarsHashMap.put(TestKeyword.QUICK_ADD_TEXT, randomText);
        supplyListDetailsPage.enterSkuToEmptyQuickAddRow(randomText);
    }

    @And("^Click on Add to this list button on Supply list details page.$")
    public void clickOnAddToThisListButtonOnSupplyListDetailsPage() {
        String testSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList currentSupplyList = supplyListsManager.getSupplyListByName(testSupplyListName);
        supplyListDetailsPage.clickOnQuickAddToThisSupplyListButton();
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        currentSupplyList.addSupplyProductsToList(selectedUOMs.keySet()
                .stream()
                .map(uom -> productsManager.getProductByUOM(uom))
                .distinct()
                .map(individualProduct -> supplyListsManager.createSupplyProductInstance(individualProduct))
                .collect(Collectors.toList()));
    }

    @Then("^Check that (.*) error message is displayed for used row.$")
    public void checkThatErrorMessageErrorMessageIsDisplayedForUsedRow(String expectedErrorMessage) {
        String enteredText = threadVarsHashMap.getString(TestKeyword.QUICK_ADD_TEXT);
        String rowErrorMessage;
        try {
            rowErrorMessage = supplyListDetailsPage.getErrorMessageForQuickAddRowWithEnteredValue(enteredText);
        } catch (NullPointerException ex) {
            throw new AssertionError(ex);
        }
        assertEquals(rowErrorMessage, expectedErrorMessage);
    }

    @And("^Check that Supply list header is visible on Supply list details page.$")
    public void checkThatSupplyListHeaderIsVisibleOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isHeaderVisible());
    }

    @Then("^Check that Supply list favorite checkbox is visible on Supply list details page.$")
    public void checkThatSupplyListFavoriteCheckboxIsVisibleOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isSupplyListFavoriteCheckboxVisible());
    }

    @Then("^Check that Add to cart button is visible on Supply list details page.$")
    public void checkThatAddToCartButtonIsVisibleOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isAddToCartButtonVisible());
    }

    @Then("^Check that product Quantity field is visible on Supply details page.$")
    public void checkThatProductQuantityFieldIsVisibleOnSupplyDetailsPage() {
        SupplyList supplyList = supplyListsManager.getSupplyListByName(threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME));
        assertTrue(supplyListDetailsPage.isQuantityFieldVisibleForProduct(supplyList.getSupplyProductsInList().stream()
                .filter(SupplyListProduct::isActive)
                .findAny().orElse(null)));
    }

    @Then("^Check that Remove button is visible on Supply list details page.$")
    public void checkThatRemoveButtonIsVisibleOnSupplyListDetailsPage() {
        SupplyList supplyList = supplyListsManager.getSupplyListByName(threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME));
        SupplyListProduct supplyListProduct = supplyList.getSupplyProductsInList().stream().findAny().orElse(null);
        assertTrue(supplyListDetailsPage.isDeactivateProductButtonVisible(supplyListProduct));
    }

    @Then("^Check that Quick add functionality is visible on Supply list details page.$")
    public void checkThatQuickAddFunctionalityIsVisibleOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isQuickAddCheckboxVisible());
    }

    @Then("^Check that Edit button is visible on Supply list details page.$")
    public void checkThatEditButtonIsVisibleOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isEditButtonVisible());
    }

    @Then("^Check that change Supply lit status button is visible on Supply list details page.$")
    public void checkThatChangeSupplyLitStatusButtonIsVisibleOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isChangeStatusButtonVisible());
    }

    @Then("^Check that Share Supply list functionality is not visible on Supply list details page.$")
    public void checkThatShareSupplyListFunctionalityIsNotVisibleOnSupplyListDetailsPage() {
        assertFalse(supplyListDetailsPage.isShareCheckboxVisible());
    }

    @Then("^Check that Share Supply list functionality is visible on Supply list details page.$")
    public void checkThatShareSupplyListFunctionalityIsVisibleOnSupplyListDetailsPage() {
        assertTrue(supplyListDetailsPage.isShareCheckboxVisible());
    }

    @Then("^Check that Add to cart button is unable on Supply list details page.$")
    public void checkThatAddToCartButtonIsUnableOnSupplyListDetailsPage() throws Throwable {
        assertFalse(supplyListDetailsPage.isAddToCartButtonEnable());
    }
}

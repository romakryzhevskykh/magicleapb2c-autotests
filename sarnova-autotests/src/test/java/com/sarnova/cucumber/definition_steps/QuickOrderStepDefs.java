package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
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
    @Autowired SupplyListsManager supplyListsManager;

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

    @Then("^Check that Add to Supply list button is unable on Quick order page.$")
    public void checkThatAddToSupplyListButtonIsUnable() {
        assertFalse(quickOrderPage.isAddToSupplyListButtonEnabled());
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

    @And("^Check that all products have corresponding QTY\\(zero by default\\) values on Quick order page.$")
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

    @And("^Set QTY (\\d+) to all UOM on Quick order page.$")
    public void setQTYToAllUOMOnQuickOrderPage(int qtyToAnyProduct) {
        HashMap<UnitOfMeasure, Integer> selectedUOMs = getSelectedUOMS();
        selectedUOMs.entrySet().forEach(unitOfMeasureIntegerEntry -> {
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

    @And("^Click on Add to Supply list button on Quick order page.$")
    public void clickOnAddToSupplyListButtonOnQuickOrderPage() {
        quickOrderPage.clickOnAddToSupplyListButton();
    }

    @And("^Select Create a Supply list radio button in Add to Supply list pop-up on Quick order page.$")
    public void selectCreateASupplyListRadioButtonInAddToSupplyListPopUp() {
        quickOrderPage.clickOnCreateNewSupplyListInAddToSupplyListPopUp();
    }

    @And("^Select Select a Supply list radio button in Add to Supply list pop-up on Quick order page.$")
    public void selectSelectASupplyListRadioButtonInAddToSupplyListPopUp() {
        quickOrderPage.clickOnSelectSupplyListInAddToSupplyListPopUp();
    }

    @And("^Enter alphanumeric text to name field in Add to Supply list pop-up on Quick order page.$")
    public void enterAlphanumericTextToNameFieldInAddToSupplyListPopUp() {
        String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, newSupplyListName);
        quickOrderPage.enterNewSupplyListNameText(newSupplyListName);
    }

    @SuppressWarnings("unchecked")
    @And("^Click on Add to Supply list in Add to Supply list pop-up on Quick order page.$")
    public void clickOnAddToSupplyListInAddToSupplyListPopUp() {
        quickOrderPage.clickOnAddToSupplyListButtonInAddToSupplyListPopUp();
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        if (supplyListName != null && !supplyListName.isEmpty() && supplyListsManager.getSupplyListByName(supplyListName) == null) {
            String supplyListId = quickOrderPage.getSupplyListId();
            HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
            ArrayList<IndividualProduct> selectedIndividualProducts = selectedUnitsOfMeasurement.keySet()
                    .stream()
                    .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                    .collect(Collectors.toCollection(ArrayList::new));
            supplyListsManager.createInstance(userSessions.getActiveUserSession().getUser(), supplyListName, supplyListId, selectedIndividualProducts);
        } else if (supplyListsManager.getSupplyListByName(supplyListName) != null) {
            HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
            ArrayList<IndividualProduct> selectedIndividualProducts = selectedUnitsOfMeasurement.keySet()
                    .stream()
                    .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                    .collect(Collectors.toCollection(ArrayList::new));
            supplyListsManager.getSupplyListByName(supplyListName)
                    .addSupplyProductsToList(selectedIndividualProducts
                            .stream()
                            .map(selectedIndividualProduct -> supplyListsManager.createSupplyProductInstance(selectedIndividualProduct))
                            .collect(Collectors.toList()));
        }
    }

    @And("^Click on View Supply list in Add to Supply list pop-up on Quick order page.$")
    public void clickOnViewSupplyListInAddToSupplyListPopUp() {
        quickOrderPage.clickOnViewSupplyListButtonInAddToSupplyListPopUp();
    }

    @And("^Select existing Supply list in Add to Supply list pop-up on Quick order page.$")
    public void selectExistingSupplyListInAddToSupplyListPopUp() {
        String existingSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        quickOrderPage.clickOnSelectExistingSupplyListDropDown();
        if (existingSupplyListName == null) {
            existingSupplyListName = quickOrderPage.getAnyExistingSupplyListNameFromDropDown();
            if (existingSupplyListName != null) {
                threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, existingSupplyListName);
            } else {
                throw new NullPointerException("Existing supply lists haven't been found for user: " + userSessions.getActiveUserSession().getUser());
            }
        }
        quickOrderPage.selectExistingSupplyListFromDropDownBySupplyListName(existingSupplyListName);
    }

    @And("^Click on Continue button in Add to Supply list pop-up on Quick order page.$")
    public void clickOnContinueButtonInAddToSupplyListPopUpOnQuickOrderPage() {
        quickOrderPage.clickOnContinueButtonInAddToSupplyListPopUpOnQuickOrderPage();
    }

    @Then("^Check that Add to cart button is unable on Quick order page.$")
    public void checkThatAddToCartButtonIsUnableOnQuickOrderPage() {
        assertFalse(quickOrderPage.isAddToCartButtonEnabled());
    }

    @And("^Click on Add to cart button on Quick order page.$")
    public void clickOnAddToCartButtonOnQuickOrderPage() {
        quickOrderPage.clickOnAddToCartButton();
    }

    @Then("^Check that Quick order list is empty on Quick order page.$")
    public void checkThatQuickOrderListIsEmptyOnQuickOrderPage() {
        assertTrue(quickOrderPage.getUomsWithQTYs().isEmpty());
    }

    @And("^Click on Reset form button on Quick order page.$")
    public void clickOnResetFormButtonOnQuickOrderPage() {
        quickOrderPage.clickOnResetFormButton();
    }

    @And("^Click on Reset form button on Pop-up on Quick order page.$")
    public void clickOnResetFormButtonOnPopUp() {
        quickOrderPage.clickOnPopUpResetFormButton();
    }
}

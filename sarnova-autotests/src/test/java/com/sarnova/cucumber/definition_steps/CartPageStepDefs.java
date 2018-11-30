package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.pages.CartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class CartPageStepDefs extends AbstractStepDefs {

    @Autowired private CartPage cartPage;
    @Autowired private ProductsManager productsManager;
    @Autowired private SupplyListsManager supplyListsManager;

    @Then("^Check that only selected UOMs exist on Cart page.$")
    public void checkThatSelectedUOMsExistOnCartPage() {
        Map<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = getSelectedUOMS().entrySet().stream()
                .filter(unitOfMeasureIntegerEntry -> unitOfMeasureIntegerEntry.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<UnitOfMeasure> unitsOfMeasurementInCart = cartPage.getUnitsOfMeasurementInCart();
        addedToCartUnitsOfMeasurement.keySet().forEach(addedUOM ->
                assertTrue(unitsOfMeasurementInCart.contains(addedUOM),"Selected products aren't equal to products on the Cart page")
        );
        assertEquals(addedToCartUnitsOfMeasurement.size(), unitsOfMeasurementInCart.size(),"The number of product items that user added to the cart aren't equals to product items on the Cart page");
    }

    @SuppressWarnings("unchecked")
    @And("^Check that selected UOMs have corresponding quantities on Cart page.$")
    public void checkThatSelectedUOMsHaveCorrespondingQuantitiesOnCartPage() {
        Map<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = getSelectedUOMS().entrySet().stream()
                .filter(unitOfMeasureIntegerEntry -> unitOfMeasureIntegerEntry.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        addedToCartUnitsOfMeasurement.forEach((unitOfMeasure, qtyOfUOM) ->
                assertEquals(cartPage.getQTYOfUOM(unitOfMeasure), qtyOfUOM.intValue(),"Products quantity in the Cart page aren't equals to selected products quantity")
        );
    }

    @And("^Open cart page.$")
    public void openCartPage() {
        cartPage.open();
    }

    @And("^Check that there are no products on Cart page.$")
    public void checkThatThereAreNoProductsOnCartPage() {
        assertTrue(cartPage.getUnitsOfMeasurementInCart().isEmpty());
    }

    @When("^Click on Checkout button on Cart page.$")
    public void clickOnCheckoutButtonOnCartPage() {
        cartPage.clickOnCheckoutButton();
    }

    @Then("^Check that Cart page is opened.$")
    public void checkThatCartPageIsOpened() {
        assertTrue(cartPage.isOpened());
    }

    @When("^Click on add to Supply list button on Cart page.$")
    public void clickOnAddToSupplyListButton() {
        cartPage.clickOnAddToSupplyListButton();
    }

    @SuppressWarnings("unchecked")
    @When("^Click on add to Supply list button for any selected UOMs on Cart page.$")
    public void clickOnAddToSupplyListButtonForAnySelectedUOM() {
        HashMap<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = getSelectedUOMS();
        UnitOfMeasure unitOfMeasureToBeSelected = addedToCartUnitsOfMeasurement.keySet().stream().findAny().orElse(null);
        cartPage.clickOnAddToSupplyListButtonForUOM(unitOfMeasureToBeSelected);
        addedToCartUnitsOfMeasurement.put(unitOfMeasureToBeSelected, 1);
    }

    @And("^Select Select a Supply list radio button in Add to Supply list pop-up on Cart page.$")
    public void selectSelectASupplyListRadioButtonInAddToSupplyListPopUp() {
        cartPage.clickOnSelectSupplyListInAddToSupplyListPopUp();
    }

    @And("^Select existing Supply list in Add to Supply list pop-up on Cart page.$")
    public void selectExistingSupplyListInAddToSupplyListPopUp() {
        String existingSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        cartPage.clickOnSelectExistingSupplyListDropDown();
        if (existingSupplyListName == null) {
            existingSupplyListName = cartPage.getAnyExistingSupplyListNameFromDropDown();
            if (existingSupplyListName != null) {
                threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, existingSupplyListName);
            } else {
                throw new IllegalStateException("Existing supply lists haven't been found for user: " + userSessions.getActiveUserSession().getUser());
            }
        }
        cartPage.selectExistingSupplyListFromDropDownBySupplyListName(existingSupplyListName);
    }

    @SuppressWarnings("unchecked")
    @And("^Click on Add to Supply list in Add to Supply list pop-up on Cart page.$")
    public void clickOnAddToSupplyListInAddToSupplyListPopUp() {
        cartPage.clickOnAddToSupplyListButtonInAddToSupplyListPopUp();
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        if (supplyListName != null && !supplyListName.isEmpty() && supplyListsManager.getSupplyListByName(supplyListName) == null) {
            String supplyListId = cartPage.getSupplyListId();
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

    @And("^Click on View Supply list in Add to Supply list pop-up on Cart page.$")
    public void clickOnViewSupplyListInAddToSupplyListPopUp() {
        cartPage.clickOnViewSupplyListButtonInAddToSupplyListPopUp();
    }

    @And("^Select Create a Supply list radio button in Add to Supply list pop-up on Cart page.$")
    public void selectCreateASupplyListRadioButtonInAddToSupplyListPopUp() {
        cartPage.clickOnCreateNewSupplyListInAddToSupplyListPopUp();
    }

    @And("^Enter alphanumeric text to name field in Add to Supply list pop-up on Cart page.$")
    public void enterAlphanumericTextToNameFieldInAddToSupplyListPopUp() {
        String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, newSupplyListName);
        cartPage.enterNewSupplyListNameText(newSupplyListName);
    }

    @Then("^Check that Add to Supply list button is not visible on Cart page.$")
    public void checkThatAddToSupplyListButtonIsNotVisibleOnCartPage() {
        assertFalse(cartPage.isAddToSupplyListButtonVisible());
    }

    @Then("^Check that Add to Supply list button is visible on Cart page.$")
    public void checkThatAddToSupplyListButtonIsVisibleOnCartPage() {
        assertTrue(cartPage.isAddToSupplyListButtonVisible());
    }

    @Then("^Check that Checkout button is visible on Cart page.$")
    public void checkThatCheckoutButtonIsVisibleOnCartPage() {
        assertTrue(cartPage.isCheckoutButtonVisible());
    }

    @Then("^Check that Save Cart button is visible on Cart page.$")
    public void checkThatSaveCartButtonIsVisibleOnCartPage() {
        assertTrue(cartPage.isSaveCartButtonVisible());
    }

    @When("^Click on Save Cart button on Cart page.$")
    public void clickOnSaveCartButton() {
        cartPage.clickOnSaveCartButton();
    }

    @When("^Click on Saved Carts button on Cart page.$")
    public void clickOnSavedCartsButton() {
        cartPage.clickOnSavedCartsButton();
    }

    @Then("^Check that Save Cart pop-up is visible on Cart page.$")
    public void checkThatSaveCartPopUpIsVisibleOnCartPage() {
        assertTrue(cartPage.isSaveCartPopUpOpened());
    }

    @Then("^Check that Save Cart name field is visible in Save Cart pop-up on Cart page.$")
    public void checkThatSaveCartNameFieldIsVisible() {
        assertTrue(cartPage.isPopUpSaveCartNameFieldVisible());
    }

    @Then("^Check that Save Cart description field is visible in Save Cart pop-up on Cart page.$")
    public void checkThatSaveCartDescriptionFieldIsVisible() {
        assertTrue(cartPage.isPopUpSaveCartDescriptionVisible());
    }

    @Then("^Check that Save Cart button is visible in Save Cart pop-up on Cart page.$")
    public void checkThatSaveCartButtonIsVisible() {
        assertTrue(cartPage.isPopUpSaveCartButtonVisible());
    }

    @Then("^Check that Cancel Save Cart button is visible in Save Cart pop-up on Cart page.$")
    public void checkThatCancelSaveCartButtonIsVisible() {
        assertTrue(cartPage.isPopUpCancelSaveCartButtonVisible());
    }

    @Then("^Check that Saved Carts button is visible on Cart page.$")
    public void checkThatSavedCartsButtonVisible() {
        assertTrue(cartPage.isSavedCartsButtonVisible());
    }

    @And("^Check that stock warning message for product (.*), (.*) is displayed on Cart page: (.*).$")
    public void checkThatStockWarningMessageForProductIsDisplayed(String skuId, String uom, boolean isDisplayed) {
        assertThat(cartPage.isWarningMessageDisplayedForProduct(skuId, uom)).as("Issue with displaying stock warning message").isEqualTo(isDisplayed);
    }
}

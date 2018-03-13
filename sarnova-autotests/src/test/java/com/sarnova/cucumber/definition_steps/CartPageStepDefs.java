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
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartPageStepDefs extends AbstractStepDefs {

    @Autowired private CartPage cartPage;
    @Autowired private ProductsManager productsManager;
    @Autowired private SupplyListsManager supplyListsManager;

    @SuppressWarnings("unchecked")
    @Then("^Check that only selected UOMs exist on Cart page.$")
    public void checkThatSelectedUOMsExistOnCartPage() {
        HashMap<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        ArrayList<UnitOfMeasure> unitsOfMeasurementInCart = cartPage.getUnitsOfMeasurementInCart();
        addedToCartUnitsOfMeasurement.keySet().forEach(addedUOM ->
                assertTrue(unitsOfMeasurementInCart.contains(addedUOM))
        );
        assertEquals(addedToCartUnitsOfMeasurement.size(), unitsOfMeasurementInCart.size());
    }

    @SuppressWarnings("unchecked")
    @And("^Check that selected UOMs have corresponding quantities on Cart page.$")
    public void checkThatSelectedUOMsHaveCorrespondingQuantitiesOnCartPage() {
        HashMap<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        addedToCartUnitsOfMeasurement.forEach((unitOfMeasure, qtyOfUOM) ->
                assertEquals(cartPage.getQTYOfUOM(unitOfMeasure), qtyOfUOM.intValue())
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
        HashMap<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        UnitOfMeasure unitOfMeasureToBeSelected = addedToCartUnitsOfMeasurement.keySet().stream().findAny().orElse(null);
        cartPage.clickOnAddToSupplyListButtonForUOM(unitOfMeasureToBeSelected);
        threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, new HashMap<UnitOfMeasure, Integer>() {{
            put(unitOfMeasureToBeSelected, 1);
        }});
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
                throw new NullPointerException("Existing supply lists haven't been found for user: " + userSessions.getActiveUserSession().getUser());
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
            HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
            ArrayList<IndividualProduct> selectedIndividualProducts = selectedUnitsOfMeasurement.keySet()
                    .stream()
                    .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                    .collect(Collectors.toCollection(ArrayList::new));
            supplyListsManager.createInstance(userSessions.getActiveUserSession().getUser(), supplyListName, supplyListId, selectedIndividualProducts);
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
}

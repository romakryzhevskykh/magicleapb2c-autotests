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

    @Then("^Check that selected product\\(s\\) is\\(are\\) displayed on the Supply list details page.$")
    public void checkThatSelectedProductsAreDisplayedOnTheSupplyListDetailsPage() {
        Set<IndividualProduct> addedIndividualProducts =
                ((ArrayList<UnitOfMeasure>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS))
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
        threadVarsHashMap.put(TestKeyword.SELECTED_UOMS, new ArrayList<UnitOfMeasure>() {{
            add(randomUnitOfMeasure);
        }});
    }

    @And("^Click on Add to cart button on Supply list details page.$")
    public void clickOnAddToCartButtonOnSupplyListDetailsPage() {
        supplyListDetailsPage.clickOnAddToCartButton();
    }

    @And("^Click on Checkout button in Add to cart pop-up on Supply list details page.$")
    public void clickOnCheckoutButtonInAddToCartPopUpOnSupplyListDetailsPage() {
        supplyListDetailsPage.clickOnCheckoutButtonInAddToCartPopUp();
    }
}

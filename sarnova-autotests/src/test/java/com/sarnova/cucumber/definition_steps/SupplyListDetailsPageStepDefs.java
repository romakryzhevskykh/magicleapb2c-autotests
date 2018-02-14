package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.storefront.pages.SupplyListDetailsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SupplyListDetailsPageStepDefs extends AbstractStepDefs {
    @Autowired private ProductsManager productsManager;
    @Autowired private SupplyListDetailsPage supplyListDetailsPage;

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
                ((ArrayList<UnitOfMeasure>) threadVarsHashMap.get(TestKeyword.SELECTED_ON_PDP_UOMS))
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
}

package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.CartManager;
import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.helpers.user_engine.UserSession;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class GeneralStepDefs extends AbstractStepDefs {
    @Autowired HeaderRowPageBlock headerRowPageBlock;
    @Autowired LoginPage loginPage;

    @Autowired private SupplyListsManager supplyListsManager;
    @Autowired private ProductsManager productsManager;
    @Autowired private CartManager cartManager;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (headerRowPageBlock.isUserLoggedOut()) {
            loginPage.open();
            loginPage.loginToStorefront(userSessions.getActiveUserSession());
        }
    }

    @SuppressWarnings("unchecked")
    @And("^Supply list that doesn't contain this products exists.$")
    public void existingSupplyListThatDoesNotContainThisProducts() {
        ArrayList<UnitOfMeasure> selectedUnitsOfMeasurement = ((ArrayList<UnitOfMeasure>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS));
        String existingSupplyListName = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                        .noneMatch(selectedUnitsOfMeasurement::contains)
                ).findAny()
                .orElseGet(() -> createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(selectedUnitsOfMeasurement, 1))
                .getName();

        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, existingSupplyListName);
    }

    @Given("^Not empty Supply list.$")
    public void notEmptySupplyList() {
        SupplyList notEmptySupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .anyMatch(SupplyListProduct::isActive))
                .findAny()
                .orElseGet(() -> createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_LIST, 1));
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, notEmptySupplyList.getName());
    }

    @Given("^Empty Cart.$")
    public void emptyCart() {
        cartManager.emptyActiveCart(userSessions.getActiveUserSession());
    }

    @SuppressWarnings("unchecked")
    private BiFunction<List<UnitOfMeasure>, Integer, SupplyList> createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts = (selectedUnitsOfMeasurement, numberOfProducts) -> {
        UserSession userSession = userSessions.getActiveUserSession();
        String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
        IndividualProduct individualProductThatDoNotContainSelectedUOMs = productsManager.getTestIndividualProducts()
                .stream()
                .filter(product -> product.getUnitsOfMeasurement()
                        .stream()
                        .noneMatch(selectedUnitsOfMeasurement::contains)
                ).findAny().orElseGet(() -> {
                    throw new NullPointerException("No test products without selected UOMs: " + selectedUnitsOfMeasurement);
                });
        supplyListsManager.createViaApi(userSession, newSupplyListName,
                new ArrayList<IndividualProduct>() {{
                    add(individualProductThatDoNotContainSelectedUOMs);
                }});
        return supplyListsManager.getSupplyListByName(newSupplyListName);
    };
}

package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.CartManager;
import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
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

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

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
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = ((HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP));
        String existingSupplyListName = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                        .noneMatch(selectedUnitsOfMeasurement.keySet()::contains)
                ).findAny()
                .orElseGet(() -> createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(selectedUnitsOfMeasurement.keySet(), 1))
                .getName();

        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, existingSupplyListName);
    }

    @SuppressWarnings("unchecked")
    @Given("^Supply list with at least (\\d+) active products.$")
    public void notEmptySupplyList(int numberOfActiveProductsInSupplyList) {
        SupplyList notEmptySupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .filter(SupplyListProduct::isActive)
                        .mapToLong(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().size())
                        .sum() >= numberOfActiveProductsInSupplyList)
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, numberOfActiveProductsInSupplyList)
                );
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, notEmptySupplyList.getName());
    }

    @Given("^Empty Cart.$")
    public void emptyCart() {
        cartManager.emptyActiveCart(userSessions.getActiveUserSession());
    }

    @SuppressWarnings("unchecked")
    private BiFunction<Set<UnitOfMeasure>, Integer, SupplyList> createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts = (selectedUnitsOfMeasurement, numberOfProducts) -> {
        UserSession userSession = userSessions.getActiveUserSession();
        String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
        ArrayList<IndividualProduct> individualProductsThatDoNotContainSelectedUOMs = productsManager.getTestIndividualProducts()
                .stream()
                .filter(product -> product.getUnitsOfMeasurement()
                        .stream()
                        .noneMatch(selectedUnitsOfMeasurement::contains)
                ).collect(Collectors.toCollection(ArrayList::new));
        List<IndividualProduct> productsToCreate;
        if (individualProductsThatDoNotContainSelectedUOMs.size() >= numberOfProducts)
            productsToCreate = individualProductsThatDoNotContainSelectedUOMs.subList(0, numberOfProducts);
        else
            throw new NullPointerException("No test products without selected UOMs: " + selectedUnitsOfMeasurement + " or quantity of products < " + numberOfProducts + "\n"
                    + "List of filtered products: " + individualProductsThatDoNotContainSelectedUOMs);
        supplyListsManager.createViaApi(userSession, newSupplyListName, productsToCreate);
        return supplyListsManager.getSupplyListByName(newSupplyListName);
    };

    @SuppressWarnings("unchecked")
    @Given("^Add to cart (.*) product with quantity (\\d+).$")
    public void cartWithProducts(List<String> productTypes, int qtyOfProducts) {
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            selectedUnitsOfMeasurement = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, selectedUnitsOfMeasurement);
        } else {
            selectedUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        Product selectedProduct = productsManager.getProductByProductTestTypes(productTypes);
        UnitOfMeasure selectedUOM = selectedProduct.getUnitsOfMeasurement().stream().findAny().orElse(null);
        selectedUnitsOfMeasurement.put(selectedUOM, qtyOfProducts);
        cartManager.addUOMsToCartViaApi(userSessions.getActiveUserSession(), new HashMap<UnitOfMeasure, Integer>() {{
            put(selectedUOM, qtyOfProducts);
        }});
    }
}

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

public class PreConditionStepDefs extends AbstractStepDefs {
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
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
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
                .filter(SupplyList::isActive)
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
    public void cartWithProducts(List<String> productTypes, int qtyOfProduct) {
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
        Product selectedProduct = productsManager.getProductByProductTestTypes(productTypes);
        UnitOfMeasure selectedUOM = selectedProduct.getUnitsOfMeasurement().stream().findAny().orElse(null);
        selectedUnitsOfMeasurement.put(selectedUOM, qtyOfProduct);
        cartManager.addUOMsToCartViaApi(userSessions.getActiveUserSession(), new HashMap<UnitOfMeasure, Integer>() {{
            put(selectedUOM, qtyOfProduct);
        }});
    }

    @SuppressWarnings("unchecked")
    @And("^Add to cart (.*) product with quantity (\\d+) that hasn't been added before.$")
    public void setQTYToAnyProductUOMThatHasNotBeenSelectedOnThePDP(List<String> productTypes, int qtyOfProduct) {
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
        List<IndividualProduct> selectedProducts = selectedUnitsOfMeasurement.keySet()
                .stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .distinct()
                .collect(Collectors.toList());
        IndividualProduct selectedProduct = productsManager.getUniqueProductsByProductsQuantityAndTestTypes(
                selectedProducts.size() + 1,
                productTypes)
                .stream()
                .map(product -> (IndividualProduct) product)
                .filter(product -> !selectedProducts.contains(product))
                .findAny()
                .orElse(null);
        UnitOfMeasure selectedUOM = selectedProduct.getUnitsOfMeasurement().stream().findAny().orElse(null);
        selectedUnitsOfMeasurement.put(selectedUOM, qtyOfProduct);
        cartManager.addUOMsToCartViaApi(userSessions.getActiveUserSession(), new HashMap<UnitOfMeasure, Integer>() {{
            put(selectedUOM, qtyOfProduct);
        }});
    }

    @SuppressWarnings("unchecked")
    @Given("^Active Supply list exists.$")
    public void notEmptyActiveSupplyList() {
        SupplyList activeSupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, 1)
                );
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, activeSupplyList.getName());
    }


    @SuppressWarnings("unchecked")
    @Given("^Active Supply list with at least (\\d+) active products exists.$")
    public void activeSupplyListWithAtLeastActiveProductsQuantity(int qtyOfActiveProducts) {
        SupplyList activeSupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .filter(SupplyListProduct::isActive)
                        .count() >= qtyOfActiveProducts)
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, qtyOfActiveProducts)
                );
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, activeSupplyList.getName());
    }

    @SuppressWarnings("unchecked")
    @Given("^Active Supply list with only (\\d+) active products exists.$")
    public void activeSupplyListWithOnlyActiveProductsQuantity(int qtyOfActiveProducts) {
        SupplyList activeSupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .filter(SupplyListProduct::isActive)
                        .count() == qtyOfActiveProducts)
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, qtyOfActiveProducts)
                );
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, activeSupplyList.getName());
    }

    @SuppressWarnings("unchecked")
    @Given("^Inactive Supply list exists.$")
    public void inactiveSupplyListExists() {
        SupplyList inactiveSupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(supplyList -> !supplyList.isActive())
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, 1)
                );
        if (inactiveSupplyList.isActive())
            supplyListsManager.deactivate(userSessions.getActiveUserSession(), inactiveSupplyList);
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, inactiveSupplyList.getName());
    }

    @Given("^Active Supply list with at least (\\d+) inactive products exists.$")
    public void activeSupplyListWithAtLeastInactiveProductsExists(int qtyOfInactiveProducts) {
        SupplyList activeSupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .filter(supplyListProduct -> !supplyListProduct.isActive())
                        .count() >= qtyOfInactiveProducts)
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, qtyOfInactiveProducts)
                );
        if(activeSupplyList.getSupplyProductsInList()
                .stream()
                .filter(supplyListProduct -> !supplyListProduct.isActive())
                .count() < qtyOfInactiveProducts) {
            activeSupplyList.getSupplyProductsInList().forEach(supplyListProduct -> {
                supplyListsManager.deactivateProductInList(userSessions.getActiveUserSession(), activeSupplyList, supplyListProduct);
            });
        }
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, activeSupplyList.getName());
    }

    @Given("^Active not favorite Supply list exists.$")
    public void activeNotFavoriteSupplyListExists() {
        SupplyList activeSupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .filter(supplyList -> !supplyList.isFavorite())
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, 1)
                );
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, activeSupplyList.getName());
    }

    @Given("^Active favorite Supply list exists.$")
    public void activeFavoriteSupplyListExists() {
        SupplyList activeSupplyList = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .filter(SupplyList::isFavorite)
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, 1)
                );
        if (!activeSupplyList.isFavorite()) {
            supplyListsManager.markSupplyListAsFavorite(userSessions.getActiveUserSession(), activeSupplyList);
        }
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, activeSupplyList.getName());
    }
}

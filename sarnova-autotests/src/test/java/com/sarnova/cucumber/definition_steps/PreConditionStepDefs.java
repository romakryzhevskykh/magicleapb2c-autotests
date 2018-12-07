package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.RandomUtils;
import com.sarnova.helpers.managers.*;
import com.sarnova.helpers.models.categories.Category;
import com.sarnova.helpers.models.categories.ChildCustomCategory;
import com.sarnova.helpers.models.categories.ParentCustomCategory;
import com.sarnova.helpers.models.credit_cards.CreditCard;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.saved_carts.SavedCart;
import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.helpers.models.users.UserGroup;
import com.sarnova.helpers.models.users.UserInformation;
import com.sarnova.helpers.user_engine.*;
import com.sarnova.pay_fabric.page_blocks.PayFabricHeaderBlock;
import com.sarnova.pay_fabric.page_blocks.PayFabricLeftBarBlock;
import com.sarnova.pay_fabric.pages.PayFabricLoginPage;
import com.sarnova.storefront.models.SarnovaStorefront;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.HomePage;
import com.sarnova.storefront.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PreConditionStepDefs extends AbstractStepDefs {
    @Autowired private HeaderRowPageBlock headerRowPageBlock;
    @Autowired private LoginPage loginPage;
    @Autowired private PayFabricLoginPage payFabricLoginPage;
    @Autowired private HomePage homePage;
    @Autowired private SarnovaStorefront sarnovaStorefront;
    @Autowired private SupplyListsManager supplyListsManager;
    @Autowired private UserGroupsManager userGroupsManager;
    @Autowired private ProductsManager productsManager;
    @Autowired private CartManager cartManager;
    @Autowired private SavedCartsManager savedCartsManager;
    @Autowired private UsersManager usersManager;
    @Autowired private CustomCategoriesManager customCategoriesManager;
    @Autowired private RandomUtils randomUtils;
    @Autowired private PayFabricLeftBarBlock payFabricLeftBarBlock;
    @Autowired private PayFabricHeaderBlock payFabricHeaderBlock;
    @Autowired private QuickOrderManager quickOrderManager;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (headerRowPageBlock.isUserLoggedOut()) {
            loginPage.open();
            loginPage.loginToStorefront(userSessions.getActiveUserSession());
        } else if (!headerRowPageBlock.isUserLoggedOut() && !headerRowPageBlock.isUserLoggedIn()) {
            homePage.open();
            if (headerRowPageBlock.isUserLoggedOut()) {
                loginPage.open();
                loginPage.loginToStorefront(userSessions.getActiveUserSession());
            }
        }
    }

    @And("^User is logged out from Storefront.$")
    public void userIsLoggedOutFromStorefront() {
        if (headerRowPageBlock.isUserLoggedIn()) {
            headerRowPageBlock.logoutFromStorefront(userSessions.getActiveUserSession());
        } else if (!headerRowPageBlock.isUserLoggedOut() && !headerRowPageBlock.isUserLoggedIn()) {
            homePage.open();
            if (headerRowPageBlock.isUserLoggedIn()) {
                headerRowPageBlock.logoutFromStorefront(userSessions.getActiveUserSession());
            }
        }
    }

    @Given("^User is logged in to Pay Fabric.$")
    public void userIsLoggedInToPayFabric() {
        if (!payFabricLeftBarBlock.isVisible()) {
            payFabricLoginPage.open();
            payFabricLoginPage.loginToPayFabric(userSessions.getActiveUserSession());
        }
    }

    @Given("^Set Sandbox to non live key.$")
    public void sandboxInNonLiveKey() {
        payFabricHeaderBlock.setNonLiveKey();
    }

    @SuppressWarnings("unchecked")
    @And("^Active Supply list that doesn't contain this products exists.$")
    public void existingSupplyListThatDoesNotContainThisProducts() {
        Map<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
        String existingSupplyListName = supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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
        cartManager.clearActiveCart(userSessions.getActiveUserSession());
    }

    @SuppressWarnings("unchecked")
    private BiFunction<Set<UnitOfMeasure>, Integer, SupplyList> createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts = (selectedUnitsOfMeasurement, numberOfProducts) -> {
        UserSession userSession = userSessions.getActiveUserSession();
        String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
        List<IndividualProduct> individualProductsThatDoNotContainSelectedUOMs = productsManager.getTestIndividualProducts()
                .stream()
                .filter(product -> product.getUnitsOfMeasurement()
                        .stream()
                        .noneMatch(selectedUnitsOfMeasurement::contains)
                ).collect(Collectors.toCollection(ArrayList::new));
        List<IndividualProduct> productsToCreate;
        if (individualProductsThatDoNotContainSelectedUOMs.size() >= numberOfProducts)
            productsToCreate = individualProductsThatDoNotContainSelectedUOMs.subList(0, numberOfProducts);
        else
            throw new IllegalStateException("No test products without selected UOMs: " + selectedUnitsOfMeasurement + " or quantity of products < " + numberOfProducts + "\n"
                    + "List of filtered products: " + individualProductsThatDoNotContainSelectedUOMs);
        boolean restorePermission = false;
        UserGroup restoreUserGroup = null;
        if (userSession.getUser().getUserRoles().stream().anyMatch(UserRole::isTest)) {
            if (userSession.getUser().getUserGroups().stream().noneMatch(userGroup -> userGroup.getPermissions().contains(Permission.MANAGE_SUPPLY_LISTS))) {
                restorePermission = true;
                restoreUserGroup = userSession.getUser().getUserGroups()
                        .stream()
                        .findAny()
                        .orElseGet(() -> {
                            throw new IllegalStateException("No user groups: " + userSession.getUser().getUserGroups()
                                    + " for user: " + userSession.getUser());
                        });
                userGroupsManager.addPermissionToUserGroup(userSessions.getAnyUserSessionForUser(usersManager.getUserByRole(StorefrontUserRole.ADMIN)),
                        restoreUserGroup,
                        Permission.MANAGE_SUPPLY_LISTS);
                restoreUserGroup.getPermissions().add(Permission.MANAGE_SUPPLY_LISTS);
            }
        }
        supplyListsManager.createViaApi(userSession, newSupplyListName, productsToCreate);
        if (restorePermission) {
            userGroupsManager.removePermissionToUserGroup(userSessions.getAnyUserSessionForUser(usersManager.getUserByRole(StorefrontUserRole.ADMIN)),
                    restoreUserGroup,
                    Permission.MANAGE_SUPPLY_LISTS);
            restoreUserGroup.getPermissions().remove(Permission.MANAGE_SUPPLY_LISTS);
        }
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
        Map<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
        List<IndividualProduct> selectedProducts = selectedUnitsOfMeasurement.keySet()
                .stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .distinct()
                .collect(Collectors.toList());
        IndividualProduct selectedProduct = productsManager.getUniqueProductsByProductsQuantityTestTypesAndExcludeProductList(
                1,
                productTypes, selectedProducts)
                .stream()
                .map(product -> (IndividualProduct) product)
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
                .filter(SupplyList::isActive)
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .filter(supplyListProduct -> !supplyListProduct.isActive())
                        .count() >= qtyOfInactiveProducts)
                .findAny()
                .orElseGet(() ->
                        createSupplyListThatDoesNotContainUOMsAndWithNumberOfProducts.apply(Collections.EMPTY_SET, qtyOfInactiveProducts)
                );
        if (activeSupplyList.getSupplyProductsInList()
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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
                .filter(supplyList -> supplyList.getUser() == userSessions.getActiveUserSession().getUser())
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

    @And("^Test user is present.$")
    public void testUserIsPresent() {
        User testUser = usersManager.getTestUser(sarnovaStorefront);
        System.out.println(usersManager.getTestUser(sarnovaStorefront));
        if (testUser == null) {
            usersManager.createTestUserByApi(userSessions.getActiveUserSession());
            testUser = usersManager.getTestUser(sarnovaStorefront);
        }
        threadVarsHashMap.put(TestKeyword.TEST_USER_USERNAME, testUser.getUsername());
    }

    //    Test user with set password
    @And("^Valid test user is present.$")
    public void validTestUserIsPresent() {
        User testUser = usersManager.getTestUser(sarnovaStorefront);
        if (testUser == null) {
            usersManager.createTestUserByApi(userSessions.getActiveUserSession());
            testUser = usersManager.getTestUser(sarnovaStorefront);
            usersManager.resetPassword(userSessions.getActiveUserSession(), testUser);
        } else if (testUser.getPassword().isEmpty()) {
            usersManager.resetPassword(userSessions.getActiveUserSession(), testUser);
        }
        threadVarsHashMap.put(TestKeyword.TEST_USER_USERNAME, testUser.getUsername());
    }

    @And("^Test user group is present.$")
    public void testUserGroupIsPresent() {
        if (userGroupsManager.getUserGroups().isEmpty())
            userGroupsManager.createUserGroup(userSessions.getActiveUserSession());
        threadVarsHashMap.put(TestKeyword.TEST_USER_GROUP_UID, userGroupsManager.getUserGroups().stream().findAny().get().getUId());
    }

    @And("^Test user has only test user group assigned.$")
    public void testUserHasOnlyTestUserGroupAssigned() {
        UserGroup testUserGroup = userGroupsManager.getUserGroupByUid(threadVarsHashMap.getString(TestKeyword.TEST_USER_GROUP_UID));
        User testUser = usersManager.getUserByUsername(threadVarsHashMap.getString(TestKeyword.TEST_USER_USERNAME));
        if (!testUser.isInitialized())
            usersManager.initUserGroups(userSessions.getActiveUserSession(), testUser);
        if (testUser.getUserGroups().isEmpty() || !testUser.getUserGroups().stream().allMatch(userGroup -> userGroup == testUserGroup)) {
            usersManager.removeAllUserGroupsForUser(userSessions.getActiveUserSession(), testUser);
            usersManager.setUserGroupForUser(userSessions.getActiveUserSession(), testUser, testUserGroup);
        }
    }

    @And("^Test user has no any roles.$")
    public void testUserHasNoRoles() {
        User testUser = usersManager.getUserByUsername(threadVarsHashMap.getString(TestKeyword.TEST_USER_USERNAME));
        if (!testUser.isInitialized())
            usersManager.initUserGroups(userSessions.getActiveUserSession(), testUser);
        if (!testUser.getUserRoles().isEmpty() && !(testUser.getUserRoles().size() == 1 && testUser.getUserRoles().contains(StorefrontUserRole.ORGANIZATION_TEST_USER))) {
            usersManager.removeAllUserRolesForUser(userSessions.getActiveUserSession(), testUser);
        }
    }

    @And("^Test user group has no any permissions.$")
    public void testUserGroupHasNoAnyPermissions() {
        UserGroup testUserGroup = userGroupsManager.getUserGroupByUid(threadVarsHashMap.getString(TestKeyword.TEST_USER_GROUP_UID));
        userGroupsManager.initPermissionsToTheUserGroup(userSessions.getActiveUserSession(), testUserGroup);
        userGroupsManager.removePermissionsToUserGroup(userSessions.getActiveUserSession(), testUserGroup, testUserGroup.getPermissions());
    }

    @And("^Test user group has only (.*) permission.$")
    public void testUserGroupHasOnlyPermission(String permissionName) {
        Permission testPermission = Permission.valueOf(permissionName);
        UserGroup testUserGroup = userGroupsManager.getUserGroupByUid(threadVarsHashMap.getString(TestKeyword.TEST_USER_GROUP_UID));
        if (!testUserGroup.isInitiated())
            userGroupsManager.initPermissionsToTheUserGroup(userSessions.getActiveUserSession(), testUserGroup);
        if (testUserGroup.getPermissions().isEmpty()) {
            userGroupsManager.addPermissionToUserGroup(userSessions.getActiveUserSession(), testUserGroup, testPermission);
            testUserGroup.getPermissions().add(testPermission);
        } else if (!testUserGroup.getPermissions().stream().allMatch(permission -> permission == testPermission)) {
            if (!testUserGroup.getPermissions().contains(testPermission)) {
                userGroupsManager.removePermissionsToUserGroup(userSessions.getActiveUserSession(), testUserGroup, testUserGroup.getPermissions());
                userGroupsManager.addPermissionToUserGroup(userSessions.getActiveUserSession(), testUserGroup, testPermission);
                testUserGroup.getPermissions().add(testPermission);
            } else {
                List<Permission> permissionsToRemove = new ArrayList<>(testUserGroup.getPermissions());
                permissionsToRemove.remove(testPermission);
                userGroupsManager.removePermissionsToUserGroup(userSessions.getActiveUserSession(), testUserGroup, permissionsToRemove);
            }
        }
    }

    @And("^Supply list is shared with Test user.$")
    public void supplyListIsSharedWithTestUser() {
        String existingSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList supplyList = supplyListsManager.getSupplyListByName(existingSupplyListName);
        User userToShareWith = usersManager.getUserByUsername(threadVarsHashMap.getString(TestKeyword.TEST_USER_USERNAME));
        supplyListsManager.shareSupplyListWithUser(userSessions.getActiveUserSession(), userToShareWith, supplyList);
    }

    @And("^Test parent Custom category is present.$")
    public void testParentCustomCategoryIsPresent() {
        Category category = getOrCreateParentCustomCategory();
        threadVarsHashMap.put(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID, category.getId());
    }

    @And("^Test child Custom category is present.$")
    public void testChildCustomCategoryIsPresent() {
        ChildCustomCategory category = getOrCreateChildCustomCategory();
        threadVarsHashMap.put(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID, category.getParentCustomCategory().getId());
        threadVarsHashMap.put(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY_ID, category.getId());
    }

    private ParentCustomCategory getOrCreateParentCustomCategory() {
        return (ParentCustomCategory) customCategoriesManager.getCustomCategories().stream()
                .filter(ParentCustomCategory.class::isInstance)
                .filter(parentCustomCategory -> parentCustomCategory.getDepartment()
                        .equals(userSessions.getActiveUserSession().getUser().getDepartment()))
                .findAny().orElseGet(() -> {
                    String ccName = RandomStringUtils.randomAlphabetic(8);
                    return customCategoriesManager.createNewParentCustomCategoryByApi(userSessions.getActiveUserSession(), ccName);
                });
    }

    @And("^At least (\\d+) product in child Custom category.$")
    public void atLeastProductInChildCustomCategory(int productsInChildCC) {
        ChildCustomCategory category = getOrCreateChildCustomCategory();
        threadVarsHashMap.put(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID, category.getParentCustomCategory().getId());
        threadVarsHashMap.put(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY_ID, category.getId());
        if (category.getProducts().size() < productsInChildCC) {
            List<Product> productsToAdd = productsManager.getUniqueProductsByProductsQuantityTestTypesAndExcludeProductList(productsInChildCC,
                    new ArrayList<String>() {{
                        add("INDIVIDUAL");
                    }},
                    new ArrayList<>());
            customCategoriesManager.addProductsToCategoryByApi(userSessions.getActiveUserSession(), category, productsToAdd);
        }
    }

    private ChildCustomCategory getOrCreateChildCustomCategory() {
        return ((ParentCustomCategory) customCategoriesManager.getCustomCategories().stream()
                .filter(ParentCustomCategory.class::isInstance)
                .filter(parentCustomCategory -> parentCustomCategory.getDepartment()
                        .equals(userSessions.getActiveUserSession().getUser().getDepartment()))
                .filter(parentCategory -> !((ParentCustomCategory) parentCategory).getChildCustomCategories().isEmpty())
                .findAny()
                .orElseGet(() -> {
                    ParentCustomCategory parentCategory = getOrCreateParentCustomCategory();
                    String ccName = RandomStringUtils.randomAlphabetic(8);
                    customCategoriesManager.createNewChildCustomCategoryByApi(userSessions.getActiveUserSession(), ccName, parentCategory);
                    return parentCategory;
                })).getChildCustomCategories().stream().findAny().get();
    }

    @And("^Saved Cart with at least (\\d+) products has been created.$")
    public void createSavedCartWithAtLeastProduct(int qtyOfProductInCart) {
        List<SavedCart> savedCarts = savedCartsManager.getUserSavedCarts(userSessions.getActiveUserSession().getUser());
        if (savedCarts.isEmpty()) {
            List<UnitOfMeasure> unitOfMeasures = productsManager.getUniqueUOMsByUOMsQuantityAndProductTestTypes(qtyOfProductInCart, new ArrayList<>());
            unitOfMeasures.forEach(uom -> getSelectedUOMS().put(uom, 1));
            cartManager.addUOMsToCartViaApi(userSessions.getActiveUserSession(), getSelectedUOMS());
            savedCartsManager.createSavedCartByApi(userSessions.getActiveUserSession(), getSelectedUOMS());
        }
        SavedCart savedCart = savedCartsManager.getUserSavedCarts(userSessions.getActiveUserSession().getUser()).stream().findAny().orElse(null);
        threadVarsHashMap.put(TestKeyword.SAVED_CART_ID, savedCart.getId());
    }

    @And("^Find any random valid Shipping address.$")
    public void findAnyRandomValidShippingAddress() {
        ShippingAddress shippingAddress = randomUtils.getRandomValidShippingAddressWithOnlyMandatoryFields();
        threadVarsHashMap.put(TestKeyword.TEST_SHIPPING_ADDRESS, shippingAddress);
    }

    @And("^Find any random valid Billing address.$")
    public void findAnyRandomValidBillingAddress() {
        ShippingAddress shippingAddress = randomUtils.getRandomValidShippingAddressWithOnlyMandatoryFields();
        threadVarsHashMap.put(TestKeyword.TEST_BILLING_ADDRESS, shippingAddress);
    }

    @And("^Find any random valid Credit card.$")
    public void findAnyRandomValidCreditCard() {
        CreditCard creditCard = randomUtils.getRandomCreditCard();
        threadVarsHashMap.put(TestKeyword.CREDIT_CARD, creditCard);
    }

    @And("^Quick order list is empty.$")
    public void quickOrderListIsEmpty() {
        Map<UnitOfMeasure, Integer> uomsInQO = quickOrderManager.getUOMs(userSessions.getActiveUserSession());
        if (!uomsInQO.isEmpty()) {
            quickOrderManager.removeAllProductsFromList(userSessions.getActiveUserSession());
        }
    }

    @When("^Generate any random User information.$")
    public void generateAnyRandomUserInformation() {
        UserInformation userInformation = randomUtils.getRandomUserInformation();
        threadVarsHashMap.put(TestKeyword.USER_INFORMATION, userInformation);
    }
}

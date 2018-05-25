package com.sarnova.storefront.pages;

import com.sarnova.helpers.models.categories.Category;
import com.sarnova.helpers.models.categories.ChildCustomCategory;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.CustomCategoryPageElements.*;

@Component
public class CustomCategoryPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/custom-category";

    @Step("Is Custom categories tree visible?")
    public boolean isCustomCategoriesTreeVisible() {
        return isDisplayed(CATEGORIES_TREE_XPATH);
    }

    @Step("Is new Custom category name field visible?")
    public boolean isNewCustomCategoryNameFieldVisible() {
        return isDisplayed(NEW_CUSTOM_CATEGORY_NAME_FIELD_XPATH);
    }

    @Step("Is Add new Custom category button visible?")
    public boolean isAddNewCustomCategoryButtonVisible() {
        return isDisplayed(ADD_NEW_CUSTOM_CATEGORY_BUTTON_XPATH);
    }

    @Step("Is parent category {0} visible?")
    public boolean isParentCCVisible(Category category) {
        return isDisplayed(PARENT_CATEGORY_ITEM_BY_ID_XPATH, category.getId());
    }

    @Step("Is child category {0} visible?")
    public boolean isChildCCVisible(Category category) {
        return isDisplayed(CHILD_CATEGORY_BLOCK_BY_ID_XPATH, category.getId());
    }

    @Step("Expand parent category {0} in the tree.")
    public void expandParentCCItemInTheTree(Category category) {
        click(EXPAND_PARENT_CATEGORY_ARROW_XPATH, category.getId());
        waitUntilElementIsVisible(ADD_CHILD_BLOCK_BY_PARENT_ID_XPATH, category.getId());
    }

    @Step("Show child category {0}.")
    public void showChildCC(Category category) {
        click(SHOW_CHILD_CATEGORY_BY_ID_XPATH, category.getId());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Open child Custom category {0}.")
    public void clickOnOpenChildCC(Category childCustomCategory) {
        click(SHOW_CHILD_CATEGORY_BY_ID_XPATH, childCustomCategory.getId());
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get displayed product's SKUs on the page.")
    public ArrayList<String> getDisplayedProductSKUs() {
        return $$(PRODUCTS_ROWS_XPATH).stream()
                .map(webElement -> webElement.getAttribute("data-product-code"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Step("Is remove parent Custom category {0} button visible?")
    public boolean isRemoveParentCustomCategoryButtonVisible(Category category) {
        return isDisplayed(REMOVE_PARENT_CATEGORY_BUTTON_BY_ID_XPATH, category.getId());
    }

    @Step("Is Add child to parent Custom category {0} button visible?")
    public boolean isAddChildCustomCategoryButtonVisible(Category category) {
        return isDisplayed(ADD_CHILD_TO_PARENT_CATEGORY_BUTTON_BY_ID_XPATH, category.getId());
    }

    @Step("Is Add child to parent Custom category {0} text field visible?")
    public boolean isAddChildCustomCategoryTextFieldVisible(Category category) {
        return isDisplayed(ADD_CHILD_TO_PARENT_CATEGORY_TEXT_FIELD_BY_ID_XPATH, category.getId());
    }

    @Step("Is remove child Custom category {0} button visible?")
    public boolean isRemoveChildCustomCategoryButtonVisible(Category category) {
        return isDisplayed(REMOVE_CHILD_CATEGORY_BUTTON_BY_ID_XPATH, category.getId());
    }

    @Step("Is Quick Add block visible?")
    public boolean isQuickAddVisible() {
        return isDisplayed(QUICK_ADD_BLOCK_XPATH);
    }

    @Step("Are remove category {0} products buttons visible?")
    public boolean areRemoveProductsFromCCButtonsVisible(ChildCustomCategory category) {
        category.getProducts()
                .forEach(product -> System.out.println(String.format(REMOVE_PRODUCT_FROM_CATEGORY_BY_PRODUCT_ID_BUTTON_XPATH, product.getSku())));
        return category.getProducts().stream()
                .allMatch(product -> isDisplayed(REMOVE_PRODUCT_FROM_CATEGORY_BY_PRODUCT_ID_BUTTON_XPATH, product.getSku()));
    }

    @Step("Click on Add items button.")
    public void clickOnQuickAdd() {
        click(By.id(TOGGLE_QUICK_ADD_CHECKBOX_ID));
    }

    @Step("Is Manage Existing Products item visible?")
    public boolean isManageExistingProductsItemVisible() {
        return isDisplayed(MANAGE_EXISTING_PRODUCTS_ITEM_XPATH);
    }

    @Step("Click on Manage Existing Products item.")
    public void clickOnManageExistingProductsItem() {
        click(OPEN_MANAGE_EXISTING_PRODUCTS_BLOCK_XPATH);
        waitUntilPageIsFullyLoaded();
    }
}

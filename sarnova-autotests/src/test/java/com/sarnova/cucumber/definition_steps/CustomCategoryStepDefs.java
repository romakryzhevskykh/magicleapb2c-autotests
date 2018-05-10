package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.CustomCategoriesManager;
import com.sarnova.helpers.models.categories.Category;
import com.sarnova.helpers.models.categories.ChildCustomCategory;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.storefront.pages.CustomCategoryPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class CustomCategoryStepDefs extends AbstractStepDefs {

    @Autowired CustomCategoriesManager customCategoriesManager;
    @Autowired CustomCategoryPage customCategoryPage;

    @When("^Open Custom category page.$")
    public void openCustomCategoryPage() {
        customCategoryPage.open();
    }

    @Then("Check that Custom Categories page is opened.")
    public void checkThatCustomCategoriesPageIsOpened() {
        assertTrue(customCategoryPage.isOpened());
    }

    @Then("Check that Categories tree is visible on Custom categories page.")
    public void checkThatCategoriesTreeIsVisible() {
        assertTrue(customCategoryPage.isCustomCategoriesTreeVisible());
    }

    @Then("^Check that new Custom Category name field is visible on Custom categories page.$")
    public void checkThatNewCustomCategoryNameFieldIsVisibleOnCustomCategoriesPage() {
        assertTrue(customCategoryPage.isNewCustomCategoryNameFieldVisible());

    }

    @And("^Check that Add new Custom Category button is visible on Custom categories page.$")
    public void checkThatAddNewCustomCategoryButtonIsVisibleOnCustomCategoriesPage() {
        assertTrue(customCategoryPage.isAddNewCustomCategoryButtonVisible());
    }

    @Then("^Check that parent Custom category is visible on Custom categories page.$")
    public void checkThatParentCustomCategoryIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        Category category = customCategoriesManager.getCustomCategoryById(ccId);
        assertTrue(customCategoryPage.isParentCCVisible(category));
    }

    @And("^Expand parent Custom category on Custom categories page.$")
    public void expandParentCustomCategoryOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        Category category = customCategoriesManager.getCustomCategoryById(ccId);
        customCategoryPage.expandParentCCItemInTheTree(category);
    }

    @Then("^Check that child Custom category is visible on Custom categories page.$")
    public void checkThatChildCustomCategoryIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY_ID);
        Category category = customCategoriesManager.getCustomCategoryById(ccId);
        customCategoryPage.isChildCCVisible(category);
    }

    @And("^Open child Custom category on Custom categories page.$")
    public void openChildCustomCategoryOnCustomCategoriesPage() {
        Category childCustomCategory = customCategoriesManager.getCustomCategoryById(threadVarsHashMap.getString(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY_ID));
        customCategoryPage.clickOnOpenChildCC(childCustomCategory);
    }

    @Then("^Check that products are displayed on Custom categories page.$")
    public void checkThatProductsAreDisplayedOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY_ID);
        ChildCustomCategory category = (ChildCustomCategory)customCategoriesManager.getCustomCategoryById(ccId);
        ArrayList<String> categoryProductSKUs = category.getProducts().stream()
                .map(Product::getSku)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<String> productsSKUsOnThePage = customCategoryPage.getDisplayedProductSKUs();
        assertTrue(productsSKUsOnThePage.containsAll(categoryProductSKUs));
    }

    @Then("^Check that Remove parent Custom category button is visible on Custom categories page.$")
    public void checkThatRemoveParentCustomCategoryButtonIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        Category category = customCategoriesManager.getCustomCategoryById(ccId);
        assertTrue(customCategoryPage.isRemoveParentCustomCategoryButtonVisible(category));
    }

    @Then("^Check that Add child category to parent button is visible on Custom categories page.$")
    public void checkThatAddChildCategoryToParentButtonIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        Category category = customCategoriesManager.getCustomCategoryById(ccId);
        assertTrue(customCategoryPage.isAddChildCustomCategoryButtonVisible(category));
    }

    @Then("^Check that Add child category to parent text field is visible on Custom categories page.$")
    public void checkThatAddChildCategoryToParentTextFieldIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        Category category = customCategoriesManager.getCustomCategoryById(ccId);
        assertTrue(customCategoryPage.isAddChildCustomCategoryTextFieldVisible(category));
    }

    @Then("^Check that Remove child Custom category button is visible on Custom categories page.$")
    public void checkThatRemoveChildCustomCategoryButtonIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY_ID);
        Category category = customCategoriesManager.getCustomCategoryById(ccId);
        assertTrue(customCategoryPage.isRemoveChildCustomCategoryButtonVisible(category));
    }

    @Then("^Check that Add items button is visible on Custom categories page.$")
    public void checkThatAddItemsButtonIsVisibleOnCustomCategoriesPage() {
        assertTrue(customCategoryPage.isAddItemsButtonVisible());
    }

    @And("^Check that Remove product buttons are visible on Custom categories page.$")
    public void checkThatRemoveProductButtonsAreVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY_ID);
        ChildCustomCategory category = (ChildCustomCategory) customCategoriesManager.getCustomCategoryById(ccId);
        assertTrue(customCategoryPage.areRemoveProductsFromCCButtonsVisible(category));
    }

    @And("^Click on Add items button on Custom categories page.$")
    public void clickOnAddItemsButtonOnCustomCategoriesPage() {
        customCategoryPage.clickOnAddItemsButton();
    }
}

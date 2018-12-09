package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.CustomCategoriesManager;
import com.sarnova.helpers.models.categories.ChildCustomCategory;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.storefront.pages.CustomCategoryPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;

public class CustomCategoryStepDefs extends AbstractStepDefs {

    @Autowired
    CustomCategoriesManager customCategoriesManager;
    @Autowired
    CustomCategoryPage customCategoryPage;

    @When("^Open Custom category page.$")
    public void openCustomCategoryPage() {
        customCategoryPage.open();
    }

    @Then("Check that Custom Categories page is opened.")
    public void checkThatCustomCategoriesPageIsOpened() {
        assertTrue(customCategoryPage.isOpened());
    }

    @And("^Check that Categories tree, New Category field and Add button are visible on Custom categories page.$")
    public void checkThatCategoriesTreeNewCategoryFieldAndAddButtonAreVisibleOnCustomCategoriesPage() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(customCategoryPage.isCustomCategoriesTreeVisible()).as("Custom category tree isn't visible").isTrue();
        softly.assertThat(customCategoryPage.isNewCustomCategoryNameFieldVisible()).as("New Custom category field isn't visible").isTrue();
        softly.assertThat(customCategoryPage.isAddNewCustomCategoryButtonVisible()).as("Add New Custom category button isn't visible").isTrue();
        softly.assertAll();
    }

    @Then("^Check that parent Custom category is visible on Custom categories page.$")
    public void checkThatParentCustomCategoryIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        assertTrue(customCategoryPage.isParentCCVisible(ccId));
    }

    @And("^Expand parent Custom category on Custom categories page.$")
    public void expandParentCustomCategoryOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        customCategoryPage.expandParentCCItemInTheTree(ccId);
    }

    @Then("^Check that child Custom category is visible on Custom categories page.$")
    public void checkThatChildCustomCategoryIsVisibleOnCustomCategoriesPage() {
        customCategoryPage.isChildCCVisible(getCreatedChildCategory());
    }

    @And("^Open child Custom category on Custom categories page.$")
    public void openChildCustomCategoryOnCustomCategoriesPage() {
        customCategoryPage.clickOnOpenChildCC(getCreatedChildCategory());
    }

    @Then("^Check that products are displayed on Custom categories page.$")
    public void checkThatProductsAreDisplayedOnCustomCategoriesPage() {
        List<String> categoryProductSKUs = getCreatedChildCategory().getProducts().stream()
                .map(Product::getSku)
                .collect(toList());
        List<String> productsSKUsOnThePage = customCategoryPage.getDisplayedProductSKUs();
        assertTrue(productsSKUsOnThePage.containsAll(categoryProductSKUs));
    }

    private ChildCustomCategory getCreatedChildCategory() {
        return (ChildCustomCategory) threadVarsHashMap.get(TestKeyword.TEST_CHILD_CUSTOM_CATEGORY);
    }

    @Then("^Check that Remove parent Custom category button is visible on Custom categories page.$")
    public void checkThatRemoveParentCustomCategoryButtonIsVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        assertTrue(customCategoryPage.isRemoveParentCustomCategoryButtonVisible(ccId));
    }

    @Then("^Check that New Subcategory field and Add Subcategory button are visible on Custom categories page.$")
    public void checkThatNewSubcategoryFieldAndAddSubcategoryButtonAreVisibleOnCustomCategoriesPage() {
        String ccId = threadVarsHashMap.getString(TestKeyword.TEST_PARENT_CUSTOM_CATEGORY_ID);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(customCategoryPage.isAddChildCustomCategoryButtonVisible(ccId)).as("Add Subcategory button isn't visible").isTrue();
        softly.assertThat(customCategoryPage.isAddChildCustomCategoryTextFieldVisible(ccId)).as("New Subcategory field isn't visible").isTrue();
        softly.assertAll();
    }

    @Then("^Check that Remove child Custom category button is visible on Custom categories page.$")
    public void checkThatRemoveChildCustomCategoryButtonIsVisibleOnCustomCategoriesPage() {
        assertTrue(customCategoryPage.isRemoveChildCustomCategoryButtonVisible(getCreatedChildCategory()));
    }

    @Then("^Check that Quick Add block is visible on Custom categories page.$")
    public void checkThatAddItemsButtonIsVisibleOnCustomCategoriesPage() {
        assertTrue(customCategoryPage.isQuickAddVisible());
    }

    @And("^Check that Remove product buttons are visible on Custom categories page.$")
    public void checkThatRemoveProductButtonsAreVisibleOnCustomCategoriesPage() {
        assertTrue(customCategoryPage.areRemoveProductsFromCCButtonsVisible(getCreatedChildCategory()));
    }

    @And("^Click on Quick Add checkbox on Custom categories page.$")
    public void clickOnAddItemsButtonOnCustomCategoriesPage() {
        customCategoryPage.clickOnQuickAdd();
    }

    @Then("^Check that Manage Existing Products item is visible on Custom Category page.$")
    public void checkThatManageExistingProductsItemIsVisibleOnCustomCategoryPage() {
        assertTrue(customCategoryPage.isManageExistingProductsItemVisible());
    }

    @Then("^Click on Manage Existing Products item on Custom Category page.$")
    public void clickOnManageExistingProductsItemOnCustomCategoryPage() {
        customCategoryPage.clickOnManageExistingProductsItem();
    }

    @After("@deletecustomcategory")
    @And("^Delete custom categories.$")
    public void deleteCustomCategories() {
        customCategoriesManager.deleteAllCustomCategories();
    }
}

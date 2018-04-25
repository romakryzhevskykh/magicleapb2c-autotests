package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.CustomCategoryPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class CustomCategoryStepDefs extends AbstractStepDefs {
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
}

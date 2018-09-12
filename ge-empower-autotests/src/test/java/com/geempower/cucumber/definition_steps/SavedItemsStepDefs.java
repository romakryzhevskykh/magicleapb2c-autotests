package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.SavedItemsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.*;

public class SavedItemsStepDefs extends AbstractStepDefs {
    @Autowired
    private SavedItemsPage savedItemsPage;


    @Then("^Check that Saved Items page is opened.$")
    public void isSavedItemsPageOpened(){
        assertTrue(savedItemsPage.isOpened());
    }

}
package com.geempower.cucumber.definition_steps;


import com.geempower.storefront.pages.SavedItemsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class SavedItemsStepDefs {
    @Autowired
    private SavedItemsPage savedItemsPage;

    @Then("^(.*) title is displayed on Saved Items page.$")
    public void checkAllItemsTitle(String allItemsTitle) {
        assertEquals(allItemsTitle, savedItemsPage.getAllItemsTitle());
    }

//    @Then("^(.*) title for appropriate section is displayed.$")
//    public void activeCartTitleForAppropriateSectionIsDisplayed(String title) {
//        assertEquals(title, savedItemsPage.getActiveCartTableTitle());
//    }

    @Then("^Active Cart table is displayed with correct columns.$")
    public void activeCartTableIsDisplayedWithCorrectColumns() {
    }

//    @Then("^(.*) title for appropriate table is displayed.$")
//    public void savedListsTitleForAppropriateTableIsDisplayed(String title) {
//        assertEquals(title, savedItemsPage.getSavedListsTableTitle());
//    }

    @Then("^Saved Lists table is displayed with correct columns.$")
    public void savedListsTableIsDisplayedWithCorrectColumns() {

    }
}

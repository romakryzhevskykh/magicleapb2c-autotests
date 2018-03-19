package com.geempower.cucumber.definition_steps;


import com.geempower.storefront.pages.SavedItemsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class SavedItemsStepDefs {
    @Autowired
    SavedItemsPage savedItemsPage;

    @Then("^(.*) title is displayed on Saved Items page.$")
    public void checkAllItemsTitle(String allItemsTitle) {
        assertEquals(savedItemsPage.getAllItemsTitle(), allItemsTitle);
    }
}

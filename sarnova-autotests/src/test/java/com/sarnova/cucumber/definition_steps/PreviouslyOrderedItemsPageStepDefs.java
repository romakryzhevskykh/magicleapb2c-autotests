package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.PreviouslyOrderedItemsPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class PreviouslyOrderedItemsPageStepDefs extends AbstractStepDefs {

    @Autowired private PreviouslyOrderedItemsPage previouslyOrderedItemsPage;

    @And("^Check that Previously Ordered Items page is opened.$")
    public void checkThatReportsPageIsOpened() {
        assertTrue(previouslyOrderedItemsPage.isOpened());
    }
}

package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.BackorderedItemsPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class BackorderedItemsPageStepDefs extends AbstractStepDefs {

    @Autowired private BackorderedItemsPage backorderedItemsPage;

    @And("^Check that Backordered Items page is opened.$")
    public void checkThatBackorderedItemsPageIsOpened() {
        assertTrue(backorderedItemsPage.isOpened());
    }
}

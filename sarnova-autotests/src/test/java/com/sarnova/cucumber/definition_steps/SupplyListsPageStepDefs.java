package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.SupplyListsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class SupplyListsPageStepDefs extends AbstractStepDefs {
    @Autowired SupplyListsPage supplyListsPage;

    @When("^Open Supply lists page.$")
    public void openSupplyListsPage() {
        supplyListsPage.open();
    }

    @And("^Click on Show inactivate entries checkbox on Supply lists page.$")
    public void clickOnShowInactivateEntriesCheckboxOnSupplyListsPage() {
        supplyListsPage.showInactiveSupplyLists();
    }

    @And("^Check that selected Supply list is deactivated on Supply lists page.$")
    public void checkThatSelectedSupplyListIsDeactivatedOnSupplyListsPage() {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        assertTrue(supplyListsPage.getInactiveSupplyLists().contains(supplyListName));
    }

    @And("^Check that selected Supply list is activated on Supply lists page.$")
    public void checkThatSelectedSupplyListIsActivatedOnSupplyListsPage() {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        assertTrue(supplyListsPage.getActiveSupplyLists().contains(supplyListName));
    }
}

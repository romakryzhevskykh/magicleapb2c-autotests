package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.storefront.pages.SupplyListsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class SupplyListsPageStepDefs extends AbstractStepDefs {
    @Autowired SupplyListsPage supplyListsPage;
    @Autowired SupplyListsManager supplyListsManager;

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

    @When("^Mark Supply list as favourite on Supply lists page.$")
    public void markSupplyListAsFavouriteOnSupplyListsPage() {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList testSupplyList = supplyListsManager.getSupplyListByName(supplyListName);
        supplyListsPage.markAsFavorite(testSupplyList);
    }

    @When("^Unmark Supply list as favourite on Supply lists page.$")
    public void unmarkSupplyListAsFavouriteOnSupplyListsPage() {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList testSupplyList = supplyListsManager.getSupplyListByName(supplyListName);
        supplyListsPage.unmarkAsFavorite(testSupplyList);
    }

    @When("^Click on deactivate button on Supply lists page.$")
    public void clickOnDeactivateButtonOnSupplyListsPage() {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList testSupplyList = supplyListsManager.getSupplyListByName(supplyListName);
        supplyListsPage.deactivateSupplyList(testSupplyList);
    }

    @When("^Click on activate button on Supply lists page.$")
    public void clickOnActivateButtonOnSupplyListsPage() {
        String supplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        SupplyList testSupplyList = supplyListsManager.getSupplyListByName(supplyListName);
        supplyListsPage.activateSupplyList(testSupplyList);
    }
}

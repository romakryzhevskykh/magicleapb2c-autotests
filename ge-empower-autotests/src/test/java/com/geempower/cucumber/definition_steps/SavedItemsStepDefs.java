package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.Utils;
import com.geempower.storefront.pages.SavedItemsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.*;

public class SavedItemsStepDefs extends AbstractStepDefs {
    @Autowired
    private SavedItemsPage savedItemsPage;
    @Autowired
    private Utils utils;

    @Then("^Check that Saved Items page is opened.$")
    public void isSavedItemsPageOpened() {
        assertTrue(savedItemsPage.isOpened());
    }

    @Then("^(.*) title is displayed on Saved Items page.$")
    public void checkAllItemsTitle(String allItemsTitle) {
        assertEquals(allItemsTitle, savedItemsPage.getAllItemsTitle());
    }

    @Then("^(.*) title for appropriate section is displayed.$")
    public void activeCartTitleForAppropriateSectionIsDisplayed(String title) {
        assertEquals(title, savedItemsPage.getActiveCartTableTitle());
    }

    @Then("^(.*) title for appropriate table is displayed.$")
    public void savedListsTitleForAppropriateTableIsDisplayed(String title) {
        assertEquals(title, savedItemsPage.getSavedListsTableTitle());
    }

    @When("^User clicks on the Add New List button on the All Items page.$")
    public void userClicksOnTheAddNewListButtonOnTheAllItemsPage() {
        savedItemsPage.clickOnAddNewListButtonOnAllItemsPage();
    }

    @And("^Set new list name in the New List pop-up.$")
    public void setNewListNameInTheNewListPopUp() {
        threadVarsHashMap.put(TestKeyword.NEW_SAVED_LIST_NAME, savedItemsPage.setNewListNameToTheNewListPopUp());
    }

    @And("^Click on Add new list button in the New List pop-up.$")
    public void clickOnAddNewListButtonInTheNewListPopUp() {
        savedItemsPage.clickOnAddNewListButtonOnNewListPopUp();
    }

    @And("^Table was sorted by Created On value (.*).$")
    public void tableWasSortedByCreatedOnValue(String sortRule) {
        savedItemsPage.sortSavedListTableByCreatedOn(sortRule);
    }

    @Then("^List with appropriate name appeared in Saved Lists table.$")
    public void listWithAppropriateNameAppearedInSavedListsTable() {
        String listName = threadVarsHashMap.getString(TestKeyword.NEW_SAVED_LIST_NAME);
        assertEquals(listName, savedItemsPage.getFirstListNameFromTheSavedListsTable());
    }

    @Then("^List data values are correct in Saved Lists table.$")
    public void listDataValuesAreCorrectInSavedListsTable() {
        String listName = threadVarsHashMap.getString(TestKeyword.NEW_SAVED_LIST_NAME);
        assertTrue(listName.contains(savedItemsPage.getCreatedOnValueOfSavedList()));
        assertTrue(listName.contains(savedItemsPage.getLastEditedOnValueOfSavedList()));
    }

    @When("^User opens the saved list.$")
    public void userOpensTheSavedList() {
        savedItemsPage.openTheCreatedSavedList();
    }

    @And("^User adds new (.*) item via New item pop-up.$")
    public void userAddsNewProductNoItemViaNewItemPopUp(String productNo) {
        savedItemsPage.addNewItemToTheSavedList(productNo);
    }

    @Then("^Chosen product (.*) is displayed on the saved list page.$")
    public void chosenProductProductNoIsDisplayedOnTheSavedListPage(String catalogueNo) {
        assertEquals(catalogueNo, savedItemsPage.isAddedProductDisplayedOnSavedListPage().toLowerCase());
        threadVarsHashMap.put(TestKeyword.EXTND_PRICE_OF_PRODUCT_IN_SAVED_LIST, savedItemsPage.getExtndPriceOfChosenProduct());
    }

    @Then("^Extnd. Price has been changed.$")
    public void extndPriceHasBeenChanged() {
        assertFalse((Double) threadVarsHashMap.get(TestKeyword.EXTND_PRICE_OF_PRODUCT_IN_SAVED_LIST) == savedItemsPage.getExtndPriceOfChosenProduct());
    }

    @When("^User goes back to the Saved Items page.$")
    public void userGoesBackToTheSavedItemsPage() {
        savedItemsPage.goBackToAllSavedItems();
    }

    @Then("^No. of items is equal to (\\d+).$")
    public void noOfItemsIsEqualTo(int itemsCount) {
        assertTrue(Integer.parseInt(savedItemsPage.getNoOfItemsValueOfSavedList()) == itemsCount);
    }

    @When("^User deletes the saved list.$")
    public void userDeletesTheSavedList() {
        savedItemsPage.deleteSavedList();
    }

    @Then("^List with appropriate name disappeared in Saved Lists table.$")
    public void listWithAppropriateNameDisappearedInSavedListsTable() {
        String addedListName = threadVarsHashMap.getString(TestKeyword.NEW_SAVED_LIST_NAME);
        assertNotEquals(addedListName, savedItemsPage.getFirstListNameFromTheSavedListsTable());
    }

    @Then("^Active Cart table contains (.*) columns.$")
    public void activeCartTableContainsNecessaryColumns(List<String> expectedColumnsNames) {
        List<String> actualColumnsNames = savedItemsPage.collectSavedCartTableColumnsName();
        assertTrue(actualColumnsNames.containsAll(expectedColumnsNames), "Expected: " + expectedColumnsNames + " but actual: " + actualColumnsNames);
    }

    @Then("^Active Cart table contains appropriate cart with correct data.$")
    public void activeCartTableContainsCorrectData() {
        String savedCartName = threadVarsHashMap.getString(TestKeyword.RANDOM_SAVED_CART_NAME);
        assertTrue(savedItemsPage.getListOfSavedCartNames().contains(savedCartName));
        assertEquals(utils.getCurrentDate(), savedItemsPage.getLatestCreatedOnValue(savedCartName));
        assertTrue(savedItemsPage.getLatestCreatedByValue(savedCartName).contains("autotest"));
        assertEquals(utils.getCurrentDate(), savedItemsPage.getLatestLastEditedOnValue(savedCartName));
        assertEquals("1", savedItemsPage.getLatestNoOfItemsValue(savedCartName));
    }

    @When("^User opens appropriate saved cart.$")
    public void userOpensAppropriateSavedCart() {
        savedItemsPage.openAppropriateSavedCart(threadVarsHashMap.getString(TestKeyword.RANDOM_SAVED_CART_NAME));
    }

    @When("^User deletes appropriate saved cart.$")
    public void userDeletesAppropriateSavedCart() {
        savedItemsPage.deleteSavedCart(threadVarsHashMap.getString(TestKeyword.RANDOM_SAVED_CART_NAME));
    }

    @Then("^Cart with appropriate name disappeared in Saved Cart table.$")
    public void savedCartIsNotDisplayedOnTheList() {
        String addedSavedCart = threadVarsHashMap.getString(TestKeyword.RANDOM_SAVED_CART_NAME);
        assertTrue(!savedItemsPage.getListOfSavedCartNames().contains(addedSavedCart));
    }
}
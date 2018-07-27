package com.geempower.storefront.pages;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.SavedItemsPageElements.*;

@Component
public class SavedItemsPage extends StorefrontBasePage {
    @Autowired private Utils utils;

    private final String pageUri = "savedLists";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get All Items title")
    public String getAllItemsTitle() {
        return $(ALL_ITEMS_TITLE_XPATH).getText();
    }

    @Step("Get Active Cart Table Title")
    public String getActiveCartTableTitle() {
        return $(ACTIVE_CART_TABLE_TITLE_XPATH).getText();
    }

    @Step("Get Saved Lists Table Title")
    public String getSavedListsTableTitle() {
        return $(SAVED_ITEMS_TABLE_TITLE_XPATH).getText();
    }

    @Step("Click On Add New List Button On All Items Page")
    public void clickOnAddNewListButtonOnAllItemsPage() {
        click(ADD_NEW_LIST_BUTTON_XPATH);
    }

    @Step("Set New List Name To The New List Pop Up")
    public String setNewListNameToTheNewListPopUp() {
        waitHTMLTemplateLoad();
        String listName = utils.getLocalDateTimeStamp();
        $(NEW_LIST_NAME_FIELD_XPATH).clear();
        $(NEW_LIST_NAME_FIELD_XPATH).sendKeys(listName);
        return listName;
    }

    @Step("Click On Add New List Button On New List Pop Up")
    public void clickOnAddNewListButtonOnNewListPopUp() {
        waitUntilPageIsFullyLoaded();
        click(ADD_NEW_LIST_BUTTON_IN_NEW_LIST_POP_UP_XPATH);
    }

    @Step("Sort Saved List Table By Created On")
    public void sortSavedListTableByCreatedOn(String sortRule) {
        waitUntilPageIsFullyLoaded();
        switch (sortRule) {
            case "ASC":
                click(ASCENDING_SORTING_LISTS_TABLE_BY_CREATION_DATE_XPATH);
                break;
            case "DESC":
                click(ASCENDING_SORTING_LISTS_TABLE_BY_CREATION_DATE_XPATH);
                waitUntilPageIsFullyLoaded();
                click(DESCENDING_SORTING_LISTS_TABLE_BY_CREATION_DATE_XPATH);
                break;
        }
    }

    @Step("Get First List Name From The Saved Lists Table")
    public String getFirstListNameFromTheSavedListsTable() {
        return $(FIRST_LIST_NAME_FROM_THE_SAVED_LISTS_TABLE_XPATH).getText();
    }

    @Step("Get Created On Value Of Saved List")
    public String getCreatedOnValueOfSavedList() {
        return $(FIRST_LIST_CREATED_ON_FROM_THE_SAVED_LISTS_TABLE_XPATH).getText();
    }

    @Step("Get Last Edited On Value Of Saved List")
    public String getLastEditedOnValueOfSavedList() {
        return $(FIRST_LIST_LAST_EDITED_ON_FROM_THE_SAVED_LISTS_TABLE_XPATH).getText();
    }

    @Step("Get No Of Items Value Of Saved List")
    public String getNoOfItemsValueOfSavedList() {
        return $(FIRST_LIST_NO_OF_ITEMS_FROM_THE_SAVED_LISTS_TABLE_XPATH).getText();
    }

    @Step("Open The Created Saved List")
    public void openTheCreatedSavedList() {
        click(FIRST_LIST_NAME_FROM_THE_SAVED_LISTS_TABLE_XPATH);
    }

    @Step("Add New Item To The Saved List")
    public void addNewItemToTheSavedList(String productNo) {
        waitUntilPageIsFullyLoaded();
        click(ADD_ITEM_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
        $(ADD_PRODUCT_LIST_FIRST_PRODUCT_NUMBER_INPUT_XPATH).clear();
        $(ADD_PRODUCT_LIST_FIRST_PRODUCT_NUMBER_INPUT_XPATH).sendKeys(productNo);
        waitUntilPageIsFullyLoaded();
        click(By.id(ADD_PRODUCT_BUTTON_IN_NEW_ITEM_POP_UP_ID));
    }

    @Step("Is Added Product Displayed On Saved List Page")
    public String isAddedProductDisplayedOnSavedListPage() {
        return $(ADDED_NEW_ITEM_CATALOG_NO_TO_THE_SAVED_LIST_XPATH).getText();
    }

    @Step("Get Extnd Price Of Chosen Product")
    public double getExtndPriceOfChosenProduct() {
        return Double.parseDouble($(EXTENDED_PRICE_OF_ADDED_PRODUCT_XPATH).getText());
    }

    @Step("Go Back To All Saved Items")
    public void goBackToAllSavedItems() {
        waitUntilPageIsFullyLoaded();
        click(GO_BACK_TO_ALL_SAVED_ITEMS_ICON_XPATH);
    }

    @Step("Delete Saved List")
    public void deleteSavedList() {
        waitUntilPageIsFullyLoaded();
        click(THREE_DOT_ICON_XPATH);
        waitUntilPageIsFullyLoaded();
        click(THREE_DOT_ICON_DELETE_OPTION_XPATH);
        waitUntilPageIsFullyLoaded();
        click(DELETE_BUTTON_IN_CONFIRMATION_DELETE_POP_UP_XPATH);
        waitUntilPageIsFullyLoaded();
    }
}
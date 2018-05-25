package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.AccountDashboardPageElements.*;

@Component
public class AccountDashboardPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/account-dashboard";

    @Override
    public void open() {
        super.open();
        waitUntilElementIsVisible(MENU_ITEMS_XPATH);
    }

    @Step("Is Order History item visible?")
    public boolean isOrderHistoryItemVisible() {
        return isDisplayed(ORDER_HISTORY_ITEM_XPATH);
    }

    @Step("Is Previously Ordered Items item visible?")
    public boolean isPreviouslyOrderedItemsItemVisible() {
        return isDisplayed(PREVIOUSLY_ORDERED_ITEMS_ITEM_XPATH);
    }

    @Step("Is Purchase Requests item visible?")
    public boolean isPurchaseRequestsItemVisible() {
        return isDisplayed(PURCHASE_REQUESTS_ITEM_XPATH);
    }

    @Step("Is Quotes item visible?")
    public boolean isQuotesItemVisible() {
        return isDisplayed(QUOTES_ITEM_XPATH);
    }

    @Step("Is Reports item visible?")
    public boolean isReportsItemVisible() {
        return isDisplayed(REPORTS_ITEM_XPATH);
    }

    @Step("Is Saved Carts item visible?")
    public boolean isSavedCartsItemVisible() {
        return isDisplayed(SAVED_CARTS_ITEM_XPATH);
    }

    @Step("Is Supply Lists item visible?")
    public boolean isSupplyListsItemVisible() {
        return isDisplayed(SUPPLY_LISTS_ITEM_XPATH);
    }

    @Step("Is Business Info item visible?")
    public boolean isBusinessInfoItemVisible() {
        return isDisplayed(BUSINESS_INFO_ITEM_XPATH);
    }

    @Step("Is Custom Category item visible?")
    public boolean isCustomCategoryItemVisible() {
        return isDisplayed(CUSTOM_CATEGORY_ITEM_XPATH);
    }

    @Step("Is Users item visible?")
    public boolean isUsersItemVisible() {
        return isDisplayed(USERS_ITEM_XPATH);
    }

    @Step("Is User Groups item visible?")
    public boolean isUserGroupsItemVisible() {
        return isDisplayed(USER_GROUPS_ITEM_XPATH);
    }

    @Step("Is Account Information item visible?")
    public boolean isAccountInformationItemVisible() {
        return isDisplayed(ACCOUNT_INFORMATION_ITEM_XPATH);
    }

    @Step("Is Help/New To Boundtree? item visible?")
    public boolean isHelpItemVisible() {
        return isDisplayed(HELP_ITEM_XPATH);
    }

    @Step("Is Quotas And Par Levels item visible?")
    public boolean isQuotasAndParLevelsItemVisible() {
        return false;
    }

    @Step("Is Saved Credit Cards item visible?")
    public boolean isSavedCreditCardsItemVisible() {
        return false;
    }

    @Step("Click on Order History item.")
    public void clickOnOrderHistoryItem() {
        click(ORDER_HISTORY_ITEM_XPATH);
    }

    @Step("Click on Previously Ordered Items item.")
    public void clickOnPreviouslyOrderedItemsItem() {
        click(PREVIOUSLY_ORDERED_ITEMS_ITEM_XPATH);
    }

    @Step("Click on Purchase Requests item.")
    public void clickOnPurchaseRequestsItem() {
        click(PURCHASE_REQUESTS_ITEM_XPATH);
    }

    @Step("Click on Quotas And Par Levels item.")
    public void clickOnQuotasAndParLevelsItem() {
        //TODO
//        click(QUOTES_ITEM_XPATH);
    }

    @Step("Click on Quotas item.")
    public void clickOnQuotesItem() {
        click(QUOTES_ITEM_XPATH);
    }

    @Step("Click on Reports item.")
    public void clickOnReportsItem() {
        click(REPORTS_ITEM_XPATH);
    }

    @Step("Click on Saved Carts item.")
    public void clickOnSavedCartsItem() {
        click(SAVED_CARTS_ITEM_XPATH);
    }

    @Step("Click on Saved Credit Cards item.")
    public void clickOnSavedCreditCardsItem() {
        //TODO
//        click(SAVED_CARTS_ITEM_XPATH);
    }

    @Step("Click on Supply Lists item.")
    public void clickOnSupplyListsItem() {
        click(SUPPLY_LISTS_ITEM_XPATH);
    }

    @Step("Click on Business Info item.")
    public void clickOnBusinessInfoItem() {
        click(BUSINESS_INFO_ITEM_XPATH);
    }

    @Step("Click on Custom Category item.")
    public void clickOnCustomCategoryItem() {
        click(CUSTOM_CATEGORY_ITEM_XPATH);
    }

    @Step("Click on Users item.")
    public void clickOnUsersItem() {
        click(USERS_ITEM_XPATH);
    }

    @Step("Click on User Groups item.")
    public void clickOnUserGroupsItem() {
        click(USER_GROUPS_ITEM_XPATH);
    }

    @Step("Click on Account Information item.")
    public void clickOnAccountInformationItem() {
        click(ACCOUNT_INFORMATION_ITEM_XPATH);
    }

    @Step("Click on Help/New To Boundtree? item.")
    public void clickOnHelpItem() {
        click(HELP_ITEM_XPATH);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

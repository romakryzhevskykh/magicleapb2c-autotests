package com.sarnova.storefront.pages;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.AccountDashboardPageElements.*;

@Component
public class AccountDashboardPage extends StorefrontBasePage {

    private String pageUrlMethod = "my-account/account-dashboard";

    @Override
    public void open() {
        super.open();
        waitUntilElementIsVisible(LEFT_BAR_MENU_XPATH);
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

    @Step("Is Purchase Summary item visible?")
    public boolean isPurchaseSummaryItemVisible() {
        return isDisplayed(PURCHASE_SUMMARY_ITEM_XPATH);
    }

    @Step("Is Saved Carts item visible?")
    public boolean isSavedCartsItemVisible() {
        return isDisplayed(SAVED_CARTS_ITEM_XPATH);
    }

    @Step("Is Supply Lists item visible?")
    public boolean isSupplyListsItemVisible() {
        return isDisplayed(SUPPLY_LISTS_ITEM_XPATH);
    }

    @Step("Is Purchases Per Month item visible?")
    public boolean isPurchasesPerMonthItemVisible() {
        return isDisplayed(PURCHASES_PER_MONTH_ITEM_XPATH);
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

    @Step("Is Account Settings item visible?")
    public boolean isAccountSettingsItemVisible() {
        return isDisplayed(ACCOUNT_SETTINGS_ITEM_XPATH);
    }

    @Step("Is Help/New To Boundtree? item visible?")
    public boolean isHelpItemVisible() {
        return isDisplayed(HELP_ITEM_XPATH);
    }

    @Step("Is Quotas And Par Levels item visible?")
    public boolean isQuotasAndParLevelsItemVisible() {
        return isDisplayed(QUOTAS_AND_PAR_LEVELS_ITEM_XPATH);
    }

    @Step("Is Replenishment Orders item visible?")
    public boolean isReplenishmentOrdersItemVisible() {
        return isDisplayed(REPLENISHMENT_ORDERS_ITEM_XPATH);
    }

    @Step("Is Backordered Items item visible?")
    public boolean isBackorderedItemsItemVisible() {
        return isDisplayed(BACKORDERED_ITEMS_ITEM_XPATH);
    }

    @Step("Is Discontinued Items item visible?")
    public boolean isDiscontinuedItemsItemVisible() {
        return isDisplayed(DISCONTINUED_PRODUCTS_ITEM_XPATH);
    }

    @Step("Is DSCSA Transactions item visible?")
    public boolean isDSCSATransactionsItemVisible() {
        return isDisplayed(DSCSA_TRANSACTIONS_ITEM_XPATH);
    }

    @Step("Is Pharmaceutical Backorder item visible?")
    public boolean isPharmaceuticalBackorderItemVisible() {
        return isDisplayed(PHARMACEUTICAL_BACKORDER_REPORT_ITEM_XPATH);
    }

    @Step("Is Saved Credit Cards item visible?")
    public boolean isSavedCreditCardsItemVisible() {
        return isDisplayed(SAVED_CREDIT_CARDS_ITEM_XPATH);
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
        click(QUOTAS_AND_PAR_LEVELS_ITEM_XPATH);
    }

    @Step("Click on Quotas item.")
    public void clickOnQuotesItem() {
        click(QUOTES_ITEM_XPATH);
    }

    @Step("Click on Reports item.")
    public void clickOnPurchaseSummaryItem() {
        click(PURCHASE_SUMMARY_ITEM_XPATH);
    }

    @Step("Click on Saved Carts item.")
    public void clickOnSavedCartsItem() {
        click(SAVED_CARTS_ITEM_XPATH);
    }

    @Step("Click on Saved Credit Cards item.")
    public void clickOnSavedCreditCardsItem() {
        click(SAVED_CREDIT_CARDS_ITEM_XPATH);
    }

    @Step("Click on Supply Lists item.")
    public void clickOnSupplyListsItem() {
        click(SUPPLY_LISTS_ITEM_XPATH);
    }

    @Step("Click on Purchases Per Month item.")
    public void clickOnPurchasesPerMonthItem() {
        click(PURCHASES_PER_MONTH_ITEM_XPATH);
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

    @Step("Click on Account Settings item.")
    public void clickOnAccountSettingsItem() {
        click(ACCOUNT_SETTINGS_ITEM_XPATH);
    }

    @Step("Click on Help/New To Boundtree? item.")
    public void clickOnHelpItem() {
        click(HELP_ITEM_XPATH);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Click on Replenishment Orders item.")
    public void clickOnReplenishmentOrdersItem() {
        click(REPLENISHMENT_ORDERS_ITEM_XPATH);
    }

    @Step("Click on Backordered Items item.")
    public void clickOnBackorderedItemsItem() {
        click(BACKORDERED_ITEMS_ITEM_XPATH);
    }

    @Step("Click on Discontinued Products item.")
    public void clickOnDiscontinuedProductsItem() {
        click(DISCONTINUED_PRODUCTS_ITEM_XPATH);
    }

    @Step("Click on DSCSA Transactions item.")
    public void clickOnDSCSATransactionsItem() {
        click(DSCSA_TRANSACTIONS_ITEM_XPATH);
    }

    @Step("Click on Pharmaceutical Backorder Report item.")
    public void clickOnPharmaceuticalBackorderReportItem() {
        click(PHARMACEUTICAL_BACKORDER_REPORT_ITEM_XPATH);
    }

    @Step("Expand Account Dashboard section in the left bar menu.")
    public void expandAccountDashboardSection() {
        if(!isDisplayed(ACCOUNT_DASHBOARD_ITEMS_XPATH)) {
            click(EXPAND_ACCOUNT_DASHBOARD_ITEMS_XPATH);
            waitUntil(driver1 -> $(EXPAND_ACCOUNT_DASHBOARD_ITEMS_XPATH).getAttribute("class").contains("rotate"));
            waitUntil(driver1 -> $$(ACCOUNT_DASHBOARD_ITEMS_XPATH).stream().allMatch(WebElement::isDisplayed));
        }
    }

    @Step("Expand Reports section in the left bar menu.")
    public void expandReportsSection() {
        if(!isDisplayed(REPORTS_ITEMS_XPATH)) {
            click(EXPAND_REPORTS_ITEMS_XPATH);
            waitUntil(driver1 -> $(EXPAND_REPORTS_ITEMS_XPATH).getAttribute("class").contains("rotate"));
            waitUntil(driver1 -> $$(REPORTS_ITEMS_XPATH).stream().allMatch(WebElement::isDisplayed));
        }
    }

    @Step("Expand Administration section in the left bar menu.")
    public void expandAdministrationSection() {
        if(!isDisplayed(ADMINISTRATION_ITEMS_XPATH)) {
            click(EXPAND_ADMINISTRATION_ITEMS_XPATH);
            waitUntil(driver1 -> $(EXPAND_ADMINISTRATION_ITEMS_XPATH).getAttribute("class").contains("rotate"));
            waitUntil(driver1 -> $$(ADMINISTRATION_ITEMS_XPATH).stream().allMatch(WebElement::isDisplayed));
        }
    }

    @Step("Expand Preferences section in the left bar menu.")
    public void expandPreferencesSection() {
        if(!isDisplayed(PREFERENCES_ITEMS_XPATH)) {
            click(EXPAND_PREFERENCES_ITEMS_XPATH);
            waitUntil(driver1 -> $(EXPAND_PREFERENCES_ITEMS_XPATH).getAttribute("class").contains("rotate"));
            waitUntil(driver1 -> $$(PREFERENCES_ITEMS_XPATH).stream().allMatch(WebElement::isDisplayed));
        }
    }
}

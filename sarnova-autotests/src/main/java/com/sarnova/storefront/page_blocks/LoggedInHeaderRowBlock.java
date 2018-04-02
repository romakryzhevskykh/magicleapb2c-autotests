package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import com.sarnova.helpers.user_engine.UserSession;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_block_elements.LoggedInHeaderRowBlockElements.*;

@Component
public class LoggedInHeaderRowBlock extends UIComponent {

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWN_XPATH);
    }

    @Step("Click on favorite Supply lists drop-down.")
    public void clickOnFavoriteSupplyListsDropDown() {
        click(SUPPLY_LISTS_DROP_DOWN_XPATH);
    }

    @Step("Get favorite Supply list names from Supply list drop-down.")
    public List<String> getFavoriteSupplyListsFromSupplyListsDropDown() {
        return $$(SUPPLY_LIST_NAMES_FROM_SUPPLY_LISTS_DROP_DOWN_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Is My account menu opened?")
    public boolean isMyAccountMenuOpened() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWN_CONTENT_XPATH);
    }

    @Step("Click on My account drop-down button.")
    public void clickOnMyAccountDropDownButton() {
        click(MY_ACCOUNT_DROP_DOWN_XPATH);
    }

    @Step("Open My account menu.")
    public void openMyAccountMenu() {
        if (!isMyAccountMenuOpened()) {
            clickOnMyAccountDropDownButton();
        }
    }

    @Step("Get My Account menu item names.")
    public List<String> getMyAccountMenuNames() {
        return $$(MY_ACCOUNT_MENU_ITEM_NAMES_XPATH).stream().map(webElement -> webElement.getText().trim()).collect(Collectors.toList());
    }

    @Step("Get My Account menu {0} item index.")
    public int getIndexOfMyAccountMenuItemByName(String menuItemName) {
        List<WebElement> myAccountItems = $$(MY_ACCOUNT_MENU_ITEMS_XPATH);
        WebElement searchedItem = myAccountItems.stream()
                .filter(webElement -> webElement.getText().contains(menuItemName))
                .findFirst()
                .orElseGet(() -> {
                    throw new NullPointerException("Row is absent: " + menuItemName);
                });
        return myAccountItems.indexOf(searchedItem) + 1;
    }

    @Step("Click on Account Dashboard item in My account menu.")
    public void clickOnAccountDashboardItemInMyAccountMenu() {
        click(ACCOUNT_DASHBOARD_ITEM_XPATH);
    }

    @Step("Click on Order History item in My account menu.")
    public void clickOnOrderHistoryItemInMyAccountMenu() {
        click(ORDER_HISTORY_ITEM_XPATH);
    }

    @Step("Click on Supply Lists item in My account menu.")
    public void clickOnSupplyListsItemInMyAccountMenu() {
        click(SUPPLY_LISTS_ITEM_XPATH);
    }

    @Step("Click on Saved Carts item in My account menu.")
    public void clickOnSavedCartsItemInMyAccountMenu() {
        click(SAVED_CARTS_ITEM_XPATH);
    }

    @Step("Click on Saved Credit Cards item in My account menu.")
    public void clickOnSavedCreditCardsItemInMyAccountMenu() {
        click(SAVED_CREDIT_CARDS_ITEM_XPATH);
    }

    @Step("Click on Quotes item in My account menu.")
    public void clickOnQuotesItemInMyAccountMenu() {
        click(QUOTES_ITEM_XPATH);
    }

    @Step("Click on Reports item in My account menu.")
    public void clickOnReportsItemInMyAccountMenu() {
        click(REPORTS_ITEM_XPATH);
    }

    @Step("Click on Account Information item in My account menu.")
    public void clickOnAccountInformationItemInMyAccountMenu() {
        click(ACCOUNT_INFORMATION_ITEM_XPATH);
    }

    @Step("Click on Custom Category item in My account menu.")
    public void clickOnCustomCategoryItemInMyAccountMenu() {
        click(CUSTOM_CATEGORY_ITEM_XPATH);
    }

    @Step("Click on Help/New To Boundtree? item in My account menu.")
    public void clickOnHelpNewToBoundtreeItemInMyAccountMenu() {
        click(HELP_NEW_TO_BOUNDTREE_ITEM_XPATH);
    }

    @Step("Click on Sign Out item in My account menu.")
    public void clickOnSignOutItemInMyAccountMenu(UserSession userSession) {
        click(SIGN_OUT_ITEM_XPATH);
        userSession.setLoggedIn(false);
        userSession.setCookies(getDriver().manage().getCookies());
    }

    @Step("Click on Purchase Requests item in My account menu.")
    public void clickOnPurchaseRequestsItemInMyAccountMenu() {
        click(PURCHASE_REQUESTS_ITEM_XPATH);
    }

    @Step("Click on Quotas And Par Levels item in My account menu.")
    public void clickOnQuotasAndParLevelsItemInMyAccountMenu() {
        click(QUOTAS_AND_PAR_LEVELS_ITEM_XPATH);
    }

    @Step("Click on Business Info item in My account menu.")
    public void clickOnBusinessInfoItemInMyAccountMenu() {
        click(BUSINESS_INFO_ITEM_XPATH);
    }

    @Step("Click on Users item in My account menu.")
    public void clickOnUsersItemInMyAccountMenu() {
        click(USERS_ITEM_XPATH);
    }

    @Step("Click on User Groups item in My account menu.")
    public void clickOnUserGroupsItemInMyAccountMenu() {
        click(USER_GROUPS_ITEM_XPATH);
    }
}

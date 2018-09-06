package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import com.sarnova.helpers.user_engine.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

@Component
public class HeaderRowPageBlock extends UIComponent {
    @Autowired LoggedInHeaderRowBlock loggedInHeaderRowBlock;
    @Autowired LoggedOutHeaderRowBlock loggedOutHeaderRowBlock;

    public boolean isUserLoggedIn() {
        return loggedInHeaderRowBlock.isUserLoggedIn();
    }

    public boolean isUserLoggedOut() {
        return loggedOutHeaderRowBlock.isUserLoggedOut();
    }

    @Step("Logout from Storefront.")
    public void logoutFromStorefront(UserSession userSession) {
        loggedInHeaderRowBlock.clickOnMyAccountDropDownButton();
        loggedInHeaderRowBlock.clickOnSignOutItemInMyAccountMenu(userSession);
    }

    public List<String> getSupplyListNamesFromFavoriteSupplyListsDropDown() {
        return loggedInHeaderRowBlock.getFavoriteSupplyListsFromSupplyListsDropDown();
    }

    public void clickOnFavoriteSupplyListsDropDown() {
        loggedInHeaderRowBlock.clickOnFavoriteSupplyListsDropDown();
    }

    public boolean isFavoriteSupplyListsDropDownPresent() {
        return loggedInHeaderRowBlock.isFavoriteSupplyListsDropDownPresent();
    }

    public void openMyAccountMenu() {
        loggedInHeaderRowBlock.openMyAccountMenu();
    }

    public List<String> getMyAccountMenuNames() {
        return loggedInHeaderRowBlock.getMyAccountMenuNames();
    }

    public int getIndexOfMyAccountMenuItemByName(String menuItemName) {
        return loggedInHeaderRowBlock.getIndexOfMyAccountMenuItemByName(menuItemName);
    }

    public void clickOnAccountDashboardItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnAccountDashboardItemInMyAccountMenu();
    }

    public void clickOnOrderHistoryItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnOrderHistoryItemInMyAccountMenu();
    }

    public void clickOnSupplyListsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnSupplyListsItemInMyAccountMenu();
    }

    public void clickOnSavedCartsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnSavedCartsItemInMyAccountMenu();
    }

    public void clickOnSavedCreditCardsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnSavedCreditCardsItemInMyAccountMenu();
    }

    public void clickOnQuotesItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnQuotesItemInMyAccountMenu();
    }

    public void clickOnReportsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnReportsItemInMyAccountMenu();
    }

    public void clickOnAccountInformationItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnAccountInformationItemInMyAccountMenu();
    }

    public void clickOnCustomCategoryItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnCustomCategoryItemInMyAccountMenu();
    }

    public void clickOnHelpNewToBoundtreeItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnHelpNewToBoundtreeItemInMyAccountMenu();
    }

    public void clickOnSignOutItemInMyAccountMenu(UserSession userSession) {
        loggedInHeaderRowBlock.clickOnSignOutItemInMyAccountMenu(userSession);
    }

    public void clickOnPurchaseRequestsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnPurchaseRequestsItemInMyAccountMenu();
    }

    public void clickOnQuotasAndParLevelsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnQuotasAndParLevelsItemInMyAccountMenu();
    }

    public void clickOnBusinessInfoItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnBusinessInfoItemInMyAccountMenu();
    }

    public void clickOnUsersItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnUsersItemInMyAccountMenu();
    }

    public void clickOnUserGroupsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnUserGroupsItemInMyAccountMenu();
    }

    public void clickOnPreviouslyOrderedItemsItemInMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnPreviouslyOrderedItemsItemInMyAccountMenu();
    }

    public boolean isViewAllSupplyListsButtonPresentInDropDown() {
        return loggedInHeaderRowBlock.isViewAllSupplyListsButtonPresentInDropDown();
    }
}

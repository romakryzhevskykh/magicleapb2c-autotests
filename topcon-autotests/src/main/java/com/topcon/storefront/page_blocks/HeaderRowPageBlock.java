package com.topcon.storefront.page_blocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class HeaderRowPageBlock {
    @Autowired LoggedInHeaderRowBlock loggedInHeaderRowBlock;
    @Autowired LoggedOutHeaderRowBlock loggedOutHeaderRowBlock;

    public boolean isUserLoggedIn() {
        return loggedInHeaderRowBlock.isUserLoggedIn();
    }

    public boolean isUserLoggedOut() {
        return loggedOutHeaderRowBlock.isUserLoggedOut();
    }

    @Step("Logout from Storefront.")
    public void logoutFromStorefront() {
        loggedInHeaderRowBlock.clickOnSignOutButton();
    }

    public void clickOnMyAccountMenu() {
        loggedInHeaderRowBlock.clickOnMyAccountMenu();
    }

    public void clickOnAddressBookItemInMyAccount() {
        loggedInHeaderRowBlock.clickOnAddressBookItemInMyAccount();
    }
}

package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import com.sarnova.helpers.user_engine.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

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
        loggedInHeaderRowBlock.clickOnSignOutButton();
        userSession.setLoggedIn(false);
        userSession.setCookies(getDriver().manage().getCookies());
    }
}

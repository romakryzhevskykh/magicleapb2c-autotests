package com.template.storefront.pages;

import com.template.helpers.user_engine.UserSession;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.LoginPageElements.LOG_IN_BUTTON_XPATH;
import static com.template.storefront.page_elements.LoginPageElements.PASSWORD_FIELD_XPATH;
import static com.template.storefront.page_elements.LoginPageElements.USERNAME_FIELD_XPATH;

@Component
public class LoginPageStorefront extends StorefrontBasePage {

    private final String pageUrlMethod = "powertools/en/USD/login";

    @Step("Login as {0}")
    public void loginAs(UserSession userSession) {
        fillLoginFieldWith(userSession.getUsername());
        fillPasswordFieldWith(userSession.getPassword());
        clickOnLoginButton(userSession);
    }

    @Step("Fill login field with {0}")
    public void fillLoginFieldWith(String login) {
        $(USERNAME_FIELD_XPATH).enterText(login);
    }

    @Step("Fill password field with {0}")
    public void fillPasswordFieldWith(String password) {
        $(PASSWORD_FIELD_XPATH).enterText(password);
    }

    @Step("Click on Login button.")
    public void clickOnLoginButton(UserSession userSession) {
        $(LOG_IN_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
        userSession.setLoggedIn(true);
        userSession.clearCookies();
        userSession.setCookies(getDriver().manage().getCookies());
    }



    public boolean isOpened() {
        return isCurrentURLEqualsToLoginPageURL() && isUserLoggedOut();
    }


    @Step("Check that current url is Login page url.")
    private boolean isCurrentURLEqualsToLoginPageURL() {
        return getPageUrl().equals(getCurrentUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

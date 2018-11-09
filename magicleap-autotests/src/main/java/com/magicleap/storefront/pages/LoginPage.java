package com.magicleap.storefront.pages;

import com.magicleap.helpers.models.users.UserSession;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.magicleap.storefront.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends StorefrontBasePage {
    private final String pageUrlMethod = "/#/login";

    public boolean isOpened() {
        return isCurrentURLEqualsToLoginPageURL() && isUserLoggedOut();
    }

    @Step("Fill username field.")
    public void fillUsernameFieldWith(String username) {
        $(USERNAME_FIELD_XPATH).sendKeys(username);
    }

    @Step("Fill password field.")
    public void fillPasswordFieldWith(String password) {
        $(PASSWORD_FIELD_XPATH).sendKeys(password);
    }

    @Step("Click on Login button.")
    public void clickOnLoginButton() {
        $(LOG_IN_BUTTON_XPATH).click();
    }

    public void loginToStorefront(UserSession user) {
        fillUsernameFieldWith(user.getUsername());
        fillPasswordFieldWith(user.getPassword());
        clickOnLoginButton();
    }

    @Step("Click on Sign Up button.")
    public void clickOnSignUpButton() {
        $(SIGN_UP_BUTTON_XPATH).click();
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

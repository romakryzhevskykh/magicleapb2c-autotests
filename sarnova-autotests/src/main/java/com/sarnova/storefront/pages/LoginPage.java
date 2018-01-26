package com.sarnova.storefront.pages;

import com.sarnova.helpers.user_engine.UserSession;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends StorefrontBasePage {

    private final String pageUrlMethod = "boundtree/en/USD/login";

    @Step("Fill username field.")
    public void fillUsernameFieldWith(String username) {
        $(By.id(USERNAME_FIELD_ID)).sendKeys(username);
    }

    @Step("Fill password field.")
    public void fillPasswordFieldWith(String password) {
        $(By.id(PASSWORD_FIELD_ID)).sendKeys(password);
    }

    @Step("Click on Login button.")
    public void clickOnLoginButton() {
        click($(LOG_IN_BUTTON_XPATH));
    }

    public void loginToStorefront(UserSession userSession) {
        fillUsernameFieldWith(userSession.getUsername());
        fillPasswordFieldWith(userSession.getPassword());
        clickOnLoginButton();
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

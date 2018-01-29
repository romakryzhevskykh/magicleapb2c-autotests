package com.sarnova.storefront.pages;

import com.sarnova.helpers.user_engine.UserSession;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends StorefrontBasePage {

    private final String pageUrlMethod = "boundtree/en/USD/login";

    public void loginToStorefront(UserSession userSession) {
        fillUsernameFieldWith(userSession.getUsername());
        fillPasswordFieldWith(userSession.getPassword());
        clickOnLoginButton();
    }

    @Step("Check that current url is Login page url.")
    private boolean isCurrentURLEqualsToLoginPageURL() {
        return getPageUrl().equals(getCurrentUrl());
    }

    @Step("Check that Username label is present.")
    public boolean checkUsernameLabelIsPresent() {
        return isDisplayed(USERNAME_LABEL);
    }

    @Step("Get username label text.")
    public String getUsernameLabelText() {
        return $(USERNAME_LABEL).getText().trim();
    }

    @Step("Check that Username field is present.")
    public boolean checkUsernameFieldIsPresent() {
        return isDisplayed(By.id(USERNAME_FIELD_ID));
    }

    @Step("Fill username field.")
    public void fillUsernameFieldWith(String username) {
        $(By.id(USERNAME_FIELD_ID)).sendKeys(username);
    }

    @Step("Check that Password label is present.")
    public boolean checkPasswordLabelIsPresent() {
        return isDisplayed(PASSWORD_LABEL);
    }

    @Step("Get password label text.")
    public String getPasswordLabelText() {
        return $(PASSWORD_LABEL).getText().trim();
    }

    @Step("Check that Password field is present.")
    public boolean checkPasswordFieldIsPresent() {
        return isDisplayed(By.id(PASSWORD_FIELD_ID));
    }

    @Step("Fill password field.")
    public void fillPasswordFieldWith(String password) {
        $(By.id(PASSWORD_FIELD_ID)).sendKeys(password);
    }


    @Step("Check that Log in button is present.")
    public boolean checkLogInButtonIsPresent() {
        return isDisplayed(LOG_IN_BUTTON_XPATH);
    }

    @Step("Get log in button text.")
    public String getLogInButtonText() {
        return $(LOG_IN_BUTTON_XPATH).getText().trim();
    }

    @Step("Click on Login button.")
    public void clickOnLoginButton() {
        click(LOG_IN_BUTTON_XPATH);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

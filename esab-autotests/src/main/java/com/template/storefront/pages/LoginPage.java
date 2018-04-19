package com.template.storefront.pages;

import com.template.helpers.BasePageObject;
import com.template.helpers.user_engine.UserSession;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends StorefrontBasePage {
    //private final String pageUrlMethod = "powertools/en/USD/login";
	private final String pageUrlMethod = "/esab/en/login";

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
    	click(LOG_IN_BUTTON_XPATH);
    }

    public void loginToStorefront(UserSession user) {
        fillUsernameFieldWith(user.getUsername());
        fillPasswordFieldWith(user.getPassword());
        clickOnLoginButton();
    }
    
    public void goToRegisterPage(){
    	clickOnRegisterButton();
    }

    @Step("Check that current url is Login page url.")
    private boolean isCurrentURLEqualsToLoginPageURL() {
        return getPageUrl().equals(getCurrentUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
    
    @Step("Click on Register button.")
    public void clickOnRegisterButton(){
    	click(REGISTER_BUTTON_XPATH);
    }
}

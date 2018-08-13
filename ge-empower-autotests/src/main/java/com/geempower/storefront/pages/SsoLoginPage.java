package com.geempower.storefront.pages;

import com.geempower.helpers.user_engine.User;
import com.geempower.helpers.user_engine.UserSession;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.SsoLoginPageElements.*;

@Component
public class SsoLoginPage extends StorefrontBasePage {

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getSsoLoginUrl();
    }

    public void loginToStorefront(UserSession userSession) {
        fillUsername(userSession.getUsername());
        fillPassword(userSession.getPassword());
        clickOnLoginButton();
        userSession.setCookies(getDriver().manage().getCookies());
    }

    public void loginToStorefront(User user) {
//        Only for HAC login
        fillUsername(user.getUsername());
        fillPassword(user.getPassword());
        clickOnLoginButton();
    }

    @Step("Fill Username field on Login Page with {0}")
    private void fillUsername(String username) {
        $(By.id(USERNAME_FIELD_ID)).sendKeys(username);
    }

    @Step("Fill Password field on Login Page with {0}")
    private void fillPassword(String password) {
        $(By.id(PASSWORD_FIELD_ID)).sendKeys(password);
    }

    @Step("Click on Sign In button")
    private void clickOnLoginButton() {
//        click(By.id(LOGIN_BUTTON_ID));
        $(By.id(LOGIN_BUTTON_ID)).click();
    }
}

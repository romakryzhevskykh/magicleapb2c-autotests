package com.sarnova.pay_fabric.pages;

import com.sarnova.helpers.user_engine.UserSession;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.pay_fabric.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends PayFabricBasePage {
    private final String pageUrlMethod = "Portal/Account";

    @Override
    public String getPageUrl() {
        return payFabric.getBaseUrl() + pageUrlMethod;
    }

    @Step("Login to Pay Fabric.")
    public void loginToPayFabric(UserSession activeUserSession) {
        fillUsername(activeUserSession.getUsername());
        fillPassword(activeUserSession.getPassword());
        clickOnSignIn();
    }

    @Step("Fill username: {0}")
    public void fillUsername(String username) {
        $(By.id(USERNAME_FIELD_ID)).clear();
        $(By.id(USERNAME_FIELD_ID)).sendKeys(username);
    }

    @Step("Fill password: {0}")
    public void fillPassword(String password) {
        $(By.id(PASSWORD_FIELD_ID)).clear();
        $(By.id(PASSWORD_FIELD_ID)).sendKeys(password);
    }

    @Step("Click on Sign in button.")
    public void clickOnSignIn() {
        click(SIGN_IN_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }
}

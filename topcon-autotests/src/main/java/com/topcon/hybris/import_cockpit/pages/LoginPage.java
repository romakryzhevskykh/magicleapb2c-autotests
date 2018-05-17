package com.topcon.hybris.import_cockpit.pages;

import com.topcon.helpers.user_engine.UserSession;
import com.topcon.hybris.import_cockpit.ImportCockpitBasePage;
import com.topcon.hybris.import_cockpit.page_elements.LoginPageElements;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.topcon.hybris.import_cockpit.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends ImportCockpitBasePage {

    private final String pageUrlMethod = "login.zul";

    public boolean isLoginPageOpened() {
        return isCurrentURLEqualsToLoginPageURL();
    }

    @Step("Fill Import cockpit's username field.")
    public void fillUsernameFieldWith(String username) {
        $(By.id(USER_ID_FIELD_ID)).sendKeys(username);
    }

    @Step("Fill Import cockpit's password field.")
    public void fillPasswordFieldWith(String password) {
        $(By.id(PASSWORD_FIELD_ID)).sendKeys(password);
    }

    @Step("Click on Import cockpit's Login button.")
    public void clickOnLoginButton() {
        click(LOGIN_BUTTON_ID);
    }

    public void loginToImporCockpit(UserSession user) {
        fillUsernameFieldWith(user.getUsername());
        fillPasswordFieldWith(user.getPassword());
        clickOnLoginButton();
    }

    @Step("Check that current url is Import cockpit's Login page url.")
    private boolean isCurrentURLEqualsToLoginPageURL() {
        return (importCockpitProject.getBaseUrl() + pageUrlMethod).equals(getCurrentUrl());
    }
}

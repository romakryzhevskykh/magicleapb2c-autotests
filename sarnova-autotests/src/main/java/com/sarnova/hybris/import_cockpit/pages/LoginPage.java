package com.sarnova.hybris.import_cockpit.pages;

import com.sarnova.helpers.user_engine.UserSession;
import com.sarnova.hybris.import_cockpit.ImportCockpitBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.hybris.import_cockpit.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends ImportCockpitBasePage {

    private final String pageUrlMethod = "login.zul";

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
        $(By.id(LOGIN_BUTTON_ID)).click();
    }

    public void loginToImporCockpit(UserSession user) {
        fillUsernameFieldWith(user.getUsername());
        fillPasswordFieldWith(user.getPassword());
        clickOnLoginButton();
    }

    @Override
    public String getPageUrl() {
        return importCockpitProject.getBaseUrl() + pageUrlMethod;
    }
}

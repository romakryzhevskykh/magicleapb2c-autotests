package com.template.storefront.pages;

import com.template.storefront.models.TestProject;
import com.template.storefront.models.User;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.LoginPageElements.*;

@Component
public class LoginPage extends Page {
    @Autowired HomePage homePage;
    @Autowired TestProject testProject;

    @Step("Fill login field with {0}.")
    public void fillLoginFieldWith(String loginEmail) {
        $(By.id(USERNAME_FIELD_ID)).sendKeys(loginEmail);
    }

    @Step("Fill password field with {0}.")
    public void fillPasswordFieldWith(String loginPassword) {
        $(By.id(PASSWORD_FIELD_ID)).sendKeys(loginPassword);
    }

    @Step("Click on Submit button.")
    public void clickOnSubmitButton() {
        $(By.id(LOGGING_BUTTON_ID)).click();
        homePage.waitForPageLoad();
    }

    public void loginAs(User user) {
        fillLoginFieldWith(user.getUsername());
        fillPasswordFieldWith(user.getPassword());
        clickOnSubmitButton();
        user.setLoggedIn(true);
    }

    @Step("Check that Login page is opened.")
    public boolean isOpened() {
        return driver.getCurrentUrl().equals(testProject.getLoginUrl());
    }
}

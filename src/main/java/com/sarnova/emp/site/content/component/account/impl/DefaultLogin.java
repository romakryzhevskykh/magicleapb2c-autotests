package com.sarnova.emp.site.content.component.account.impl;

import com.codeborne.selenide.SelenideElement;
import com.sarnova.emp.site.common.impl.AbstractStore;
import com.sarnova.emp.site.content.component.account.Login;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Component
public class DefaultLogin extends AbstractStore implements Login {

    private SelenideElement userName = $(By.id("j_username"));
    private SelenideElement password = $(By.id("j_password"));
    private SelenideElement loginButton = $(".action-login");
    private SelenideElement errorMessage = $(".alert-danger");
    private SelenideElement loginSection = $(By.className("login-section"));

    @Override
    public SelenideElement getLoadableElement() {
        return loginSection;
    }

    @Override
    public Login enterEmail(String email) {
        userName.clear();
        userName.setValue(email);
        return this;
    }

    @Override
    public Login enterPassword(String password) {
        this.password.clear();
        this.password.setValue(password);
        return this;
    }

    @Override
    public Login clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return errorMessage.exists() && errorMessage.isDisplayed() && isNotEmpty(errorMessage.getText());
    }
}

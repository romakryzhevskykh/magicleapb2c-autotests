package com.sarnova.emp.site.content.page.account.impl;

import com.codeborne.selenide.SelenideElement;
import com.sarnova.emp.site.common.impl.AbstractBasePage;
import com.sarnova.emp.site.content.component.account.Login;
import com.sarnova.emp.site.content.component.account.Register;
import com.sarnova.emp.site.content.page.account.LoginRegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class DefaultLoginRegisterPage extends AbstractBasePage implements LoginRegisterPage {

    private static final String PAGE_URL = "login";
    private SelenideElement loginRegisterSection = $(By.className("login-section"));

    @Autowired
    private Login loginComponent;
    @Autowired
    private Register registerComponent;

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }

    @Override
    public SelenideElement getLoadableElement() {
        return loginRegisterSection;
    }

    @Override
    public Login getLoginComponent() {
        loginComponent.waitForLoad();
        return loginComponent;
    }

    @Override
    public Register getRegisterComponent() {
        registerComponent.waitForLoad();
        return registerComponent;
    }
}

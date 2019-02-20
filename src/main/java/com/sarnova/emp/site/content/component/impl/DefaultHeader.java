package com.sarnova.emp.site.content.component.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.sarnova.emp.site.common.impl.AbstractStore;
import com.sarnova.emp.site.content.component.Header;
import com.sarnova.emp.site.content.page.account.LoginRegisterPage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class DefaultHeader extends AbstractStore implements Header {

    private SelenideElement myAccountSection = $(By.className("nav__links"));
    private SelenideElement loggedInSection = $(".myAccountLinksHeader");
    private SelenideElement logInLink = $("a[href*='login']");
    private SelenideElement logOutLink = $(By.className("signOutLink"));
    private SelenideElement myAccountLink = $(".myAccountLinksHeader");

    @Autowired
    private LoginRegisterPage loginRegisterPage;

    @Override
    public SelenideElement getLoadableElement() {
        return null;
    }

    @Override
    public boolean isCustomerLoggedIn() {
        return loggedInSection.exists();
    }

    @Override
    public void clickLoginRegisterLink() {
        logInLink.click();
        loginRegisterPage.getLoadableElement().shouldBe(Condition.visible);
    }

    @Override
    public void clickLogOutLink() {
        myAccountLink.click();
        myAccountSection.shouldBe(Condition.visible);
        logOutLink.click();
        logInLink.shouldBe(Condition.visible);
    }
}

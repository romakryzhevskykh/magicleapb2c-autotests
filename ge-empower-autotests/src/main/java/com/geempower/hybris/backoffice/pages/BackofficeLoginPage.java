package com.geempower.hybris.backoffice.pages;

import com.geempower.helpers.Utils;
import com.geempower.helpers.user_engine.UserSession;
import com.geempower.hybris.backoffice.BackofficeBasePage;
import com.geempower.hybris.backoffice.models.TemplateBackoffice;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.hybris.backoffice.page_elements.BackofficeMainPageElements.*;
import static com.geempower.hybris.backoffice.page_elements.LoginPageElements.*;

@Component
public class BackofficeLoginPage extends BackofficeBasePage {
    @Autowired
    private TemplateBackoffice templateBackoffice;
    @Autowired
    private Utils utils;

    private String pageMethodUrl = "/login.zul";

    @Override
    public boolean isOpened() {
        waitUntilPageIsFullyLoaded();
        if (getCurrentUrl().contains(getPageUrl())) {
            System.out.println("Backoffice login page is opened at: " + utils.getLocalDateTimeStamp());
        } else {
            System.out.println("Backoffice login page is not opened at: " + utils.getLocalDateTimeStamp());
        }
        return getCurrentUrl().contains(getPageUrl());
    }

    @Override
    public String getPageUrl() {
        return templateBackoffice.getBaseUrl().concat(pageMethodUrl);
    }

    @Step("Login to Backoffice.")
    public void loginToBackoffice(UserSession userSession) {
        waitUntilPageIsFullyLoaded();
        System.out.println("Login to backoffice started at: " + utils.getLocalDateTimeStamp());
        fillUsername(userSession.getUsername());
        fillPassword(userSession.getPassword());
        clickOnLoginButton();
        waitUntilPageIsFullyLoaded();
        userSession.setCookies(getDriver().manage().getCookies());
    }

    @Step("Fill Username field on Login Page with {0}.")
    private void fillUsername(String username) {
        waitUntilPageIsFullyLoaded();
        enterText(username, LOGIN_INPUT_FIELD_XPATH);
    }

    @Step("Fill Password field on Login Page with {0}.")
    private void fillPassword(String password) {
        waitUntilPageIsFullyLoaded();
        enterText(password, PASSWORD_INPUT_FIELD_XPATH);
    }

    @Step("Click on Sign In button.")
    private void clickOnLoginButton() {
        click(LOGIN_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        if ((Boolean) js.executeScript("return jQuery.active == 0")) {
            if (!isDisplayed(COMMERCE_LOGO_XPATH)) {
                utils.refreshCurrentPage();
            }
        }
        if (isDisplayed(WEBKIT_CHROME_BREEZE_XPATH)) {
            utils.refreshCurrentPage();
        }
    }
}
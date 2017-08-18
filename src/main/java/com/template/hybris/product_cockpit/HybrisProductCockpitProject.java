package com.template.hybris.product_cockpit;

import com.template.helpers.webengine.Browser;
import com.template.hybris.product_cockpit.pages.LoginPage;
import com.template.hybris.product_cockpit.pages.MainPage;
import lombok.Getter;

/**
 * depends on hybpis docs https://help.hybris.com/6.3.0/hcd/8b2e29d986691014b5fe816a449aa126.html
 */
public class HybrisProductCockpitProject {
    @Getter private HybrisProductCockpitSettings hybrisProductCockpitSettings;

    private boolean isLoggedIn = false;
    private boolean isBrowserOpened = false;

    @Getter private Browser browser;

    private LoginPage loginPage;
    private MainPage mainPage;

    public HybrisProductCockpitProject(HybrisProductCockpitSettings hybrisProductCockpitSettings) {
        this.hybrisProductCockpitSettings = hybrisProductCockpitSettings;
    }

    private void openBrowser() {
        browser = Browser.createNewInstance("chrome");
        isBrowserOpened = true;
    }

    public void logIn() {
        if (!isBrowserOpened)
            openBrowser();
        if (!isLoggedIn) {
            loginPage = LoginPage.getInstance(this);
            loginPage.logIn();
            isLoggedIn = true;
            mainPage = MainPage.getInstance(browser);
        }
    }
}

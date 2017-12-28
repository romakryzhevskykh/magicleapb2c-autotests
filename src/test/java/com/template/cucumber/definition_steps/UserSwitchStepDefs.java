package com.template.cucumber.definition_steps;

import com.template.helpers.user_engine.BackofficeUserRoles;
import com.template.helpers.user_engine.ImportCockpitUserRoles;
import com.template.helpers.user_engine.StorefrontUserRoles;
import com.template.helpers.web_engine.WebDriverSessions;
import com.template.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSwitchStepDefs {

    @Autowired protected WebDriverSessions webDriverPool;
    @Autowired StartPage storefrontStartPage;

    @Given("Switch to Backoffice Admin user.")
    public void switchToBackofficeAdmin() {
        webDriverPool.setDriverActive(BackofficeUserRoles.ADMIN);
    }

    @Given("Switch to Storefront shopper.")
    public void switchToStorefrontAsShopper() {
        webDriverPool.setDriverActive(StorefrontUserRoles.SHOPPER);
        if (webDriverPool.getActiveDriver().getCurrentUrl().equals("data:,")) {
            storefrontStartPage.open();
        }
    }

    @Given("Switch to Storefront guest.")
    public void switchToStorefrontAsGuest() {
        webDriverPool.setDriverActive(StorefrontUserRoles.GUEST);
        if (webDriverPool.getActiveDriver().getCurrentUrl().equals("data:,")) {
            storefrontStartPage.open();
        }
    }

    @Given("Switch to Import cockpit import manager role.")
    public void switchToImportCockpitAsImportManager() {
        webDriverPool.setDriverActive(ImportCockpitUserRoles.IMPORT_MANAGER);
    }
}

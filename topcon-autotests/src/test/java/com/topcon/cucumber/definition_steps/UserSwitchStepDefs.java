package com.topcon.cucumber.definition_steps;

import com.topcon.helpers.user_engine.BackofficeUserRole;
import com.topcon.helpers.user_engine.ImportCockpitUserRole;
import com.topcon.helpers.user_engine.StorefrontUserRole;
import com.topcon.helpers.web_engine.WebDriverSessions;
import com.topcon.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSwitchStepDefs extends AbstractStepDefs {

    @Autowired protected WebDriverSessions webDriverPool;
    @Autowired private StartPage storefrontStartPage;

    @Given("Switch to Backoffice Admin user.")
    public void switchToBackofficeAdmin() {
        webDriverPool.setDriverActive(BackofficeUserRole.ADMIN);
    }

    @Given("Switch to Storefront shopper.")
    public void switchToStorefrontAsShopper() {
        webDriverPool.setDriverActive(StorefrontUserRole.SHOPPER);
    }

    @Given("Switch to Storefront guest.")
    public void switchToStorefrontAsGuest() {
        webDriverPool.setDriverActive(StorefrontUserRole.GUEST);
    }

    @Given("Switch to Import cockpit import manager role.")
    public void switchToImportCockpitAsImportManager() {
        webDriverPool.setDriverActive(ImportCockpitUserRole.IMPORT_MANAGER);
    }
}

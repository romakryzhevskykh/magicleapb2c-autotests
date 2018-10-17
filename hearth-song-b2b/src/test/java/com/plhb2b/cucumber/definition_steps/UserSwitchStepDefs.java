package com.plhb2b.cucumber.definition_steps;

import com.plhb2b.helpers.models.users.BackofficeUserRole;
import com.plhb2b.helpers.models.users.ImportCockpitUserRole;
import com.plhb2b.helpers.models.users.StorefrontUserRole;
import com.plhb2b.helpers.web_engine.WebDriverSessions;
import com.plhb2b.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSwitchStepDefs {

    @Autowired protected WebDriverSessions webDriverPool;
    @Autowired StartPage storefrontStartPage;

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

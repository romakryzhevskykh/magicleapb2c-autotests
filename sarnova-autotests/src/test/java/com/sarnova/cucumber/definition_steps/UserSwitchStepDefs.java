package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.BackofficeUserRoles;
import com.sarnova.helpers.user_engine.ImportCockpitUserRoles;
import com.sarnova.helpers.user_engine.StorefrontUserRoles;
import com.sarnova.helpers.web_engine.WebDriverSessions;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSwitchStepDefs extends AbstractStepDefs {

    @Autowired WebDriverSessions webDriverPool;

    @Given("Switch to Backoffice Admin user.")
    public void switchToBackofficeAdmin() {
        webDriverPool.setDriverActive(BackofficeUserRoles.ADMIN);
    }

    @Given("Switch to Storefront owner.")
    public void switchToStorefrontAsOwner() {
        webDriverPool.setDriverActive(StorefrontUserRoles.ADMIN);
    }

    @Given("Switch to Storefront shopper.")
    public void switchToStorefrontAsShopper() {
        webDriverPool.setDriverActive(StorefrontUserRoles.BUYER);
    }

    @Given("Switch to Storefront guest.")
    public void switchToStorefrontAsGuest() {
        webDriverPool.setDriverActive(StorefrontUserRoles.GUEST_CONSUMER);
    }

    @Given("Switch to Import cockpit import manager role.")
    public void switchToImportCockpitAsImportManager() {
        webDriverPool.setDriverActive(ImportCockpitUserRoles.IMPORT_MANAGER);
    }
}

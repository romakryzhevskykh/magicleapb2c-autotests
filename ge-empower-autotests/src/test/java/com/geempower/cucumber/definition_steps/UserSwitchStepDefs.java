package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.user_engine.BackofficeUserRoles;
import com.geempower.helpers.user_engine.ImportCockpitUserRoles;
import com.geempower.helpers.user_engine.StorefrontUserRoles;
import com.geempower.helpers.web_engine.WebDriverSessions;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSwitchStepDefs {

    @Autowired protected WebDriverSessions webDriverPool;

//    @Given("Switch to Backoffice Admin user.")
//    public void switchToBackofficeAdmin() {
//        webDriverPool.setDriverActive(BackofficeUserRoles.ADMIN);
//    }

    @Given("Switch to Storefront shopper.")
    public void switchToStorefrontAsShopper() {
        webDriverPool.setDriverActive(StorefrontUserRoles.SHOPPER);
    }

    @Given("Switch to Storefront admin.")
    public void switchToStorefrontAsAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.EMPOWERADMIN);
    }

//    @Given("Switch to Import cockpit import manager role.")
//    public void switchToImportCockpitAsImportManager() {
//        webDriverPool.setDriverActive(ImportCockpitUserRoles.IMPORT_MANAGER);
//    }
}

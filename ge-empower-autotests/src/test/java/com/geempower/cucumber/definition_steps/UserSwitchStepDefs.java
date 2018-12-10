package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.user_engine.BackofficeUserRoles;
import com.geempower.helpers.user_engine.HACUserRoles;
import com.geempower.helpers.user_engine.StorefrontUserRoles;
import com.geempower.helpers.web_engine.WebDriverSessions;
import com.geempower.hybris.hac.models.HacActiveNode;
import com.geempower.hybris.hac.models.TemplateHAC;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSwitchStepDefs {

    @Autowired
    protected WebDriverSessions webDriverPool;
    @Autowired
    private TemplateHAC templateHAC;

    @Given("Switch to Storefront as externalUser1.")
    public void switchToStorefrontAsExternalUser1() {
        webDriverPool.setDriverActive(StorefrontUserRoles.EXTERNALUSER1);
    }

    @Given("Switch to Storefront as externalUser2.")
    public void switchToStorefrontAsExternalUser2() {
        webDriverPool.setDriverActive(StorefrontUserRoles.EXTERNALUSER2);
    }

    @Given("Switch to Storefront as externalUser3.")
    public void switchToStorefrontAsExternalUser3() {
        webDriverPool.setDriverActive(StorefrontUserRoles.EXTERNALUSER3);
    }

    @Given("Switch to Storefront as caAdmin.")
    public void switchToStorefrontAsCaAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.CAADMIN);
    }

    @Given("Switch to Storefront as first caAdmin.")
    public void switchToStorefrontAsCaAdmin1() {
        webDriverPool.setDriverActive(StorefrontUserRoles.CAADMIN1);
    }

    @Given("Switch to Storefront as admin.")
    public void switchToStorefrontAsAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.EMPOWERADMIN);
    }

    @Given("Switch to HAC (.*) as admin.")
    public void switchToHACF1AsAdmin(String node) {
        templateHAC.setHacActiveNode(HacActiveNode.valueOf(node));
        webDriverPool.setDriverActive(HACUserRoles.ADMIN);
    }

    @Given("Switch to Storefront as smAdmin.")
    public void switchToStorefrontAsSmAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.SMADMIN);
    }

    @Given("Switch to Storefront as first smAdmin.")
    public void switchToStorefrontAsSmAdmin1() {
        webDriverPool.setDriverActive(StorefrontUserRoles.SMADMIN1);
    }

    @Given("Switch to Storefront as rmAdmin.")
    public void switchToStorefrontAsRmAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.RMADMIN);
    }

    @Given("Switch to Storefront as secondInternalUser.")
    public void switchToStorefrontAsInternalUser1() {
        webDriverPool.setDriverActive(StorefrontUserRoles.INTERNALUSER1);
    }

    @Given("Switch to Storefront as thirdInternalUser.")
    public void switchToStorefrontAsThirdInternalUser() {
        webDriverPool.setDriverActive(StorefrontUserRoles.INTERNALUSER2);
    }

    @Given("Switch to Backoffice as admin.")
    public void switchToBackofficeAsAdmin() {
        webDriverPool.setDriverActive(BackofficeUserRoles.ADMIN);
    }

    @Given("Switch to Storefront as newInternalUser.")
    public void switchToStorefrontAsNewInternalUser() {
        webDriverPool.setDriverActive(StorefrontUserRoles.NEWINTERNALUSER);
    }

    @Given("Switch to Storefront as internalUser.")
    public void switchToStorefrontAsInternalUser() {
        webDriverPool.setDriverActive(StorefrontUserRoles.INTERNALUSER);
    }

    @Given("Switch to Storefront as regionalView.")
    public void switchToStorefrontAsRegionalView() {
        webDriverPool.setDriverActive(StorefrontUserRoles.REGIONALVIEW);
    }

    @Given("Switch to Storefront as testRoleUser.")
    public void switchToStorefrontAsTestRoleUser() {
        webDriverPool.setDriverActive(StorefrontUserRoles.TESTROLEUSER);
    }

    @Given("Switch to Storefront as mfgRepAdmin.")
    public void switchToStorefrontAsMfgRepAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.MFGREPADMIN);
    }

    @Given("Switch to Storefront as mfgRepUser.")
    public void switchToStorefrontAsMfgRepUser() {
        webDriverPool.setDriverActive(StorefrontUserRoles.MFGREPUSER);
    }

    @Given("Switch to Storefront as newUser.")
    public void switchToStorefrontAsNewUser() {
        webDriverPool.setDriverActive(StorefrontUserRoles.NEWUSER);
    }

    @Given("Switch to Storefront as newMfgRepUser1.")
    public void switchToStorefrontAsNewMfgRepUser1() {
        webDriverPool.setDriverActive(StorefrontUserRoles.MFGREPUSER1);
    }

    @Given("Switch to Storefront as empAdmin.")
    public void switchToStorefrontAsEmpAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.EMPADMIN);
    }

    @Given("Switch to Storefront as first EmpAdmin.")
    public void switchToStorefrontAsFirstEmpAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.FIRSTEMPADMIN);
    }

    @Given("Switch to Storefront as secondEmpAdmin.")
    public void switchToStorefrontAsSecondEmpAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.SECONDEMPADMIN);
    }

    @Given("Switch to Storefront as helpDesc.")
    public void switchToStorefrontAsHelpDesc() {
        webDriverPool.setDriverActive(StorefrontUserRoles.HELPDESC);
    }

    @Given("Switch to Storefront as first helpDesc.")
    public void switchToStorefrontAsHelpDesc1() {
        webDriverPool.setDriverActive(StorefrontUserRoles.HELPDESC1);
    }

    @Given("Switch to Storefront as csAdmin.")
    public void switchToStorefrontAsCsAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.CSADMIN);
    }

    @And("^Dismiss sessions.$")
    public void dismissSession() {
        webDriverPool.dismissAll();
    }
}
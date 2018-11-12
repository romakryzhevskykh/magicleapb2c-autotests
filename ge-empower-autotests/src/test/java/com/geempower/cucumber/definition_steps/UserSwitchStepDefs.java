package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.user_engine.HACUserRoles;
import com.geempower.helpers.user_engine.StorefrontUserRoles;
import com.geempower.helpers.web_engine.WebDriverSessions;
import com.geempower.hybris.hac.models.HacActiveNode;
import com.geempower.hybris.hac.models.TemplateHAC;
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

    @Given("Switch to Storefront as caAdmin.")
    public void switchToStorefrontAsCaAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.CAADMIN);
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

    @Given("Switch to Storefront as mfgRepUser.")
    public void switchToStorefrontAsMfgRepUser() {
        webDriverPool.setDriverActive(StorefrontUserRoles.MFGREPUSER);
    }

    @Given("Switch to Storefront as mfgRepUser1.")
    public void switchToStorefrontAsMfgRepUser1() {
        webDriverPool.setDriverActive(StorefrontUserRoles.MFGREPUSER1);
    }

    @Given("Switch to Storefront as empAdmin.")
    public void switchToStorefrontAsEmpAdmin() {
        webDriverPool.setDriverActive(StorefrontUserRoles.EMPADMIN);
    }

    @Given("Switch to Storefront as firstEmpAdmin.")
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
}
package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.page_blocks.HeaderBlock;
import com.geempower.storefront.pages.AccountManagementPage;
import com.geempower.storefront.pages.LoginPage;
import com.geempower.storefront.pages.SsoLoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class PreconditionStepDefs extends AbstractStepDefs {
    @Autowired
    private HeaderBlock headerBlock;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private SsoLoginPage ssoLoginPage;
    @Autowired
    private AccountManagementPage accountManagementPage;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (!headerBlock.isUserLoggedIn()) {
            loginPage.open();
            loginPage.waitHTMLTemplateLoad();
            loginPage.waitJQueryRequestsLoad();
            if (loginPage.isOpened()) {
                loginPage.loginToStorefront(userSessions.getActiveUserSession().getUser());
            } else if (ssoLoginPage.isOpened()) {
                ssoLoginPage.loginToStorefront(userSessions.getActiveUserSession().getUser());
            }
        }
    }

    @And("^Account management page is opened.$")
    public void accountManagementPageIsOpened() {
        if (!accountManagementPage.isOpened()) {
            accountManagementPage.open();
        }
    }
}

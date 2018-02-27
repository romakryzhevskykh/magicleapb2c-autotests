package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.page_blocks.HeaderBlock;
import com.geempower.storefront.pages.*;
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
    @Autowired
    private OrdersPage ordersPage;
    @Autowired
    private DashboardPage dashboardPage;

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
        accountManagementPage.waitUntilPageIsFullyLoaded();
        if (!accountManagementPage.isOpened()) {
            accountManagementPage.open();
        }
    }

    @And("^Orders page is opened.$")
    public void ordersPageIsOpened() {
        accountManagementPage.waitUntilPageIsFullyLoaded();
        if (!ordersPage.isOpened()) {
            ordersPage.open();
        }
    }

    @And("^Dashboard page is opened.$")
    public void dashboardPageIsOpened() {
        if (!dashboardPage.isOpened()) {
            dashboardPage.open();
        }
    }

}

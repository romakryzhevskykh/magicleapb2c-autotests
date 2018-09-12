package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.page_blocks.HeaderBlock;
import com.geempower.storefront.pages.*;
import com.geempower.storefront.pages.order.OrdersPage;
import com.geempower.storefront.pages.product.ProductsPage;
import com.geempower.storefront.pages.rebate.RebateCreation1Page;
import com.geempower.storefront.pages.rebate.RebatesPage;
import com.geempower.storefront.pages.returns.ReturnCreation1Page;
import com.geempower.storefront.pages.returns.ReturnsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class PreconditionStepDefs extends AbstractStepDefs {
    @Autowired
    private HeaderBlock headerBlock;
    @Autowired
    private com.geempower.storefront.pages.LoginPage loginPage;
    @Autowired
    private SsoLoginPage ssoLoginPage;
    @Autowired
    private AccountManagementPage accountManagementPage;
    @Autowired
    private OrdersPage ordersPage;
    @Autowired
    private DashboardPage dashboardPage;
    @Autowired
    private ShipmentsPage shipmentsPage;
    @Autowired
    private MyCartPage myCartPage;
    @Autowired
    private SavedItemsPage savedItemsPage;
    @Autowired
    private InvoicePage invoicePage;
    @Autowired
    private ProductsPage productsPage;
    @Autowired
    private ReturnsPage returnsPage;
    @Autowired
    private ReturnCreation1Page returnCreation1Page;
    @Autowired
    private RebatesPage rebatesPage;
    @Autowired
    private RebateCreation1Page rebateCreation1Page;
    @Autowired
    private SpecialPricingPage specialPricingPage;
    @Autowired
    private ManageUsersPage manageUsersPage;
    @Autowired
    private ProfilePage profilePage;
    @Autowired
    private PriceAndAvailabilityPage priceAndAvailabilityPage;
    @Autowired
    private NotificationCenterPage notificationCenterPage;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (!headerBlock.isUserLoggedIn()) {
            dashboardPage.open();
            loginPage.waitHTMLTemplateLoad();
            loginPage.waitJQueryRequestsLoad();
            if (loginPage.isOpened()) {
                loginPage.loginToStorefront(userSessions.getActiveUserSession().getUser());
            } else if (ssoLoginPage.isOpened()) {
                ssoLoginPage.loginToStorefront(userSessions.getActiveUserSession());
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

    @And("^Shipments page is opened.$")
    public void shipmentsPageIsOpened() {
        shipmentsPage.waitUntilPageIsFullyLoaded();
        if (!shipmentsPage.isOpened()) {
            shipmentsPage.open();
        }
    }

    @And("^My Cart page is opened.$")
    public void myCartPageIsOpened() {
        myCartPage.waitUntilPageIsFullyLoaded();
        if (!myCartPage.isOpened()) {
            myCartPage.open();
        }
    }

    @And("^Saved Items page is opened.$")
    public void savedItemsPageIsOpened() {
        savedItemsPage.waitUntilPageIsFullyLoaded();
        if (!savedItemsPage.isOpened()) {
            savedItemsPage.open();
        }
    }

    @And("^Invoice page is opened.$")
    public void invoicePageIsOpened() {
        invoicePage.waitUntilPageIsFullyLoaded();
        if (!invoicePage.isOpened()) {
            invoicePage.open();
        }
    }

    @And("^Products page is opened.$")
    public void productsPageIsOpened() {
        productsPage.waitUntilPageIsFullyLoaded();
        if (!productsPage.isOpened()) {
            productsPage.open();
        }
    }

    @And("^Returns page is opened.$")
    public void returnsPageIsOpened() {
        returnsPage.waitUntilPageIsFullyLoaded();
        if (!returnsPage.isOpened()) {
            returnsPage.open();
        }
    }

    @And("^Create Returns page is opened.$")
    public void createReturnsPageIsOpened() {
        returnCreation1Page.waitUntilPageIsFullyLoaded();
        if (!returnCreation1Page.isOpened()) {
            returnCreation1Page.open();
        }
    }

    @And("^Rebates page is opened.$")
    public void rebatesPageIsOpened() {
        rebatesPage.waitUntilPageIsFullyLoaded();
        if (!rebatesPage.isOpened()) {
            rebatesPage.open();
        }
    }

    @And("^Create Rebates page is opened.$")
    public void createRebatesPageIsOpened() {
        rebateCreation1Page.waitUntilPageIsFullyLoaded();
        if (!rebateCreation1Page.isOpened()) {
            rebateCreation1Page.open();
        }
    }

    @And("^Special Pricing page is opened.$")
    public void specialPricingPageIsOpened() {
        specialPricingPage.waitUntilPageIsFullyLoaded();
        if (!specialPricingPage.isOpened()) {
            specialPricingPage.open();
        }
    }

    @And("^Manage Users page is opened.$")
    public void manageUsersPageIsOpened() {
        manageUsersPage.waitUntilPageIsFullyLoaded();
        if (!manageUsersPage.isOpened()) {
            manageUsersPage.open();
        }
    }

    @And("^Profile page is opened.$")
    public void profilePageIsOpened() {
        profilePage.waitUntilPageIsFullyLoaded();
        if (!profilePage.isOpened()) {
            profilePage.open();
        }
    }

    @And("^Price&Availability page is opened.$")
    public void priceAndAvailabilityPageIsOpened() {
        priceAndAvailabilityPage.waitUntilPageIsFullyLoaded();
        if (!priceAndAvailabilityPage.isOpened()) {
            priceAndAvailabilityPage.open();
        }
    }

    @And("^Dashboard page is opened.$")
    public void dashboardPageIsOpened() {
        dashboardPage.waitUntilPageIsFullyLoaded();
        if (!dashboardPage.isOpened()) {
            dashboardPage.open();
        }
    }

    @And("^Notification Center page is opened.$")
    public void NotificationCenterPageIsOpened() {
        notificationCenterPage.waitUntilPageIsFullyLoaded();
        if (!notificationCenterPage.isOpened()) {
            notificationCenterPage.open();
        }
    }
}
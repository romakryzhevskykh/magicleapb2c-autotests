package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.ProductManager;
import com.geempower.storefront.page_blocks.HeaderBlock;
import com.geempower.storefront.pages.*;
import com.geempower.storefront.pages.order.OrdersPage;
import com.geempower.storefront.pages.product.ProductsPage;
import com.geempower.storefront.pages.rebate.RebatesPage;
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
    private RebatesPage rebatesPage;
    @Autowired
    private SpecialPricingPage specialPricingPage;
    @Autowired
    private ManageUsersPage manageUsersPage;
    @Autowired
    private ProfilePage profilePage;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private PriceAndAvailabilityPage priceAndAvailabilityPage;


    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (!headerBlock.isUserLoggedIn()) {
            loginPage.open();
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
        accountManagementPage.isAccountPageFullyLoaded();
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

    @And("^Rebates page is opened.$")
    public void rebatesPageIsOpened() {
        rebatesPage.waitUntilPageIsFullyLoaded();
        if (!rebatesPage.isOpened()) {
            rebatesPage.open();
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
}

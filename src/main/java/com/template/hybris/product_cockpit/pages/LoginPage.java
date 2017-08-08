package com.template.hybris.product_cockpit.pages;

import com.template.hybris.product_cockpit.HybrisProductCockpitProject;
import com.template.hybris.product_cockpit.html_elements.login_page_elements.LoginBlock;

public class LoginPage {
    private static LoginPage loginPage;
    private LoginBlock loginBlock;

    public static LoginPage getInstance(HybrisProductCockpitProject hybrisProductCockpitProject) {
        if (loginPage == null) {
            loginPage = new LoginPage(hybrisProductCockpitProject);
        }
        return loginPage;
    }

    private LoginPage(HybrisProductCockpitProject hybrisProductCockpitProject) {
        this.loginBlock = new LoginBlock(hybrisProductCockpitProject);
    }

    public void logIn() {
        loginBlock.logIn();
    }

}

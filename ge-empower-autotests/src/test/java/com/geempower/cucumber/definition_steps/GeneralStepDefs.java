package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.UserNotValidPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneralStepDefs extends AbstractStepDefs {
    @Autowired
    private UserNotValidPage userNotValidPage;

    @And("^Focus on browser.$")
    public void focusOnBrowser() {
        userNotValidPage.focusOnActiveBrowser();
    }

    @And("^Refresh page.$")
    public void refreshPage() {
        userNotValidPage.refreshCurrentPage();
    }
}

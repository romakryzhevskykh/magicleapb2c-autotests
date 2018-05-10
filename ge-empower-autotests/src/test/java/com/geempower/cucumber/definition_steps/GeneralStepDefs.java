package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.Utils;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneralStepDefs extends AbstractStepDefs {
    @Autowired private Utils utils;

    @And("^Focus on browser.$")
    public void focusOnBrowser() {
        utils.focusOnActiveBrowser();
    }

    @And("^Refresh page.$")
    public void refreshPage() {
        utils.refreshCurrentPage();
    }
}

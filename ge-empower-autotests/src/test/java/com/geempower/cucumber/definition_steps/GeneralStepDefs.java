package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.BasePageObject;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneralStepDefs extends AbstractStepDefs {
    @Autowired
    private BasePageObject basePageObject;

    @And("^Focus on browser.$")
    public void focusOnBrowser() {
        basePageObject.focusOnActiveBrowser();
    }

    @And("^Refresh page.$")
    public void refreshPage() {
        basePageObject.refreshCurrentPage();
    }
}

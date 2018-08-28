package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.ReportsPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class ReportsPageStepDefs extends AbstractStepDefs {

    @Autowired private ReportsPage reportsPage;

    @And("^Check that Reports page is opened.$")
    public void checkThatReportsPageIsOpened() {
        assertTrue(reportsPage.isOpened());
    }
}

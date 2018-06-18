package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.PharmaceuticalBackorderReportPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class PharmaceuticalBackorderReportPageStepDefs extends AbstractStepDefs {

    @Autowired private PharmaceuticalBackorderReportPage pharmaceuticalBackorderReportPage;

    @And("^Check that Pharmaceutical Backorder Report page is opened.$")
    public void checkThatPharmaceuticalBackorderReportPageIsOpened() {
        assertTrue(pharmaceuticalBackorderReportPage.isOpened());
    }
}

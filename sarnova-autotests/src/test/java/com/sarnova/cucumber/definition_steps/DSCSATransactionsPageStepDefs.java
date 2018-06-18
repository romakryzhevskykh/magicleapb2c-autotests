package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.DSCSATransactionsPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class DSCSATransactionsPageStepDefs extends AbstractStepDefs {

    @Autowired private DSCSATransactionsPage dscsaTransactionsPage;

    @And("^Check that DSCSA Transactions page is opened.$")
    public void checkThatDSCSATransactionsPageIsOpened() {
        assertTrue(dscsaTransactionsPage.isOpened());
    }
}

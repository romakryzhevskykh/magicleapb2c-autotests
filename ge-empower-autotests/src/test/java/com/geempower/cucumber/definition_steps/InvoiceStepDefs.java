package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.InvoicePage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class InvoiceStepDefs extends AbstractStepDefs{
    @Autowired
    InvoicePage invoicePage;

    @Then("^(.*) title is displayed on Invoice page.$")
    public void checkAllInvoicesTitle(String allInvoicesTitle) {
        assertEquals(invoicePage.getInvoicesTitle(), allInvoicesTitle);
    }
}

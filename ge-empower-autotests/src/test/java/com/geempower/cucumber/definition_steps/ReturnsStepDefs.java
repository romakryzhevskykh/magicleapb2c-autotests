package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ReturnsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ReturnsStepDefs extends AbstractStepDefs {
    @Autowired
    ReturnsPage returnsPage;

    @Then("^(.*) title is displayed on Returns page.$")
    public void checkAllCasesTitle(String allCasesTitle) {
        assertEquals(returnsPage.getReturnsTitle(), allCasesTitle);
    }
}

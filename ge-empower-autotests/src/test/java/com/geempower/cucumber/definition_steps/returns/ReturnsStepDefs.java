package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.storefront.pages.returns.ReturnsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ReturnsStepDefs extends AbstractStepDefs {
    @Autowired
    private ReturnsPage returnsPage;

    @Then("^(.*) title is displayed on Returns page.$")
    public void checkAllCasesTitle(String allCasesTitle) {
        assertEquals(returnsPage.getReturnsTitle(), allCasesTitle);
    }

    @And("^Click on Create Request button.$")
    public void clickOnCreateRequestButton(){
        returnsPage.clickOnCreateRequestButton();
    }
}

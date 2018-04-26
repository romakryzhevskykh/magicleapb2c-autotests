package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.SpecialPricingPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;


public class SpecialPricingStepDefs extends AbstractStepDefs {
    @Autowired
    private SpecialPricingPage specialPricingPages;

    @Then("^(.*) title is displayed on Special Pricing page.$")
    public void checkAllSpecialPricingTitle(String allSpecialPricingTitle) {
        assertEquals(allSpecialPricingTitle, specialPricingPages.getSpecialPricingTitle());
    }
}

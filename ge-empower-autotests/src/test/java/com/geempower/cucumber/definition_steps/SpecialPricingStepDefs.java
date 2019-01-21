package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.SpecialPricingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SpecialPricingStepDefs extends AbstractStepDefs {
    @Autowired
    private SpecialPricingPage specialPricingPages;

    @Then("^(.*) title is displayed on Special Pricing page.$")
    public void checkAllSpecialPricingTitle(String allSpecialPricingTitle) {
        assertEquals(allSpecialPricingTitle, specialPricingPages.getSpecialPricingTitle());
    }

    @Then("^(.*) tab is displayed.$")
    public void regionalListPriceTabIsDisplayed(String tabTitle) {
        assertEquals(tabTitle, specialPricingPages.getRegionalListTabTitle());
    }

    @When("^User switch to Regional List Price tab.$")
    public void userSwitchToRegionalListPriceTab() {
        specialPricingPages.openRegionalListTab();
    }

    @And("^Opens Select Price Schedule list.$")
    public void opensSelectPriceScheduleList() {
        specialPricingPages.openPriceScheduleList();
    }

    @Then("^Only one document is displayed with appropriate (.*) salesDistrict.$")
    public void onlyOneDocumentIsDisplayedWithAppropriateSalesDistrictSalesDistrict(String salesDistrict) {
        Supplier<Stream<WebElement>> priceScheduleList = () -> specialPricingPages.getAllPriceScheduleDocuments();
        Predicate<WebElement> p = priceSchedule -> priceSchedule.getText().contains(salesDistrict);
        assertTrue(priceScheduleList.get().count() == 3);
        assertTrue(priceScheduleList.get().anyMatch(p));
    }

    @Then("^Regional List Price tab is not displayed.$")
    public void regionalListPriceTabIsNotDisplayed() {
        assertFalse(specialPricingPages.isRegionalListTabDisplayed());
    }
}
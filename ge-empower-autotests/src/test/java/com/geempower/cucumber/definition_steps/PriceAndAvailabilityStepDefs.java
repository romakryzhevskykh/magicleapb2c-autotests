package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.PriceAndAvailabilityPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PriceAndAvailabilityStepDefs extends AbstractStepDefs {

    @Autowired
    PriceAndAvailabilityPage priceAndAvailabilityPage;

    @Then("^Check that default quantity is equals to (.*) on the Price&Availability page.$")
    public void checkQtyValue(String qtyValue) {
        assertEquals(priceAndAvailabilityPage.getQtyValue(), qtyValue);
    }

    @Then("^Check that description, list price, final net price, availability are equal to data from PDP.$")
    public void checkThatDescriptionListPriceFinalNetPriceAvailabilityAreEqualToDataFromPDP() throws Throwable {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String description = getSelectedProducts().keySet().stream().findAny().get().getDescription();
        String listPrice = getSelectedProducts().keySet().stream().findAny().get().getListPrice().trim();
        String finalNetPrice = getSelectedProducts().keySet().stream().findAny().get().getFinalNetPrice();
        String availability = getSelectedProducts().keySet().stream().findAny().get().getAvailability().replace("*", "");

        assertEquals(priceAndAvailabilityPage.getDescription(), description);
        assertEquals(priceAndAvailabilityPage.getListPrice(), listPrice);
        assertEquals(priceAndAvailabilityPage.getFinalNetPrice(), finalNetPrice);
        assertTrue(priceAndAvailabilityPage.getAvailability().contains(availability));
    }
}

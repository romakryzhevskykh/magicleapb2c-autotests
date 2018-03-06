package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.MyCartPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class MyCartStepDefs extends AbstractStepDefs {
    @Autowired
    MyCartPage myCartPage;

    @Then("(.*) title is displayed on My Cart page.")
    public void checkMyCartTitle(String myCartTitle) {
        assertEquals(myCartPage.getMyCartTitle(), myCartTitle);
    }

}

package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.HelpNewToBoundtreePage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class HelpNewToBoundtreePageStepDefs extends AbstractStepDefs {

    @Autowired private HelpNewToBoundtreePage helpNewToBoundtreePage;

    @Then("^Check that Help/New To Boundtree\\? page is opened.$")
    public void checkThatHelpNewToBoundtreePageIsOpened() {
        assertTrue(helpNewToBoundtreePage.isOpened());
    }

}

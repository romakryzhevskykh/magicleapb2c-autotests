package com.template.cucumber.definition_steps;

import com.template.storefront.pages.HomePage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class HomePageStepDefs extends AbstractStepDefs {

    @Autowired HomePage homePage;

    @Then("Check that Home page is opened.")
    public void checkThatHomePageIsOpened() {
        assertTrue(homePage.isHomePageOpened());
    }
}

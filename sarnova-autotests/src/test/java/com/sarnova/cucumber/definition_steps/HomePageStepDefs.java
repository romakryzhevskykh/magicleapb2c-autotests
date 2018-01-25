package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.HomePage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class HomePageStepDefs {

    @Autowired HomePage homePage;

    @Then("Check that Home page is opened.")
    public void checkThatHomePageIsOpened() {
        assertTrue(homePage.isOpened());
    }
}

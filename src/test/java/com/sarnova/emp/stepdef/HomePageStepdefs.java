package com.sarnova.emp.stepdef;

import com.sarnova.emp.site.content.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;


public class HomePageStepdefs {

    @Autowired
    private HomePage homePage;

    @Given("^Customer opens Home page$")
    public void customerOpensHomePage() {
        homePage.openPage();
    }

    @Then("^Verify that Home Page is displayed$")
    public void verifyThatHomePageIsDisplayed() {
        homePage.waitForLoad();
        Assertions.assertThat(homePage.isLoaded()).as("Login Page isn't displayed").isTrue();
    }

    @And("^Verify that success register message \"([^\"]*)\" is displayed$")
    public void verifyThatSuccessRegisterMessageIsDisplayed(String message) {
        Assertions.assertThat(homePage.isSuccessRegisterMessageDisplayed(message)).as("Success register message isn't displayed").isTrue();
    }
}

package com.sarnova.emp.stepdef;

import com.sarnova.emp.site.content.component.Header;
import com.sarnova.emp.site.content.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class GeneralStepdefs {

    @Autowired
    private HomePage homePage;

    @When("^Customer logs out$")
    public void customerLogsOut() {
       // getHeader().clickMyAccount();
        getHeader().clickLogOutLink();
    }

    @Then("^Customer sees not logged in header$")
    public void customerSeesNotLoggedInHeader() {
        Assertions.assertThat(getHeader().isCustomerLoggedIn()).as("Customer is still logged in").isFalse();
    }

    @Then("^Customer sees logged in header$")
    public void customerSeesLoggedInHeader() {
        Assertions.assertThat(homePage.getHeader().isCustomerLoggedIn()).as("Customer is not logged in").isTrue();
    }

    @And("^Customer navigates to Login Register page$")
    public void customerNavigatesToLoginRegisterPage() {
        getHeader().clickLoginRegisterLink();
    }

    private Header getHeader() {
        return homePage.getHeader();
    }
}

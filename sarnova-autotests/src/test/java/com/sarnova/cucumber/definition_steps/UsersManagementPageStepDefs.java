package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.UsersManager;
import com.sarnova.storefront.pages.UsersPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class UsersManagementPageStepDefs extends AbstractStepDefs {
    @Autowired UsersManager usersManager;
    @Autowired UsersPage usersPage;

    @Then("^Check that Users page is opened.$")
    public void checkThatUsersPageIsOpened() {
        assertTrue(usersPage.isOpened());
    }

    @Given("^Open Users Management page.$")
    public void openUserManagementPage() {
        usersPage.open();
    }

    @When("^Click on Add new user on Users page.$")
    public void clickOnAddNewUserOnUsersPage() {
        usersPage.clickOnAddNewUser();
    }
}

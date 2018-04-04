package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.UsersManager;
import com.sarnova.storefront.pages.UsersPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersManagementPageStepDefs extends AbstractStepDefs {
    @Autowired UsersManager usersManager;
    @Autowired UsersPage usersPage;

    @Given("^Open Users Management page.$")
    public void openUserManagementPage() {
        usersPage.open();
    }

    @When("^Click on Add new user on Users page.$")
    public void clickOnAddNewUserOnUsersPage() {
        usersPage.clickOnAddNewUser();
    }
}

package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ManageUsersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ManageUsersStepDefs extends AbstractStepDefs {
    @Autowired
    private ManageUsersPage manageUsersPage;

    @Then("^(.*) title is displayed on Manage Users page.$")
    public void checkManageUsersTitle(String manageUsersTitle) {
        assertEquals(manageUsersPage.getManageUsersTitle(), manageUsersTitle);
    }

    @When("^Admin opens Users tab.$")
    public void adminOpensUsersTab() {
        manageUsersPage.openUsersTab();
    }

    @And("^Sets (.*) email to the email field.$")
    public void setsValidEmailToTheEmailField(String email) {
        manageUsersPage.setEmailToTheSearchField(email);
    }

    @And("^Click on the Search button.$")
    public void clickOnTheSearchButton() {
        manageUsersPage.clickOnSearchUserButton();
    }

    @Then("^Appropriate user with appropriate (.*) email is displayed in the users list.$")
    public void appropriateUserWithAppropriateEmailEmailIsDisplayedInTheUsersList(String email) {
        assertEquals(manageUsersPage.isUserFoundByEmail(), email);
    }
}
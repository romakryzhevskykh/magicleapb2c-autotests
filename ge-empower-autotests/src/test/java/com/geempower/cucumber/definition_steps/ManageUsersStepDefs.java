package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ManageUsersPage;
import cucumber.api.PendingException;
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
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
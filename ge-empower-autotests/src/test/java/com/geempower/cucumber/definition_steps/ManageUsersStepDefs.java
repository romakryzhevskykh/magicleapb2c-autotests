package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ManageUsersPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ManageUsersStepDefs extends AbstractStepDefs {
    @Autowired
    ManageUsersPage manageUsersPage;

    @Then("^(.*) title is displayed on Manage Users page.$")
    public void checkManageUsersTitle(String manageUsersTitle) {
        assertEquals(manageUsersPage.getManageUsersTitle(), manageUsersTitle);
    }
}
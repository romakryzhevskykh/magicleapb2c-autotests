package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.UserGroupsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class UserGroupsPageStepDefs extends AbstractStepDefs {
    @Autowired UserGroupsPage userGroupsPage;

    @Then("^Check that User Groups page is opened.$")
    public void checkThatUserGroupsPageIsOpened() {
        assertTrue(userGroupsPage.isOpened());
    }
}

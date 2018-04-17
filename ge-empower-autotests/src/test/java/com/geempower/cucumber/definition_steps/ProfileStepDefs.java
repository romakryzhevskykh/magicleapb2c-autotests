package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ProfilePage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ProfileStepDefs extends AbstractStepDefs {
    @Autowired
    ProfilePage profilePage;

    @Then("^(.*) title is displayed on Profile page.$")
    public void checkProfileTitle(String profileTitle) {
        assertEquals(profilePage.getProfileTitle(), profileTitle);
    }
}

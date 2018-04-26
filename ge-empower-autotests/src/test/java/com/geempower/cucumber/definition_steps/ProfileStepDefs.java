package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ProfilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ProfileStepDefs extends AbstractStepDefs {
    @Autowired
    private ProfilePage profilePage;

    @Then("^(.*) title is displayed on Profile page.$")
    public void checkProfileTitle(String profileTitle) {
        assertEquals(profilePage.getProfileTitle(), profileTitle);
    }

    @And("^Admin's name and last name are stored to threadVars.$")
    public void adminNameAndLastNameAreStoredToThreadVars() {
        threadVarsHashMap.put(TestKeyword.USER_FIRST_AND_LAST_NAME, profilePage.getUserName() + " " + profilePage.getUserLastName());
    }
}

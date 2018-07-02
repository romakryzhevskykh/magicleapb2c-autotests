package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ProfilePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @SuppressWarnings("unchecked")
    @Then("^Admin Privileges are equal to roles which were set by Admin in each region.$")
    public void adminPrivilegesAreEqualToRolesWhichWereSetByAdminInEachRegion() {
        HashMap<String, String> userRolesInEachRegionInUserProfile = profilePage.getRoleForEachRegion();
        HashMap<String, String> userRolesInEachRegionSetByAdmin = (HashMap) threadVarsHashMap.get(TestKeyword.USER_ROLES_IN_EACH_REGION);
        assertTrue(userRolesInEachRegionInUserProfile.entrySet().containsAll(userRolesInEachRegionSetByAdmin.entrySet()));
    }
}

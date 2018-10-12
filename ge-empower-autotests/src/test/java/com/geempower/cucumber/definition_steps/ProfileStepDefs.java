package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.UserManager;
import com.geempower.storefront.pages.ProfilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileStepDefs extends AbstractStepDefs {
    @Autowired
    private ProfilePage profilePage;
    @Autowired
    private UserManager userManager;

    @Then("^(.*) title is displayed on Profile page.$")
    public void checkProfileTitle(String profileTitle) {
        assertEquals(profilePage.getProfileTitle(), profileTitle);
    }

    @And("^Admin's name and last name are stored to threadVars.$")
    public void adminNameAndLastNameAreStoredToThreadVars() {
        threadVarsHashMap.put(TestKeyword.USER_FIRST_AND_LAST_NAME, profilePage.getUserName() + " " + profilePage.getUserLastName());
    }

    @And("^Admin's name is stored to threadVars.$")
    public void adminNameIsStoredToThreadVars() {
        threadVarsHashMap.put(TestKeyword.USER_FIRST_NAME, profilePage.getUserName());
    }

    @SuppressWarnings("unchecked")
    @Then("^Admin Privileges are equal to roles which were set by Admin in each region.$")
    public void adminPrivilegesAreEqualToRolesWhichWereSetByAdminInEachRegion() {
        HashMap<String, String> userRolesInEachRegionInUserProfile = profilePage.getRoleForEachRegion();
        HashMap<String, String> userRolesInEachRegionSetByAdmin = (HashMap) threadVarsHashMap.get(TestKeyword.USER_ROLES_IN_EACH_REGION);
        assertTrue(userRolesInEachRegionInUserProfile.entrySet().containsAll(userRolesInEachRegionSetByAdmin.entrySet()));
    }

    @Then("^Unregister section with (.*) title is displayed.$")
    public void unregisterSectionWithTitleIsDisplayed(String unregisterTitle) {
        assertEquals(unregisterTitle, profilePage.getUnregisterSectionTitle());
    }

    @Then("^Deactivate description (.*) is displayed.$")
    public void deactivateDescriptionDescriptionIsDisplayed(String description) {
        assertEquals(description, profilePage.getDeactivateActionDescription());
    }

    @When("^User clicks on Deactivate my ID button.$")
    public void userClicksOnDeactivateMyIDButton() {
        profilePage.clickOnDeactivateMyUserIDButton();
    }

    @Then("^Confirmation pop-up appeared with appropriate (.*) text.$")
    public void confirmationPopUpAppearedWithAppropriateConfirmationText(String confirmationText) {
        assertEquals(confirmationText, profilePage.getConfirmationTextFromConfirmationPopUp());
    }

    @Then("^Confirmation text (.*) is displayed in the pop-up.$")
    public void confirmationTextConfirmationIsDisplayedInThePopUp(String confirmationText2) {
        assertEquals(confirmationText2, profilePage.getConfirmationSecondTextFromConfirmationPopUp());
    }

    @Then("^Deactivate my User ID button is disabled.$")
    public void deactivateMyUserIDButtonIsNotClickable() {
        assertTrue(profilePage.isDeactivateButtonDisabled());
    }

    @When("^User confirms the deactivate action.$")
    public void userConfirmsTheDeactivateAction() {
        profilePage.confirmDeactivation();
    }

    @And("^User clicks on Deactivate my User ID button.$")
    public void userClicksOnDeactivateMyUserIDButton() {
        profilePage.clickOnDeactivateMyUserIdButton();
    }

    @And("^Create User instance.$")
    public void createUserInstance() {
        userManager.createUserInstance(profilePage.getUserName(), profilePage.getUserLastName(), profilePage.getUserId(),
                profilePage.getUserRole(), profilePage.getCompanyName(), profilePage.getEmail(), profilePage.getPhoneNumber(),
                profilePage.getLanguage(), profilePage.getRelationship());
    }
}
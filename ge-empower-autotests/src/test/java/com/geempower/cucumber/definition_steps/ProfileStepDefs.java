package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.QmsService;
import com.geempower.helpers.managers.UserManager;
import com.geempower.helpers.models.UserEntity;
import com.geempower.storefront.pages.ProfilePage;
import cucumber.api.PendingException;
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
    @Autowired
    private QmsService qmsService;

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
                profilePage.getLanguage(), profilePage.getRelationship(), profilePage.getRegion(),
                profilePage.getAltEmail());
    }

    @When("^User clicks on Permanently delete button.$")
    public void userClicksOnPermanentlyDeleteButton() {
        profilePage.clickOnPermanentlyDeleteButton();
    }

    @And("^Confirm delete action in the Permanently delete user ID pop-up.$")
    public void confirmDeleteActionInThePermanentlyDeleteUserIDPopUp() {
        profilePage.confirmDeleteActionInThePopUp();
    }

    @And("^Get QMS response for user (.*) and save it to the hashmap.$")
    public void getQMSResponseForUser(String sso) {
        threadVarsHashMap.put(TestKeyword.QMS_USER_INFO, qmsService.getQmsUserInfo(sso));
    }

    @Then("^Check that QMS user info are equals to the user info on Profile page for user (.*).$")
    @SuppressWarnings("unchecked")
    public void checkThatQmsUserInfoAreEqualsToTheUserInfoOnProfilePage(String sso) {
        UserEntity user = userManager.getUserBySso(sso);
        HashMap<String, String> qmsUserResponse = (HashMap) threadVarsHashMap.get(TestKeyword.QMS_USER_INFO);
        assertEquals(user.getEmail(), qmsUserResponse.get("altEmail"));
        assertEquals(user.getAlternateEmail(), qmsUserResponse.get("email"));
        assertEquals(user.getCompanyName(), qmsUserResponse.get("company"));
        assertEquals(user.getFirstName(), qmsUserResponse.get("firstName"));
        assertEquals(user.getLastName(), qmsUserResponse.get("lastName"));
        assertTrue(user.isInternalUser(), qmsUserResponse.get("isInternalUser"));
        assertEquals("1", qmsUserResponse.get("isInternal"));
        assertEquals("en-US", qmsUserResponse.get("language"));
        assertEquals(user.getPhoneNumber(), qmsUserResponse.get("telephone"));
        assertEquals(user.getRegion().replaceAll(" ", "").toLowerCase(), qmsUserResponse.get("region").toLowerCase());
        assertTrue(user.getRelationship().toLowerCase().contains(qmsUserResponse.get("relationshipToGe")));
        assertEquals(user.getUserId(), qmsUserResponse.get("sso"));
        assertEquals("false", qmsUserResponse.get("qmsEnabled"));
        assertEquals("false", qmsUserResponse.get("qualityPrice"));
        assertEquals("false", qmsUserResponse.get("tinderBoxNode"));
    }

    @Then("^Alternate email (.*) and primary email (.*) adresses are displayed on User profile page.$")
    public void alternateEmailAndPrimaryEmailAdressesAreDisplayedOnUserProfilePage(String altEmail, String primaryEmail){
        assertEquals(primaryEmail, profilePage.getAltEmail());
        assertEquals(altEmail, profilePage.getEmail());

    }

    @And("^User clicks on edit alt email pencil button.$")
    public void userClicksOnEditAltEmailPencilButton() {
        profilePage.userClicksOnEditAltEmailPencilButton();
    }

    @Then("^Is (.*) pop-up with text (.*) displayed.$")
    public void isEmailAddressUpdatePopUpWithTextAbbTextDisplayed(String title, String text) {
        assertTrue(profilePage.isEmailAddressUpdatePopUpDisplayed());
        assertEquals(title, profilePage.getEmailAddressUpdatePopUpTitle());
        assertEquals(text, profilePage.getEmailAddressUpdatePopUpText());
    }

    @When("^User updates alternate email to (.*).$")
    public void userUpdatesAlternateEmailToNewAbbEmail(String newEmail) {
        profilePage.setEmailToTheAltEmailField(newEmail);
    }

    @Then("^Is email updated to new email (.*) on User profile page.$")
    public void isEmailUpdatedToNewEmailOnUserProfilePage(String newEmail) {
        assertEquals(newEmail, profilePage.getEmail());
    }
}
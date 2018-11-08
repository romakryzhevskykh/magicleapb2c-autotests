package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.UserManager;
import com.geempower.storefront.pages.RegistrationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegistrationStepDefs extends AbstractStepDefs {

    @Autowired
    private RegistrationPage registrationPage;
    @Autowired
    private UserManager userManager;

    @Then("^Registration page is opened.$")
    public void isRegistrationPageOpened() {
        assertTrue(registrationPage.isOpened());
    }

    @Then("^First name is equal to (.*).$")
    public void firstNameIsEqualToUserName(String userName) {
        registrationPage.getUserNameValue();
    }

    @Then("^Last name is equal to (.*).$")
    public void lastNameIsEqualToUserLastName(String userLastName) {
        registrationPage.getUserLastNameValue();
    }

    @Then("^User ID is equal to (.*).$")
    public void userIDIsEqualToUserId() {
        registrationPage.getUserIdValue();
    }

    @Then("^User email is equal to (.*).$")
    public void userEmailIsEqualToUserEmail() {
        registrationPage.getUserEmailValue();
    }

    @When("^User fills Company Name (.*).$")
    public void userFillsCompanyNameCompanyName(String companyName) {
        registrationPage.setCompanyName(companyName);
    }

    @When("^User fills Phone No (.*).$")
    public void userFillsPhoneNoPhoneNo(String phoneNo) {
        registrationPage.setPhoneNo(phoneNo);
    }

    @When("^User selects random Region from regions list.$")
    public void userSelectsRandomRegionFromRegionsList() {
        registrationPage.selectRandomRegionFromRegionsList();
    }

    @When("^User selects random Country from countries list.$")
    public void userSelectsRandomCountryFromCountriesList() {
        registrationPage.selectRandomCountryFromCountriesList();
    }

    @When("^User selects (.*) Relationship to Industrial Solutions.$")
    public void userSelectsRelationshipRelationshipToIndustrialSolutions(String relationship) {
        registrationPage.selectAppropriateRelationship(relationship);
    }

    @When("^User selects random Role.$")
    public void userSelectsRandomRole() {
        threadVarsHashMap.put(TestKeyword.CHOSEN_USER_ROLE_ON_REGISTRATION_PAGE, registrationPage.selectRandomUserRoleFromRolesList());
    }

    @And("^Click on register button.$")
    public void clickOnRegisterButton() {
        registrationPage.clickOnRegisterButton();
    }

    @Then("^Registration successful pop-up is appeared with appropriate header (.*).$")
    public void registrationSuccessfulPopUpIsAppeared(String popUpHeader) {
        assertEquals(popUpHeader, registrationPage.getSuccessRegistrationPopUpHeader());
    }

    @And("^Create User instance on registration page with values (.*), (.*), (.*).$")
    public void createUserInstanceOnRegistrationPage(String companyName, String userEmail, String phoneNo) {
        userManager.createUserInstance(registrationPage.getUserNameValue(), registrationPage.getUserLastNameValue(), registrationPage.getUserIdValue(),
                threadVarsHashMap.getString(TestKeyword.CHOSEN_USER_ROLE_ON_REGISTRATION_PAGE), companyName, userEmail, phoneNo,
                registrationPage.getDefaultLanguage(), registrationPage.getRelationshipValue());
    }
}

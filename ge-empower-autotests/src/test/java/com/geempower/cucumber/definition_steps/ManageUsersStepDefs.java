package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ManageUsersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @And("^Clicks on the Search button.$")
    public void clickOnTheSearchButton() {
        manageUsersPage.clickOnSearchUserButton();
    }

    @Then("^Appropriate user with appropriate (.*) email is displayed in the users list.$")
    public void appropriateUserWithAppropriateEmailEmailIsDisplayedInTheUsersList(String email) {
        assertEquals(manageUsersPage.isUserFoundByEmail(), email);
    }

    @And("^Sets (.*) account to the account field.$")
    public void setsAccountAccountToTheAccountField(String account) {
        manageUsersPage.setAccountToTheAccountSearchField(account);
    }

    @Then("^Users list is not empty.$")
    public void usersListIsNotEmpty() {
        assertTrue(manageUsersPage.isUsersListNotEmpty());
    }

    @When("^Clicks on the user name in the table.$")
    public void clickOnTheUserNameInTheTable(){
        manageUsersPage.clickOnTheUserNameInTheTable();
    }

    @Then("^User details block for chosen user with (.*) userId is opened.$")
    public void userDetailsBlockIsOpened(String userId) {
        assertTrue(manageUsersPage.isUserDetailsBlockOpened());
        assertEquals(manageUsersPage.getUserIdFromUserDetailsBlock(), userId);
    }

    @When("^Admin opens Actions list.$")
    public void adminOpensActionsList() {
        manageUsersPage.openActionsList();
    }

    @Then("^Chosen user has (.*) user status.$")
    public void chosenUserHasAppropriateUserStatus(String status) {
        assertEquals(manageUsersPage.getUserStatus(), status);
    }

    @And("^Chooses (.*) option from the actions list.$")
    public void choosesDeactivateOptionFromTheActionsList(String actionName) {
        manageUsersPage.clickOnAppropriateOptionOnActionsList(actionName);
    }

    @Then("^Chosen user's status has been changed to (.*) and sub-status details are correct.$")
    public void chosenUserStatusHasBeenChangedToInactive(String status) {
        String [] subStatus = manageUsersPage.getFullUserSubStatus().split(" ");
        String actualUserStatus = subStatus[0];
        String deactivatedBy = (subStatus[3] + " ").concat(subStatus[4].replace(",",""));
        String deactivationDate = subStatus[5].replace(")", "");
        String actualDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(actualUserStatus, status);
        assertEquals(deactivationDate, actualDate);
        assertEquals(deactivatedBy, threadVarsHashMap.getString(TestKeyword.USER_FIRST_AND_LAST_NAME));
    }
}
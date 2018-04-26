package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.page_blocks.IwantToBlock;
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
    @Autowired
    private IwantToBlock iWantToBlock;

    @Then("^(.*) title is displayed on Manage Users page.$")
    public void checkManageUsersTitle(String manageUsersTitle) {
        assertEquals(manageUsersTitle, manageUsersPage.getManageUsersTitle());
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
        assertEquals(email, manageUsersPage.isUserFoundByEmail());
    }

    @When("^Click on the first user name in the table.$")
    public void clickOnTheFirstUserNameInTheTable() {
        manageUsersPage.clickOnTheFirstUserNameInTheTable();
    }

    @When("^Click on Add account button in User Detail block.$")
    public void clickOnAddAccountButtonInUserDetailBlock() {
        manageUsersPage.clickOnAddAccountButtonInUserDetailBlock();
    }

    @Then("^(.*) pop-up is displayed on Manage Users page.$")
    public void addAccountPopUpIsDisplayedOnManageUsersPage(String popUpTitle) {
        assertTrue(manageUsersPage.isAddAccountPopUpDisplayed());
        assertEquals(popUpTitle, manageUsersPage.getAddAccPopUpTitle());
    }

    @When("^Set (.*) SO code to the Sales Office Code field in the Add Account pop-up.$")
    public void setSoCodeToTheSalesOfficeCodeField(String code) {
        manageUsersPage.setSoCodeToTheSalesOfficeCodeField(code);
    }

    @And("^Click on Modify button in the Add Account pop-up.$")
    public void clickOnModifyButtonInTheAddAccountPopUp() {
        manageUsersPage.clickOnModifyButtonInTheAddAccountPopUp();
    }

    @And("^Expand Modify an Account tab in I Want To Block.$")
    public void expandModifyAnAccountTabInIWantToBlock() {
        iWantToBlock.expandModifyAnAccountTabInIWantToBlock();
    }

    @And("^Select (.*) in the Region field in the Add Account pop-up.$")
    public void selectRegionInTheAddAccountPopUp(String region) {
        manageUsersPage.selectRegionInTheAddAccountPopUp(region);
    }

    @And("^Set (.*) SO code to the Second Sales Office Code field in the Add Account pop-up.$")
    public void setSoCodeToTheSecondSalesOfficeCodeField(String code) {
        manageUsersPage.setSoCodeToTheSecondSalesOfficeCodeField(code);
    }

    @And("^Click on the Search button in the Add Account pop-up.$")
    public void clickOnTheSearchButtonInTheAddAccountPopUp() {
        manageUsersPage.clickOnTheSearchButtonInTheAddAccountPopUp();
    }

    @Then("^Add New Accounts table is displayed in the Add Account pop-up.$")
    public void addNewAccountsTableIsDisplayed() {
        assertTrue(manageUsersPage.addNewAccountsTableIsDisplayed());
        threadVarsHashMap.put(TestKeyword.MANAGE_USERS_ACCOUNT_NAME, manageUsersPage.getAccountNameFromAddAccPopUp());
    }

    @Then("^Account from SO code is displayed in the the All Accounts tab.$")
    public void accountFromSOCodeIsDisplayedInTheTheAllAccountsTab() {
        String accountName = threadVarsHashMap.getString(TestKeyword.MANAGE_USERS_ACCOUNT_NAME);
        assertEquals(accountName, iWantToBlock.getAccountName());
    }

    @When("^Click on Sales Office Codes tab In Modify an Account Tab.$")
    public void clickOnSalesOfficeCodesTab() {
        iWantToBlock.clickOnSalesOfficeCodesTab();
    }

    @Then("^(.*) Sales Office Code is displayed in the SO Codes table.$")
    public void AppropriateSalesOfficeCodeIsDisplayedInTheTable(String code) {
        assertEquals(code, iWantToBlock.getSoCode());
    }

    @And("^Select All Sales Office Codes checkbox in SO Codes tab.$")
    public void selectAllSalesOfficeCodesCheckboxInSOCodesTab() {
        iWantToBlock.selectAllSalesOfficeCodesCheckboxInSOCodesTab();
    }

    @And("^Click on SO Codes Remove button in SO Codes tab.$")
    public void clickOnRemoveSoCodesButtoninSOCodesTab() {
        iWantToBlock.clickOnRemoveSoCodesButtonSOCodesTab();
    }

    @Then("^(.*) pop-up is displayed on I Want To Block.$")
    public void removeAccountPopUpTitleIsEqualToRemoveAccount(String popUpTitle) {
        assertTrue(iWantToBlock.isRemoveAccountPopUpIsDisplayed());
        assertEquals(popUpTitle, iWantToBlock.getRemoveAccPopUpTitle());
    }

    @And("^Click on Remove button in the Remove Account pop-up.$")
    public void clickOnRemoveButtonInTheRemoveAccountPopUp() {
        iWantToBlock.clickOnRemoveButtonInTheRemoveAccountPopUp();
    }

    @Then("^(.*) title is displayed in Sales Office Code table.$")
    public void getNoDataTitle(String title) {
        assertEquals(title, iWantToBlock.getNoDataTitle());
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
        assertEquals(userId, manageUsersPage.getUserIdFromUserDetailsBlock());
    }

    @When("^Admin opens Actions list.$")
    public void adminOpensActionsList() {
        manageUsersPage.openActionsList();
    }

    @Then("^Chosen user has (.*) user status.$")
    public void chosenUserHasAppropriateUserStatus(String status) {
        assertEquals(status, manageUsersPage.getUserStatus());
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
        assertEquals(status, actualUserStatus);
        assertEquals(deactivationDate, actualDate);
        assertEquals(threadVarsHashMap.getString(TestKeyword.USER_FIRST_AND_LAST_NAME), deactivatedBy);
    }
}
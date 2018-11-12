package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.LessonLyService;
import com.geempower.helpers.managers.RegionsManager;
import com.geempower.helpers.managers.UserManager;
import com.geempower.helpers.models.Region;
import com.geempower.helpers.models.UserEntity;
import com.geempower.storefront.page_blocks.IwantToBlock;
import com.geempower.storefront.pages.ManageUsersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.geempower.helpers.models.RegionType.getRegionTypes;
import static org.testng.Assert.*;

public class ManageUsersStepDefs extends AbstractStepDefs {
    @Autowired
    private ManageUsersPage manageUsersPage;
    @Autowired
    private IwantToBlock iWantToBlock;
    @Autowired
    private RegionsManager regionsManager;
    @Autowired
    private LessonLyService lessonLyService;
    @Autowired
    private UserManager userManager;

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

    @When("^Click on Add account button in User Detail block.$")
    public void clickOnAddAccountButtonInUserDetailBlock() {
        manageUsersPage.clickOnAddAccountButtonInUserDetailBlock();
    }

    @Then("^(.*) pop-up is displayed on Manage Users page.$")
    public void addAccountPopUpIsDisplayedOnManageUsersPage(String popUpTitle) {
        assertTrue(manageUsersPage.isAddAccountPopUpDisplayed());
        assertEquals(popUpTitle, manageUsersPage.getAddAccPopUpTitle());
    }

    @When("^Set (.*) SO code to the First Sales Office Code field in the Add Account pop-up.$")
    public void setSoCodeToFirstTheSalesOfficeCodeField(String code) {
        manageUsersPage.setSoCodeToTheFirstSalesOfficeCodeField(code);
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
        Region chosenRegion = regionsManager.getRegionByName(region);
        manageUsersPage.selectRegionInTheAddAccountPopUp(chosenRegion);
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
        threadVarsHashMap.put(TestKeyword.MANAGE_USERS_ACCOUNT_NO, manageUsersPage.getAccountNoFromAddAccPopUp());
    }

    @Then("^Is account (.*) displayed in the All Accounts tab.$")
    public void isAccountDisplayedInAllAccTab(String accountNo) {
        assertTrue(iWantToBlock.isAccountDisplayedInAllAccTab(accountNo));
    }

    @Then("^Is (.*) account not displayed in the All Accounts tab.$")
    public void isAccountNotDisplayedInAllAccTab(String accountNo) {
        assertFalse(iWantToBlock.isAccountDisplayedInAllAccTab(accountNo));
    }

    @Then("^Is account from add account pop-up displayed in the all accounts tab.$")
    public void isAccountFromAddAccountPopUpDisplayedInTheAllAccountsTab() {
        String accountNo = threadVarsHashMap.getString(TestKeyword.MANAGE_USERS_ACCOUNT_NO);
        assertTrue(iWantToBlock.getAllAccountNo()
                .anyMatch(account -> account.getText().equals(accountNo)));
    }

    @When("^Click on Sales Office Codes tab In Modify an Account Tab.$")
    public void clickOnSalesOfficeCodesTab() {
        iWantToBlock.clickOnSalesOfficeCodesTab();
    }

    @When("^Click on Pending Sales Office Codes tab In Approve Pending Accounts Tab.$")
    public void clickOnPendingSalesOfficeCodesTab() {
        iWantToBlock.clickOnPendingSalesOfficeCodesTab();
    }

    @And("^Select All Sales Office Codes checkbox in SO Codes tab.$")
    public void selectAllSalesOfficeCodesCheckboxInSOCodesTab() {
        iWantToBlock.selectAllSalesOfficeCodesCheckboxInSOCodesTab();
    }

    @And("^Select All Sales Engineer Codes checkbox in SE Codes tab.$")
    public void selectAllSalesEngineerCodesCheckboxInSECodesTab() {
        iWantToBlock.selectAllSalesEngineerCodesCheckboxInSECodesTab();
    }

    @And("^Click on SO Codes Remove button in SO Codes tab.$")
    public void clickOnRemoveSoCodesButtoninSOCodesTab() {
        iWantToBlock.clickOnRemoveSoCodesButtonSOCodesTab();
    }

    @And("^Click on SE Codes Remove button in SE Codes tab.$")
    public void clickOnRemoveSeCodesButtonInSeCodesTab() {
        iWantToBlock.clickOnRemoveSeCodesButtonInSeCodesTab();
    }

    @Then("^(.*) pop-up is displayed on I Want To Block in SO codes tab.$")
    public void removeAccountPopUpTitleIsEqualToRemoveAccount(String popUpTitle) {
        assertTrue(iWantToBlock.isRemoveAccountPopUpIsDisplayedInSoCodesTab());
        assertEquals(popUpTitle, iWantToBlock.getRemoveSoCodesAccPopUpTitle());
    }

    @Then("^(.*) pop-up is displayed on I Want To Block in SE codes tab.$")
    public void removeAccountPopUpTitleIsEqualToRemoveAccountInSeCodesTab(String popUpTitle) {
        assertTrue(iWantToBlock.isRemoveAccountPopUpIsDisplayedInSeCodesTab());
        assertEquals(popUpTitle, iWantToBlock.getRemoveSeCodesAccPopUpTitle());
    }

    @And("^Click on Remove button in the Remove Account pop-up on I Want To Block in SO codes tab.$")
    public void clickOnRemoveButtonInTheRemoveAccountPopUpInSOCodesTab() {
        iWantToBlock.clickOnRemoveButtonInTheRemoveAccountPopUpInSOCodesTab();
    }

    @And("^Click on Remove button in the Remove Account pop-up on I Want To Block in SE codes tab.$")
    public void clickOnRemoveButtonInTheRemoveAccountPopUpInSECodesTab() {
        iWantToBlock.clickOnRemoveButtonInTheRemoveAccountPopUpInSECodesTab();
    }

    @And("^Click on Remove button in the Remove Account pop-up on I Want To Block in All Accounts tab.$")
    public void clickOnRemoveButtonInTheRemoveAccountPopUpInAllAccountsTab() {
        iWantToBlock.clickOnRemoveButtonInTheRemoveAccountPopUpInAllAccountsTab();
    }

    @And("^Click on Accept button in the Accept Account pop-up on I Want To Block in Pending SO Codes tab.$")
    public void clickOnAcceptButtonInTheAcceptAccountPopUpInPendingSOCodesTab() {
        iWantToBlock.clickOnAcceptButtonInTheAcceptAccountPopUpInPendingSOCodesTab();
    }

    @And("^Click on Reject button in the Reject Account pop-up on I Want To Block in Pending SO Codes tab.$")
    public void clickOnRejectButtonInTheRejectAccountPopUpInPendingSOCodesTab() {
        iWantToBlock.clickOnRejectButtonInTheRejectAccountPopUpInPendingSOCodesTab();
    }

    @Then("^(.*) title is displayed in Sales Office Code table.$")
    public void getNoDataTitleInSoCodesTable(String title) {
        assertEquals(title, iWantToBlock.getNoDataTitleInSoCodesTable());
    }

    @Then("^(.*) title is displayed in Sales Engineer Code table.$")
    public void getNoDataTitleInSeCodesTable(String title) {
        assertEquals(title, iWantToBlock.getNoDataTitleInSeCodesTable());
    }

    @Then("^(.*) title is displayed in Pending Sales Office Code table.$")
    public void getNoDataTitleInPendingSoCodesTable(String title) {
        assertEquals(title, iWantToBlock.getNoDataTitleInPendingSoCodesTable());
    }

    @Then("^(.*) title is displayed in All Accounts table.$")
    public void getNoDataTitleInAllAccountsTable(String title) {
        assertEquals(title, iWantToBlock.getNoDataTitleInAllAccountsTable());
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
    public void clickOnTheUserNameInTheTable() {
        manageUsersPage.clickOnTheUserNameInTheTable();
    }

    @SuppressWarnings("unchecked")
    @When("^Clicks on the user name in the table with pending accounts.$")
    public void clickOnTheUserNameInTheTableWithPendingRequests() {
        ArrayList<String> requestedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        manageUsersPage.clickOnTheUserNameInTheTableWithPendingRequests(requestedAccounts.size());
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
        String[] subStatus = manageUsersPage.getFullUserSubStatus().split(" ");
        String actualUserStatus = subStatus[0];
        String deactivatedBy = (subStatus[3] + " ").concat(subStatus[4].replace(",", ""));
        String deactivationDate = subStatus[5].replace(")", "");
        String actualDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(status, actualUserStatus);
        assertEquals(deactivationDate, actualDate);
        assertEquals(threadVarsHashMap.getString(TestKeyword.USER_FIRST_AND_LAST_NAME), deactivatedBy);
    }

    @And("^Set (.*) SE code to the Second Sales Engineer Code field in the Add Account pop-up.$")
    public void setSECodeToTheSecondSalesEngineerCodeFieldInTheAddAccountPopUp(String code) {
        manageUsersPage.setSECodeToTheSecondSalesEngineerCodeFieldInTheAddAccountPopUp(code);
    }

    @When("^Set (.*) SE code to the First Sales Engineer Code field in the Add Account pop-up.$")
    public void setSeCodeSECodeToTheFirstSalesEngineerCodeFieldInTheAddAccountPopUp(String code) {
        manageUsersPage.setSeCodeSECodeToTheFirstSalesEngineerCodeFieldInTheAddAccountPopUp(code);
    }

    @When("^Click on Sales Engineer Codes tab In Modify an Account Tab.$")
    public void clickOnSalesEngineerCodesTabInModifyAnAccountTab() {
        iWantToBlock.clickOnSalesEngineerCodesTab();
    }

    @Then("^(.*) Sales Engineer Code is displayed in the Approved SE Codes table.$")
    public void appropriateSeCodeCodeIsDisplayedInTheSECodesTable(String selesEngCode) {
        assertTrue(iWantToBlock.getAllSeCodesFromTable()
                .anyMatch(code -> code.getText().trim().equals(selesEngCode)));
    }

    @Then("^Is (.*) Sales Office Code displayed in the Approved SO Codes table.$")
    public void appropriateSalesOfficeCodeIsDisplayedInTheTable(String salesOfficeCode) {
        assertTrue(iWantToBlock.getAllSoCodesFromApprovedSoCodesTable()
                .anyMatch(code -> code.getText().trim().equals(salesOfficeCode)));
    }

    @Then("^Is (.*) Sales Office Code not displayed in the Approved SO Codes table.$")
    public void isAppropriateSalesOfficeCodeNotDisplayedInTheTable(String salesOfficeCode) {
        assertFalse(iWantToBlock.getAllSoCodesFromApprovedSoCodesTable()
                .anyMatch(code -> code.getText().contains(salesOfficeCode)));
    }

    @SuppressWarnings("unchecked")
    @Then("^(.*) section is displayed with appropriate count of accounts.$")
    public void approvePendingAccountsSectionIsDisplayedWithAppropriateCountOfAccounts(String sectionTitle) {
        ArrayList<String> requestedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        assertEquals(sectionTitle + " (" + requestedAccounts.size() + ")", iWantToBlock.getApprovePendingAccountsSectionTitle());
        assertTrue(requestedAccounts.size() == iWantToBlock.getTotalAccountRequests());
    }

    @When("^User expand the Approve Pending Accounts section.$")
    public void userExpandTheApprovePendingAccountsSection() {
        iWantToBlock.expandApprovePendingAccountsSection();
    }

    @SuppressWarnings("unchecked")
    @Then("^Appropriate count of pending requests are displayed in Pending accounts table.$")
    public void appropriateCountOfPendingRequestsAreDisplayedInPendingAccountsTable() {
        ArrayList<String> requestedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        assertTrue(requestedAccounts.size() == iWantToBlock.getActualPendingAccountsTableSize());
    }

    @When("^Admin clicks on All accounts checkbox.$")
    public void adminClicksOnAllAccountsCheckbox() {
        iWantToBlock.clickOnSelectAllPendingAccountsCheckBox();
    }

    @When("^Admin clicks on All Sales Office Codes checkbox in Pending SO Codes tab.$")
    public void adminClicksOnAllSalesOfficeCodesCheckboxInPendingSOCodesTab() {
        iWantToBlock.adminClicksOnAllSalesOfficeCodesCheckboxInPendingSOCodesTab();
    }

    @And("^Click on Accept accounts button.$")
    public void clickOnAcceptButton() {
        iWantToBlock.clickOnAcceptAccountButton();
    }

    @And("^Click on Reject accounts button.$")
    public void clickOnRejectButton() {
        iWantToBlock.clickOnRejectAccountButton();
    }

    @And("^Click on Accept SO codes button.$")
    public void clickOnAcceptSOCodesButton() {
        iWantToBlock.clickOnAcceptSOCodesButton();
    }

    @And("^Click on Reject SO codes button.$")
    public void clickOnRejectSOCodesButton() {
        iWantToBlock.clickOnRejectSOCodesButton();
    }

    @And("^Accept the action in Accept Account pop-up.$")
    public void acceptTheActionInAcceptAccountPopUp() {
        iWantToBlock.acceptTheActionOnAcceptAccountPopUp();
    }

    @And("^Accept the action in Reject Account pop-up.$")
    public void acceptTheActionInRejectAccountPopUp() {
        iWantToBlock.acceptTheActionOnRejectAccountPopUp();
    }

    @Then("^Pending accounts table became empty.$")
    public void pendingAccountsTableBecomeEmpty() {
        assertEquals("No data available in table", iWantToBlock.getNoDataTitleInPendingAccountsTable());
    }

    @SuppressWarnings("unchecked")
    @Then("^Appropriate accounts are displayed in All approved Accounts table.$")
    public void appropriateApprovedAccountsAreDisplayedInAllAccountsTable() {
        ArrayList<String> requestedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        assertTrue(iWantToBlock.getActiveAccountForUserInModifyAnAccountSection().containsAll(requestedAccounts));
    }

    @And("^Set (.*) to the Account field in the Add Account pop-up.$")
    public void setAccountToTheAccountFieldInTheAddAccountPopUp(String account) {
        manageUsersPage.setAccountToTheAccountFieldInTheAddAccountPopUp(account);
    }

    @When("^Click on Select All checkbox in the Add Account pop-up.$")
    public void clickOnSelectAllCheckboxInTheAddAccountPopUp() {
        manageUsersPage.clickOnSelectAllCheckboxInTheAddAccountPopUp();
    }

    @And("^Click on Add button in the Add Account pop-up.$")
    public void clickOnAddButtonInTheAddAccountPopUp() {
        manageUsersPage.clickOnAddButtonInTheAddAccountPopUp();
    }

    @When("^Click on (.*) checkbox in I Want To Block in All Accounts tab.$")
    public void clickOnAccountCheckboxInIWantToBlockInAllAccountsTab(String account) {
        iWantToBlock.clickOnAccountCheckboxInIWantToBlockInAllAccountsTab(account);
    }

    @And("^Click on Remove button in All Accounts tab.$")
    public void clickOnRemoveButtonInAllAccountsTab() {
        iWantToBlock.clickOnRemoveButtonInAllAccountsTab();
    }

    @Then("^(.*) pop-up is displayed on I Want To Block in All Accounts tab.$")
    public void removeAccountPopUpTitleIsEqualToRemoveAccountInAllAccountsTab(String popUpTitle) {
        assertTrue(iWantToBlock.isRemoveAccountPopUpIsDisplayedInAllAccountsTab());
        assertEquals(popUpTitle, iWantToBlock.getRemoveAllAccountsPopUpTitle());
    }

    @Then("^(.*) pop-up is displayed on I Want To Block in Pending SO Codes tab.$")
    public void acceptPopUpIsDisplayedOnIWantToBlockInPendingSOCodestab(String popUpTitle) {
        assertEquals(popUpTitle, iWantToBlock.getAcceptAllAccountsPopUpTitle());
    }

    @Then("^(.*) SO code is displayed in the Pending SO codes table.$")
    public void soCodeIsDisplayedInThePendingSOCodesTable(String salesCode) {
        assertTrue(iWantToBlock.getAllSOCodesFromPendingSOCodesTable()
                .anyMatch(code -> code.getText().trim().equals(salesCode)));
    }

    @SuppressWarnings("unchecked")
    @Then("^Appropriate accounts are not displayed in All approved Accounts table.$")
    public void appropriateAccountsAreNotDisplayedInAllApprovedAccountsTable() {
        ArrayList<String> requestedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        assertFalse(iWantToBlock.getActiveAccountForUserInModifyAnAccountSection().containsAll(requestedAccounts));
    }

    @And("^Expand Change an empower Privilege/Role in I want to block.$")
    public void expandChangeAnEmpowerPrivilegeRoleInIWantToBlock() {
        iWantToBlock.expandChangeEmpPrivilegeBlock();
    }

    @Then("^User has (.*) role in each region.$")
    public void userHasRoleInEachRegion(String role) {
        HashMap<String, String> userRolesInEachRegion = iWantToBlock.getAllRolesForEachRegion();
        userRolesInEachRegion.values().forEach(roleForRegion ->
                assertTrue(roleForRegion.equals(role)));
    }

    @When("^Admin Set (.*) role for each region to the user.$")
    public void adminSetNewRoleForEachRegionToTheUser(String newRole) {
        new ArrayList<>(getRegionTypes()).forEach(region -> iWantToBlock.setNewRoleToUserForEachRegion(region.getRegionName(), newRole));
    }

    @And("^Clicks on Assign button.$")
    public void clicksOnAssignButton() {
        iWantToBlock.clickOnAssignRolesButton();
    }

    @And("^All new set roles are stored to threadVarsHashMap.$")
    public void allNewSetRolesAreStoredToThreadVarsHashMap() {
        HashMap<String, String> userRolesInEachRegion = iWantToBlock.getAllRolesForEachRegion();
        threadVarsHashMap.put(TestKeyword.USER_ROLES_IN_EACH_REGION, userRolesInEachRegion);
    }

    @Then("^Prevent appearing (.*) in the All Accounts tab.$")
    public void preventAppearingAccountInTheAllAccountsTab(String account) {
        iWantToBlock.preventAppearingAccountInTheAllAccountsTab(account);
    }

    @And("^Prevent appearing of SO code in SO Codes tab.$")
    public void preventAppearingOfSoCodeInSOCodesTab() {
        iWantToBlock.preventAppearingOfSoCodeInSOCodesTab();
    }

    @And("^Prevent appearing of SE code in SE Codes tab.$")
    public void preventAppearingOfSeCodeInSECodesTab() {
        iWantToBlock.preventAppearingOfSeCodeInSECodesTab();
    }

    @Then("^Account from Add Account pop-up is displayed in the All Accounts tab.$")
    public void previouslyAddedAccountIsDisplayedInTheAllAccountsTab() {
        String accountNo = threadVarsHashMap.getString(TestKeyword.MANAGE_USERS_ACCOUNT_NO);
        assertTrue(iWantToBlock.getAllAccountNo()
                .anyMatch(account -> account.getText().equals(accountNo)));
    }

    @And("^Get user status in lessonly service for user by email (.*).$")
    public void getUserStatusInLessonlyResponseForUserByEmailEmail(String email) {
        String lessonLyUserId = lessonLyService.getUserIdByEmailFromLessonLy(email);
        String userStatus = lessonLyService.getUserStatusInLessonlyService(lessonLyUserId);
        threadVarsHashMap.replace(TestKeyword.USER_STATUS_VALUE_IN_LESSONLY, userStatus);
    }

    @Then("^User status in lessonly service corresponds to user status in Manage Users page.$")
    public void userStatusInLessonlyServiceCorrespondsToUserStatusInManageUsersPage() {
        if (manageUsersPage.getFullUserSubStatus().contains("Active")) {
            assertEquals(threadVarsHashMap.get(TestKeyword.USER_STATUS_VALUE_IN_LESSONLY), ("ACTIVE"));
        }
        if (manageUsersPage.getFullUserSubStatus().contains("Inactive")) {
            assertEquals(threadVarsHashMap.get(TestKeyword.USER_STATUS_VALUE_IN_LESSONLY), ("INACTIVE"));
        }
    }

    @Then("^Is (.*) user status displayed in lessonly service.$")
    public void isAppropriateUserStatusDisplayedInLessonlyService(String userStatus) {
        assertEquals(threadVarsHashMap.get(TestKeyword.USER_STATUS_VALUE_IN_LESSONLY), (userStatus));
    }

    @Then("^User sub-status contains (.*).$")
    public void userSubStatusIsEqualToInactiveDeactivatedByUser(String subStatus) {
        assertTrue(manageUsersPage.getFullUserSubStatus().contains(subStatus));
    }

    @Then("^(.*) toggle section is displayed.$")
    public void tBAccessToggleSectionIsDisplayed(String toggleText) {
        assertEquals(toggleText, iWantToBlock.isTnbAccessToggleSectionDisplayed());
    }

    @When("^Admin turn on T&B Access toggle.$")
    public void adminTurnOnTBAccessToggle() {
        iWantToBlock.turnTnBToggleOn();
    }

    @When("^Admin turn off T&B Access toggle.$")
    public void adminTurnOffTBAccessToggle() {
        iWantToBlock.turnTnBToggleOff();
    }

    @Then("^Is Appropriate data from user profile displayed in user details block for user (.*).$")
    public void isAppropriateFullNameDisplayedDetailBlockHeader(String email) {
        UserEntity user = userManager.getUserByEmail(email);
        String userFullName = user.getFirstName() + " " + user.getLastName();
        List<String> labelValues = Stream.of(user.getUserRole(), user.getEmail(), user.getUserId(),
                user.getCompanyName(), user.getPhoneNumber(), user.getLanguage()).collect(Collectors.toList());
        assertEquals(userFullName, manageUsersPage.getUserFullNameInDetailsBlock());
        assertTrue(manageUsersPage.getAllLabelValuesInUserDetailsBlock().containsAll(labelValues));
    }

    @When("^Admin expands user details block.$")
    public void adminExpandsUserDetailsBlock() {
        manageUsersPage.adminExpandsUserDetailsBlock();
    }

    @Then("^Is opened user details (.*) displayed.$")
    public void isOpenedUserDetailsBlockDisplayed(String block) {
        assertTrue(manageUsersPage.getBottomRowInUserDetailsBlock().getAttribute("style").contains(block));
    }

    @Then("^Is open user details (.*) not displayed.$")
    public void isOpenUserDetailsBlockNotDisplayed(String block) {
        assertFalse(manageUsersPage.getBottomRowInUserDetailsBlock().getAttribute("style").contains(block));
    }

    @Then("^Is Appropriate year (\\d+) displayed under (.*) label.$")
    public void isAppropriateYearDisplayedUnderRevalidationDateLabel(int year, String label) {
        assertTrue(manageUsersPage.getLabelValueInUserDetailsBlock(label).contains(String.valueOf(year)));
    }

    @When("^Admin closes user details block.$")
    public void adminClosesUserDetailsBlock() {
        manageUsersPage.adminClosesUserDetailsBlock();
    }

    @Then("^Pending requests tab is active.$")
    public void pendingRequestsTabIsActive() {
        assertTrue(manageUsersPage.isPendingRequestTabActive());
    }

    @Then("^Admin is able to see user (.*) on the Pending requests tab with (.*) label.$")
    public void adminIsAbleToSeeUserUserIdOnThePendingRequestsTabWithNoAccountLabel(String userId, String noAccLabel) {
        assertEquals(noAccLabel, manageUsersPage.getNoAccountsLabelForUser(userId, manageUsersPage.getPagesCountOfPendingRequests()));
    }

    @When("^Admin clicks on envelope icon near the user (.*).$")
    public void adminClicksOnEnvelopeIconNearTheUser(String userId) {
        manageUsersPage.clickOnEnvelopeForAppropriateUser(userId);
    }

    @Then("^Confirmation Email sent pop-up is appeared.$")
    public void confirmationEmailSentPopUpIsAppeared() {
        assertEquals("Email Sent", manageUsersPage.getConfirmationPopUpTitle());
    }

    @And("^Close Confirmation Email sent pop-up.$")
    public void closeConfirmationEmailSentPopUp() {
        manageUsersPage.closeConfirmationPopUp();
    }

    @Then("^There is no user in the users list table.$")
    public void thereIsNoUserInTheUsersListTable() {
        assertEquals("No data available in table", manageUsersPage.getFoundUsersList());
    }
}
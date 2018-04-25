package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.page_blocks.IwantToBlock;
import com.geempower.storefront.pages.ManageUsersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ManageUsersStepDefs extends AbstractStepDefs {
    @Autowired
    private ManageUsersPage manageUsersPage;
    @Autowired
    private IwantToBlock iWantToBlock;

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

    @And("^Click on the Search button.$")
    public void clickOnTheSearchButton() {
        manageUsersPage.clickOnSearchUserButton();
    }

    @Then("^Appropriate user with appropriate (.*) email is displayed in the users list.$")
    public void appropriateUserWithAppropriateEmailEmailIsDisplayedInTheUsersList(String email) {
        assertEquals(manageUsersPage.isUserFoundByEmail(), email);
    }

    @When("^Click on the user name in the table.$")
    public void clickOnTheUserNameInTheTable() {
        manageUsersPage.clickOnTheUserNameInTheTable();
    }

    @When("^Click on Add account button in User Detail block.$")
    public void clickOnAddAccountButtonInUserDetailBlock() {
        manageUsersPage.clickOnAddAccountButtonInUserDetailBlock();
    }

    @Then("^(.*) pop-up is displayed on Manage Users page.$")
    public void addAccountPopUpIsDisplayedOnManageUsersPage(String popUpTitle) {
        manageUsersPage.addAccountPopUpIsDisplayedOnManageUsersPage(popUpTitle);
    }

    @When("^Set (.*) SO code to the Sales Eng Code field in the Add Account pop-up.$")
    public void setSoCodeToTheSalesEngCodeField(String code) {
        manageUsersPage.setSoCodeToTheSalesEngCodeField(code);
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
    public void selectRegion(String region) {
        manageUsersPage.selectRegion(region);
    }

    @And("^Set (.*) SO code to the Second Sales Eng Code field in the Add Account pop-up.$")
    public void setSoCodeToTheSecondSalesEngCodeField(String code) {
        manageUsersPage.setSoCodeToTheSecondSalesEngCodeField(code);
        threadVarsHashMap.put(TestKeyword.MANAGE_USERS_SO_CODE, code);
    }

    @And("^Click on the Search button in the Add Account pop-up.$")
    public void clickOnTheSearchButtonInTheAddAccountPopUp() {
        manageUsersPage.clickOnTheSearchButtonInTheAddAccountPopUp();
    }

    @Then("^Add New Accounts table is displayed in the Add Account pop-up.$")
    public void addNewAccountsTableIsDisplayed() {
        manageUsersPage.addNewAccountsTableIsDisplayed();
        threadVarsHashMap.put(TestKeyword.MANAGE_USERS_ACCOUNT_NAME, manageUsersPage.getAccountNameFromAddAccPopUp());
    }

    @Then("^Account from SO code is displayed in the the All Accounts tab.$")
    public void accountFromSOCodeIsDisplayedInTheTheAllAccountsTab() {
        String accountName = (String) threadVarsHashMap.get(TestKeyword.MANAGE_USERS_ACCOUNT_NAME);
        assertEquals(accountName, iWantToBlock.getAccountName());
    }

    @When("^Click on Sales Office Codes tab In Modify an Account Tab.$")
    public void clickOnSalesOfficeCodesTab() {
        iWantToBlock.clickOnSalesOfficeCodesTab();
    }

    @Then("^Appropriate Sales Office Code is displayed in the SO Codes table.$")
    public void AppropriateSalesOfficeCodeIsDisplayedInTheTable() {
        String salesCode = (String) threadVarsHashMap.get(TestKeyword.MANAGE_USERS_SO_CODE);
        assertEquals(salesCode, iWantToBlock.getSoCode());
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
    public void removeAccountPopUpIsDisplayedOnManageUsersPage(String popUpTitle) {
        iWantToBlock.removeAccountPopUpIsDisplayedOnManageUsersPage(popUpTitle);
    }

    @And("^Click on Remove button in the Remove Account pop-up.$")
    public void clickOnRemoveButtonInTheRemoveAccountPopUp() {
        iWantToBlock.clickOnRemoveButtonInTheRemoveAccountPopUp();
    }

    @Then("^Empty Sales Office Code table is displayed in SO Codes tab.$")
    public void emptySalesOfficeCodeTableIsDisplayedInSOCodesTab() {
        iWantToBlock.emptySalesOfficeCodeTableIsDisplayedInSOCodesTab();
    }
}
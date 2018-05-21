package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.RegionsManager;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.pages.AccountManagementPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountManagementStepDefs extends AbstractStepDefs {
    @Autowired
    private RegionsManager regionsManager;
    @Autowired
    private AccountManagementPage accountManagementPage;

    @When("^Choose (.*) region.$")
    public void chooseRegion(String regionName) {
        Region chosenRegion = regionsManager.getRegionByName(regionName);
        accountManagementPage.selectAppropriateRegionFromRegionList(chosenRegion);
        threadVarsHashMap.put(TestKeyword.CHOSEN_REGION, chosenRegion);
    }

    @And("^Close Account management page.$")
    public void clickOnCancelButton() {
        accountManagementPage.clickOnCancelButton();
    }

    @And("^Search random account for chosen region.$")
    public void searchForChosenRegionAccount() {
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        String accountName = chosenRegion.getAccounts().stream().findAny().orElseGet(() -> {
            throw new NullPointerException("No Accounts in the selected region");
        });
        threadVarsHashMap.put(TestKeyword.CHOSEN_ACCOUNT, accountName);
        accountManagementPage.searchAccountByAccountName(accountName);
    }

    @And("^Click on chosen account.$")
    public void clickOnChosenAccount() {
        accountManagementPage.selectAccountFromTheList();
    }

    @And("^Click on account with (.*) sales division.$")
    public void clickOnAccountWithAppropriateSalesDivision(String salesDivision) {
        accountManagementPage.selectAccountWithDivisionFromTheList(salesDivision);
    }

    @When("^Request account popup is opened.$")
    public void clickOnRequestAccountButton() {
        accountManagementPage.openRequestAccountPopup();
    }

    @And("^Popup is filled by (.*) accounts.$")
    public void popupIsFilledByAccountsForNorth_AmericaLatin_AmericaEMEAAndASIARegions(List<String> regions) {
        List<Region> selectedRegions = regions.stream()
                .map(region1 -> regionsManager.getRegionByName(region1))
                .collect(Collectors.toList());
        for (int i = 0; i < selectedRegions.size(); i++) {
            accountManagementPage.selectRegionFromRegionsListInRequestAccountPopupByCounter(selectedRegions.get(i), i + 1);
            String account = selectedRegions.get(i).getAccounts().stream().findAny().orElse(null);
            accountManagementPage.setAccountNumberToAccountFieldInPopup(account, i + 1);
            threadVarsHashMap.put(TestKeyword.CHOSEN_ACCOUNT, account);
        }
    }

    @And("^User send this requests for approval.$")
    public void userSendThisRequestsForApproval() {
        accountManagementPage.clickOnSendRequestButtonInPopUp();
    }

    @When("^User switch to Pending for approval tab on Account management page.$")
    public void userSwitchToPendingForApprovalTabOnAccountManagementPage() {
        accountManagementPage.switchToPendingTab();
    }

    @SuppressWarnings("unchecked")
    @Then("^Requested accounts are displayed on Pending for approval tab.$")
    public void requestedAccountsAreDisplayedOnPendingForApprovalTab() {
        ArrayList<String> chosenAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.CHOSEN_ACCOUNT);
        ArrayList<String> pendingAccounts = accountManagementPage.getListOfRequestedAccounts();
        threadVarsHashMap.put(TestKeyword.COUNT_OF_PENDING_REQUESTS, pendingAccounts.size());
        assertTrue(pendingAccounts.containsAll(chosenAccounts));
    }

    @And("^All request were removed by User.$")
    public void allRequestsWereRemovedByUser() {
        accountManagementPage.removeRequestedAccounts(Integer.parseInt(threadVarsHashMap.getString(TestKeyword.COUNT_OF_PENDING_REQUESTS)));
    }

    @And("^Search Account From Add Account Pop-Up.$")
    public void searchAccountFromAddAccPopUp() {
        String accountName = threadVarsHashMap.getString(TestKeyword.MANAGE_USERS_ACCOUNT_NAME);
        accountManagementPage.searchAccountByAccountName(accountName);
    }

    @Then("^Appropriate account is displayed in the table on Account Management Page.$")
    public void appropriateAccountIsDisplayedInTheTable() {
        String accountName = threadVarsHashMap.getString(TestKeyword.MANAGE_USERS_ACCOUNT_NAME);
        assertEquals(accountName, accountManagementPage.getFirstAccountNameInTheTable());
    }

    @And("^Select account (.*).$")
    public void selectAccount(String accountName) {
        accountManagementPage.searchAccountByAccountName(accountName);
    }

    @And("^All requested accounts are stored to the thread vars hashmap.$")
    public void allRequestedAccountsAreStoredToTheThreadVarsHashmap() {
        ArrayList<String> pendingAccounts = accountManagementPage.getListOfRequestedAccounts();
        threadVarsHashMap.put(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS, pendingAccounts);
    }

    @Then("^List on Pending accounts is empty.$")
    public void listOnPendingAccountsIsEmpty() {
        assertEquals("No data available in table", accountManagementPage.getNoDataTitleFromPendingAccountsTable());
    }

    @When("^User switch to Approved Accounts tab on Account management page.$")
    public void userSwitchToApprovedAccountsTabOnAccountManagementPage() {
        accountManagementPage.switchToApprovedAccountsTab();
    }

    @SuppressWarnings("unchecked")
    @Then("^All the requested accounts are displayed in the tab.$")
    public void allTheRequestedAccountsAreDisplayedInTheTab() {
        ArrayList<String> approvedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        assertTrue(accountManagementPage.getAllApprovedAccountsInApprovedAccountsTab().containsAll(approvedAccounts));
    }

    @SuppressWarnings("unchecked")
    @And("^User deletes all requested accounts from his profile.$")
    public void userDeletesAllRequestedAccountsFromHisProfile() {
        ArrayList<String> approvedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        accountManagementPage.removeAllRequestedAccounts(approvedAccounts);
    }

    @Then("^Favorites tab is displayed by Default on Account Management page.$")
    public void favoritesTabIsDisplayedByDefaultOnAccountManagementPage() {
        assertTrue(accountManagementPage.activeFavoriteTabIsDisplayed());
    }

    @Then("^Appropriate reject messages for each account are displayed.$")
    public void appropriateInfoMessageIsDisplayed() {
        Stream<WebElement> rejectedMessages = accountManagementPage.getRejectedRequestListMessages();
        rejectedMessages.forEach( message -> assertTrue(message.getText().startsWith("Your request for Account No. ") && message.getText().endsWith("has been rejected.")));
    }
}
package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.RegionsManager;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.pages.AccountManagementPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

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

    @When("^Set (.*) SO code to the First Sales Office Code field in the Request Account pop-up.$")
    public void setSOCodeToTheFirstSOCodeFieldInTheRequestAccPopUp(String code) {
        accountManagementPage.setSOCodeToTheFirstSOCodeFieldInTheRequestAccPopUp(code);
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

    @Then("^Is account (.*) displayed in the table on Account Management Page.$")
    public void isAccountDisplayedInTheTableOnAccountManagementPage(String accountNo) {
        assertTrue(accountManagementPage.getAllApprovedAccounts()
                .anyMatch(account -> account.getText().equals(accountNo)));
    }

    @And("^Select account (.*).$")
    public void selectAccount(String accountNo) {
        accountManagementPage.searchAccountByAccountName(accountNo);
    }

    @And("^Search account from Add Account pop-up.$")
    public void searchAccountFromAddAccPopUp() {
        String accountNo = threadVarsHashMap.getString(TestKeyword.MANAGE_USERS_ACCOUNT_NO);
        accountManagementPage.searchAccountByAccountName(accountNo);
    }

    @Then("^Appropriate account is displayed in the table on Account Management Page.$")
    public void appropriateAccountIsDisplayedInTheTable() {
        String accountNo = threadVarsHashMap.getString(TestKeyword.MANAGE_USERS_ACCOUNT_NO);
        assertTrue(accountManagementPage.getAllApprovedAccounts()
                .anyMatch(account -> account.getText().equals(accountNo)));
    }

    @Then("^Is account name (.*) displayed in the table.")
    public void isAppropriateAccountNameIsDisplayedInTheTable(String accountName) {
        assertTrue(accountManagementPage.getListOfApprovedAccountNames()
                .anyMatch(account -> account.getText().equals(accountName)));
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
        assertTrue(accountManagementPage.getAllApprovedAccountsNoInApprovedAccountsTab().containsAll(approvedAccounts));
    }

    @SuppressWarnings("unchecked")
    @And("^User deletes all requested accounts from his profile.$")
    public void userDeletesAllRequestedAccountsFromHisProfile() {
        ArrayList<String> approvedAccounts = (ArrayList<String>) threadVarsHashMap.get(TestKeyword.LIST_OF_REQUESTED_ACCOUNTS);
        accountManagementPage.removeAllRequestedAccounts(approvedAccounts);
    }

    @Then("^Is Favorites tab displayed by Default on Account Management page.$")
    public void isFavoritesTabDisplayedByDefaultOnAccountManagementPage() {
        assertTrue(accountManagementPage.isActiveFavoriteTabDisplayed());
    }

    @And("^Click on Modify button in the Request Account pop-up.$")
    public void clickOnModifyButtonInTheRequestAccountPopUp() {
        accountManagementPage.clickOnModifyButtonInTheRequestAccountPopUp();
    }

    @Then("^Appropriate reject messages for each account are displayed.$")
    public void appropriateInfoMessageIsDisplayed() {
        Stream<WebElement> rejectedMessages = accountManagementPage.getRejectedRequestListMessages();
        rejectedMessages.forEach(message -> assertTrue(message.getText().startsWith("Your request for Account No. ") && message.getText().endsWith("has been rejected.")));
    }

    @And("^User deletes all unnecessary accounts from his profile except (.*).$")
    public void userDeletesAllUnnecessaryAccountsFromHisProfile(String necessaryAccount) {
        Supplier<Stream<WebElement>> approvedAccounts = () -> accountManagementPage.getListOfApprovedAccounts().stream();
        if (approvedAccounts.get().count() > 2) {
            approvedAccounts.get().forEach(account -> {
                if (!account.getText().equals(necessaryAccount)) {
                    accountManagementPage.removeAccountByAccountNo(account.getText());
                }
            });
        }
    }

    @And("^First account is stored to the threadVarsHashMap.$")
    public void firstAccountIsStoredToTheThreadVarsHashMap() {
        threadVarsHashMap.put(TestKeyword.FIRST_ACCOUNT_ON_APPROVED_ACCOUNTS_PAGE, accountManagementPage.getFirstAccountFullInfo());
    }

    @When("^User marks first account as favorite on approved accounts tab.$")
    public void userMarksFirstAccountAsFavoriteOnApprovedAccountsTab() {
        accountManagementPage.markAppropriateAccountAsFavorite(threadVarsHashMap.getString(TestKeyword.FIRST_ACCOUNT_ON_APPROVED_ACCOUNTS_PAGE));
    }

    @And("^User switch to Favorites Accounts tab on Account management page.$")
    public void userSwitchToFavoritesAccountsTabOnAccountManagementPage() {
        accountManagementPage.switchToFavoritesAccountsTab();
    }

    @Then("^Favorite account is present on the Favorites Accounts table.$")
    public void favoriteAccountIsPresentOnTheFavoritesAccountsTable() {
        assertTrue(accountManagementPage.getAllFavoriteAccounts().anyMatch(favAccount ->
                favAccount.getAttribute("href").contains(threadVarsHashMap.getString(TestKeyword.FIRST_ACCOUNT_ON_APPROVED_ACCOUNTS_PAGE))));
    }

    @When("^User unmarks the account as favorite on favorites accounts tab.$")
    public void userUnmarksTheAccountAsFavoriteOnFavoritesAccountsTab() {
        accountManagementPage.unmarkAsFavoriteAppropriateAccountOnFavoritesTab(threadVarsHashMap.getString(TestKeyword.FIRST_ACCOUNT_ON_APPROVED_ACCOUNTS_PAGE));
    }

    @Then("^The account is not displayed more on the table.$")
    public void theAccountIsNotDisplayedMoreOnTheTable() {
        assertFalse(accountManagementPage.isFavoriteAccountDisplayedOnFavoritesTab(threadVarsHashMap.getString(TestKeyword.FIRST_ACCOUNT_ON_APPROVED_ACCOUNTS_PAGE)));
    }

    @Then("^(.*) title is displayed on Pre Authorization Code section.$")
    public void titleIsDisplayedOnPreAuthorizationCodeSection(String title) {
        assertEquals(title, accountManagementPage.getPreAuthCodeSectionTitle());
    }

    @When("^User sets some data to the Pre Authorization Code input.$")
    public void userSetsSomeDataToThePreAuthorizationCodeInput() {
        accountManagementPage.setDataToPreAuthField();
    }

    @And("^Click on Go button.$")
    public void clickOnGoButton() {
        accountManagementPage.clickOnGoPreAuthCodeButton();
    }

    @Then("^Empty table with necessary columns appears.$")
    public void emptyTableWithNecessaryColumnsAppears() {
        assertTrue(accountManagementPage.isPreAuthAccountsTableDisplayed());
        assertTrue(accountManagementPage.isPreAuthAccountsTableEmpty());
    }

    @When("^User clicks on Send request button.$")
    public void userClicksOnSendRequestButton() {
        accountManagementPage.clickOnSendPreAuthCode();
    }

    @Then("^Table with accounts disappears.$")
    public void tableWithAccountsDisappears() {
        assertFalse(accountManagementPage.isPreAuthAccountsTableDisplayed());
    }

    @Then("^Check that Account management page is opened.$")
    public void checkThatAccountManagementPageIsOpened() {
        assertTrue(accountManagementPage.isOpened());
    }

    @And("^Count of Favorites accounts is stored to the threadVarsHashMap.$")
    public void countOfFavoriteAccountsIsStoredToTheThreadVarsHashMap() {
        threadVarsHashMap.put(TestKeyword.FAVORITE_ACCOUNTS_COUNT_FAVORITES_TAB, accountManagementPage.getCountOfFavoriteAccounts());
    }

    @When("^User marks some account as favorite.$")
    public void userMarksSomeAccountAsFavorite() {
        String accountFullInfo = accountManagementPage.getListOfNotFavoritesAccounts().stream().findAny().get().getAttribute("href").split("/select-account/")[1];
        accountManagementPage.markAppropriateAccountAsFavorite(accountFullInfo);
        threadVarsHashMap.put(TestKeyword.JUST_MARKED_FAVORITE_ACCOUNT, accountFullInfo);
    }

    @And("^Previously marked account is unmarked by user.$")
    public void previouslyMarkedAccountIsUnmarkedByUser() {
        accountManagementPage.unmarkAsFavoriteAppropriateAccountOnFavoritesTab(threadVarsHashMap.getString(TestKeyword.JUST_MARKED_FAVORITE_ACCOUNT));
    }

    @Then("^Correct count of favorite account is displayed in Favorites tab.$")
    public void correctCountOfFavoriteAccountIsDisplayedInFavoritesTab() {
        assertTrue(accountManagementPage.getCountOfFavoriteAccounts() == (int) threadVarsHashMap.get(TestKeyword.FAVORITE_ACCOUNTS_COUNT_FAVORITES_TAB));
    }

    @Then("^Request account button is not displayed on the page.$")
    public void requestAccountButtonIsNotDisplayedOnThePage() {
        assertFalse(accountManagementPage.isRequestAccountButtonDisplayed());
    }

    @Then("^Favorite accounts tab is not displayed on the page.$")
    public void favoriteAccountsTabIsNotDisplayedOnThePage() {
        assertFalse(accountManagementPage.isFavoriteAccountsTabDisplayed());
    }

    @Then("^Pending for approval tab is not displayed on the page.$")
    public void pendingForApprovalTabIsNotDisplayedOnThePage() {
        assertFalse(accountManagementPage.isPendingForApprovalTabDisplayed());
    }

    @Then("^Accounts tab is displayed on the page.$")
    public void accountsTabIsDisplayedOnThePage() {
        assertTrue(accountManagementPage.isAccountsTabDisplayed());
    }

    @Then("^User is able to find all accounts in (.*) region.$")
    public void userIsAbleToFindAllAccountsInNorth_AmericaRegion(String regionName) {
        Region chosenRegion = regionsManager.getRegionByName(regionName);
        accountManagementPage.selectAppropriateRegionFromRegionList(chosenRegion);
        accountManagementPage.clickOnSearchButton();
        if (regionName.equals("EMEA") || regionName.equals("ASIA") || regionName.equals("Latin_America"))
            assertEquals(accountManagementPage.getNoDataTitleFromAccountsTable(), "No data available in table");
        else
            assertTrue(accountManagementPage.getApprovedAccountsTableSize() > 1);
    }

    @When("^User selects random favorites account.$")
    public void userSelectsRandomFavoritesAccount() {
        StringBuilder chosenAccount = new StringBuilder();
        accountManagementPage.getAllFavoriteAccounts().findAny().ifPresent(acc -> {
            chosenAccount.append(acc.getText());
            acc.click();
        });
        threadVarsHashMap.put(TestKeyword.CHOSEN_FAVORITE_ACCOUNT, chosenAccount);
    }

    @When("^User hover mouse over red triangle icon.$")
    public void userHoverMouseOverRedTriangleIcon() {
        accountManagementPage.userHoverMouseOverRedTriangleIcon();
    }

    @When("^User hover mouse over red certificate icon.$")
    public void userHoverMouseOverRedCertificateIcon() {
        accountManagementPage.userHoverMouseOverRedCertificateIcon();
    }

    @Then("^Is tooltip text (.*) displayed in stopship/stopbook tooltip.$")
    public void isTooltipTextDisplayedInStopshipStopbookTooltip(String tooltipText) {
        assertEquals(tooltipText, accountManagementPage.getStopBookStopShipTooltipText());
    }
}
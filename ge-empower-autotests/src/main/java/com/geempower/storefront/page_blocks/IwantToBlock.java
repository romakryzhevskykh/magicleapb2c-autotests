package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import com.geempower.helpers.models.RegionType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.geempower.helpers.models.RegionType.getRegionTypes;
import static com.geempower.storefront.page_block_elements.IwantToBlockElements.*;

@Component
public class IwantToBlock extends UIComponent {

    @Step("Expand Modify An Account Tab In I Want To Block.")
    public void expandModifyAnAccountTabInIWantToBlock() {
        waitUntilPageIsFullyLoaded();
        click(MODIFY_AN_ACCOUNT_TAB_XPATH);
    }

    @Step("Is Orders Table Empty.")
    private boolean isAccountsTableEmpty() {
        try {
            return $(EMPTY_ALL_ACCOUNTS_TABLE_XPATH).isDisplayed();
        } catch (NoSuchElementException | NullPointerException exception) {
            return false;
        }
    }

    @Step("Get Count Of Pages All Accounts tab.")
    private int getCountOfPagesAllAccountsTab() {
        int actualCount = 0;
        if (isPaginatorDisplayed()) {
            String countOfPages = $(COUNT_OF_PAGES_ALL_ACCOUNTS_TAB_XPATH).getText();
            actualCount = Integer.parseInt(countOfPages.replace("of ", ""));
        } else if (!isPaginatorDisplayed()) {
            actualCount = 1;
        } else if (isAccountsTableEmpty()) {
            actualCount = 0;
        }
        return actualCount;
    }

    @Step("Is Paginator Displayed.")
    private boolean isPaginatorDisplayed() {
        return isDisplayed(COUNT_OF_PAGES_ALL_ACCOUNTS_TAB_XPATH);
    }

    @Step("Get All Account Names.")
    public Stream<WebElement> getAllAccountNo() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_ACCOUNT_NO_IN_ACCOUNTS_TABLE_XPATH).stream();
    }

    @Step("Click On Sales Office Codes Tab.")
    public void clickOnSalesOfficeCodesTab() {
        waitUntilPageIsFullyLoaded();
        click(SALES_OFFICE_CODES_TAB_IN_MODIFY_ACC_TAB_XPATH);
    }

    @Step("Get All SO Codes from table from approved SO Codes Table.")
    public Stream<WebElement> getAllSoCodesFromApprovedSoCodesTable() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_APPROVED_SALES_OFFICE_CODE_XPATH).stream();
    }

    @Step("Get All SE Codes from approved SE Codes table.")
    public Stream<WebElement> getAllSeCodesFromTable() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_APPROVED_SALES_ENGINEER_CODES_XPATH).stream();
    }

    @Step("Select All Sales Office Codes Checkbox In SO Code tab.")
    public void selectAllSalesOfficeCodesCheckboxInSOCodesTab() {
        click(ALL_SO_CODES_CHECKBOX_IN_MODIFY_AN_ACC_TAB_XPATH);
    }

    @Step("Select All Sales Engineer Codes Checkbox In SE Code tab.")
    public void selectAllSalesEngineerCodesCheckboxInSECodesTab() {
        click(ALL_SE_CODES_CHECKBOX_IN_MODIFY_AN_ACC_TAB_XPATH);
    }

    @Step("Click On Remove SO Codes Button.")
    public void clickOnRemoveSoCodesButtonSOCodesTab() {
        click(REMOVE_BUTTON_IN_SO_CODES_TAB_IN_MODIFY_AN_ACC_TAB_XPATH);
    }

    @Step("Click On Remove SE Codes Button.")
    public void clickOnRemoveSeCodesButtonInSeCodesTab() {
        click(REMOVE_BUTTON_IN_SE_CODES_TAB_IN_MODIFY_AN_ACC_TAB_XPATH);
    }

    @Step("Get Remove Acc SO Codes Pop-Up Title.")
    public String getRemoveSoCodesAccPopUpTitle() {
        return $(REMOVE_ACCOUNT_POP_UP_TITLE_SO_CODES_XPATH).getText();
    }

    @Step("Get Remove Acc SE Codes Pop-Up Title.")
    public String getRemoveSeCodesAccPopUpTitle() {
        return $(REMOVE_ACCOUNT_POP_UP_TITLE_SE_CODES_XPATH).getText();
    }

    @Step("Get Remove All Accounts Pop-Up Title.")
    public String getRemoveAllAccountsPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        return $(REMOVE_ACCOUNT_POP_UP_TITLE_ALL_ACCOUNTS_XPATH).getText();
    }

    @Step("Get Accept All Accounts Pop-Up Title.")
    public String getAcceptAllAccountsPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        return $(ACCEPT_ACCOUNT_POP_UP_TITLE_SO_CODES_IN_PENDING_SALES_OFFICE_TAB_XPATH).getText();
    }

    @Step("Click On Remove Button In The Remove Account Pop-Up In SO Codes Tab.")
    public void clickOnRemoveButtonInTheRemoveAccountPopUpInSOCodesTab() {
        click(REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_SO_CODES_TAB_XPATH);
    }

    @Step("Click On Remove Button In The Remove Account Pop-Up In SE Codes Tab.")
    public void clickOnRemoveButtonInTheRemoveAccountPopUpInSECodesTab() {
        click(REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_SE_CODES_TAB_XPATH);
    }

    @Step("Click On Remove Button In The Remove Account Pop-Up In All Accounts Tab.")
    public void clickOnRemoveButtonInTheRemoveAccountPopUpInAllAccountsTab() {
        click(REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_ALL_ACCOUNTS_TAB_XPATH);
    }

    @Step("Click On Accept Button In The Accept Account Pop-Up In Pending SO Codes Tab.")
    public void clickOnAcceptButtonInTheAcceptAccountPopUpInPendingSOCodesTab() {
        click(ACCEPT_BUTTON_IN_ACCEPT_ACC_POP_UP_IN_PENDING_S0_CODES_TAB_XPATH);
    }

    @Step("Click On Reject Button In The Reject Account Pop-Up In Pending SO Codes Tab.")
    public void clickOnRejectButtonInTheRejectAccountPopUpInPendingSOCodesTab() {
        click(REJECT_BUTTON_IN_REJECT_ACC_POP_UP_IN_PENDING_S0_CODES_TAB_XPATH);
    }

    @Step("Get No Data Title in SO Codes table.")
    public String getNoDataTitleInSoCodesTable() {
        waitUntilPageIsFullyLoaded();
        return $(EMPTY_SO_CODES_TABLE_XPATH).getText();
    }

    @Step("Get No Data Title in Pending SO Codes table.")
    public String getNoDataTitleInPendingSoCodesTable() {
        waitUntilPageIsFullyLoaded();
        return $(EMPTY_SO_CODES_TABLE_IN_PENDING_SO_CODES_XPATH).getText();
    }

    @Step("Get No Data Title in SE Codes table.")
    public String getNoDataTitleInSeCodesTable() {
        waitUntilPageIsFullyLoaded();
        return $(EMPTY_SE_CODES_TABLE_XPATH).getText();
    }

    @Step("Is Remove Account Pop-Up Is Displayed In SO Codes Tab.")
    public boolean isRemoveAccountPopUpIsDisplayedInSoCodesTab() {
        waitForElementWithAppropriateTextToAppear(By.xpath(REMOVE_ACCOUNT_POP_UP_TITLE_SO_CODES_XPATH), "Remove Account");
        return isDisplayed(REMOVE_ACCOUNT_POP_UP_SO_CODES_XPATH);
    }

    @Step("Is Remove Account Pop-Up Is Displayed In SE Codes Tab.")
    public boolean isRemoveAccountPopUpIsDisplayedInSeCodesTab() {
        waitForElementWithAppropriateTextToAppear(By.xpath(REMOVE_ACCOUNT_POP_UP_TITLE_SE_CODES_XPATH), "Remove Account");
        return isDisplayed(REMOVE_ACCOUNT_POP_UP_SE_CODES_XPATH);
    }

    @Step("Is Remove Account Pop-Up Is Displayed In All Accounts Tab.")
    public boolean isRemoveAccountPopUpIsDisplayedInAllAccountsTab() {
        waitForElementWithAppropriateTextToAppear(By.xpath(REMOVE_ACCOUNT_POP_UP_TITLE_ALL_ACCOUNTS_XPATH), "Remove Account");
        return isDisplayed(REMOVE_ACCOUNT_POP_UP_ALL_ACCOUNTS_XPATH);
    }

    @Step("Click on Sales Engineer Sales Tab.")
    public void clickOnSalesEngineerCodesTab() {
        click(SALES_ENGINEER_CODES_TAB_IN_MODIFY_ACC_TAB_XPATH);
    }

    @Step("Get Approve Pending Accounts Section Title.")
    public String getApprovePendingAccountsSectionTitle() {
        waitUntilPageIsFullyLoaded();
        return $(APPROVE_PENDING_ACCOUNTS_SECTION_TITLE_XPATH).getText();
    }

    @Step("Get Total Accounts Requests.")
    public int getTotalAccountRequests() {
        return Integer.parseInt($(TOTAL_ACCOUNT_REQUESTS_XPATH).getText());
    }

    @Step("Expand Approve Pending Accounts Section.")
    public void expandApprovePendingAccountsSection() {
        waitUntilPageIsFullyLoaded();
        click(APPROVE_PENDING_ACCOUNTS_SECTION_EXPAND_ICON_XPATH);
    }

    @Step("Get Actual Pending Accounts Table Size.")
    public int getActualPendingAccountsTableSize() {
        waitUntilPageIsFullyLoaded();
        return $$(PENDING_ACCOUNTS_TABLE_ROWS_XPATH).size();
    }

    @Step("Click On Select All Pending Accounts CheckBox.")
    public void clickOnSelectAllPendingAccountsCheckBox() {
        waitUntilPageIsFullyLoaded();
        click(ALL_PENDING_ACCOUNT_CHECKBOX_XPATH);
    }

    @Step("Click On Accept Account Button.")
    public void clickOnAcceptAccountButton() {
        click(ACCEPT_ACCOUNT_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click On Accept SO Codes Button.")
    public void clickOnAcceptSOCodesButton() {
        click(ACCEPT_SO_CODES_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click On Reject SO Codes Button.")
    public void clickOnRejectSOCodesButton() {
        click(REJECT_SO_CODES_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Accept The Action On Accept Account PopUp.")
    public void acceptTheActionOnAcceptAccountPopUp() {
        click(ACCEPT_THE_ACTION_IN_ACCEPT_ACCOUNT_POP_UP_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get No Data Title In Pending Accounts Table.")
    public String getNoDataTitleInPendingAccountsTable() {
        waitUntilPageIsFullyLoaded();
        return $(PENDING_ACCOUNTS_TABLE_NO_DATA_TITLE_XPATH).getText();
    }

    @Step("Get Active Account For User In Modify An Account Section.")
    public List<String> getActiveAccountForUserInModifyAnAccountSection() {
        waitUntilPageIsFullyLoaded();
        return $$(ACTIVE_USER_ACCOUNTS_NAME_TABLE_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Click On Account Checkbox In I Want To Block In All Accounts Tab.")
    public void clickOnAccountCheckboxInIWantToBlockInAllAccountsTab(String account) {
        click(ACCOUNT_CHECKBOX_XPATH, account);
    }

    @Step("Click On Remove Button In All Accounts Tab.")
    public void clickOnRemoveButtonInAllAccountsTab() {
        click(REMOVE_BUTTON_IN_ALL_ACCOUNTS_TAB_XPATH);
    }

    @Step("Click on Pending Sales Office Codes tab In Approve Pending Accounts Tab.")
    public void clickOnPendingSalesOfficeCodesTab() {
        click(PENDING_SALES_OFFICE_CODES_TAB_APPROVED_PENDING_ACC_TAB_XPATH);
    }

    @Step("^Admin clicks on All Sales Office Codes checkbox in Pending SO Codes tab.$")
    public void adminClicksOnAllSalesOfficeCodesCheckboxInPendingSOCodesTab() {
        click(ALL_CHECKBOX_SALES_OFFICE_CODES_IN_PENDING_SALES_OFFICE_TAB_XPATH);
    }

    @Step("Get all SO codes from pending SO codes table.")
    public Stream<WebElement> getAllSOCodesFromPendingSOCodesTable() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_SO_CODES_IN_PENDING_SO_CODES_TABLE_XPATH).stream();
    }

    @Step("Click On Reject Account Button.")
    public void clickOnRejectAccountButton() {
        click(REJECT_ACCOUNT_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Accept The Action On Reject Account PopUp.")
    public void acceptTheActionOnRejectAccountPopUp() {
        click(ACCEPT_THE_ACTION_IN_REJECT_ACCOUNT_POP_UP_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Expand Change EmpPrivilege Block.")
    public void expandChangeEmpPrivilegeBlock() {
        waitUntilPageIsFullyLoaded();
        click(EXPAND_CHANGE_EMPOWER_PRIVILEGES_ROLES_ICON_XPATH);
    }

    @Step("Get All User Roles For Each Region")
    public HashMap<String, String> getAllRolesForEachRegion() {
        waitUntilPageIsFullyLoaded();
        HashMap<String, String> rolesForRegions = new HashMap<>();
        rolesForRegions.putAll(getRegionTypes().stream()
                .collect(Collectors.toMap(RegionType::getRegionName,
                        region -> $(ROLE_FOR_APPROPRIATE_REGION_XPATH, region.getRegionName()).getText().trim())));
        return rolesForRegions;
    }

    @Step("Set New Role To User For Each Region.")
    public void setNewRoleToUserForEachRegion(String region, String newRole) {
        waitUntilPageIsFullyLoaded();
        click(OPEN_ROLES_LIST_FOR_APPROPRIATE_REGION_ICON_XPATH, region);
        waitUntilPageIsFullyLoaded();
        click(getAllRolesFromRolesDropdown().filter(role -> role.getText().trim().equals(newRole)).findAny().orElse(null));
    }

    @Step("Get all roles from roles drop-down.")
    private Stream<WebElement> getAllRolesFromRolesDropdown() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_ROLES_IN_ROLES_DROPDOWN_XPATH).stream();
    }

    @Step("Click On Assign Roles Button")
    public void clickOnAssignRolesButton() {
        waitUntilPageIsFullyLoaded();
        click(By.id(ASSIGN_ROLES_OR_PRIVILEGES_BUTTON_ID));
    }

    @Step("Prevent Appearing Account In The All Accounts Tab.")
    public void preventAppearingAccountInTheAllAccountsTab(String accountNo) {
        waitUntilPageIsFullyLoaded();
        int actualCountOfPages = getCountOfPagesAllAccountsTab();
        for (int i = 0; i < actualCountOfPages; i++) {
            if ($$(ALL_ACCOUNT_NO_IN_ACCOUNTS_TABLE_XPATH).stream().noneMatch(account -> account.getText().equals(accountNo))) {
                if (actualCountOfPages > 1) {
                    click(NEXT_PAGINATION_BUTTON_ALL_ACCOUNTS_TAB_XPATH);
                }
                waitUntilPageIsFullyLoaded();
            } else if ($$(ALL_ACCOUNT_NO_IN_ACCOUNTS_TABLE_XPATH).stream().anyMatch(account -> account.getText().equals(accountNo))) {
                click(ACCOUNT_CHECKBOX_XPATH, accountNo);
                ((JavascriptExecutor) getDriver()).executeScript("scroll(0,0)");
                click(REMOVE_BUTTON_IN_ALL_ACCOUNTS_TAB_XPATH);
                click(REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_ALL_ACCOUNTS_TAB_XPATH);
                actualCountOfPages = i;
            }
        }
    }

    @Step("Is account displayed in all account tab.")
    public boolean isAccountDisplayedInAllAccTab(String accountNo) {
        waitUntilPageIsFullyLoaded();
        boolean result = false;
        int actualCountOfPages = getCountOfPagesAllAccountsTab();
        for (int i = 0; i < actualCountOfPages; i++) {
            if ($$(ALL_ACCOUNT_NO_IN_ACCOUNTS_TABLE_XPATH).stream().noneMatch(account -> account.getText().equals(accountNo))) {
                if (actualCountOfPages > 1) {
                    click(NEXT_PAGINATION_BUTTON_ALL_ACCOUNTS_TAB_XPATH);
                }
            } else if ($$(ALL_ACCOUNT_NO_IN_ACCOUNTS_TABLE_XPATH).stream().anyMatch(account -> account.getText().equals(accountNo))) {
                actualCountOfPages = i;
                result = true;
            }
        }
        return result;
    }
}
package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.geempower.storefront.page_block_elements.IwantToBlockElements.*;

@Component
public class IwantToBlock extends UIComponent {

    @Step("Expand Modify An Account Tab In I Want To Block.")
    public void expandModifyAnAccountTabInIWantToBlock() {
        waitUntilPageIsFullyLoaded();
        click(MODIFY_AN_ACCOUNT_TAB_XPATH);
    }

    @Step("Get Account Name.")
    public Stream<WebElement> getAccountName() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_ACCOUNT_NAMES_IN_ACCOUNTS_TABLE_XPATH).stream();
    }

    @Step("Click On Sales Office Codes Tab.")
    public void clickOnSalesOfficeCodesTab() {
        click(SALES_OFFICE_CODES_TAB_XPATH);
    }

    @Step("Get SO Code from table.")
    public String getSoCodeFromTable() {
        waitUntilPageIsFullyLoaded();
        return $(SALES_OFFICE_CODE_XPATH).getText().trim();
    }

    @Step("Get SE Code from table.")
    public String getSeCodeFromTable() {
        waitUntilPageIsFullyLoaded();
        return $(SALES_ENGINEER_CODE_XPATH).getText().trim();
    }

    @Step("Select All Sales Office Codes Checkbox In SO Code tab.")
    public void selectAllSalesOfficeCodesCheckboxInSOCodesTab() {
        click(ALL_SO_CODES_CHECKBOX_XPATH);
    }

    @Step("Select All Sales Engineer Codes Checkbox In SE Code tab.")
    public void selectAllSalesEngineerCodesCheckboxInSECodesTab() {
        click(ALL_SE_CODES_CHECKBOX_XPATH);
    }

    @Step("Click On Remove SO Codes Button.")
    public void clickOnRemoveSoCodesButtonSOCodesTab() {
        click(REMOVE_BUTTON_IN_SO_CODES_TAB_XPATH);
    }

    @Step("Click On Remove SE Codes Button.")
    public void clickOnRemoveSeCodesButtonInSeCodesTab() {
        click(REMOVE_BUTTON_IN_SE_CODES_TAB_XPATH);
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
        return $(REMOVE_ACCOUNT_POP_UP_TITLE_ALL_ACCOUNTS_XPATH).getText();
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

    @Step("Get No Data Title in SO Codes table.")
    public String getNoDataTitleInSoCodesTable() {
        waitUntilPageIsFullyLoaded();
        return $(EMPTY_SO_CODES_TABLE_XPATH).getText();
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
        click(SALES_ENGINEER_CODES_TAB_XPATH);
    }

    @Step("Get Approve Pending Accounts Section Title")
    public String getApprovePendingAccountsSectionTitle() {
        waitUntilPageIsFullyLoaded();
        return $(APPROVE_PENDING_ACCOUNTS_SECTION_TITLE_XPATH).getText();
    }

    @Step("Get Total Accounts Requests")
    public int getTotalAccountRequests() {
        return Integer.parseInt($(TOTAL_ACCOUNT_REQUESTS_XPATH).getText());
    }

    @Step("Expand Approve Pending Accounts Section")
    public void expandApprovePendingAccountsSection() {
        click(APPROVE_PENDING_ACCOUNTS_SECTION_EXPAND_ICON_XPATH);
    }

    @Step("Get Actual Pending Accounts Table Size")
    public int getActualPendingAccountsTableSize() {
        return $$(PENDING_ACCOUNTS_TABLE_ROWS_XPATH).size();
    }

    @Step("Click On Select All Pending Accounts CheckBox")
    public void clickOnSelectAllPendingAccountsCheckBox() {
        waitUntilPageIsFullyLoaded();
        click(ALL_PENDING_ACCOUNT_CHECKBOX_XPATH);
    }

    @Step("Click On Accept Account Button")
    public void clickOnAcceptAccountButton() {
        click(ACCEPT_ACCOUNT_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Accept The Action On Accept Account PopUp")
    public void acceptTheActionOnAcceptAccountPopUp() {
        click(ACCEPT_THE_ACTION_IN_ACCEPT_ACCOUNT_POP_UP_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get No Data Title In Pending Accounts Table")
    public String getNoDataTitleInPendingAccountsTable() {
        waitUntilPageIsFullyLoaded();
        return $(PENDING_ACCOUNTS_TABLE_NO_DATA_TITLE_XPATH).getText();
    }

    @Step("Get Active Account For User In Modify An Account Section")
    public List<String> getActiveAccountForUserInModifyAnAccountSection() {
        waitUntilPageIsFullyLoaded();
        return $$(ACTIVE_USER_ACCOUNTS_NAME_TABLE_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Click On Account Checkbox In I Want To Block In All Accounts Tab")
    public void clickOnAccountCheckboxInIWantToBlockInAllAccountsTab(String account) {
        click(ACCOUNT_CHECKBOX_XPATH, account);
    }

    @Step("Click On Remove Button In All Accounts Tab")
    public void clickOnRemoveButtonInAllAccountsTab() {
        click(REMOVE_BUTTON_IN_ALL_ACCOUNTS_TAB_XPATH);
    }
}

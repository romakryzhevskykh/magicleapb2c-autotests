package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.IwantToBlockElements.*;

@Component
public class IwantToBlock extends UIComponent {

    @Step("Expand Modify An Account Tab In I Want To Block.")
    public void expandModifyAnAccountTabInIWantToBlock() {
        waitUntilPageIsFullyLoaded();
        click(MODIFY_AN_ACCOUNT_TAB_XPATH);
    }


    @Step("Get Account Name.")
    public String getAccountName() {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_NAME_IN_ACCOUNTS_TABLE_XPATH).getText();
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
        click(REMOVE_SO_CODES_BUTTON_XPATH);
    }

    @Step("Click On Remove SE Codes Button.")
    public void clickOnRemoveSeCodesButtonInSeCodesTab() {
        click(REMOVE_SE_CODES_BUTTON_XPATH);
    }

    @Step("Get Remove Acc SO Codes Pop-Up Title.")
    public String getRemoveSoCodesAccPopUpTitle() {
        return $(REMOVE_ACCOUNT_POP_UP_TITLE_SO_CODES_XPATH).getText();
    }

    @Step("Get Remove Acc SE Codes Pop-Up Title.")
    public String getRemoveSeCodesAccPopUpTitle() {
        return $(REMOVE_ACCOUNT_POP_UP_TITLE_SE_CODES_XPATH).getText();
    }

    @Step("Click On Remove Button In The Remove Account Pop-Up.")
    public void clickOnRemoveButtonInTheRemoveAccountPopUp() {
        click(REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_XPATH);
    }

    @Step("Click On Remove Button In The Remove Account Pop-Up In SE Codes Tab.")
    public void clickOnRemoveButtonInTheRemoveAccountPopUpInSECodesTab() {
        click(REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_SE_CODES_TABLE_XPATH);
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

    @Step("Click on Sales Engineer Sales Tab.")
    public void clickOnSalesEngineerCodesTab() {
        click(SALES_ENGINEER_CODES_TAB_XPATH);
    }
}

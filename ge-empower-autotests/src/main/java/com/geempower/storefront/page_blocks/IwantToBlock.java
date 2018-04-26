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

    @Step("Get SO Code.")
    public String getSoCode() {
        waitUntilPageIsFullyLoaded();
        return $(SALES_OFFICE_CODE_XPATH).getText().trim();
    }

    @Step("Select All Sales Office Codes Checkbox In SO Code tab.")
    public void selectAllSalesOfficeCodesCheckboxInSOCodesTab() {
        click(ALL_SO_CODES_CHECKBOX_XPATH);
    }

    @Step("Click On Remove SO Codes Button.")
    public void clickOnRemoveSoCodesButtonSOCodesTab() {
        click(REMOVE_SO_CODES_BUTTON_XPATH);
    }

    @Step("Get Remove Acc Pop-Up Title")
    public String getRemoveAccPopUpTitle() {
        waitForElementWithAppropriateTextToAppear(By.xpath(REMOVE_ACCOUNT_POP_UP_TITLE_XPATH), "Remove Account");
        return $(REMOVE_ACCOUNT_POP_UP_TITLE_XPATH).getText();
    }

    @Step("Click On Remove Button In The Remove Account PopUp.")
    public void clickOnRemoveButtonInTheRemoveAccountPopUp() {
        click(REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_XPATH);
    }

    @Step("Get No Data Title.")
    public String getNoDataTitle() {
        waitUntilPageIsFullyLoaded();
        return $(EMPTY_SO_CODES_TABLE_XPATH).getText();
    }
}

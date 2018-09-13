package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.UserNotActivePageElements.*;


@Component
public class UserNotActivePage extends StorefrontBasePage {
    private final String pageUri = "register/userNotActive";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get User Not Active Page Title.")
    public String getUserNotActivePageTitle() {
        return $(USER_NOT_ACTIVE_PAGE_TITLE_XPATH).getText();
    }

    @Step("Get Hello Message Screen 1.")
    public String getHelloMessageScreen1() {
        return $(MAIN_BLOCK_HELLO_MESSAGE_SCREEN_1_XPATH).getText();
    }

    @Step("Get Hello Message 1 Screen 2.")
    public String getHelloMessage1Screen2() {
        return $(MAIN_BLOCK_HELLO_MESSAGE_SCREEN_2_XPATH).getText();
    }

    @Step("Get Hello Message 2 Screen 2.")
    public String getHelloMessage2Screen2() {
        return $(MAIN_BLOCK_HELLO_MESSAGE_2_SCREEN_2_XPATH).getText();
    }

    @Step("Get Requested Accounts text Screen 2.")
    public String getRequestedAccountsTextScreen2() {
        return $(MAIN_BLOCK_REQUESTED_ACCOUNTS_TEXT_2_SCREEN_2_XPATH).getText();
    }

    @Step("Get Authorization text Screen 2.")
    public String getAuthorizationTextScreen2() {
        return $(MAIN_BLOCK_AUTHORIZATION_CODE_TEXT_SCREEN_2_XPATH).getText();
    }

    @Step("Get Please Allow Us text Screen 2.")
    public String getPleaseAllowUsTextScreen2() {
        return $(MAIN_BLOCK_PLEASE_ALLOW_US_TEXT_SCREEN_2_XPATH).getText();
    }

    @Step("Get How To Find Text Screen 1.")
    public String getHowToFindTextScreen1() {
        return $(MAIN_BLOCK_HOW_TO_FIND_TEXT_SCREEN_1_XPATH).getText();
    }

    @Step("Get Invoice Text Screen 1.")
    public String getInvoiceTextScreen1() {
        return $(MAIN_BLOCK_INVOICE_TEXT_SCREEN_1_XPATH).getText();
    }

    @Step("Get Account Management Text Screen 1.")
    public String getAccountManagementTextScreen1() {
        return $(MAIN_BLOCK_ACCOUNT_MANAGER_TEXT_SCREEN_1_XPATH).getText();
    }

    @Step("Get Note Footer Text Screen 1.")
    public String getNoteFooterTextScreen1() {
        return $(FOOTER_NOTE_TEXT_SCREEN_1_XPATH).getText();
    }

    @Step("Get Footer Locate A distributor Link Text Screen 1.")
    public String getFooterLocateAdistributorLinkTextScreen1() {
        return $(FOOTER_LOCATE_A_DISTRIBUTOR_LINK_TEXT_SCREEN_1_XPATH).getText();
    }

    @Step("Get Footer Locate A distributor Text Screen 1.")
    public String getFooterContactUsLinkTextScreen1() {
        return $(FOOTER_CONTACT_US_LINK_TEXT_SCREEN_1_XPATH).getText();
    }

    @Step("User Clicks On Request Account Button.")
    public void userClicksOnRequestAccountButton() {
        click(REQUEST_ACCOUNT_BUTTON_XPATH);
    }

    @Step("Get Request Account Title PopUp.")
    public String getRequestAccountTitlePopUp() {
        waitUntilPageIsFullyLoaded();
        return $(REQUEST_ACCOUNT_TITLE_IN_POP_UP_XPATH).getText();
    }

    @Step("User Closes Request Account PopUp.")
    public void userClosesRequestAccountPopUp() {
        click(CLOSE_BUTTON_IN_REQUEST_ACCOUNT_POP_UP_XPATH);
    }

    @Step("User Clicks On Add New Account Field Button.")
    public void userClicksOnAddNewAccountFieldButton() {
        waitUntilPageIsFullyLoaded();
        click(ADD_ACCOUNT_FIELD_BUTTON_XPATH);
    }

    @Step("Get Account No Fields.")
    public int getAccountNoFields() {
        return $$(ACCOUNT_NO_FIELD_XPATH).size();
    }

    @Step("Get Requested account fields.")
    public Stream<WebElement> getRequestedAccountFields() {
        return $$(REQUESTED_ACCOUNT_FIELD_XPATH).stream();
    }

    @Step("User Sets Account To The Account Number Field.")
    public void userSetsAccountToTheAccountNumberField(String accountNo) {
        $(ACCOUNT_NO_FIELD_XPATH).clear();
        $(ACCOUNT_NO_FIELD_XPATH).sendKeys(accountNo);
    }

    @Step("Click On Submit For Approval Button.")
    public void clickOnSubmitForApprovalButton() {
        click(ACTIVE_SUBMIT_FOR_APPROVAL_BUTTON_XPATH);
    }

    @Step("User Clicks On Yes Pre Authorization Code Button.")
    public void userClicksOnYesPreAuthorizationCodeButton() {
        click(YES_PRE_AUTH_BUTTON_XPATH);
    }

    @Step("Get Pre Auth Title PopUp")
    public String getPreAuthTitlePopUp() {
        waitUntilPageIsFullyLoaded();
        return $(PRE_AUTHORIZATION_CODE_TITLE_IN_POP_UP_XPATH).getText();
    }

    @Step("User Closes Pre Authorization Code PopUp.")
    public void userClosesPreAuthorizationCodePopUp() {
        click(CANCEL_BUTTON_IN_PRE_AUTH_CODE_POP_UP_XPATH);
    }
}
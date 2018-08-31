package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

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

    @Step("Get Hello Message.")
    public String getHelloMessage() {
        return $(MAIN_BLOCK_HELLO_MESSAGE_XPATH).getText();
    }

    @Step("Get How To Find Text.")
    public String getHowToFindText() {
        return $(MAIN_BLOCK_HOW_TO_FIND_TEXT_XPATH).getText();
    }

    @Step("Get Invoice Text.")
    public String getInvoiceText() {
        return $(MAIN_BLOCK_INVOICE_TEXT_XPATH).getText();
    }

    @Step("Get Account Management Text.")
    public String getAccountManagementText() {
        return $(MAIN_BLOCK_ACCOUNT_MANAGER_TEXT_XPATH).getText();
    }

    @Step("Get Note Footer Text.")
    public String getNoteFooterText() {
        return $(FOOTER_NOTE_TEXT_XPATH).getText();
    }

    @Step("Get Footer Locate A distributor Link Text.")
    public String getFooterLocateAdistributorLinkText() {
        return $(FOOTER_LOCATE_A_DISTRIBUTOR_LINK_TEXT_XPATH).getText();
    }

    @Step("Get Footer Locate A distributor Text.")
    public String getFooterContactUsLinkText() {
        return $(FOOTER_CONTACT_US_LINK_TEXT_XPATH).getText();
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
        return $$(ACCOUNT_NO_FIELDS_XPATH).size();
    }
}
package com.magicleap.storefront.pages;

import com.magicleap.helpers.UIComponent;
import com.magicleap.helpers.models.users.UserSession;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import static com.magicleap.storefront.page_elements.LoginPageElements.*;
import static com.magicleap.storefront.page_elements.QualificationPageElements.*;

@Component
public class QualificationPage extends StorefrontBasePage {
    private final String pageUrlMethod = "/#/signup";

    public boolean isOpened() {
        return isCurrentURLEqualsToLoginPageURL();
            }

    @Step("Fill legal company name.")
    public void fillLegalCompanyName (String legalCompanyName) {
        waitUntilPageIsFullyLoaded();
        $(COMPANY_NAME_FIELD_XPATH).sendKeys(legalCompanyName);
    }
    @Step("Fill DBA field.")
    public void fillDba (String dba) {
        $(DBA_FIELD_XPATH).sendKeys(dba);
    }
    @Step("Fill website field.")
    public void fillWebsite (String website) {
        $(WEBSITE_FIELD_XPATH).sendKeys(website);
    }
    @Step("Fill years in business field.")
    public void fillYearsInBusiness (String yearsInBusiness) {
        $(YEARS_IN_BUSINESS_FIELD_XPATH).sendKeys(yearsInBusiness);
    }
    @Step("Click on 'type of business' dropdown")
    public void clickOnTypeOfBusinessDropdown () {
        $(BUSINESS_TYPE_DROPDOWN_XPATH).click();
    }
    @Step("Select 'type of business' dropdown")
    public void selectTypeOfBusinessDropdown (String typeOfBusinessName) {
        click(BUSINESS_TYPE_ELEMENT_DROPDOWN_XPATH, typeOfBusinessName);
    }
    @Step("Click on 'Market segment' dropdown")
    public void clickOnMarketSegmentDropdown () {
        $(MARKET_SEGMENT_DROPDOWN_XPATH).click();
    }

    @Step("Select 'Market segment' dropdown")
    public void selectMarketSegmentDropdown (String marketSegment) {
        click(MARKET_SEGMENT_ELEMENT_DROPDOWN_XPATH, marketSegment);
    }
    @Step("Click on selected radio-button")
    public void clickOnTypeOfOwnershipRadioButton (String radioButton) {
        click(TYPE_OF_OWNERSHIP_RADIO_BUTTON_XPATH,radioButton);
           }

    @Step("Click on 'Any prior business dealings with Magic Leap' radio-button")
    public void clickOnPriorBusinessDealingsRadioButton (String radioButton) {
        click(PRIOR_DEALING_RADIO_BUTTON,radioButton);
    }
    @Step("Click on login Button on qualification page")
    public void clickOnLoginButtonQualificationPage () {
        $(LOGIN_PAGE_BUTTON_XPATH).click();
    }

    @Step("Click on login Button on qualification page")
    public void clickOnNextButton () {
        $(NEXT_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }
    @Step("Fill full name in the full name field field.")
    public void fillFullName (String fullName) {
        $(NAME_FIELD_XPATH).sendKeys(fullName);
    }
    @Step("Fill title in the title field.")
    public void fillTitle (String title) {
        $(TITLE_FIELD_XPATH).sendKeys(title);
    }
    @Step("Fill email in the email field.")
    public void fillEmail (String email) {
        $(EMAIL_FIELD_XPATH).sendKeys(email);
    }
    @Step("Fill phone in the phone field.")
    public void fillPhoneNumber (String phoneNumber) {
        $(PHONE_FIELD_XPATH).sendKeys(phoneNumber);
    }
    @Step("Fill Address1 in the Address1 field.")
    public void fillAddress1 (String streetAddress1) {
        $(STREET1_FIELD_XPATH).sendKeys(streetAddress1);
    }
    @Step("Fill Address2 in the Address1 field.")
    public void fillAddress2 (String streetAddress2) {
        $(STREET2_FIELD_XPATH).sendKeys(streetAddress2);
    }
    @Step("Fill zip code in the zip code field.")
    public void fillZipcode (String zipCode) {
        $(ZIP_CODE_FIELD_XPATH).sendKeys(zipCode);
    }
    @Step("Fill city in the city field.")
    public void fillCity (String city) {
        $(CITY_FIELD_XPATH).sendKeys(city);
    }
    @Step("Click on the 'state' dropdown")
    public void clickOnStateDropdown () {
        $(STATE_DROPDOWN_FIELD_XPATH).click();
    }
    @Step("Click on the 'state' dropdown")
    public void selectStateDropdown (String state) {
        click(STATE_DROPDOWN_ELEMENT_FIELD_XPATH, state);
    }
    @Step("Fill password field.")
    public void fillPasswordFieldWith(String password) {
        $(PASSWORD_FIELD_XPATH).sendKeys(password);
    }
    @Step("Click on Login button.")
    public void clickOnLoginButton() {
        $(LOG_IN_BUTTON_XPATH).click();
    }

    @Step("Fill email address to send invoice field.")
    public void emailAddressToSendInvoice (String emailToSendInvoice) {
        $(EMAIL_TO_SEND_INVOICE_FIELD_XPATH).sendKeys(emailToSendInvoice);
    }
    @Step("Click on 'TaxExempt' radio-button")
    public void clickOnTaxExemptRadioButton (String radioButton) {
        click(TAX_EXEMPT_RADIO_BUTTON_XPATH, radioButton);
    }
    @Step("Click on 'Your billing address is different'  radio-button")
    public void clickOnYourBillingAddressIsDifferentRadioButton (String radioButton) {
        click(BILLING_ADDRESS_DIFFERENT_RADIO_BUTTON_XPATH, radioButton);
    }
    @Step("Click on 'Your shipping address is different radio-button")
    public void clickOnShippingAddressDifferentRadioButton (String radioButton) {
        click(SHIPPING_ADRESS_DIFFERENT_RADIO_BUTTON_XPATH, radioButton);
    }
    @Step("Click on 'Preferred form of payment radio-button")
    public void clickOnPreferredFormOfPaymentRadioButton (String radioButton) {
        click(FORM_OF_PAYMENT_RADIO_BUTTON_XPATH, radioButton);
    }
    @Step("Click on Get Qualified button.")
    public void clickOnGetQualifiedButton() {
        $(GET_QUALIFIED_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }
    @Step("Click on Sign Up button.")
    public void clickOnSignUpButton() {
        $(SIGN_UP_BUTTON_XPATH).click();
    }
    @Step("Check that current url is Login page url.")
    private boolean isCurrentURLEqualsToLoginPageURL() {
        return getPageUrl().equals(getCurrentUrl());
    }
    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

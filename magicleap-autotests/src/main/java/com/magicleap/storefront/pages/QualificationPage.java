package com.magicleap.storefront.pages;

import com.magicleap.helpers.models.users.UserSession;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.magicleap.storefront.page_elements.LoginPageElements.*;
import static com.magicleap.storefront.page_elements.QualificationPageElements.*;

@Component
public class QualificationPage extends StorefrontBasePage {
    private final String pageUrlMethod = "/#/signup";

    public boolean isOpened() {
        return isCurrentURLEqualsToLoginPageURL() && isUserLoggedOut();
    }

    @Step("Fill legal company name.")
    public void fillLegalCompanyName (String legalCompanyName) {
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
    @Step("Click on 'Corporation' radio-button")
    public void clickOnCorporationRadioButton () {
        $(CORPORATION_RADIO_BUTTON_XPATH).click();
    }
    @Step("Click on 'Corporation' radio-button")
    public void clickOnPriorBusinessDealingsRadioButton () {
        $(PRIOR_DEALING_RADIO_BUTTON_NO_XPATH).click();
    }
    @Step("Click on 'Market segment' dropdown")
    public void clickOnMarletSegmentDropdown () {
        $(MARKET_SEGMENT_DROPDOWN_XPATH).click();
    }
    @Step("Click on login Button on qualification page")
    public void clickOnLoginButtonQualificationPage () {
        $(NEXT_BUTTON_XPATH).click();
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
    @Step("Click on Sign Up button.")
    public void clickTaxExemptRadioButton() {
        $(SIGN_UP_BUTTON_XPATH).click();
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

    @Step("Click on 'TaxExempt' yes radio-button")
    public void clickOnTaxExemptYesRadioButton () {
        $(TAX_EXEMPT_YES_RADIO_BUTTON_XPATH).click();
    }
    @Step("Click on 'Your address is different' no radio-button")
    public void clickOnYourAddressIsDifferentYesRadioButton () {
        $(BILLING_ADRESS_DIFFERENT_NO_RADIO_BUTTON_XPATH).click();
    }

    @Step("Click on 'Is your shipping address  yes radio-button")
    public void clickOnIsyourYesRadioButton () {
        $(SHIPPING_ADRESS_YES_RADIO_BUTTON_XPATH).click();
    }
    @Step("Click on 'Preferred form of payment Credit Card radio-button")
    public void clickOnPreferredFormOfPaymentCreditCardRadioButton () {
        $(FORM_OF_PAYMENT_CREDIT_CARD_RADIO_BUTTON_XPATH).click();
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

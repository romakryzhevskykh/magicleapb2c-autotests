package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.CheckoutPaymentMethodStepBlockElements.*;

@Component
public class CheckoutPaymentMethodStepBlock extends UIComponent {

    private String pageUrlMethod = "multi/payment-method/add";

    @Step("Click on Next button on Checkout Payment method step.")
    public void clickOnNextButton() {
        click(By.id(NEXT_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    @Step("Select Card payment type on Checkout Payment method step.")
    public void selectCardPaymentType() {
        click(CARD_PAYMENT_CHECKBOX_XPATH);
        waitUntilElementIsVisible(By.id(CARD_ACCOUNT_NUMBER_FIELD_ID));
    }

    @Step("Is Card payment type checkbox visible?")
    public boolean isCardPaymentTypeVisible() {
        return isDisplayed(CARD_PAYMENT_CHECKBOX_XPATH);
    }

    @Step("Select Invoice payment type on Checkout Payment method step.")
    public void selectInvoicePaymentType() {
        click(INVOICE_PAYMENT_CHECKBOX_XPATH);
    }

    @Step("Is Invoice payment type checkbox visible?")
    public boolean isInvoicePaymentTypeVisible() {
        return isDisplayed(INVOICE_PAYMENT_CHECKBOX_XPATH);
    }

    @Step("Is Card number text field visible?")
    public boolean isCardNumberTextFieldVisible() {
        return isDisplayed(By.id(CARD_ACCOUNT_NUMBER_FIELD_ID));
    }

    @Step("Is Expire month drop-down visible?")
    public boolean isExpireMonthDropDownVisible() {
        return isDisplayed(By.id(CARD_EXPIRY_MONTH_DROP_DOWN_ID));
    }

    @Step("Is Expire year drop-down visible?")
    public boolean isExpireYearDropDownVisible() {
        return isDisplayed(By.id(CARD_EXPIRY_YEAR_DROP_DOWN_ID));
    }

    @Step("Is Name on card text field visible?")
    public boolean isNameOnCardTextFieldVisible() {
        return isDisplayed(By.id(CARD_NAME_ON_CARD_FIELD_ID));
    }

    @Step("Is Card CVV code text field visible?")
    public boolean isCVVCodeTextFieldVisible() {
        return isDisplayed(By.id(CARD_CVV_CODE_FIELD_ID));
    }

    @Step("Is Save card checkbox visible?")
    public boolean isSaveCardCheckboxVisible() {
        return isDisplayed(By.id(CARD_SAVE_PAYMENT_METHOD_CHECKBOX_ID));
    }

    @Step("Is Purchase order number text field visible?")
    public boolean isPurchaseOrderNumberFieldVisible() {
        return isDisplayed(By.id(PURCHASE_ORDER_NUMBER_FIELD_ID));
    }

    @Step("Is Comment text field visible?")
    public boolean isCommentFieldVisible() {
        return isDisplayed(By.id(COMMENT_FIELD_ID));
    }

    @Step("Fill Purchase order number text field with text {0}.")
    public void fillPONWithText(String randomPON) {
        enterText(randomPON, By.id(PURCHASE_ORDER_NUMBER_FIELD_ID));
    }

    public String getPageUrlMethod() {
        return pageUrlMethod;
    }

    @Step("Enter text to Card number field: {0}.")
    public void fillCardNumberField(String cardNumber) {
        enterText(cardNumber, By.id(CARD_ACCOUNT_NUMBER_FIELD_ID));
    }

    @Step("Open Expiry month drop-down.")
    public void clickOnExpiryMonthDropDown() {
        click(By.id(CARD_EXPIRY_MONTH_DROP_DOWN_ID));
    }

    @Step("Select Expiry month in Expiry month drop-down: {0}.")
    public void selectExpiryMonth(String expiryMonth) {
        click(CARD_EXPIRY_MONTH_ITEM_BY_VALUE_XPATH, expiryMonth);
    }

    @Step("Open Expiry year drop-down.")
    public void clickOnExpiryYearDropDown() {
        click(By.id(CARD_EXPIRY_YEAR_DROP_DOWN_ID));
    }

    @Step("Select Expiry yesr in Expiry year drop-down: {0}.")
    public void selectExpiryYear(String expiryYear) {
        click(CARD_EXPIRY_YEAR_ITEM_BY_VALUE_XPATH, expiryYear);
    }

    @Step("Enter text to Name on card field: {0}.")
    public void fillNameOnCard(String nameOnCard) {
        enterText(nameOnCard, By.id(CARD_NAME_ON_CARD_FIELD_ID));
    }

    @Step("Enter text to CVV field: {0}.")
    public void fillCVV(String cvv) {
        enterText(cvv, By.id(CARD_CVV_CODE_FIELD_ID));
    }

    @Step("Click on CHANGE BILLING ADDRESS FOR THIS ORDER ONLY checkbox.")
    public void clickOnChangeBillingAddress() {
        click(CHANGE_BILLING_ADDRESS_CHECKBOX_XPATH);
    }

    @Step("Click on BILLING ADDRESS IS THE SAME AS SHIPPING ADDRESS checkbox.")
    public void clickOnUseTheSameBillingAddressCheckox() {
        click(BILLING_ADDRESS_IS_THE_SAME_AS_SHIPPING_ADDRESS_CHECKBOX_XPATH);
    }

    @Step("Deselect BILLING ADDRESS IS THE SAME AS SHIPPING ADDRESS checkbox.")
    public void deselectGuestBillingAddressCheckbox() {
        if($(BILLING_ADDRESS_IS_THE_SAME_AS_SHIPPING_ADDRESS_CHECKBOX_XPATH).isSelected()) {
            clickOnUseTheSameBillingAddressCheckox();
        }
    }

    @Step("Select BILLING ADDRESS IS THE SAME AS SHIPPING ADDRESS checkbox.")
    public void selectGuestBillingAddressCheckbox() {
        if(!$(BILLING_ADDRESS_IS_THE_SAME_AS_SHIPPING_ADDRESS_CHECKBOX_XPATH).isSelected()) {
            clickOnUseTheSameBillingAddressCheckox();
        }
    }

    @Step("Get any Billing address country from drop-down.")
    public String getAnyCountryFromBillingAddressCountiesDropDown() {
        return $$(ITEMS_IN_BILLING_ADDRESS_COUNTRY_DROP_DOWN_XPATH).stream().findAny().get().getAttribute("value");
    }

    @Step("Select {0} in Billing address country drop-down.")
    public void selectBillingAddressCountryFromCountiesDropDown(String country) {
        click(ITEM_IN_BILLING_ADDRESS_COUNTRY_DROP_DOWN_BY_VALUE_XPATH, country);
    }

    @Step("Open Billing address countries drop-down.")
    public void openBillingAddressCountriesDropDown() {
        click(By.id(SELECT_BILLING_ADDRESS_COUNTRY_DROP_DOWN_ID));
    }

    @Step("Open Billing address states drop-down.")
    public void openBillingAddressStatesDropDown() {
        click(By.id(BILLING_ADDRESS_STATE_DROP_DOWN_ID));
    }

    @Step("Select {0} in Billing address state drop-down.")
    public void selectBillingAddressStateFromTitlesDropDown(String state) {
        click(ITEM_IN_BILLING_ADDRESS_STATE_DROP_DOWN_BY_VALUE_XPATH, state);
    }

    @Step("Enter Billing address First name: {0}.")
    public void fillBillingAddressFirstName(String firstName) {
        enterText(firstName, By.id(BILLING_ADDRESS_FIRST_NAME_FIELD_ID));
    }

    @Step("Enter Billing address Last name: {0}.")
    public void fillBillingAddressLastName(String lastName) {
        enterText(lastName, By.id(BILLING_ADDRESS_LAST_NAME_FIELD_ID));
    }

    @Step("Enter Billing address Address line 1: {0}.")
    public void fillBillingAddressAddressLine1(String addressLine1) {
        enterText(addressLine1, By.id(BILLING_ADDRESS_ADDRESS_LINE_1_FIELD_ID));
    }

    @Step("Enter Billing address Address line 2: {0}.")
    public void fillBillingAddressAddressLine2(String addressLine2) {
        enterText(addressLine2, By.id(BILLING_ADDRESS_ADDRESS_LINE_2_FIELD_ID));
    }

    @Step("Enter Billing address Town: {0}.")
    public void fillBillingAddressTown(String town) {
        enterText(town, By.id(BILLING_ADDRESS_TOWN_CITY_FIELD_ID));
    }

    @Step("Enter Billing address Zip code: {0}.")
    public void fillBillingAddressZipCode(String zipCode) {
        enterText(zipCode, By.id(BILLING_ADDRESS_POSTCODE_FIELD_ID));
    }

    @Step("Enter Billing address Phone number: {0}.")
    public void fillBillingAddressPhoneNumber(String phoneNumber) {
        enterText(phoneNumber, By.id(BILLING_ADDRESS_PHONE_FIELD_ID));
    }
}

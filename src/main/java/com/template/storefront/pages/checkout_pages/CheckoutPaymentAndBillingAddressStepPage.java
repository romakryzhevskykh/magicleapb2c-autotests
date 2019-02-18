package com.template.storefront.pages.checkout_pages;

import com.template.helpers.models.credit_cards.CardType;
import com.template.helpers.models.users.UserTitle;
import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.checkout_page_elements.CheckoutPaymentAndBillingAddressPageElements.*;

@Component
public class CheckoutPaymentAndBillingAddressStepPage extends StorefrontBasePage {

    private final String pageUrlMethod = "checkout/multi/payment-method/add";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().startsWith(getPageUrl());
    }

    @Step("Is Use My Shipping Address as default checkbox selected?")
    public boolean isUseMyShippingAddressCheckboxSelected() {
        return $(By.id(USE_MY_SHIPPING_ADDRESS_CHECKBOX_ID)).isSelected();
    }

    @Step("Click on Use my shipping address checkbox.")
    public void clickOnUseMyShippingAddressCheckbox() {
        $(By.id(USE_MY_SHIPPING_ADDRESS_CHECKBOX_ID)).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Fill First name with: {0}.")
    public void fillFirstNameField(String firstName) {
        $(By.id(FIRST_NAME_FIELD_ID)).enterText(firstName);
    }

    @Step("Select country {0}.")
    public void selectCountry(String country) {
        $(By.id(COUNTRY_DROP_DOWN_ID)).selectByVisibleText(country);
    }

    @Step("Select title from Title drop-down: {0}.")
    public void selectTitleFromDropDown(UserTitle userTitle) {
        $(By.id(TITLE_DROPDOWN_ID)).selectByVisibleText(userTitle.getTitleText());
    }

    @Step("Fill Last name with: {0}.")
    public void fillLastNameField(String lastName) {
        $(By.id(LAST_NAME_FIELD_ID)).enterText(lastName);
    }

    @Step("Fill Address Line 1 field with: {0}.")
    public void fillAddress1Field(String address1) {
        $(By.id(ADDRESS1_FIELD_ID)).enterText(address1);
    }

    @Step("Fill Address Line 2 field with: {0}.")
    public void fillAddress2Field(String address2) {
        $(By.id(ADDRESS2_FIELD_ID)).enterText(address2);
    }

    @Step("Fill City field with: {0}.")
    public void fillCityField(String city) {
        $(By.id(CITY_ID)).enterText(city);
    }

    @Step("Fill Postcode field with: {0}.")
    public void fillPostcodeField(String postcode) {
        $(By.id(POSTCODE_FIELD_ID)).enterText(postcode);
    }

    @Step("Select state from State drop-down: {0}.")
    public void selectStateFromDropDown(String state) {
        $(By.id(STATE_DROP_DOWN_ID)).selectByVisibleText(state);
    }

    @Step("Click on Next button.")
    public void clickOnNextButton() {
        $(NEXT_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Enter a credit card number: {0}.")
    public void fillTheCreditCardNumberField(String creditCardNumber) {
        $(By.id(CARD_NUMBER_FIELD_ID)).enterText(creditCardNumber);
    }

    @Step("Select Year expiration from drop-down: {0}.")
    public void selectYearExpirationFromDropDown(String year) {
        $( By.id(EXPIRY_YEAR_DROPDOWN_ID)).selectByVisibleText(year);
    }

    @Step("Select Month expiration from drop-down: {0}.")
    public void selectMonthExpirationFromDropDown(String month) {
        $(By.id(EXPIRY_MONTH_DROPDOWN_ID)).selectByVisibleText(month);
    }

    @Step("Fill the CVV field: {0}.")
    public void fillTheCVVField(String cvv) {
        $(By.id(CVV_FIELD_ID)).enterText(cvv);
    }

    @Step("Is Save payment method checkbox selected?")
    public boolean isSavePaymentMethodCheckboxSelected() {
        return $(By.id(SAVE_CARD_CHECKBOX_ID)).isSelected();
    }

    @Step("Click on Save payment method checkbox.")
    public void clickOnSavePaymentMethodCheckbox() {
        $(By.id(SAVE_CARD_CHECKBOX_ID)).click();
    }

    @Step("Select card type: {0}.")
    public void selectCardType(CardType cardType) {
        $(By.id(CARD_TYPE_DROPDOWN_ID)).selectByVisibleText(cardType.getName());
    }
}

package com.template.storefront.pages.checkout_pages;

import com.template.helpers.models.users.UserTitle;
import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.checkout_page_elements.CheckoutShippingAddressPageElements.*;

@Component
public class CheckoutShippingAddressStepPage extends StorefrontBasePage {

    private String pageUrlMethod = "checkout/multi/delivery-address/add";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().startsWith(getPageUrl());
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

    @Step("Fill Telephone field with: {0}.")
    public void fillTelephoneField(String telephone) {
        $(By.id(TELEPHONE_FIELD_ID)).enterText(telephone);
    }

    @Step("Click on Next button.")
    public void clickOnNextButton() {
        $(By.id(NEXT_BUTTON_ID)).click();
        waitUntilPageIsFullyLoaded();
    }
}

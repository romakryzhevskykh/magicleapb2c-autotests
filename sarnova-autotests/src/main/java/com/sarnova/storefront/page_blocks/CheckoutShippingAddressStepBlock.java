package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.CheckoutShippingAddressStepBlockElements.*;

@Component
public class CheckoutShippingAddressStepBlock extends UIComponent {

    private String pageUrlMethod = "multi/delivery-address/add";

    @Step("Click on Next button on Checkout Shipping address step.")
    public void clickOnNextButton() {
        click(By.id(NEXT_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    public String getPageUrlMethod() {
        return pageUrlMethod;
    }

    @Step("Select Create new shipping address checkbox.")
    public void selectCreateNewShippingAddress() {
        click(CREATE_NEW_SHIPPING_ADDRESS_CHECKBOX_XPATH);
    }

    @Step("Get any country from drop-down.")
    public String getAnyCountryFromCountiesDropDown() {
        return $$(ITEMS_IN_COUNTRY_DROP_DOWN_XPATH).stream().findAny().get().getAttribute("value");
    }

    @Step("Select {0} in country drop-down.")
    public void selectCountryFromCountiesDropDown(String country) {
        click(ITEM_IN_COUNTRY_DROP_DOWN_BY_VALUE_XPATH, country);
    }

    @Step("Open countries drop-down.")
    public void openCountriesDropDown() {
        click(By.id(SELECT_COUNTRY_DROP_DOWN_ID));
    }

    @Step("Open titles drop-down.")
    public void openTitlesDropDown() {
        click(By.id(SELECT_TITLE_DROP_DOWN_ID));
    }

    @Step("Select {0} in title drop-down.")
    public void selectTitleFromTitlesDropDown(String title) {
        click(ITEM_IN_TITLE_DROP_DOWN_BY_VALUE_XPATH, title);
    }

    @Step("Open states drop-down.")
    public void openStatesDropDown() {
        click(By.id(STATE_DROP_DOWN_ID));
    }

    @Step("Select {0} in state drop-down.")
    public void selectStateFromTitlesDropDown(String state) {
        click(ITEM_IN_STATE_DROP_DOWN_BY_VALUE_XPATH, state);
    }

    @Step("Enter First name: {0}.")
    public void fillFirstName(String firstName) {
        enterText(firstName, By.id(FIRST_NAME_FIELD_ID));
    }

    @Step("Enter Last name: {0}.")
    public void fillLastName(String lastName) {
        enterText(lastName, By.id(LAST_NAME_FIELD_ID));
    }

    @Step("Enter Address line 1: {0}.")
    public void fillAddressLine1(String addressLine1) {
        enterText(addressLine1, By.id(ADDRESS_LINE_1_FIELD_ID));
    }

    @Step("Enter Address line 2: {0}.")
    public void fillAddressLine2(String addressLine2) {
        enterText(addressLine2, By.id(ADDRESS_LINE_2_FIELD_ID));
    }

    @Step("Enter Town: {0}.")
    public void fillTown(String town) {
        enterText(town, By.id(TOWN_CITY_FIELD_ID));
    }

    @Step("Enter Zip code: {0}.")
    public void fillZipCode(String zipCode) {
        enterText(zipCode, By.id(POSTCODE_FIELD_ID));
    }

    @Step("Enter Phone number: {0}.")
    public void fillPhoneNumber(String phoneNUmber) {
        enterText(phoneNUmber, By.id(PHONE_FIELD_ID));
    }

    @Step("Wait until Country checkbox is disappeared.")
    public void waitUntilCountryCheckboxIsDisappeared() {
        waitUntil(driver1 -> !isDisplayed(By.id(SELECT_COUNTRY_DROP_DOWN_ID)));
    }
}

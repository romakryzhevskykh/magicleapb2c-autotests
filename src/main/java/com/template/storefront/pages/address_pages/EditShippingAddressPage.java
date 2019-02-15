package com.template.storefront.pages.address_pages;

import com.template.helpers.models.users.User;
import com.template.helpers.models.users.UserTitle;
import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

import static com.template.storefront.page_elements.address_page.EditAddressPageElements.*;

@Component
public class EditShippingAddressPage extends StorefrontBasePage {

    private final String pageUrlMethod = "powertools/en/USD/my-account/edit-address/%s";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUrlMethod);
    }

    public String getPageUrl(User.UserShippingAddress userShippingAddress) {
        return storefrontProject.getBaseUrl().concat(String.format(pageUrlMethod, userShippingAddress.getId()));
    }

    public void open(User.UserShippingAddress userShippingAddress) {
        open(getPageUrl(userShippingAddress));
    }

    @Step("Select country {0}")
    public void selectCountry(String country) {
        $(By.id(COUNTRY_DROPDOWN_ID)).selectByVisibleText(country);
    }

    @Step("Select title {0}")
    public void selectTitle(UserTitle userTitle) {
        $(By.id(TITLE_DROPDOWN_ID)).selectByVisibleText(userTitle.getTitleText());
    }

    @Step("Enter text: {0} to Address line 1 field.")
    public void fillAddressLine1(String street) {
        $(By.id(ADDRESS1_FIELD_ID)).enterText(street);
    }

    @Step("Enter text: {0} to Address line 2 field.")
    public void fillAddressLine2(String street) {
        $(By.id(ADDRESS2_FIELD_ID)).enterText(street);
    }

    @Step("Enter text: {0} to City field.")
    public void fillCity(String city) {
        $(By.id(CITY_ID)).enterText(city);
    }

    @Step("Enter text: {0} to Zip code field.")
    public void fillZipCode(String zipCode) {
        $(By.id(POSTCODE_FIELD_ID)).enterText(zipCode);
    }

    @Step("Fill first name {0}.")
    public void fillFirstName(String firstName) {
        $(By.id(FIRST_NAME_FIELD_ID)).enterText(firstName);
    }

    @Step("Fill last name {0}")
    public void fillLastName(String lastName) {
        $(By.id(LAST_NAME_FIELD_ID)).enterText(lastName);
    }

    @Step("Fill state {0}")
    public void fillState(String state) {
        $(By.id(STATE_DROPDOWN_ID)).selectByVisibleText(state);
    }

    @Step("Enter text: {0} to Telephone field.")
    public void fillTelephone(String telephone) {
        $(By.id(TELEPHONE_FIELD_ID)).enterText(telephone);
    }

    @Step("Click on Save button.")
    public void clickOnSaveButton() {
        $(SAVE_ADDRESS_BUTTON_XPATH).click();
    }

    @Step("Get flash/info message.")
    public String getFlashInfoMessage() {
        if (withTimeOutOf(5, TimeUnit.SECONDS).isPresent(INFO_FLASH_MESSAGE_XPATH)) {
            return $(INFO_FLASH_MESSAGE_XPATH).getText();
        } else {
            return $(FLASH_MESSAGE_XPATH).getTextNode();
        }
    }

    @Step("Click on Cancel button.")
    public void clickOnCancelButton() {
        $(CANCEL_BUTTON_XPATH).click();
    }

    public boolean isOpened(User.UserShippingAddress userShippingAddress) {
        return getCurrentUrl().equals(String.format(getPageUrl(), userShippingAddress.getId()));
    }

}

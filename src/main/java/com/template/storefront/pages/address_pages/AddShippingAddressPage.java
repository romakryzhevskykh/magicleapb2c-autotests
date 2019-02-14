package com.template.storefront.pages.address_pages;

import com.template.helpers.models.users.UserTitle;
import com.template.storefront.page_blocks.AddressBookAddUpdateEntryBlock;
import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

import static com.template.storefront.page_elements.address_page.AddAddressPageElements.*;

@Component
public class AddShippingAddressPage extends StorefrontBasePage {

    @Autowired private AddressBookAddUpdateEntryBlock addressBookAddUpdateEntryBlock;

    private final String pageUrlMethod = "powertools/en/USD/my-account/add-address";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Is Title displayed?")
    public boolean isTitleDisplayed() {
        return $(PAGE_HEADER_TITLE_XPATH).isDisplayed();
    }

    @Step("Get page title text.")
    public String getTitleText() {
        return $(PAGE_HEADER_TITLE_XPATH).getText();
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
    @Step("Enter text: {0} to City field.")
    public void fillCity(String city) {
        $(By.id(CITY_ID)).enterText(city);
    }

    @Step("Enter text: {0} to Zip code field.")
    public void fillZipCode(String zipCode) {
        $(By.id(POSTCODE_FIELD_ID)).enterText(zipCode);
    }

    @Step("Click on Save button.")
    public void clickOnSaveButton() {
        addressBookAddUpdateEntryBlock.clickOnSaveButton();
    }

    @Step("Get flash/info message.")
    public String getFlashInfoMessage() {
        if (withTimeOutOf(5,TimeUnit.SECONDS).isPresent(INFO_FLASH_MESSAGE_XPATH)) {
            return $(INFO_FLASH_MESSAGE_XPATH).getText();
        } else {
            return $(FLASH_MESSAGE_XPATH).getTextNode();
        }
    }

    @Step("Fill first name {0}.")
    public void fillFirstName(String firstName) {
        addressBookAddUpdateEntryBlock.fillFirstNameWithText(firstName);
    }

    @Step("Fill last name {0}")
    public void fillLastName(String lastName) {
        addressBookAddUpdateEntryBlock.fillLastNameWithText(lastName);
    }

    @Step("Fill state {0}")
    public void fillState(String state) {
        $(By.id(STATE_DROPDOWN_ID)).selectByVisibleText(state);
    }
}

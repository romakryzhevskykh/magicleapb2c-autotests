package com.topcon.storefront.pages;

import com.topcon.helpers.user_engine.UserSession;
import com.topcon.storefront.managers.AddressBookEntriesManager;
import com.topcon.storefront.models.AddressBookEntry;
import com.topcon.storefront.page_blocks.AddressBookAddUpdateEntryBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static com.topcon.storefront.page_elements.AddressBookPageElements.*;

@Component
public class AddressBookPage extends StorefrontBasePage {
    @Autowired private AddressBookEntriesManager addressBookEntriesManager;
    @Autowired private AddressBookAddUpdateEntryBlock addressBookAddUpdateEntryBlock;

    private final String pageUrlMethod = "powertools/en/USD/my-account/address-book";

    @Step("Get text of header section on address book page.")
    public String getSectionHeader() {
        return $(SECTION_HEADER_XPATH).getText().trim();
    }

    @Step("Get all shipping addresses on address book page.")
    public ArrayList<AddressBookEntry> getAddressesList(UserSession userSession) {
        ArrayList<AddressBookEntry> userAddresses = new ArrayList<>();
        for (WebElement address : $$(By.xpath(ADDRESSES_INFO_ITEMS_TEXT_XPATH))) {
            AddressBookEntry userAddress = addressBookEntriesManager.parseAddressFromHTML(address, userSession.getUser());
            userAddresses.add(userAddress);
        }
        return userAddresses;
    }


    public void selectCountryFromDropDown(String countryName) {
        addressBookAddUpdateEntryBlock.selectCountryFromDropDown(countryName);
    }

    public void clickOnCountryDropDown() {
        addressBookAddUpdateEntryBlock.clickOnCountryDropDown();
    }

    public String getRandomCountryFromDropDown() {
        return addressBookAddUpdateEntryBlock.getRandomCountryFromDropDown();
    }

    public String getRandomTitleFromDropDown() {
        return addressBookAddUpdateEntryBlock.getRandomTitleFromDropDown();
    }

    public void selectTitleFromDropDown(String titleName) {
        addressBookAddUpdateEntryBlock.selectTitleFromDropDown(titleName);
    }

    public void clickOnTitleDropDown() {
        addressBookAddUpdateEntryBlock.clickOnTitleDropDown();
    }

    public void fillFirstName(String firstName) {
        addressBookAddUpdateEntryBlock.fillFirstNameWithText(firstName);
    }

    public void fillLastName(String lastName) {
        addressBookAddUpdateEntryBlock.fillLastNameWithText(lastName);
    }

    public void fillAddress1With(String address1) {
        addressBookAddUpdateEntryBlock.fillAddress1WithText(address1);
    }

    public void fillTownWith(String towm) {
        addressBookAddUpdateEntryBlock.fillTownWithText(towm);
    }

    public void fillPostCode(String postCode) {
        addressBookAddUpdateEntryBlock.fillPostCodeWithText(postCode);
    }

    public void clickOnSaveButton() {
        addressBookAddUpdateEntryBlock.clickOnSaveButton();
    }

    public boolean isAlertOnCreateNewAddress() {
        return addressBookAddUpdateEntryBlock.isAlertDisplayed();
    }

    @Step("Click on Add Address button.")
    public void clickOnAddAddressButton() {
        click(ADD_ADDRESS_BUTTON_XPATH);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

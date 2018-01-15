package com.template.storefront.pages;

import com.template.helpers.user_engine.User;
import com.template.storefront.managers.AddressBookEntriesManager;
import com.template.storefront.models.AddressBookEntry;
import com.template.storefront.page_blocks.AddressBookAddUpdateEntryBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static com.template.storefront.page_elements.AddressBookPageElements.*;

@Component
public class AddressBookPage extends StorefrontBasePage {
    @Autowired AddressBookEntriesManager addressBookEntriesManager;
    @Autowired AddressBookAddUpdateEntryBlock addressBookAddUpdateEntryBlock;

    private final String pageUrlMethod = "powertools/en/USD/my-account/address-book";

    @Step("Get text of header section on address book page.")
    public String getSectionHeader() {
        return $(SECTION_HEADER_XPATH).getText().trim();
    }

    @Step("Get all shipping addresses on address book page.")
    public ArrayList<AddressBookEntry> getAddressesList() {
        ArrayList<AddressBookEntry> userAddresses = new ArrayList<>();
        for (WebElement address : $$(By.xpath(ADDRESSES_INFO_ITEMS_TEXT_XPATH))) {
            AddressBookEntry userAddress = addressBookEntriesManager.parseAddressFromHTML(address);
            userAddresses.add(userAddress);
        }
        return userAddresses;
    }

    @Step("Add new random address to Address Book.")
    public void addNewRandomAddress(User activeUser) {
        clickOnAddAddressButton();
        addressBookAddUpdateEntryBlock.clickOnCountryDropDown();
        addressBookAddUpdateEntryBlock.selectRandomCountryFromDropDown();
        addressBookAddUpdateEntryBlock.clickOnTitleDropDown();
        addressBookAddUpdateEntryBlock.selectRandomTitleFromDropDown();
        addressBookAddUpdateEntryBlock.fillFirstNameWithRandomText();
        addressBookAddUpdateEntryBlock.fillLastNameWithRandomText();
        addressBookAddUpdateEntryBlock.fillAddress1WithRandomText();
        addressBookAddUpdateEntryBlock.fillTownWithRandomText();
        addressBookAddUpdateEntryBlock.fillPostCodeWithRandomText();
        addressBookAddUpdateEntryBlock.clickOnSaveButton(activeUser);
    }

    @Step("Click on Add Address button.")
    public void clickOnAddAddressButton() {
        $(ADD_ADDRESS_BUTTON_XPATH).click();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

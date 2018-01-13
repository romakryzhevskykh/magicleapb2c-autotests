package com.template.storefront.pages;

import com.template.helpers.user_engine.User;
import com.template.storefront.managers.AddressBookEntriesManager;
import com.template.storefront.models.AddressBookEntry;
import org.apache.commons.lang3.RandomStringUtils;
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
        clickOnCountryDropDown();
        selectRandomCountryFromDropDown();
        clickOnTitleDropDown();
        selectRandomTitleFromDropDown();
        fillFirstNameWithRandomText();
        fillLastNameWithRandomText();
        fillAddress1WithRandomText();
        fillTownWithRandomText();
        fillPostCodeWithRandomText();
        clickOnSaveButton(activeUser);
    }

    @Step("Click on Add Address button.")
    public void clickOnAddAddressButton() {
        $(ADD_ADDRESS_BUTTON_XPATH).click();
    }

    @Step("Click on Country drop-down")
    public void clickOnCountryDropDown() {
        $(By.id(COUNTRY_DROP_DOWN_ID)).click();
    }

    @Step("Select any Country from Country drop-down list")
    public void selectRandomCountryFromDropDown() {
        String randomCountryName = $$(COUNTRIES_IN_DROP_DOWN_XPATH).stream().findAny().get().getText();
        selectCountryFromDropDown(randomCountryName);
    }

    @Step("Select Country from Country drop-down list")
    public void selectCountryFromDropDown(String countryName) {
        $(COUNTRY_IN_DROP_DOWN_BY_NAME_XPATH, countryName.toLowerCase()).click();
        threadVarsHashMap.put("newAddressCountry", countryName);
    }

    @Step("Click on Title drop-down")
    public void clickOnTitleDropDown() {
        $(By.id(TITLE_DROP_DOWN_ID)).click();
    }

    @Step("Select any Title from Title drop-down list")
    public void selectRandomTitleFromDropDown() {
        String randomTitleName = $$(TITLES_IN_DROP_DOWN_XPATH).stream().findAny().get().getText();
        selectTitleFromDropDown(randomTitleName);
    }

    @Step("Select Title from Title drop-down list")
    public void selectTitleFromDropDown(String titleName) {
        $(TITLE_IN_DROP_DOWN_BY_NAME_XPATH, titleName.toLowerCase()).click();
        threadVarsHashMap.put("newAddressTitle", titleName);
    }

    @Step("Fill First name field with random text.")
    public void fillFirstNameWithRandomText() {
        String randomFirstName = RandomStringUtils.randomAlphabetic(10);
        fillFirstNameWithText(randomFirstName);
    }

    @Step("Fill First name field with text.")
    public void fillFirstNameWithText(String firstName) {
        $(By.id(FIRST_NAME_FIELD_ID)).sendKeys(firstName);
        threadVarsHashMap.put("newAddressFirstName", firstName);
    }

    @Step("Fill Last name field with random text.")
    public void fillLastNameWithRandomText() {
        String randomLastName = RandomStringUtils.randomAlphabetic(10);
        fillLastNameWithText(randomLastName);
    }

    @Step("Fill Last name field with text.")
    public void fillLastNameWithText(String lastName) {
        $(By.id(LAST_NAME_FIELD_ID)).sendKeys(lastName);
        threadVarsHashMap.put("newAddressLastName", lastName);
    }

    @Step("Fill Address 1 field with random text.")
    public void fillAddress1WithRandomText() {
        String randomAddress1 = RandomStringUtils.randomAlphabetic(10);
        fillAddress1WithText(randomAddress1);
    }

    @Step("Fill Address 1 field with text.")
    public void fillAddress1WithText(String address1) {
        $(By.id(ADDRESS_LINE_1_FIELD_ID)).sendKeys(address1);
        threadVarsHashMap.put("newAddressAddress1", address1);
    }

    @Step("Fill TOWN field with random text.")
    public void fillTownWithRandomText() {
        String randomTown = RandomStringUtils.randomAlphabetic(10);
        fillTownWithText(randomTown);
    }

    @Step("Fill TOWN field with text.")
    public void fillTownWithText(String townName) {
        $(By.id(TOWN_FIELD_ID)).sendKeys(townName);
        threadVarsHashMap.put("newAddressTown", townName);
    }

    @Step("Fill Post code with random text.")
    public void fillPostCodeWithRandomText() {
        String randomPostCode = RandomStringUtils.randomNumeric(5) + "-" + RandomStringUtils.randomNumeric(4);
        fillPostCodeWithText(randomPostCode);
    }

    @Step("Fill Post code field with text.")
    public void fillPostCodeWithText(String postCode) {
        $(By.id(POST_CODE_FIELD_ID)).sendKeys(postCode);
        threadVarsHashMap.put("newAddressPostCode", postCode);
    }

    @Step("Click on Save button.")
    public void clickOnSaveButton(User activeUser) {
        $(SAVE_ADDRESS_BUTTON_XPATH).click();
        if (!isDisplayed(ALERT_ERROR_MESSAGE_XPATH)) {
            AddressBookEntry.AddressBookEntryBuilder addressBookEntryBuilder =
                    new AddressBookEntry.AddressBookEntryBuilder(activeUser.getUserCredentials())
                            .country(threadVarsHashMap.getString("newAddressCountry"))
                            .title(threadVarsHashMap.getString("newAddressTitle"))
                            .firstName(threadVarsHashMap.getString("newAddressFirstName"))
                            .lastName(threadVarsHashMap.getString("newAddressLastName"))
                            .addressLine1(threadVarsHashMap.getString("newAddressAddress1"))
                            .addressLine2(threadVarsHashMap.getString("newAddressAddress1"))
                            .town(threadVarsHashMap.getString("newAddressAddress1"))
                            .postCode(threadVarsHashMap.getString("newAddressAddress1"))
                            .phoneNumber(threadVarsHashMap.getString("newAddressAddress1"));
            AddressBookEntry createdAddressBookEntry = addressBookEntriesManager.createInstance(addressBookEntryBuilder);
            threadVarsHashMap.clear();
            threadVarsHashMap.put("newAddress", createdAddressBookEntry);
        }
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

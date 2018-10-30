package com.magicleap.cucumber.definition_steps;

import com.magicleap.helpers.managers.users.UserSessions;
import com.magicleap.storefront.managers.AddressBookEntriesManager;
import com.magicleap.storefront.models.AddressBookEntry;
import com.magicleap.storefront.page_blocks.HeaderRowPageBlock;
import com.magicleap.storefront.pages.AddressBookPage;
import com.magicleap.storefront.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddressBookPageStepDefs extends AbstractStepDefs {
    @Autowired UserSessions userSessions;
    @Autowired AddressBookEntriesManager addressBookEntriesManager;

    @Autowired AddressBookPage addressBookPage;
    @Autowired LoginPage loginPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("^Address book page opened.$")
    public void addressBookPageOpened() throws Throwable {
        if (!addressBookPage.isOpened()) {
            if (headerRowPageBlock.isUserLoggedOut()) {
                loginPage.open();
                loginPage.loginToStorefront(userSessions.getActiveUserSession());
            }
            addressBookPage.open();
        }
    }

    @Then("^Check that Address Book page is opened.$")
    public void checkThatAddressBookIsOpened() {
        assertTrue(addressBookPage.isOpened());
    }

    @Then("^Check that header equals to (.*).$")
    public void checkThatHeaderEqualsToAddressBook(String addressBookHeader) {
        assertTrue(addressBookPage.getSectionHeader().trim().contains(addressBookHeader));
    }

    @Then("^Check that URL equals to (.*).$")
    public void checkThatURLEqualsTo(String addressBookURL) throws Throwable {
        assertEquals(addressBookPage.getCurrentUrl(), addressBookURL);
    }

    @When("Fill First name with random text on Create new Address page.")
    public void fillFirstNameRandom() {
        String randomFirstName = RandomStringUtils.randomAlphabetic(10);
        addressBookPage.fillFirstName(randomFirstName);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_FIRST_NAME, randomFirstName);
    }

    @When("Fill Last name with random text on Create new Address page.")
    public void fillLastNameRandom() {
        String randomLastName = RandomStringUtils.randomAlphabetic(10);
        addressBookPage.fillLastName(randomLastName);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_LAST_NAME, randomLastName);
    }

    @When("Fill Address 1 with random text on Create new Address page.")
    public void fillAddress1Random() {
        String randomAddress1 = RandomStringUtils.randomAlphabetic(10);
        addressBookPage.fillAddress1With(randomAddress1);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_ADDRESS_1, randomAddress1);
    }

    @When("Fill Town with random text on Create new Address page.")
    public void fillTownRandom() {
        String randomTown = RandomStringUtils.randomAlphabetic(10);
        addressBookPage.fillTownWith(randomTown);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_TOWN, randomTown);
    }

    @When("Fill Post code with random text on Create new Address page.")
    public void fillPostCodeRandom() {
        String randomPostCode = RandomStringUtils.randomNumeric(5) + "-" + RandomStringUtils.randomNumeric(4);
        addressBookPage.fillPostCode(randomPostCode);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_POST_CODE, randomPostCode);
    }

    @When("Click on Add Address button.")
    public void clickOnAddAddressButton() {
        addressBookPage.clickOnAddAddressButton();
    }

    @When("Select random country from drop-down on Create new Address page.")
    public void selectRandomCountry() {
        addressBookPage.clickOnCountryDropDown();
        String randomCountry = addressBookPage.getRandomCountryFromDropDown();
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_COUNTRY, randomCountry);
        addressBookPage.selectCountryFromDropDown(randomCountry);
    }

    @When("Select random title from drop-down on Create new Address page.")
    public void selectRandomTitle() {
        addressBookPage.clickOnTitleDropDown();
        String randomTitle = addressBookPage.getRandomTitleFromDropDown();
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_TITLE, randomTitle);
        addressBookPage.selectTitleFromDropDown(randomTitle);
    }

    @When("Click on Save button on Create new Address page.")
    public void clickOnSaveButton() {
        addressBookPage.clickOnSaveButton();
        if (!addressBookPage.isAlertOnCreateNewAddress()) {
            AddressBookEntry.AddressBookEntryBuilder addressBookEntryBuilder =
                    new AddressBookEntry.AddressBookEntryBuilder(userSessions.getActiveUserSession().getUser())
                            .country(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_COUNTRY))
                            .title(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_TITLE))
                            .firstName(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_FIRST_NAME))
                            .lastName(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_LAST_NAME))
                            .addressLine1(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_ADDRESS_1))
                            .addressLine2(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_ADDRESS_2))
                            .town(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_TOWN))
                            .postCode(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_POST_CODE))
                            .phoneNumber(threadVarsHashMap.getString(TestKeyword.NEW_ADDRESS_PHONE));
            AddressBookEntry createdAddressBookEntry = addressBookEntriesManager.createInstance(addressBookEntryBuilder);
            threadVarsHashMap.clear();
            threadVarsHashMap.put(TestKeyword.NEW_ADDRESS, createdAddressBookEntry);
        }
    }

    @Then("^Check that created address book entry is present in the list.$")
    public void checkThatCreatedAddressBookEntryIsPresentInTheList() throws Throwable {
        ArrayList<AddressBookEntry> addressBookEntries = addressBookPage.getAddressesList(userSessions.getActiveUserSession());
        assertTrue(threadVarsHashMap.get(TestKeyword.NEW_ADDRESS) != null);
        assertTrue(addressBookEntries.stream()
                .anyMatch(addressBookEntry -> addressBookEntry.equals((AddressBookEntry) threadVarsHashMap.get(TestKeyword.NEW_ADDRESS))));
    }
}

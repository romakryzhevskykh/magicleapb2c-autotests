package com.template.cucumber.definition_steps.address_pages;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.cucumber.definition_steps.TestKeyword;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.users.User;
import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.models.AddressBookEntry;
import com.template.storefront.pages.address_pages.ShippingAddressesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddressBookPageStepDefs extends AbstractStepDefs {

    @Autowired private UserSessions userSessions;
    @Autowired private ShippingAddressesPage shippingAddressesPage;

    @Given("^Shipping Addresses page is opened.$")
    public void addressBookPageIsOpened() {
        if (!shippingAddressesPage.isOpened()) {
            shippingAddressesPage.open();
        }
    }

    @When("^Open Shipping Addresses page.$")
    public void openAddressBookPage() {
        shippingAddressesPage.open();
    }

    @Then("^Check that Shipping address is present on Shipping Addresses page.$")
    public void checkThatShippingAddressIsPresentOnShippingAddressPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        List<ShippingAddress> shippingAddresses = shippingAddressesPage.getShippingAddresses();
        assertTrue(shippingAddresses.contains(userShippingAddress.getShippingAddress()), "Shipping address must be present: " + userShippingAddress);
    }

    @Then("^Check that Shipping Addresses page is opened.$")
    public void checkThatAddressBookPageIsOpened() {
        assertTrue(shippingAddressesPage.isOpened());
    }

    @And("^Check that flash/info message is (.*) on Shipping Address book page.$")
    public void checkThatFlashInfoMessageIsYourAddressAlreadyExistsInShippingAddressBookOnShippingAddressBookPage(String message) {
        assertEquals(shippingAddressesPage.getFlashInfoMessage(), message);
    }

    @And("^Check that new Shipping Address has not been added on Shipping Address page.$")
    public void checkThatNewShippingAddressHasNotBeenAddedOnShippingAddressPage() {
        assertEquals(shippingAddressesPage.getShippingAddresses().size(), userSessions.getActiveUserSession().getUser().getUserShippingAddresses().size());
    }








//    @Given("^Address book page opened.$")
//    public void addressBookPageOpened() throws Throwable {
//        if (!addressBookPage.isOpened()) {
//            if (headerRowPageBlock.isUserLoggedOut()) {
//                loginPageStorefront.open();
//                loginPageStorefront.loginToStorefront(userSessions.getActiveUserSession());
//            }
//            addressBookPage.open();
//        }
//    }

    @Then("^Check that Address Book page is opened.$")
    public void checkThatAddressBookIsOpened() {
        assertTrue(shippingAddressesPage.isOpened());
    }

    @Then("^Check that header equals to (.*).$")
    public void checkThatHeaderEqualsToAddressBook(String addressBookHeader) {
        assertTrue(shippingAddressesPage.getSectionHeader().trim().contains(addressBookHeader));
    }

    @Then("^Check that URL equals to (.*).$")
    public void checkThatURLEqualsTo(String addressBookURL) {
        assertEquals(shippingAddressesPage.getCurrentUrl(), addressBookURL);
    }

    @When("Fill Address 1 with random text on Create new Address page.")
    public void fillAddress1Random() {
        String randomAddress1 = RandomStringUtils.randomAlphabetic(10);
        shippingAddressesPage.fillAddress1With(randomAddress1);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_ADDRESS_1, randomAddress1);
    }

    @When("Fill Town with random text on Create new Address page.")
    public void fillTownRandom() {
        String randomTown = RandomStringUtils.randomAlphabetic(10);
        shippingAddressesPage.fillTownWith(randomTown);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_TOWN, randomTown);
    }

    @When("Fill Post code with random text on Create new Address page.")
    public void fillPostCodeRandom() {
        String randomPostCode = RandomStringUtils.randomNumeric(5) + "-" + RandomStringUtils.randomNumeric(4);
        shippingAddressesPage.fillPostCode(randomPostCode);
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_POST_CODE, randomPostCode);
    }

    @When("Click on Add Address button.")
    public void clickOnAddAddressButton() {
        shippingAddressesPage.clickOnAddAddressButton();
    }

    @When("Select random country from drop-down on Create new Address page.")
    public void selectRandomCountry() {
        shippingAddressesPage.clickOnCountryDropDown();
        String randomCountry = shippingAddressesPage.getRandomCountryFromDropDown();
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_COUNTRY, randomCountry);
        shippingAddressesPage.selectCountryFromDropDown(randomCountry);
    }

    @When("Select random title from drop-down on Create new Address page.")
    public void selectRandomTitle() {
        shippingAddressesPage.clickOnTitleDropDown();
        String randomTitle = shippingAddressesPage.getRandomTitleFromDropDown();
        threadVarsHashMap.put(TestKeyword.NEW_ADDRESS_TITLE, randomTitle);
        shippingAddressesPage.selectTitleFromDropDown(randomTitle);
    }

    @When("Click on Save button on Create new Address page.")
    public void clickOnSaveButton() {
        shippingAddressesPage.clickOnSaveButton();
        if (!shippingAddressesPage.isAlertOnCreateNewAddress()) {
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
          //  AddressBookEntry createdAddressBookEntry = addressBookEntriesManager.createInstance(addressBookEntryBuilder);
//            threadVarsHashMap.clear();
            //threadVarsHashMap.put(TestKeyword.NEW_ADDRESS, createdAddressBookEntry);
        }
    }

    @Then("^Check that created address book entry is present in the list.$")
    public void checkThatCreatedAddressBookEntryIsPresentInTheList() throws Throwable {
        ArrayList<AddressBookEntry> addressBookEntries = shippingAddressesPage.getAddressesList(userSessions.getActiveUserSession());
        assertTrue(threadVarsHashMap.get(TestKeyword.NEW_ADDRESS) != null);
        assertTrue(addressBookEntries.stream()
                .anyMatch(addressBookEntry -> addressBookEntry.equals((AddressBookEntry) threadVarsHashMap.get(TestKeyword.NEW_ADDRESS))));
    }
}

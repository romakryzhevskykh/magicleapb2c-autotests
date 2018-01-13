package com.template.cucumber.definition_steps;

import com.template.helpers.user_engine.UsersPool;
import com.template.storefront.models.AddressBookEntry;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.AddressBookPage;
import com.template.storefront.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddressBookPageStepDefs extends AbstractStepDefs {
    @Autowired UsersPool usersPool;

    @Autowired AddressBookPage addressBookPage;
    @Autowired LoginPage loginPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("^Address book page opened.$")
    public void addressBookPageOpened() throws Throwable {
        if (!addressBookPage.isOpened()) {
            if (headerRowPageBlock.isUserLoggedOut()) {
                loginPage.open();
                loginPage.loginToStorefront(usersPool.getActiveUser());
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

    @Then("^Create new address book entry.$")
    public void createNewAddressBookEntry() throws Throwable {
        addressBookPage.addNewRandomAddress(usersPool.getActiveUser());
    }

    @Then("^Check that created address book entry is present in the list.$")
    public void checkThatCreatedAddressBookEntryIsPresentInTheList() throws Throwable {
        ArrayList<AddressBookEntry> addressBookEntries = addressBookPage.getAddressesList();
        assertTrue(threadVarsHashMap.get("newAddress") != null);
        assertTrue(addressBookEntries.stream()
                .anyMatch(addressBookEntry -> addressBookEntry.equals((AddressBookEntry) threadVarsHashMap.get("newAddress"))));
    }
}

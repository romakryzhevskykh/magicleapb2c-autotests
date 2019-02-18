package com.template.cucumber.definition_steps.address_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.cucumber.definition_steps.TestKeyword;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.users.User;
import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.page_blocks.DeleteAddressPopUp;
import com.template.storefront.pages.address_pages.ShippingAddressesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddressBookPageStepDefs extends AbstractStepDefs {

    @Autowired private UserSessions userSessions;
    @Autowired private ShippingAddressesPage shippingAddressesPage;
    @Autowired private DeleteAddressPopUp deleteAddressPopUp;

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

    @Then("^Check that page title is visible on Shipping Addresses page.$")
    public void checkThatPageTitleIsVisible() {
        assertTrue(shippingAddressesPage.isTitleDisplayed());
    }

    @Then("^Check that page title text is equal to (.*) on Shipping Addresses page.$")
    public void checkThatPageTitleTextIs(String expectedTitleText) {
        assertEquals(shippingAddressesPage.getTitleText(), expectedTitleText);
    }

    @Then("^Check that empty list message is displayed on Shipping Addresses page.$")
    public void checkThatContentTextIsDisplayedOnAddressBookPage() {
        assertTrue(shippingAddressesPage.isEmptyListMessageDisplayed());
    }

    @Then("^Check that empty list message equals to (.*) on Shipping Addresses page.$")
    public void checkThatEmptyListMessageEqualsToOnAddressBookPage(String messageInContent) {
        assertEquals(shippingAddressesPage.getEmptyListMessage(), messageInContent);
    }


    @And("^Click on Delete button for Shipping address on Shipping Addresses page.$")
    public void clickOnDeleteButtonForAnyShippingAddressOnShippingAddressesPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        shippingAddressesPage.clickOnDeleteButtonForShippingAddress(userShippingAddress);
    }

    @And("^Click on Delete button in Delete Address pop-up on Shipping Addresses page.$")
    public void clickOnDeleteButtonInDeleteAddressPopUpOnShippingAddressesPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        deleteAddressPopUp.clickOnDeleteButton(userShippingAddress);
        userSessions.getActiveUserSession().getUser().getUserShippingAddresses().remove(userShippingAddress);
        if (userShippingAddress.isDefault() && !userSessions.getActiveUserSession().getUser().getUserShippingAddresses().isEmpty()) {
            userSessions.getActiveUserSession().getUser().getUserShippingAddresses().get(0).setDefault(true);
        }
    }

    @Then("^Check that Shipping address is not present on Shipping Addresses page.$")
    public void checkThatShippingAddressIsNotPresentOnShippingAddressPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        List<ShippingAddress> shippingAddresses = shippingAddressesPage.getShippingAddresses();
        assertFalse(shippingAddresses.contains(userShippingAddress.getShippingAddress()));
    }

    @And("^Click on Cancel button in Delete Address pop-up on Shipping Addresses page.$")
    public void clickOnCancelButtonInDeleteAddressPopUpOnShippingAddressesPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        deleteAddressPopUp.clickOnCancelButton(userShippingAddress);
    }

    @And("^Click on Set as Default button for Shipping address on Shipping Addresses page.$")
    public void clickOnSetAsDefaultButtonForShippingAddressOnShippingAddressesPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        shippingAddressesPage.clickOnSetAsDefaultButton(userShippingAddress);
        userShippingAddress.setDefault(true);
    }

    @Then("^Check that Shipping Address is default on Shipping Addresses page.$")
    public void checkThatShippingAddressIsDefaultOnShippingAddressesPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        assertTrue(shippingAddressesPage.isShippingAddressDefault(userShippingAddress));
    }

    @And("^Check that other user addresses are not default on Shipping Addresses page.$")
    public void checkThatOtherUserAddressesAreNotDefaultOnShippingAddressesPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        userSessions.getActiveUserSession().getUser().getUserShippingAddresses().stream()
                .filter(userShippingAddress1 -> !userShippingAddress1.getShippingAddress().equals(userShippingAddress.getShippingAddress()))
                .forEach(userShippingAddress1 ->
                        assertFalse(shippingAddressesPage.isShippingAddressDefault(userShippingAddress1), "Shipping address must not be default: " + userShippingAddress1)
                );
    }

    @And("^Click on Edit button for Shipping Address on Shipping Addresses page.$")
    public void clickOnEditButtonForShippingAddressOnShippingAddressesPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        shippingAddressesPage.clickOnEditButton(userShippingAddress);
    }

    @When("^Click on Add Shipping address button on Shipping Addresses page.$")
    public void clickOnAddShippingAddressButtonOnShippingAddressesPage() {
        shippingAddressesPage.clickOnAddShippingAddressButton();
    }
}

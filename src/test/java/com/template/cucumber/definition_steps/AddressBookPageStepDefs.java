package com.template.cucumber.definition_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import com.template.storefront.models.User;
import com.template.storefront.models.UserAddress;
import com.template.storefront.pages.AddressBookPage;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.LoginPage;
import com.template.storefront.pages.StartPage;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddressBookPageStepDefs extends AbstractStepDefs {

    @Autowired User testUser;

    @Autowired HomePage homePage;
    @Autowired LoginPage loginPage;
    @Autowired AddressBookPage addressBookPage;
    @Autowired StartPage startPage;

    @Given("^Address book page opened.$")
    public void openAddressBookPage() {
        if (!addressBookPage.isOpened()) {
            if(!testUser.isLoggedIn()) {
                if(!loginPage.isOpened()) {
                    startPage.open();
                    startPage.openLoginPage();
                }
                loginPage.loginAs(testUser);
            }
            homePage.openShippingAddressBook();
        }
    }

    @Then("^Check that header equals to (.*)$")
    public void checkHeader(String expectedHeader) {
        assertTrue(addressBookPage.getSectionHeader().contains(expectedHeader));
    }

    @Then("^Check that URL equals to (.*)$")
    public void checkURL(String expectedURL) {
        assertTrue(addressBookPage.getPageUrl().equals(expectedURL));
    }

    @Then("^Check that any address street equals to (.*)$")
    public void checkItemStreet(String expectedStreet) {
        List<UserAddress> shippingAddresses = addressBookPage.getShippingAddresses();
        assertFalse(shippingAddresses.stream().map(UserAddress::getStreet).noneMatch(street -> street.equals(expectedStreet)));
    }
}

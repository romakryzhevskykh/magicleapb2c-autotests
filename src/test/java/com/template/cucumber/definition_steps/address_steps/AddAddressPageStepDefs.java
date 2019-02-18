package com.template.cucumber.definition_steps.address_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.cucumber.definition_steps.TestKeyword;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.users.User;
import com.template.storefront.pages.address_pages.AddShippingAddressPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddAddressPageStepDefs extends AbstractStepDefs {

    @Autowired private AddShippingAddressPage addShippingAddressPage;

    @Given("^Open Add Shipping Address page.$")
    public void openAddShippingAddressPage() {
        addShippingAddressPage.open();
    }

    @Given("^Add Shipping Address page is opened.$")
    public void addAddressPageIsOpened() {
        if (!addShippingAddressPage.isOpened()) {
            addShippingAddressPage.open();
        }
    }

    @Then("^Check that page title is visible on Add Shipping Addresses page.$")
    public void checkThatPageTitleIsVisible() {
        assertTrue(addShippingAddressPage.isTitleDisplayed());
    }

    @Then("^Check that page title text is equal to (.*) on Add Shipping Addresses page.$")
    public void checkThatPageTitleTextIsEqualOnAddShippingAddressesPage(String titleText) {
        assertEquals(addShippingAddressPage.getTitleText(), titleText);
    }

    @When("^Select Title from drop-down on Add Shipping Address page.$")
    public void selectTitleFromDropDownOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.selectTitle(shippingAddress.getUserTitle());
    }

    @When("^Select country from drop-down on Add Shipping Address page.$")
    public void selectCountryFromDropDownOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.selectCountry(shippingAddress.getCountry());
    }

    @When("^Fill Address line 1 field on Add Shipping Address page.$")
    public void fillAddressLine1FieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillAddressLine1(shippingAddress.getStreet());
    }

    @When("^Fill Address line 2 field on Add Shipping Address page.$")
    public void fillAddressLine2FieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillAddressLine2(shippingAddress.getAddressLine2());
    }

    @And("^Fill City field on Add Shipping Address page.$")
    public void fillCityFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillCity(shippingAddress.getCity());
    }

    @And("^Fill Zip code field on Add Shipping Address page.$")
    public void fillZipCodeFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillZipCode(shippingAddress.getZipCode());
    }

    @And("^Click on Save button on Add Shipping Address page.$")
    public void clickOnSaveButtonOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.clickOnSaveButton();
        if ("Your address was created.".equals(addShippingAddressPage.getFlashInfoMessage())) {
            String url = addShippingAddressPage.getCurrentUrl();
            String id = url.split("/")[url.split("/").length - 1];
            User.UserShippingAddress userShippingAddress = userSessions.getActiveUserSession().getUser().addShippingAddress(id, shippingAddress);
            threadVarsHashMap.put(TestKeyword.USER_SHIPPING_ADDRESS, userShippingAddress);
        }
    }

    @Then("^Check that flash/info message is (.*) on Add Shipping Address book page.$")
    public void addressWasCreated(String expectedMessage) {
        String infoMessage = addShippingAddressPage.getFlashInfoMessage();
        assertEquals(infoMessage, expectedMessage);
    }

    @And("^Fill First name on Add Shipping Address page.$")
    public void fillFirstNameOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillFirstName(shippingAddress.getFirstName());
    }

    @And("^Fill Last name on Add Shipping Address page.$")
    public void fillLastNameOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillLastName(shippingAddress.getLastName());
    }

    @And("^Fill State field on Add Shipping Address page.$")
    public void fillStateFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillState(shippingAddress.getState());
    }

    @When("^Fill Telephone field on Add Shipping Address page.$")
    public void fillTelephoneFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        addShippingAddressPage.fillTelephone(shippingAddress.getPhoneNumber());
    }

    @Then("^Check that Add Shipping address page is opened.$")
    public void checkThatAddressBookPageIsOpened() {
        assertTrue(addShippingAddressPage.isOpened(), "Shipping Address page must be opened.");
    }
}

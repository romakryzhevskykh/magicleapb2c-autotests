package com.template.cucumber.definition_steps.address_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.cucumber.definition_steps.TestKeyword;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.users.User;
import com.template.helpers.models.users.UserTitle;
import com.template.storefront.pages.address_pages.EditShippingAddressPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditAddressPageStepDefs extends AbstractStepDefs {

    @Autowired private EditShippingAddressPage editShippingAddressPage;

    @When("Open Edit Shipping Address page.")
    public void openEditAddressPage() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        editShippingAddressPage.open(userShippingAddress);
    }

    @When("^Select Title from drop-down on Edit Shipping Address page.$")
    public void selectTitleFromDropDownOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.selectTitle(shippingAddress.getUserTitle());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_TITLE, shippingAddress.getUserTitle());
    }

    @When("^Select country from drop-down on Edit Shipping Address page.$")
    public void selectCountryFromDropDownOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.selectCountry(shippingAddress.getCountry());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_COUNTRY, shippingAddress.getCountry());
    }

    @When("^Fill Address line 1 field on Edit Shipping Address page.$")
    public void fillAddressLine1FieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillAddressLine1(shippingAddress.getStreet());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_LINE_1, shippingAddress.getStreet());
    }

    @When("^Fill Address line 2 field on Edit Shipping Address page.$")
    public void fillAddressLine2FieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillAddressLine2(shippingAddress.getAddressLine2());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_LINE_2, shippingAddress.getAddressLine2());
    }

    @And("^Fill City field on Edit Shipping Address page.$")
    public void fillCityFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillCity(shippingAddress.getCity());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_CITY, shippingAddress.getCity());
    }

    @And("^Fill Zip code field on Edit Shipping Address page.$")
    public void fillZipCodeFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillZipCode(shippingAddress.getZipCode());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_ZIP_CODE, shippingAddress.getZipCode());
    }

    @And("^Fill First name on Edit Shipping Address page.$")
    public void fillFirstNameOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillFirstName(shippingAddress.getFirstName());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_FIRST_NAME, shippingAddress.getFirstName());
    }

    @And("^Fill Last name on Edit Shipping Address page.$")
    public void fillLastNameOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillLastName(shippingAddress.getLastName());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_LAST_NAME, shippingAddress.getFirstName());
    }

    @And("^Fill State field on Edit Shipping Address page.$")
    public void fillStateFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillState(shippingAddress.getState());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_STATE, shippingAddress.getState());
    }

    @When("^Fill Telephone field on Edit Shipping Address page.$")
    public void fillTelephoneFieldOnAddShippingAddressPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        editShippingAddressPage.fillTelephone(shippingAddress.getPhoneNumber());
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS_TELEPHONE, shippingAddress.getPhoneNumber());
    }

    @And("^Click on Save button on Edit Shipping Address page.$")
    public void clickOnSaveButtonOnEditShippingAddressPage() {
        editShippingAddressPage.clickOnSaveButton();
        if ("Your address was updated.".equals(editShippingAddressPage.getFlashInfoMessage())) {
            String url = editShippingAddressPage.getCurrentUrl();
            String id = url.split("/")[url.split("/").length - 1];
            User.UserShippingAddress userShippingAddress = userSessions.getActiveUserSession().getUser()
                    .getUserShippingAddresses().stream()
                    .filter(userShippingAddress1 -> userShippingAddress1.getId().equals(id))
                    .findAny()
                    .orElseGet(() -> {
                        throw new NullPointerException("User doesn't have Shipping address with id: " + id + ". Address instance can't be updated");
                    });
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_COUNTRY) !=null){
                userShippingAddress.getShippingAddress().setCountry(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_COUNTRY));
            }
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_FIRST_NAME) !=null){
                userShippingAddress.getShippingAddress().setFirstName(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_FIRST_NAME));
            }
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_LAST_NAME) !=null){
                userShippingAddress.getShippingAddress().setLastName(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_LAST_NAME));
            }
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_TITLE) != null)
                userShippingAddress.getShippingAddress().setUserTitle((UserTitle) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_TITLE));
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_LINE_1) != null)
                userShippingAddress.getShippingAddress().setStreet(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_LINE_1));
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_LINE_2) != null)
                userShippingAddress.getShippingAddress().setAddressLine2(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_LINE_2));
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_CITY) != null)
                userShippingAddress.getShippingAddress().setCity(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_CITY));
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_STATE) != null)
                userShippingAddress.getShippingAddress().setState(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_STATE));
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_ZIP_CODE) != null)
                userShippingAddress.getShippingAddress().setZipCode(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_ZIP_CODE));
            if (threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS_TELEPHONE) != null)
                userShippingAddress.getShippingAddress().setPhoneNumber(threadVarsHashMap.getString(TestKeyword.SHIPPING_ADDRESS_TELEPHONE));
            threadVarsHashMap.put(TestKeyword.USER_SHIPPING_ADDRESS, userShippingAddress);
        }
    }

    @Then("^Check that flash/info message is (.*) on Edit Shipping Address book page.$")
    public void addressWasCreated(String expectedMessage) {
        String infoMessage = editShippingAddressPage.getFlashInfoMessage();
        assertEquals(infoMessage, expectedMessage);
    }

    @And("^Click on Cancel button on Edit Shipping Address page.$")
    public void clickOnCancelButtonOnEditShippingAddressPage() {
        editShippingAddressPage.clickOnCancelButton();
    }

    @Then("^Check that Edit Shipping address page is opened.$")
    public void checkThatAddressBookPageIsOpened() {
        User.UserShippingAddress userShippingAddress = (User.UserShippingAddress) threadVarsHashMap.get(TestKeyword.USER_SHIPPING_ADDRESS);
        assertTrue(editShippingAddressPage.isOpened(userShippingAddress), "Edit Address page must be opened for: " + userShippingAddress);
    }
}

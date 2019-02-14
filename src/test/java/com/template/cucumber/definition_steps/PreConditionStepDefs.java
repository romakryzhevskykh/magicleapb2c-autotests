package com.template.cucumber.definition_steps;

import com.template.helpers.managers.addresses.AddressesManager;
import com.template.helpers.models.addresses.AddressTestType;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.users.User;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.LoginPageStorefront;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PreConditionStepDefs extends AbstractStepDefs {

    @Autowired private HeaderRowPageBlock headerRowPageBlock;
    @Autowired private LoginPageStorefront loginPageStorefront;
    @Autowired private HomePage homePage;


    @Autowired private AddressesManager addressesManager;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (headerRowPageBlock.isUserLoggedOut()) {
            loginPageStorefront.open();
            loginPageStorefront.loginAs(userSessions.getActiveUserSession());
        } else if (!headerRowPageBlock.isUserLoggedOut() && !headerRowPageBlock.isUserLoggedIn()) {
            homePage.open();
            if (headerRowPageBlock.isUserLoggedOut()) {
                loginPageStorefront.open();
                loginPageStorefront.loginAs(userSessions.getActiveUserSession());
            }
        }
    }

    @And("^(.*) Shipping address that does not exist is generated.$")
    public void validShippingAddressThatDoesNotExistIsGenerated(String validInvalid) {
        AddressTestType addressTestType = AddressTestType.valueOf(validInvalid);
        List<User.UserShippingAddress> userShippingAddresses = addressesManager.getUserSavedShippingAddresses(userSessions.getActiveUserSession());
        ShippingAddress shippingAddress = addressesManager.generateRandomShippingAddressThatDoesNotExist(userShippingAddresses, addressTestType);
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, shippingAddress);
    }

    @Given("^User does not have Saved Shipping Addresses.$")
    public void customerDoesNotHaveSavedShippingAddresses() {
        List<User.UserShippingAddress> shippingAddresses = addressesManager.getUserSavedShippingAddresses(userSessions.getActiveUserSession());
        if (!shippingAddresses.isEmpty()) {
            addressesManager.removeUserShippingAddresses(userSessions.getActiveUserSession(), shippingAddresses);
        }
    }
}

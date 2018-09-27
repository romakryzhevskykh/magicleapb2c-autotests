package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import com.sarnova.helpers.models.users.UserInformation;
import com.sarnova.storefront.pages.RegistrationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationStepDefs extends AbstractStepDefs {

    @Autowired RegistrationPage registrationPage;

    @When("^Open Registration page.$")
    public void openHomePage() {
        registrationPage.open();
    }

    @And("^Fill all mandatory User information fields with generated values on Registration page.$")
    public void fillAllUserInformationFieldsWithGeneratedValuesOnRegistrationPage() {
        UserInformation userInformation = (UserInformation) threadVarsHashMap.get(TestKeyword.USER_INFORMATION);
        registrationPage.fillUsernameFieldWithText(userInformation.getUsername());
        registrationPage.fillPasswordFieldWithText(userInformation.getPassword());
        registrationPage.fillConfirmPasswordFieldWithText(userInformation.getPassword());
        registrationPage.selectNewSecurityQuestionFromDropDown(userInformation.getSecurityQuestion());
        registrationPage.fillSecurityAnswerFieldWithText(userInformation.getSecurityAnswer());
        registrationPage.fillReEnterAnswerFieldWithText(userInformation.getSecurityAnswer());
        registrationPage.selectAccountTypeFromDropDown(userInformation.getAccountType());

        registrationPage.selectTitleFromDropDown(userInformation.getTitle());
        registrationPage.fillFirstNameFieldWithText(userInformation.getFirstName());
        registrationPage.fillLastNameFieldWithText(userInformation.getLastName());
        registrationPage.fillAccountLabelFieldWithText(userInformation.getAccountLabel());
        registrationPage.fillPhoneFieldWithText(userInformation.getPhoneNumber());
        registrationPage.fillEmailFieldWithText(userInformation.getEmail());
        registrationPage.selectRoleFromDropDown(userInformation.getProfileRole());

        registrationPage.setSomeoneToMakePurchase(userInformation.isSomeoneToMakePurchase());
        registrationPage.setReceiveEmails(userInformation.isReceiveEmails());
    }

    @And("^Fill all mandatory Shipping address fields with generated values on Registration page.$")
    public void fillAllShippingAddressFieldsWithGeneratedValuesOnRegistrationPage() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        registrationPage.fillShippingAddressFirstName(shippingAddress.getFirstNameText());
        registrationPage.fillShippingAddressLastName(shippingAddress.getLastNameText());
        registrationPage.selectShippingAddressCountry(shippingAddress.getCountry().getAbbreviation());
        registrationPage.fillShippingAddressAddressLine1(shippingAddress.getAddressLine1());
        registrationPage.fillShippingAddressTown(shippingAddress.getTown().getFullName());
        registrationPage.selectShippingAddressState(shippingAddress.getState().getWithCountryAbbreviation());
        registrationPage.fillShippingAddressZip(shippingAddress.getPostcode());
        registrationPage.fillShippingAddressPhone1(shippingAddress.getPhoneNumber());
    }

    @And("^Fill all mandatory Billing address fields with generated values on Registration page.$")
    public void fillAllBillingAddressFieldsWithGeneratedValuesOnRegistrationPage() {
        ShippingAddress billingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        registrationPage.fillBillingAddressFirstName(billingAddress.getFirstNameText());
        registrationPage.fillBillingAddressLastName(billingAddress.getLastNameText());
        registrationPage.selectBillingAddressCountry(billingAddress.getCountry().getAbbreviation());
        registrationPage.fillBillingAddressAddressLine1(billingAddress.getAddressLine1());
        registrationPage.fillBillingAddressTown(billingAddress.getTown().getFullName());
        registrationPage.selectBillingAddressState(billingAddress.getState().getWithCountryAbbreviation());
        registrationPage.fillBillingAddressZip(billingAddress.getPostcode());
        registrationPage.fillBillingAddressPhone1(billingAddress.getPhoneNumber());
    }

    @And("^Click on Register button on Registration page.$")
    public void clickOnRegisterButtonOnRegistrationPage() {
        registrationPage.clickOnRegisterButton();
    }
}

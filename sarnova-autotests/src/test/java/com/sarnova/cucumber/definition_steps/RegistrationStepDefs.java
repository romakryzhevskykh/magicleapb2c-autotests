package com.sarnova.cucumber.definition_steps;

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

    @And("^Fill all User information fields with generated values on Registration page.$")
    public void fillAllUserInformationFieldsWithGeneratedValuesOnRegistrationPage() {
        UserInformation userInformation = (UserInformation) threadVarsHashMap.get(TestKeyword.USER_INFORMATION);
        registrationPage.fillUsernameFieldWithText(userInformation.getUsername());
        registrationPage.fillPasswordFieldWithText(userInformation.getPassword());
        registrationPage.fillConfirmPasswordFieldWithText(userInformation.getPassword());
        registrationPage.selectNewSequrityQuestionFromDropDown(userInformation.getSecurityQuestion());
        registrationPage.fillSecurityAnswerFieldWithText(userInformation.getSecurityAnswer());
        registrationPage.fillReEnterAnswerFieldWithText(userInformation.getSecurityAnswer());
        registrationPage.selectAccountTypeFromDropDown(userInformation.getAccountType());

        registrationPage.selectTitleFromDropDown(userInformation.getTitle());
        registrationPage.fillFirstnameFieldWithText(userInformation.getFirstName());
        registrationPage.fillLastNameFieldWithText(userInformation.getLastName());
        registrationPage.fillAccountLabelFieldWithText(userInformation.getAccountLabel());
        registrationPage.fillPhoneFieldWithText(userInformation.getPhoneNumber());
        registrationPage.fillEmailFieldWithText(userInformation.getEmail());
        registrationPage.selectRoleFromDropDown(userInformation.getProfileRole());

        registrationPage.setSomeoneToMakePurchase(userInformation.isSomeoneToMakePurchase());
        registrationPage.setReceiveEmails(userInformation.isReceiveEmails());
    }
}

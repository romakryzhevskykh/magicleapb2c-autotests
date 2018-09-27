package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.RegistrationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationStepDefs {

    @Autowired RegistrationPage registrationPage;

    @When("^Open Registration page.$")
    public void openHomePage() {
        registrationPage.open();
    }

    @And("^Fill all User information fields with generated values on Registration page.$")
    public void fillAllUserInformationFieldsWithGeneratedValuesOnRegistrationPage() {

    }
}

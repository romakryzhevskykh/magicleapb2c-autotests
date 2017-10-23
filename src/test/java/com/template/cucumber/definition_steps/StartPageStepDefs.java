package com.template.cucumber.definition_steps;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import com.template.storefront.pages.StartPage;

public class StartPageStepDefs extends AbstractStepDefs {

    @Autowired StartPage startPage;

    @Given("^Login page.$")
    public void clickOnHelloSignIn() {
        startPage.openLoginPage();
    }

}

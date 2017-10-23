package com.template.cucumber.definition_steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import com.template.storefront.models.User;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.LoginPage;
import com.template.storefront.pages.StartPage;

public class LoginPageStepDefs extends AbstractStepDefs {

    @Autowired User testUser;

    @Autowired HomePage homePage;
    @Autowired LoginPage loginPage;
    @Autowired StartPage startPage;


    @Given("^Login page opened.$")
    public void openLoginPage() {
        if (testUser.isLoggedIn()) {
            homePage.open();
            homePage.logout(testUser);
            startPage.openLoginPage();
        } else if (!homePage.isOpened()) {
            startPage.open();
            startPage.openLoginPage();
        }
    }

    @When("Login to project as a basic customer.")
    public void loginToProject() {
        loginPage.loginAs(testUser);
    }

    @And("^Fill login field with valid user email.$")
    public void fillLoginFieldWithValidEmail() {
        loginPage.fillLoginFieldWith(testUser.getUsername());
    }

    @And("^Fill password field with valid user password.$")
    public void fillPasswordFieldWithValidPassword() {
        loginPage.fillPasswordFieldWith(testUser.getPassword());
    }

    @And("^Click on submit/login button for valid user.$")
    public void clickOnSubmitButton() {
        loginPage.clickOnSubmitButton();
        testUser.setLoggedIn(true);
    }
}

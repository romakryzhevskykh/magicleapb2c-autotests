package com.template.cucumber.definition_steps;

import com.template.helpers.UsersPool;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.LoginPage;
import com.template.storefront.pages.StartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDefs extends AbstractStepDefs {

    @Autowired UsersPool usersPool;

    @Autowired HomePage homePage;
    @Autowired LoginPage loginPage;
    @Autowired StartPage startPage;


    @Given("^Login page opened.$")
    public void openLoginPage() {
        if (usersPool.getUser().isLoggedIn()) {
            homePage.open();
            homePage.logout(usersPool.getUser());
            startPage.openLoginPage();
        } else if (!homePage.isOpened()) {
            startPage.open();
            startPage.openLoginPage();
        }
    }

    @When("Login to project as a basic customer.")
    public void loginToProject() {
        loginPage.loginAs(usersPool.getUser());
    }

    @And("^Fill login field with valid user email.$")
    public void fillLoginFieldWithValidEmail() {
        loginPage.fillLoginFieldWith(usersPool.getUser().getUsername());
    }

    @And("^Fill password field with valid user password.$")
    public void fillPasswordFieldWithValidPassword() {
        loginPage.fillPasswordFieldWith(usersPool.getUser().getPassword());
    }

    @And("^Click on submit/login button for valid user.$")
    public void clickOnSubmitButton() {
        loginPage.clickOnSubmitButton();
        usersPool.getUser().setLoggedIn(true);
    }
}

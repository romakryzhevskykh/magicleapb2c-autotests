package com.sarnova.emp.stepdef.account;

import com.sarnova.emp.dataprovider.DataProvider;
import com.sarnova.emp.entity.CustomerDto;
import com.sarnova.emp.site.content.component.account.Login;
import com.sarnova.emp.site.content.page.account.LoginRegisterPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginStepdefs {

    private static final Logger LOG = LoggerFactory.getLogger(LoginStepdefs.class);

    @Autowired
    private LoginRegisterPage loginRegisterPage;
    @Autowired
    private DataProvider<CustomerDto> customerDataProvider;

    @Given("^Customer opens Login Register page$")
    public void customerOpensLoginRegisterPage() {
        loginRegisterPage.openPage();
    }

   // @When("^Customer logs in with email (.*) and password (.*)$")
  //  public void customerLogsInWithEmailAndPassword(String email, String password) {
  //      login(email, password);
  //  }

    private void login(String email, String password) {
        getLoginComponent().enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();
    }

    @When("^Customer logs in with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void customerLogsInWithEmailAndPassword(String email, String password) {
        login(email, password);
    }

    @And("^Customer logs in$")
    public void customerLogsIn() {
        customerLogsInWithEmailAndPassword(customerDataProvider.getItem().getEmail(), customerDataProvider.getItem().getPassword());
    }

    @Then("^Login page is opened$")
    public void loginPageIsOpened() {
        Assertions.assertThat(loginRegisterPage.isLoaded()).as("Login page isn't displayed").isTrue();
    }

    @And("^Error message for incorrect credentials is displayed$")
    public void errorMessageForIncorrectCredentialsIsDisplayed() {
        Assertions.assertThat(getLoginComponent().isErrorMessageDisplayed()).as("Error message isn't displayed").isTrue();
    }

    private Login getLoginComponent() {
        return loginRegisterPage.getLoginComponent();
    }

    @When("^Customer logs with ([^\"]*) and ([^\"]*)$")
    public void customerLogsWithEmailAndPassword(String email, String password) {
        login(email, password);
    }
}

package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.DashboardPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DashboardStepDefs extends AbstractStepDefs{

    @Autowired private DashboardPage dashboardPage;

    @When("^Click on Skip button.$")
    public void clickOnSkipButton(){
        dashboardPage.skipTrainingLevel();
    }

    @Then("^Dashboard page is opened.")
    public void isDashboardPageOpened(){
        assertTrue(dashboardPage.isOpened());
    }

    @Then("^Chosen account is displayed in account box on Dashboard page.$")
    public void chosenAccountIsDisplayedInAccountsBoxOnDashboardPage() {
        String chosenAccount = threadVarsHashMap.getString(TestKeyword.CHOSEN_ACCOUNT);
        assertTrue(dashboardPage.isSelectedAccountIsDisplayed().contains(chosenAccount));
    }
}

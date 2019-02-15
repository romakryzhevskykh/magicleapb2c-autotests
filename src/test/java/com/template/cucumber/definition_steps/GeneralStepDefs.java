package com.template.cucumber.definition_steps;

import com.template.helpers.GeneralPageActivities;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class GeneralStepDefs extends AbstractStepDefs {

    @Autowired HeaderRowPageBlock headerRowPageBlock;
    @Autowired GeneralPageActivities generalPageActivities;

    @And("^Refresh page.$")
    public void refreshPage() {
        generalPageActivities.refreshPage();
    }

    @Then("^Check that user is logged out.$")
    public void checkThatUserIsLoggedOut() {
        assertTrue(headerRowPageBlock.isUserLoggedOut());
    }

    @Then("^Check that user is logged in.$")
    public void checkThatUserIsLoggedIn() {
        assertTrue(headerRowPageBlock.isUserLoggedIn());
    }

    @And("^Wait for (\\d+) seconds.$")
    public void waitForSeconds(int secondsToWait) {
        try {
            TimeUnit.SECONDS.sleep(secondsToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^Switch to the latest window with closing the others.$")
    public void switchToTheLatestWindowWithClosingTheOthers() {
        generalPageActivities.switchToTheLatestWindowWithClosingTheOthers();
    }
}

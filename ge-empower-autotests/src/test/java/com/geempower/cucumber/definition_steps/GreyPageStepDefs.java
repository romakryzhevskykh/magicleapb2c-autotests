package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.GreyPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GreyPageStepDefs extends AbstractStepDefs {
    @Autowired
    private GreyPage greyPage;

    @Then("^Grey page is opened.$")
    public void isGreyPageOpened() {
        assertTrue(greyPage.isOpened());
    }

    @Then("^Hello message (.*) is displayed on the Grey page.$")
    public void helloHelloMessageIsDisplayedOnTheGreyPage(String helloMessage) {
        assertEquals(helloMessage, greyPage.getHelloMessage());
    }

    @Then("^(.*) relationship label is displayed on the Grey page.$")
    public void relationshipLabelIsDisplayedOnTheGreyPage(String label) {
        assertEquals(label, greyPage.getRelationshipLabel());
    }

    @Then("^(.*) role label is displayed on the Grey page.$")
    public void roleLabelIsDisplayedOnTheGreyPage(String label) {
        assertEquals(label, greyPage.getRoleLabel());
    }

    @Then("^Correct change Role&Relationship header (.*) is displayed on the Grey page.$")
    public void correctChangeRoleRelationshipHeaderIsDisplayedOnTheGreyPage(String header) {
        assertEquals(header, greyPage.getChangeRoleAndRelationshipHeader());
    }

    @Then("^Account request page footer title (.*) is displayed on the Grey page.$")
    public void accountRequestPageFooterTitleIsDisplayedOnTheGreyPage(String title) {
        assertEquals(title, greyPage.getGreyPageFooterTitle());
    }

    @Then("^Footer title item1 (.*) is displayed on the Grey page.$")
    public void footerTitleItem1IsDisplayedOnTheGreyPage(String item1) {
        assertEquals(item1, greyPage.getFooterTitleItem1());
    }

    @Then("^Footer title item2 (.*) is displayed on the Grey page.$")
    public void footerTitleItem2IsDisplayedOnTheGreyPage(String item2) {
        assertEquals(item2, greyPage.getFooterTitleItem2());
    }

    @When("^User clicks on the ABB logo to activate himself on the Grey page.$")
    public void userClicksOnTheABBLogoToActivateHimselfOnTheGreyPage() {
        greyPage.clickOnAbbLogoToActivateUser();
    }

    @When("^User selects random relationship type except (.*) from relationship list.$")
    public void userSelectsRandomRelationshipTypeExceptMfgFromRelationshipList(String relationship) {
        greyPage.selectRandomRelationshipTypeExceptMfgFromRelationshipList(relationship);
    }

    @When("^User selects random role from role list.$")
    public void userSelectsRandomRoleFromRoleList() {
        greyPage.userSelectsRandomRoleFromRoleList();
    }

    @And("^User click on Assign button.$")
    public void userClickOnAssignButton()  {
        greyPage.userClickOnAssignButton();
    }
}
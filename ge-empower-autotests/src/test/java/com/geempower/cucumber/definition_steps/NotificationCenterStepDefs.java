package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.NotificationCenterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NotificationCenterStepDefs extends AbstractStepDefs {

    @Autowired
    private NotificationCenterPage notificationCenterPage;

    @Then("^(.*) title is displayed.$")
    public void isNotificationPreferencesTitleDisplayed(String title) {
        assertEquals(title, notificationCenterPage.getNotificationCenterPageTitle());
    }

    @Then("^(.*) title of section is displayed.$")
    public void marketingAndPromotionalContentSectionTitleIsDisplayed(String title) {
        assertEquals(title, notificationCenterPage.getPromotionalContentSectionTitle());
    }

    @Then("^Informational toggle section contains (.*) description.$")
    public void informationalToggleSectionContainsTextDescription(String description) {
        assertEquals(description, notificationCenterPage.getInformationalToggleSectionDescription());
    }

    @Then("^Subscription preference (.*) is displayed.$")
    public void subscriptionPreferenceTextIsDisplayed(String description) {
        assertEquals(description, notificationCenterPage.getSubscriptionPreferenceDescription());
    }

    @Then("^(.*) section header is displayed.$")
    public void statusTrainingAlertsSectionHeaderIsDisplayed(String header) {
        assertEquals(header, notificationCenterPage.getStatusTrainingAlertsSectionHeader());
    }

    @Then("^(.*) header of Notification Preferences section is displayed.$")
    public void notificationPreferencesSectionHeaderIsDisplayed(String sectionHeader) {
        assertTrue(notificationCenterPage.getNotificationPreferencesSectionHeader().equals(sectionHeader));
    }

    @When("^Admin switches the empowerU toggle to another state.$")
    public void adminSwitchesTheempowerUToggle() {
        String currentTogglePosition = threadVarsHashMap.getString(TestKeyword.EMPOWER_U_TOGGLE_POSITION);
        notificationCenterPage.switchTheEmpowerUToggle();
        if (currentTogglePosition.equals("ON")) {
            threadVarsHashMap.replace(TestKeyword.EMPOWER_U_TOGGLE_POSITION, "OFF");
        } else if (currentTogglePosition.equals("OFF")) {
            threadVarsHashMap.replace(TestKeyword.EMPOWER_U_TOGGLE_POSITION, "ON");
        }
    }

    @And("^Current empowerU toggle position is saved to the threadVarsHashMap.$")
    public void currentEmpowerUTogglePositionIsSavedToTheThreadVarsHashMap() {
        threadVarsHashMap.replace(TestKeyword.EMPOWER_U_TOGGLE_POSITION, notificationCenterPage.getEmpowerUTogglePosition());
    }

    @And("^Click on Save notification preferences button.$")
    public void clickOnSaveNotificationPreferencesButton() {
        notificationCenterPage.saveNotificationPreferences();
    }

    @Then("^empowerU toggle is switched to previously chosen state.$")
    public void empowerUToggleIsSwitchedToPreviouslyChosenState() {
        assertEquals(threadVarsHashMap.getString(TestKeyword.EMPOWER_U_TOGGLE_POSITION), notificationCenterPage.getEmpowerUTogglePosition());
    }

    @And("^Current System Status toggle position is saved to the threadVarsHashMap.$")
    public void currentSystemStatusTogglePositionIsSavedToTheThreadVarsHashMap() {
        threadVarsHashMap.replace(TestKeyword.SYSTEM_STATUS_TOGGLE_POSITION, notificationCenterPage.getSystemStatusTogglePosition());
    }

    @When("^Admin switches the System Status toggle to another state.$")
    public void adminSwitchesTheSystemStatusToggleToAnotherState() {
        String currentTogglePosition = threadVarsHashMap.getString(TestKeyword.SYSTEM_STATUS_TOGGLE_POSITION);
        notificationCenterPage.switchTheSystemStatusToggle();
        if (currentTogglePosition.equals("ON")) {
            threadVarsHashMap.replace(TestKeyword.SYSTEM_STATUS_TOGGLE_POSITION, "OFF");
        } else if (currentTogglePosition.equals("OFF")) {
            threadVarsHashMap.replace(TestKeyword.SYSTEM_STATUS_TOGGLE_POSITION, "ON");
        }
    }

    @Then("^System Status toggle is switched to previously chosen state.$")
    public void systemStatusToggleIsSwitchedToPreviouslyChosenState() {
        assertEquals(threadVarsHashMap.getString(TestKeyword.SYSTEM_STATUS_TOGGLE_POSITION), notificationCenterPage.getSystemStatusTogglePosition());
    }
}

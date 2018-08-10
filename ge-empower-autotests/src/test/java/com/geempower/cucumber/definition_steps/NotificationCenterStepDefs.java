package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.ThreadVarsHashMap;
import com.geempower.storefront.pages.NotificationCenterPage;
import cucumber.api.PendingException;
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

    @When("^Admin switches the Lessonly toggle to another state.$")
    public void adminSwitchesTheLessonlyToggle() {
        String currentTogglePosition = threadVarsHashMap.getString(TestKeyword.LESSONLY_TOGGLE_POSITION);
        notificationCenterPage.switchTheLessonlyToggle();
        if (currentTogglePosition.equals("ON")) {
            threadVarsHashMap.replace(TestKeyword.LESSONLY_TOGGLE_POSITION, "OFF");
        } else if (currentTogglePosition.equals("OFF")) {
            threadVarsHashMap.replace(TestKeyword.LESSONLY_TOGGLE_POSITION, "ON");
        }
    }

    @And("^Current Lessonly toggle position is saved to the threadVarsHashMap.$")
    public void currentLessonlyTogglePositionIsSavedToTheThreadVarsHashMap() {
        threadVarsHashMap.replace(TestKeyword.LESSONLY_TOGGLE_POSITION, notificationCenterPage.getLessonlyTogglePosition());
    }

    @And("^Click on Save notification preferences button.$")
    public void clickOnSaveNotificationPreferencesButton() {
        notificationCenterPage.saveNotificationPreferences();
    }

    @Then("^Lessonly toggle is switched to previously chosen state.$")
    public void lessonlyToggleIsSwitchedToPreviouslyChosenState() {
        assertEquals(threadVarsHashMap.getString(TestKeyword.LESSONLY_TOGGLE_POSITION), notificationCenterPage.getLessonlyTogglePosition());
    }

    @And("^Current Status Page toggle position is saved to the threadVarsHashMap.$")
    public void currentStatusPageTogglePositionIsSavedToTheThreadVarsHashMap() {
        threadVarsHashMap.replace(TestKeyword.STATUS_PAGE_TOGGLE_POSITION, notificationCenterPage.getStatusPageTogglePosition());
    }

    @When("^Admin switches the Status Page toggle to another state.$")
    public void adminSwitchesTheStatusPageToggleToAnotherState() {
        String currentTogglePosition = threadVarsHashMap.getString(TestKeyword.STATUS_PAGE_TOGGLE_POSITION);
        notificationCenterPage.switchTheStatusPageToggle();
        if (currentTogglePosition.equals("ON")) {
            threadVarsHashMap.replace(TestKeyword.STATUS_PAGE_TOGGLE_POSITION, "OFF");
        } else if (currentTogglePosition.equals("OFF")) {
            threadVarsHashMap.replace(TestKeyword.STATUS_PAGE_TOGGLE_POSITION, "ON");
        }
    }

    @Then("^Status Page toggle is switched to previously chosen state.$")
    public void statusPageToggleIsSwitchedToPreviouslyChosenState() {
        assertEquals(threadVarsHashMap.getString(TestKeyword.STATUS_PAGE_TOGGLE_POSITION), notificationCenterPage.getStatusPageTogglePosition());
    }
}

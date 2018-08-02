package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.NotificationCenterPage;
import cucumber.api.java.en.Then;
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
}

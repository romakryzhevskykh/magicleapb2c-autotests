package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.NotificationCenterPageElements.*;

@Component
public class NotificationCenterPage extends StorefrontBasePage {

    private final String pageUri = "my-account/notification-preferences";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Notification Center Page Title")
    public String getNotificationCenterPageTitle() {
        return $(NOTIFICATION_PREFERENCES_TITLE_XPATH).getText();
    }

    @Step("Get Promotional Content Section Title")
    public String getPromotionalContentSectionTitle() {
        return $(PROMOTIONAL_CONTENT_TITLE_XPATH).getText();
    }

    @Step("Get Informational Toggle Section Description")
    public String getInformationalToggleSectionDescription() {
        return $(INFORMATIONAL_TOGGLE_DESCRIPTION_XPATH).getText();
    }

    @Step("Get Subscription Preference Description")
    public String getSubscriptionPreferenceDescription() {
        return $(SUBSCRIPTION_PREFERENCE_DESCRIPTION_XPATH).getText();
    }

    @Step("Get Status Training Alerts Section Header")
    public String getStatusTrainingAlertsSectionHeader() {
        return $(STATUS_TRAINING_ALERT_HEADER_XPATH).getText();
    }

    @Step("Get Notification Preferences Section Header")
    public String getNotificationPreferencesSectionHeader() {
        return $(NOTIFICATION_PREFERENCE_TITLE_XPATH).getText();
    }

    @Step("Get Lessonly Toggle Position")
    public String getLessonlyTogglePosition() {
        String togglePosition;
        if ($(LESSONLY_TOGGLE_XPATH).getCssValue("background-color").equals("rgba(59, 115, 185, 1)")) {
            togglePosition = "ON";
        } else {
            togglePosition = "OFF";
        }
        return togglePosition;
    }

    @Step("Switch The Lessonly Toggle")
    public void switchTheLessonlyToggle() {
        click(LESSONLY_TOGGLE_XPATH);
    }

    @Step("Save Notification Preferences")
    public void saveNotificationPreferences() {
        click(SAVE_NOTIFICATION_PREFERENCES_BUTTON_XPATH);
    }

    @Step("Get Status Page Toggle Position")
    public String getStatusPageTogglePosition() {
        String togglePosition;
        if ($(STATUS_PAGE_TOGGLE_XPATH).getCssValue("background-color").equals("rgba(59, 115, 185, 1)")) {
            togglePosition = "ON";
        } else {
            togglePosition = "OFF";
        }
        return togglePosition;
    }

    @Step("Switch The Status Page Toggle")
    public void switchTheStatusPageToggle() {
        click(STATUS_PAGE_TOGGLE_XPATH);
    }
}
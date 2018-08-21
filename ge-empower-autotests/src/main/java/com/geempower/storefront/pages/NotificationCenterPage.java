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
    public String getEmpowerUTogglePosition() {
        String togglePosition;
        if ($(EMPOWER_U_TOGGLE_XPATH).getCssValue("background-color").equals("rgba(59, 115, 185, 1)")) {
            togglePosition = "ON";
        } else {
            togglePosition = "OFF";
        }
        return togglePosition;
    }

    @Step("Switch The empowerU Toggle")
    public void switchTheEmpowerUToggle() {
        click(EMPOWER_U_TOGGLE_XPATH);
    }

    @Step("Save Notification Preferences")
    public void saveNotificationPreferences() {
        click(SAVE_NOTIFICATION_PREFERENCES_BUTTON_XPATH);
    }

    @Step("Get System status Toggle Position")
    public String getSystemStatusTogglePosition() {
        String togglePosition;
        if ($(SYSTEM_STATUS_TOGGLE_XPATH).getCssValue("background-color").equals("rgba(59, 115, 185, 1)")) {
            togglePosition = "ON";
        } else {
            togglePosition = "OFF";
        }
        return togglePosition;
    }

    @Step("Switch The System status Toggle")
    public void switchTheSystemStatusToggle() {
        click(SYSTEM_STATUS_TOGGLE_XPATH);
    }
}
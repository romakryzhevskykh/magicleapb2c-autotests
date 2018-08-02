package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;

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

    public String getNotificationCenterPageTitle() {
        return $(NOTIFICATION_PREFERENCES_TITLE_XPATH).getText();
    }

    public String getPromotionalContentSectionTitle() {
        return $(PROMOTIONAL_CONTENT_TITLE_XPATH).getText();
    }

    public String getInformationalToggleSectionDescription() {
        return $(INFORMATIONAL_TOGGLE_DESCRIPTION_XPATH).getText();
    }

    public String getSubscriptionPreferenceDescription() {
        return $(SUBSCRIPTION_PREFERENCE_DESCRIPTION_XPATH).getText();
    }

    public String getStatusTrainingAlertsSectionHeader() {
        return $(STATUS_TRAINING_ALERT_HEADER_XPATH).getText();
    }

    public String getNotificationPreferencesSectionHeader() {
        return $(NOTIFICATION_PREFERENCE_TITLE_XPATH).getText();
    }
}

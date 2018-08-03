package com.geempower.storefront.page_elements;

public class NotificationCenterPageElements {

    public final static String NOTIFICATION_PREFERENCES_TITLE_XPATH = "//p[@class='navigation-navbar-heading']";
    private final static String REGISTRATION_INFO_WRAPPER_XPATH = "//div[@class='registration-info-wrapper']";
    public final static String PROMOTIONAL_CONTENT_TITLE_XPATH = REGISTRATION_INFO_WRAPPER_XPATH + "/p[1]";
    public final static String STATUS_TRAINING_ALERT_HEADER_XPATH = REGISTRATION_INFO_WRAPPER_XPATH + "/p[2]";
    private final static String NOTIFICATION_PREFERENCES_SECTION_XPATH = "//div[contains(@class, 'notification-preferences-section')]";
    public final static String INFORMATIONAL_TOGGLE_DESCRIPTION_XPATH = NOTIFICATION_PREFERENCES_SECTION_XPATH + "//p[1]";
    public final static String SUBSCRIPTION_PREFERENCE_DESCRIPTION_XPATH = NOTIFICATION_PREFERENCES_SECTION_XPATH + "//p[2]";
    public final static String NOTIFICATION_PREFERENCE_TITLE_XPATH = "//div[@id='profile-notification-preferences']//p[contains(@class, 'personal-title')]";
    public final static String LESSONLY_TOGGLE_XPATH = "//input[@name='lessonlyEnabled']/..//span[@class='onoffswitch-switch']";
    public final static String SAVE_NOTIFICATION_PREFERENCES_BUTTON_XPATH = "//button[@id='notificationPreferences-submit-button']";
    public final static String STATUS_PAGE_TOGGLE_XPATH = "//input[@name='statuspageEnabled']/..//span[@class='onoffswitch-switch']";

}

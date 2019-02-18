package com.template.helpers.managers.constants;

public class CreditCardsXSoupElements {
    public static final String CUSTOM_SPLITTER = "TemporaryRemoveSign";
    public static final String CARD_ELEMENTS_X_SOUP_PATH = "//div[@class*=account-paymentdetails]/div[@class*=account-cards]/div[@class=row]/div[@class*=card]";
    public static final String CARD_ADDRESS_1_X_SOUP_PATH = "ul/li[5]/text()";
    public static final String CARD_CITY_STATE_X_SOUP_PATH = "ul/li[6]/text()";
    public static final String CARD_COUNTRY_ZIP_X_SOUP_PATH = "ul/li[7]/text()";
    public static final String NAME_IN_CARD_X_SOUP_PATH = "ul/li[1]/div/text()";
    public static final String BILLING_INFO_X_SOUP_PATH = "ul/li[1]/text()";
    public static final String CARD_TYPE_X_SOUP_PATH = "ul/li[2]/text()";
    public static final String CARD_MASK_X_SOUP_PATH = "ul/li[3]/text()";
    public static final String CARD_EXPIRY_DATA_X_SOUP_PATH = "ul/li[4]/text()";
    public static final String CARD_IS_DEFAULT_X_SOUP_PATH = "ul/li[1]";
    public static final String CARD_REMOVE_BUTTON_CARD_ID_X_SOUP_PATH = "div[@class*=account-cards-actions]/a[@class*=removePaymentDetailsButton]/@data-payment-id";
}

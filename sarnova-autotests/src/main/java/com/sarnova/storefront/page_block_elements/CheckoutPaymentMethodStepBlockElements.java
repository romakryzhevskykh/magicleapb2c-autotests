package com.sarnova.storefront.page_block_elements;

public class CheckoutPaymentMethodStepBlockElements {
    public static final String NEXT_BUTTON_ID = "cardDetailsSubmitButton";

    public static final String CARD_PAYMENT_CHECKBOX_XPATH = "//label[@for='PaymentTypeSelection_CARD']/div/div";
    public static final String INVOICE_PAYMENT_CHECKBOX_XPATH = "//label[@for='PaymentTypeSelection_INVOICE']/div/div";
    public static final String PURCHASE_ORDER_NUMBER_FIELD_ID = "PurchaseOrderNumber";
    public static final String COMMENT_FIELD_ID = "comment";
    public static final String CARD_ACCOUNT_NUMBER_FIELD_ID = "card_accountNumber";
    public static final String CARD_EXPIRY_MONTH_DROP_DOWN_ID = "ExpiryMonth";
    public static final String CARD_EXPIRY_MONTH_ITEM_BY_VALUE_XPATH = "//select[@id='ExpiryMonth']/option[@value='%s']";
    public static final String CARD_EXPIRY_YEAR_DROP_DOWN_ID = "ExpiryYear";
    public static final String CARD_EXPIRY_YEAR_ITEM_BY_VALUE_XPATH = "//select[@id='ExpiryYear']/option[@value='%s']";
    public static final String CARD_NAME_ON_CARD_FIELD_ID = "card_nameOnCard";
    public static final String CARD_CVV_CODE_FIELD_ID = "card_cvNumber";
    public static final String CARD_SAVE_PAYMENT_METHOD_CHECKBOX_ID = "savePaymentMethod";

    public static final String CHANGE_BILLING_ADDRESS_CHECKBOX_XPATH = "//label[@for='changeBillingAdress_true']/div/div";
    public static final String SELECT_BILLING_ADDRESS_COUNTRY_DROP_DOWN_ID = "address.country";
    public static final String ITEMS_IN_BILLING_ADDRESS_COUNTRY_DROP_DOWN_XPATH = "//select[@id='address.country']/option[not(@disabled)]";
    public static final String ITEM_IN_BILLING_ADDRESS_COUNTRY_DROP_DOWN_BY_VALUE_XPATH = "//select[@id='address.country']/option[@value='%s']";

    public static final String BILLING_ADDRESS_FIRST_NAME_FIELD_ID = "address.firstName";
    public static final String BILLING_ADDRESS_LAST_NAME_FIELD_ID = "address.surname";
    public static final String BILLING_ADDRESS_ADDRESS_LINE_1_FIELD_ID = "address.line1";
    public static final String BILLING_ADDRESS_ADDRESS_LINE_2_FIELD_ID = "address.line2";
    public static final String BILLING_ADDRESS_TOWN_CITY_FIELD_ID = "address.townCity";

    public static final String BILLING_ADDRESS_STATE_DROP_DOWN_ID = "address.region";
    public static final String ITEMS_IN_BILLING_ADDRESS_STATE_DROP_DOWN_XPATH = "//select[@id='address.region']/option[not(@disabled)]";
    public static final String ITEM_IN_BILLING_ADDRESS_STATE_DROP_DOWN_BY_VALUE_XPATH = "//select[@id='address.region']/option[@value='%s']";

    public static final String BILLING_ADDRESS_POSTCODE_FIELD_ID = "address.postcode";
    public static final String BILLING_ADDRESS_PHONE_FIELD_ID = "address.phone";

}

package com.magicleap.storefront.page_elements;

public class QualificationPageElements {
    private static final String SIGN_UP_FORM = "//div[@class = 'signup-step']//form";
    public static final String COMPANY_NAME_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'Legal Company Name']";
    public static final String DBA_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'DBA']";
    public static final String WEBSITE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'Website']";
    public static final String YEARS_IN_BUSINESS_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'Website']";

    public static final String BUSINESS_TYPE_DROPDOWN_XPATH = "//*[text()='What type of business are you?']//following::div[@class='select-style']";
    public static final String MARKET_SEGMENT_DROPDOWN_XPATH = "//*[text()='Market Segment']//following::div[@class='select-style']";

    private static final String LLC_RADIO_BUTTON = "//label[@class='radio-style']//input";
    public static final String LLC_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@value='llc']";
    public static final String CORPORATION_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@value='corporation']";
    public static final String SOLE_PRACTIONER_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@value='solePractitioner']";
    public static final String OTHER_RADIO_BUTTON_XPATH =  LLC_RADIO_BUTTON + "[@value='other']";
    public static final String OTHER_TYPE_OF_OWNERSHIP_XPATH =  LLC_RADIO_BUTTON + "[@placeholder='Please enter type of ownership']";
    public static final String PRIOR_DEALING_RADIO_BUTTON_YES_XPATH = LLC_RADIO_BUTTON + "[@value='true']";
    public static final String PRIOR_DEALING_RADIO_BUTTON_NO_XPATH = LLC_RADIO_BUTTON +"[@value='false']";

    public static final String NEXT_BUTTON_XPATH = "//button[@type='submit']";
    public static final String LOGIN_PAGE_BUTTON_XPATH = "//a[@href='#/login']";

    //Second page, Your Contact Info
    public static final String NAME_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Name']";
    public static final String TITLE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Title']";
    public static final String EMAIL_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Email']";
    public static final String PHONE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Phone']";
    public static final String STREET1_FIELD_XPATH = "//div[@class='form-row']/input[@id='street1']";
    public static final String STREET2_FIELD_XPATH = "//div[@class='form-row no-space']/input[@id='street2']";
    public static final String CITY_FIELD_XPATH = "//div[@class='row form-row no-space']//input[@id='city']";
    public static final String ZIP_CODE_FIELD_XPATH = "//div[@class='col col-4']//input[@id='zip']";

    public static final String STATE_DROPDOWN_FIELD_XPATH = "//div[@class='col col-3']/div[@class='select-style']";

    public static final String BACK_BUTTON_XPATH = "//button[@type='button']";

    //Third page, Your Payment Info
    public static final String EMAIL_TO_SEND_INVOICE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Email address to send invoices to']";

    public static final String TAX_EXEMPT_YES_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='taxExempt' and @value='true']";
    public static final String TAX_EXEMPT_NO_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='taxExempt' and @value='false']";
    public static final String BILLING_ADRESS_DIFFERENT_YES_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='isBillingAddressDifferent' and @value='true']";
    public static final String BILLING_ADRESS_DIFFERENT_NO_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='isBillingAddressDifferent' and @value='falsew']";
    public static final String SHIPPING_ADRESS_YES_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='isShippingAddress' and @value='true']";
    public static final String SHIPPING_ADRESS_NO_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='isShippingAddress' and @value='false']";
    public static final String FORM_OF_PAYMENT_PREPAY_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='paymentMethod' and @value='prepay']";
    public static final String FORM_OF_PAYMENT_TERMS_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='paymentMethod' and @value='terms']";
    public static final String FORM_OF_PAYMENT_CREDIT_CARD_RADIO_BUTTON_XPATH = LLC_RADIO_BUTTON + "[@name='paymentMethod' and @value='terms']";

    public static final String GET_QUALIFIED_BUTTON_XPATH = "//button[@type='submit']";
}

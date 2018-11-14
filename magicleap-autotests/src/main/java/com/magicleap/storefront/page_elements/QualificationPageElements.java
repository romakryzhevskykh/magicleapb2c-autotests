package com.magicleap.storefront.page_elements;

public class QualificationPageElements {
    private static final String SIGN_UP_FORM = "//div[@class = 'signup-step']//form";
    public static final String COMPANY_NAME_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'Legal Company Name']";
    public static final String DBA_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'DBA']";
    public static final String WEBSITE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'Website']";
    public static final String YEARS_IN_BUSINESS_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder = 'Years In Business']";

    public static final String BUSINESS_TYPE_DROPDOWN_XPATH = "//*[text()='What type of business are you?']//following::div[@class='select-style']";
    public static final String BUSINESS_TYPE_ELEMENT_DROPDOWN_XPATH = "//*[text()='What type of business are you?']//following::div[@class='select-style']/select/option[text()='%s']";
    public static final String MARKET_SEGMENT_DROPDOWN_XPATH = "//*[text()='Market Segment']//following::div[@class='select-style']";
    public static final String MARKET_SEGMENT_ELEMENT_DROPDOWN_XPATH = "//*[text()='Market Segment']//following::div[@class='select-style']/select/option[text()='%s']";

    private static final String RADIO_BUTTON = "//label[@class='radio-style']//input";
    public static final String TYPE_OF_OWNERSHIP_RADIO_BUTTON_XPATH = RADIO_BUTTON + "[@value='%s']";
    public static final String PRIOR_DEALING_RADIO_BUTTON = RADIO_BUTTON + "[@name='priorDealings' and @value='%s']";

    public static final String NEXT_BUTTON_XPATH = "//button[@type='submit']";
    public static final String LOGIN_PAGE_BUTTON_XPATH = "//a[@href='#/login']";

    //Second page, Your Contact Info
    public static final String NAME_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Contact Name']";
    public static final String TITLE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Contact Title']";
    public static final String EMAIL_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Contact Email']";
    public static final String PHONE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Phone']";
    public static final String STREET1_FIELD_XPATH = "//div[@class='form-row']/input[@id='street1']";
    public static final String STREET2_FIELD_XPATH = "//div[@class='form-row no-space']/input[@id='street2']";
    public static final String CITY_FIELD_XPATH = "//div[@class='row form-row no-space']//input[@id='city']";
    public static final String ZIP_CODE_FIELD_XPATH = "//div[@class='col col-4']//input[@id='zip']";

    public static final String STATE_DROPDOWN_FIELD_XPATH = "//div[@class='col col-3']/div[@class='select-style']";
    public static final String STATE_DROPDOWN_ELEMENT_FIELD_XPATH = "//div[@class='col col-3']/div[@class='select-style']/select/option[@value='%s']";

    public static final String BACK_BUTTON_XPATH = "//button[@type='button']";

    //Third page, Your Payment Info
    public static final String EMAIL_TO_SEND_INVOICE_FIELD_XPATH = SIGN_UP_FORM + "/input[@placeholder='Email address to send invoices to']";

    public static final String TAX_EXEMPT_RADIO_BUTTON_XPATH = RADIO_BUTTON + "[@name='taxExempt' and @value='%s']";
    public static final String BILLING_ADDRESS_DIFFERENT_RADIO_BUTTON_XPATH = RADIO_BUTTON + "[@name='isBillingAddressDifferent' and @value='%s']";
    public static final String SHIPPING_ADRESS_DIFFERENT_RADIO_BUTTON_XPATH = RADIO_BUTTON + "[@name='isShippingAddress' and @value='%s']";
    public static final String FORM_OF_PAYMENT_RADIO_BUTTON_XPATH = RADIO_BUTTON + "[@name='paymentMethod' and @value='%s']";

    public static final String GET_QUALIFIED_BUTTON_XPATH = "//button[@type='submit']";
}

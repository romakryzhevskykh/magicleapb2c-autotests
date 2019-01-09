package com.geempower.storefront.page_elements;

public class VolumeRebatePageElements {
    public static String AVR_LIST_XPATH = "//div[@class='tab-pane active fade in']//div[contains(@class, 'avr-rebates')]/div";
    public static String VOLUME_REBATE_PAGE_TITLE_XPATH = "//h3";
    public static String LIST_OF_SETTLEMENT_PARTNER_AND_INFO_ERROR_MESSAGES_XPATH = "//div[@class='tab-pane active fade in']/div[contains(@class, 'disclaimer')]";
    public static String CURRENT_YEAR_SWITCHER_VALUE_XPATH = "//a[@data-toggle='pill']";
    public static String CURRENCY_LABEL_XPATH = "//div[@class='panel-title text-center']//span[@class='pull-right']";
    public static String CURRENT_PAYOUT_LABEL_XPATH = "//div[@class='panel-title text-center']//span[1]";
    public static String SEE_DETAILS_BELOW_VALUE_XPATH = "//div[@class='panel-title text-center']//span[2]";
    private static String APPROPRIATE_AVR_XPATH = "//div[contains(@class, 'avr-rebates')]/div[%s]";
    private static String APPROPRIATE_AVR_DETAILS_XPATH = APPROPRIATE_AVR_XPATH + "//div[contains(@class,'avr-panel-title')]//div[contains(@class, 'p-15')]";
    public static String APPROPRIATE_AVR_ID_XPATH = APPROPRIATE_AVR_DETAILS_XPATH + "/div[1]";
    public static String APPROPRIATE_AVR_TYPE_XPATH = APPROPRIATE_AVR_DETAILS_XPATH + "/div[2]";
    public static String IS_AVR_EXPANDED_FLAG_XPATH = APPROPRIATE_AVR_XPATH + "//a[@data-toggle]";
    public static String OPEN_APPROPRIATE_AVR_ICON_XPATH = APPROPRIATE_AVR_XPATH + "//div[contains(@class,'avr-panel-arrow')]/a/i";
    public static String GRAPH_FOR_APPROPRIATE_AVR_XPATH = APPROPRIATE_AVR_XPATH + "//*[@class='highcharts-plot-background']";
    public static String APPROPRIATE_NEXT_TARGET_VALUE_XPATH = "//div[@class='tab-pane active fade in']" + APPROPRIATE_AVR_XPATH + "//div[contains(@class, 'pl-0 graph-label')]";
    public static String APPROPRIATE_AVR_CURRENT_VOLUME_LABEL_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[1]/div[1]/div[@class='col-xs-7']";
    public static String APPROPRIATE_AVR_CURRENT_PAYOUT_LABEL_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[1]/div[2]/div[@class='col-xs-7']";
    public static String APPROPRIATE_AVR_CURRENT_PAYOUT_VALUE_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[1]/div[2]/div[2]";
    public static String APPROPRIATE_AVR_TARGET_REACHED_LABEL_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[2]/div[1]/div[@class='col-xs-7']";
    public static String PAYOUT_OR_CURRENT_REBATE_LABEL_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[2]/div[2]/div[@class='col-xs-7']";
    public static String TARGET_REACHED_VALUE_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[2]/div[1]/div[@class='col-xs-5 text-bold pl-0']";
    public static String DIFF_TO_NEXT_TARGET_LABEL_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[3]/div[1]/div[@class='col-xs-7']";
    public static String NEXT_TARGET_LABEL_XPATH = APPROPRIATE_AVR_XPATH + "//ul[@class]/li[3]/div[2]/div[@class='col-xs-7']";
    public static String APPROPRIATE_AVR_CALCULATOR_XPATH = APPROPRIATE_AVR_XPATH + "//div[contains(@class,'avr-calculations')]";
    public static String CALCULATOR_CUSTOMER_PROJECTION_LABEL_XPATH = APPROPRIATE_AVR_CALCULATOR_XPATH + "//div[1]/div[1]/label";
    public static String CALCULATOR_CUSTOMER_PROJECTION_FIELD_XPATH = APPROPRIATE_AVR_CALCULATOR_XPATH + "//div[1]/div[2]/input";
    public static String CALCULATOR_PROJECTION_PAYOUT_LABEL_XPATH = APPROPRIATE_AVR_CALCULATOR_XPATH + "//div[2]/div[1]/label";
    public static String CALCULATOR_PROJECTION_PAYOUT_FIELD_XPATH = APPROPRIATE_AVR_CALCULATOR_XPATH + "//div[2]/div[2]/input";
    public static String SAVE_PROJECTION_PAYOUT_ICON_XPATH = APPROPRIATE_AVR_CALCULATOR_XPATH + "//i[@class='fas fa-save']";
}

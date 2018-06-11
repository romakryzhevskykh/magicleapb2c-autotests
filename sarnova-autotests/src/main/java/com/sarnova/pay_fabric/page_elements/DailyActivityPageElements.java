package com.sarnova.pay_fabric.page_elements;

public class DailyActivityPageElements {
    public static final String RUN_REPORT_BUTTON_XPATH = "//input[@value='Run Report']";

    public static final String DAILY_ACTIVITY_TABLE_XPATH = "//table[@id='trxdailyactivitylist']";
    public static final String TRANSACTION_ITEMS_XPATH = DAILY_ACTIVITY_TABLE_XPATH + "/tbody/tr[not(@class='jqgfirstrow')]";

}

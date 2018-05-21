package com.geempower.storefront.page_block_elements;

public class OrderStatusWidgetElements {

    public final static String ORDER_STATUS_WIDGET_TITLE_XPATH = "//div[contains(@class,'trainingLayerOrderDashboardTooltip')]//h3[@class='pull-left']";
    public final static String LAST_150_ORDERS_XPATH = "//p[@class='label-text summary-period-text']";
    private final static String TOTAL_ORDER_SUMMARY_XPATH = "//div[@class='total-order-summary']";
    public final static String TOTAL_ORDERS_SUMMARY_COUNT_XPATH = TOTAL_ORDER_SUMMARY_XPATH + "/h3";
    public final static String TOTAL_ORDERS_SUMMARY_TITLE_XPATH = TOTAL_ORDER_SUMMARY_XPATH + "/p";
    public final static String TOTAL_ORDERS_LINK_XPATH = "//div[@class='col-xs-12 col-sm-3']/a";
    private final static String OPENED_ORDERS_XPATH = "//div[@id='pie-chart-open']";
    private final static String SHIPPED_ORDERS_XPATH = "//div[@id='pie-chart-shipped']";
    private final static String ON_HOLD_ORDERS_XPATH = "//div[@id='pie-chart-hold']";
    private final static String CANCELLED_ORDERS_XPATH = "//div[@id='pie-chart-cancelled']";
    private final static String COUNT_OF_APPROPRIATE_ORDERS_XPATH = "//*[@class='highcharts-title']";
    private final static String STATUS_OF_APPROPRIATE_ORDERS_XPATH = "//*[@class='highcharts-subtitle']";

    public final static String OPENED_ORDERS_COUNT_XPATH = OPENED_ORDERS_XPATH + COUNT_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String OPENED_ORDERS_TITLE_XPATH = OPENED_ORDERS_XPATH + STATUS_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String OPENED_ORDERS_LINK_XPATH = OPENED_ORDERS_XPATH + "/../../a";

    public final static String SHIPPED_ORDERS_COUNT_XPATH = SHIPPED_ORDERS_XPATH + COUNT_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String SHIPPED_ORDERS_TITLE_XPATH = SHIPPED_ORDERS_XPATH + STATUS_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String SHIPPED_ORDERS_LINK_XPATH = SHIPPED_ORDERS_XPATH + "/../../a";

    public final static String ON_HOLD_ORDERS_COUNT_XPATH = ON_HOLD_ORDERS_XPATH + COUNT_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String ON_HOLD_ORDERS_TITLE_XPATH = ON_HOLD_ORDERS_XPATH + STATUS_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String ON_HOLD_ORDERS_LINK_XPATH = ON_HOLD_ORDERS_XPATH + "/../../a";

    public final static String CANCELLED_ORDERS_COUNT_XPATH = CANCELLED_ORDERS_XPATH + COUNT_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String CANCELLED_ORDERS_TITLE_XPATH = CANCELLED_ORDERS_XPATH + STATUS_OF_APPROPRIATE_ORDERS_XPATH;
    public final static String CANCELLED_ORDERS_LINK_XPATH = CANCELLED_ORDERS_XPATH + "/../../a";
}


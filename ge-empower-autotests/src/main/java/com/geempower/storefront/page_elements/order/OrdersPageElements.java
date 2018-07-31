package com.geempower.storefront.page_elements.order;

public class OrdersPageElements {
    public final static String ALL_ORDERS_TITLE_XPATH = ".//*[@id='page']/section/div/div/div/div[1]/div[1]/h3";
    public final static String COUNT_OF_PAGES_WITH_ORDERS_XPATH = "//span[@class='paginate_of']";
    public final static String ORDER_TABLE_SIZE_PER_PAGE_XPATH = "//table[@id='DataTables_Table_0']/tbody/tr";
    public final static String NEXT_ORDER_PAGE_XPATH = "//i[@class='fa fa-angle-right']";
    public final static String EMPTY_ORDERS_TABLE_XPATH = "//td[@class='dataTables_empty']";
    public final static String FIRST_ORDER_IN_APPROPRIATE_STATUS_XPATH = "//td[@class='table-visible-lg-block sorting_1' and contains(text(), '%s')]//..//../tr[1]/td[1]/a";
    public final static String SORTING_ORDERS_TABLE_ICON_BY_STATUS_ID = "sortStatus";
    public final static String ORDER_LINK_BY_ORDER_NO_XPATH = "//td/a[contains(@href, '%s')]";
}

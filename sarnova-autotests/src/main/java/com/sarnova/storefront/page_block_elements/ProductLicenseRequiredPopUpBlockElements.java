package com.sarnova.storefront.page_block_elements;

public class ProductLicenseRequiredPopUpBlockElements {
    public static final String HAS_NO_LICENSE_SELECT_BOX_ID = "CheckoutLicenseRequired_noLicense";
    public static final String CONTINUE_BUTTON_XPATH = "//div[div/span[.='Products required license']]//button[.='Continue']";

    private static final String PRODUCTS_ROWS_XPATH = "//div[div/span[.='Products required license']]//table//tr";
    public static final String PRODUCTS_SKUS_XPATH = PRODUCTS_ROWS_XPATH + "/td[@class='sku']";
}

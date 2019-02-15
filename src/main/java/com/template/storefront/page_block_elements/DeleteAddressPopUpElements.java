package com.template.storefront.page_block_elements;

public class DeleteAddressPopUpElements {

    private static final String POP_UP_XPATH = "//div[@id='cboxContent']";
    public static final String DELETE_BUTTON_BY_ID_XPATH = POP_UP_XPATH + "//div[@class='modal-actions']//a[@href = 'remove-address/%s']";
    public static final String CANCEL_BUTTON_BY_ID_XPATH = POP_UP_XPATH + "//div[@class='modal-actions']//a[contains(@class,'closeColorBox') and @data-address-id='%s']";
}

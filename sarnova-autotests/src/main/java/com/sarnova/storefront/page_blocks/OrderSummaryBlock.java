package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class OrderSummaryBlock extends UIComponent {

    private static final String PRODUCT_ROW_PATH = "//*[div[@class='product-details product-brief']//span[@class='product-article'][.='Item #: %s'] and div[@class= 'product-sold-by table-item-property'][contains(., '%s')]]";
    private static final By STOCK_WARNING_MESSAGE = By.className("error-message");

    public boolean isWarningMessageDisplayedForProduct(String skuId, String uom) {
        return isElementPresentInside(getCheckoutProductElement(skuId, uom), STOCK_WARNING_MESSAGE);
    }

    private WebElement getCheckoutProductElement(String skuId, String uom) {
        return $(PRODUCT_ROW_PATH, skuId, uom);
    }
}

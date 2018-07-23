package com.geempower.storefront.pages.product;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.product.ProductSubDetailPageElements.*;

@Component
public class ProductSubDetailPage extends StorefrontBasePage {

    private final String pageUri = "product/sub-detail?product=";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

    @Step("Choose selected product by catalog no.")
    public void chooseSelectedProductsByCatalogNo(String catalogNo) {
        waitUntilPageIsFullyLoaded();
        $(SELECTED_PRODUCT_CHECKBOX_XPATH, catalogNo.toUpperCase()).click();
    }

    @Step("Click on add to cart button")
    public void clickOnAddToCartButton() {
        $(ADD_TO_CART_BUTTON_XPATH).click();
    }

    @Step("Getting the line items value from checkout pop-up")
    public Integer getLineItemsValue() {
        return Integer.parseInt($(LINE_ITEMS_VALUE_XPATH).getText());
    }

    @Step("Getting the order value from checkout pop-up")
    public String getOrderValueFromCheckoutPopUp() {
        waitUntilPageIsFullyLoaded();
        String orderValue = $(ORDER_VALUE_XPATH).getText();
        return orderValue.substring(0, orderValue.length() - 4);
    }

    @Step("Click on Catalog No Link.")
    public void clickOnCatalogNoLink(String catalogNo) {
        waitUntilPageIsFullyLoaded();
        $(CATALOG_NO_LINK_XPATH, catalogNo).click();
    }
}

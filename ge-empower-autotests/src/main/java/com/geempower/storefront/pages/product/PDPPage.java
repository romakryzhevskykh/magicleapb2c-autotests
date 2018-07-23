package com.geempower.storefront.pages.product;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;

import static com.geempower.storefront.page_elements.product.PDPPageElements.*;

@Component
public class PDPPage extends StorefrontBasePage {

    private final String pageUri = "p/product_detail";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

    public String getCatalogNoHeaderTitle() {
       return $(CATALOG_NO_HEADER_TITLE).getText();
    }
}

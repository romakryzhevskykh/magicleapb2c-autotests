package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;

@Component
public class OrdersPage extends StorefrontBasePage {

    private final String pageUri = "user/viewOrderHistory.action";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }
}

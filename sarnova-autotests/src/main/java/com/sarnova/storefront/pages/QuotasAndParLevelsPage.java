package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class QuotasAndParLevelsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/quotas-and-par-levels";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

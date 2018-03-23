package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class CustomCategoryPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/custom-category";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

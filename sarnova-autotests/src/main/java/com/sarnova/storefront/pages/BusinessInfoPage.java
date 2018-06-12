package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class BusinessInfoPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-company/organization-management/manage-units/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

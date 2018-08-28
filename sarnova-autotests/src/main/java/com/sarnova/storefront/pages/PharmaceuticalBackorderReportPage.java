package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class PharmaceuticalBackorderReportPage extends StorefrontBasePage {

    private String pageUrlMethod = "pharmaceutical-backorder-report";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

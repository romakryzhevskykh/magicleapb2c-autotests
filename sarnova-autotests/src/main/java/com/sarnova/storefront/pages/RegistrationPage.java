package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class RegistrationPage extends StorefrontBasePage {

    private String pageUrlMethod = "register";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

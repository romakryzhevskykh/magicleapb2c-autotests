package com.template.storefront.models;

import com.template.hybris.Cockpit;
import com.template.storefront.pages.LoginPageStorefront;
import org.springframework.beans.factory.annotation.Autowired;

public class TemplateStorefront extends Cockpit {
    @Autowired LoginPageStorefront loginPage;

    public TemplateStorefront(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}

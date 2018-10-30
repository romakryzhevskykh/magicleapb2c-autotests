package com.magicleap.storefront.models;

import com.magicleap.hybris.Cockpit;
import com.magicleap.storefront.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class TemplateStorefront extends Cockpit {
    @Autowired LoginPage loginPage;

    public TemplateStorefront(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}

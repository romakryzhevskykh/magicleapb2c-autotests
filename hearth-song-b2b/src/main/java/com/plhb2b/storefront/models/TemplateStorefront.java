package com.plhb2b.storefront.models;

import com.plhb2b.hybris.Cockpit;
import com.plhb2b.hybris.Cockpit;
import com.plhb2b.storefront.pages.LoginPage;
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

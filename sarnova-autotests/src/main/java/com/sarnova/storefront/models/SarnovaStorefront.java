package com.sarnova.storefront.models;

import com.sarnova.hybris.Cockpit;
import com.sarnova.storefront.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SarnovaStorefront extends Cockpit {

    @Autowired LoginPage loginPage;

    public SarnovaStorefront(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}

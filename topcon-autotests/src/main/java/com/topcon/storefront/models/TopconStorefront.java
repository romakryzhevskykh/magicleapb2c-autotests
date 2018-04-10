package com.topcon.storefront.models;

import com.topcon.hybris.Cockpit;
import com.topcon.storefront.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class TopconStorefront extends Cockpit {
    @Autowired LoginPage loginPage;

    public TopconStorefront(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}

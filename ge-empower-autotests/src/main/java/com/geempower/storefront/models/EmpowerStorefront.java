package com.geempower.storefront.models;

import com.geempower.hybris.Cockpit;
import com.geempower.storefront.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpowerStorefront extends Cockpit {
    private final String ssoLoginUrl;
    @Autowired
    private LoginPage loginPage;

    public EmpowerStorefront(String baseUrl, String ssoLoginUrl) {
        this.baseUrl = baseUrl;
        this.ssoLoginUrl = ssoLoginUrl;
    }

    public String getSsoLoginUrl() {
        return ssoLoginUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}

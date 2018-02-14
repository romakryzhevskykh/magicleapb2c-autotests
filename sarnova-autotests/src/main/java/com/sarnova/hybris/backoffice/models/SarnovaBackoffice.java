package com.sarnova.hybris.backoffice.models;

import com.sarnova.hybris.Cockpit;
import com.sarnova.hybris.backoffice.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SarnovaBackoffice extends Cockpit {

    @Autowired LoginPage loginPage;

    public SarnovaBackoffice(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}

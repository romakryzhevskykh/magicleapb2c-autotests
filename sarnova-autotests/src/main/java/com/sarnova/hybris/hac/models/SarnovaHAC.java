package com.sarnova.hybris.hac.models;

import com.sarnova.hybris.Cockpit;
import com.sarnova.hybris.hac.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SarnovaHAC extends Cockpit {

    @Autowired LoginPage loginPage;

    public SarnovaHAC(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}

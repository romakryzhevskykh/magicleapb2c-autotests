package com.geempower.hybris.hac.models;

import com.geempower.hybris.Cockpit;

public class TemplateHAC extends Cockpit {

    public TemplateHAC(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}

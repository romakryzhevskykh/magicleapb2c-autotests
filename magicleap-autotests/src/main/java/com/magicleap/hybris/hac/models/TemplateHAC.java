package com.magicleap.hybris.hac.models;

import com.magicleap.hybris.Cockpit;

public class TemplateHAC extends Cockpit {

    public TemplateHAC(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}

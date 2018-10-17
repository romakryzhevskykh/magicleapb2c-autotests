package com.plhb2b.hybris.hac.models;

import com.plhb2b.hybris.Cockpit;
import com.plhb2b.hybris.Cockpit;

public class TemplateHAC extends Cockpit {

    public TemplateHAC(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}

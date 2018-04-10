package com.topcon.hybris.hac.models;

import com.topcon.hybris.Cockpit;

public class TopconHAC extends Cockpit {

    public TopconHAC(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}

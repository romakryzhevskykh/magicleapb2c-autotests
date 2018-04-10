package com.topcon.hybris.backoffice.models;

import com.topcon.hybris.Cockpit;

public class TopconBackoffice extends Cockpit {

    public TopconBackoffice(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}

package com.topcon.hybris.import_cockpit.models;

import com.topcon.hybris.Cockpit;

public class TopconImportCockpit extends Cockpit {

    public TopconImportCockpit(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}

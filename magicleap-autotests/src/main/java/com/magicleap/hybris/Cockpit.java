package com.magicleap.hybris;

public abstract class Cockpit {
    protected String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public abstract String getLoginUrl();
}

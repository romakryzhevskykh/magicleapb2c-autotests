package com.sarnova.helpers.web_engine;

import java.net.URL;

public class WebDriverSetups {
    private URL hubUrl;
    private String browserName;
    private final boolean headless;

    public WebDriverSetups(URL hubUrl, String browserName, String headless) {
        this.hubUrl = hubUrl;
        this.browserName = browserName;
        this.headless = Boolean.valueOf(headless);
    }

    public URL getHubUrl() {
        return hubUrl;
    }

    public String getBrowserName() {
        return browserName;
    }

    public boolean isHeadless() {
        return headless;
    }
}

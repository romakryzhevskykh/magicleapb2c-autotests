package com.template.helpers.web_engine;

import java.net.URL;

public class WebDriverSetups {
    private URL hubUrl;
    private String browserName;

    public WebDriverSetups(URL hubUrl, String browserName) {
        this.hubUrl = hubUrl;
        this.browserName = browserName;
    }

    public URL getHubUrl() {
        return hubUrl;
    }

    public String getBrowserName() {
        return browserName;
    }
}

package com.template.helpers.web_engine;

import lombok.Getter;

import java.net.URL;

public class WebDriverSetups {
    @Getter private URL hubUrl;
    @Getter private String browserName;
    @Getter private final boolean headless;

    public WebDriverSetups(URL hubUrl, String browserName, String headless) {
        this.hubUrl = hubUrl;
        this.browserName = browserName;
        this.headless = Boolean.valueOf(headless);
    }
}

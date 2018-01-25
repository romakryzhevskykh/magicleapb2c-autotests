package com.sarnova.helpers;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridSettings {

    private URL hubUrl;

    public SeleniumGridSettings(String hubUrl) throws MalformedURLException {
        if (hubUrl != null && !hubUrl.isEmpty())
            this.hubUrl = new URL(hubUrl);
    }

    public URL getHubUrl() {
        return hubUrl;
    }
}

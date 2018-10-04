package com.template.helpers;

import org.openqa.selenium.UnhandledAlertException;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public abstract class BasePageObject extends UIComponent {

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getDecodedCurrentUrl() {
        try {
            return URLDecoder.decode(getCurrentUrl(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    public void open() {
        open(getPageUrl());
    }

    @Step("Open page {0}.")
    protected void open(String url) {
        try {
            getDriver().get(url);
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert: " + ex);
            alertHandling();
            open(url);
        }
        waitUntilPageIsFullyLoaded();
    }

    public abstract String getPageUrl();

    @Step("Refresh page.")
    public void refreshPage() {
        getDriver().navigate().refresh();
        waitUntilPageIsFullyLoaded();
    }
}
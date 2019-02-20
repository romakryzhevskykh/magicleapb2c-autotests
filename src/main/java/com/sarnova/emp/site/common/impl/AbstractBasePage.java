package com.sarnova.emp.site.common.impl;

import com.sarnova.emp.framework.FrameworkConfiguration;
import com.sarnova.emp.site.common.Page;
import com.sarnova.emp.site.content.component.Header;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public abstract class AbstractBasePage extends AbstractStore implements Page {

    @Autowired
    private FrameworkConfiguration frameworkConfiguration;
    @Autowired
    private Header header;

    @Override
    public Header getHeader() {
        return header;
    }

    public String getCurrentUrl() {
        return url();
    }

    @Override
    public void openPage() {
        final String pageUrl = frameworkConfiguration.getStoreBaseUrl() + getPageUrl();
        open(pageUrl);
        waitForLoad();
        if (!isLoaded()) {
            throw new RuntimeException(" Page isn't loaded");
        }
    }

    protected abstract String getPageUrl();
}

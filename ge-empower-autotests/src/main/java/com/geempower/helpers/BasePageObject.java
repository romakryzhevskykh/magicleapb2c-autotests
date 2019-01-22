package com.geempower.helpers;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePageObject extends UIComponent {

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    @Autowired
    private Utils utils;

    public void open() {
        System.out.println("Open backoffice at:" + utils.getLocalDateTimeStamp());
        open(getPageUrl());
    }

    public abstract String getPageUrl();

}
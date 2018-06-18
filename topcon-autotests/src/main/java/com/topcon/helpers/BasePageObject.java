package com.topcon.helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public abstract class BasePageObject extends UIComponent {

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

//    public String getDecodedCurrentUrl() {
//        try {
//            return URLDecoder.decode(getCurrentUrl(), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            System.out.println(e);
//            return null;
//        }
//    }

    public void open() {
        open(getPageUrl());
    }

    public abstract String getPageUrl();

    public void refreshPage() {
        getDriver().navigate().refresh();
        waitUntilPageIsFullyLoaded();
    }
}
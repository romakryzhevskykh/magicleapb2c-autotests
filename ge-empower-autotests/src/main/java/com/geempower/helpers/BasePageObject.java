package com.geempower.helpers;

import ru.yandex.qatools.allure.annotations.Step;

public abstract class BasePageObject extends UIComponent {

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    public void open() {
        open(getPageUrl());
    }

    public abstract String getPageUrl();

    @Step("Refresh the page.")
    public void refreshCurrentPage() {
        getDriver().navigate().refresh();
    }

    @Step("Focus on browser.")
    public void focusOnActiveBrowser() {
        getDriver().switchTo().window(getDriver().getWindowHandle());
    }
}
package com.sarnova.emp.site.common;

import com.codeborne.selenide.SelenideElement;

public interface Store {

    void waitForLoad();

    boolean isLoaded();

    SelenideElement getLoadableElement();
}

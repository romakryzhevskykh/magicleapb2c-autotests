package com.sarnova.emp.site.common.impl;

import com.codeborne.selenide.Condition;
import com.sarnova.emp.site.common.Store;

public abstract class AbstractStore implements Store {

    @Override
    public void waitForLoad() {
        getLoadableElement().shouldBe(Condition.visible);
    }

    @Override
    public boolean isLoaded() {
        return getLoadableElement().exists();
    }
}

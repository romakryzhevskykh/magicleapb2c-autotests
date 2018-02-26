package com.geempower.storefront;

import com.geempower.helpers.BasePageObject;
import com.geempower.storefront.models.EmpowerStorefront;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;

public abstract class StorefrontBasePage extends BasePageObject {
    @Autowired
    protected EmpowerStorefront storefrontProject;

    @Step("Check that Shipping address book page is opened.")
    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    public void open() {
        open(getPageUrl());
    }

    public abstract String getPageUrl();
}

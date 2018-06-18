package com.topcon.storefront.pages;

import com.topcon.helpers.BasePageObject;
import com.topcon.storefront.models.TopconStorefront;
import com.topcon.storefront.page_blocks.HeaderRowPageBlock;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;

public abstract class StorefrontBasePage extends BasePageObject {
    @Autowired
    public TopconStorefront storefrontProject;
    @Autowired private HeaderRowPageBlock headerRowPageBlock;

    protected boolean isUserLoggedIn() {
        return headerRowPageBlock.isUserLoggedIn();
    }

    protected boolean isUserLoggedOut() {
        return headerRowPageBlock.isUserLoggedOut();
    }

    @Step("Check that Shipping address book page is opened.")
    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    public abstract String getPageUrl();
}

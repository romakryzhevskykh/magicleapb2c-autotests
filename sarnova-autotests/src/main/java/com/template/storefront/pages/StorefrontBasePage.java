package com.template.storefront.pages;

import com.template.helpers.BasePageObject;
import com.template.storefront.models.TemplateStorefront;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;

public abstract class StorefrontBasePage extends BasePageObject {
    @Autowired TemplateStorefront storefrontProject;

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

    public void open() {
        open(getPageUrl());
    }

    public abstract String getPageUrl();
}

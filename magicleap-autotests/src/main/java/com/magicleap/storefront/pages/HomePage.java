package com.magicleap.storefront.pages;

import com.magicleap.storefront.page_blocks.HeaderRowPageBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.magicleap.storefront.page_elements.HomePageElements.*;

@Component
public class HomePage extends StorefrontBasePage {

    @Autowired HeaderRowPageBlock headerRowPageBlock;

    private final String pageUrlMethod = "/";

    public boolean isOpened() {
        return isCurrentURLEqualsToHomePageURL() && isUserLoggedIn();
    }

    @Step("Check that current url is Home page url.")
    private boolean isCurrentURLEqualsToHomePageURL() {
        return getPageUrl().equals(getCurrentUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Check that page overlay presence")
    public boolean isOverlayEnabled(){
        return isPresent(PAGE_OVERLAY_XPATH);
    }
}

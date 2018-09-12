package com.geempower.storefront.pages.returns;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.returns.ReturnsCreation1PageElements.*;

@Component
public class ReturnCreation1Page extends StorefrontBasePage {

    @Autowired
    private Utils utils;

    private final String pageUri = "returnRequest";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

}
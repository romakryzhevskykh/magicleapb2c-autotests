package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.ReturnsPageElements.*;


@Component
public class ReturnsPage extends StorefrontBasePage {
    private final String pageUri = "returnTracking";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Returns title")
    public String getReturnsTitle() {
        return $(ALL_CASES_TITLE_XPATH).getText();
    }
}


package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.RebatesPageElements.*;


@Component
public class RebatesPage extends StorefrontBasePage {
    private final String pageUri = "rebate";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Rebates title")
    public String getRebatesTitle() {
        return $(ALL_REBATES_TITLE_XPATH).getText();
    }
}

package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.SpecialPricingElements.*;


@Component
public class SpecialPricingPage extends StorefrontBasePage {
    private final String pageUri = "specialPricing";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Rebates title")
    public String getSpecialPricingTitle() {
        return $(ALL_SPECIAL_PRICING_TITLE_XPATH).getText();
    }
}

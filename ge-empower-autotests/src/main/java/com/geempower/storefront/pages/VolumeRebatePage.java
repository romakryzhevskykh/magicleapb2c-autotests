package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.VolumeRebatePageElements.AVR_LIST_XPATH;

@Component
public class VolumeRebatePage extends StorefrontBasePage {

    private final String pageUri = "annualVolumeRebate";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Count Of Avrs.")
    public int getCountOfAvrs() {
        waitUntilPageIsFullyLoaded();
        return $$(AVR_LIST_XPATH).size();
    }
}

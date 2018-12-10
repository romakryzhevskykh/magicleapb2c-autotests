package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.VolumeRebatePageElements.AVR_LIST_XPATH;
import static com.geempower.storefront.page_elements.VolumeRebatePageElements.LIST_OF_SETTLEMENT_PARTNER_AND_INFO_ERROR_MESSAGES_XPATH;
import static com.geempower.storefront.page_elements.VolumeRebatePageElements.VOLUME_REBATE_PAGE_TITLE_XPATH;

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

    public String getPageTitle() {
        waitUntilPageIsFullyLoaded();
        return $(VOLUME_REBATE_PAGE_TITLE_XPATH).getText();
    }

    public List<String> getListOfMessages() {
        return $$(LIST_OF_SETTLEMENT_PARTNER_AND_INFO_ERROR_MESSAGES_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

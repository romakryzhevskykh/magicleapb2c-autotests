package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.PriceAndAvailabilityPageElements.*;

@Component
public class PriceAndAvailabilityPage extends StorefrontBasePage {
    private final String pageUri = "check-price-availability";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Select all checkboxes")
    public void clickOnAllCheckboxes() {
        click(ALL_CHECKBOXES_XPATH);
    }

    @Step("Click on Add to Card button")
    public void clickOnAddToCartButton() {
        click(ADD_TO_CARD_BUTTON_XPATH);
    }
}

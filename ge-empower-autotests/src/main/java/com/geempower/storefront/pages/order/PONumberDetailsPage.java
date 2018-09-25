package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class PONumberDetailsPage extends StorefrontBasePage {
    private final String pageUri = "orders/details/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("PO Details page is opened.")
    public boolean isOpened(String orderNo) {
        return getCurrentUrl().contains(orderNo);
    }
}
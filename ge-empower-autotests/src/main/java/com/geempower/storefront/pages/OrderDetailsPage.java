package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.OrderDetailsPageElements.*;

@Component
public class OrderDetailsPage extends StorefrontBasePage {
    private final String pageUri = "orders/details/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Correct page is opened.")
    public boolean isOpened(String orderNo) {
        return getCurrentUrl().equals(getPageUrl().concat(orderNo));
    }

    @Step("Get GE order NO.")
    public String getGeOrderNo() {
        return $(GE_ORDER_NO_XPATH).getText();
    }

    @Step("Get Total Net Price")
    public String getTotalNetPrice() {
        String netPrice = $(TOTAL_NET_PRICE_VALUE_XPATH).getText();
        return netPrice.substring(0, netPrice.length() - 4).replace(",","");
    }
}

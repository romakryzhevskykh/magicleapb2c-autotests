package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.order.OrdersPageElements.*;

@Component
public class OrdersPage extends StorefrontBasePage {

    private final String pageUri = "user/viewOrderHistory.action";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Get Orders title")
    public String getOrdersTitle() {
        return $(ALL_ORDERS_TITLE_XPATH).getText();
    }


}
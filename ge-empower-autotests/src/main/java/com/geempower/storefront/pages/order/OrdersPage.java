package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.NoSuchElementException;
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

    private int getCountOfPagesWithOrders() {
        String countOfPages = $(COUNT_OF_PAGES_WITH_ORDERS_XPATH).getText();
        int actualCount = 0;
        if (!countOfPages.equals("")) {
            actualCount = Integer.parseInt(countOfPages.replace("of ", ""));
        } else if (!isOrdersTableEmpty() && countOfPages.equals("")) {
            actualCount = 1;
        } else if (isOrdersTableEmpty()) {
            actualCount = 0;
        }
        return actualCount;
    }

    private boolean isOrdersTableEmpty() {
        try {
            return $(EMPTY_ORDERS_TABLE_XPATH).isDisplayed();
        } catch (NoSuchElementException | NullPointerException exception) {
            return false;
        }
    }

    @Step("Get actual count of orders with appropriate status")
    public int getActualCountOfOrders() {
        int ordersCount = 0;
        int actualCountOfOrderPages = getCountOfPagesWithOrders();
        if (actualCountOfOrderPages != 0) {
            for (int i = 0; i < actualCountOfOrderPages; i++) {
                ordersCount += $$(ORDER_TABLE_SIZE_PER_PAGE_XPATH).size();
                if (i != actualCountOfOrderPages - 1) {
                    click(NEXT_ORDER_PAGE_XPATH);
                }
                waitUntilPageIsFullyLoaded();
            }
        }
        return ordersCount;
    }
}
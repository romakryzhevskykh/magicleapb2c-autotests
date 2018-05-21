package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.geempower.storefront.page_block_elements.OrderStatusWidgetElements.*;

@Component
public class OrderStatusWidget extends UIComponent {

    @Step("Get widget title.")
    public String getWidgetTitle() {
        waitUntilPageIsFullyLoaded();
        return $(ORDER_STATUS_WIDGET_TITLE_XPATH).getText();
    }

    @Step("Get Last Count Of Orders Title.")
    public String getLastCountOfOrdersTitle() {
        return $(LAST_150_ORDERS_XPATH).getText();
    }

    @Step("Get Total Orders Status.")
    public String getTotalOrdersStatus() {
        return $(TOTAL_ORDERS_SUMMARY_TITLE_XPATH).getText();
    }

    @Step("Get Count Of Total Orders.")
    public int getCountOfTotalOrders() {
        return Integer.parseInt($(TOTAL_ORDERS_SUMMARY_COUNT_XPATH).getText());
    }

    @Step("Get Order Statuses From Wrappers.")
    public List<String> getOrderStatusesFromWrappers() {
        List<String> statuses = new ArrayList<>();
        statuses.add($(OPENED_ORDERS_TITLE_XPATH).getText());
        statuses.add($(SHIPPED_ORDERS_TITLE_XPATH).getText());
        statuses.add($(ON_HOLD_ORDERS_TITLE_XPATH).getText());
        statuses.add($(CANCELLED_ORDERS_TITLE_XPATH).getText());
        return statuses;
    }

    @Step("Get Sum Of All Orders In Different Statuses.")
    public int getSumOfAllOrdersInDifferentStatuses() {
        return getOpenedOrdersCount() + getShippedOrdersCount() + getOnHoldOrdersCount() + getCancelledOrdersCount();
    }

    @Step("Get Opened Orders Count.")
    public int getOpenedOrdersCount() {
        return Integer.parseInt($(OPENED_ORDERS_COUNT_XPATH).getText());
    }

    @Step("Get Shipped Orders Count.")
    public int getShippedOrdersCount() {
        return Integer.parseInt($(SHIPPED_ORDERS_COUNT_XPATH).getText());
    }

    @Step("Get On Hold Orders Count.")
    public int getOnHoldOrdersCount() {
        return Integer.parseInt($(ON_HOLD_ORDERS_COUNT_XPATH).getText());
    }

    @Step("Get Cancelled Orders Count.")
    public int getCancelledOrdersCount() {
        return Integer.parseInt($(CANCELLED_ORDERS_COUNT_XPATH).getText());
    }

    @Step("Open Appropriate List Of Orders By Status.")
    public void openAppropriateListOfOrdersByStatus(String orderStatus) {
        switch (orderStatus) {
            case "Opened":
                waitUntilPageIsFullyLoaded();
                click(OPENED_ORDERS_LINK_XPATH);
                break;
            case "Shipped":
                waitUntilPageIsFullyLoaded();
                click(SHIPPED_ORDERS_LINK_XPATH);
                break;
            case "On Hold":
                waitUntilPageIsFullyLoaded();
                click(ON_HOLD_ORDERS_LINK_XPATH);
                break;
            case "Cancelled":
                waitUntilPageIsFullyLoaded();
                click(CANCELLED_ORDERS_LINK_XPATH);
                break;
        }
    }
}
package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.order.PONumberDetailsPageElements.*;

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

    @Step("Is Purchase Order Title Displayed On Details PO Number Page.")
    public String  getPurchaseOrderTitleOnDetailsPONumberPage() {
        if (isDisplayed (By.id(PO_NUMBERS_ORDER_TABLE_ID))){
            click(PO_NUMBERS_ORDER_TABLE_SELECT_ALL_CHECKBOX_XPATH);
            click(ACTIVE_NEXT_BUTTON_ABOVE_PO_NUMBERS_ORDER_TABLE_XPATH);
            waitUntilPageIsFullyLoaded();
            return $(PURCHASE_ORDER_TITLE_XPATH).getText();
        } else {
            return $(PURCHASE_ORDER_TITLE_XPATH).getText();
        }
    }
}
package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.InvoiceDetailsPopUpElements.*;
import static com.geempower.storefront.page_elements.order.OrderDetailsPageElements.*;

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

    @Step("Get Total Net Price.")
    public String getTotalNetPrice() {
        String netPrice = $(TOTAL_NET_PRICE_VALUE_XPATH).getText();
        return netPrice.substring(0, netPrice.length() - 4).replace(",","");
    }

    @Step("Click On Expand Order Details Icon.")
    public void clickOnExpandOrderDetailsIcon() {
        waitUntilPageIsFullyLoaded();
        click(EXPAND_ORDER_DETAILS_ICON_XPATH);
    }

    @Step("Click On Invoice Hyper link.")
    public void clickOnInvoiceHyperlink() {
        waitHTMLTemplateLoad();
        click(INVOICE_DOWNLOAD_HYPERLINK_XPATH);
    }

    @Step("Is Pop-Up Appears.")
    public boolean isPopUpAppears() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(INVOICE_DETAILS_POP_UP_XPATH);
    }

    @Step("Get Invoice Details Pop-Up Header.")
    public String getInvoiceDetailsPopUpHeader() {
        return $(INVOICE_DETAILS_HEADER_XPATH).getText();
    }

    @Step("Get Pop-Up Body Text.")
    public String getPopUpBodyText() {
        return $(INVOICE_DETAILS_BODY_TEXT_XPATH).getText();
    }

    @Step("Close Invoice Details Pop-Up.")
    public void closeInvoiceDetailsPopUp() {
        click(INVOICE_DETAILS_POP_UP_CLOSE_BUTTON_XPATH);
    }
}

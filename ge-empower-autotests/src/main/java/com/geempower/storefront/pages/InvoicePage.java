package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.InvoicePageElements.*;


@Component
public class InvoicePage extends StorefrontBasePage {
    private final String pageUri = "invoice";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

    @Step("Get Invoice title")
    public String getInvoicesTitle() {
        return $(ALL_INVOICES_TITLE_XPATH).getText();
    }
}

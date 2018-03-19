package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.ProductsPageElements.*;


@Component
public class ProductsPage extends StorefrontBasePage {
    private final String pageUri = "products";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Products title")
    public String getProductsTitle() {
        return $(ALL_PRODUCTS_TITLE_XPATH).getText();
    }
}

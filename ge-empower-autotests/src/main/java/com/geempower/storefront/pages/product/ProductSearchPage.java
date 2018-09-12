package com.geempower.storefront.pages.product;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.product.ProductsSearchPageElements.*;

@Component
public class ProductSearchPage extends StorefrontBasePage {

    @Autowired
    private Utils utils;

    private final String pageUri = "product/search?onlyOneProduct=false&product";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

}
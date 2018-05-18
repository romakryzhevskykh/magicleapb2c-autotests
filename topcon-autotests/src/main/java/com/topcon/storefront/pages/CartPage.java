package com.topcon.storefront.pages;

import com.topcon.helpers.request_engine.API;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.topcon.storefront.page_elements.CartPageElements.PRODUCTS_IDS_XPATH;

@Component
public class CartPage extends StorefrontBasePage {

    private final String pageUrlMethod = "topcon/en/USD/cart";

    public List<String> getAllAddedProductsIds() {
        return $$(PRODUCTS_IDS_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

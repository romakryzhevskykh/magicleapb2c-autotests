package com.template.storefront.pages;

import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.CartPageElements.*;


@Component
public class CartPage extends StorefrontBasePage {

    private String pageMethodUrl = "cart";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageMethodUrl;
    }

    @Step("Click on Checkout button.")
    public void clickCheckoutButton() {
        $(CHECKOUT_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }
}

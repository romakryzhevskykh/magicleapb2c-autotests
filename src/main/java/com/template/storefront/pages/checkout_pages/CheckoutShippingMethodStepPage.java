package com.template.storefront.pages.checkout_pages;

import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.checkout_page_elements.CheckoutShippingMethodPageElements.NEXT_BUTTON_ID;

@Component
public class CheckoutShippingMethodStepPage extends StorefrontBasePage {

    private final String pageUrlMethod = "checkout/multi/delivery-method/choose";

    @Override
    public String getPageUrl() {
        return storefrontProject + pageUrlMethod;
    }

    @Step("Click on Next button.")
    public void clickOnNextButton() {
        $(By.id(NEXT_BUTTON_ID)).click();
    }
}

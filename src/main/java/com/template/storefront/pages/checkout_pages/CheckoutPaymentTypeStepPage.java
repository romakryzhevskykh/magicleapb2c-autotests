package com.template.storefront.pages.checkout_pages;

import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.checkout_page_elements.CheckoutPaymentTypesPageElements.*;

@Component
public class CheckoutPaymentTypeStepPage extends StorefrontBasePage {

    private final String pageUrlMethod = "checkout/multi/payment-type/choose";

    @Override
    public String getPageUrl() {
        return storefrontProject + pageUrlMethod;
    }

    @Step("Select card payment type.")
    public void selectCardPayment() {
        $(By.id(CARD_PAYMENT_RADIO_BUTTON_ID)).click();
    }

    @Step("Click on Next button.")
    public void clickOnNextButton() {
        $(By.id(NEXT_BUTTON_ID)).click();
    }
}

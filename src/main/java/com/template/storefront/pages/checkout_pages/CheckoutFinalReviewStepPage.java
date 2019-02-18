package com.template.storefront.pages.checkout_pages;

import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.checkout_page_elements.CheckoutFinalReviewPageElements.PLACE_ORDER_BUTTON_ID;
import static com.template.storefront.page_elements.checkout_page_elements.CheckoutFinalReviewPageElements.TERMS_CONDITION_CHECKBOX_ID;

@Component
public class CheckoutFinalReviewStepPage extends StorefrontBasePage {

    private String pageUrlMethod = "checkout/multi/cbs-summary/view";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Click on Terms and conditions checkbox.")
    public void clickOnTermsAndConditionsCheckbox() {
        $(By.id(TERMS_CONDITION_CHECKBOX_ID)).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Is Terms and conditions checkbox selected?")
    public boolean isTermsAndConditionsSelected() {
        return $(By.id(TERMS_CONDITION_CHECKBOX_ID)).isSelected();
    }

    @Step("Click on Place order button.")
    public void clickOnPlaceOrderButton() {
        $(By.id(PLACE_ORDER_BUTTON_ID)).click();
        waitUntilPageIsFullyLoaded();
    }
}

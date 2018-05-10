package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.CheckoutFinalReviewStepBlockElements.ACCEPT_TERMS_CHECKBOX_ID;
import static com.sarnova.storefront.page_block_elements.CheckoutFinalReviewStepBlockElements.PLACE_ORDER_BUTTON_ID;

@Component
public class CheckoutFinalReviewStepBlock extends UIComponent {

    private String pageUrlMethod = "multi/summary/view";

    @Step("Is Terms and Conditions checkbox visible?")
    public boolean isAcceptTermsCheckboxVisible() {
        return isDisplayed(By.id(ACCEPT_TERMS_CHECKBOX_ID));
    }

    @Step("Is Place order button visible?")
    public boolean isPlaceOrderButtonVisible() {
        return isDisplayed(By.id(PLACE_ORDER_BUTTON_ID));
    }

    public String getPageUrlMethod() {
        return pageUrlMethod;
    }

    @Step("Confirm Terms and Conditions.")
    public void confirmTerms() {
        if(!isTermsConfirmed()) {
            click(By.id(ACCEPT_TERMS_CHECKBOX_ID));
        }
    }

    @Step("Is T&C confirmed?")
    private boolean isTermsConfirmed() {
        return $(By.id(ACCEPT_TERMS_CHECKBOX_ID)).isSelected();
    }

    @Step("Click on Place order button.")
    public void placeOrder() {
        click(By.id(PLACE_ORDER_BUTTON_ID));
    }
}

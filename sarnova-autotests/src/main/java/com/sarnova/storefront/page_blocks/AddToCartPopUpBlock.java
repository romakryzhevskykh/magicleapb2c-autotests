package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.AddToCartPopUpBlockElements.*;

@Component
public class AddToCartPopUpBlock extends UIComponent {

    @Step("Click on Checkout in Add to cart pop-up.")
    public void clickOnCheckoutButtonInAddToCartPopUp() {
        click(CHECKOUT_BUTTON_XPATH);
    }

    @Step("Get Add to cart pop-up's text content.")
    public String getAddToSupplyListPopUpContent() {
        return $(CONTENT_MESSAGE_TEXT_XPATH).getText().trim();
    }
}

package com.topcon.storefront.page_blocks;

import com.topcon.helpers.UIComponent;
import ru.yandex.qatools.allure.annotations.Step;

import static com.topcon.storefront.page_block_elements.AddToCartPopUpBlockElements.CHECKOUT_BUTTON_XPATH;

public class AddToCartPopupBlock extends UIComponent {

    @Step("Click on checkout in Add to cart pop-up.")
    public void clickOnCheckoutButtonInAddToCartPopup() {
        click(CHECKOUT_BUTTON_XPATH);
    }
}

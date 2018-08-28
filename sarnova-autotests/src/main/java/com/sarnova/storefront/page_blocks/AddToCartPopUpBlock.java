package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.AddToCartPopUpBlockElements.*;

@Component
public class AddToCartPopUpBlock extends UIComponent {

    @Step("Click on Checkout in Add to cart pop-up.")
    public void clickOnCheckoutButtonInAddToCartPopUp() {
        click(CHECKOUT_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Add to cart pop-up's text content.")
    public String getAddToCartPopUpContent() {
        return $(CONTENT_MESSAGE_TEXT_XPATH).getText().trim();
    }

    @Step("Wait images are loaded.")
    public void waitUntilProductImagesAreVisible() {
        if (isDisplayed(By.xpath(CART_POP_UP_IMAGES_XPATH))) {
            $$(CART_POP_UP_IMAGES_XPATH).forEach(webElement ->
                    waitUntil(driver1 -> (webElement.getSize().getHeight() >= 20 && webElement.getSize().getWidth() >= 20))
            );
        }
    }
}

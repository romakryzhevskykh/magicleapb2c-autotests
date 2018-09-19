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
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Continue shopping in Add to cart pop-up.")
    public void clickOnContinueShoppingButtonInAddToCartPopUp() {
        click(CONTINUE_SHOPPING_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Add to cart pop-up's text content.")
    public String getAddToCartPopUpContent() {
        return $(CONTENT_MESSAGE_TEXT_XPATH).getText().trim();
    }

    @Step("Wait product images are loaded.")
    public void waitUntilProductImagesAreVisible() {
        if (isPresent(CART_POP_UP_IMAGES_XPATH)) {
            loadingProductImages();
        }
    }

    @Step("Loading product images.")
    private void loadingProductImages() {
        $$(CART_POP_UP_IMAGES_XPATH).forEach(webElement ->
                waitUntil(driver1 -> (webElement.getSize().getHeight() >= 20 && webElement.getSize().getWidth() >= 20))
        );
    }

    @Step("Wait banner image is loaded.")
    public void waitUntilBannerImageIsVisible() {
        if (isPresent(CART_POP_UP_BANNER_IMAGE_XPATH)) {
            loadingBannerImage();
        }
    }

    @Step("Loading banner image.")
    private void loadingBannerImage() {
        waitUntil(driver1 -> ($(CART_POP_UP_BANNER_IMAGE_XPATH).getSize().getHeight() >= 20
                && $(CART_POP_UP_BANNER_IMAGE_XPATH).getSize().getWidth() >= 20));
    }
}

package com.magicleap.storefront.page_blocks;

import com.magicleap.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.magicleap.storefront.page_block_elements.MiniCartSidebarBlockElements.*;

@Component
public class MiniCartSidebarBlock extends UIComponent {

    @Step("Click on Checkout in Add to cart pop-up.")
    public void clickOnCheckoutButtonInAddToCartPopUp() {
        click(VIEW_CART_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Continue shopping in Add to cart pop-up.")
    public void clickOnContinueShoppingButtonInAddToCartPopUp() {
        click(CONTINUE_SHOPPING_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Add to cart pop-up's text content.")
    public String getAddToCartPopUpContent() {
        return $(CONTENT_BLOCK_TEXT_XPATH).getText().trim();
    }

    @Step("Wait product images are loaded.")
    public void waitUntilProductImagesAreVisible() {
        if (isPresent(MINI_CART_IMAGES_XPATH)) {
            loadingProductImages();
        }
    }

    @Step("Loading product images.")
    private void loadingProductImages() {
        $$(MINI_CART_IMAGES_XPATH).forEach(webElement ->
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

    public void waitUntilVisible() {
        waitUntilElementIsVisible(By.id(MINI_CART_SIDEBAR_XPATH));
    }

    @Step("Wait until sidebar is closed")
    public void waitUntilClosed(){ waitUntilElementNotPresent(MINI_CART_SIDEBAR_XPATH);}

    @Step("Check that Mini Cart sidebar is shown.")
    public boolean isShown() {
        return isPresent(MINI_CART_SIDEBAR_XPATH); }

    @Step("Get current title")
    public String getCartTitle(){
        return $(MINI_CART_TITLE_XPATH).getText().trim();
    }

    @Step("Check that View Cart button is shown.")
    public boolean viewCartButtonIsShown(){
        return isDisplayed(VIEW_CART_BUTTON_XPATH);
    }

    public String getContentBlockText(){
        return $(CONTENT_BLOCK_TEXT_XPATH).getText().trim();
    }

    @Step("Click on X button.")
    public void closeMiniCartSideBar(){
        $(MINI_CART_CLOSE_BUTTON_XPATH).click();
        waitUntilClosed();
    }


}
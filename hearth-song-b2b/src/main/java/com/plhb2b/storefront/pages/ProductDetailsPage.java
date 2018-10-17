package com.plhb2b.storefront.pages;

import com.plhb2b.helpers.managers.products.ProductsManager;
import com.plhb2b.helpers.models.products.Product;
import com.plhb2b.storefront.page_blocks.AddToCartPopUpBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.plhb2b.storefront.page_elements.ProductDetailsPageElements.*;

@Component
public class ProductDetailsPage extends StorefrontBasePage {
    @Autowired private ProductsManager productsManager;

    @Autowired private AddToCartPopUpBlock addToCartPopUpBlock;

    private final String pageUrlMethod = "p/%s";

    @Step("Set QTY: {1} for product: {0}.")
    public void setQTYForProductToValue(Product product, int qty) {
        enterText(String.valueOf(qty), QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH);
    }

    @Step("Open PDP for product {0} by link.")
    public void openPDPForProduct(Product product) {
        open(String.format(getPageUrl(), product.getSku()));
        waitUntilPageIsFullyLoaded();
    }

    public void clickOnCheckoutButtonInAddToCartPopUp() {
        addToCartPopUpBlock.clickOnCheckoutButtonInAddToCartPopUp();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    public String getAddToCartPopUpContent() {
        return addToCartPopUpBlock.getAddToCartPopUpContent();
    }

    public void clickOnAddToCartButton() {
        click(ADD_TO_CART_BUTTONS_XPATH);
        waitUntilPageIsFullyLoaded();
        addToCartPopUpBlock.waitUntilVisible();
//        addToCartPopUpBlock.waitUntilProductImagesAreVisible();
//        addToCartPopUpBlock.waitUntilBannerImageIsVisible();
    }

    @Step("Is Add to cart button enable?")
    public boolean isAddToCartButtonEnable() {
        return $(ADD_TO_CART_BUTTONS_XPATH).isEnabled();
    }
}

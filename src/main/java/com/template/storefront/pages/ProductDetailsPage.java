package com.template.storefront.pages;

import com.template.helpers.managers.products.ProductsManager;
import com.template.helpers.models.products.BaseProduct;
import com.template.storefront.page_blocks.AddToCartPopUpBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.ProductDetailsPageElements.ADD_TO_CART_BUTTONS_XPATH;
import static com.template.storefront.page_elements.ProductDetailsPageElements.QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH;

@Component
public class ProductDetailsPage extends StorefrontBasePage {
    @Autowired private ProductsManager productsManager;

    @Autowired private AddToCartPopUpBlock addToCartPopUpBlock;

    private final String pageUrlMethod = "p/%s";

    @Step("Set QTY: {1} for product: {0}.")
    public void setQTYForProductToValue(BaseProduct product, int qty) {
        enterText(String.valueOf(qty), QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH);
    }

    @Step("Open PDP for product {0} by link.")
    public void openPDPForProduct(BaseProduct product) {
        open(String.format(getPageUrl(), product.getId()));
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

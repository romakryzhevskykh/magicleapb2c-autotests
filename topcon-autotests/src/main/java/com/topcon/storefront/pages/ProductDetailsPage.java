package com.topcon.storefront.pages;

import com.topcon.helpers.models.Product;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.topcon.storefront.page_block_elements.AddToCartPopUpBlockElements.CHECKOUT_BUTTON_XPATH;
import static com.topcon.storefront.page_elements.ProductDetailsPageElements.*;

@Component
public class ProductDetailsPage extends StorefrontBasePage {
    private final String pageUrlMethod = "topcon/en/USD/p/%s";

    public void open(Product product) {
        getDriver().get(getPageUrl(product));
    }

    public String getPageUrl(Product product) {
        return storefrontProject.getBaseUrl() + String.format(pageUrlMethod, product.getId());
    }

    public void clickOnAddToCartButton() {
        click(ADD_TO_CART_BUTTONS_XPATH);
        waitUntilPageIsFullyLoaded();
        waitUntilVisible(By.id(POP_UP_ID));
    }

    public void clickOnCheckoutButtonInAddToCartPopUp() {
        click(CHECKOUT_BUTTON_XPATH);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl();
    }

    @Step("Set QTY {1}.")
    public void setQTY(int qtyValueforAllProductsOnPDP) {
        $(By.id(QTY_FIELD_ID)).clear();
        $(By.id(QTY_FIELD_ID)).sendKeys(String.valueOf(qtyValueforAllProductsOnPDP));
    }
}

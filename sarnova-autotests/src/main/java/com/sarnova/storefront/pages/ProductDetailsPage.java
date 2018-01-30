package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.ProductDetailsPageElements.*;

@Component
public class ProductDetailsPage extends StorefrontBasePage {
    @Autowired private ProductsManager productsManager;

    private final String pageUrlMethod = "boundtree/en/USD/p/%s";


    @Step("Click on Add to Supply list button on PDP.")
    public void clickOnAddToSupplyListButton() {
        click(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH);
    }

    @Step("Set QTY: {1} for product UOM: {0}.")
    public void setQTYForProductUOMToValue(UnitOfMeasure unitOfMeasure, int qty) {
        WebElement qtyField = $(QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH,
                productsManager.getProductByUOM(unitOfMeasure).getSku(),
                unitOfMeasure.getUomType().toString());
        if (!qtyField.getAttribute("value").equals(String.valueOf(qty))) {
            qtyField.clear();
            qtyField.sendKeys(String.valueOf(qty));
        }
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    public String getPageUrlForProduct(Product product) {
        return null;
    }

    @Step("Open PDP for product by link.")
    public void openPDPForProduct(Product product) {
        open(String.format(getPageUrl(), product.getSku()));
    }

    public String getAddToSupplyListPopUpContent() {
        return $(ADD_TO_SUPPLY_LIST_POP_UP_CONTENT_XPATH).getText().trim();
    }
}

package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.page_blocks.AddToCartPopUpBlock;
import com.sarnova.storefront.page_blocks.AddToSupplyListPopUpBlock;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.ProductDetailsPageElements.*;

@Component
public class ProductDetailsPage extends StorefrontBasePage {
    @Autowired private ProductsManager productsManager;

    @Autowired private AddToSupplyListPopUpBlock addToSupplyListPopUpBlock;
    @Autowired private AddToCartPopUpBlock addToCartPopUpBlock;

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

    public String getPageUrlForProduct(Product product) {
        return null;
    }

    @Step("Open PDP for product {0} by link.")
    public void openPDPForProduct(Product product) {
        open(String.format(getPageUrl(), product.getSku()));
    }

    public String getAddToSupplyListPopUpContent() {
        return addToSupplyListPopUpBlock.getAddToSupplyListPopUpContent();
    }

    public void clickOnCreateNewSupplyListInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnCreateNewSupplyListInAddToSupplyListPopUp();
    }

    public void clickOnSelectSupplyListInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnSelectSupplyListInAddToSupplyListPopUp();
    }

    public void enterNewSupplyListNameText(String newSupplyListName) {
        addToSupplyListPopUpBlock.enterNewSupplyListNameText(newSupplyListName);
    }

    public void clickOnAddToSupplyListButtonInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnAddToSupplyListButtonInAddToSupplyListPopUp();
    }

    public void clickOnViewSupplyListButtonInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnViewSupplyListButtonInAddToSupplyListPopUp();
    }

    public void clickOnSelectExistingSupplyListDropDown() {
        addToSupplyListPopUpBlock.clickOnSelectExistingSupplyListDropDown();
    }

    public void selectExistingSupplyListFromDropDownBySupplyListName(String existingSupplyListName) {
        addToSupplyListPopUpBlock.selectExistingSupplyListFromDropDownBySupplyListName(existingSupplyListName);
    }

    public String getAnyExistingSupplyListNameFromDropDown() {
        return addToSupplyListPopUpBlock.getAnyExistingSupplyListNameFromDropDown();
    }

    public void clickOnCheckoutButtonInAddToCartPopUp() {
        addToCartPopUpBlock.clickOnCheckoutButtonInAddToCartPopUp();
    }

    public String getSupplyListId() {
        return addToSupplyListPopUpBlock.getSupplyListId();
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
    }
}

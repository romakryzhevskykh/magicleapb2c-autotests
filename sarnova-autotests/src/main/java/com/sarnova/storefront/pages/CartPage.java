package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.page_blocks.AddToSupplyListPopUpBlock;
import com.sarnova.storefront.page_blocks.SaveCartPopUpBlock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.CartPageElements.*;
import static java.lang.Integer.valueOf;

@Component
public class CartPage extends StorefrontBasePage {

    private static final String PAGE_URL_METHOD = "cart";

    @Autowired private ProductsManager productsManager;
    @Autowired private AddToSupplyListPopUpBlock addToSupplyListPopUpBlock;
    @Autowired private SaveCartPopUpBlock saveCartPopUpBlock;

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + PAGE_URL_METHOD;
    }

    public List<UnitOfMeasure> getUnitsOfMeasurementInCart() {
        List<Document> unitsOfMeasurementRows = isDisplayed(PRODUCTS_ROWS_XPATH) ?
                $$(PRODUCTS_ROWS_XPATH).stream()
                .map(productWebElement -> Jsoup.parse(productWebElement.getAttribute("innerHTML")))
                .collect(Collectors.toCollection(ArrayList::new)) :
                Collections.EMPTY_LIST;
        return productsManager.parseUnitsOfMeasurementFromCartPageHTML(unitsOfMeasurementRows);
    }

    public int getQTYOfUOM(UnitOfMeasure unitOfMeasure) {
        return valueOf($(UOM_QTY_BY_SKU_AND_UOM_TYPE_XPATH, getSku(unitOfMeasure), getUomType(unitOfMeasure))
                       .getAttribute("value"));
    }

    private String getSku(UnitOfMeasure unitOfMeasure) {
        return productsManager.getProductByUOM(unitOfMeasure).getSku();
    }

    private String getUomType (UnitOfMeasure unitOfMeasure) {
        return unitOfMeasure.getUomType().name();
    }

    public boolean isWarningMessageDisplayedForProduct(String skuId, String uom){
      return isPresent(UOM_WARNING_MESSAGE_BY_SKU_AND_UOM_TYPE_XPATH, skuId, uom);
    }

    @Step("Click on Checkout button on Cart page.")
    public void clickOnCheckoutButton() {
        click(CHECKOUT_BUTTONS_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Add to Supply list button on Cart page.")
    public void clickOnAddToSupplyListButton() {
        click(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH);
        waitUntilPageIsFullyLoaded();
        addToSupplyListPopUpBlock.waitUntilBannerImageIsVisible();
    }

    @Step("Click on Add to Supply list button for UOM: {0} on Cart page.")
    public void clickOnAddToSupplyListButtonForUOM(UnitOfMeasure unitOfMeasure) {
        click(ADD_UOM_TO_SUPPLY_LIST_BUTTON_BY_SKU_AND_UOM_TYPE_XPATH,
                productsManager.getProductByUOM(unitOfMeasure).getSku(),
                unitOfMeasure.getUomType().name());
    }

    @Step("Is Saved Carts button visible?")
    public boolean isSavedCartsButtonVisible() {
        return isDisplayed(SAVED_CARTS_BUTTON_XPATH);
    }

    @Step("Click on Saved Carts button.")
    public void clickOnSavedCartsButton() {
        click(SAVED_CARTS_BUTTON_XPATH);
    }

    public void clickOnSelectSupplyListInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnSelectSupplyListInAddToSupplyListPopUp();
    }

    public void clickOnSelectExistingSupplyListDropDown() {
        addToSupplyListPopUpBlock.clickOnSelectExistingSupplyListDropDown();
    }

    public String getAnyExistingSupplyListNameFromDropDown() {
        return addToSupplyListPopUpBlock.getAnyExistingSupplyListNameFromDropDown();
    }

    public void selectExistingSupplyListFromDropDownBySupplyListName(String existingSupplyListName) {
        addToSupplyListPopUpBlock.selectExistingSupplyListFromDropDownBySupplyListName(existingSupplyListName);
    }

    public void clickOnAddToSupplyListButtonInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnAddToSupplyListButtonInAddToSupplyListPopUp();
    }

    public String getSupplyListId() {
        return addToSupplyListPopUpBlock.getSupplyListId();
    }

    public void clickOnViewSupplyListButtonInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnViewSupplyListButtonInAddToSupplyListPopUp();
    }

    public void clickOnCreateNewSupplyListInAddToSupplyListPopUp() {
        addToSupplyListPopUpBlock.clickOnCreateNewSupplyListInAddToSupplyListPopUp();
    }

    public void enterNewSupplyListNameText(String newSupplyListName) {
        addToSupplyListPopUpBlock.enterNewSupplyListNameText(newSupplyListName);
    }

    @Step("Is Add to Supply list button visible?")
    public boolean isAddToSupplyListButtonVisible() {
        return isDisplayed(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH);
    }

    @Step("Is Checkout button visible?")
    public boolean isCheckoutButtonVisible() {
        return isDisplayed(CHECKOUT_BUTTONS_XPATH);
    }

    @Step("Is Save Cart button visible?")
    public boolean isSaveCartButtonVisible() {
        return isDisplayed(SAVE_CART_BUTTON_XPATH);
    }

    @Step("Click on Save Cart button.")
    public void clickOnSaveCartButton() {
        click(SAVE_CART_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    public boolean isSaveCartPopUpOpened() {
        return saveCartPopUpBlock.isOpened();
    }

    public boolean isPopUpSaveCartButtonVisible() {
        return saveCartPopUpBlock.isSaveCartButtonVisible();
    }

    public boolean isPopUpCancelSaveCartButtonVisible() {
        return saveCartPopUpBlock.isCancelSaveCartButtonVisible();
    }

    public boolean isPopUpSaveCartNameFieldVisible() {
        return saveCartPopUpBlock.isSaveCartNameFieldVisible();
    }

    public boolean isPopUpSaveCartDescriptionVisible() {
        return saveCartPopUpBlock.isSaveCartDescriptionFieldVisible();
    }
}

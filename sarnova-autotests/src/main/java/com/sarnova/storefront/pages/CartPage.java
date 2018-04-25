package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.page_blocks.AddToSupplyListPopUpBlock;
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

@Component
public class CartPage extends StorefrontBasePage {

    @Autowired private ProductsManager productsManager;
    @Autowired private AddToSupplyListPopUpBlock addToSupplyListPopUpBlock;

    private String pageUrlMethod = "boundtree/en/USD/cart";

    public List<UnitOfMeasure> getUnitsOfMeasurementInCart() {
        List<Document> unitsOfMeasurementRows = isDisplayed(PRODUCTS_ROWS_XPATH) ?
                $$(PRODUCTS_ROWS_XPATH).stream()
                .map(productWebElement -> Jsoup.parse(productWebElement.getAttribute("innerHTML")))
                .collect(Collectors.toCollection(ArrayList::new)) :
                Collections.EMPTY_LIST;
        return productsManager.parseUnitsOfMeasurementFromCartPageHTML(unitsOfMeasurementRows);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    public int getQTYOfUOM(UnitOfMeasure unitOfMeasure) {
        return Integer.valueOf(
                $(UOM_QTY_BY_SKU_AND_UOM_TYPE_XPATH,
                        productsManager.getProductByUOM(unitOfMeasure).getSku(),
                        unitOfMeasure.getUomType().name()
                ).getAttribute("value"));
    }

    @Step("Click on Checkout button on Cart page.")
    public void clickOnCheckoutButton() {
        click(CHECKOUT_BUTTONS_XPATH);
    }

    @Step("Click on Add to Supply list button on Cart page.")
    public void clickOnAddToSupplyListButton() {
        click(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH);
    }

    @Step("Click on Add to Supply list button for UOM: {0} on Cart page.")
    public void clickOnAddToSupplyListButtonForUOM(UnitOfMeasure unitOfMeasure) {
        click(ADD_UOM_TO_SUPPLY_LIST_BUTTON_BY_SKU_AND_UOM_TYPE_XPATH,
                productsManager.getProductByUOM(unitOfMeasure).getSku(),
                unitOfMeasure.getUomType().name());
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
}

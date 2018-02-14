package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import org.openqa.selenium.By;
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

    @Step("Open PDP for product {0} by link.")
    public void openPDPForProduct(Product product) {
        open(String.format(getPageUrl(), product.getSku()));
    }

    @Step("Get Add to Supply list pop-up's text content.")
    public String getAddToSupplyListPopUpContent() {
        return $(ADD_TO_SUPPLY_LIST_POP_UP_CONTENT_XPATH).getText().trim();
    }

    @Step("Select create new Supply list radio button in Add to Supply list pop-up.")
    public void clickOnCreateNewSupplyListInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_CREATE_NEW_SUPPLY_LIST_RADIO_BUTTON_XPATH);
    }

    @Step("Select select Supply list radio button in Add to Supply list pop-up.")
    public void clickOnSelectSupplyListInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_SELECT_SUPPLY_LIST_RADIO_BUTTON_XPATH);
    }

    @Step("Enter new Supply list name: {0} in Add to Supply list pop-up.")
    public void enterNewSupplyListNameText(String newSupplyListName) {
        $(By.id(ADD_TO_SUPPLY_LIST_POP_UP_NEW_SUPPLY_LIST_NAME_FIELD_ID)).sendKeys(newSupplyListName);
    }

    @Step("Click on Add to Supply list button in Add to Supply list pop-up.")
    public void clickOnAddToSupplyListButtonInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_ADD_TO_SUPPLY_LIST_BUTTON_XPATH);
    }

    @Step("Click on View Supply list button in Add to Supply list pop-up.")
    public void clickOnViewSupplyListButtonInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_VIEW_SUPPLY_LIST_BUTTON_XPATH);
    }

    @Step("Click on Select Your Supply list drop-down.")
    public void clickOnSelectExistingSupplyListDropDown() {
        click(By.id(ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_LISTS_DROP_DOWN_ID));
    }

    @Step("Select {0} Supply list from drop-down.")
    public void selectExistingSupplyListFromDropDownBySupplyListName(String existingSupplyListName) {
        click(ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_SUPPLY_LIST_IN_DROP_DOWN_BY_NAME_XPATH, existingSupplyListName);
    }

    @Step("Get name of any existing Supply list in the drop-down.")
    public String getAnyExistingSupplyListNameFromDropDown() {
        return $$(ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_SUPPLY_LISTS_IN_DROP_DOWN_XPATH)
                .stream()
                .map(webElement -> webElement.getText().trim())
                .findAny()
                .orElse(null);
    }
}

package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.models.supply_lists.SupplyListProduct;
import com.sarnova.helpers.user_engine.User;
import com.sarnova.storefront.page_blocks.AddToCartPopUpBlock;
import com.sarnova.storefront.page_blocks.LoggedInHeaderRowBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.SupplyListDetailsPageElements.*;

@Component
public class SupplyListDetailsPage extends StorefrontBasePage {
    @Autowired private SupplyListsManager supplyListsManager;
    @Autowired private ProductsManager productsManager;
    @Autowired private LoggedInHeaderRowBlock loggedInHeaderRowBlock;

    @Autowired private AddToCartPopUpBlock addToCartPopUpBlock;
    private final String pageUrlMethod = "my-account/supply-lists/%s";

    @Step("Get Supply list name from Supply list details page.")
    public String getSupplyListName() {
        return $(By.id(SUPPLY_LIST_NAME_ID)).getText().trim();
    }

    @Step("Is Supply list details header is visible.")
    public boolean isHeaderVisible() {
        return isDisplayed(SUPPLY_LIST_HEADER_XPATH);
    }

    @Step("Get Supply list active status.")
    public String getSupplyListActiveStatus() {
        return $(SUPPLY_LIST_ACTIVE_STATUS_XPATH).getText().trim();
    }

    @Step("Get Supply list id value.")
    public String getSupplyListIdValue() {
        return $(SUPPLY_LIST_ID_VALUE_XPATH).getText().trim();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().startsWith(String.format(getPageUrl(), ""));
    }

    public String getPageUrlForProduct(SupplyList supplyList) {
        return null;
    }

    @Step("Get Supply list from page.")
    public SupplyList getSupplyListFromPage(User user) {
        String supplyListName = getSupplyListName();
        String id = getSupplyListIdValue();
        String supplyListActiveStatus = getSupplyListActiveStatus();
        List<SupplyListProduct> activeSupplyProducts = getActiveProducts();
        List<SupplyListProduct> inactiveSupplyProducts = getInactiveProducts();
        List<SupplyListProduct> supplyListProducts = new ArrayList<SupplyListProduct>() {{
            addAll(activeSupplyProducts);
            addAll(inactiveSupplyProducts);
        }};
        SupplyList supplyList = new SupplyList(user, supplyListName, id, supplyListProducts);
        supplyList.setActive(supplyListActiveStatus.equalsIgnoreCase("Inactivate"));
        return supplyList;
    }

    @Step("Get active products from the list.")
    public List<SupplyListProduct> getActiveProducts() {
        return $$(ACTIVE_PRODUCTS_ROWS_XPATH).stream()
                .map(webElement -> new SupplyListProduct(
                        (IndividualProduct) productsManager.getProductBySku(webElement.getAttribute("data-product-code")),
                        true))
                .collect(Collectors.toList());
    }


    @SuppressWarnings("unchecked")
    @Step("Get inactive products from the list.")
    public List<SupplyListProduct> getInactiveProducts() {
        if (isDisplayed(By.id(SHOW_INACTIVE_ENTRIES_BUTTON_ID)))
            return $$(INACTIVE_PRODUCTS_ROWS_XPATH).stream()
                    .map(webElement -> new SupplyListProduct(
                            (IndividualProduct) productsManager.getProductBySku(webElement.getAttribute("data-product-code")),
                            false))
                    .collect(Collectors.toList());
        else
            return Collections.EMPTY_LIST;
    }

    @Step("Open Supply list details page for supply list id {0} by link.")
    public void openSupplyListDetailsPageForSupplyLIst(SupplyList supplyList) {
        open(String.format(getPageUrl(), supplyList.getId()));
    }

    @Step("Set QTY: {1} for product UOM: {0}.")
    public void setQTYForProductUOMToValue(UnitOfMeasure unitOfMeasure, int qty) {
        WebElement qtyField = $(SUPPLY_PRODUCT_ROW_QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH,
                productsManager.getProductByUOM(unitOfMeasure).getSku(),
                unitOfMeasure.getUomType().toString());
        if (!qtyField.getAttribute("value").equals(String.valueOf(qty))) {
            qtyField.clear();
            qtyField.sendKeys(String.valueOf(qty));
        }
    }

    @Step("Click on Add to cart button.")
    public void clickOnAddToCartButton() {
        click(ADD_TO_CART_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
        addToCartPopUpBlock.waitUntilProductImagesAreVisible();
    }

    @Step("Is Add to cart button visible?")
    public boolean isAddToCartButtonVisible() {
        return isDisplayed(ADD_TO_CART_BUTTON_XPATH);
    }

    public void clickOnCheckoutButtonInAddToCartPopUp() {
        addToCartPopUpBlock.clickOnCheckoutButtonInAddToCartPopUp();
    }

    public String getAddToCartPopUpMessage() {
        return addToCartPopUpBlock.getAddToCartPopUpContent();
    }

    @Step("Check that Supply list is active.")
    public boolean isSupplyListActive() {
        return getSupplyListActiveStatus().equalsIgnoreCase("Inactivate");
    }

    @Step("Check that Supply list is inactive.")
    public boolean isSupplyListInactive() {
        return getSupplyListActiveStatus().equalsIgnoreCase("Reactivate");
    }

    @Step("Change Supply list status.")
    public void changeSupplyListStatus() {
        SupplyList supplyList = supplyListsManager.getSupplyListByName(getSupplyListName());
        click(SUPPLY_LIST_ACTIVE_STATUS_XPATH);
        supplyList.setActive(!supplyList.isActive());
        waitUntilPageIsFullyLoaded();
    }

    @Step("Activate product: {0}.")
    public void activateProduct(SupplyListProduct supplyListProduct) {
        click(INACTIVE_PRODUCT_ACTIVATE_BUTTON_BY_SKU_XPATH, supplyListProduct.getSku());
        waitUntilPageIsFullyLoaded();
        supplyListProduct.setActive(true);
    }

    @Step("Deactivate product: {0}.")
    public void deactivateProduct(SupplyListProduct supplyListProduct) {
        click(ACTIVE_PRODUCT_DEACTIVATE_BUTTON_BY_SKU_XPATH, supplyListProduct.getSku());
        waitUntilPageIsFullyLoaded();
        supplyListProduct.setActive(false);
    }

    @Step("Is deactivate product button visible for {0}.")
    public boolean isDeactivateProductButtonVisible(SupplyListProduct supplyListProduct) {
        return isDisplayed(ACTIVE_PRODUCT_DEACTIVATE_BUTTON_BY_SKU_XPATH, supplyListProduct.getSku());
    }

    @Step("Is Show inactive entries checkbox selected?")
    public boolean isShowInactiveEntiesCheckboxActive() {
        return $(By.id(SHOW_INACTIVE_ENTRIES_BUTTON_ID)).isSelected();
    }

    @Step("Click on Show inactive entries checkbox.")
    public void clickOnShowInactiveEntriesCheckbox() {
        click(By.id(SHOW_INACTIVE_ENTRIES_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    @Step("Show inactive Supply products.")
    public void showInactiveSupplyProducts() {
        if (!isShowInactiveEntiesCheckboxActive()) {
            clickOnShowInactiveEntriesCheckbox();
        }
    }

    @Step("Hide inactive Supply products.")
    public void hideInactiveSupplyProducts() {
        if (isShowInactiveEntiesCheckboxActive()) {
            clickOnShowInactiveEntriesCheckbox();
        }
    }

    @Step("Check that inactive Supply products are visible.")
    public boolean areInactiveSupplyListsBlockVisible() {
        return isDisplayed(INACTIVE_PRODUCTS_BLOCK_XPATH);
    }

    @Step("Check that text message content is displayed in Active products block.")
    public boolean checkThatTextContentMessageIsDisplayed() {
        return isDisplayed(ACTIVE_PRODUCTS_BLOCK_TEXT_CONTENT);
    }

    @Step("Get text message content in Active products block.")
    public String getTextContentMessageInActiveProductsBlock() {
        return $(ACTIVE_PRODUCTS_BLOCK_TEXT_CONTENT).getText();
    }

    @Step("Get list of deactivated products.")
    public List<IndividualProduct> getDeactivatedProducts() {
        return $$(INACTIVE_PRODUCTS_ROWS_XPATH)
                .stream()
                .map(webElement -> webElement.getAttribute("data-product-code"))
                .map(sku -> productsManager.getProductBySku(sku))
                .map(product -> (IndividualProduct) product)
                .collect(Collectors.toList());
    }

    @Step("Get list of active products.")
    public List<IndividualProduct> getActivatedProducts() {
        return $$(ACTIVE_PRODUCTS_ROWS_XPATH)
                .stream()
                .map(webElement -> webElement.getAttribute("data-product-code"))
                .map(sku -> productsManager.getProductBySku(sku))
                .map(product -> (IndividualProduct) product)
                .collect(Collectors.toList());
    }

    @Step("Get Supply list favorite status.")
    public boolean isSupplyListFavorite() {
        return $(FAVORITE_CHECKBOX_XPATH).isSelected();
    }

    @Step("Is Supply list favorite checkbox visible?")
    public boolean isSupplyListFavoriteCheckboxVisible() {
        return isDisplayed(FAVORITE_CHECKBOX_XPATH);
    }

    @Step("Mark Supply list as favorite.")
    public void markAsFavorite() {
        if (!isSupplyListFavorite()) {
            clickOnFavoriteCheckbox();
        }
    }

    @Step("Make Supply list as un-favorite.")
    public void markAsUnFavorite() {
        if (isSupplyListFavorite()) {
            clickOnFavoriteCheckbox();
        }
    }

    @Step("Click on favorite checkbox.")
    public void clickOnFavoriteCheckbox() {
        click(FAVORITE_CHECKBOX_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Open Quick add block.")
    public void openQuickAddBlockOnSupplyListDetailsPage() {
        if (!isQuickAddCheckboxSelected()) {
            clickOnQuickAddCheckbox();
        }
    }

    @Step("Close Quick add block.")
    public void closeQuickAddBlockOnSupplyListDetailsPage() {
        if (!isQuickAddCheckboxSelected()) {
            clickOnQuickAddCheckbox();
        }
    }

    @Step("Is Quick Add checkbox selected?")
    public boolean isQuickAddCheckboxSelected() {
        return $(By.id(QUICK_ADD_CHECKBOX_ID)).isSelected();
    }

    @Step("Is Quick add block opened.")
    public boolean isQuickAddBlockOpened() {
        return isDisplayed(QUICK_ADD_SUPPLY_LIST_BLOCK_XPATH);
    }

    @Step("Click on Quick add checkbox.")
    public void clickOnQuickAddCheckbox() {
        click(By.id(QUICK_ADD_CHECKBOX_ID));
        waitUntilPageIsFullyLoaded();
    }

    @Step("Enter SKU value to any empty Quick add row: {0}.")
    public void enterSkuToEmptyQuickAddRow(String newProductSKU) {
        WebElement emptyRow = $$(QUICK_ADD_ROW_TEXT_FIELDS_XPATH).stream()
                .filter(webElement -> webElement.getAttribute("value").isEmpty())
                .findFirst().orElseGet(() -> {
                    throw new NullPointerException("No empty rows!");
                });
        emptyRow.sendKeys(newProductSKU);
        blurElement(emptyRow);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Add to this Supply list Quick Add button.")
    public void clickOnQuickAddToThisSupplyListButton() {
        click(QUICK_ADD_TO_THIS_SUPPLY_LIST_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    public String getErrorMessageForQuickAddRowWithEnteredValue(String enteredText) throws NullPointerException {
        for (int i = 1; i <= $$(QUICK_ADD_ROWS).size(); i++) {
            if ($(QUICK_ADD_ROW_TEXT_FIELD_BY_NUMBER_XPATH, String.valueOf(i)).getAttribute("value").equals(enteredText))
                return $(QUICK_ADD_ROW_ERROR_TEXT_BY_ROW_NUMBER_XPATH, String.valueOf(i)).getText();
        }
        throw new NullPointerException("No field with such entered value: " + enteredText);
    }

    @Step("Is QTY field visible for {0}.")
    public boolean isQuantityFieldVisibleForProduct(SupplyListProduct supplyListProduct) {
        return isDisplayed(SUPPLY_PRODUCT_ROW_QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH, supplyListProduct.getSku(),
                supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream()
                        .map(unitOfMeasure -> unitOfMeasure.getUomType().toString())
                        .findAny().orElse(null));
    }

    @Step("Is Quick add checkbox visible?")
    public boolean isQuickAddCheckboxVisible() {
        return isDisplayed(By.id(QUICK_ADD_CHECKBOX_ID));
    }

    @Step("Is Edit button visible?")
    public boolean isEditButtonVisible() {
        return isDisplayed(EDIT_SUPPLY_LIST_BUTTON_XPATH);
    }

    @Step("Is Change Supply list status button visible?")
    public boolean isChangeStatusButtonVisible() {
        return isDisplayed(SUPPLY_LIST_ACTIVE_STATUS_XPATH);
    }

    @Step("Is Share checkbox visible?")
    public boolean isShareCheckboxVisible() {
        return isDisplayed(By.id(SHOW_SHARE_FUNC_CHECKBOX_ID));
    }

    @Step("Is Add to cart button enable?")
    public boolean isAddToCartButtonEnable() {
        return $(ADD_TO_CART_BUTTON_XPATH).isEnabled();
    }
}

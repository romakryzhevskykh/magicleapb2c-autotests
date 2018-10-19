package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.page_blocks.AddToCartPopUpBlock;
import com.sarnova.storefront.page_blocks.AddToSupplyListPopUpBlock;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.QuickOrderPageElements.*;

@Component
public class QuickOrderPage extends StorefrontBasePage {

    @Autowired ProductsManager productsManager;
    @Autowired AddToSupplyListPopUpBlock addToSupplyListPopUpBlock;
    @Autowired AddToCartPopUpBlock addToCartPopUpBlock;

    private String pageUrlMethod = "quickOrder";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Is Add to Supply list button visible?")
    public boolean isAddToSupplyListButtonVisible() {
        return isDisplayed(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH);
    }

    @Step("Is Add to Supply list button enabled?")
    public boolean isAddToSupplyListButtonEnabled() {
        return $(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH).isEnabled();
    }

    @Step("Is Add to cart button enabled?")
    public boolean isAddToCartButtonEnabled() {
        return $(ADD_TO_CART_BUTTONS_XPATH).isEnabled();
    }

    @Step("Add product: {0} to Quick order list.")
    public void fillProductIdToNextEmptySKURow(Product product) {
        fillTextToEmptyRow(product.getSku());
    }

    @Step("Fill text to next empty Quick order row.")
    public void fillTextToEmptyRow(String text) {
        enterText(text, EMPTY_PRODUCTS_SKU_ROW_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get UOMs with corresponding QTYs.")
    public Map<UnitOfMeasure, Integer> getUomsWithQTYs() {
        return $$(QTY_FIELDS_XPATH).stream().collect(Collectors.toMap(
                we -> productsManager.getProductBySku(we.getAttribute("data-product-code"))
                        .getUnitsOfMeasurement().stream().filter(unitOfMeasure -> unitOfMeasure.getUomType().name().equals(we.getAttribute("data-unit")))
                        .findAny().orElse(null),
                we -> Integer.parseInt(we.getAttribute("value"))
        ));
    }

    public String getErrorMessageForQuickAddRowWithEnteredValue(String enteredText) throws NullPointerException {
        ArrayList<String> skuErrors = new ArrayList<>();
        for (int i = 1; i <= $$(QUICK_ADD_ROW_XPATH).size(); i++) {
            if ($(QUICK_ADD_ROW_TEXT_FIELD_BY_NUMBER_XPATH, String.valueOf(i)).getAttribute("value").equals(enteredText))
                skuErrors.add($(QUICK_ADD_ROW_ERROR_TEXT_BY_ROW_NUMBER_XPATH, String.valueOf(i)).getText());
        }
        if (skuErrors.isEmpty())
            throw new NullPointerException("No field with such entered value: " + enteredText);
        else if (skuErrors.size() > 1) {
            skuErrors = skuErrors.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
            skuErrors.remove("");
            if (skuErrors.size() == 1) {
                return skuErrors.get(0);
            } else {
                throw new NullPointerException("Multiple results for this field: " + enteredText + ", results: " + skuErrors);
            }
        } else
            return skuErrors.get(0);
    }

    @Step("Set QTY: {0} to UOM: {1}.")
    public void setQTYToUOM(int qtyToSet, UnitOfMeasure unitOfMeasure) {
        enterText(String.valueOf(qtyToSet), QTY_FIELD_BY_SKU_AND_UOM_XPATH, productsManager.getProductByUOM(unitOfMeasure).getSku(), unitOfMeasure.getUomType().name());
    }

    @Step("Set QTY: {0} to UOM: {1} using plus/minus buttons.")
    public void setQTYToUOMUsingPlusMinus(int qtyToAnyProduct, Map.Entry<UnitOfMeasure, Integer> unitOfMeasureIntegerEntry) {
        int raiseNumber = Math.abs(qtyToAnyProduct - unitOfMeasureIntegerEntry.getValue());
        boolean increase = qtyToAnyProduct > unitOfMeasureIntegerEntry.getValue();
        for (int i = 0; i < raiseNumber; i++) {
            if (increase) {
                clickPlusFor(unitOfMeasureIntegerEntry.getKey());
            } else {
                clickMinusFor(unitOfMeasureIntegerEntry.getKey());
            }
        }
    }

    @Step("Click plus button for UOM: {0}.")
    private void clickPlusFor(UnitOfMeasure unitOfMeasure) {
        click(PLUS_BUTTON_BY_SKU_AND_UOM_XPATH, productsManager.getProductByUOM(unitOfMeasure).getSku(), unitOfMeasure.getUomType().name());
    }

    @Step("Click minus button for UOM: {0}.")
    private void clickMinusFor(UnitOfMeasure unitOfMeasure) {
        click(MINUS_BUTTON_BY_SKU_AND_UOM_XPATH, productsManager.getProductByUOM(unitOfMeasure).getSku(), unitOfMeasure.getUomType().name());
    }

    @Step("Click on Add to Supply list button.")
    public void clickOnAddToSupplyListButton() {
        click(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH);
        waitUntilPageIsFullyLoaded();
        addToSupplyListPopUpBlock.waitUntilProductImagesAreVisible();
        addToSupplyListPopUpBlock.waitUntilBannerImageIsVisible();
    }

    @Step("Click on Add to cart button.")
    public void clickOnAddToCartButton() {
        click(ADD_TO_CART_BUTTONS_XPATH);
        waitUntilPageIsFullyLoaded();
        waitUntilElementIsVisible(By.id(POP_UP_ID));
        addToCartPopUpBlock.waitUntilProductImagesAreVisible();
        addToCartPopUpBlock.waitUntilBannerImageIsVisible();
    }

    @Step("Click on Reset form button.")
    public void clickOnResetFormButton() {
        click(RESET_FORM_BUTTONS_XPATH);
        waitUntilPageIsFullyLoaded();
    }
    @Step("Click on Pop-up Reset form button")
    public void clickOnPopUpResetFormButton() {
        click(RESET_FORM_BUTTON_POP_UP_XPATH);
        waitUntilPageIsFullyLoaded();
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

    public String getSupplyListId() {
        return addToSupplyListPopUpBlock.getSupplyListId();
    }

    public void clickOnContinueButtonInAddToSupplyListPopUpOnQuickOrderPage() {
        addToSupplyListPopUpBlock.clickOnContinueButton();
    }

    public void clickOnCheckoutButtonInAddToCartPopUp() {
        addToCartPopUpBlock.clickOnCheckoutButtonInAddToCartPopUp();
    }

    public void clickOnContinueShoppingButtonInAddToCartPopUp() {
        addToCartPopUpBlock.clickOnContinueShoppingButtonInAddToCartPopUp();
    }

    public String getAddToCartPopUpContent() {
        return addToCartPopUpBlock.getAddToCartPopUpContent();
    }
}

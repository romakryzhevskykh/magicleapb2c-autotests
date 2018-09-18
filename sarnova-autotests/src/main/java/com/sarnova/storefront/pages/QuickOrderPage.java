package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
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
}

package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.Product;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

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
        enterText(product.getSku(), EMPTY_PRODUCTS_SKU_ROW_XPATH);
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
}

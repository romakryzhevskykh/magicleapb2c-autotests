package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.user_engine.User;
import com.sarnova.storefront.page_blocks.AddToCartPopUpBlock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.SupplyListDetailsPageElements.*;

@Component
public class SupplyListDetailsPage extends StorefrontBasePage {
    @Autowired private SupplyListsManager supplyListsManager;
    @Autowired private ProductsManager productsManager;

    @Autowired private AddToCartPopUpBlock addToCartPopUpBlock;
    private final String pageUrlMethod = "boundtree/en/USD/my-account/supply-lists/%s";

    @Step("Get Supply list name from Supply list details page.")
    public String getSupplyListName() {
        return $(By.id(SUPPLY_LIST_NAME_ID)).getText().trim();
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
        List<Document> supplyProductsRowsHTMLs = $$(SUPPLY_PRODUCTS_ROWS_XPATH)
                .stream()
                .map(webElement -> Jsoup.parse(webElement.getAttribute("innerHTML")))
                .collect(Collectors.toList());
        return supplyListsManager.parseSupplyListFromHTMLSupplyListDetailsPage(user, supplyListName, id,
                supplyListActiveStatus, supplyProductsRowsHTMLs);
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
    }

    public void clickOnCheckoutButtonInAddToCartPopUp() {
        addToCartPopUpBlock.clickOnCheckoutButtonInAddToCartPopUp();
    }

    public String getAddToCartPopUpMessage() {
        return addToCartPopUpBlock.getAddToCartPopUpContent();
    }
}

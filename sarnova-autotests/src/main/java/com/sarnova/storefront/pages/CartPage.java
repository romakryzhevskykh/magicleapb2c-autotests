package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.CartPageElements.*;

@Component
public class CartPage extends StorefrontBasePage {

    @Autowired private ProductsManager productsManager;

    private String pageUrlMethod = "boundtree/en/USD/cart";

    public ArrayList<UnitOfMeasure> getUnitsOfMeasurementInCart() {
        ArrayList<Document> unitsOfMeasurementRows = $$(PRODUCTS_ROWS_XPATH).stream()
                .map(productWebElement -> Jsoup.parse(productWebElement.getAttribute("innerHTML")))
                .collect(Collectors.toCollection(ArrayList::new));
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
                        unitOfMeasure.getUomType().getFullName()
                ).getAttribute("value"));
    }
}

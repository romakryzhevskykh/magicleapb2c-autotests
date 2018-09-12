package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.request_engine.GETRequest;
import com.sarnova.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class QuickOrderManager {
    GETRequest QUICK_ORDER_PAGE_SOURCE = new GETRequest("Get Quick order page source", "quickOrder");
    GETRequest RESTORE_FORM = new GETRequest("Remove all items from Quick order list", "quickOrder/removeAllEntries");

    @Autowired ProductsManager productsManager;

    public void removeAllProductsFromList(UserSession userSession) {
        GETRequest clearProductsList = RESTORE_FORM.getClone();
        try {
            clearProductsList.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<UnitOfMeasure, Integer> getUOMs(UserSession userSession) {
        GETRequest qoPageSource = QUICK_ORDER_PAGE_SOURCE.getClone();
        try {
            qoPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document response = qoPageSource.getResponse().getHTMLResponseDocument();
        return parseUOMsFromPage(response);
    }

    private Map<UnitOfMeasure, Integer> parseUOMsFromPage(Document response) {
        List<UnitOfMeasure> uoms = Xsoup.select(response, "//li[@class*=item__list--item]/div/input[@value][@type=text]/@value").list().stream()
                .map(sku -> productsManager.getProductBySku(sku))
                .flatMap(product -> product.getUnitsOfMeasurement().stream())
                .collect(Collectors.toList());
        return uoms.stream().collect(Collectors.toMap(
                uom -> uom,
                uom -> new Integer(Xsoup.select(response,
                        String.format("//li[@class*=item__list--item]//div[@class*=qty-selector]//input[@type=text][@data-product-code=%s][@data-unit=%s]/@value",
                                productsManager.getProductByUOM(uom).getSku(),
                                uom.getUomType().name()))
                        .get())
        ));
    }
}

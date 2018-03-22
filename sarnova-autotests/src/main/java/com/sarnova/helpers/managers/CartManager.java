package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.request_engine.API;
import com.sarnova.helpers.request_engine.GETRequest;
import com.sarnova.helpers.request_engine.POSTRequest;
import com.sarnova.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CartManager {
    @Autowired ProductsManager productsManager;

    private POSTRequest REMOVE_ENTRY_FROM_CART = new POSTRequest("Remove entry from active cart", "/boundtree/en/USD/cart/entry/execute/REMOVE");
    private GETRequest GET_CART_PAGE_SOURCE = new GETRequest("Get cart page source", "/boundtree/en/USD/cart");
    private POSTRequest ADD_UOMS_TO_CART = new POSTRequest("Add UOMs to cart", "/cart/addIndividualList");

    @SuppressWarnings("unchecked")
    public void emptyActiveCart(UserSession userSession) {
        List<UnitOfMeasure> unitsOfMeasurementInCart = getUOMsFromCartPage(userSession);
        String csrfToken = getCartPageCsrfToken(userSession);
        for (int i = 0; i < unitsOfMeasurementInCart.size(); i++) {
            try {
                POSTRequest removeEntryFromCart = REMOVE_ENTRY_FROM_CART.getClone();
                removeEntryFromCart.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
                removeEntryFromCart.addPostParameterAndValue(new API.PostParameterAndValue("entryNumbers", "0"));
                removeEntryFromCart.sendPostRequest(userSession);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCartPageCsrfToken(UserSession userSession) {
        GETRequest getCartPageSource = GET_CART_PAGE_SOURCE.getClone();
        try {
            getCartPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = getCartPageSource.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//input[@name=CSRFToken]/@value").list().stream().findAny().orElse(null);
    }

    private List<UnitOfMeasure> getUOMsFromCartPage(UserSession userSession) {
        GETRequest getCartPageSource = GET_CART_PAGE_SOURCE.getClone();
        try {
            getCartPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = getCartPageSource.getResponse().getHTMLResponseDocument();
        ArrayList<Element> unitsOfMeasurementRows = Xsoup.select(htmlResponse, "//table/tbody/tr/td/li[@class=item__list--item]").getElements();
        return productsManager.parseUnitsOfMeasurementFromCartPageHTML(unitsOfMeasurementRows);
    }

    @SuppressWarnings("unchecked")
    public void addUOMsToCartViaApi(UserSession userSession, HashMap<UnitOfMeasure, Integer> unitsOfMeasurementToAdd) {
        POSTRequest addUOMsToCart = ADD_UOMS_TO_CART.getClone();
        int counter = 0;
        for(Map.Entry<UnitOfMeasure, Integer> unitOfMeasure : unitsOfMeasurementToAdd.entrySet()) {
            addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("productList[" + counter + "].unit",
                    unitOfMeasure.getKey().getUomType().name()));
            addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("productList[" + counter + "].qty",
                    unitOfMeasure.getValue()));
            addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("productList[" + counter + "].productCode",
                    productsManager.getProductByUOM(unitOfMeasure.getKey()).getSku()));
        }
        String csrfToken = productsManager.getCSRFTokenFromPDPOf(userSession, unitsOfMeasurementToAdd.keySet()
                .stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .collect(Collectors.toList()));
        addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            addUOMsToCart.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

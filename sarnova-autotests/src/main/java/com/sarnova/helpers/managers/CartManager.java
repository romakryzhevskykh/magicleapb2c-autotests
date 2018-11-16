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
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sarnova.RegexUtils.matchPattern;

@Component
public class CartManager {

    private static final String CSRFTOKEN_REGEX_PATTERN = "CSRFToken\\s*=\\s*\"(.+)\";";

    @Autowired
    private ProductsManager productsManager;

    private POSTRequest REMOVE_ENTRY_FROM_CART = new POSTRequest("Remove entry from active cart", "cart/entry/execute/REMOVE");
    private GETRequest GET_CART_PAGE_SOURCE = new GETRequest("Get cart page source", "cart");
    private POSTRequest ADD_UOMS_TO_CART = new POSTRequest("Add UOMs to cart", "cart/addIndividualList");
    private POSTRequest CLEAR_CART = new POSTRequest("Clear active cart", "cart/clear");

    @Step("Clear active cart.")
    @SuppressWarnings("unchecked")
    public void clearActiveCart(UserSession userSession) {
        String csrfToken = getCartPageCsrfToken(userSession);
        POSTRequest clearCart = CLEAR_CART.getClone();
        try {
            clearCart.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
            clearCart.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Step("Remove UOM from cart.")
    public void removeUOMFromCart(UserSession userSession, String csrfToken) {
        POSTRequest removeEntryFromCart = REMOVE_ENTRY_FROM_CART.getClone();
        try {
            removeEntryFromCart.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
            removeEntryFromCart.addPostParameterAndValue(new API.PostParameterAndValue("entryNumbers", "0"));
            removeEntryFromCart.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCartPageCsrfToken(UserSession userSession) {
        GETRequest getCartPageSource = GET_CART_PAGE_SOURCE.getClone();
        getCartPageSource.setIsShortLogResponse(true);
        try {
            getCartPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String htmlResponse = getCartPageSource.getResponse().getHTMLResponseDocument().outerHtml();
        return matchPattern(htmlResponse, CSRFTOKEN_REGEX_PATTERN, 1);
    }

    @Step("Get current cart ID.")
    public String getCurrentCartId(UserSession userSession) {
        GETRequest getCartPageSource = GET_CART_PAGE_SOURCE.getClone();
        getCartPageSource.setIsShortLogResponse(true);
        try {
            getCartPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlResponse = getCartPageSource.getResponse().getHTMLResponseDocument();
        return Xsoup.select(htmlResponse, "//span[@class=cart__id]/text()").get();
    }

    @Step("Get UOMs from active cart.")
    private List<UnitOfMeasure> getUOMsFromCartPage(UserSession userSession) {
        GETRequest getCartPageSource = GET_CART_PAGE_SOURCE.getClone();
        getCartPageSource.setIsShortLogResponse(true);
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
    @Step("Add {1} to cart.")
    public void addUOMsToCartViaApi(UserSession userSession, HashMap<UnitOfMeasure, Integer> unitsOfMeasurementToAdd) {
        POSTRequest addUOMsToCart = ADD_UOMS_TO_CART.getClone();
        int counter = 0;
        for (Map.Entry<UnitOfMeasure, Integer> unitOfMeasure : unitsOfMeasurementToAdd.entrySet()) {
            System.out.println("UOM1 :" + unitOfMeasure.getKey().getUomType().name());
            addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("productList[" + counter + "].unit",
                    unitOfMeasure.getKey().getUomType().name()));
            System.out.println("UOM2 :" + unitOfMeasure.getValue());
            addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("productList[" + counter + "].qty",
                    unitOfMeasure.getValue()));
            System.out.println("UOM3 :" + productsManager.getProductByUOM(unitOfMeasure.getKey()).getSku());
            addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("productList[" + counter + "].productCode",
                    productsManager.getProductByUOM(unitOfMeasure.getKey()).getSku()));
        }
        String csrfToken = productsManager.getCSRFTokenFromPDPOf(userSession, unitsOfMeasurementToAdd.keySet()
                .stream()
                .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                .collect(Collectors.toList()));
        System.out.println("UOM CSRF :" + csrfToken);
        addUOMsToCart.addPostParameterAndValue(new API.PostParameterAndValue("CSRFToken", csrfToken));
        try {
            addUOMsToCart.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

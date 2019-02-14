package com.template.helpers.managers.orders;

import com.template.helpers.managers.products.ProductsManager;
import com.template.helpers.models.products.VariantProduct;
import com.template.helpers.request_engine.GETRequest;
import com.template.helpers.request_engine.POSTRequest;
import com.template.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CartManager {

    @Autowired private ProductsManager productsManager;

    private final POSTRequest EMPTY_CART = new POSTRequest("Empty cart", "cart/removeAll");
    private final GETRequest CART_PAGE_SOURCE = new GETRequest("Get Cart page source", "cart");
    private final POSTRequest ADD_PRODUCT_TO_CART = new POSTRequest("Add product to cart", "cart/add");

    @Step("Get list of products from cart via API.")
    public Map<VariantProduct, Integer> getProductsInCart(UserSession userSession) {
        GETRequest cartPageSource = CART_PAGE_SOURCE.getClone();
        cartPageSource.setIsShortLogResponse(true);

        try {
            cartPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document cartSource = cartPageSource.getResponse().getHTMLResponseDocument();
        final String PRODUCT_ITEMS_IN_CART_XSOUPPATH = "//ul[@class*=item__list__cart]/li[@class*=item__list--item]";
        final String PRODUCT_ITEMS_ID_XSOUPPATH = "//div[@class=item__info]/div[@class=item__code]/text()";
        final String PRODUCT_ITEMS_QTY_XSOUPPATH = "//input[@name=quantity]/@value";
        return Xsoup.select(cartSource, PRODUCT_ITEMS_IN_CART_XSOUPPATH)
                .getElements().stream()
                .collect(Collectors.toMap(
                        element -> productsManager.getVariantProductById(Xsoup.select(element, PRODUCT_ITEMS_ID_XSOUPPATH).get()),
                        element -> Integer.parseInt(Xsoup.select(element, PRODUCT_ITEMS_QTY_XSOUPPATH).get())));
    }

    @Step("Empty cart via API.")
    public void emptyCart(UserSession userSession) {
        POSTRequest emptyCart = EMPTY_CART.getClone();
        emptyCart.setIsShortLogResponse(true);

        try {
            emptyCart.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Add product: {1} to cart via API.")
    public void addProduct(UserSession activeUserSession, Map.Entry<VariantProduct, Integer> product) {
        POSTRequest addProductToCart = ADD_PRODUCT_TO_CART.getClone();
        String csrfToken = getCsrfToken(activeUserSession);

        addProductToCart.addPostParameterAndValue("qty", Integer.toString(product.getValue()));
        addProductToCart.addPostParameterAndValue("productCodePost", product.getKey().getId());
        addProductToCart.addPostParameterAndValue("CSRFToken", csrfToken);

        try {
            addProductToCart.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Add product: {1} to cart via API.")
    public void addProduct(UserSession activeUserSession, Map.Entry<VariantProduct, Integer> product, String csrfToken) {
        POSTRequest addProductToCart = ADD_PRODUCT_TO_CART.getClone();

        addProductToCart.addPostParameterAndValue("qty", Integer.toString(product.getValue()));
        addProductToCart.addPostParameterAndValue("productCodePost", product.getKey().getId());
        addProductToCart.addPostParameterAndValue("CSRFToken", csrfToken);

        try {
            addProductToCart.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProducts(UserSession activeUserSession, Map<VariantProduct, Integer> products) {
        String csrfToken = getCsrfToken(activeUserSession);
        products.entrySet().forEach(product -> addProduct(activeUserSession, product, csrfToken));
    }

    private String getCsrfToken(UserSession userSession) {
        GETRequest cartPage = CART_PAGE_SOURCE.getClone();
        cartPage.setIsShortLogResponse(true);

        try {
            cartPage.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document pageSource = cartPage.getResponse().getHTMLResponseDocument();
        return pageSource.html().split("ACC.config.CSRFToken = \"")[1].split("\"")[0];
    }
}
package com.template.helpers.managers.orders;

import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.payments.Order;
import com.template.helpers.models.products.VariantProduct;
import com.template.helpers.request_engine.GETRequest;
import com.template.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Component
public class OrdersManager {
    @Autowired CartManager cartManager;
    @Autowired CheckoutManager checkoutManager;
    private ArrayList<Order> testOrders = new ArrayList<>();

    private final GETRequest ORDER_DETAILS_PAGE_SOURCE = new GETRequest("Get order details page source", "my-account/order/%s");

    public synchronized void createOrderInstance(String id, Map<VariantProduct, Integer> placedProducts, ShippingAddress shippingAddress, boolean useMyShippingAddressForBilling, CreditCard creditCard) {
        Order order = new Order(id, placedProducts, shippingAddress, useMyShippingAddressForBilling, creditCard);
        testOrders.add(order);
    }

    public synchronized Order getOrderById(String id) {
        return testOrders.stream().filter(order -> order.getId().equals(id)).findAny().orElse(null);
    }

    @Step("Place new order.")
    public Order placeNewOrder(UserSession userSession, Map<VariantProduct, Integer> products, ShippingAddress shippingAddress, boolean useShippingAddressForBilling, CreditCard creditCard) {
        Map<VariantProduct, Integer> variantProductIntegerMap = cartManager.getProductsInCart(userSession);
        if (!variantProductIntegerMap.isEmpty())
            cartManager.emptyCart(userSession);
        cartManager.addProducts(userSession, products);
        Document shippingForm = checkoutManager.getShippingAddressForm(userSession);
        checkoutManager.addShippingAddressToCheckout(userSession, shippingAddress, shippingForm);
        if(useShippingAddressForBilling) {
            checkoutManager.addBillingAddressToCheckout(userSession, creditCard.getBillingAddress());
        } else {
            checkoutManager.addShippingAddressAsBillingAddressToCheckout(userSession);
        }
        Document paymentForm = checkoutManager.getPaymentMethodForm(userSession);
        checkoutManager.addPaymentMethodToCheckoutWithoutSavingCard(userSession, creditCard, paymentForm);
        Document finalReviewForm = checkoutManager.getFinalReviewPageSource(userSession);
        Order order = checkoutManager.placeOrder(userSession, shippingAddress, useShippingAddressForBilling, creditCard, products, finalReviewForm, true);
        if (!variantProductIntegerMap.isEmpty())
            cartManager.addProducts(userSession, variantProductIntegerMap);
        return order;
    }

    @Step("Get order status via API.")
    public String getOrderStatus(UserSession userSession, Order order) {
        GETRequest orderDetailsPageSource = ORDER_DETAILS_PAGE_SOURCE.getClone();
        orderDetailsPageSource.setIsShortLogResponse(true);
        orderDetailsPageSource.setValue(order.getId());

        try {
            orderDetailsPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Xsoup.select(orderDetailsPageSource.getResponse().getHTMLResponseDocument(), "//div[@class=top-area]/div[@class=left]/ul/li[2]/text()")
                .get().split(":")[1].replaceAll("[\\s\\u00A0]", " ").trim();
    }
}

package com.template.helpers.managers.orders;

import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.payments.Subscription;
import com.template.helpers.models.payments.SubscriptionType;
import com.template.helpers.models.products.VariantProduct;
import com.template.helpers.user_engine.UserSession;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

@Component
public class SubscriptionsManager {
    @Autowired CartManager cartManager;
    @Autowired CheckoutManager checkoutManager;
    private ArrayList<Subscription> testSubscriptions = new ArrayList<>();

    public void createSubscriptionInstance(String id, Map<VariantProduct, Integer> placedProducts, ShippingAddress shippingAddress, boolean useMyShippingAddressForBilling, CreditCard creditCard, String subscriptionName, SubscriptionType subscriptionType, LocalDate startDate) {
        Subscription subscription = new Subscription(id, placedProducts, shippingAddress, useMyShippingAddressForBilling, creditCard, subscriptionName, subscriptionType, startDate);
        testSubscriptions.add(subscription);
    }

    public Subscription getSubscriptionById(String id) {
        return testSubscriptions.stream().filter(subscription -> subscription.getId().equals(id)).findAny().orElse(null);
    }

    @Step("Place new subscription.")
    public Subscription placeNewSubscription(UserSession userSession, Map<VariantProduct, Integer> products, ShippingAddress shippingAddress, boolean useMyShippingAddressForBilling, CreditCard creditCard, String subscriptionName, SubscriptionType subscriptionType, LocalDate startDate) {
        Map<VariantProduct, Integer> variantProductIntegerMap = cartManager.getProductsInCart(userSession);
        if (!variantProductIntegerMap.isEmpty())
            cartManager.emptyCart(userSession);
        cartManager.addProducts(userSession, products);
        Document shippingForm = checkoutManager.getShippingAddressForm(userSession);
        checkoutManager.addShippingAddressToCheckout(userSession, shippingAddress, shippingForm);
        if(useMyShippingAddressForBilling) {
            checkoutManager.addBillingAddressToCheckout(userSession, creditCard.getBillingAddress());
        } else {
            checkoutManager.addShippingAddressAsBillingAddressToCheckout(userSession);
        }
        Document paymentForm = checkoutManager.getPaymentMethodForm(userSession);
        checkoutManager.addPaymentMethodToCheckoutWithoutSavingCard(userSession, creditCard, paymentForm);
        Subscription subscription = checkoutManager.placeSubscription(userSession, shippingAddress, useMyShippingAddressForBilling, creditCard, products, subscriptionName, subscriptionType, startDate);
        if (!variantProductIntegerMap.isEmpty())
            cartManager.addProducts(userSession, variantProductIntegerMap);
        return subscription;
    }

}

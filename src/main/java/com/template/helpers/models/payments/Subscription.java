package com.template.helpers.models.payments;

import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.products.VariantProduct;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Map;

public class Subscription extends Payment {
    @Getter private final SubscriptionType subscriptionType;
    @Getter private final LocalDate startDate;
    @Getter private final String name;

    public Subscription(String id, Map<VariantProduct, Integer> placedProducts, ShippingAddress shippingAddress, boolean useMyShippingAddressForBilling, CreditCard creditCard, String name, SubscriptionType subscriptionType, LocalDate startDate) {
        super(id, placedProducts, shippingAddress, useMyShippingAddressForBilling, creditCard);
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.name = name;
    }
}

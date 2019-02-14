package com.template.helpers.models.payments;

import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.products.VariantProduct;

import java.util.Map;

public class Order extends Payment {
    public Order(String id, Map<VariantProduct, Integer> placedProducts, ShippingAddress shippingAddress, boolean useMyShippingAddressForBilling, CreditCard creditCard) {
        super(id, placedProducts, shippingAddress, useMyShippingAddressForBilling, creditCard);
    }
}

package com.template.helpers.models.payments;

import com.template.helpers.models.addresses.BillingAddress;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.products.VariantProduct;
import lombok.Getter;

import java.util.Map;

public class Payment {

    @Getter private final String id;
    @Getter private final Map<VariantProduct, Integer> placedProducts;
    @Getter private final ShippingAddress shippingAddress;
    @Getter private BillingAddress billingAddress;
    @Getter private final CreditCard creditCard;

    public Payment(String id, Map<VariantProduct, Integer> placedProducts, ShippingAddress shippingAddress, boolean useShippingAddressForBilling, CreditCard creditCard) {
        this.id = id;
        this.placedProducts = placedProducts;
        this.shippingAddress = shippingAddress;
        this.creditCard = creditCard;
        if (useShippingAddressForBilling) {
            this.billingAddress = new BillingAddress(shippingAddress.getUserTitle(), shippingAddress.getFirstName(), shippingAddress.getLastName(), shippingAddress.getAddressLine2(), shippingAddress.getCity(), shippingAddress.getCountry(), shippingAddress.getZipCode());
        } else {
            this.billingAddress = creditCard.getBillingAddress();
        }
    }

    @Override
    public String toString() {
        return "Payment id: " + id;
    }
}

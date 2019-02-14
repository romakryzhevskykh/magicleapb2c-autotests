package com.template.helpers.managers.orders;

import com.template.helpers.models.addresses.Address;
import com.template.helpers.models.addresses.BillingAddress;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.addresses.State;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.payments.Order;
import com.template.helpers.models.payments.Subscription;
import com.template.helpers.models.payments.SubscriptionType;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.template.helpers.managers.constants.CheckoutXSoupElements.*;

@Component
public class CheckoutManager {
    @Autowired OrdersManager ordersManager;
    @Autowired SubscriptionsManager subscriptionsManager;

    private final GETRequest GET_SHIP_TO_PAGE = new GETRequest("Get Shipping address form", "checkout/multi/delivery-address/add?edit=true");
    private final POSTRequest ADD_SHIP_TO_ADDRESS = new POSTRequest("Add Shipping address to checkout", "checkout/multi/delivery-address/add");
    private final GETRequest ADD_BILL_TO_ADDRESS = new GETRequest("Add Billing address to checkout", "checkout/multi/addon/billto-address/select");
    private final GETRequest GET_PAYMENT_METHOD_PAGE = new GETRequest("Get Payment method form", "checkout/multi/cbs-payment-method/add");
    private final GETRequest GET_FINAL_REVIEW_PAGE = new GETRequest("Get final review page source", "checkout/multi/cbs-summary/view");
    private final POSTRequest SANDBOX_EPAY_FORM = new POSTRequest("Send Sandbox request", "https://sandbox.ebizcharge.com/interface/epayform");
    private final POSTRequest PLACE_SUBSCRIPTION = new POSTRequest("Place Subscription", "checkout/multi/cbs-summary/subscriptionOrder");

    private final GETRequest OPEN_CHECKOUT = new GETRequest("Open checkout", "cart/checkout");

    @Step("Get Shipping Address checkout form.")
    public Document getShippingAddressForm(UserSession userSession) {
        GETRequest shipToRequest = GET_SHIP_TO_PAGE.getClone();
        shipToRequest.setIsShortLogResponse(true);
        try {
            shipToRequest.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return shipToRequest.getResponse().getHTMLResponseDocument();
    }

    @Step("Open checkout form.")
    public Document openCheckout(UserSession userSession) {
        GETRequest openCheckout = OPEN_CHECKOUT.getClone();
        openCheckout.setIsShortLogResponse(true);

        try {
            openCheckout.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return openCheckout.getResponse().getHTMLResponseDocument();
    }

    @Step("Accept Shipping Address form: {1}.")
    public void addShippingAddressToCheckout(UserSession userSession, Address address, Document shippingAddressForm) {
        addShippingAddressToCheckout(userSession, address, shippingAddressForm, "");
    }

    @Step("Accept Shipping Address form: {1} , PN: {3}.")
    public void addShippingAddressToCheckout(UserSession userSession, Address address, Document shippingAddressForm, String practiceName) {
        String addressId = Xsoup.select(shippingAddressForm, ADDRESS_ID_VALUE_XSOUPPATH).get();

        POSTRequest addShipAddressRequest = ADD_SHIP_TO_ADDRESS.getClone();

        addShipAddressRequest.addPostParameterAndValue("addressId", addressId == null ? "" : addressId);
        addShipAddressRequest.addPostParameterAndValue("ignoreAvalaraVerification", "false");
        addShipAddressRequest.addPostParameterAndValue("bill_state", "");
        addShipAddressRequest.addPostParameterAndValue("addressRejected", "");
        addShipAddressRequest.addPostParameterAndValue("practiceName", practiceName);
        addShipAddressRequest.addPostParameterAndValue("titleCode", address.getUserTitle().getTitleText().replaceAll("\\.", "").toLowerCase());
        addShipAddressRequest.addPostParameterAndValue("firstName", address.getFirstName());
        addShipAddressRequest.addPostParameterAndValue("lastName", address.getLastName());
        addShipAddressRequest.addPostParameterAndValue("line1", address.getStreet());
        addShipAddressRequest.addPostParameterAndValue("line2", address.getAddressLine2());
        addShipAddressRequest.addPostParameterAndValue("townCity", address.getCity());
        addShipAddressRequest.addPostParameterAndValue("regionIso", State.getStateByFullName(address.getCountry()).getWithCountryAbbreviation());
        addShipAddressRequest.addPostParameterAndValue("postcode", address.getZipCode());
        addShipAddressRequest.addPostParameterAndValue("phone", address.getPhoneNumber());
        addShipAddressRequest.addPostParameterAndValue("_saveInAddressBook", "on");

        try {
            addShipAddressRequest.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Accept Billing Address form with Shipping address.")
    public void addShippingAddressAsBillingAddressToCheckout(UserSession userSession) {
        GETRequest getBillto = ADD_BILL_TO_ADDRESS.getClone();
        getBillto.setIsShortLogResponse(true);
        getBillto.setGetParameterAndValue("addressId", "");
        getBillto.setGetParameterAndValue("useDeliveryAddress", "true");
        getBillto.setGetParameterAndValue("_useDeliveryAddress", "on");
        getBillto.setGetParameterAndValue("billTo_country", "US");

        try {
            getBillto.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBillingAddressToCheckout(UserSession userSession, BillingAddress billingAddress) {
        addBillingAddressToCheckout(userSession, billingAddress, "");
    }

    @Step("Accept Billing Address form with: {1} and PN: {2}")
    public void addBillingAddressToCheckout(UserSession userSession, BillingAddress billingAddress, String practiceName) {
        GETRequest getBillto = ADD_BILL_TO_ADDRESS.getClone();
        getBillto.setIsShortLogResponse(true);
        getBillto.setGetParameterAndValue("addressId", "");
        getBillto.setGetParameterAndValue("_useDeliveryAddress", "on");
        getBillto.setGetParameterAndValue("billTo_country", State.getStateByFullName(billingAddress.getCountry()).getCountry().getAbbreviation());
        getBillto.setGetParameterAndValue("billTo_practiceName", practiceName);
        getBillto.setGetParameterAndValue("billTo_titleCode", billingAddress.getUserTitle().getTitleText().replaceAll("\\.", "").toLowerCase());
        getBillto.setGetParameterAndValue("billTo_firstName", billingAddress.getFirstName());
        getBillto.setGetParameterAndValue("billTo_lastName", billingAddress.getLastName());
        getBillto.setGetParameterAndValue("billTo_street1", billingAddress.getStreet());
        getBillto.setGetParameterAndValue("billTo_street2", billingAddress.getAddressLine2());
        getBillto.setGetParameterAndValue("billTo_city", billingAddress.getCity());
        getBillto.setGetParameterAndValue("billTo_state", State.getStateByFullName(billingAddress.getCountry()).getWithCountryAbbreviation());
        getBillto.setGetParameterAndValue("billTo_postalCode", billingAddress.getZipCode());

        try {
            getBillto.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Get Payment method checkout form.")
    public Document getPaymentMethodForm(UserSession userSession) {
        GETRequest getPayMForm = GET_PAYMENT_METHOD_PAGE.getClone();
        getPayMForm.setIsShortLogResponse(true);
        try {
            getPayMForm.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getPayMForm.getResponse().getHTMLResponseDocument();
    }

    @Step("Fill form with credit card: {1} and Save card: {3}")
    public String addPaymentMethodToCheckout(UserSession userSession, CreditCard creditCard, Document paymentForm, boolean saveCard) {
        POSTRequest addCard = SANDBOX_EPAY_FORM.getClone();

        addCard.addPostParameterAndValue("UMsubmit", "1");
        addCard.addPostParameterAndValue("UMkey", Xsoup.select(paymentForm, UM_KEY_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMname", "");
        addCard.addPostParameterAndValue("UMredirDeclined", Xsoup.select(paymentForm, UM_REDIR_DECLINED_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMredirApproved", Xsoup.select(paymentForm, UM_REDIR_APPROVED_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMredir", "");
        addCard.addPostParameterAndValue("UMhash", Xsoup.select(paymentForm, UM_HASH_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMcommand", Xsoup.select(paymentForm, UM_COMMAND_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMamount", Xsoup.select(paymentForm, UM_AMOUNT_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMtax", "");
        addCard.addPostParameterAndValue("UMinvoice", Xsoup.select(paymentForm, UM_INVOICE_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMcustid", "");
        addCard.addPostParameterAndValue("UMrecurring", "");
        addCard.addPostParameterAndValue("UMbillamount", "");
        addCard.addPostParameterAndValue("UMcustreceipt", "");
        addCard.addPostParameterAndValue("UMschedule", "");
        addCard.addPostParameterAndValue("UMnumleft", "");
        addCard.addPostParameterAndValue("UMstart", "");
        addCard.addPostParameterAndValue("UMexpire", "");
        addCard.addPostParameterAndValue("UMdescription", "");
        addCard.addPostParameterAndValue("UMechofields", "all");
        addCard.addPostParameterAndValue("UMisError", "");
        addCard.addPostParameterAndValue("UMbillfname", "");
        addCard.addPostParameterAndValue("UMbilllname", "");
        addCard.addPostParameterAndValue("UMbillcompany", "");
        addCard.addPostParameterAndValue("UMbillstreet", "");
        addCard.addPostParameterAndValue("UMbillstreet2", "");
        addCard.addPostParameterAndValue("UMbillcity", "");
        addCard.addPostParameterAndValue("UMbillstate", "");
        addCard.addPostParameterAndValue("UMbillzip", "");
        addCard.addPostParameterAndValue("UMbillphone", "");
        addCard.addPostParameterAndValue("UMFrameType", "tokenization");
        addCard.addPostParameterAndValue("paymentId", "");
        addCard.addPostParameterAndValue("UMexpir", creditCard.getExpirationMonth() + creditCard.getExpirationYear().substring(2));
        addCard.addPostParameterAndValue("UMexpirMonth", "");
        addCard.addPostParameterAndValue("UMexpirYear", "");
        addCard.addPostParameterAndValue("UMtransactionId", Xsoup.select(paymentForm, UM_TRANSACTION_ID_VALUE_XSOUPPATH).get());
        addCard.addPostParameterAndValue("UMaddcustomer", saveCard ? "true" : "");
        addCard.addPostParameterAndValue("UMsaveCard", saveCard ? "true" : "");
        addCard.addPostParameterAndValue("UMbaseUrl", userSession.getUser().getUserCockpit().getBaseUrl());
        addCard.addPostParameterAndValue("UMcard", creditCard.getCardNumber());
        addCard.addPostParameterAndValue("UMexpirMonth", creditCard.getExpirationMonth());
        addCard.addPostParameterAndValue("UMexpirYear", creditCard.getExpirationYear());
        addCard.addPostParameterAndValue("UMcvv2", creditCard.getCvv());
        addCard.addPostParameterAndValue("UMexpirMonth", creditCard.getExpirationMonth());

        try {
            addCard.sendPostRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cardId = addCard.getResponse().getResponseLocation().split("UMcardRef=")[1].split("&")[0];

        GETRequest addCardGet = new GETRequest("add card get", addCard.getResponse().getResponseLocation());

        try {
            addCardGet.sendGetRequest(userSession.getCookies());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cardId;
    }

    public String addPaymentMethodToCheckoutAndSaveCard(UserSession userSession, CreditCard creditCard, Document paymentForm) {
        return addPaymentMethodToCheckout(userSession, creditCard, paymentForm, true);
    }

    public String addPaymentMethodToCheckoutWithoutSavingCard(UserSession userSession, CreditCard creditCard, Document paymentForm) {
        return addPaymentMethodToCheckout(userSession, creditCard, paymentForm, false);
    }

    @Step("Get Final review page source.")
    public Document getFinalReviewPageSource(UserSession userSession) {
        GETRequest finalReviewPageSource = GET_FINAL_REVIEW_PAGE.getClone();
        finalReviewPageSource.setIsShortLogResponse(true);
        try {
            finalReviewPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalReviewPageSource.getResponse().getHTMLResponseDocument();
    }

    @Step("Place order.")
    public Order placeOrder(UserSession userSession, ShippingAddress shippingAddress, boolean useMyShippingAddressForBilling, CreditCard creditCard, Map<VariantProduct, Integer> products, Document finalReviewForm, boolean hidedCVV) {
        POSTRequest placeOrder = SANDBOX_EPAY_FORM.getClone();

        placeOrder.addPostParameterAndValue("UMsubmit", "1");
        placeOrder.addPostParameterAndValue("UMkey", Xsoup.select(finalReviewForm, UM_KEY_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMname", Xsoup.select(finalReviewForm, UM_NAME_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMcommand", Xsoup.select(finalReviewForm, UM_COMMAND_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMredirDeclined", Xsoup.select(finalReviewForm, UM_REDIR_DECLINED_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMredirApproved", Xsoup.select(finalReviewForm, UM_REDIR_APPROVED_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMredir", "");
        placeOrder.addPostParameterAndValue("UMhash", Xsoup.select(finalReviewForm, UM_HASH_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMsubtotal", Xsoup.select(finalReviewForm, UM_SUBTOTAL_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMdiscount", Xsoup.select(finalReviewForm, UM_DISCOUNT_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMtip", "");
        placeOrder.addPostParameterAndValue("UMamount", Xsoup.select(finalReviewForm, UM_AMOUNT_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMtax", Xsoup.select(finalReviewForm, UM_TAX_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMstreet", Xsoup.select(finalReviewForm, UM_STREET_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMzip", Xsoup.select(finalReviewForm, UM_ZIP_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMinvoice", Xsoup.select(finalReviewForm, UM_INVOICE_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMsubscriptionId", Xsoup.select(finalReviewForm, UM_SUBSCRIPTION_ID_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMsubscriptionForm", "");
        placeOrder.addPostParameterAndValue("UMcard", Xsoup.select(finalReviewForm, UM_CARD_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMrefNum", "");
        placeOrder.addPostParameterAndValue("UMcustid", Xsoup.select(finalReviewForm, UM_CUST_ID_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMrecurring", "");
        placeOrder.addPostParameterAndValue("UMaddcustomer", "");
        placeOrder.addPostParameterAndValue("UMbillamount", "");
        placeOrder.addPostParameterAndValue("UMcustreceipt", "");
        placeOrder.addPostParameterAndValue("UMschedule", "");
        placeOrder.addPostParameterAndValue("UMnumleft", "");
        placeOrder.addPostParameterAndValue("UMstart", "");
        placeOrder.addPostParameterAndValue("UMexpire", "");
        placeOrder.addPostParameterAndValue("UMdescription", "");
        placeOrder.addPostParameterAndValue("UMechofields", "all");
        placeOrder.addPostParameterAndValue("UMbillfname", creditCard.getBillingAddress().getFirstName());
        placeOrder.addPostParameterAndValue("UMbilllname", creditCard.getBillingAddress().getLastName());
        placeOrder.addPostParameterAndValue("UMbillcompany", "");
        placeOrder.addPostParameterAndValue("UMbillstreet", creditCard.getBillingAddress().getStreet());
        placeOrder.addPostParameterAndValue("UMbillstreet2", creditCard.getBillingAddress().getAddressLine2());
        placeOrder.addPostParameterAndValue("UMbillcity", creditCard.getBillingAddress().getCity());
        placeOrder.addPostParameterAndValue("UMbillstate", State.getStateByFullName(creditCard.getBillingAddress().getCountry()).getWithCountryAbbreviation());
        placeOrder.addPostParameterAndValue("UMbillzip", creditCard.getBillingAddress().getZipCode());
        placeOrder.addPostParameterAndValue("UMbillcountry", State.getStateByFullName(creditCard.getBillingAddress().getCountry()).getCountry().getAbbreviation());
        placeOrder.addPostParameterAndValue("UMbillphone", creditCard.getBillingAddress().getPhoneNumber());
        placeOrder.addPostParameterAndValue("UMshipfname", shippingAddress.getFirstName());
        placeOrder.addPostParameterAndValue("UMshiplname", shippingAddress.getLastName());
        placeOrder.addPostParameterAndValue("UMshipcompany", "");
        placeOrder.addPostParameterAndValue("UMshipstreet", shippingAddress.getStreet());
        placeOrder.addPostParameterAndValue("UMshipstreet2", shippingAddress.getAddressLine2());
        placeOrder.addPostParameterAndValue("UMshipcity", shippingAddress.getCity());
        placeOrder.addPostParameterAndValue("UMshipstate", State.getStateByFullName(shippingAddress.getCountry()).getWithCountryAbbreviation());
        placeOrder.addPostParameterAndValue("UMshipzip", shippingAddress.getZipCode());
        placeOrder.addPostParameterAndValue("UMshipcountry", State.getStateByFullName(shippingAddress.getCountry()).getCountry().getAbbreviation());
        placeOrder.addPostParameterAndValue("UMshipphone", shippingAddress.getPhoneNumber());
        placeOrder.addPostParameterAndValue("UMip", Xsoup.select(finalReviewForm, UM_IP_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMFrameType", "authorization");
        placeOrder.addPostParameterAndValue("UMhideCvv", String.valueOf(hidedCVV));
        placeOrder.addPostParameterAndValue("UMclearance", Xsoup.select(finalReviewForm, UM_CLEARANCE_XSOUPPATH).get());

        ZoneId gmtZone = ZoneId.of("GMT");
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime gmt = ZonedDateTime.of(now, gmtZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z");
        placeOrder.addPostParameterAndValue("UMtermsTimestamp", gmt.format(formatter));
        if (Xsoup.select(finalReviewForm, UM_CLEARANCE_XSOUPPATH).get().equals("true")) {
            now = LocalDateTime.now();
            gmt = ZonedDateTime.of(now, gmtZone);
            placeOrder.addPostParameterAndValue("UMtermsClearanceTimestamp", gmt.format(formatter));
        } else {
            placeOrder.addPostParameterAndValue("UMtermsClearanceTimestamp", "");
        }
        placeOrder.addPostParameterAndValue("UMtransactionId", Xsoup.select(finalReviewForm, UM_TRANSACTION_ID_XSOUPPATH).get());
        placeOrder.addPostParameterAndValue("UMFreeOrderPlaceURL", "");

        int i = 1;
        for (Map.Entry<VariantProduct, Integer> product : products.entrySet()) {
            placeOrder.addPostParameterAndValue("UMline" + i + "sku", product.getKey().getId());
            placeOrder.addPostParameterAndValue("UMline" + i + "cost", Double.toString(product.getKey().getPrice()));
            placeOrder.addPostParameterAndValue("UMline" + i + "productrefnum", product.getKey().getId());
            placeOrder.addPostParameterAndValue("UMline" + i + "name", product.getKey().getBaseProduct().getName());
            placeOrder.addPostParameterAndValue("UMline" + i + "qty", String.valueOf(product.getValue()));
            i++;
        }

        placeOrder.addPostParameterAndValue("UMexpir", "0000");
        placeOrder.addPostParameterAndValue("UMcvv2", hidedCVV ? "" : creditCard.getCvv());
        placeOrder.addPostParameterAndValue("termsCheck", "true");
        placeOrder.addPostParameterAndValue("_termsCheck", "on");
        placeOrder.addPostParameterAndValue("_termsCheck", "on");

        try {
            placeOrder.sendPostRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GETRequest placeOrderStorefront = new GETRequest("Place order Storefront", placeOrder.getResponse().getResponseLocation());

        try {
            placeOrderStorefront.sendGetRequest(userSession.getCookies());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile(Pattern.quote("orderConfirmation/") + "(.*?)" + Pattern.quote("\";"));
        Matcher matcher = pattern.matcher(placeOrderStorefront.getResponse().getHTMLResponseDocument().html());

        String orderId = matcher.find() ? matcher.group(1) : null;
        ordersManager.createOrderInstance(orderId, products, shippingAddress, useMyShippingAddressForBilling, creditCard);
        return ordersManager.getOrderById(orderId);
    }

    @Step("Place subscription.")
    public Subscription placeSubscription(UserSession userSession, ShippingAddress shippingAddress, boolean useMyShippingAddressForBilling, CreditCard creditCard, Map<VariantProduct, Integer> products, String subscriptionName, SubscriptionType subscriptionType, LocalDate startDate) {
        POSTRequest placeSubscription = PLACE_SUBSCRIPTION.getClone();
        placeSubscription.addPostParameterAndValue("placeNow", "false");
        placeSubscription.addPostParameterAndValue("UMcvv2", "");
        placeSubscription.addPostParameterAndValue("termsCheck", "true");
        placeSubscription.addPostParameterAndValue("subscriptionName", subscriptionName);
        placeSubscription.addPostParameterAndValue("replenishmentRecurrence", subscriptionType.name());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        placeSubscription.addPostParameterAndValue("replenishmentStartDate", startDate.format(formatter));
        placeSubscription.addPostParameterAndValue("nDays", "14");
        placeSubscription.addPostParameterAndValue("nWeeks", "1");
        placeSubscription.addPostParameterAndValue("nDaysOfWeek", "MONDAY");
        placeSubscription.addPostParameterAndValue("_nDaysOfWeek", "on");
        placeSubscription.addPostParameterAndValue("nthDayOfMonth", "1");
        placeSubscription.addPostParameterAndValue("replenishmentOrder", "true");

        try {
            placeSubscription.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile(Pattern.quote("confirmation/") + "(.*?)" + Pattern.quote("\";"));
        Matcher matcher = pattern.matcher(placeSubscription.getResponse().getHTMLResponseDocument().html());

        String subscriptionId = matcher.find() ? matcher.group(1) : null;

        subscriptionsManager.createSubscriptionInstance(subscriptionId, products, shippingAddress, useMyShippingAddressForBilling, creditCard, subscriptionName, subscriptionType, startDate);
        return subscriptionsManager.getSubscriptionById(subscriptionId);
    }
}

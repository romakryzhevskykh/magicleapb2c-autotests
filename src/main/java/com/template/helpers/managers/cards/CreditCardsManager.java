package com.template.helpers.managers.cards;

import com.template.helpers.managers.addresses.AddressesManager;
import com.template.helpers.managers.orders.CartManager;
import com.template.helpers.managers.orders.CheckoutManager;
import com.template.helpers.managers.products.ProductsManager;
import com.template.helpers.models.addresses.AddressTestType;
import com.template.helpers.models.addresses.BillingAddress;
import com.template.helpers.models.credit_cards.CardTestType;
import com.template.helpers.models.credit_cards.CardType;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.products.VariantProduct;
import com.template.helpers.models.users.User;
import com.template.helpers.request_engine.APIResponse;
import com.template.helpers.request_engine.GETRequest;
import com.template.helpers.request_engine.POSTRequest;
import com.template.helpers.user_engine.UserSession;
import com.template.utils.SiteUtil;
import javafx.util.Pair;
import lombok.Getter;
import org.apache.commons.lang.RandomStringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.template.helpers.managers.constants.CreditCardsXSoupElements.*;
import static com.template.utils.RandomUtil.getRandomIntInRange;


public class CreditCardsManager {

    private static final String URL_ADD = "powertools/en/USD/";

    @Autowired private AddressesManager addressesManager;
    @Autowired private CartManager cartManager;
    @Autowired private ProductsManager productsManager;
    @Autowired private CheckoutManager checkoutManager;
    @Getter private ArrayList<CreditCard> testCreditCards = new ArrayList<>();

    private final GETRequest PAYMENT_INFO_PAGE_SOURCE = new GETRequest("Payment info page source", URL_ADD + "my-account/payment-details");
    private final POSTRequest REMOVE_PAYMENT_METHOD = new POSTRequest("Remove payment method from user list", URL_ADD + "my-account/remove-payment-method");
    private final POSTRequest SET_CARD_AS_DEFAULT = new POSTRequest("Set card as default", URL_ADD + "my-account/set-default-payment-details");

    public CreditCard createInstance(CardType cardType, String cardNumber, String cardExpiryMonth, String cardExpiryYear, String cvv, BillingAddress billingAddress) {
        return new CreditCard(cardType, cardNumber, cardExpiryMonth, cardExpiryYear, cvv, billingAddress);
    }

    public void createTestInstance(String cardTypeName, String cardNumber, String cardExpiryMonth, String cardExpiryYear, String cvv) {
        CardType cardType = CardType.byTextName(cardTypeName);
        BillingAddress billingAddress = addressesManager.generateRandomBillingAddress(AddressTestType.VALID);
        CreditCard creditCard = createInstance(cardType, cardNumber, cardExpiryMonth, cardExpiryYear, cvv, billingAddress);
        testCreditCards.add(creditCard);
    }

    @Step("Generate random {0} Credit card.")
    public CreditCard generateRandomCard(CardTestType cardTestType) {
        if (cardTestType.equals(CardTestType.VALID)) {
            Random rand = new Random();
            return testCreditCards.get(rand.nextInt(testCreditCards.size()));
        } else if (cardTestType.equals(CardTestType.INVALID_BILLING_ADDRESS)) {
            BillingAddress billingAddress = addressesManager.generateRandomBillingAddress(AddressTestType.INVALID);
            Random rand = new Random();
            CreditCard creditCard = testCreditCards.get(rand.nextInt(testCreditCards.size()));
            return createInstance(creditCard.getCardType(), creditCard.getCardNumber(), creditCard.getExpirationMonth(),
                    creditCard.getExpirationYear(), creditCard.getCvv(), billingAddress);
        } else if (cardTestType.equals(CardTestType.INVALID_CARD_DATA)) {
            BillingAddress billingAddress = addressesManager.generateRandomBillingAddress(AddressTestType.VALID);
            CardType cardType = CardType.getAny();
            String cardNumber = RandomStringUtils.randomNumeric(16);
            String expiryMonth = String.valueOf(getRandomIntInRange(1, 12));
            String expiryYear = String.valueOf(getRandomIntInRange(2020, 2025));
            String cvv = String.valueOf(getRandomIntInRange(100, 999));
            return createInstance(cardType, cardNumber, expiryMonth, expiryYear, cvv, billingAddress);
        } else
            throw new NullPointerException("Card test type: " + cardTestType + " is not added to generator.");
    }

    private Map<String, Pair<CreditCard, Boolean>> getCreditCardsFromPage(UserSession userSession) {


        Document pageSource = getPageSource(userSession).getHTMLResponseDocument();
        return Xsoup.select(pageSource, CARD_ELEMENTS_X_SOUP_PATH).getElements().stream()
                .collect(Collectors.toMap(
                        element -> Xsoup.select(element, CARD_REMOVE_BUTTON_CARD_ID_X_SOUP_PATH).get(),
                        this::getCreditCard));
    }


    private Pair<CreditCard, Boolean> getCreditCard(Element cardElement) {
        //TODO no billing name in OOB
        //billing data parser
//                            List<String> billingNameParts = Stream.of(Xsoup.select(element, NAME_IN_CARD_X_SOUP_PATH).get()
//                                    .replaceAll(" ", CUSTOM_SPLITTER)
//                                    .split("[\\s\\u00A0]"))
//                                    .map(str -> str.replaceAll(CUSTOM_SPLITTER, " "))
//                                    .map(String::trim)
//                                    .collect(Collectors.toList());
//                            UserTitle title = UserTitle.getUserTitleByTitleText(billingNameParts.get(0));
//                            String firstName = billingNameParts.get(1);
//                            String lastName = billingNameParts.get(2);
        String addressLine1 = Xsoup.select(cardElement, CARD_ADDRESS_1_X_SOUP_PATH).get();
        String[] cityState = SiteUtil.separateWordsByWhiteSpace(Xsoup.select(cardElement, CARD_CITY_STATE_X_SOUP_PATH).get());
        String city = cityState[0].trim();
        String state = cityState.length > 1 ? cityState[1].trim() : null;
        String[] countryZip = SiteUtil.separateWordsByWhiteSpace(Xsoup.select(cardElement, CARD_COUNTRY_ZIP_X_SOUP_PATH).get());
        String country = countryZip[0].trim();
        String postalCode = countryZip[1].trim();
        //TODO no name on Payment details in OOB hybris
//                            BillingAddress billingAddress = addressesManager.createBillingAddressInstance(title, firstName, lastName, addressLine1, city, state, postalCode);
        BillingAddress billingAddress = addressesManager.createBillingAddressInstance(null, null, null, addressLine1, city, country, postalCode);
        if (state != null) {
            billingAddress.setState(state);
        }
        //credit card data parser
        CardType cardType = CardType.cardTypeByTextMarker(Xsoup.select(cardElement, CARD_TYPE_X_SOUP_PATH).get().trim());
        String cardMask = Xsoup.select(cardElement, CARD_MASK_X_SOUP_PATH).get().trim();
        String cardExpiryMonth = Xsoup.select(cardElement, CARD_EXPIRY_DATA_X_SOUP_PATH).get().trim().split("/")[0].replaceAll("[\\s\\u00A0]", "");
        String cardExpiryYear = Xsoup.select(cardElement, CARD_EXPIRY_DATA_X_SOUP_PATH).get().trim().split("/")[1].replaceAll("[\\s\\u00A0]", "");
        CreditCard sameCreditCardByMask = getTestCreditCards().stream()
                .filter(creditCard -> creditCard.getCardNumber().endsWith(cardMask.substring(cardMask.length() - 4)))
                .findAny().orElse(null);
        String cvv = sameCreditCardByMask != null ? sameCreditCardByMask.getCvv() : null;

        String isDefaultCardText = Xsoup.select(cardElement, CARD_IS_DEFAULT_X_SOUP_PATH).get();
        Boolean isDefaultFlag = false;
        if (isDefaultCardText != null && isDefaultCardText.contains("(Default)")) {
            isDefaultFlag = true;
        }

        return new Pair<>(createInstance(cardType, cardMask, cardExpiryMonth, cardExpiryYear, cvv, billingAddress), isDefaultFlag);

    }

    @Step("Get user {0} saved cards from Payment info page.")
    public List<User.UserCreditCard> getAndUpdateUserSavedCreditCards(UserSession activeUserSession) {
        activeUserSession.getUser().getUserCreditCards().clear();

        getCreditCardsFromPage(activeUserSession).forEach((key, value) -> {
            activeUserSession.getUser().addCreditCard(key, value.getKey());
            if (value.getValue()) {
                activeUserSession.getUser().setCreditCardIsDefault(value.getKey());
            }
        });
        activeUserSession.getUser().setCreditCardInit(true);

        return activeUserSession.getUser().getUserCreditCards();
    }

    @Step("Get user credit cards without init if possible.")
    public List<User.UserCreditCard> getUserSavedCreditCards(UserSession userSession) {
        if (!userSession.getUser().isCreditCardInit()) {
            getAndUpdateUserSavedCreditCards(userSession);
        }
        return userSession.getUser().getUserCreditCards();
    }

    @Step("Get Payment info page source.")
    private APIResponse getPageSource(UserSession userSession) {
        GETRequest paymentInfoSource = PAYMENT_INFO_PAGE_SOURCE.getClone();
        paymentInfoSource.setIsShortLogResponse(true);

        try {
            paymentInfoSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return paymentInfoSource.getResponse();
    }

    public void removeUserCreditCards(UserSession activeUserSession, List<User.UserCreditCard> userCreditCards) {
        String token = getCsrfToken(activeUserSession);
        userCreditCards.forEach(userCreditCard -> removeUserCreditCard(activeUserSession, userCreditCard, token));
        activeUserSession.getUser().getUserCreditCards().removeAll(userCreditCards);
    }

    public void removeUserCreditCards(UserSession activeUserSession, User.UserCreditCard userCreditCard) {
        String token = getCsrfToken(activeUserSession);
        removeUserCreditCard(activeUserSession, userCreditCard, token);
        activeUserSession.getUser().getUserCreditCards().remove(userCreditCard);
    }

    @Step("Remove CC: {1} for user {0}.")
    private void removeUserCreditCard(UserSession activeUserSession, User.UserCreditCard userCreditCard, String CsrToken) {
        POSTRequest removePaymentMethod = REMOVE_PAYMENT_METHOD.getClone();
        removePaymentMethod.addPostParameterAndValue("paymentInfoId", userCreditCard.getId());
        removePaymentMethod.addPostParameterAndValue("CSRFToken", CsrToken);

        try {
            removePaymentMethod.sendPostRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Add Credit card to user saved cards.")
    public void addCreditCardToUserSavedCards(UserSession userSession, CreditCard creditCard) {
        Map<VariantProduct, Integer> variantProducts = cartManager.getProductsInCart(userSession);
        if (variantProducts.isEmpty()) {
            Map<VariantProduct, Integer> productsToAdd = new HashMap<VariantProduct, Integer>() {{
                put(productsManager.getProductByProductTestTypes(new ArrayList<String>() {{
                    add("VALID");
                }}), 1);
            }};
            cartManager.addProducts(userSession, productsToAdd);
        }

        Document shippingAddressForm = checkoutManager.getShippingAddressForm(userSession);
        checkoutManager.addShippingAddressToCheckout(userSession, creditCard.getBillingAddress(), shippingAddressForm);
        checkoutManager.addShippingAddressAsBillingAddressToCheckout(userSession);
        Document paymentMethodForm = checkoutManager.getPaymentMethodForm(userSession);
        String cardId = checkoutManager.addPaymentMethodToCheckoutAndSaveCard(userSession, creditCard, paymentMethodForm);
        Map<String, Pair<CreditCard, Boolean>> existedCreditCards = getCreditCardsFromPage(userSession);
        if (existedCreditCards.get(cardId) == null) {
            Optional<Map.Entry<String, Pair<CreditCard, Boolean>>> existedCC = existedCreditCards.entrySet().stream()
                    .filter(existedCreditCard -> existedCreditCard.getValue().getKey().equals(creditCard))
                    .findAny();
            if (existedCC.isPresent()) {
                cardId = existedCC.get().getKey();
            }
        }

        if (userSession.getUser().getUserCreditCards().isEmpty()) {
            userSession.getUser().addCreditCard(cardId, creditCard);
            userSession.getUser().setCreditCardIsDefault(creditCard);
            makeUserCreditCardDefault(userSession, userSession.getUser().getUserCreditCards().stream()
                    .filter(userCreditCard -> userCreditCard.getCreditCard() == creditCard)
                    .findAny().orElse(null));
        } else {
            userSession.getUser().addCreditCard(cardId, creditCard);
        }

        cartManager.emptyCart(userSession);
        cartManager.addProducts(userSession, variantProducts);
    }

    @Step("Make user Credit card: {1} default.")
    public void makeUserCreditCardDefault(UserSession userSession, User.UserCreditCard creditCard) {
        POSTRequest setAsDefault = SET_CARD_AS_DEFAULT.getClone();

        setAsDefault.addPostParameterAndValue("paymentInfoId", creditCard.getId());

        try {
            setAsDefault.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        creditCard.setDefault(true);
    }

    public void createNewUserCCs(UserSession userSession, List<CreditCard> ccs) {
        ccs.forEach(creditCard -> addCreditCardToUserSavedCards(userSession, creditCard));
    }

    public void createNumberOfUniqueCreditCards(UserSession activeUserSession, int numberOfCCToCreate) {
        List<CreditCard> ccAddedToUser = activeUserSession.getUser().getUserCreditCards()
                .stream()
                .map(User.UserCreditCard::getCreditCard)
                .collect(Collectors.toList());
        List<CreditCard> availableCC = getTestCreditCards().stream()
                .filter(testValidCC -> ccAddedToUser.stream().noneMatch(cc -> cc.equals(testValidCC)))
                .collect(Collectors.toList());
        if (availableCC.size() < numberOfCCToCreate)
            throw new NullPointerException("Not enough available test Credit Cards");
        List<CreditCard> ccToAdd = availableCC.subList(0, numberOfCCToCreate);
        createNewUserCCs(activeUserSession, ccToAdd);
    }

    private String getCsrfToken(UserSession userSession) {
        Document pageSource = getPageSource(userSession).getHTMLResponseDocument();
        return pageSource.html().split("ACC.config.CSRFToken = \"")[1].split("\"")[0];
    }
}

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
import com.template.helpers.models.users.UserTitle;
import com.template.helpers.request_engine.APIResponse;
import com.template.helpers.request_engine.GETRequest;
import com.template.helpers.request_engine.POSTRequest;
import com.template.helpers.user_engine.UserSession;
import javafx.util.Pair;
import lombok.Getter;
import org.apache.commons.lang.RandomStringUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.template.utils.RandomUtil.getRandomIntInRange;


public class CreditCardsManager {

    @Autowired private AddressesManager addressesManager;
    @Autowired private CartManager cartManager;
    @Autowired private ProductsManager productsManager;
    @Autowired private CheckoutManager checkoutManager;
    @Getter private ArrayList<CreditCard> testCreditCards = new ArrayList<>();

    private final GETRequest PAYMENT_INFO_PAGE_SOURCE = new GETRequest("Payment info page source", "my-account/payment-details");
    private final POSTRequest REMOVE_PAYMENT_METHOD = new POSTRequest("Remove payment method from user list", "my-account/remove-payment-method");
    private final POSTRequest SET_CARD_AS_DEFAULT = new POSTRequest("Set card as default", "my-account/set-default-payment-details");

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
        String customSplitter = "TemporaryRemoveSign";
        String cardElementsXSoupPath = "//div[@class*=account-paymentdetails]/div[@class*=account-cards]/div[@class=row]/div[@class*=card]";
        String nameInCardXSoupPath = "ul/li[1]/div/text()";
        String billingInfoXSoupPath = "ul/li[1]/text()";
        String cardTypeXSoupPath = "ul/li[2]/text()";
        String cardMaskXSoupPath = "ul/li[3]/text()";
        String cardExpiryDataXSoupPath = "ul/li[4]/div/text()";
        String cardIsDefaultXSoupPath = "ul/li[5]";
        String cardRemoveButtonCardIdXSoupPath = "div[@class*=account-cards-actions]/a[@class*=removePaymentDetailsButton]/@data-payment-id";

        Document pageSource = getPageSource(userSession).getHTMLResponseDocument();
        return Xsoup.select(pageSource, cardElementsXSoupPath).getElements().stream()
                .collect(Collectors.toMap(
                        element -> Xsoup.select(element, cardRemoveButtonCardIdXSoupPath).get(),
                        element -> {
                            //billing data parser
                            List<String> billingNameParts = Stream.of(Xsoup.select(element, nameInCardXSoupPath).get()
                                    .replaceAll(" ", customSplitter)
                                    .split("[\\s\\u00A0]"))
                                    .map(str -> str.replaceAll(customSplitter, " "))
                                    .map(String::trim)
                                    .collect(Collectors.toList());
                            UserTitle title = UserTitle.getUserTitleByTitleText(billingNameParts.get(0));
                            String firstName = billingNameParts.get(1);
                            String lastName = billingNameParts.get(2);
                            String addressBlock = Xsoup.select(element, billingInfoXSoupPath).get();
                            List<String> addressParts = Stream.of(addressBlock.split("  "))
                                    .filter(str -> !str.trim().isEmpty())
                                    .map(str -> str.replaceAll("[\\s\\u00A0]", " ").trim())
                                    .collect(Collectors.toList());
                            String addressLine1 = addressParts.get(0);
                            String city = addressParts.get(1).split(",")[0].trim();
                            String state = addressParts.get(1).split(",")[1].trim();
                            String postalCode = addressParts.get(2);
                            BillingAddress billingAddress = addressesManager.createBillingAddressInstance(title, firstName, lastName, addressLine1, city, state, postalCode);

                            //credit card data parser
                            CardType cardType = CardType.cardTypeByTextMarker(Xsoup.select(element, cardTypeXSoupPath).get().trim());
                            String cardMask = Xsoup.select(element, cardMaskXSoupPath).get().trim();
                            String cardExpiryMonth = Xsoup.select(element, cardExpiryDataXSoupPath).get().trim().split("/")[0].replaceAll("[\\s\\u00A0]", "");
                            String cardExpiryYear = Xsoup.select(element, cardExpiryDataXSoupPath).get().trim().split("/")[1].replaceAll("[\\s\\u00A0]", "");
                            CreditCard sameCreditCardByMask = getTestCreditCards().stream()
                                    .filter(creditCard -> creditCard.getCardNumber().endsWith(cardMask.substring(cardMask.length() - 4)))
                                    .findAny().orElse(null);
                            String cvv = sameCreditCardByMask != null ? sameCreditCardByMask.getCvv() : null;

                            String isDefaultCardText = Xsoup.select(element, cardIsDefaultXSoupPath).get();
                            Boolean isDefaultFlag = false;
                            if (isDefaultCardText != null && isDefaultCardText.contains("(Default)")) {
                                isDefaultFlag = true;
                            }

                            return new Pair<>(createInstance(cardType, cardMask, cardExpiryMonth, cardExpiryYear, cvv, billingAddress), isDefaultFlag);
                        }));
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
        if(!userSession.getUser().isCreditCardInit()) {
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
        userCreditCards.forEach(userCreditCard -> removeUserCreditCard(activeUserSession, userCreditCard));
        activeUserSession.getUser().getUserCreditCards().removeAll(userCreditCards);
    }

    public void removeUserCreditCards(UserSession activeUserSession, User.UserCreditCard userCreditCard) {
        removeUserCreditCard(activeUserSession, userCreditCard);
        activeUserSession.getUser().getUserCreditCards().remove(userCreditCard);
    }

    @Step("Remove CC: {1} for user {0}.")
    private void removeUserCreditCard(UserSession activeUserSession, User.UserCreditCard userCreditCard) {
        POSTRequest removePaymentMethod = REMOVE_PAYMENT_METHOD.getClone();
        removePaymentMethod.addPostParameterAndValue("paymentInfoId", userCreditCard.getId());

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
                put(productsManager.getProductByProductTestTypes(new ArrayList<String>() {{ add("VALID"); }}), 1);
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
}

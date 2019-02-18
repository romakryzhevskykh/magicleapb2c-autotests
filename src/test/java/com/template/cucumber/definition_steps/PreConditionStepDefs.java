package com.template.cucumber.definition_steps;

import com.template.helpers.managers.addresses.AddressesManager;
import com.template.helpers.managers.cards.CreditCardsManager;
import com.template.helpers.managers.orders.CartManager;
import com.template.helpers.managers.products.ProductsManager;
import com.template.helpers.models.addresses.AddressTestType;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CardTestType;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.products.VariantProduct;
import com.template.helpers.models.users.User;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.LoginPageStorefront;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PreConditionStepDefs extends AbstractStepDefs {

    @Autowired private HeaderRowPageBlock headerRowPageBlock;
    @Autowired private LoginPageStorefront loginPageStorefront;
    @Autowired private HomePage homePage;

    @Autowired private CartManager cartManager;
    @Autowired private AddressesManager addressesManager;
    @Autowired private CreditCardsManager creditCardsManager;
    @Autowired private ProductsManager productsManager;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (headerRowPageBlock.isUserLoggedOut()) {
            loginPageStorefront.open();
            loginPageStorefront.loginAs(userSessions.getActiveUserSession());
        } else if (!headerRowPageBlock.isUserLoggedOut() && !headerRowPageBlock.isUserLoggedIn()) {
            homePage.open();
            if (headerRowPageBlock.isUserLoggedOut()) {
                loginPageStorefront.open();
                loginPageStorefront.loginAs(userSessions.getActiveUserSession());
            }
        }
    }

    @And("^(.*) Shipping address that does not exist is generated.$")
    public void validShippingAddressThatDoesNotExistIsGenerated(String validInvalid) {
        AddressTestType addressTestType = AddressTestType.valueOf(validInvalid);
        List<User.UserShippingAddress> userShippingAddresses = addressesManager.getUserSavedShippingAddresses(userSessions.getActiveUserSession());
        ShippingAddress shippingAddress = addressesManager.generateRandomShippingAddressThatDoesNotExist(userShippingAddresses, addressTestType);
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, shippingAddress);
    }

    @Given("^User does not have Saved Shipping Addresses.$")
    public void customerDoesNotHaveSavedShippingAddresses() {
        List<User.UserShippingAddress> shippingAddresses = addressesManager.getUserSavedShippingAddresses(userSessions.getActiveUserSession());
        if (!shippingAddresses.isEmpty()) {
            addressesManager.removeUserShippingAddresses(userSessions.getActiveUserSession(), shippingAddresses);
        }
    }

    @Given("^User has at least (\\d+) Saved Shipping Addresses.$")
    public void userHasAtLeastSavedShippingAddress(int numOfAddressesToExist) {
        List<User.UserShippingAddress> userShippingAddresses = addressesManager.getUserSavedShippingAddresses(userSessions.getActiveUserSession());
        if (userShippingAddresses.size() < numOfAddressesToExist) {
            int numberOfAddressesToCreate = numOfAddressesToExist - userShippingAddresses.size();
            addressesManager.createNumberOfUniqueAddresses(userSessions.getActiveUserSession(), numberOfAddressesToCreate);
        }
    }

    @And("^Choose any user Saved Shipping address.$")
    public void chooseAnyUserSavedShippingAddress() {
        User.UserShippingAddress userShippingAddress = userSessions.getActiveUserSession().getUser().getUserShippingAddresses().stream()
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("User does not have Shipping addresses.");
                });
        threadVarsHashMap.put(TestKeyword.USER_SHIPPING_ADDRESS, userShippingAddress);
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, userShippingAddress.getShippingAddress());
    }

    @And("^Choose any not default user Saved Shipping address.$")
    public void chooseAnyNotDefaultUserSavedShippingAddress() {
        User.UserShippingAddress userShippingAddress = userSessions.getActiveUserSession().getUser().getUserShippingAddresses().stream()
                .filter(userShippingAddress1 -> !userShippingAddress1.isDefault())
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("User does not have not default Shipping addresses.");
                });
        threadVarsHashMap.put(TestKeyword.USER_SHIPPING_ADDRESS, userShippingAddress);
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, userShippingAddress.getShippingAddress());
    }

    @SuppressWarnings("unchecked")
    @And("^Cart is empty.$")
    public void cartIsEmpty() {
        Map<VariantProduct, Integer> productList = cartManager.getProductsInCart(userSessions.getActiveUserSession());
        if (!productList.isEmpty()) {
            cartManager.removeProducts(userSessions.getActiveUserSession(), productList);
            getSelectedProducts().clear();
        }
    }

    @Given("^User does not have saved Credit Carts/Payment Infos.$")
    public void customerDoesNotHavePaymentInfo() {
        List<User.UserCreditCard> userCreditCards = creditCardsManager.getAndUpdateUserSavedCreditCards(userSessions.getActiveUserSession());
        if (!userCreditCards.isEmpty()) {
            creditCardsManager.removeUserCreditCards(userSessions.getActiveUserSession(), userCreditCards);
        }
    }

    @Given("^User does not have default Shipping Address.$")
    public void customerDoesNotHaveDefaultShippingAddress() {
        List<User.UserShippingAddress> shippingAddresses = addressesManager.getUserSavedShippingAddresses(userSessions.getActiveUserSession());
        shippingAddresses.stream()
                .filter(User.UserShippingAddress::isDefault)
                .findAny()
                .ifPresent(i -> addressesManager.removeUserShippingAddresses(userSessions.getActiveUserSession(), shippingAddresses));
    }

    @And("^(\\d+) (.*) products are added to cart.$")
    public void validProductsAreAddedToCart(int numberOfProducts, List<String> productTestTypes) {
        List<VariantProduct> products = productsManager.getUniqueVariantProductsByProductsQuantityAndProductTestTypes(numberOfProducts, productTestTypes);
        Map<VariantProduct, Integer> productsToAdd = products.stream().collect(Collectors.toMap(product -> product, product -> 1));
        cartManager.addProducts(userSessions.getActiveUserSession(), productsToAdd);
        addSelectedProducts(productsToAdd);
    }

    @And("^(.*) Shipping address is generated.$")
    public void validShippingAddressIsGenerated(String validInvalid) {
        AddressTestType addressTestType = AddressTestType.valueOf(validInvalid);
        ShippingAddress shippingAddress = addressesManager.generateRandomShippingAddress(addressTestType);
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, shippingAddress);
    }

    @And("^(.*) Credit card is generated.$")
    public void validCreditCardIsGenerated(String validInvalid) {
        CardTestType cardTestType = CardTestType.valueOf(validInvalid);
        CreditCard creditCard = creditCardsManager.generateRandomCard(cardTestType);
        threadVarsHashMap.put(TestKeyword.CREDIT_CARD, creditCard);
    }
}

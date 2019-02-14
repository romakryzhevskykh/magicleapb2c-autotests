package com.template.helpers.models.users;

import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.lists.SavedCart;
import com.template.hybris.Cockpit;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class User {

    @Getter @Setter private UserTitle userTitle;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String email;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter private ArrayList<UserRole> userRoles = new ArrayList<>();
    @Getter @Setter private Cockpit userCockpit;
    @Getter @Setter private boolean isEnabled;
    @Getter private ArrayList<UserCreditCard> userCreditCards = new ArrayList<>();
    @Getter private ArrayList<UserShippingAddress> userShippingAddresses = new ArrayList<>();
    @Getter private ArrayList<UserSavedCart> userSavedCarts = new ArrayList<>();

    @Getter @Setter private boolean shippingAddressInit;
    @Getter @Setter private boolean creditCardInit;
    @Getter @Setter private boolean savedListsInit;

    public User(String username, String password, Cockpit userCockpit) {
        this.username = username;
        this.password = password;
        this.userCockpit = userCockpit;
        this.isEnabled = true;
    }

    public User.UserCreditCard getDefaultUserCreditCard() {
        return userCreditCards.stream().filter(userCreditCard -> userCreditCard.isDefault).findAny().orElseGet(() -> {
                    throw new NullPointerException("User has no default Credit card.");
                }
        );
    }

    public User.UserShippingAddress getDefaultUserShippingAddress() {
        return userShippingAddresses.stream().filter(userShippingAddress -> userShippingAddress.isDefault).findAny().orElseGet(() -> {
                    throw new NullPointerException("User has no default Shipping address.");
                }
        );
    }

    public synchronized void addCreditCard(String id, CreditCard creditCard) {
        UserCreditCard userCreditCard = new UserCreditCard(id, creditCard);
        userCreditCards.add(userCreditCard);
    }

    public synchronized User.UserShippingAddress addShippingAddress(String id, ShippingAddress shippingAddress) {
        if (!shippingAddress.getAddressLine2().isEmpty()) {
            shippingAddress.setStreet(shippingAddress.getStreet() + " " + shippingAddress.getAddressLine2());
            shippingAddress.setAddressLine2("");
        }
        UserShippingAddress userShippingAddress = new UserShippingAddress(id, shippingAddress);
        userShippingAddresses.add(userShippingAddress);
        return userShippingAddress;
    }

    public synchronized void setCreditCardIsDefault(CreditCard creditCard) {
        userCreditCards.stream()
                .filter(creditCard1 -> creditCard1.getCreditCard() == creditCard)
                .findAny()
                .ifPresent(creditCard1 -> creditCard1.setDefault(true));
    }

    public synchronized void setShippingAddressIsDefault(ShippingAddress shippingAddress) {
        userShippingAddresses.stream()
                .filter(shippingAddress1 -> shippingAddress1.getShippingAddress() == shippingAddress)
                .findAny()
                .ifPresent(shippingAddress1 -> shippingAddress1.setDefault(true));
    }

    public synchronized User.UserSavedCart addSavedCart(String id, SavedCart cart) {
        UserSavedCart userSavedCart = new UserSavedCart(id, cart);
        userSavedCarts.add(userSavedCart);
        return userSavedCart;
    }

    public class UserCreditCard {
        @Getter private CreditCard creditCard;
        @Getter private boolean isDefault;
        @Getter private final String id;

        UserCreditCard(String id, CreditCard creditCard) {
            this.id = id;
            this.creditCard = creditCard;
            this.isDefault = false;
        }

        public void setDefault(boolean isDefault) {
            if (isDefault) {
                User.this.userCreditCards.forEach(creditCard -> creditCard.setDefault(false));
            }
            this.isDefault = isDefault;
        }

        @Override
        public String toString() {
            return "id: " + id + ", " + creditCard + ", " + isDefault;
        }
    }

    public class UserShippingAddress {
        @Getter private ShippingAddress shippingAddress;
        @Getter private boolean isDefault;
        @Getter private final String id;

        UserShippingAddress(String id, ShippingAddress shippingAddress) {
            this.id = id;
            this.shippingAddress = shippingAddress;
            this.isDefault = false;
        }

        public void setDefault(boolean isDefault) {
            if (isDefault) {
                User.this.userShippingAddresses.forEach(userShippingAddress -> userShippingAddress.setDefault(false));
            }
            this.isDefault = isDefault;
        }

        @Override
        public String toString() {
            return "id: " + id + ", " + shippingAddress + ", " + isDefault;
        }
    }

    public class UserSavedCart {
        @Getter private final String id;
        @Getter @Setter private String updatedDate;
        @Getter @Setter private SavedCart savedList;

        UserSavedCart(String id, SavedCart cart) {
            this.id = id;
            this.savedList = cart;
        }

        @Override
        public String toString() {
            return "List: " +
                    "id=" + id +
                    "," + savedList;
        }
    }

    @Override
    public String toString() {
        return "User: " + this.username + ", Cockpit: " + this.userCockpit.getBaseUrl() + ", Roles: " + this.getUserRoles();
    }
}

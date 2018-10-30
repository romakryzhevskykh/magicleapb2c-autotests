package com.magicleap.storefront.models;

import com.magicleap.helpers.models.users.User;

public class AddressBookEntry {
    private String country;
    private String title;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String state;
    private String postCode;
    private String phoneNumber;
    private User user;

    private AddressBookEntry(AddressBookEntryBuilder addressBookEntryBuilder) {
        this.country = addressBookEntryBuilder.country != null ? addressBookEntryBuilder.country : "";
        this.title = addressBookEntryBuilder.title != null ? addressBookEntryBuilder.title : "";
        this.firstName = addressBookEntryBuilder.firstName != null ? addressBookEntryBuilder.firstName : "";
        this.lastName = addressBookEntryBuilder.lastName != null ? addressBookEntryBuilder.lastName : "";
        this.addressLine1 = addressBookEntryBuilder.addressLine1 != null ? addressBookEntryBuilder.addressLine1 : "";
        this.addressLine2 = addressBookEntryBuilder.addressLine2 != null ? addressBookEntryBuilder.addressLine2 : "";
        this.town = addressBookEntryBuilder.town != null ? addressBookEntryBuilder.town : "";
        this.state = addressBookEntryBuilder.state != null ? addressBookEntryBuilder.state : "";
        this.postCode = addressBookEntryBuilder.postCode != null ? addressBookEntryBuilder.postCode : "";
        this.phoneNumber = addressBookEntryBuilder.phoneNumber != null ? addressBookEntryBuilder.phoneNumber : "";
        this.user = addressBookEntryBuilder.user;
    }

    public User getUser() {
        /*
          for future implementation to identify for which user this address has been created
         */
        return user;
    }

    public boolean equals(AddressBookEntry addressBookEntry) {
        return this.country.equalsIgnoreCase(addressBookEntry.country) && this.title.equals(addressBookEntry.title)
                && this.firstName.equalsIgnoreCase(addressBookEntry.firstName) && this.lastName.equalsIgnoreCase(addressBookEntry.lastName)
                && this.addressLine1.equals(addressBookEntry.addressLine1) && this.addressLine2.equals(addressBookEntry.addressLine2)
                && this.town.equals(addressBookEntry.town) && this.state.equals(addressBookEntry.state)
                && this.postCode.equals(addressBookEntry.postCode) && this.phoneNumber.equals(addressBookEntry.phoneNumber);
    }

    @Override
    public String toString() {
        return "Name: " + this.title + " " + this.firstName + " " + this.lastName + "\n" +
                "Address line 1: " + this.addressLine1 + "\n" +
                "Address line 2: " + this.addressLine2 + "\n" +
                "Town/State: " + this.town + " " + this.state + "\n" +
                "Country: " + this.country + "\n" +
                "Post code: " + this.postCode + "\n" +
                "Phone number: " + this.phoneNumber + "\n" +
                "User name: " + (user.getUsername() != null ? user.getUsername() : "user is not set.");

    }

    public static class AddressBookEntryBuilder {
        private String country;
        private String title;
        private String firstName;
        private String lastName;
        private String addressLine1;
        private String addressLine2;
        private String town;
        private String state;
        private String postCode;
        private String phoneNumber;
        private final User user;

        public AddressBookEntryBuilder(User user) {
            this.user = user;
        }

        public AddressBookEntryBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AddressBookEntryBuilder title(String title) {
            this.title = title;
            return this;
        }

        public AddressBookEntryBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AddressBookEntryBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AddressBookEntryBuilder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public AddressBookEntryBuilder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public AddressBookEntryBuilder state(String state) {
            this.state = state;
            return this;
        }

        public AddressBookEntryBuilder town(String town) {
            this.town = town;
            return this;
        }

        public AddressBookEntryBuilder postCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public AddressBookEntryBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public AddressBookEntry build() {
            return new AddressBookEntry(this);
        }
    }
}

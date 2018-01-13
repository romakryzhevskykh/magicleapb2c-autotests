package com.template.storefront.models;

import com.template.helpers.user_engine.UserCredentials;

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
    private UserCredentials userCredentials;

    private AddressBookEntry(AddressBookEntryBuilder addressBookEntryBuilder) {
        this.country = addressBookEntryBuilder.country;
        this.title = addressBookEntryBuilder.title;
        this.firstName = addressBookEntryBuilder.firstName;
        this.lastName = addressBookEntryBuilder.lastName;
        this.addressLine1 = addressBookEntryBuilder.addressLine1;
        this.addressLine2 = addressBookEntryBuilder.addressLine2;
        this.town = addressBookEntryBuilder.town;
        this.state = addressBookEntryBuilder.state;
        this.postCode = addressBookEntryBuilder.postCode;
        this.phoneNumber = addressBookEntryBuilder.phoneNumber;
        this.userCredentials = addressBookEntryBuilder.userCredentials;
    }

    public UserCredentials getUserCredentials() {
        /**
         * for future implementation to identify for which user this address has been created
         */
        return userCredentials;
    }

    public boolean equals(AddressBookEntry addressBookEntry) {
        return true;
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
        private final UserCredentials userCredentials;

        public AddressBookEntryBuilder(UserCredentials userCredentials) {
            this.userCredentials = userCredentials;
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

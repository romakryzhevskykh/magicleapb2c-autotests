package com.sarnova.helpers;

import com.sarnova.helpers.managers.CreditCardsManager;
import com.sarnova.helpers.managers.ShippingAddressesManager;
import com.sarnova.helpers.models.credit_cards.CreditCard;
import com.sarnova.helpers.models.shipping_addresses.*;
import com.sarnova.helpers.models.users.*;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomUtils {
    @Autowired ShippingAddressesManager shippingAddressesManager;
    @Autowired CreditCardsManager creditCardsManager;

    public String getRandomTestFirstName() {
        return "Test" + FirstName.getRandom().getFirstNameText();
    }

    public String getRandomTestLastName() {
        return "Test" + LastName.getRandom().getLastNameText();
    }

    public String getRandomUsername() {
        return "test" + StringUtils.capitalize(RandomStringUtils.randomAlphabetic(6).toLowerCase());
    }

    public String randomEmail() {
        return (getRandomTestFirstName().toLowerCase() + "." + getRandomTestLastName().toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(5) + ".com").toLowerCase();
    }

    public ShippingAddress getRandomValidShippingAddressWithOnlyMandatoryFields() {
        String firstName = getRandomTestFirstName();
        String lastName = getRandomTestLastName();
        Town town = Town.getAnyTown();
        String zip = town.getZipCodes().stream().findAny().orElse(null);
        State state = town.getState();
        Country country = state.getCountry();
        String addressLine1 = getRandomAddressLine1();
        String phoneNumber = RandomStringUtils.randomNumeric(10);

        return shippingAddressesManager.createInstance(firstName, lastName, addressLine1, town, state, country, zip, phoneNumber);
    }

    public ShippingAddress getRandomValidShippingAddressWithAllPossibleFields() {
        return null;
    }

    public int getRandomIntInRange(int s, int e) {
        return org.apache.commons.lang3.RandomUtils.nextInt(s, e);
    }

    public String getRandomAddressLine1() {
        return getRandomIntInRange(1, 200) + " " + StreetName.getRandom().getStreetNameText();
    }

    public CreditCard getRandomCreditCard() {
        String cardNumber = "4111111111111111";
        String cvv = "111";
        String nameOnCard = getRandomTestFirstName() + " " + getRandomTestLastName();
        String expiryMonth = String.valueOf(getRandomIntInRange(1,12));
        String expiryYear = String.valueOf(getRandomIntInRange(2019,2024));
        return creditCardsManager.createInstance(cardNumber, expiryMonth, expiryYear, nameOnCard, cvv);
    }

    public UserInformation getRandomUserInformation() {
        String username = getRandomUsername();
        String password = RandomStringUtils.randomAlphabetic(10);
        String firstName = getRandomTestFirstName();
        String lastName = getRandomTestLastName();
        Title title = Title.getAny();
        String phoneNumber = RandomStringUtils.randomNumeric(10);
        String email = randomEmail();
        SecurityQuestion securityQuestion = SecurityQuestion.getAny();
        String securityAnswer = RandomStringUtils.randomAlphabetic(10);
        AccountType accountType = AccountType.getAny();
        ProfileRole profileRole = ProfileRole.getAny();
        boolean someoneToMakePurchase = false;
        boolean receiveEmails = false;

        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(username);
        userInformation.setPassword(password);
        userInformation.setFirstName(firstName);
        userInformation.setLastName(lastName);
        userInformation.setTitle(title);
        userInformation.setAccountLabel(username);
        userInformation.setPhoneNumber(phoneNumber);
        userInformation.setEmail(email);
        userInformation.setSecurityQuestion(securityQuestion);
        userInformation.setSecurityAnswer(securityAnswer);
        userInformation.setAccountType(accountType);
        userInformation.setProfileRole(profileRole);
        userInformation.setSomeoneToMakePurchase(someoneToMakePurchase);
        userInformation.setReceiveEmails(receiveEmails);

        return userInformation;
    }
}

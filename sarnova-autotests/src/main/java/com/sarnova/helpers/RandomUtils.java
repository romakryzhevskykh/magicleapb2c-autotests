package com.sarnova.helpers;

import com.sarnova.helpers.managers.CreditCardsManager;
import com.sarnova.helpers.managers.ShippingAddressesManager;
import com.sarnova.helpers.models.credit_cards.CreditCard;
import com.sarnova.helpers.models.shipping_addresses.Country;
import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import com.sarnova.helpers.models.shipping_addresses.State;
import com.sarnova.helpers.models.shipping_addresses.Town;
import com.sarnova.helpers.request_engine.GETRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomUtils {
    @Autowired ShippingAddressesManager shippingAddressesManager;
    @Autowired CreditCardsManager creditCardsManager;
    GETRequest GET_RANDOM_ZIP_AND_CITY_ADDRESSES = new GETRequest("Get random zip and city addresses", "https://www.randomlists.com/data/zip-codes.json");

    public String randomName() {
        return StringUtils.capitalize(RandomStringUtils.randomAlphabetic(10).toLowerCase());
    }

    public String randomEmail() {
        return (RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com").toLowerCase();
    }

    public ShippingAddress getRandomValidShippingAddressWithOnlyMandatoryFields() {
//        GETRequest getRandomAddresses = GET_RANDOM_ZIP_AND_CITY_ADDRESSES.getClone();
//        try {
//            getRandomAddresses.sendGetRequest();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject response = new JSONObject(getRandomAddresses.getResponse().getResponseBodyText());
//        JSONObject randomTown = response.getJSONArray("data").getJSONObject(getRandomIntInRange(1, 100));
        String firstName = randomName();
        String lastName = randomName();
        Town town = Town.getAnyTown();
        String zip = town.getZipCodes().stream().findAny().orElse(null);
        State state = town.getState();
        Country country = state.getCountry();
        String addressLine1 = getRandomAddressLine1();

        return shippingAddressesManager.createInstance(firstName, lastName, addressLine1, town, state, country, zip);
    }

    public ShippingAddress getRandomValidShippingAddressWithAllPossibleFields() {
        return null;
    }

    public int getRandomIntInRange(int s, int e) {
        return org.apache.commons.lang3.RandomUtils.nextInt(s, e);
    }

    public String getRandomAddressLine1() {
        return getRandomIntInRange(1, 200) + " " + RandomStringUtils.randomAlphabetic(10);
    }

    public CreditCard getRandomCreditCard() {
        String cardNumber = "4111111111111111";
        String cvv = "111";
        String nameOnCard = randomName() + " " + randomName();
        String expiryMonth = String.valueOf(org.apache.commons.lang3.RandomUtils.nextInt(1,12));
        String expiryYear = String.valueOf(org.apache.commons.lang3.RandomUtils.nextInt(2019,2024));
        return creditCardsManager.createInstance(cardNumber, expiryMonth, expiryYear, nameOnCard, cvv);
    }
}

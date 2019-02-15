package com.template.helpers.managers.addresses;

import com.template.helpers.models.addresses.*;
import com.template.helpers.models.users.FirstName;
import com.template.helpers.models.users.LastName;
import com.template.helpers.models.users.User;
import com.template.helpers.models.users.UserTitle;
import com.template.helpers.request_engine.APIResponse;
import com.template.helpers.request_engine.GETRequest;
import com.template.helpers.request_engine.POSTRequest;
import com.template.helpers.user_engine.UserSession;
import com.template.utils.SiteUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.template.helpers.managers.constants.ShippingAddressXSoupElements.*;

@Component
public class AddressesManager {

    private static final String URL_ADD = "powertools/en/USD/";

    private final GETRequest ADDRESS_PAGE_SOURCE = new GETRequest("Address book page source", URL_ADD + "my-account/address-book");
    private final POSTRequest ADD_ADDRESS = new POSTRequest("Add address", URL_ADD + "my-account/add-address");
    private final GETRequest GET_ADD_ADDRESS = new GETRequest("Get page add address", URL_ADD + "my-account/add-address");
    private final GETRequest REMOVE_ADDRESS = new GETRequest("Remove address", URL_ADD + "my-account/remove-address/%s");

    private final GETRequest MARK_AS_DEFAULT = new GETRequest("Make Shipping address default", URL_ADD + "my-account/set-default-address/%s");

    private ArrayList<Address> testValidAddresses = new ArrayList<>();
    private boolean isTestAddressesInit = false;

    private List<Address> getTestAddresses() {
        if (!isTestAddressesInit) {
            testValidAddresses.addAll(Stream.of(StreetName.values()).map(streetName -> {
                UserTitle userTitle = UserTitle.getAny();
                FirstName firstName = FirstName.getAny();
                LastName lastName = LastName.getAny();
                String street = streetName.getStreetNameText();
                String city = streetName.getCity().getFullName();
                String state = streetName.getCity().getState().getFullName();
                String country = streetName.getCity().getState().getCountry().getName();
                String zipCode = streetName.getZipCode();
                Address address = createAddressInstance(userTitle, firstName.getFirstNameText(), lastName.getLastNameText(), street, city, country, zipCode);
                address.setState(state);
                return address;
            }).collect(Collectors.toList()));
            this.isTestAddressesInit = true;
        }
        return testValidAddresses;
    }

    private Address generateRandomAddress(AddressTestType validInvalid) {
        if (validInvalid.equals(AddressTestType.VALID)) {
            Random rand = new Random();
            return getTestAddresses().get(rand.nextInt(getTestAddresses().size()));
        } else if (validInvalid.equals(AddressTestType.WITH_ALL_FIELDS)) {
            Random rand = new Random();
            Address address = getTestAddresses().get(rand.nextInt(getTestAddresses().size()));
            String addressLine2 = RandomStringUtils.randomNumeric(3);
            String telephone = RandomStringUtils.randomNumeric(10);
            Address address1 = address.deepClone();
            address1.setAddressLine2(addressLine2);
            address1.setPhoneNumber(telephone);
            return address1;
        } else if (validInvalid.equals(AddressTestType.INVALID)) {
            UserTitle userTitle = UserTitle.getAny();
            FirstName firstName = FirstName.getAny();
            LastName lastName = LastName.getAny();
            String streetName = RandomStringUtils.randomAlphabetic(10);
            String city = RandomStringUtils.randomAlphabetic(10);
            String state = RandomStringUtils.randomAlphabetic(10);
            String country = RandomStringUtils.randomAlphabetic(10);
            String zipCode = RandomStringUtils.randomNumeric(5) + "-" + RandomStringUtils.randomNumeric(4);
            Address address = createAddressInstance(userTitle, firstName.getFirstNameText(), lastName.getLastNameText(), streetName, city, country, zipCode);
            address.setState(state);
            return address;
        }
        throw new NullPointerException("Status is not added to generator: " + validInvalid);
    }

    private Address createAddressInstance(UserTitle userTitle, String firstName, String lastName, String streetName, String city, String country, String zipCode) {
        return new Address(userTitle, firstName, lastName, streetName, city, country, zipCode);
    }

    @Step("Generate {0} Shipping address.")
    public ShippingAddress generateRandomShippingAddress(AddressTestType validInvalid) {
        Address address = generateRandomAddress(validInvalid);
        return createShippingAddressInstance(address);
    }

    @Step("Generate {0} Shipping address that doesn't exist.")
    public ShippingAddress generateRandomShippingAddressThatDoesNotExist(List<User.UserShippingAddress> userShippingAddresses, AddressTestType addressTestType) {
        Address address = getTestAddresses().stream()
                .filter(testValidAddress -> userShippingAddresses.stream().noneMatch(shippingAddress -> shippingAddress.getShippingAddress().equals(testValidAddress)))
                .findAny().orElseGet(() -> {
                    throw new NullPointerException("Not enough available test Addresses");
                });
        if (addressTestType == AddressTestType.WITH_ALL_FIELDS) {
            String addressLine2 = RandomStringUtils.randomNumeric(3);
            String telephone = RandomStringUtils.randomNumeric(10);
            ShippingAddress shippingAddress = createShippingAddressInstance(address);
            shippingAddress.setState(address.getState());
            shippingAddress.setAddressLine2(addressLine2);
            shippingAddress.setPhoneNumber(telephone);
            return shippingAddress;
        } else if (addressTestType == AddressTestType.VALID) {
            ShippingAddress shippingAddress = createShippingAddressInstance(address);
            shippingAddress.setState(address.getState());
            return shippingAddress;
        }
        return null; //TODO make INVALID return
    }

    @Step("Generate {0} Billing address.")
    public BillingAddress generateRandomBillingAddress(AddressTestType validInvalid) {
        Address address = generateRandomAddress(validInvalid);
        return createBillingAddressInstance(address);
    }

    public ShippingAddress createShippingAddressInstance(UserTitle userTitle, String firstName, String lastName, String address1, String city, String country, String zipCode) {
        return new ShippingAddress(userTitle, firstName, lastName, address1, city, country, zipCode);
    }

    public BillingAddress createBillingAddressInstance(UserTitle userTitle, String firstName, String lastName, String address1, String city, String state, String zipCode) {
        return new BillingAddress(userTitle, firstName, lastName, address1, city, state, zipCode);
    }

    public ShippingAddress createShippingAddressInstance(Address address) {
        return new ShippingAddress(address.getUserTitle(), address.getFirstName(), address.getLastName(), address.getStreet(), address.getCity(), address.getCountry(), address.getZipCode());
    }

    public BillingAddress createBillingAddressInstance(Address address) {
        return new BillingAddress(address.getUserTitle(), address.getFirstName(), address.getLastName(), address.getStreet(), address.getCity(), address.getCountry(), address.getZipCode());
    }

    public List<User.UserShippingAddress> getUserSavedShippingAddresses(UserSession activeUserSession) {
        if (!activeUserSession.getUser().isShippingAddressInit()) {
            activeUserSession.getUser().getUserShippingAddresses().clear();
            Document pageSourceDocument = getPageSource(activeUserSession).getHTMLResponseDocument();
            Xsoup.select(pageSourceDocument, CARD_ELEMENTS_XSOUP_PATH).getElements()
                    .forEach(element -> getUserShippingAddress(activeUserSession, element));
            activeUserSession.getUser().setShippingAddressInit(true);
        }
        return activeUserSession.getUser().getUserShippingAddresses();
    }

    private User.UserShippingAddress getUserShippingAddress(UserSession userSession, Element addressElement) {

        String addressRemoveButtonAddressIdXSoupPath = "div[@class*=account-cards-actions]/a[@class*=removeAddressFromBookButton]/@data-address-id";

        List<String> addressParts = Xsoup.select(addressElement, CARD_ELEMENTS).getElements().stream()
                .map(Element::text).collect(Collectors.toList());

        //name part
        List<String> nameParts = Stream.of(addressParts.get(0)
                .replaceAll(" ", CUSTOM_SPLITTER)
                .split("[\\s\\u00A0]"))
                .map(str -> str.replaceAll(CUSTOM_SPLITTER, " "))
                .map(String::trim)
                .collect(Collectors.toList());
        UserTitle title = UserTitle.getUserTitleByTitleText(nameParts.get(0));
        String firstName = nameParts.get(1);
        String lastName = nameParts.get(2).replace(DEFAULT_ADD, "").trim();

        int addressPartsSize = addressParts.size();
        boolean hasPhone = addressParts.get(addressPartsSize - 1).replaceAll("[^0-9]", "").length() > 0;
        boolean hasAddress2 = !(addressPartsSize <= 5);
        //address part
        String addressLine1 = addressParts.get(1).trim();
        String addressLine2 = hasAddress2 ? addressParts.get(2).trim() : null;
        String cityState = (hasAddress2 ? addressParts.get(3) : addressParts.get(2)).trim();
        String[] cityAndState = SiteUtil.separateWordsByWhiteSpace(cityState);
        boolean isState = cityAndState.length > 1;
        String city = isState ? cityAndState[0] : cityState.trim();
        String state = isState ?cityAndState[1].trim() : null;
        String countryPostal = (hasAddress2 ? addressParts.get(4) : addressParts.get(3));
        String[] countryAndPostal = SiteUtil.separateWordsByWhiteSpace(countryPostal);
        String country, postalCode;
        country = countryAndPostal[0];
        postalCode = countryAndPostal[1];
        String phone = hasPhone ? addressParts.get(addressPartsSize - 1) : null;
        ShippingAddress shippingAddress = createShippingAddressInstance(title, firstName, lastName, addressLine1, city, country, postalCode);
        if (addressLine2 != null) {
            shippingAddress.setAddressLine2(addressLine2);
        }
        if (hasPhone) {
            shippingAddress.setPhoneNumber(phone);
        }
        if (isState) {
            shippingAddress.setState(state);
        }

        String id = Xsoup.select(addressElement, addressRemoveButtonAddressIdXSoupPath).get();

        User.UserShippingAddress userShippingAddress = userSession.getUser().addShippingAddress(id, shippingAddress);

        String isDefaultAddressText = Xsoup.select(addressElement, ADDRESS_IS_DEFAULT_X_SOUP_PATH).get();
        if (isDefaultAddressText == null) {
            userSession.getUser().setShippingAddressIsDefault(shippingAddress);
        }
        return userShippingAddress;
    }

    public void removeUserShippingAddresses(UserSession activeUserSession, List<User.UserShippingAddress> shippingAddresses) {
        shippingAddresses.forEach(shippingAddress -> removeUserShippingAddress(activeUserSession, shippingAddress));
        activeUserSession.getUser().getUserShippingAddresses().removeAll(shippingAddresses);
    }

    public void removeUserShippingAddresses(UserSession activeUserSession, User.UserShippingAddress shippingAddress) {
        removeUserShippingAddress(activeUserSession, shippingAddress);
        activeUserSession.getUser().getUserShippingAddresses().remove(shippingAddress);
    }

    @Step("Remove Shipping address: {1} for user: {0}.")
    private void removeUserShippingAddress(UserSession activeUserSession, User.UserShippingAddress shippingAddress) {
        GETRequest removeAddress = REMOVE_ADDRESS.getClone();
        removeAddress.setIsShortLogResponse(true);
        removeAddress.setValue(shippingAddress.getId());

        try {
            removeAddress.sendGetRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Get Address book page source.")
    private APIResponse getPageSource(UserSession userSession) {
        GETRequest addressPageSource = ADDRESS_PAGE_SOURCE.getClone();
        addressPageSource.setIsShortLogResponse(true);

        try {
            addressPageSource.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return addressPageSource.getResponse();
    }

    @Step("Create new user: {0} Shipping Address.")
    public void createNewUserShippingAddress(UserSession userSession, Address shippingAddress, boolean isDefault) {
        POSTRequest addAddress = ADD_ADDRESS.getClone();
        addAddress.addPostParameterAndValue("addressId", "");
        addAddress.addPostParameterAndValue("bill_state", "");
        addAddress.addPostParameterAndValue("countryIso", Country.getCountryByName(shippingAddress.getCountry()).getAbbreviation());
        addAddress.addPostParameterAndValue("titleCode", shippingAddress.getUserTitle().getTitleText().toLowerCase().replaceAll("\\.", ""));
        addAddress.addPostParameterAndValue("firstName", shippingAddress.getFirstName());
        addAddress.addPostParameterAndValue("lastName", shippingAddress.getLastName());
        addAddress.addPostParameterAndValue("line1", shippingAddress.getStreet());
        addAddress.addPostParameterAndValue("line2", shippingAddress.getAddressLine2());
        addAddress.addPostParameterAndValue("townCity", shippingAddress.getCity());
        addAddress.addPostParameterAndValue("regionIso", State.getStateByFullName(shippingAddress.getState()).getWithCountryAbbreviation());
        addAddress.addPostParameterAndValue("postcode", shippingAddress.getZipCode());
        addAddress.addPostParameterAndValue("phone", shippingAddress.getPhoneNumber());
        if (isDefault) {
            addAddress.addPostParameterAndValue("defaultAddress", String.valueOf(isDefault));
        }
        addAddress.addPostParameterAndValue("_defaultAddress", "on");
        addAddress.addPostParameterAndValue("_defaultAddress", "on");
        String csrfToken = getCsrfToken(userSession);
        addAddress.addPostParameterAndValue("CSRFToken", csrfToken);

        addAddress.setFollowRedirection(true);
        try {
            addAddress.sendPostRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String finalLocation = addAddress.getResponse().getFinalLocation();
        String id = finalLocation.split("/")[finalLocation.split("/").length - 1];
        ShippingAddress shippingAddress1;
        if (!(shippingAddress instanceof ShippingAddress)) {
            shippingAddress1 = createShippingAddressInstance(shippingAddress);
            shippingAddress1.setState(shippingAddress.getState());
        }
        else {
            shippingAddress1 = (ShippingAddress) shippingAddress;
        }
        if (userSession.getUser().getUserShippingAddresses().isEmpty() || isDefault) {
            userSession.getUser().addShippingAddress(id, shippingAddress1);
            userSession.getUser().setShippingAddressIsDefault(shippingAddress1);
        } else {
            userSession.getUser().addShippingAddress(id, shippingAddress1);
        }
    }

    public void createNewUserAddresses(UserSession userSession, List<Address> shippingAddresses) {
        shippingAddresses.forEach(shippingAddress -> createNewUserShippingAddress(userSession, shippingAddress, false));
    }

    public void createNumberOfUniqueAddresses(UserSession activeUserSession, int numberOfAddressesToCreate) {
        List<ShippingAddress> shippingAddressesAddedToUser = activeUserSession.getUser().getUserShippingAddresses()
                .stream()
                .map(User.UserShippingAddress::getShippingAddress)
                .collect(Collectors.toList());
        List<Address> availableAddresses = getTestAddresses().stream()
                .filter(testValidAddress -> shippingAddressesAddedToUser.stream().noneMatch(shippingAddress -> shippingAddress.equals(testValidAddress)))
                .collect(Collectors.toList());
        if (availableAddresses.size() < numberOfAddressesToCreate)
            throw new NullPointerException("Not enough available test Addresses");
        List<Address> addressesToAdd = availableAddresses.subList(0, numberOfAddressesToCreate);
        createNewUserAddresses(activeUserSession, addressesToAdd);
    }

    public void makeUserShippingAddressDefault(UserSession activeUserSession, User.UserShippingAddress userShippingAddress) {
        GETRequest makeDefault = MARK_AS_DEFAULT.getClone();
        makeDefault.setValue(userShippingAddress.getId());

        try {
            makeDefault.sendGetRequest(activeUserSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userShippingAddress.setDefault(true);
    }

    private String getCsrfToken(UserSession userSession) {
        GETRequest getAddAddressPage = GET_ADD_ADDRESS.getClone();
        getAddAddressPage.setIsShortLogResponse(true);

        try {
            getAddAddressPage.sendGetRequest(userSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document pageSource = getAddAddressPage.getResponse().getHTMLResponseDocument();
        return pageSource.html().split("ACC.config.CSRFToken = \"")[1].split("\"")[0];
    }
}

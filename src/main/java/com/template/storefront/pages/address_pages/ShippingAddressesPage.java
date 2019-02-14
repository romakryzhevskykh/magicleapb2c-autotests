package com.template.storefront.pages.address_pages;

import com.template.helpers.managers.addresses.AddressesManager;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.users.UserTitle;
import com.template.helpers.user_engine.UserSession;
import com.template.storefront.models.AddressBookEntry;
import com.template.storefront.page_blocks.AddressBookAddUpdateEntryBlock;
import com.template.storefront.pages.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.template.storefront.page_elements.address_page.AddressBookPageElements.ADDRESSES_INFO_ITEMS_TEXT_XPATH;
import static com.template.storefront.page_elements.address_page.AddressBookPageElements.ADDRESS_ITEMS_XPATH;
import static com.template.storefront.page_elements.address_page.AddressBookPageElements.ADD_ADDRESS_BUTTON_XPATH;
import static com.template.storefront.page_elements.address_page.AddressBookPageElements.SECTION_HEADER_XPATH;

@Component
public class ShippingAddressesPage extends StorefrontBasePage {
    @Autowired private AddressesManager addressesManager;
    @Autowired AddressBookAddUpdateEntryBlock addressBookAddUpdateEntryBlock;

    private final String pageUrlMethod = "powertools/en/USD/my-account/address-book";

    @Step("Get all shipping addresses on Shipping address book page.")
    public List<ShippingAddress> getShippingAddresses() {
        return $$(ADDRESS_ITEMS_XPATH).stream()
                .map(webElement -> {
                    List<String> addressParts = webElement.findElements(By.xpath(".//li")).stream().map(WebElement::getText).collect(Collectors.toList());


                    List<String> nameParts = Stream.of(addressParts.get(0)
                            .split(" "))
                            .map(String::trim)
                            .collect(Collectors.toList());
                    UserTitle userTitle = UserTitle.getUserTitleByTitleText(nameParts.get(0).trim());
                    String firstName = nameParts.get(1);
                    String lastName = nameParts.get(2);

                    //
                    int addressPartsSize = addressParts.size();
                    boolean hasPhone = addressParts.get(addressPartsSize - 1).replaceAll("[^0-9]", "").length() > 0;
                    boolean hasAddress2 = !(addressPartsSize <= 5);
                    //address part
                    String addressLine1 = addressParts.get(1).trim();
                    String addressLine2 = hasAddress2 ? addressParts.get(2).trim() : null;
                    String[] cityState = (hasAddress2 ? addressParts.get(3) : addressParts.get(2)).trim().split("[\\s\\u00A0]");
                    boolean isState = cityState.length > 1;
                    String state = isState ? cityState[cityState.length - 1].trim() : null;
                    String city = isState ? String.join(" ",Arrays.stream(cityState).filter(word -> !word.equalsIgnoreCase(state)).collect(Collectors.toList()))
                            : cityState[0];
                    String[] countryPostal = (hasAddress2 ? addressParts.get(4) : addressParts.get(3)).split("[\\s\\u00A0]");
                    String country, postalCode;
                    if (countryPostal.length > 2) {
                        StringJoiner joiner = new StringJoiner(" ");
                        for (int i = 0; i < countryPostal.length - 1; i++) {
                            joiner.add(countryPostal[i]);
                        }
                        country = joiner.toString();
                        postalCode = countryPostal[countryPostal.length - 1];
                    } else {
                        country = countryPostal[0];
                        postalCode = countryPostal[1];
                    }
                    String phone = hasPhone ? addressParts.get(addressPartsSize - 1) : null;
                    ShippingAddress shippingAddress =addressesManager.createShippingAddressInstance(userTitle, firstName, lastName, addressLine1, city, country, postalCode);
                    if (addressLine2 != null) {
                        shippingAddress.setAddressLine2(addressLine2);
                    }
                    if (hasPhone) {
                        shippingAddress.setPhoneNumber(phone);
                    }
                    if (isState) {
                        shippingAddress.setState(state);
                    }

                    return shippingAddress;
                }).collect(Collectors.toList());
    }












    @Step("Get text of header section on address book page.")
    public String getSectionHeader() {
        return $(SECTION_HEADER_XPATH).getText().trim();
    }

    @Step("Get all shipping addresses on address book page.")
    public ArrayList<AddressBookEntry> getAddressesList(UserSession userSession) {
        ArrayList<AddressBookEntry> userAddresses = new ArrayList<>();
        for (WebElement address : $$(By.xpath(ADDRESSES_INFO_ITEMS_TEXT_XPATH))) {
//            AddressBookEntry userAddress = addressBookEntriesManager.parseAddressFromHTML(address, userSession.getUser());
//            userAddresses.add(userAddress);
        }
        return userAddresses;
    }


    public void selectCountryFromDropDown(String countryName) {
        addressBookAddUpdateEntryBlock.selectCountryFromDropDown(countryName);
    }

    public void clickOnCountryDropDown() {
        addressBookAddUpdateEntryBlock.clickOnCountryDropDown();
    }

    public String getRandomCountryFromDropDown() {
        return addressBookAddUpdateEntryBlock.getRandomCountryFromDropDown();
    }

    public String getRandomTitleFromDropDown() {
        return addressBookAddUpdateEntryBlock.getRandomTitleFromDropDown();
    }

    public void selectTitleFromDropDown(String titleName) {
        addressBookAddUpdateEntryBlock.selectTitleFromDropDown(titleName);
    }

    public void clickOnTitleDropDown() {
        addressBookAddUpdateEntryBlock.clickOnTitleDropDown();
    }

    public void fillAddress1With(String address1) {
        addressBookAddUpdateEntryBlock.fillAddress1WithText(address1);
    }

    public void fillTownWith(String towm) {
        addressBookAddUpdateEntryBlock.fillTownWithText(towm);
    }

    public void fillPostCode(String postCode) {
        addressBookAddUpdateEntryBlock.fillPostCodeWithText(postCode);
    }

    public void clickOnSaveButton() {
        addressBookAddUpdateEntryBlock.clickOnSaveButton();
    }

    public boolean isAlertOnCreateNewAddress() {
        return addressBookAddUpdateEntryBlock.isAlert();
    }

    @Step("Click on Add Address button.")
    public void clickOnAddAddressButton() {
        $(ADD_ADDRESS_BUTTON_XPATH).click();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

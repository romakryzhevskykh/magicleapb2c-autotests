package com.template.storefront.pages.address_pages;

import com.template.helpers.managers.addresses.AddressesManager;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.users.User;
import com.template.helpers.models.users.UserTitle;
import com.template.storefront.pages.StorefrontBasePage;
import com.template.utils.SiteUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.template.helpers.managers.constants.ShippingAddressXSoupElements.DEFAULT_ADD;
import static com.template.storefront.page_elements.address_page.AddressBookPageElements.*;

@Component
public class ShippingAddressesPage extends StorefrontBasePage {

    @Autowired private AddressesManager addressesManager;

    private final String pageUrlMethod = "powertools/en/USD/my-account/address-book";

    @Step("Get all shipping addresses on Shipping address book page.")
    public List<ShippingAddress> getShippingAddresses() {
        return withTimeOutOf(10,TimeUnit.SECONDS).$$(ADDRESS_ITEMS_XPATH).stream()
                .map(webElement -> {
                    List<WebElement> elements = webElement.findElements(By.xpath(".//li"));

                    List<String> addressParts = elements.stream()
                            .map(webElement1 -> webElement1.getAttribute("innerHTML")).collect(Collectors.toList());
                    String unformattedNameParts = elements.get(0).findElement(By.xpath("./strong")).getAttribute("innerHTML");
                    String[] nameParts = SiteUtil.separateWordsByWhiteSpace(unformattedNameParts);

                    UserTitle title = UserTitle.getUserTitleByTitleText(nameParts[0].trim());
                    String firstName = nameParts[1].trim();
                    String lastName = nameParts[2].replace(DEFAULT_ADD, "").trim();
                    //
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
                    country = countryAndPostal[0].trim();
                    postalCode = countryAndPostal[1].trim();
                    String phone = hasPhone ? addressParts.get(addressPartsSize - 1) : null;
                    ShippingAddress shippingAddress = addressesManager.createShippingAddressInstance(title, firstName, lastName, addressLine1, city, country, postalCode);
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

    @Step("Get info flash message.")
    public String getFlashInfoMessage() {
        return $(FLASH_INFO_MESSAGE_XPATH).getText().trim();
    }


    @Step("Is Title displayed?")
    public boolean isTitleDisplayed() {
        return $(TITLE_XPATH).isDisplayed();
    }

    @Step("Get page title text.")
    public String getTitleText() {
        return $(TITLE_XPATH).getTextNode();
    }

    @Step("Is empty list message displayed?")
    public boolean isEmptyListMessageDisplayed() {
        return $(EMPTY_LIST_MESSAGE_XPATH).isDisplayed();
    }

    @Step("Get empty list message.")
    public String getEmptyListMessage() {
        return $(EMPTY_LIST_MESSAGE_XPATH).getText().trim();
    }

    @Step("Click on Delete button for Shipping address: {0}.")
    public void clickOnDeleteButtonForShippingAddress(User.UserShippingAddress userShippingAddress) {
        $(DELETE_ADDRESS_BUTTON_BY_ID_XPATH, userShippingAddress.getId()).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Set as default for {0}.")
    public void clickOnSetAsDefaultButton(User.UserShippingAddress userShippingAddress) {
        $(SET_AS_DEFAULT_BUTTON_BY_ID_XPATH, userShippingAddress.getId()).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Is Shipping address {0} default.")
    public boolean isShippingAddressDefault(User.UserShippingAddress userShippingAddress) {
        return !withTimeOutOf(5,TimeUnit.SECONDS).isPresent(SET_AS_DEFAULT_BUTTON_BY_ID_XPATH, userShippingAddress.getId());
    }

    @Step("Click on Edit button for {0}.")
    public void clickOnEditButton(User.UserShippingAddress userShippingAddress) {
        $(EDIT_ADDRESS_BUTTON_BY_ID_XPATH, userShippingAddress.getId()).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Add Shipping address button.")
    public void clickOnAddShippingAddressButton() {
        $(ADD_ADDRESS_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

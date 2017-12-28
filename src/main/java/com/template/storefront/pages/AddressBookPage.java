package com.template.storefront.pages;

import com.template.storefront.models.ShippingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.template.storefront.page_elements.AddressBookPageElements.ADDRESSES_INFO_ITEMS_TEXT_XPATH;
import static com.template.storefront.page_elements.AddressBookPageElements.SECTION_HEADER_XPATH;

@Component
public class AddressBookPage extends StorefrontBasePage {

    private final String pageUrlMethod = "powertools/en/USD/my-account/address-book";

    @Step("Get text of header section on Shipping address book page.")
    public String getSectionHeader() {
        return $(SECTION_HEADER_XPATH).getText().trim();
    }

    @Step("Get all shipping addresses on Shipping address book page.")
    public List<ShippingAddress> getShippingAddresses() {
        ArrayList<String> addressesText = new ArrayList<>();
        for (WebElement webElement : $$(By.xpath(ADDRESSES_INFO_ITEMS_TEXT_XPATH))) {
            addressesText.add(webElement.getText());
        }

        ArrayList<ShippingAddress> userAddresses = new ArrayList<>();
        for (String address : addressesText) {
            ShippingAddress userAddress = new ShippingAddress(address);
            userAddresses.add(userAddress);
        }
        return userAddresses;
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}

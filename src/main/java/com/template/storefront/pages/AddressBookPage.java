package com.template.storefront.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.template.storefront.models.TestProject;
import com.template.storefront.models.UserAddress;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.template.storefront.page_elements.AddressBookPageElements.ADDRESSES_INFO_ITEMS_TEXT_XPATH;
import static com.template.storefront.page_elements.AddressBookPageElements.SECTION_HEADER_XPATH;

@Component
public class AddressBookPage extends Page {

    @Autowired TestProject testProject;

    @Step("Get text of header section on Shipping address book page.")
    public String getSectionHeader() {
        return $(SECTION_HEADER_XPATH).getText().trim();
    }

    @Step("Get current page URL.")
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Get all shipping addresses on Shipping address book page.")
    public List<UserAddress> getShippingAddresses() {
        ArrayList<String> addressesText = new ArrayList<>();
        for (WebElement webElement : $$(By.xpath(ADDRESSES_INFO_ITEMS_TEXT_XPATH))) {
            addressesText.add(webElement.getText());
        }

        ArrayList<UserAddress> userAddresses = new ArrayList<>();
        for (String address : addressesText) {
            UserAddress userAddress = new UserAddress(address);
            userAddresses.add(userAddress);
        }
        return userAddresses;
    }

    @Step("Check that Shipping address book page is opened.")
    public boolean isOpened() {
        return driver.getCurrentUrl().equals(testProject.getShippingAddressBookUrl());
    }
}

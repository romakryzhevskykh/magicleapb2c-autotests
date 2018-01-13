package com.template.storefront.managers;

import com.template.storefront.models.AddressBookEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressBookEntriesManager {
    private ArrayList<AddressBookEntry> defaultAddresses = new ArrayList<>();
    private ArrayList<AddressBookEntry> testAddresses = new ArrayList<>();

    private void addTestAddress(AddressBookEntry addressBookEntry) {
        testAddresses.add(addressBookEntry);
    }

    public void addDefaultAddresses(ArrayList<AddressBookEntry> addressBookEntries) {
        defaultAddresses.addAll(addressBookEntries);
    }

    public ArrayList<AddressBookEntry> getTestAddresses() {
        return testAddresses;
    }

    public ArrayList<AddressBookEntry> getAllAddresses() {
        return new ArrayList<AddressBookEntry>() {{
            addAll(defaultAddresses);
            addAll(testAddresses);
        }};
    }

    public AddressBookEntry createInstance(AddressBookEntry.AddressBookEntryBuilder addressBookEntryBuilder) {
        if(addressBookEntryBuilder == null) {
            throw new IllegalStateException("AddressBookEntryBuilder is incorrect!");
        }
        AddressBookEntry newAddressBookEntry = addressBookEntryBuilder.build();
        if (newAddressBookEntry.getUserCredentials() != null)
            addTestAddress(newAddressBookEntry);
        return newAddressBookEntry;
    }

    public void deleteInstance(AddressBookEntry addressBookEntry) {
        if (testAddresses.contains(addressBookEntry)) {
            testAddresses.remove(addressBookEntry);
        } else if (defaultAddresses.contains(addressBookEntry)) {
            defaultAddresses.remove(addressBookEntry);
        }
    }

    private ArrayList<AddressBookEntry> getAllAddressesFromPage() {
        /**
         Create method based on API request to get all addresses from the page.
         **/
        return null;
    }

    private void createByApi(AddressBookEntry.AddressBookEntryBuilder addressBookEntryBuilder) {
        /**
         Create method based on API request to create address for user.
         **/
        createInstance(addressBookEntryBuilder);
    }

    private void deleteByApi(AddressBookEntry addressBookEntry) {
        /**
         Create method based on API request to remove address from the page.
         **/
        deleteInstance(addressBookEntry);
    }

    public AddressBookEntry parseAddressFromHTML(WebElement addressFromAddressBookPage) {
        List<WebElement> addressRows = addressFromAddressBookPage.findElements(By.xpath("li"));
        AddressBookEntry.AddressBookEntryBuilder addressBookEntryBuilder = null;
        if (addressRows.size() == 6) {
            addressBookEntryBuilder = new AddressBookEntry.AddressBookEntryBuilder(null)
                    .title(addressRows.get(0).getText().trim().split(" ")[0])
                    .firstName(addressRows.get(0).getText().trim().split(" ")[1])
                    .lastName(addressRows.get(0).getText().trim().split(" ")[2])
                    .addressLine1(addressRows.get(1).getText().trim())
                    .addressLine2(addressRows.get(2).getText().trim())
                    .town(addressRows.get(3).getText().trim().split(" ")[0])
                    .state(addressRows.get(3).getText().trim().split(" ").length > 1 ?
                            addressRows.get(3).getText().trim().split(" ")[1] : null)
                    .country(addressRows.get(4).getText().trim().split(" ")[0])
                    .postCode(addressRows.get(4).getText().trim().split(" ")[1])
                    .phoneNumber(addressRows.get(5).getText().trim());
        } else if (addressRows.size() == 5) {
            addressBookEntryBuilder = new AddressBookEntry.AddressBookEntryBuilder(null)
                    .title(addressRows.get(0).getText().trim().split(" ")[0])
                    .firstName(addressRows.get(0).getText().trim().split(" ")[1])
                    .lastName(addressRows.get(0).getText().trim().split(" ")[2])
                    .addressLine1(addressRows.get(1).getText().trim())
                    .town(addressRows.get(2).getText().trim().split(" ")[0])
                    .state(addressRows.get(2).getText().trim().split(" ").length > 1 ?
                            addressRows.get(2).getText().trim().split(" ")[1] : null)
                    .country(addressRows.get(3).getText().trim().split(" ")[0])
                    .postCode(addressRows.get(3).getText().trim().split(" ")[1])
                    .phoneNumber(addressRows.get(4).getText().trim().isEmpty() ?
                            addressRows.get(4).getText().trim() : null);
        }
        return createInstance(addressBookEntryBuilder);
    }
}

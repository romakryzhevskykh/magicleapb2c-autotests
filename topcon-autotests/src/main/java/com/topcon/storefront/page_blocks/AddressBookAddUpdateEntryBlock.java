package com.topcon.storefront.page_blocks;

import com.topcon.helpers.UIComponent;
import com.topcon.storefront.page_elements.AddressBookPageElements;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class AddressBookAddUpdateEntryBlock extends UIComponent {

    @Step("Click on Country drop-down")
    public void clickOnCountryDropDown() {
        $(By.id(AddressBookPageElements.COUNTRY_DROP_DOWN_ID)).click();
    }

    @Step("Get any Country from Country drop-down list")
    public String getRandomCountryFromDropDown() {
        return $$(AddressBookPageElements.COUNTRIES_IN_DROP_DOWN_XPATH).stream().findAny().get().getText();
    }

    @Step("Select Country from Country drop-down list")
    public void selectCountryFromDropDown(String countryName) {
        $(AddressBookPageElements.COUNTRY_IN_DROP_DOWN_BY_NAME_XPATH, countryName.toLowerCase()).click();
    }

    @Step("Click on Title drop-down")
    public void clickOnTitleDropDown() {
        $(By.id(AddressBookPageElements.TITLE_DROP_DOWN_ID)).click();
    }

    @Step("Get any Title from Title drop-down list")
    public String getRandomTitleFromDropDown() {
        return $$(AddressBookPageElements.TITLES_IN_DROP_DOWN_XPATH).stream().findAny().get().getText();
    }

    @Step("Select Title from Title drop-down list")
    public void selectTitleFromDropDown(String titleName) {
        $(AddressBookPageElements.TITLE_IN_DROP_DOWN_BY_NAME_XPATH, titleName.toLowerCase()).click();
    }

    @Step("Fill First name field with text.")
    public void fillFirstNameWithText(String firstName) {
        $(By.id(AddressBookPageElements.FIRST_NAME_FIELD_ID)).sendKeys(firstName);
    }

    @Step("Fill Last name field with text.")
    public void fillLastNameWithText(String lastName) {
        $(By.id(AddressBookPageElements.LAST_NAME_FIELD_ID)).sendKeys(lastName);
    }

    @Step("Fill Address 1 field with text.")
    public void fillAddress1WithText(String address1) {
        $(By.id(AddressBookPageElements.ADDRESS_LINE_1_FIELD_ID)).sendKeys(address1);
    }

    @Step("Fill TOWN field with text.")
    public void fillTownWithText(String townName) {
        $(By.id(AddressBookPageElements.TOWN_FIELD_ID)).sendKeys(townName);
    }

    @Step("Fill Post code field with text.")
    public void fillPostCodeWithText(String postCode) {
        $(By.id(AddressBookPageElements.POST_CODE_FIELD_ID)).sendKeys(postCode);
    }

    @Step("Is alert displayed.")
    public boolean isAlertDisplayed() {
        return isDisplayed(AddressBookPageElements.ALERT_ERROR_MESSAGE_XPATH);
    }

    @Step("Click on Save button.")
    public void clickOnSaveButton() {
        $(AddressBookPageElements.SAVE_ADDRESS_BUTTON_XPATH).click();
    }
}

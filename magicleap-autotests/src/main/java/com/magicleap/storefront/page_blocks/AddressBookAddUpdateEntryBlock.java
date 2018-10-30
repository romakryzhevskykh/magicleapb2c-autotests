package com.magicleap.storefront.page_blocks;

import com.magicleap.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.magicleap.storefront.page_elements.AddressBookPageElements.*;

@Component
public class AddressBookAddUpdateEntryBlock extends UIComponent {

    @Step("Click on Country drop-down")
    public void clickOnCountryDropDown() {
        $(By.id(COUNTRY_DROP_DOWN_ID)).click();
    }

    @Step("Get any Country from Country drop-down list")
    public String getRandomCountryFromDropDown() {
        return $$(COUNTRIES_IN_DROP_DOWN_XPATH).stream().findAny().get().getText();
    }

    @Step("Select Country from Country drop-down list")
    public void selectCountryFromDropDown(String countryName) {
        $(COUNTRY_IN_DROP_DOWN_BY_NAME_XPATH, countryName.toLowerCase()).click();
    }

    @Step("Click on Title drop-down")
    public void clickOnTitleDropDown() {
        $(By.id(TITLE_DROP_DOWN_ID)).click();
    }

    @Step("Get any Title from Title drop-down list")
    public String getRandomTitleFromDropDown() {
        return $$(TITLES_IN_DROP_DOWN_XPATH).stream().findAny().get().getText();
    }

    @Step("Select Title from Title drop-down list")
    public void selectTitleFromDropDown(String titleName) {
        $(TITLE_IN_DROP_DOWN_BY_NAME_XPATH, titleName.toLowerCase()).click();
    }

    @Step("Fill First name field with text.")
    public void fillFirstNameWithText(String firstName) {
        $(By.id(FIRST_NAME_FIELD_ID)).sendKeys(firstName);
    }

    @Step("Fill Last name field with text.")
    public void fillLastNameWithText(String lastName) {
        $(By.id(LAST_NAME_FIELD_ID)).sendKeys(lastName);
    }

    @Step("Fill Address 1 field with text.")
    public void fillAddress1WithText(String address1) {
        $(By.id(ADDRESS_LINE_1_FIELD_ID)).sendKeys(address1);
    }

    @Step("Fill TOWN field with text.")
    public void fillTownWithText(String townName) {
        $(By.id(TOWN_FIELD_ID)).sendKeys(townName);
    }

    @Step("Fill Post code field with text.")
    public void fillPostCodeWithText(String postCode) {
        $(By.id(POST_CODE_FIELD_ID)).sendKeys(postCode);
    }

    @Step("Is alert displayed.")
    public boolean isAlert() {
        return isDisplayed(ALERT_ERROR_MESSAGE_XPATH);
    }

    @Step("Click on Save button.")
    public void clickOnSaveButton() {
        $(SAVE_ADDRESS_BUTTON_XPATH).click();
    }
}

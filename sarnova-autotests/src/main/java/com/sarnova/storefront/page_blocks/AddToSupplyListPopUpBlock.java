package com.sarnova.storefront.page_blocks;

import com.google.common.collect.Iterables;
import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;

import static com.sarnova.storefront.page_block_elements.AddToSupplyLIstPopUpBlockElements.*;

@Component
public class AddToSupplyListPopUpBlock extends UIComponent {

    @Step("Get Add to Supply list pop-up's text content.")
    public String getAddToSupplyListPopUpContent() {
        return $(ADD_TO_SUPPLY_LIST_POP_UP_CONTENT_XPATH).getText().trim();
    }

    @Step("Select create new Supply list radio button in Add to Supply list pop-up.")
    public void clickOnCreateNewSupplyListInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_CREATE_NEW_SUPPLY_LIST_RADIO_BUTTON_XPATH);
    }

    @Step("Select select Supply list radio button in Add to Supply list pop-up.")
    public void clickOnSelectSupplyListInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_SELECT_SUPPLY_LIST_RADIO_BUTTON_XPATH);
    }

    @Step("Enter new Supply list name: {0} in Add to Supply list pop-up.")
    public void enterNewSupplyListNameText(String newSupplyListName) {
        enterText(newSupplyListName, By.id(ADD_TO_SUPPLY_LIST_POP_UP_NEW_SUPPLY_LIST_NAME_FIELD_ID));
    }

    @Step("Click on Add to Supply list button in Add to Supply list pop-up.")
    public void clickOnAddToSupplyListButtonInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_ADD_TO_SUPPLY_LIST_BUTTON_XPATH);
    }

    @Step("Click on View Supply list button in Add to Supply list pop-up.")
    public void clickOnViewSupplyListButtonInAddToSupplyListPopUp() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_VIEW_SUPPLY_LIST_BUTTON_XPATH);
    }

    @Step("Click on Select Your Supply list drop-down.")
    public void clickOnSelectExistingSupplyListDropDown() {
        click(By.id(ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_LISTS_DROP_DOWN_ID));
    }

    @Step("Select {0} Supply list from drop-down.")
    public void selectExistingSupplyListFromDropDownBySupplyListName(String existingSupplyListName) {
        click(ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_SUPPLY_LIST_IN_DROP_DOWN_BY_NAME_XPATH, existingSupplyListName);
    }

    @Step("Get name of any existing Supply list in the drop-down.")
    public String getAnyExistingSupplyListNameFromDropDown() {
        return $$(ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_SUPPLY_LISTS_IN_DROP_DOWN_XPATH)
                .stream()
                .map(webElement -> webElement.getText().trim())
                .findAny()
                .orElse(null);
    }

    @Step("Get supply list id.")
    public String getSupplyListId() {
        return Iterables.getLast(Arrays.asList($(ADD_TO_SUPPLY_LIST_POP_UP_VIEW_SUPPLY_LIST_BUTTON_XPATH).getAttribute("href").split("/")));
    }

    @Step("Wait images are loaded.")
    public void waitUntilProductImagesAreVisible() {
        if (isPresent(SUPPLY_POP_UP_IMAGES_XPATH)) {
            loadingProductImages();
        }
    }

    @Step("Loading products images.")
    private void loadingProductImages() {
        $$(SUPPLY_POP_UP_IMAGES_XPATH).forEach(webElement ->
                waitUntil(driver1 -> (webElement.getSize().getHeight() >= 20
                        && webElement.getSize().getWidth() >= 20))
        );
    }

    @Step("Wait banner image is loaded.")
    public void waitUntilBannerImageIsVisible() {
        if (isBannerPresent()) {
            loadingBannerImage();
        }
    }

    @Step("Loading banner image.")
    private void loadingBannerImage() {
        waitUntil(driver1 -> ($(SUPPLY_POP_UP_BANNER_IMAGE_XPATH).getSize().getHeight() >= 20
                && $(SUPPLY_POP_UP_BANNER_IMAGE_XPATH).getSize().getWidth() >= 20));
    }

    @Step("Is banner present.")
    public boolean isBannerPresent() {
        return isPresent(SUPPLY_POP_UP_BANNER_IMAGE_XPATH);
    }

    @Step("Click on Continue button.")
    public void clickOnContinueButton() {
        click(ADD_TO_SUPPLY_LIST_POP_UP_CONTINUE_BUTTON_XPATH);
    }
}

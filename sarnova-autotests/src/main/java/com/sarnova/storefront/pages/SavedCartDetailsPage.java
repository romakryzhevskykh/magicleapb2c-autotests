package com.sarnova.storefront.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.SavedCartDetailsPageElements.*;

@Component
public class SavedCartDetailsPage extends StorefrontBasePage {
    private String methodPageUrl = "my-account/saved-carts/%s";

    @Step("Get page label text.")
    public String getPageLabel() {
        return $(PAGE_LABEL_XPATH).getText().trim();
    }

    public void open(String id) {
        getDriver().get(getPageUrl(id));
    }

    public boolean isOpened(String id) {
        return getCurrentUrl().equals(getPageUrl(id));
    }

    public String getPageUrl(String id) {
        return String.format(getPageUrl(), id);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + methodPageUrl;
    }

    @Step("Is label visible?")
    public boolean isLabelVisible() {
        return isDisplayed(PAGE_LABEL_XPATH);
    }

    @Step("Is Restore button visible?")
    public boolean isRestoreButtonVisible() {
        return isDisplayed(By.id(RESTORE_BUTTON_ID));
    }

    @Step("Is Edit button visible?")
    public boolean isEditButtonVisible() {
        return isDisplayed(EDIT_BUTTON_XPATH);
    }

    @Step("Is Delete cart button visible?")
    public boolean isDeleteCartButtonVisible() {
        return isDisplayed(DELETE_CART_BUTTON_XPATH);
    }

    @Step("Is Product rows visible?")
    public boolean isUnitsOfMeasureItemsVisible() {
        return isDisplayed(UOMS_ROWS_XPATH);
    }
}

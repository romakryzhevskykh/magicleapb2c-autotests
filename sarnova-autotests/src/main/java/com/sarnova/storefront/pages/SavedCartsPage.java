package com.sarnova.storefront.pages;

import com.sarnova.helpers.models.saved_carts.SavedCart;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.SavedCartsPageElements.*;

@Component
public class SavedCartsPage extends StorefrontBasePage implements DefaultHomePage {

    private String pageUrlMethod = "my-account/saved-carts";

    @Step("Is Saved carts title visible?")
    public boolean isSavedCartsTitleVisible() {
        return isDisplayed(HEADER_TITLE_XPATH) && $(HEADER_TITLE_XPATH).getText().trim().equals("Saved Carts");
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Get Saved carts ids.")
    public List<String> getSavedCartsIds() {
        return $$(SAVED_CARTS_IDS_XPATH).stream().map(webElement -> webElement.getText().trim()).collect(Collectors.toList());
    }

    @Step("Is Saved cart Restore button visible?")
    public boolean isSavedCartRestoreButtonVisible(SavedCart savedCart) {
        return isDisplayed(SAVED_CART_RESTORE_BUTTON_BY_ID_XPATH, savedCart.getId());
    }

    @Step("Is Saved cart Remove button visible?")
    public boolean isSavedCartRemoveButtonVisible(SavedCart savedCart) {
        return isDisplayed(SAVED_CART_REMOVE_BUTTON_BY_ID_XPATH, savedCart.getId());
    }
}

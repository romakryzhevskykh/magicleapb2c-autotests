package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_elements.SupplyListsPageElements.*;

@Component
public class SupplyListsPage extends StorefrontBasePage {
    @Autowired private SupplyListsManager supplyListsManager;

    private final String pageUrlMethod = "my-account/supply-lists";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Click on Show inactive entries checkbox.")
    public void clickOnShowInactiveEntriesCheckbox() {
        click(SHOW_INACTIVE_ENTRIES_CHECKBOX_XPATH);
        waitJQueryRequestsLoad();
    }

    @Step("Show inactive Supply lists.")
    public void showInactiveSupplyLists() {
        if (!areInactiveSupplyListsBlockVisible()) {
            clickOnShowInactiveEntriesCheckbox();
        }
    }

    @Step("Hide inactive Supply lists.")
    public void hideInactiveSupplyLists() {
        if (areInactiveSupplyListsBlockVisible()) {
            clickOnShowInactiveEntriesCheckbox();
        }
    }

    @Step("Check that inactive Supply lists are visible.")
    public boolean areInactiveSupplyListsBlockVisible() {
        return isDisplayed(INACTIVE_SUPPLY_LISTS_BLOCK_XPATH);
    }

    @Step("Get inactive Supply lists.")
    public List<String> getInactiveSupplyLists() {
        return $$(INACTIVE_SUPPLY_LISTS_NAMES_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Is active supply lists block visible?")
    public boolean isActiveSupplyListsVisible() {
        return isDisplayed(ACTIVE_SUPPLY_LISTS_BLOCK_XPATH);
    }

    @Step("Get active Supply lists.")
    public List<String> getActiveSupplyLists() {
        return $$(ACTIVE_SUPPLY_LISTS_NAMES_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Is favorite checkbox present for {0}.")
    public boolean isFavoriteCheckboxPresentForSupplylist(SupplyList supplyList) {
        return isDisplayed(IS_FAVORITE_SUPPLY_LIST_CHECKBOX_BY_ID_XPATH, supplyList.getId());
    }

    @Step("Mark {0} as favorite.")
    public void markAsFavorite(SupplyList supplyList) {
        if (!isFavorite(supplyList)) {
            clickOnFavoriteCheckbox(supplyList);
            supplyList.setFavorite(true);
        }
    }

    @Step("Unmark {0} as favorite.")
    public void unmarkAsFavorite(SupplyList supplyList) {
        if (isFavorite(supplyList)) {
            clickOnFavoriteCheckbox(supplyList);
            supplyList.setFavorite(false);
        }
    }

    @Step("Click on favorite checkbox {0}.")
    private void clickOnFavoriteCheckbox(SupplyList supplyList) {
        click(IS_FAVORITE_SUPPLY_LIST_CHECKBOX_BY_ID_XPATH, supplyList.getId());
        waitJQueryRequestsLoad();
    }

    @Step("Is {0} favorite?")
    private boolean isFavorite(SupplyList supplyList) {
        return $(IS_FAVORITE_SUPPLY_LIST_CHECKBOX_BY_ID_XPATH, supplyList.getId()).isSelected();
    }

    @Step("Click on Deactivate {0}.")
    public void deactivateSupplyList(SupplyList supplyList) {
        click(DEACTIVATE_SUPPLY_LIST_BUTTON_BY_ID_XPATH, supplyList.getId());
        clickOnDeactivateButtonInDeleteSLPopUp();
        supplyList.setActive(false);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Is Deactivate button for {0} visible?")
    public boolean isDeactivateButtonVisibleForSupplyList(SupplyList supplyList) {
        return isDisplayed(DEACTIVATE_SUPPLY_LIST_BUTTON_BY_ID_XPATH, supplyList.getId());
    }

    @Step("Click on Activate {0}.")
    public void activateSupplyList(SupplyList supplyList) {
        click(ACTIVATE_SUPPLY_LIST_BUTTON_BY_ID_XPATH, supplyList.getId());
        supplyList.setActive(true);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Deactivate button in Delete pop-up.")
    public void clickOnDeactivateButtonInDeleteSLPopUp() {
        click(DEACTIVATE_SUPPLY_LIST_POP_UP_DEACTIVATE_BUTTON_XPATH);
    }
}

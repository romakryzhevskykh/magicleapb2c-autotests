package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.SupplyListsManager;
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

    private final String pageUrlMethod = "/boundtree/en/USD/my-account/supply-lists";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(pageUrlMethod);
    }

    @Step("Click on Show inactive entries checkbox.")
    public void clickOnShowInactiveEntriesCheckbox() {
        click(SHOW_INACTIVE_ENTRIES_CHECKBOX_XPATH);
    }

    @Step("Show inactive Supply lists.")
    public void showInactiveSupplyLists() {
        if(!areInactiveSupplyListsBlockVisible()) {
            clickOnShowInactiveEntriesCheckbox();
        }
    }

    @Step("Hide inactive Supply lists.")
    public void hideInactiveSupplyLists() {
        if(areInactiveSupplyListsBlockVisible()) {
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

    @Step("Get active Supply lists.")
    public List<String> getActiveSupplyLists() {
        return $$(ACTIVE_SUPPLY_LISTS_NAMES_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.user_engine.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.sarnova.storefront.page_elements.SupplyListDetailsPageElements.*;

@Component
public class SupplyListDetailsPage extends StorefrontBasePage {
    @Autowired private SupplyListsManager supplyListsManager;
    private final String pageUrlMethod = "boundtree/en/USD/my-account/supply-lists/%s";

    @Step("Get Supply list name from Supply list details page.")
    public String getSupplyListName() {
        return $(By.id(SUPPLY_LIST_NAME_ID)).getText().trim();
    }

    @Step("Get Supply list active status.")
    public String getSupplyListActiveStatus() {
        return $(SUPPLY_LIST_ACTIVE_STATUS_XPATH).getText().trim();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().startsWith(String.format(getPageUrl(), ""));
    }

    public String getPageUrlForProduct(SupplyList supplyList) {
        return null;
    }

    @Step("Get Supply list from page.")
    public SupplyList getSupplyListFromPage(User user) {
        String supplyListName = getSupplyListName();
        String supplyListActiveStatus = getSupplyListActiveStatus();
        List<WebElement> supplyProductsRowsElements = $$(SUPPLY_PRODUCTS_ROWS_XPATH);
        return supplyListsManager.parseSupplyListFromHTMLSupplyListDetailsPage(user, supplyListName,
                supplyListActiveStatus, supplyProductsRowsElements);
    }
}

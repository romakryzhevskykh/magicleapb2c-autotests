package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.user_engine.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

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

    @Step("Get Supply list id value.")
    public String getSupplyListIdValue() {
        return $(SUPPLY_LIST_ID_VALUE_XPATH).getText().trim();
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
        String id = getSupplyListIdValue();
        String supplyListActiveStatus = getSupplyListActiveStatus();
        List<Document> supplyProductsRowsHTMLs = $$(SUPPLY_PRODUCTS_ROWS_XPATH)
                .stream()
                .map(webElement -> Jsoup.parse(webElement.getAttribute("innerHTML")))
                .collect(Collectors.toList());
        return supplyListsManager.parseSupplyListFromHTMLSupplyListDetailsPage(user, supplyListName, id,
                supplyListActiveStatus, supplyProductsRowsHTMLs);
    }
}

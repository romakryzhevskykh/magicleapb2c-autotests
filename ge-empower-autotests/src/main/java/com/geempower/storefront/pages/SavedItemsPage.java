package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.SavedItemsPageElements.*;


@Component
public class SavedItemsPage extends StorefrontBasePage {
    private final String pageUri = "savedLists";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get All Items title")
    public String getAllItemsTitle() {
        return $(ALL_ITEMS_TITLE_XPATH).getText();
    }

//    public String getActiveCartTableTitle() {
//
//    }
}

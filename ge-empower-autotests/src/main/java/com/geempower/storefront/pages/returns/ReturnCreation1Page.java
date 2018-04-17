package com.geempower.storefront.pages.returns;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.Keys;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.returns.ReturnsCreation1PageElements.*;


@Component
public class ReturnCreation1Page extends StorefrontBasePage {

    private final String pageUri = "returnRequest";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    @Step("Return Creation 1 page Is Opened.")
    public boolean returnCreation1pageIsOpened() {
        return isDisplayed(IDENTIFY_PRODUCTS_PAGE_ACTIVE_TITLE_XPATH);
    }

    @Step("Search All PO No in the Search field.")
    public void searchAllPoNo() {
        click(SEARCH_FIELD_XPATH);
        $(SEARCH_FIELD_XPATH).sendKeys(Keys.ENTER);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Select first Invoice No. in table")
    public long selectFirstInvoiceNo() {
        waitUntilPageIsFullyLoaded();
        click(FIRST_INVOICE_NO_IN_TABLE_XPATH);
        waitUntilPageIsFullyLoaded();
        return Long.parseLong($(FIRST_ACTIVE_INVOICE_NO_IN_TABLE_XPATH).getText());
    }

    @Step("Select first product in table")
    public String selectFirstProduct() {
        waitUntilPageIsFullyLoaded();
        click(FIRST_CHECKBOX_IN_TABLE_XPATH);
        return $(FIRST_ACTIVE_CATALOGUE_NO_IN_TABLE_XPATH ).getText();
    }

    @Step("Click on Top Next button")
    public void clickOnNextButton() {
        waitUntilPageIsFullyLoaded();
        click(TOP_NEXT_BUTTON_XPATH);
    }

    @Step("Get Catalog No.")
    public String getCatalogueNo() {
        waitUntilPageIsFullyLoaded();
        return $(FIRST_ACTIVE_CATALOGUE_NO_IN_TABLE_XPATH).getText();
    }
}
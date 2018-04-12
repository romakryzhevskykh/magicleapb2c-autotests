package com.geempower.storefront.pages.returnsPages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.Keys;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.returnsCreationPageElements.ReturnsCreation1PageElements.*;


@Component
public class ReturnCreation1Page extends StorefrontBasePage {

    private final String pageUri = "returnTracking";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }


    @Step("Return Creation 1 page Is Displayed.")
    public boolean returnCreation1pageIsDisplayed() {
        return isDisplayed(IDENTIFY_PRODUCTS_PAGE_ACTIVE_TITLE_XPATH);
    }

    @Step("Search All PO No in the Search field.")
    public void searchAllPoNo() {
        click(SEARCH_FIELD_XPATH);
        $(SEARCH_FIELD_XPATH).sendKeys(Keys.ENTER);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Select First Invoice No. in table")
    public void selectFirstInvoiceNo() {
        waitUntilPageIsFullyLoaded();
        click(FIRST_INVOICE_NO_IN_TABLE_XPATH);
    }

    @Step("Get Invoice No.")
    public String getInvoiceNo() {
        return $(FIRST_ACTIVE_INVOICE_NO_IN_TABLE_XPATH).getText();
    }

    @Step("Select first product in table")
    public void selectFirstProduct() {
        waitUntilPageIsFullyLoaded();
        click(FIRST_CHECKBOX_IN_TABLE_XPATH);
    }

    @Step("Click on Top Next button")
    public void clickOnNextButton() {
        waitUntilPageIsFullyLoaded();
        click(TOP_NEXT_BUTTON_XPATH);
    }

    @Step("Get Catalogue No.")
    public String getCatalogueNo() {
        return $(FIRST_ACTIVE_CATALOGUE_NO_IN_TABLE_XPATH).getText();
    }
}

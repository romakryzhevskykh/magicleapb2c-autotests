package com.geempower.storefront.pages.product;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.geempower.storefront.page_elements.product.ProductsSearchPageElements.*;

@Component
public class ProductSearchPage extends StorefrontBasePage {

    private final String pageUri = "product/search?onlyOneProduct=false&product";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

    @Step("Get Search Result Title.")
    public String getSearchResultTitle() {
        return $(SEARCH_RESULT_TITLE_XPATH).getText();
    }

    @Step("Verify Alternate Column")
    public boolean verifyAlternateColumn() {
       return isDisplayed(ALTERNATE_CAT_NO_XPATH);
    }

    @Step("Click On Product Link On The Search Result Page.")
    public void clickOnProductLinkOnTheSearchResultPage(String product) {
        click(PRODUCT_LINK_ON_PRODUCT_SEARCH_PAGE_XPATH, product);
    }

    @Step("Click On All Product Checkbox On Product Search Page.")
    public void clickOnAllProductCheckboxOnProductSearchPage() {
        click(ALL_PRODUCTS_CHECKBOX_ON_PRODUCT_SEARCH_PAGE_XPATH);
    }

    @Step("Click On Save To List Button On Product Search Page.")
    public void clickOnSaveToListButtonOnProductSearchPage() {
        click(SAVE_TO_LIST_BUTTON_ON_PRODUCT_SEARCH_PAGE_XPATH);
    }

    @Step("Is Save To List Pop Up Displayed.")
    public boolean isSaveToListPopUpDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(SAVE_TO_LIST_POP_UP_ON_PRODUCT_SEARCH_PAGE_XPATH);
    }

    @Step("Set List Name To The New List Field.")
    public void setListNameToTheNewListField() {
        String uniquePoNo = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(NEW_LIST_FIELD_IN_SAVE_LIST_POP_UP_XPATH).clear();
        $(NEW_LIST_FIELD_IN_SAVE_LIST_POP_UP_XPATH).sendKeys(uniquePoNo);
    }

    @Step("Click On Save Button In The Save To List PopUp.")
    public void clickOnSaveButtonInTheSaveToListPopUp() {
        $(SAVE_NEW_LIST_BUTTON_IN_SAVE_LIST_POP_UP_XPATH).click();
    }
}

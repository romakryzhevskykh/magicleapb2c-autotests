package com.geempower.storefront.pages.product;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

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
        return isDisplayed(SAVE_TO_LIST_POP_UP_ON_PRODUCT_SEARCH_PAGE_XPATH);
    }
}

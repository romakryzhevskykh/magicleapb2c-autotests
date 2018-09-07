package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import static com.sarnova.storefront.page_elements.PurchaseRequestPageElements.*;

@Component
public class PurchaseSummaryPage extends StorefrontBasePage {

    private String pageUrlMethod = "reports/purchase-summary";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step ("Is Quick Add Products Visible?")
    public boolean isQuickAddProductsVisible() {return isDisplayed(QUICK_ADD_PRODUCTS_CHECKBOX_ID); }

    @Step ("Is Quick Add Products Visible?")
    public void clickOnAddProductCheckBox() { click(QUICK_ADD_PRODUCTS_CHECKBOX_ID); }

    @Step ("Is product search Visible?")
    public boolean isProductSearchIdVisible() {return isDisplayed(PRODUCT_SEARCH_ID); }

    @Step ("Is item quantity container Visible?")
    public boolean isQuantityContainerXpathVisible() {return isDisplayed(QUANTITY_CONTAINER_XPATH); }

    @Step ("Is field to enter product by SKU in Quick Add Product is Visible?")
    public boolean isFieldAddProductsBySkuInQuickAddProductVisible() {return isDisplayed(ADD_PRODUCTS_BY_SKU_FIELD_IN_QUICK_ADD_PRODUCTS_XPATH); }

    @Step ("Is Clear search button Visible?")
    public boolean isClearSearchButtonVisible() {return isDisplayed(CLEAR_SEARCH_BUTTON_XPATH); }

    @Step ("Is Reject Order Button Visible?")
    public boolean isRejectOrderButtonVisible() {return isDisplayed(REJECT_ORDER_BUTTON_XPATH); }

    @Step ("Is Forward Order Button Visible?")
    public boolean isForwardOrderButtonVisible() {return isDisplayed(FORWARD_ORDER_BUTTON_XPATH); }


}

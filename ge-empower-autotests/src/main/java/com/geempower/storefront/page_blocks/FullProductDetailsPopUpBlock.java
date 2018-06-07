package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.FullProductDetailsPopUpBlockElements.*;


public class FullProductDetailsPopUpBlock extends UIComponent {

    @Step("Product Details pop-up on Price and Availability page is displayed.")
    public boolean productDetailPopUpOnPApageIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(PRODUCT_DETAILS_POP_UP_XPATH);
    }

    @Step("Click on product details tab.")
    public void clickOnProductDetailsTab() {
        click(PRODUCT_DETAILS_TAB_IN_DETAILED_POP_XPATH);
    }

    @Step("Get Claimback message below Pricing Details title field.")
    public String getClaimbackMessageBelowPricingDetailsTitleField() {
        waitUntilPageIsFullyLoaded();
        return $(CLAIMBACK_MESSAGE_BELOW_PRICING_DETAILS_TITLE_XPATH).getText();
    }

    @Step("Close Product Details pop-up.")
    public void closeProductsDetailPopUp() {
        click(CLOSE_BUTTON_IN_PRODUCT_DETAILS_TAB_XPATH);
    }
}

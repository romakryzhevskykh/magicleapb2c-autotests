package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.FullProductDetailsPopUpBlockElements.*;

@Component
public class FullProductDetailsPopUpBlock extends UIComponent {

    @Step("is Product Details pop-up on Price and Availability page displayed.")
    public boolean isProductDetailPopUpOnPApageDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(PRODUCT_DETAILS_POP_UP_XPATH);
    }

    @Step("Click on product details tab.")
    public void clickOnProductDetailsTab() {
        click(PRODUCT_DETAILS_TAB_IN_DETAILED_POP_XPATH);
    }

    @Step("Click on availability details tab.")
    public void clickOnAvailabilityDetailsTab() {
        click(AVAILABILITY_DETAILS_TAB_IN_DETAILED_POP_XPATH);
    }

    @Step("Get Claimback message below Pricing Details title field.")
    public String getClaimbackMessageBelowPricingDetailsTitleField() {
        waitUntilPageIsFullyLoaded();
        return $(CLAIMBACK_MESSAGE_BELOW_PRICING_DETAILS_TITLE_XPATH).getText();
    }

    @Step("Close Full Product Details pop-up.")
    public void closeFullProductsDetailPopUp() {
        click(CLOSE_BUTTON_IN_PRODUCT_DETAILS_TAB_XPATH);
    }

    @Step("Is Active Specification Tab Selected.")
    public boolean isActiveSpecificationTabSelected() {
        return isDisplayed(ACTIVE_SPECIFICATION_TAB_XPATH);
    }

    @Step("Is Active Product Details Tab Selected.")
    public boolean isActiveProductDetailsTabSelected() {
        return isDisplayed(ACTIVE_PRODUCT_DETAILS_TAB_XPATH);
    }

    @Step("Is Active Availability Details Tab Selected.")
    public boolean isActiveAvailabilityDetailsTabSelected() {
        return isDisplayed(ACTIVE_AVAILABILITY_PRODUCT_DETAILS_TAB_XPATH);
    }
}

package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.ShortProductDetailsPopUpBlockElements.*;

@Component
public class ShortProductDetailsPopUpBlock extends UIComponent {

    @Step("Is Short Product Details pop-up displayed.")
    public boolean isShortProductDetailPopUpDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(SHORT_PRODUCT_DETAILS_POP_UP_XPATH);
    }

    @Step("Get Claimback message below Pricing Details title field.")
    public String getClaimbackMessageBelowPricingDetailsTitleField() {
        waitUntilPageIsFullyLoaded();
        return $(CLAIMBACK_MESSAGE_BELOW_PRICING_DETAILS_TITLE_XPATH).getText();
    }

    @Step("Close Short Products Detail PopUp")
    public void closeShortProductsDetailPopUp() {
        click(CLOSE_BUTTON_IN_PRODUCT_DETAILS_TAB_XPATH);
    }
}

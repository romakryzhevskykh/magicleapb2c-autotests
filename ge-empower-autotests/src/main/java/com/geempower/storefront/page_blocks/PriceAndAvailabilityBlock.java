package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.PriceAndAvailabilityBlockElements.*;

@Component
public class PriceAndAvailabilityBlock extends UIComponent {

    @Step("Click on Check P&A button")
    public void clickOnCheckPAButton() {
        click(CHECK_PRICE_AND_AVAILABILITY_BUTTON_ID);
    }
}


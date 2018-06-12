package com.sarnova.pay_fabric.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.pay_fabric.page_block_elements.LeftBarBlockElements.*;

@Component
public class PayFabricLeftBarBlock extends UIComponent {

    @Step("Is Left bar menu visible?")
    public boolean isVisible() {
        return isDisplayedInFrame("portalFrame", LEFT_BAR_MENU_XPATH);
    }

    @Step("Is Wallets item selected?")
    public boolean isWalletsItemSelected() {
        return isSelectedInFrame("portalFrame", WALLETS_ITEM_XPATH);
    }

    @Step("Is Daily activity item selected?")
    public boolean isDailyActivityItemSelected() {
        return isSelectedInFrame("portalFrame", DAILY_ACTIVITY_ITEM_XPATH);
    }

    @Step("Click on Customer Wallets item.")
    public void clickOnCustomerWalletsItem() {
        clickInFrame("portalFrame", WALLETS_ITEM_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Daily Activity item.")
    public void clickOnDailyActivityItem() {
        clickInFrame("portalFrame", DAILY_ACTIVITY_ITEM_XPATH);
        waitUntilPageIsFullyLoaded();
    }
}

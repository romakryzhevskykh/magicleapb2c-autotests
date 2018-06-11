package com.sarnova.pay_fabric.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.pay_fabric.page_block_elements.LeftBarBlockElements.*;

@Component
public class LeftBarBlock extends UIComponent {

    @Step("Is Left bar menu visible?")
    public boolean isVisible() {
        return isDisplayed(LEFT_BAR_MENU_XPATH);
    }

    @Step("Is Wallets item selected?")
    public boolean isWalletsItemSelected() {
        return $(WALLETS_ITEM_XPATH).isSelected();
    }

    @Step("Click on Customer Wallets item.")
    public void clickOnCustomerWalletsItem() {
        click(WALLETS_ITEM_XPATH);
        waitUntilPageIsFullyLoaded();
    }
}

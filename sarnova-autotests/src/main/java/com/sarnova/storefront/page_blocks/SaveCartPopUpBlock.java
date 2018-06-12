package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.SaveCartPopUpBlockElements.*;

@Component
public class SaveCartPopUpBlock extends UIComponent {

    @Step("Is Save Cart pop-up opened?")
    public boolean isOpened() {
        return isDisplayed(By.id(SAVE_CART_POP_UP_ID));
    }

    @Step("Is Save Cart name field visible?")
    public boolean isSaveCartNameFieldVisible() {
        return isDisplayed(By.id(SAVE_CART_NAME_FIELD_ID));
    }

    @Step("Is Save Cart description field visible?")
    public boolean isSaveCartDescriptionFieldVisible() {
        return isDisplayed(By.id(SAVE_CART_DESCRIPTION_FIELD_ID));
    }

    @Step("Is Save Cart button visible?")
    public boolean isSaveCartButtonVisible() {
        return isDisplayed(By.id(SAVE_CART_BUTTON_ID));
    }

    @Step("Is Cancel Save Cart button visible?")
    public boolean isCancelSaveCartButtonVisible() {
        return isDisplayed(By.id(CANCEL_SAVE_CART_BUTTON_ID));
    }
}

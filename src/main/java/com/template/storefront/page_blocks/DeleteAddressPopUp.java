package com.template.storefront.page_blocks;

import com.template.helpers.models.users.User;
import com.template.helpers.page.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_block_elements.DeleteAddressPopUpElements.CANCEL_BUTTON_BY_ID_XPATH;
import static com.template.storefront.page_block_elements.DeleteAddressPopUpElements.DELETE_BUTTON_BY_ID_XPATH;


@Component
public class DeleteAddressPopUp extends UIComponent {

    @Step("Click on Delete button.")
    public void clickOnDeleteButton(User.UserShippingAddress userShippingAddress) {
        $(DELETE_BUTTON_BY_ID_XPATH, userShippingAddress.getId()).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Cancel button.")
    public void clickOnCancelButton(User.UserShippingAddress userShippingAddress) {
        $(CANCEL_BUTTON_BY_ID_XPATH, userShippingAddress.getId()).click();
        waitUntilPageIsFullyLoaded();
    }
}

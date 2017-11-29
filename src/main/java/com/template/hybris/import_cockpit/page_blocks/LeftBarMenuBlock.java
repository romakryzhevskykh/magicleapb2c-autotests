package com.template.hybris.import_cockpit.page_blocks;

import com.template.helpers.BasePageObject;
import org.springframework.stereotype.Component;

import static com.template.hybris.import_cockpit.page_elements.LeftBarMenuElements.MENU_LABEL_ID;

@Component
public class LeftBarMenuBlock extends BasePageObject {

    public boolean isLoggedIn() {
        return isOpened();
    }

    private boolean isOpened() {
        return isDisplayed($(MENU_LABEL_ID));
    }
}

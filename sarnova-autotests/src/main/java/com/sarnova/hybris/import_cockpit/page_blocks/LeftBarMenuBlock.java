package com.sarnova.hybris.import_cockpit.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.springframework.stereotype.Component;

import static com.sarnova.hybris.import_cockpit.page_elements.LeftBarMenuElements.MENU_LABEL_ID;

@Component
public class LeftBarMenuBlock extends UIComponent {

    public boolean isLoggedIn() {
        return isOpened();
    }

    public boolean isOpened() {
        return isDisplayed(MENU_LABEL_ID);
    }
}

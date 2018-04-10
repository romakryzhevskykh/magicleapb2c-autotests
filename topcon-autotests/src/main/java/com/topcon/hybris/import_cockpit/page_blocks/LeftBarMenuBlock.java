package com.topcon.hybris.import_cockpit.page_blocks;

import com.topcon.helpers.UIComponent;
import org.springframework.stereotype.Component;

import static com.topcon.hybris.import_cockpit.page_elements.LeftBarMenuElements.MENU_LABEL_ID;

@Component
public class LeftBarMenuBlock extends UIComponent {

    public boolean isLoggedIn() {
        return isOpened();
    }

    private boolean isOpened() {
        return isDisplayed(MENU_LABEL_ID);
    }
}

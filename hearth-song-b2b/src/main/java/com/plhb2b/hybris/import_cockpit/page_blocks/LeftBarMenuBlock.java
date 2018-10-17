package com.plhb2b.hybris.import_cockpit.page_blocks;

import com.plhb2b.helpers.UIComponent;
import org.springframework.stereotype.Component;

import static com.plhb2b.hybris.import_cockpit.page_elements.LeftBarMenuElements.MENU_LABEL_ID;

@Component
public class LeftBarMenuBlock extends UIComponent {

    public boolean isLoggedIn() {
        return isOpened();
    }

    private boolean isOpened() {
        return isDisplayed(MENU_LABEL_ID);
    }
}

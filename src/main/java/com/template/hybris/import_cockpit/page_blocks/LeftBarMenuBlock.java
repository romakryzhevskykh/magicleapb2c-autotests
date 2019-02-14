package com.template.hybris.import_cockpit.page_blocks;

import com.template.helpers.page.UIComponent;
import org.springframework.stereotype.Component;

import static com.template.hybris.import_cockpit.page_elements.LeftBarMenuElements.MENU_LABEL_ID;

@Component
public class LeftBarMenuBlock extends UIComponent {

    public boolean isLoggedIn() {
        return isOpened();
    }

    private boolean isOpened() {
        return $(MENU_LABEL_ID).isDisplayed();
    }
}

package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.springframework.stereotype.Component;

import static com.geempower.storefront.page_block_elements.HeaderBlockElements.*;

@Component
public class HeaderBlock extends UIComponent {

    public boolean isUserLoggedIn(){
        return isDisplayed(PROFILE_DROPDOWN_XPATH);
    }
}

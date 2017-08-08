package com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.navigation_north_area;

import com.template.helpers.webengine.Browser;
import com.template.helpers.webengine.Element;

class Menu {
    private Element LOGOUT_BUTTON = new Element("Logout button", null);

    private static Menu menu;
    private Browser browser;

    private Menu(Browser browser) {
        this.browser = browser;
    }

    static Menu getInstance(Browser browser) {
        if(menu == null) {
            menu = new Menu(browser);
        }
        return menu;
    }

    void logout() {
        browser.click(LOGOUT_BUTTON);
    }
}

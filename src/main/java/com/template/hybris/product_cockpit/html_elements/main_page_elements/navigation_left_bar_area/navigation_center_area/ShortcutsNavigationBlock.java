package com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.navigation_center_area;

import com.template.helpers.webengine.Browser;
import com.template.helpers.webengine.Element;

class ShortcutsNavigationBlock {
    private final Element ALL_PRODUCTS_ITEM = new Element("All products navigation item", null);
    private final Element BLACKLIST_PRODUCTS_ITEM = new Element("Blacklist products navigation item", null);
    private final Element QUICKCOLLECTION_ITEM = new Element("Quickcollection navigation item", null);

    private static ShortcutsNavigationBlock shortcutsNavigationBlock;

    private Browser browser;

    private ShortcutsNavigationBlock(Browser browser) {
        this.browser = browser;
    }

    public static ShortcutsNavigationBlock getInstance(Browser browser) {
        if(shortcutsNavigationBlock == null) {
            shortcutsNavigationBlock = new ShortcutsNavigationBlock(browser);
        }
        return shortcutsNavigationBlock;
    }

    public void navigateToAllProducts() {
        browser.click(ALL_PRODUCTS_ITEM);
    }

    public void navigateToBlacklist() {
        browser.click(BLACKLIST_PRODUCTS_ITEM);
    }

    public void navigateToQuickcollection() {
        browser.click(QUICKCOLLECTION_ITEM);
    }
}

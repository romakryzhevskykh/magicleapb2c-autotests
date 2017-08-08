package com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.navigation_center_area;

import com.template.helpers.webengine.Browser;

public class NavigationCenterArea {
    private static NavigationCenterArea navigationCenterArea;

    private ShortcutsNavigationBlock shortcutsNavigationBlock;
    private CatalogNavigationBlock catalogNavigationBlock;

    private Browser browser;

    private NavigationCenterArea(Browser browser) {
        this.browser = browser;
        this.shortcutsNavigationBlock = ShortcutsNavigationBlock.getInstance(browser);
        this.catalogNavigationBlock = CatalogNavigationBlock.getInstance(browser);
    }

    public NavigationCenterArea getInstance(Browser browser) {
        if(navigationCenterArea == null) {
            navigationCenterArea = new NavigationCenterArea(browser);
        }
        return navigationCenterArea;
    }

}

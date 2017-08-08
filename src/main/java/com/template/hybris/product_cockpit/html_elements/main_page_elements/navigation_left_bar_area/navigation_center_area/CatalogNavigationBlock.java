package com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.navigation_center_area;

import com.template.helpers.webengine.Browser;

class CatalogNavigationBlock {
    private static CatalogNavigationBlock catalogNavigationBlock;

    private Browser browser;

    private CatalogNavigationBlock(Browser browser) {
        this.browser = browser;
    }

    public static CatalogNavigationBlock getInstance(Browser browser) {
        if (catalogNavigationBlock == null) {
            catalogNavigationBlock = new CatalogNavigationBlock(browser);
        }
        return catalogNavigationBlock;
    }
}

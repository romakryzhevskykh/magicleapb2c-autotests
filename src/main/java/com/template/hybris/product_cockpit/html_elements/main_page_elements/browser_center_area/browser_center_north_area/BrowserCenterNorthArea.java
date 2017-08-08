package com.template.hybris.product_cockpit.html_elements.main_page_elements.browser_center_area.browser_center_north_area;

import com.template.helpers.webengine.Browser;

public class BrowserCenterNorthArea {
    private static BrowserCenterNorthArea browserCenterNorthArea;

    private Browser browser;

    private BrowserCenterNorthArea(Browser browser) {
        this.browser = browser;
    }

    public static BrowserCenterNorthArea getInstance(Browser browser) {
        if (browserCenterNorthArea == null) {
            browserCenterNorthArea = new BrowserCenterNorthArea(browser);
        }
        return browserCenterNorthArea;
    }
}


package com.template.hybris.product_cockpit.html_elements.main_page_elements.browser_center_area.browser_center_center_area;

import com.template.helpers.webengine.Browser;

public class BrowserCenterCenterArea {
    private static BrowserCenterCenterArea browserCenterCenterArea;

    private Browser browser;

    private BrowserCenterCenterArea(Browser browser) {
        this.browser = browser;
    }

    public static BrowserCenterCenterArea getInstance(Browser browser) {
        if (browserCenterCenterArea == null) {
            browserCenterCenterArea = new BrowserCenterCenterArea(browser);
        }
        return browserCenterCenterArea;
    }
}


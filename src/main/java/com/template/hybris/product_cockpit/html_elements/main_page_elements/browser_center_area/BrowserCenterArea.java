package com.template.hybris.product_cockpit.html_elements.main_page_elements.browser_center_area;

import com.template.helpers.webengine.Browser;
import com.template.hybris.product_cockpit.html_elements.main_page_elements.browser_center_area.browser_center_center_area.BrowserCenterCenterArea;
import com.template.hybris.product_cockpit.html_elements.main_page_elements.browser_center_area.browser_center_north_area.BrowserCenterNorthArea;
import com.template.hybris.product_cockpit.html_elements.main_page_elements.browser_center_area.browser_center_south_area.BrowserCenterSouthArea;

public class BrowserCenterArea {
    private static BrowserCenterArea browserCenterArea;

    private BrowserCenterNorthArea browserCenterNorthArea;
    private BrowserCenterCenterArea browserCenterCenterArea;
    private BrowserCenterSouthArea browserCenterSouthArea;

    private Browser browser;

    private BrowserCenterArea(Browser browser) {
        this.browser = browser;
        this.browserCenterNorthArea = BrowserCenterNorthArea.getInstance(browser);
        this.browserCenterCenterArea = BrowserCenterCenterArea.getInstance(browser);
    }

    public static BrowserCenterArea getInstance(Browser browser) {
        if(browserCenterArea == null) {
            browserCenterArea = new BrowserCenterArea(browser);
        }
        return browserCenterArea;
    }
}

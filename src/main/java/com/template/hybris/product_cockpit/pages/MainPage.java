package com.template.hybris.product_cockpit.pages;

import com.template.helpers.webengine.Browser;
import com.template.hybris.product_cockpit.html_elements.main_page_elements.browser_center_area.BrowserCenterArea;
import com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.NavigationLeftBarArea;

public class MainPage {
    private static MainPage mainPage;

    private NavigationLeftBarArea leftBarMenu;
    private BrowserCenterArea browserCenterArea;

    private Browser browser;

    public static MainPage getInstance(Browser browser) {
        if(mainPage == null) {
            mainPage = new MainPage(browser);
        }
        return mainPage;
    }

    private MainPage(Browser browser) {
        this.browser = browser;
        this.leftBarMenu = NavigationLeftBarArea.getInstance(browser);
        this.browserCenterArea = BrowserCenterArea.getInstance(browser);
    }
}

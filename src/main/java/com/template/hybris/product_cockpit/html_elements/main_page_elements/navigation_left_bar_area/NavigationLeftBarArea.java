package com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area;

import com.template.helpers.webengine.Browser;
import com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.navigation_north_area.NavigationNorthArea;

public class NavigationLeftBarArea {
    private static NavigationLeftBarArea navigationLeftBarArea;

    private NavigationNorthArea navigationNorthArea;
    private Browser browser;

    private NavigationLeftBarArea(Browser browser) {
        this.browser = browser;
        this.navigationNorthArea = NavigationNorthArea.getInstance(browser);
    }

    public static NavigationLeftBarArea getInstance(Browser browser) {
        if(navigationLeftBarArea == null) {
            navigationLeftBarArea = new NavigationLeftBarArea(browser);
        }
        return navigationLeftBarArea;
    }

    public void logout() {
        navigationNorthArea.logout();
    }

}

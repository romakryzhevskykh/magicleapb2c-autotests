package com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.navigation_north_area;

import com.template.helpers.webengine.Browser;
import com.template.helpers.webengine.Element;

public class NavigationNorthArea {
    private final Element MENU = new Element("Menu options dropdown", null);

    private static NavigationNorthArea navigationNorthArea;

    private PerspectiveChooser perspectiveChooser;
    private Menu menu;
    private Browser browser;

    private NavigationNorthArea(Browser browser) {
        this.browser = browser;
        this.perspectiveChooser = PerspectiveChooser.getInstance(browser);
    }

    public static NavigationNorthArea getInstance(Browser browser) {
        if(navigationNorthArea == null) {
            navigationNorthArea = new NavigationNorthArea(browser);
        }
        return navigationNorthArea;
    }

    public void navigateToCatalog() {
        perspectiveChooser.chooseCatalog();
    }

    public void navigateToProduct() {
        perspectiveChooser.chooseProduct();
    }

    public void logout() {
        openMenu();
        menu.logout();
    }

    private void openMenu() {
        //open dropdown
        browser.click(MENU);
        this.menu = Menu.getInstance(browser);
    }

}

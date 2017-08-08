package com.template.hybris.product_cockpit.html_elements.main_page_elements.navigation_left_bar_area.navigation_north_area;

import com.template.helpers.webengine.Browser;
import com.template.helpers.webengine.Element;

class PerspectiveChooser {
    private final Element PRODUCT_CHOOSER = new Element("Product chooser item", null);
    private final Element CATALOG_CHOOSER = new Element("Catalog chooser", null);

    private static PerspectiveChooser perspectiveChooser;

    private Browser browser;

    private PerspectiveChooser(Browser browser) {
        this.browser = browser;
    }

    static PerspectiveChooser getInstance(Browser browser) {
        if (perspectiveChooser == null) {
            perspectiveChooser = new PerspectiveChooser(browser);
        }
        return perspectiveChooser;
    }

    void chooseProduct() {
        browser.click(PRODUCT_CHOOSER);
    }

    void chooseCatalog() {
        browser.click(CATALOG_CHOOSER);
    }
}

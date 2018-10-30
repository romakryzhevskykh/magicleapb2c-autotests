package com.magicleap.helpers;

import org.springframework.stereotype.Component;

@Component
public class GeneralPageActivities extends UIComponent {

    public void refreshPage() {
        getDriver().navigate().refresh();
        waitUntilPageIsFullyLoaded();
    }
}

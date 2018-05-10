package com.geempower.helpers;

import com.geempower.helpers.web_engine.WebDriverSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class Utils {
    @Autowired
    private WebDriverSessions webDriverPool;

    @Step("Refresh the page.")
    public void refreshCurrentPage() {
        webDriverPool.getActiveDriver().navigate().refresh();
    }

    @Step("Focus on browser.")
    public void focusOnActiveBrowser() {
        webDriverPool.getActiveDriver().switchTo().window(webDriverPool.getActiveDriver().getWindowHandle());
    }

}

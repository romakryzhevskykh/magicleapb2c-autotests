package com.template.helpers;

import com.template.helpers.page.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Set;

@Component
public class GeneralPageActivities extends UIComponent {

    @Step("Refresh page.")
    public void refreshPage() {
        getDriver().navigate().refresh();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Switch to the latest window with closing the others.")
    public void switchToTheLatestWindowWithClosingTheOthers() {
        Set<String> windowHandles = getDriver().getWindowHandles();
        String latestHandle = windowHandles.stream().reduce((f, s) -> s).orElse(null);
        for (String handle : windowHandles) {
            if (!handle.equals(latestHandle)) {
                getDriver().switchTo().window(handle);
                getDriver().close();
            }
        }
        getDriver().switchTo().window(latestHandle);
    }
}

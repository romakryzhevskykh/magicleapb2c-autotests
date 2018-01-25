package com.sarnova.cucumber.runners;

import com.sarnova.helpers.ThreadVarsHashMap;
import com.sarnova.helpers.web_engine.WebDriverSessions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Attachment;

public class CucumberHooks {
    @Autowired WebDriverSessions webDriverPool;
    @Autowired ThreadVarsHashMap threadVarsHashMap;

    @After
    public void onFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            captureScreenshot();
        }
    }

    @After
    public void clearThreadVars() {
        threadVarsHashMap.clear();
    }

    @Attachment("Screenshot")
    private byte[] captureScreenshot() {
        return ((TakesScreenshot) webDriverPool.getActiveDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

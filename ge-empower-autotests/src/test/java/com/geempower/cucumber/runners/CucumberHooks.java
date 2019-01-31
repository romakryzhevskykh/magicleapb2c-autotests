package com.geempower.cucumber.runners;

import com.geempower.helpers.ThreadVarsHashMap;
import com.geempower.helpers.web_engine.WebDriverSessions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Attachment;

public class CucumberHooks {
    @Autowired WebDriverSessions webDriverPool;
    @Autowired ThreadVarsHashMap threadVarsHashMap;

    @Before("@Skip")
    public void skipScenario(Scenario scenario) {
        System.out.println("Skipped scenario: " + scenario.getName());
        Assume.assumeTrue("Skipped", false);
    }

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

package com.template.cucumber.runners;

import com.template.helpers.WebDriverIstansiator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Attachment;

public class CucumberHooks {
    @Autowired WebDriverIstansiator webDriverPool;

    @After
    public void onFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            captureScreenshot();
        }
    }

    @Attachment("Screenshot")
    private byte[] captureScreenshot() {
        return ((TakesScreenshot) webDriverPool.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

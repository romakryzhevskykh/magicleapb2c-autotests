package com.template.cucumber.runners;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Attachment;

public class CucumberHooks {
    @Autowired WebDriver driver;

    @After
    public void onFailure(Scenario scenario) {
        System.out.println(driver);
        if (scenario.isFailed()) {
            captureScreenshot();
        }
    }

    @Attachment("Screenshot")
    private byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

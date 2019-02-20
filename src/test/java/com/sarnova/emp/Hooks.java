package com.sarnova.emp;

import com.sarnova.emp.config.ContextConfig;
import io.qameta.allure.Attachment;
import com.sarnova.emp.framework.FrameworkConfiguration;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.io.File;
import java.io.IOException;

@ContextConfiguration(classes = ContextConfig.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class Hooks {

    @Autowired
    private FrameworkConfiguration frameworkConfiguration;

    @Before
    public void setup() {
        Configuration.browser = frameworkConfiguration.getBrowserType();
        Configuration.startMaximized=true;
    }

    @After
    public void makeScreenshots(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
           scenario.write("Current URL is " + WebDriverRunner.getWebDriver().getCurrentUrl());
           screenshot();
        }
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        FileUtils.copyFile(screenshot, new File("build/allure-results/" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }
}

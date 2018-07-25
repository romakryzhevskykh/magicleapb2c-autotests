package com.geempower.helpers.web_engine;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSession {
    private WebDriver webDriver;
    private final int timeOut = 70;
    private final int shortTimeOut = 5;
    private boolean isActive = false;

    public WebDriverSession(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().window().fullscreen();
        this.webDriver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        this.changeImplicitWait(timeOut, TimeUnit.SECONDS);
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void restoreDefaultImplicitWait() {
        changeImplicitWait(timeOut, TimeUnit.SECONDS);
    }

    public void setShortImplicitWait() {
        changeImplicitWait(shortTimeOut, TimeUnit.SECONDS);
    }

    public void setImplicitWait() {
        changeImplicitWait(timeOut, TimeUnit.SECONDS);
    }

    private void changeImplicitWait(int value, TimeUnit timeUnit) {
        webDriver.manage().timeouts().implicitlyWait(value, timeUnit);
    }

    public int getShortTimeOut() {
        return shortTimeOut;
    }

    public int getTimeOut() {
        return timeOut;
    }

    //only for WebDriverSessions usage
    public void dismiss() {
        webDriver.quit();
    }
}

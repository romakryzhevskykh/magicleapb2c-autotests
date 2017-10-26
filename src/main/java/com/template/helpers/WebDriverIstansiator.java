package com.template.helpers;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import ru.stqa.selenium.factory.ThreadLocalSingleWebDriverPool;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.URL;
import java.util.concurrent.TimeUnit;

@Component
public class WebDriverIstansiator {

    private InheritableThreadLocal<WebDriver> storefrontDriver = new InheritableThreadLocal<>();
    private WebDriverPool storefrontWebDriverPool = new ThreadLocalSingleWebDriverPool();

    public void setDriver(URL hubUrl, String browserName) {
        storefrontDriver.set(storefrontWebDriverPool.getDriver(hubUrl, browserName));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return storefrontDriver.get();
    }

}

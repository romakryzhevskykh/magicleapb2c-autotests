package com.template.storefront.pages;

import com.template.helpers.WebDriverIstansiator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public abstract class Page {

    @Autowired WebDriverIstansiator webDriverPool;


    @PostConstruct
    public void setUp() {
//        webDriverPool
    }

    protected void open(String url) {
        getDriver().get(url);
    }

    protected WebElement $(String xpath, String... args) {
        return getDriver().findElement(By.xpath(String.format(xpath, args)));
    }

    protected List<WebElement> $$(By by) {
        return getDriver().findElements(by);
    }

    protected WebElement $(By by) {
        return getDriver().findElement(by);
    }

    protected WebDriver getDriver() {
        return webDriverPool.getDriver();
    }
}

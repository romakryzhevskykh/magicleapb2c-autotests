package com.template.storefront.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public abstract class Page {

//    public static boolean isDriverSet = false;

    @Autowired
    WebDriver driver;

    @PostConstruct
    public void setUp() {
//        if (!isDriverSet) {
//            driver.manage().window().maximize();
//            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            isDriverSet = true;
//        }
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected WebElement $(String xpath, String... args) {
        return driver.findElement(By.xpath(String.format(xpath, args)));
    }

    protected List<WebElement> $$(By by) {
        return driver.findElements(by);
    }

    protected WebElement $(By by) {
        return driver.findElement(by);
    }
}

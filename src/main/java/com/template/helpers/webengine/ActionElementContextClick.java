package com.template.helpers.webengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionElementContextClick implements IElementAction{
    WebDriver driver;
    public ActionElementContextClick(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void perform(WebElement element) {
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
    }
}

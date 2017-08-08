package com.template.helpers.webengine;

import org.openqa.selenium.WebElement;

public class ActionElementClick implements IElementAction {

    public void perform(WebElement element){
        element.click();
    }
}

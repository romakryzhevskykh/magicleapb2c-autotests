package com.template.storefront.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.template.storefront.models.TemplateStorefront;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.StartPageElements.HELLO_SIGN_IN_LINK_XPATH;

@Component
public class StartPage extends StorefrontBasePage {

    @Autowired TemplateStorefront testProject;

    @Step("Open Start page using URL.")
    public void open() {
        open(testProject.getStartUrl());
    }

    @Step("Click on Hello, sign in button.")
    public void openLoginPage() {
        $(HELLO_SIGN_IN_LINK_XPATH).click();
    }
}

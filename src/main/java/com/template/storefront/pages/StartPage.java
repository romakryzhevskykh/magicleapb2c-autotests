package com.template.storefront.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.template.storefront.models.TestProject;

import static com.template.storefront.page_elements.StartPageElements.HELLO_SIGN_IN_LINK_XPATH;

@Component
public class StartPage extends Page {

    @Autowired TestProject testProject;

    public void open() {
        open(testProject.getStartUrl());
    }

    public void openLoginPage() {
        $(HELLO_SIGN_IN_LINK_XPATH).click();
    }
}

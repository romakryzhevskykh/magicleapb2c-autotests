package com.template.hybris.product_cockpit.html_elements.login_page_elements;

import com.template.helpers.webengine.Element;
import com.template.hybris.product_cockpit.HybrisProductCockpitProject;

public class LoginBlock {
    private HybrisProductCockpitProject hybrisProductCockpitProject;

    public LoginBlock(HybrisProductCockpitProject hybrisProductCockpitProject) {
        this.hybrisProductCockpitProject = hybrisProductCockpitProject;
    }

    private Element loginBlockElement = new Element("Login block element", "//form[@id='loginForm']");
    private Element login = new Element("Username login field", loginBlockElement.getXpath() + "//input[@name='j_username']");
    private Element password = new Element("Password login field", loginBlockElement.getXpath() + "//input[@name='j_password']");
    private Element submit = new Element("Submit login button", loginBlockElement.getXpath() + "//td[contains(@class, 'button') and .='Login']");

    public void logIn() {
        hybrisProductCockpitProject.getBrowser().enterText(login, hybrisProductCockpitProject.getHybrisProductCockpitSettings().getUsername());
        hybrisProductCockpitProject.getBrowser().enterText(password, hybrisProductCockpitProject.getHybrisProductCockpitSettings().getPassword());
        hybrisProductCockpitProject.getBrowser().click(submit);
    }
}

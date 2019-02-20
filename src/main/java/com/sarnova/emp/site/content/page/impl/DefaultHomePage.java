package com.sarnova.emp.site.content.page.impl;

import com.codeborne.selenide.SelenideElement;
import com.sarnova.emp.site.common.impl.AbstractBasePage;
import com.sarnova.emp.site.content.page.HomePage;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Component
public class DefaultHomePage extends AbstractBasePage implements HomePage {

    private SelenideElement homepageSection = $(".page-homepage");
    private SelenideElement warningMessage = $(".alert-info");

    @Override
    protected String getPageUrl() {
        return EMPTY;
    }

    @Override
    public SelenideElement getLoadableElement() {
        return homepageSection;
    }

    @Override
    public boolean isSuccessRegisterMessageDisplayed(String message) {
        return warningMessage.isDisplayed() && warningMessage.getText().contains(message);
    }
}

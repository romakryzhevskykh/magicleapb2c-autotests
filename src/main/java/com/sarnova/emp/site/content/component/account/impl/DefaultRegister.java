package com.sarnova.emp.site.content.component.account.impl;

import com.codeborne.selenide.SelenideElement;
import com.sarnova.emp.entity.CustomerDto;
import com.sarnova.emp.site.common.impl.AbstractStore;
import com.sarnova.emp.site.content.component.account.Register;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class DefaultRegister extends AbstractStore implements Register {
    @Override
    public void populateForm(CustomerDto customerDto) {

    }

    @Override
    public void clickRegisterButton() {

    }

    @Override
    public void checkTermsConditions() {

    }

    @Override
    public boolean isFirstNameErrorMessageDisplayed() {
        return false;
    }

    @Override
    public boolean isLastNameErrorMessageDisplayed() {
        return false;
    }

    @Override
    public boolean isEmailErrorMessageDisplayed() {
        return false;
    }

    @Override
    public boolean isEmailErrorMessageDisplayed(String message) {
        return false;
    }

    @Override
    public boolean isPasswordErrorMessageDisplayed() {
        return false;
    }

    @Override
    public boolean isConfirmPasswordErrorMessageDisplayed() {
        return false;
    }

    @Override
    public SelenideElement getLoadableElement() {
        return null;
    }
}

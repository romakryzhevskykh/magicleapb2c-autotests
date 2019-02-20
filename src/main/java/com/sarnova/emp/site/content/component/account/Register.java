package com.sarnova.emp.site.content.component.account;

import com.sarnova.emp.entity.CustomerDto;
import com.sarnova.emp.site.common.Store;

public interface Register extends Store {

    void populateForm(CustomerDto customerDto);

    void clickRegisterButton();

    void checkTermsConditions();

    boolean isFirstNameErrorMessageDisplayed();

    boolean isLastNameErrorMessageDisplayed();

    boolean isEmailErrorMessageDisplayed();

    boolean isEmailErrorMessageDisplayed(String message);

    boolean isPasswordErrorMessageDisplayed();

    boolean isConfirmPasswordErrorMessageDisplayed();

}

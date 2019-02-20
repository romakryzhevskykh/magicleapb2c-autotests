package com.sarnova.emp.site.content.component.account;

import com.sarnova.emp.site.common.Store;

public interface Login extends Store {

    Login enterEmail(String email);

    Login enterPassword(String password);

    Login clickLoginButton();

    boolean isErrorMessageDisplayed();

}

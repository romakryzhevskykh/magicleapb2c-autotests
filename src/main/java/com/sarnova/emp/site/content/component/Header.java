package com.sarnova.emp.site.content.component;

import com.sarnova.emp.site.common.Store;

public interface Header extends Store {

    boolean isCustomerLoggedIn();

    void clickLoginRegisterLink();

    void clickLogOutLink();
}

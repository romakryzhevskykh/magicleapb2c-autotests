package com.sarnova.emp.site.content.page.account;

import com.sarnova.emp.site.common.Page;
import com.sarnova.emp.site.content.component.account.Login;
import com.sarnova.emp.site.content.component.account.Register;

public interface LoginRegisterPage extends Page {

    Login getLoginComponent();

    Register getRegisterComponent();
}

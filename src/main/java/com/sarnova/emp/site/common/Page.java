package com.sarnova.emp.site.common;

import com.sarnova.emp.site.content.component.Header;

public interface Page extends Store {

    Header getHeader();

    void openPage();

    String getCurrentUrl();
}

package com.sarnova.emp.framework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FrameworkConfiguration {

    @Value("${browser.type}")
    private String browserType;

    @Value("${hac.test.environment.url}")
    private String hacUrl;

    @Value("${storefront.test.environment.url}")
    private String testEnvironment;

    public String getBrowserType() {
       return browserType;
    }

    public String getHacUrl() {
        return hacUrl;
    }

    public String getStoreBaseUrl(){
        return testEnvironment;
    }
}

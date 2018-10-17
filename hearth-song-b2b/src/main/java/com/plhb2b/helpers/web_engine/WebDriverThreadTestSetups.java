package com.plhb2b.helpers.web_engine;

import org.springframework.stereotype.Component;

@Component
public class WebDriverThreadTestSetups {

    private InheritableThreadLocal<WebDriverSetups> tlDriverSetups = new InheritableThreadLocal<>();

    public synchronized void setTlDriverSetups(WebDriverSetups webDriverSetups) {
        tlDriverSetups.set(webDriverSetups);
    }

    public synchronized WebDriverSetups getWebDriverSetups() {
        return tlDriverSetups.get();
    }
}

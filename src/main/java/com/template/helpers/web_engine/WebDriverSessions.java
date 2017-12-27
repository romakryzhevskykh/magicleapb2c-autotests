package com.template.helpers.web_engine;

import com.template.helpers.user_engine.UserRole;
import com.template.helpers.user_engine.UsersPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stqa.selenium.factory.LooseWebDriverPool;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.URL;
import java.util.HashMap;

@Component
public class WebDriverSessions {
    @Autowired UsersPool usersPool;
    @Autowired WebDriverThreadTestSetups webDriverThreadTestSetups;

    private InheritableThreadLocal<HashMap<UserRole, WebDriverSession>> tlDriversMap = new InheritableThreadLocal<>();

    private InheritableThreadLocal<WebDriverPool> tlWebDriverPool = new InheritableThreadLocal<WebDriverPool>();

    public synchronized void setDriver(URL hubUrl, String browserName, UserRole userRole) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        WebDriver webDriver;
        if (tlWebDriverPool.get() == null) {
            tlWebDriverPool.set(new LooseWebDriverPool());
            webDriver = tlWebDriverPool.get().getDriver(hubUrl, capabilities);
        } else
            webDriver = tlWebDriverPool.get().getDriver(hubUrl, capabilities);
        tlDriversMap.get().put(userRole, new WebDriverSession(webDriver));
    }

    public synchronized void setDriverActive(UserRole userRole) {
        if (tlDriversMap.get() == null) {
            tlDriversMap.set(new HashMap<>());
            setDriver(webDriverThreadTestSetups.getWebDriverSetups().getHubUrl(),
                    webDriverThreadTestSetups.getWebDriverSetups().getBrowserName(),
                    userRole);
            tlDriversMap.get().get(userRole).setActive(true);
            usersPool.setActiveUser(userRole);
        } else if (!usersPool.getActiveUser().getUserRole().equals(userRole)) {
            tlDriversMap.get().forEach((userRole1, webDriverSession) -> webDriverSession.setActive(false));
            if (tlDriversMap.get().get(userRole) == null)
                setDriver(webDriverThreadTestSetups.getWebDriverSetups().getHubUrl(),
                        webDriverThreadTestSetups.getWebDriverSetups().getBrowserName(),
                        userRole);
            tlDriversMap.get().get(userRole).setActive(true);
            usersPool.setActiveUser(userRole);
        }
    }

    public synchronized WebDriver getActiveDriver() {
        return tlDriversMap.get().values().stream().filter(WebDriverSession::isActive).map(WebDriverSession::getWebDriver).findAny().orElse(null);
    }

    public synchronized WebDriverSession getActiveDriverSession() {
        return tlDriversMap.get().values().stream().filter(WebDriverSession::isActive).findAny().orElse(null);
    }

    public void dismissAll() {
        tlDriversMap.get().values().forEach(WebDriverSession::dismiss);
        tlDriversMap.get().clear();
    }
}

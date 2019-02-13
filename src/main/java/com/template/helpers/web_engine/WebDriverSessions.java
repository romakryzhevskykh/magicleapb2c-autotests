package com.template.helpers.web_engine;

import com.template.helpers.managers.users.UsersManager;
import com.template.helpers.models.users.UserRole;
import com.template.helpers.user_engine.UserSessions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    @Autowired UserSessions userSessions;
    @Autowired WebDriverThreadTestSetups webDriverThreadTestSetups;
    @Autowired UsersManager usersManager;

    private InheritableThreadLocal<HashMap<UserRole, WebDriverSession>> tlDriversMap = new InheritableThreadLocal<>();

    private InheritableThreadLocal<WebDriverPool> tlWebDriverPool = new InheritableThreadLocal<>();

    public synchronized void setDriver(URL hubUrl, String browserName, boolean headless, UserRole userRole) {
        Capabilities capabilities;
        if (browserName.equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
            ((ChromeOptions) capabilities).setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            ((ChromeOptions) capabilities).setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            if (headless) {
                ((ChromeOptions) capabilities).addArguments("--headless");
                ((ChromeOptions) capabilities).addArguments("window-size=1920x1080");
            }
        } else {
            capabilities = new DesiredCapabilities();
            ((DesiredCapabilities) capabilities).setBrowserName(browserName);
        }
        WebDriver webDriver;
        if (tlWebDriverPool.get() == null) {
            tlWebDriverPool.set(new LooseWebDriverPool());
            webDriver = tlWebDriverPool.get().getDriver(hubUrl, capabilities);
        } else
            webDriver = tlWebDriverPool.get().getDriver(hubUrl, capabilities);
        tlDriversMap.get().put(userRole, new WebDriverSession(webDriver));
        webDriver.get(usersManager.getUsers()
                .stream()
                .filter(user -> user.getUserRoles().contains(userRole))
                .findFirst()
                .orElseGet(() -> {
                    throw new NullPointerException("No created users with this role: " + userRole.toString());
                })
                .getUserCockpit().getBaseUrl());
    }

    public synchronized void setDriverActive(UserRole userRole) {
        if (tlDriversMap.get() == null) {
            tlDriversMap.set(new HashMap<>());
            setDriver(webDriverThreadTestSetups.getWebDriverSetups().getHubUrl(),
                    webDriverThreadTestSetups.getWebDriverSetups().getBrowserName(),
                    webDriverThreadTestSetups.getWebDriverSetups().isHeadless(),
                    userRole);
            tlDriversMap.get().get(userRole).setActive(true);
            userSessions.setActiveUserSession(userRole);
        } else if (!userSessions.getActiveUserSession().getUserRoles().contains(userRole)
                || (!userRole.isTest() && userSessions.getActiveUserSession().getUserRoles().stream().anyMatch(UserRole::isTest))) {
            tlDriversMap.get().forEach((userRole1, webDriverSession) -> webDriverSession.setActive(false));
            if (tlDriversMap.get().get(userRole) == null)
                setDriver(webDriverThreadTestSetups.getWebDriverSetups().getHubUrl(),
                        webDriverThreadTestSetups.getWebDriverSetups().getBrowserName(),
                        webDriverThreadTestSetups.getWebDriverSetups().isHeadless(),
                        userRole);
            tlDriversMap.get().get(userRole).setActive(true);
            userSessions.setActiveUserSession(userRole);
        }
        userSessions.getActiveUserSession().setCookies(tlDriversMap.get().get(userRole).getWebDriver().manage().getCookies());
    }

    public synchronized WebDriver getActiveDriver() {
        return tlDriversMap.get().values().stream().filter(WebDriverSession::isActive).map(WebDriverSession::getWebDriver).findAny().orElse(null);
    }

    public synchronized WebDriverSession getActiveDriverSession() {
        return tlDriversMap.get().values().stream().filter(WebDriverSession::isActive).findAny().orElse(null);
    }

    public void dismissAll() {
        if (tlDriversMap.get() != null) {
            tlDriversMap.get().values().forEach(WebDriverSession::dismiss);
            tlDriversMap.get().clear();
        }
    }
}

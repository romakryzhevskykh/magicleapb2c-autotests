package com.geempower.helpers.managers;

import com.geempower.helpers.request_engine.GETRequest;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class QmsService {
    private GETRequest getQmsUserInfo = new GETRequest("GET USER INFO FROM QMS SERVICE BY SSO", "https://qa.geempower.com/gewebservices/rest/geb2bcustomers/%s");

    @Step("Get User Info from Qms service.")
    public String getQmsUserInfo(String sso){
        GETRequest userInfoRequest = getQmsUserInfo.getClone();
        userInfoRequest.setValue(sso);
        try {
            userInfoRequest.sendGetRequest();
        }
    }
}

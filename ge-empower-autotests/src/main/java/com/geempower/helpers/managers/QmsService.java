package com.geempower.helpers.managers;

import com.geempower.helpers.request_engine.GETRequest;
import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.HashMap;

@Component
public class QmsService {
    @Autowired
    private String qmsUser;
    @Autowired
    private String qmsPassword;

    private GETRequest getQmsUserInfo = new GETRequest("GET USER INFO FROM QMS SERVICE BY SSO", "https://qa.geempower.com/gewebservices/rest/geb2bcustomers/%s");

    @Step("Get User Info from Qms service.")
    public HashMap getQmsUserInfo(String sso) {
        GETRequest userInfoRequest = getQmsUserInfo.getClone();
        userInfoRequest.setValue(sso);
        try {
            userInfoRequest.sendGetRequest(qmsUser, qmsPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document doc = (Document) userInfoRequest.getResponse().getResponseBody();
        HashMap<String, String> qmsUserInfo = new HashMap<>();
        qmsUserInfo.put("email", doc.selectSingleNode("/UserProfile/Email").getText());
        qmsUserInfo.put("altEmail", doc.selectSingleNode("/UserProfile/AlternateEmail").getText());
        qmsUserInfo.put("company", doc.selectSingleNode("/UserProfile/Company").getText());
        qmsUserInfo.put("firstName", doc.selectSingleNode("/UserProfile/FirstName").getText());
        qmsUserInfo.put("lastName", doc.selectSingleNode("/UserProfile/LastName").getText());
        qmsUserInfo.put("isInternal", doc.selectSingleNode("/UserProfile/IsInternal").getText());
        qmsUserInfo.put("isInternalUser", doc.selectSingleNode("/UserProfile/IsInternalUser").getText());
        qmsUserInfo.put("language", doc.selectSingleNode("/UserProfile/Language").getText());
        qmsUserInfo.put("telephone", doc.selectSingleNode("/UserProfile/Telephone").getText());
        qmsUserInfo.put("region", doc.selectSingleNode("/UserProfile/Region").getText());
        qmsUserInfo.put("relationshipToGe", doc.selectSingleNode("/UserProfile/RelationshipToGe").getText());
        qmsUserInfo.put("sso", doc.selectSingleNode("/UserProfile/SSO").getText());
        qmsUserInfo.put("qmsEnabled", doc.selectSingleNode("/UserProfile/QMSEnabled").getText());
        qmsUserInfo.put("qualityPrice", doc.selectSingleNode("/UserProfile/QuotePriceAppealEnabled").getText());
        qmsUserInfo.put("tinderBoxNode", doc.selectSingleNode("/UserProfile/TinderboxEnabled").getText());
        return qmsUserInfo;
    }
}
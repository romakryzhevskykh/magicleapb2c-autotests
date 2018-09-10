package com.geempower.helpers.managers;

import com.geempower.helpers.request_engine.GETRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

@Component
public class LessonLyService {
    @Autowired
    private String lessonLyUser;
    @Autowired
    private String lessonLyPassword;

    private GETRequest getUserInfo = new GETRequest("GET USER INFO FROM LESSONLY BY EMAIL", "https://api.lessonly.com/api/v1/users");
    private GETRequest getDoNotEmailValueForUser = new GETRequest("GET DO NOT EMAIL VALUE FROM LESSONLY FOR USER", "https://api.lessonly.com/api/v1/users/%s");

    @Step("Get User id from lessonLy service.")
    public String getUserIdByEmailFromLessonLy(String email) {
        GETRequest userInfo = getUserInfo.getClone();
        userInfo.setGetParameterAndValue("filter[email]", email);
        try {
            userInfo.sendGetRequest(lessonLyUser, lessonLyPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray users = (JSONArray) userInfo.getResponse().getValueOf("users");
        JSONObject user = users.getJSONObject(0);
        return user.get("id").toString();
    }

    @Step("Get do_not_email value from lessonLy service.")
    public boolean getDoNotEmailValueForUserByUserId(String lessonlyUserId) {
        boolean doNotEmail = false;
        GETRequest doNotEmailRequest = getDoNotEmailValueForUser.getClone();
        doNotEmailRequest.setValue(lessonlyUserId);
        try {
            doNotEmailRequest.sendGetRequest(lessonLyUser, lessonLyPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray fieldsData = (JSONArray) doNotEmailRequest.getResponse().getValueOf("custom_user_field_data");
        for (int i = 0; i < fieldsData.length(); i++) {
            JSONObject fieldData = fieldsData.getJSONObject(i);
            if (fieldData.get("name").equals("do_not_email")) {
                doNotEmail = fieldData.getBoolean("value");
            }
        }
        return doNotEmail;
    }
}

package com.geempower.helpers.managers;

import com.geempower.helpers.models.LessonLy;
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

    private static LessonLy instance;

    public static synchronized LessonLy getInstance() {
        if (instance == null) {
            instance = new LessonLy();
        }
        return instance;
    }

    private GETRequest getUserInfo = new GETRequest("GET USER INFO FROM LESSONLY BY EMAIL", "https://api.lessonly.com/api/v1/users");
    private GETRequest getPersonalUserSettings = new GETRequest("GET PERSONAL USER SETTINGS", "https://api.lessonly.com/api/v1/users/%s");

    @Step("Get User id from lessonLy service.")
    public String getUserIdByEmailFromLessonLy(String email) {
        GETRequest userInfo = getUserInfo.getClone();
        userInfo.setGetParameterAndValue("filter[email]", email);
        try {
            userInfo.sendGetRequest(lessonLyUser, lessonLyPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray users = new JSONArray();
        try {
            users = (JSONArray) userInfo.getResponse().getValueOf("users");
        } catch (NullPointerException e) {
            System.err.println(userInfo.getResponse());
            e.printStackTrace();
        }
        JSONObject user = users.getJSONObject(0);
        return user.get("id").toString();
    }

    @Step("Get do_not_email value from lessonLy service.")
    public boolean getDoNotEmailValueForUserByUserId(String lessonlyUserId) {
        boolean doNotEmail = false;
        GETRequest doNotEmailRequest = getPersonalUserSettings.getClone();
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

    @Step("Get User Status In Lessonly Service.")
    public String getUserStatusInLessonlyService(String lessonlyUserId) {
        String userStatus = "";
        GETRequest userStatusRequest = getPersonalUserSettings.getClone();
        userStatusRequest.setValue(lessonlyUserId);
        try {
            userStatusRequest.sendGetRequest(lessonLyUser, lessonLyPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray fieldsData = (JSONArray) userStatusRequest.getResponse().getValueOf("custom_user_field_data");
        for (int i = 0; i < fieldsData.length(); i++) {
            JSONObject fieldData = fieldsData.getJSONObject(i);
            if (fieldData.get("name").equals("user_status")) {
                userStatus = fieldData.getString("value");
            }
        }
        return userStatus;
    }
}

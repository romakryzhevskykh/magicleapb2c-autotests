package com.geempower.helpers.managers;

import com.geempower.helpers.request_engine.GETRequest;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class StatusPageService {
    @Autowired
    private String statusPageToken;

    private GETRequest getStatusPage = new GETRequest("GET STATUS PAGE INFO FOR USER BY EMAIL.", "https://api.statuspage.io/v1/pages/r2gjt1g2kjfq/subscribers.json");

    @Step("Get response for user from StatusPage service.")
    public JSONArray getUserByEmailFromStatusPageService(String email) {
        GETRequest statusPage = getStatusPage.getClone();
        statusPage.setGetParameterAndValue("q", email);
        statusPage.setGetParameterAndValue("state", "all");
        statusPage.sendGetRequest(statusPageToken);
        return (JSONArray) statusPage.getResponse().getResponseBody();
    }

}

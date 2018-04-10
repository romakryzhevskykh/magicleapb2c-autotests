package com.topcon.helpers.request_engine;

import com.topcon.helpers.user_engine.UserSession;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;

public class GETRequest extends APIRequest {
    public GETRequest(String name, String address_method) {
        super(name, address_method);
    }

    @Override
    public GETRequest getClone() {
        return new GETRequest(name, getSystemAddress());
    }

    public void sendGetRequest(UserSession userSession, ArrayList<PostParameterAndValue> parametersAndValues) throws IOException {
        this.parametersAndValues = parametersAndValues;
        sendGetRequest(userSession);
    }

    public void sendGetRequest(UserSession userSession) throws IOException {
        generateRequestURL(userSession);
        try {
            System.out.println("*******");
            System.out.println("API: " + this.name);
            System.out.println("Sending 'GET' request to URL : " + requestURL.toString());
            connection = (HttpsURLConnection) requestURL.openConnection();
            connection.setRequestMethod("GET");
            //add request header
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            //add connection time out in milliseconds
            connection.setConnectTimeout(connectionTimeout);
            connection.setReadTimeout(connectionTimeout);

//            if (userSession.getUsername() != null && userSession.getPassword() != null) {
//                String userpass = userSession.getUsername() + ":" + userSession.getPassword();
//                String basicAuth = "Basic " + base64Format(userpass);
//                connection.setRequestProperty("Authorization", basicAuth);
//                System.out.println("Set Authorization: " + basicAuth);
//            }

            if (headers.size() > 0) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    System.out.println("Set request header: " + header);
                    connection.setRequestProperty(header.getKey(), header.getValue());
                }
            }

            if (userSession.getCookies() != null) {
                connection.setRequestProperty("Cookie", String.join("; ", userSession.getCookies()));
                System.out.println("Set cookie: " + String.join("; ", userSession.getCookies()));
            }

            this.response = new APIResponse(connection);
            this.response.setLogRequestShort(isShortLogResponse);
            this.response.setContentType();
            this.response.setResponseCode();
            this.response.setResponseBody();
        } catch (SocketTimeoutException exTimeout) {
            System.out.println("Timeout exception after: " + connectionTimeout + " seconds. No response!");
        } finally {
            System.out.println("*******");
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

package com.sarnova.helpers.request_engine;

import com.sarnova.helpers.user_engine.UserSession;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class POSTRequest extends APIRequest {
    private ArrayList<PostParameterAndValue> postParametersAndValues;

    public void addPostParameterAndValue(PostParameterAndValue parameterAndValue) {
        if (postParametersAndValues == null) {
            this.postParametersAndValues = new ArrayList<>();
            this.postParametersAndValues.add(parameterAndValue);
        } else
            this.postParametersAndValues.add(parameterAndValue);
    }

    public ArrayList<PostParameterAndValue> getPostParametersAndValues() {
        return postParametersAndValues;
    }

    public POSTRequest(String name, String address_method) {
        super(name, address_method);
    }

    @Override
    public POSTRequest getClone() {
        return new POSTRequest(name, getSystemAddress());
    }

    private void setFormDataPostParametersAndValues(ArrayList<PostParameterAndValue> postParametersAndValues) {
        if (postParametersAndValues != null) {
            this.postParametersAndValues = postParametersAndValues;
            for (PostParameterAndValue parameterAndValue : postParametersAndValues) {
                try {
                    this.stringOfPostParameters.append(parameterAndValue.parameter).append("=")
                            .append(URLEncoder.encode(parameterAndValue.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!postParametersAndValues
                        .get(postParametersAndValues.size() - 1)
                        .equals(parameterAndValue)) {
                    this.stringOfPostParameters.append(DELIMITER.AMPERSAND);
                }
            }
        }
    }

    private void setPayloadPostParametersAndValues(ArrayList<PostParameterAndValue> payloadParametersAndValues) {
        if (payloadParametersAndValues != null) {
            this.postParametersAndValues = payloadParametersAndValues;
            JSONObject jsonObject = new JSONObject();
            for (PostParameterAndValue parameterAndValue : payloadParametersAndValues) {
                jsonObject.put(parameterAndValue.parameter, parameterAndValue.value instanceof List ?
                        new JSONArray((List)parameterAndValue.value) : parameterAndValue.getValue());
            }
            this.stringOfPostParameters.append(jsonObject.toString());
        }
    }

    public void setPostString(String postString) {
        this.stringOfPostParameters.append(postString);
    }


    public void sendPostRequest(UserSession userSession) throws IOException {
        sendPostRequest(userSession, this.postParametersAndValues);
    }

    public void sendPostRequest(UserSession userSession, ArrayList<PostParameterAndValue> postParametersAndValues) throws IOException {
        //create url without post parameters
        generateRequestURL(userSession);
        //Create connection
        System.out.println("*******");
        System.out.println("API: " + this.name);
        System.out.println("Sending 'POST' request to URL : " + requestURL.toString());

        connection = (HttpsURLConnection) requestURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        if (headers.size() > 0) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                System.out.println("Set request header: " + header);
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
        }

        if (userSession.getCookies() != null) {
            connection.setRequestProperty("Cookie", String.join("; ", userSession.getCookies()));
            System.out.println("Set cookies: " + connection.getRequestProperty("Cookie"));
        }

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //create post data
        if (connection.getRequestProperty("Content-Type").contains("json")) {
            setPayloadPostParametersAndValues(postParametersAndValues);
        } else {
            setFormDataPostParametersAndValues(postParametersAndValues);
        }
        //Send request
        System.out.println("POST parameters: " + stringOfPostParameters);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(stringOfPostParameters.toString());
        wr.flush();
        wr.close();

        this.response = new APIResponse(connection);
        this.response.setContentType();
        this.response.setResponseCode();
        this.response.setResponseBody();

        System.out.println("*******");
        connection.disconnect();
    }
}

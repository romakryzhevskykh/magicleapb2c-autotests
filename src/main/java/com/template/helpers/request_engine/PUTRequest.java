package com.template.helpers.request_engine;

import com.template.helpers.user_engine.UserSession;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PUTRequest extends APIRequest {
    private ArrayList<PostParameterAndValue> postParametersAndValues;
    private PrintWriter postParametersWriter;
    private DataOutputStream outputStream;

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

    public PUTRequest(String name, String addressMethod) {
        super(name, addressMethod);
    }

    @Override
    public PUTRequest getClone() {
        return new PUTRequest(name, getSystemAddress());
    }

    private void setFormDataPostParametersAndValues(ArrayList<PostParameterAndValue> postParametersAndValues) {
        if (postParametersAndValues != null) {
            this.postParametersAndValues = postParametersAndValues;
            for (PostParameterAndValue parameterAndValue : postParametersAndValues) {
                try {
                    this.postParametersWriter.append(parameterAndValue.parameter).append("=")
                            .append(URLEncoder.encode(parameterAndValue.getValue(), CHARSET.toString()));
                    this.postParametersWriter.flush();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!postParametersAndValues
                        .get(postParametersAndValues.size() - 1)
                        .equals(parameterAndValue)) {
                    this.postParametersWriter.append(DELIMITER.AMPERSAND.delimiter).flush();
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
                        new JSONArray((List) parameterAndValue.value) : parameterAndValue.getValue());
            }
            this.postParametersWriter.append(jsonObject.toString()).flush();
        }
    }

    public void setPostString(String postString) {
        this.postParametersWriter.append(postString);
    }


    public void sendPutRequest(UserSession userSession) throws IOException {
        sendPutRequest(userSession, this.postParametersAndValues);
    }

    public void sendPutRequest(UserSession userSession, ArrayList<PostParameterAndValue> postParametersAndValues) throws IOException {
        //create url without post parameters
        generateRequestURL(userSession);
        //Create connection
        System.out.println("*******");
        System.out.println("API: " + this.name);
        System.out.println("Sending 'PUT' request to URL : " + requestURL.toString());

        connection = (HttpsURLConnection) requestURL.openConnection();
        connection.setRequestMethod("PUT");
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
        this.outputStream = new DataOutputStream(connection.getOutputStream());
        this.postParametersWriter = new PrintWriter(new OutputStreamWriter(outputStream, CHARSET), true);
        if (connection.getRequestProperty("Content-Type").contains("json")) {
            setPayloadPostParametersAndValues(postParametersAndValues);
        } else {
            setFormDataPostParametersAndValues(postParametersAndValues);
        }

        outputStream.flush();
        outputStream.close();
        postParametersWriter.close();

        this.response = new APIResponse(connection);
        this.response.setContentType();
        this.response.setResponseCode();
        this.response.setResponseBody();

        System.out.println("*******");
        connection.disconnect();
    }
}

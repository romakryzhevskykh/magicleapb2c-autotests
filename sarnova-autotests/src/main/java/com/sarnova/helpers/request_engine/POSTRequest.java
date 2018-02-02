package com.sarnova.helpers.request_engine;

import com.sarnova.helpers.user_engine.UserSession;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;


public class POSTRequest extends APIRequest {
    private   ArrayList<ParameterAndValue> postParametersAndValues;

    public void addPostParameterAndValue(ParameterAndValue parameterAndValue) {
        if(postParametersAndValues == null) {
            this.postParametersAndValues = new ArrayList<>();
            this.postParametersAndValues.add(parameterAndValue);
        } else
            this.postParametersAndValues.add(parameterAndValue);
    }

    public ArrayList<ParameterAndValue> getPostParametersAndValues() {
        return postParametersAndValues;
    }

    public POSTRequest(String name, String address_method) {
        super(name, address_method);
    }

    @Override
    public POSTRequest getClone() {
        return new POSTRequest(name, getSystemAddress());
    }

    public void setPostParametersAndValues(ArrayList<ParameterAndValue> postParametersAndValues) {
        if(postParametersAndValues != null) {
            this.postParametersAndValues = postParametersAndValues;
            this.stringOfPostParameters = "";
            for (ParameterAndValue parameterAndValue : postParametersAndValues) {
                try {
                    this.stringOfPostParameters += parameterAndValue.parameter +
                            "=" +
                            URLEncoder.encode(parameterAndValue.value, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!postParametersAndValues
                        .get(postParametersAndValues.size() - 1)
                        .equals(parameterAndValue)) {
                    this.stringOfPostParameters += "&";
                }
            }
        }
    }

    public void setPostString(String postString) {
        this.stringOfPostParameters = postString;
    }


    public void sendPostRequest(UserSession userSession) throws IOException {
        sendPostRequest(userSession, this.postParametersAndValues);
    }

    public void sendPostRequest(UserSession userSession, ArrayList<ParameterAndValue> postParametersAndValues) throws IOException {
        //create post string
        setPostParametersAndValues(postParametersAndValues);
        //create url without post parameters
        generateRequestURL(userSession);

        //Create connection
        System.out.println("*******");
        System.out.println("API: " + this.name);
        System.out.println("Sending 'POST' request to URL : " + requestURL.toString());

        connection = (HttpURLConnection) requestURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Language", "en-US");
        connection.setRequestProperty("Content-Length", "" +
                Integer.toString(stringOfPostParameters.getBytes().length));
        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        if(userSession.getUsername() != null && userSession.getPassword() != null){
            String userpass = userSession.getUsername() + ":" + userSession.getPassword();
            String basicAuth = "Basic " + base64Format(userpass);
            connection.setRequestProperty ("Authorization", basicAuth);
        }

        if (headers.size() > 0) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                System.out.println("Set request header: " + header);
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
        }

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        if (userSession.getCookies() != null)
            for (String cookie : userSession.getCookies()) {
                connection.setRequestProperty("Cookie", cookie);
                System.out.println("Set cookie: " + cookie);
            }

        //Send request
        System.out.println("POST parameters: " + stringOfPostParameters);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(stringOfPostParameters);
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

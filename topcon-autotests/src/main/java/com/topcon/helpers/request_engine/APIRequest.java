package com.topcon.helpers.request_engine;

import com.topcon.helpers.user_engine.UserSession;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class APIRequest implements API {

    static {
        SSLUtilities.trustAllHostnames();
//        SSLUtilities.trustAllHttpsCertificates();
//        SSLUtilities.trustAllTLSHttpsCertificates();
    }

    protected String name;
    protected String systemAddress;
    protected ArrayList<String> value = new ArrayList<>();
    protected int connectionTimeout = 25000;
    protected StringBuilder stringOfPostParameters = new StringBuilder();
    protected URL requestURL;
    //    protected HttpURLConnection connection = null;
    protected HttpURLConnection connection = null;
    protected APIResponse response;
    protected ArrayList<PostParameterAndValue> parametersAndValues;
    protected HashMap<String, String> headers = new HashMap<>();

    protected boolean isShortLogResponse = false;

    public APIRequest(String name, String address_method) {
        this.name = name;
        this.systemAddress = address_method;
        this.parametersAndValues = new ArrayList<>();
    }

    public <T> void setValue(T value) {
        this.value.add(String.valueOf(value));
    }

    public String getSystemAddress() {
        return value.isEmpty() ? systemAddress : String.format(systemAddress, value.toArray());
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setCookiesToUserSession(UserSession userSession) throws IOException {
        String urlParameters = "login=" + userSession.getUsername() + "&password=" + userSession.getPassword();
        boolean redirect = false;
        int status;
        System.out.println("Get logged in user cookies");
        HttpURLConnection connection;
        URL requestUrl = new URL(userSession.getUser().getUserCockpit().getLoginUrl());
        connection = (HttpURLConnection) requestUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setReadTimeout(10000);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Language", "en-US");
        connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
        connection.setRequestProperty("Host", userSession.getUser().getUserCockpit().getBaseUrl());
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);

        //Send request
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(urlParameters);

        status = connection.getResponseCode();

        if (status != HttpURLConnection.HTTP_OK) {
            if (status == HttpURLConnection.HTTP_MOVED_TEMP
                    || status == HttpURLConnection.HTTP_MOVED_PERM
                    || status == HttpURLConnection.HTTP_SEE_OTHER)
                redirect = true;
        }
        userSession.setCookies(connection.getHeaderFields().get("Set-Cookie"));
        if (redirect) {
            followRedirection(connection, userSession);
        }
        //this.connection.setRequestProperty("Cookie", cookies);
        wr.flush();
        wr.close();
        connection.disconnect();
    }

    public void followRedirection(HttpURLConnection connection, UserSession userSession) throws IOException {

        String newUrl = connection.getHeaderField("Location");

        try {
            connection = (HttpURLConnection) new URL(newUrl).openConnection();
        } catch (MalformedURLException e) {
            connection = (HttpURLConnection) new URL(userSession.getUser().getUserCockpit().getBaseUrl() + newUrl).openConnection();
        }
        connection.setRequestProperty("Cookie", String.join("; ", userSession.getCookies()));
        connection.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
        connection.addRequestProperty("User-Agent", "Mozilla");

        int status = connection.getResponseCode();
        if (connection.getHeaderFields().get("Set-Cookie") != null)
            userSession.setCookies(connection.getHeaderFields().get("Set-Cookie"));
        boolean redirect = status != HttpURLConnection.HTTP_OK && (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_SEE_OTHER);

        if (redirect)
            followRedirection(connection, userSession);
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public void setGetParameterAndValue(String parameter, String value, DELIMITER delimiter) {
        this.parametersAndValues.add(new PostParameterAndValue(parameter, value, delimiter));
    }

    public void setGetParameterAndValue(String parameter, String value) {
        this.parametersAndValues.add(new PostParameterAndValue(parameter, value));
    }

    public String getValueByParameter(String parameter) {
        for (PostParameterAndValue parameterAndValue : parametersAndValues) {
            if (parameterAndValue.contains(parameter)) {
                return parameterAndValue.getValue();
            }
        }
        return null;
    }

    protected void generateRequestURL(UserSession userSession) {
        String requestUrl = userSession.getUser().getUserCockpit().getBaseUrl() + getSystemAddress();
        String parametersWithSlashSeparator = "";
        String parametersWithAmpersandSeparator = "";
        for (PostParameterAndValue parameterAndValue : parametersAndValues)
            if (parameterAndValue.containsDelimiter(DELIMITER.FORWARD_SLASH))
                parametersWithSlashSeparator += parameterAndValue.delimiter
                        + parameterAndValue.parameter
                        + parameterAndValue.delimiter
                        + parameterAndValue.value;
            else if (parameterAndValue.containsDelimiter(DELIMITER.AMPERSAND))
                parametersWithAmpersandSeparator += (requestUrl.contains(DELIMITER.QUESTION_MARK.toString())
                        || parametersWithAmpersandSeparator.contains(DELIMITER.QUESTION_MARK.toString()))
                        ?
                        parameterAndValue.delimiter
                                + parameterAndValue.parameter
                                + DELIMITER.EQUALS_SIGN
                                + parameterAndValue.value
                        :
                        DELIMITER.QUESTION_MARK
                                + parameterAndValue.parameter
                                + DELIMITER.EQUALS_SIGN
                                + parameterAndValue.value;
        try {
            requestUrl = requestUrl.contains(DELIMITER.QUESTION_MARK.toString())
                    ?
                    new StringBuffer(requestUrl).insert(requestUrl.indexOf(DELIMITER.QUESTION_MARK.toString()), parametersWithSlashSeparator).toString()
                            + parametersWithAmpersandSeparator
                    :
                    requestUrl + parametersWithSlashSeparator + parametersWithAmpersandSeparator;
            requestUrl = requestUrl.replaceAll(" ", "%20");
            this.requestURL = new URL(requestUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("URL format is incorrect: " + requestUrl);
        }
    }

    public APIResponse getResponse() {
        return response;
    }

    public abstract Object getClone();

    public String getRequestURL(UserSession userSession) {
        generateRequestURL(userSession);
        return requestURL.toString();
    }

    public void setIsShortLogResponse(boolean isShortLogResponse) {
        this.isShortLogResponse = isShortLogResponse;
    }

    @Override
    public String toString() {
        return name + ": " + getSystemAddress();
    }

    String base64Format(String hash) {
        try {
            return java.util.Base64.getUrlEncoder().encodeToString(hash.getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Exception";
        }
    }
}


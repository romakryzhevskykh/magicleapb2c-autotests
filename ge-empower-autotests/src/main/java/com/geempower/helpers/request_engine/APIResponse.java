package com.geempower.helpers.request_engine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.*;

public class APIResponse implements API {
    HttpURLConnection connection;
    private String contentType;
    private int responseCode;
    private Object responseBody;

    private boolean isLogRequestShort = false;

    public APIResponse(HttpURLConnection connection) {
        this.connection = connection;
        this.responseBody = new Object();
    }

    public Object getResponseBody() {
        return responseBody;
    }

    @SuppressWarnings("unchecked")
    public <T> APIResponse(T response) {
        Object results = null;
        if (response != null && response instanceof HashMap) {
            results = new HashMap();
            ((HashMap) results).putAll((Map) response);
        } else if (response != null) {
            results = new HashMap();
            if (((T[]) response).length <= 1)
                for (T obj : (T[]) response) {
                    ((HashMap) results).putAll((Map) obj);
                    for (Object o : ((HashMap) results).entrySet()) {
                        Map.Entry thisEntry = (Map.Entry) o;
                        Object key = thisEntry.getKey();
                        Object value = thisEntry.getValue();
                        if (value instanceof Object[]) {
                            ArrayList newValue = new ArrayList<HashMap>();
                            Collections.addAll(newValue, (Object[]) value);
                            ((HashMap) results).replace(key, value, newValue);
                        }
                    }
                }
            else {
                results = new ArrayList<HashMap>();
                for (T obj : (T[]) response) {
                    HashMap resultPart = new HashMap();
                    resultPart.putAll((Map) obj);
                    for (Object o : resultPart.entrySet()) {
                        Map.Entry thisEntry = (Map.Entry) o;
                        Object key = thisEntry.getKey();
                        Object value = thisEntry.getValue();
                        if (value instanceof Object[]) {
                            ArrayList newValue = new ArrayList<HashMap>();
                            Collections.addAll(newValue, (Object[]) value);
                            resultPart.replace(key, value, newValue);
                        }
                    }
                    ((ArrayList<HashMap>) results).add(resultPart);
                }
            }
        }
        this.responseBody = results;
        System.out.println("XML-Rpc response : " + (this.responseBody == null ? "null" : this.responseBody.toString()));
    }

    public void setResponseCode() {
        try {
            this.responseCode = connection.getResponseCode();
            System.out.println("Response Code : " + responseCode);
        } catch (IOException e) {
            System.out.println("Response Code : " + responseCode);
        }
    }

    public void setResponseBody() {
        StringBuilder responseBody = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            responseBody = new StringBuilder();
            String inputLine;
            while ((inputLine = rd.readLine()) != null) {
                responseBody.append(inputLine);
                responseBody.append('\r');
            }
            rd.close();
        } catch (IOException ex) {
            System.out.println("Response Body : " + responseBody);
            System.out.println("[ERROR] " + ex.toString());
        }
        getResponseWithActualObjectType(responseBody != null ? responseBody.toString() : null);
    }

    public void setContentType() {
        this.contentType = connection.getContentType();
        System.out.println("Response type is " + this.contentType);
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Object getValueOf(String parameter) {
        if (responseBody instanceof JSONObject) {
            return ((JSONObject) responseBody).get(parameter);
        } else if (responseBody instanceof JSONArray) {
            for (int i = 0; i < ((JSONArray) responseBody).length(); i++) {
                if (((JSONArray) responseBody).getJSONObject(i).has(parameter))
                    return ((JSONArray) responseBody).getJSONObject(i).get(parameter);
            }
        }
        throw new UnknownFormatFlagsException("Response is not JSON format" + responseBody.toString());
    }

    public void getResponseWithActualObjectType(String RESPONSE_STRING) {
//        if(RESPONSE_STRING == null) {
//            return;
//        }
        if (RESPONSE_CONTENT_TYPES.JSON.contains(contentType))
            try {
                this.responseBody = new JSONObject(RESPONSE_STRING);
            } catch (JSONException ex) {
                try {
                    this.responseBody = new JSONArray(RESPONSE_STRING);
                } catch (JSONException e) {/*ignore*/}
            }
        else if (RESPONSE_CONTENT_TYPES.HTML.contains(contentType)) {
            this.responseBody = Jsoup.parse(RESPONSE_STRING);
        } else if (RESPONSE_CONTENT_TYPES.XML.contains(contentType))
            this.responseBody = RESPONSE_STRING;
        else {
            this.responseBody = RESPONSE_STRING;
            System.out.println("[WARNING] Unknowing response type, please add it to test framework - " + contentType);
        }
        if (isLogRequestShort) {
            System.out.println("Response text: " + RESPONSE_STRING.substring(0, 1000));
        } else {
            System.out.println("Response text: " + RESPONSE_STRING);
        }
    }

    public void setLogRequestShort(boolean isLogRequestShort) {
        this.isLogRequestShort = isLogRequestShort;
    }

    public String getResponseBodyText() {
        return responseBody.toString();
    }

    public Document getHTMLResponseDocument() {
        return (Document) this.responseBody;
    }
}

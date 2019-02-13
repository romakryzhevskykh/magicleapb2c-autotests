package com.template.helpers.request_engine;

import com.template.helpers.user_engine.UserSession;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class POSTRequest extends APIRequest {

    private PrintWriter postParametersWriter;
    private DataOutputStream outputStream;
    @Getter private ArrayList<PostParameterAndValue> postParametersAndValues;
    private boolean isFile = false;
    @Setter private boolean isFollowRedirection = false;

    public POSTRequest(String name, String addressMethod) {
        super(name, addressMethod);
    }

    public void addPostParameterAndValue(PostParameterAndValue parameterAndValue) {
        if (postParametersAndValues == null) {
            this.postParametersAndValues = new ArrayList<>();
            this.postParametersAndValues.add(parameterAndValue);
        } else {
            this.postParametersAndValues.add(parameterAndValue);
        }
        if (parameterAndValue.value instanceof File) {
            System.out.println("The POST request contains file(s)");
            this.isFile = true;
        }
    }

    @SuppressWarnings("unchecked")
    public void addPostParameterAndValue(String parameter, String value) {
        PostParameterAndValue parameterAndValue = new PostParameterAndValue(parameter, value);
        if (postParametersAndValues == null) {
            this.postParametersAndValues = new ArrayList<>();
            this.postParametersAndValues.add(parameterAndValue);
        } else {
            this.postParametersAndValues.add(parameterAndValue);
        }
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


    private void setFormDataPostParametersAndValuesForMultipart(ArrayList<PostParameterAndValue> postParametersAndValues) throws IOException {
        if (postParametersAndValues != null) {
            this.postParametersAndValues = postParametersAndValues;
            for (PostParameterAndValue parameterAndValue : postParametersAndValues) {
                if (parameterAndValue.value instanceof File) {
                    File file = (File) parameterAndValue.value;
                    String fileName = file.getName();
                    this.postParametersWriter.append("--").append(boundary).append(DELIMITER.LINE_FEED.delimiter);
                    this.postParametersWriter.append("Content-Disposition: form-data; name=\"").append(parameterAndValue.parameter);
                    this.postParametersWriter.append("\"; filename=\"").append(fileName).append("\"");
                    this.postParametersWriter.append(DELIMITER.LINE_FEED.delimiter);
                    this.postParametersWriter.append("Content-Type: ").append(URLConnection.guessContentTypeFromName(fileName));
                    this.postParametersWriter.append(DELIMITER.LINE_FEED.delimiter);
                    this.postParametersWriter.append(DELIMITER.LINE_FEED.delimiter);
                    this.postParametersWriter.flush();
                    Files.copy(file.toPath(), this.outputStream);
                    this.outputStream.flush();
                    this.postParametersWriter.append(DELIMITER.LINE_FEED.delimiter).flush();
                    this.postParametersWriter.append("--").append(boundary).append("--").append(DELIMITER.LINE_FEED.delimiter).flush();
                } else {
                    this.postParametersWriter.append("--").append(boundary).append(DELIMITER.LINE_FEED.delimiter);

                    this.postParametersWriter.append("Content-Disposition: form-data; name=\"");
                    this.postParametersWriter.append(parameterAndValue.parameter).append("\"")
                            .append(DELIMITER.LINE_FEED.delimiter);
                    this.postParametersWriter.append(DELIMITER.LINE_FEED.delimiter);
                    this.postParametersWriter.append(parameterAndValue.value.toString()).append(DELIMITER.LINE_FEED.delimiter).flush();
                }
            }
        }
    }

    public void setPostString(String postString) {
        this.postParametersWriter.append(postString);
    }

    public void sendPostRequest(UserSession userSession) throws IOException {
        sendPostRequest(userSession, this.postParametersAndValues);
    }

    public void sendPostRequest() throws IOException {
        sendPostRequest(this.postParametersAndValues, Collections.emptyList());
    }

    public void sendPostRequest(List<String> cookies) throws IOException {
        sendPostRequest(this.postParametersAndValues, cookies);
    }

    private void sendPostRequest(ArrayList<PostParameterAndValue> postParametersAndValues, List<String> cookies) throws IOException {
        sendPostRequest(postParametersAndValues, null, cookies);
    }

    private void sendPostRequest(UserSession userSession, ArrayList<PostParameterAndValue> postParametersAndValues) throws IOException {
        sendPostRequest(postParametersAndValues, userSession, userSession.getCookies());
    }

    private void sendPostRequest(ArrayList<PostParameterAndValue> postParametersAndValues, UserSession userSession, List<String> cookies) throws IOException {
        System.out.println("Create url without post parameters");
        generateRequestURL(userSession);
        System.out.println("Create connection");
        System.out.println("*******");
        System.out.println("API: " + this.name);
        System.out.println("Sending 'POST' request to URL : " + requestURL.toString());

        connection = (HttpsURLConnection) requestURL.openConnection();
        connection.setRequestMethod("POST");

        if (isFile) {
            System.out.println("Set header: Content-Type = multipart/form-data; boundary=" + boundary);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        } else {
            System.out.println("Set header: Content-Type = application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }
        connection.setRequestProperty("Connection", "keep-alive");
        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        if (headers.size() > 0) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                System.out.println("Set request header: " + header);
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
        }

        if (!cookies.isEmpty()) {
            connection.setRequestProperty("Cookie", String.join("; ", cookies));
            System.out.println("Set cookie: " + String.join("\n ", cookies));
        }

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);

        System.out.println("Send request");
        this.outputStream = new DataOutputStream(connection.getOutputStream());
        this.postParametersWriter = new PrintWriter(new OutputStreamWriter(outputStream, CHARSET), true);

        System.out.println("Sending post data");
        if (connection.getRequestProperty("Content-Type").contains("json")) {
            setPayloadPostParametersAndValues(postParametersAndValues);
        } else if (this.isFile) {
            setFormDataPostParametersAndValuesForMultipart(postParametersAndValues);
        } else {
            setFormDataPostParametersAndValues(postParametersAndValues);
        }

        this.postParametersWriter.close();
        this.outputStream.flush();
        this.outputStream.close();

        if (this.isFollowRedirection) {
            connection = checkAndFollowRedirection(connection, userSession);
        }

        this.response = new APIResponse(connection);
        this.response.setContentType();
        this.response.setResponseCode();
        this.response.setResponseBody();

        System.out.println("*******");
        connection.disconnect();
    }
}

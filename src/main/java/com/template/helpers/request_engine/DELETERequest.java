package com.template.helpers.request_engine;

import com.template.helpers.user_engine.UserSession;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.Objects;

public class DELETERequest extends APIRequest {

    public DELETERequest(String name, String address_method) {
        super(name, address_method);
    }

    @Override
    public DELETERequest getClone() {
        return new DELETERequest(name, getSystemAddress());
    }

    public void sendDeleteRequest(UserSession userSession) throws IOException {
        generateRequestURL(userSession);
        try {
            System.out.println("*******");
            System.out.println("API: " + this.name);
            System.out.println("Sending 'DELETE' request to URL : " + requestURL.toString());
            connection = (HttpsURLConnection) requestURL.openConnection();
            connection.setRequestMethod("DELETE");
            //add request header
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            //add connection time out in milliseconds
            connection.setConnectTimeout(connectionTimeout);
            connection.setReadTimeout(connectionTimeout);
            connection.setInstanceFollowRedirects(false);

            if (headers.size() > 0) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    System.out.println("Set request header: " + header);
                    connection.setRequestProperty(header.getKey(), header.getValue());
                }
            }

            if (userSession.getCookies() != null) {
                connection.setRequestProperty("Cookie", String.join("; ", userSession.getCookies()));
                System.out.println("Set cookie: " + String.join("\n ", userSession.getCookies()));
            }

            connection = checkAndFollowRedirection(connection, userSession);

            this.response = new APIResponse(connection);
            this.response.setLogRequestShort(isShortLogResponse);
            this.response.setContentType();
            this.response.setContentDisposition();
            this.response.setResponseCode();
            if (Objects.nonNull(this.response.getContentDisposition()) && this.response.getContentDisposition().contains("attachment")) {
                this.response.setResponseAttachment();
            } else {
                this.response.setResponseBody();
            }
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

package com.sarnova.emp.framework.rest.client.impl;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final String MEDIA_TYPE = "Media-Type";
    private static final String TEXT_PLAIN = "text/plain";
    private static final String COOKIE = "Cookie";
    private static final String X_CSRF_TOKEN = "X-CSRF-TOKEN";

    private String sessionAuthValue;
    private String crfToken;

    @Override
    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, final ClientHttpRequestExecution execution) throws IOException {
        final HttpRequest wrapper = new HttpRequestWrapper(request);
        wrapper.getHeaders().add(MEDIA_TYPE, TEXT_PLAIN);
        wrapper.getHeaders().add(COOKIE, getJSessionId());
        wrapper.getHeaders().add(X_CSRF_TOKEN, getCrfToken());
        return execution.execute(wrapper, body);
    }

    public String getJSessionId() {
        return sessionAuthValue;
    }

    public void setJSessionId(String sessionAuthValue) {
        this.sessionAuthValue = sessionAuthValue;
    }

    public String getCrfToken() {
        return crfToken;
    }

    public void setCrfToken(String crfToken) {
        this.crfToken = crfToken;
    }
}

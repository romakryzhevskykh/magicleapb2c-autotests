package com.sarnova.emp.framework.rest.client.impl;

import com.sarnova.emp.framework.rest.client.RestTemplateHolder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

import javax.annotation.PostConstruct;

@Component
public class DefaultRestTemplateHolder implements RestTemplateHolder {

    private final HeaderRequestInterceptor headerRequestInterceptor;
    private RestTemplate restTemplate;

    @Autowired
    public DefaultRestTemplateHolder(HeaderRequestInterceptor headerRequestInterceptor) {
        this.headerRequestInterceptor = headerRequestInterceptor;
    }

    @PostConstruct
    public void initRestTemplate() {
        restTemplate = new RestTemplate(configureSSL());
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());
        restTemplate.setInterceptors(Collections.singletonList(headerRequestInterceptor));
    }

    @Override
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    private HttpComponentsClientHttpRequestFactory configureSSL() {
        final SSLContextBuilder sslContext = new SSLContextBuilder();
        CloseableHttpClient httpClient = null;
        try {
            sslContext.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            httpClient = HttpClients.custom().setSSLContext(sslContext.build()).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException ignored) {
        }
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return requestFactory;
    }

    @Override
    public void setJSessionId(String jsessionId) {
        headerRequestInterceptor.setJSessionId(jsessionId);
    }

    @Override
    public void setCrfToken(String crfToken) {
        headerRequestInterceptor.setCrfToken(crfToken);
    }
}

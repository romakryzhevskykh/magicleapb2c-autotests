package com.sarnova.emp.framework.rest.client.impl;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RestTemplateErrorHandler implements ResponseErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestTemplateErrorHandler.class);

    @Override
    public boolean hasError(final ClientHttpResponse clientHttpResponse) throws IOException {
        final HttpStatus.Series series = clientHttpResponse.getStatusCode().series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series) || HttpStatus.Series.SERVER_ERROR.equals(series));
    }

    @Override
    public void handleError(final ClientHttpResponse clientHttpResponse) throws IOException {
        final InputStream bodyStream = clientHttpResponse.getBody();
        final String body = IOUtils.toString(clientHttpResponse.getBody(), StandardCharsets.UTF_8);
        IOUtils.closeQuietly(bodyStream);
        LOG.error("Response error: {} {} {}", clientHttpResponse.getStatusCode(), clientHttpResponse.getStatusText(), body);
    }
}

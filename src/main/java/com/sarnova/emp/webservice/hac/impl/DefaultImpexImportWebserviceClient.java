package com.sarnova.emp.webservice.hac.impl;

import com.sarnova.emp.util.RegexUtils;
import com.sarnova.emp.webservice.hac.ImpexImportWebserviceClient;
import com.sarnova.emp.framework.rest.client.RestTemplateHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.sarnova.emp.util.RegexUtils.matchPattern;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class DefaultImpexImportWebserviceClient extends AbstractWebserviceClient implements ImpexImportWebserviceClient {

    private static final String CONSOLE_IMPEX_IMPORT = "console/impex/import";
    private static final String RESULT_REGEX = "data-result=\"(.*)\">";

    private final RestTemplateHolder restTemplateHolder;

    @Autowired
    public DefaultImpexImportWebserviceClient(RestTemplateHolder restTemplateHolder) {
        this.restTemplateHolder = restTemplateHolder;
    }

    @Override
    public void importContent(String impex) {
        String body = openImpexImportPage();
        restTemplateHolder.setCrfToken(getCrfCode(body));
        String impexResponseBody = importImpex(impex);
        checkImpexImportResult(impexResponseBody);
    }

    private String openImpexImportPage() {
        ResponseEntity<String> response = getRestTemplate().getForEntity(getImportImpexUrl(),
                String.class);
        return response.getBody();
    }

    private String importImpex(String impex) {
        ResponseEntity<String> response = getRestTemplate().postForEntity(getImportImpexUrl(),
                setParamsToUrl(impex), String.class);
        return response.getBody();
    }

    private String getImportImpexUrl() {
        return getHacUrl() + CONSOLE_IMPEX_IMPORT;
    }

    private MultiValueMap<String, String> setParamsToUrl(String impex) {
        MultiValueMap<String, String> urlParameters = new LinkedMultiValueMap<>();
        urlParameters.add("encoding", "UTF-8");
        urlParameters.add("maxThreads", "2");
        urlParameters.add("validationEnum", "IMPORT_STRICT");
        urlParameters.add("scriptContent", impex);
        return urlParameters;
    }

    private void checkImpexImportResult(String responseBody) {
        String responseResult = RegexUtils.matchPattern(responseBody, RESULT_REGEX, 1);
        assertThat(responseResult).as("Impex importing failed").isEqualTo("Import finished successfully");
    }
}

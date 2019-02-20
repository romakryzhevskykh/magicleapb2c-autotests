package com.sarnova.emp.framework.fixture.generator.impl;

import com.sarnova.emp.framework.fixture.generator.ImpexFixtureGenerator;
import com.sarnova.emp.entity.CustomerDto;
import freemarker.template.Configuration;
import freemarker.template.Template;
import javaslang.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultImpexFixtureGenerator implements ImpexFixtureGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultImpexFixtureGenerator.class);
    private static final String USERNAME_PLACEHOLDER = "userName";
    private static final String B2B_ID_PLACEHOLDER = "id";
    private static final String BILLING_ADDRESS_ID_PLACEHOLDER = "addressBillingId";
    private static final String SHIPPING_ADDRESS_ID_PLACEHOLDER = "addressShippingId";
    private static final String CUSTOMER_TEMPLATE_IMPEX = "customer_template.impex";
    private static final String IMPEX_PATH = "/impex";

    @Override
    public String generateCustomerFixture(CustomerDto customerDto) {
        Configuration cnfTemplate = initConfiguration();
        Template template = Try.of(() -> cnfTemplate.getTemplate(CUSTOMER_TEMPLATE_IMPEX))
                .getOrElseThrow(() -> new RuntimeException("Could not find impex template"));

        StringWriter out = generateImpex(setPlaceholder(customerDto), template);
        return out.toString();
    }

    private Configuration initConfiguration() {
        Configuration configTemplate = new Configuration();
        configTemplate.setClassForTemplateLoading(DefaultImpexFixtureGenerator.class, IMPEX_PATH);
        return configTemplate;
    }

    private StringWriter generateImpex(Map<String, Object> userEmailMap, Template template) {
        StringWriter writer = new StringWriter();
        Try.run(() -> template.process(userEmailMap, writer)).orElse(() -> {
            LOG.warn("Impex template or placeholders were'n found");
            throw new RuntimeException("Failed to process template.");
        });
        return writer;
    }

    private Map<String, Object> setPlaceholder(CustomerDto customerDto) {
        final Map<String, Object> placeholderMap = new HashMap<>();
        placeholderMap.put(USERNAME_PLACEHOLDER, customerDto.getUserName());
        placeholderMap.put(B2B_ID_PLACEHOLDER, customerDto.getB2bUnitDto().getId());
        placeholderMap.put(BILLING_ADDRESS_ID_PLACEHOLDER, customerDto.getBillingAddressDto().getAddressId());
        placeholderMap.put(SHIPPING_ADDRESS_ID_PLACEHOLDER, customerDto.getShippingAddressDto().getAddressId());
        return placeholderMap;
    }
}

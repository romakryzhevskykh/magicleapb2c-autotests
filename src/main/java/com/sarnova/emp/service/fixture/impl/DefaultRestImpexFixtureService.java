package com.sarnova.emp.service.fixture.impl;

import com.sarnova.emp.service.fixture.ImpexFixtureService;
import com.sarnova.emp.framework.fixture.generator.ImpexFixtureGenerator;
import com.sarnova.emp.entity.CustomerDto;
import com.sarnova.emp.webservice.hac.ImpexImportWebserviceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultRestImpexFixtureService implements ImpexFixtureService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultRestImpexFixtureService.class);

    private final ImpexFixtureGenerator impexGenerator;
    private final ImpexImportWebserviceClient impexImportWebserviceClient;

    @Autowired
    public DefaultRestImpexFixtureService(ImpexFixtureGenerator impexGenerator, ImpexImportWebserviceClient impexImportWebserviceClient) {
        this.impexGenerator = impexGenerator;
        this.impexImportWebserviceClient = impexImportWebserviceClient;
    }

    @Override
    public CustomerDto registerCustomer(CustomerDto customerDto) {
        String userCreationImpex = impexGenerator.generateCustomerFixture(customerDto);
        impexImportWebserviceClient.importContent(userCreationImpex);
        LOG.info("New customer has been created  " + customerDto.getUserName());
        return customerDto;
    }
}

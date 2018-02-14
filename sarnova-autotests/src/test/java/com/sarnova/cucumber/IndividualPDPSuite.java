package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {"src/test/resources/features/pdp_features/individual_pdp_features",
                "src/test/resources/features/pdp_features/individual_pdp_features"}
)

public class IndividualPDPSuite extends CucumberTestsRunner {
}

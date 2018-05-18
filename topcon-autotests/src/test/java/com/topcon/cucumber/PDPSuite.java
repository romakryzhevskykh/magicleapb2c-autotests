package com.topcon.cucumber;

import com.topcon.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/pdp_features/"
)

public class PDPSuite extends CucumberTestsRunner {
}
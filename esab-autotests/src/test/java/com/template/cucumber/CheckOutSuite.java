package com.template.cucumber;

import com.template.cucumber.runners.CucumberTestsRunner;

import cucumber.api.CucumberOptions;
@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/check_out_features/"
)

public class CheckOutSuite extends CucumberTestsRunner {

}

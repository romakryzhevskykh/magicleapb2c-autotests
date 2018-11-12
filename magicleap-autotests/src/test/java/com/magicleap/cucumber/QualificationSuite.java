package com.magicleap.cucumber;

import com.magicleap.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = "src/test/resources/features/qualification_features/"
)

public class QualificationSuite extends CucumberTestsRunner {
}

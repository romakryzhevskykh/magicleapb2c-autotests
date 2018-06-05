package com.topcon.cucumber;

import com.topcon.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/checkout_features/"
)

public class CheckoutSuit extends CucumberTestsRunner {
}
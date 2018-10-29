package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = {
                "src/test/resources/features/purchase_request_features/SubmitPurchaseRequestFeature.feature",
        }
)

public class PurchaseRequestSuite extends CucumberTestsRunner {
}

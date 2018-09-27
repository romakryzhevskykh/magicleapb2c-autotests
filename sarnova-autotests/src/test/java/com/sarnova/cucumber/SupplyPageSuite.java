package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = {
                "src/test/resources/features/purchase_request_features/instances_crud_features/Purchase_Summary_Page.feature"
        }
)

public class SupplyPageSuite extends CucumberTestsRunner {
}

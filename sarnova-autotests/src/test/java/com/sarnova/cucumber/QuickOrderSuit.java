package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/quick_order_features/Quick_Order_Add_Products_To_List.feature",
        }
)

public class QuickOrderSuit extends CucumberTestsRunner {
}

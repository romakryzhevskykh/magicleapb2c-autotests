package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/pdp_features/individual_pdp_features/Individual_PDP_Add_To_Supply_List.feature",
                "src/test/resources/features/cart_features/Cart_Page_Add_To_Supply_List.feature",
                "src/test/resources/features/quick_order_features/Quick_Order_Add_To_Supply_List.feature"
        }
)
public class AddToSupplyListSuite extends CucumberTestsRunner {
}

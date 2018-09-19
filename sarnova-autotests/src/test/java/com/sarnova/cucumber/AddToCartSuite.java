package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/pdp_features/individual_pdp_features/Individual_PDP_Add_To_Cart.feature",
                "src/test/resources/features/supply_list_features/supply_list_details_page_features/Supply_List_Details_Add_To_Cart.feature",
                "src/test/resources/features/quick_order_features/Quick_Order_Add_To_Cart.feature"
        }
)
public class AddToCartSuite extends CucumberTestsRunner {
}

package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/supply_list_features/supply_list_details_page_features/Supply_List_Details_Activation_Statuses.feature",
                "src/test/resources/features/supply_list_features/supply_list_details_page_features/Supply_List_Details_Favorite.feature",
                "src/test/resources/features/supply_list_features/supply_list_details_page_features/Supply_List_Details_Quick_Add.feature",
                "src/test/resources/features/supply_list_features/supply_lists_page_features/Supply_Lists_Activation_Statuses.feature",
                "src/test/resources/features/supply_list_features/supply_lists_page_features/Supply_Lists_Favorite.feature"
        }
)
public class SupplyListsFunctionalitySuit extends CucumberTestsRunner {
}

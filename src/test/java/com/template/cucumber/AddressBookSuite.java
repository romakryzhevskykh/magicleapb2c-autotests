package com.template.cucumber;

import com.template.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/address_book_features/"
)

public class AddressBookSuite extends CucumberTestsRunner {
}
package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.SpecialPricingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SpecialPricingStepDefs extends AbstractStepDefs {
    @Autowired
    private SpecialPricingPage specialPricingPages;

}
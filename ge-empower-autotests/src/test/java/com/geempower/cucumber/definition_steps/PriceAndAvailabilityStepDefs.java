package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.page_blocks.FullProductDetailsPopUpBlock;
import com.geempower.storefront.page_blocks.HeaderBlock;
import com.geempower.storefront.pages.PriceAndAvailabilityPage;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.*;

public class PriceAndAvailabilityStepDefs extends AbstractStepDefs {
    @Autowired
    private PriceAndAvailabilityPage priceAndAvailabilityPage;
    @Autowired
    private FullProductDetailsPopUpBlock fullProductDetailsPopUpBlock;
    @Autowired
    private HeaderBlock headerBlock;

    private final double delta = 0.000001;



}
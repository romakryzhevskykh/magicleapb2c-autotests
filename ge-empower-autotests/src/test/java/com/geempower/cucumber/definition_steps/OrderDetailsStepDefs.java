package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.OrderDetailsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static com.geempower.storefront.page_elements.OrderDetailsPageElements.TOTAL_NET_PRICE_VALUE_XPATH;
import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class OrderDetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private OrderDetailsPage orderDetailsPage;

    private final double delta = 0.000001;

    @Then("^Orders Details page is opened.$")
    public void orderDetailsPageIsOpened() {
        assertTrue(orderDetailsPage.isOpened(threadVarsHashMap.get(TestKeyword.GE_ORDER_NO).toString()));
    }

    @Then("^GE Order No. is correct.$")
    public void GeOrderNoIsCorrect() {
        assertEquals(threadVarsHashMap.get(TestKeyword.GE_ORDER_NO), orderDetailsPage.getGeOrderNo());
    }

    @Then("^Total Net Price is equal to Extend Price.$")
    public void totalNetPriceIsEqualToExtendPrice() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> {
            double finalNetPrice = Double.parseDouble(product.getFinalNetPrice());
            double quantityOfEachProduct = (double) selectedProducts.get(product);
            double finalActualPrice = finalNetPrice * quantityOfEachProduct;
            assertEquals(finalActualPrice, Double.parseDouble(orderDetailsPage.getTotalNetPrice()), delta);
        });
    }

}

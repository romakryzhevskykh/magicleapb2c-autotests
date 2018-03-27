package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.ThreadVarsHashMap;
import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.helpers.user_engine.UserSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.HashMap;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public abstract class AbstractStepDefs {
    @Autowired
    protected ThreadVarsHashMap threadVarsHashMap;
    @Autowired
    protected UserSessions userSessions;

    @SuppressWarnings("unchecked")
    protected ArrayList<Region> getChosenRegions() {
        ArrayList<Region> regions = null;
        if (threadVarsHashMap.get(TestKeyword.CHOSEN_REGION) == null) {
            regions = new ArrayList<>();
            threadVarsHashMap.put(TestKeyword.CHOSEN_REGION, regions);
        } else {
            regions = (ArrayList<Region>) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        }
        return regions;
    }

    @SuppressWarnings("unchecked")
    protected HashMap<Product, Integer> getSelectedProducts() {
        HashMap<Product, Integer> selectedProducts;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS) == null) {
            selectedProducts = new HashMap<>();
        } else {
            selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        }
        return selectedProducts;
    }
}

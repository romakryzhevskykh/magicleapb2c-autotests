package com.template.cucumber.definition_steps;

import com.template.helpers.ThreadVarsHashMap;
import com.template.helpers.models.products.VariantProduct;
import com.template.helpers.user_engine.UserSessions;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;
import java.util.Objects;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public abstract class AbstractStepDefs {
    @Autowired protected ThreadVarsHashMap threadVarsHashMap;
    @Autowired protected UserSessions userSessions;

    @SuppressWarnings("unchecked")
    protected Map<VariantProduct, Integer> getSelectedProducts() {
        Map<VariantProduct, Integer> selectedProducts;
        if (Objects.isNull(threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS))) {
            selectedProducts = new HashedMap();
            threadVarsHashMap.put(TestKeyword.SELECTED_PRODUCTS, selectedProducts);
        } else {
            selectedProducts = (Map<VariantProduct, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        }
        return selectedProducts;
    }

    protected void addSelectedProducts(Map<VariantProduct, Integer> productsToAdd) {
        Map<VariantProduct, Integer> selectedProducts = getSelectedProducts();
        productsToAdd.forEach((product, quantity) -> {
            if (selectedProducts.containsKey(product)) {
                Integer productQuantity = selectedProducts.get(product);
                selectedProducts.put(product, productQuantity + quantity);
            } else {
                selectedProducts.put(product, quantity);
            }
        });
    }
}

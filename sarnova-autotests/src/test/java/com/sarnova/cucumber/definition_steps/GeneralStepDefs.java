package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.user_engine.UserSession;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class GeneralStepDefs extends AbstractStepDefs {
    @Autowired HeaderRowPageBlock headerRowPageBlock;
    @Autowired LoginPage loginPage;

    @Autowired private SupplyListsManager supplyListsManager;
    @Autowired private ProductsManager productsManager;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (headerRowPageBlock.isUserLoggedOut()) {
            loginPage.open();
            loginPage.loginToStorefront(userSessions.getActiveUserSession());
        }
    }

    @And("^Supply list that doesn't contain this products exists.$")
    public void existingSupplyListThatDoesNotContainThisProducts() {
        ArrayList<UnitOfMeasure> selectedUnitsOfMeasurement = ((ArrayList<UnitOfMeasure>) threadVarsHashMap.get(TestKeyword.SELECTED_ON_PDP_UOMS));
        supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(supplyList -> supplyList.getSupplyProductsInList()
                        .stream()
                        .flatMap(supplyListProduct -> supplyListProduct.getIndividualProduct().getUnitsOfMeasurement().stream())
                        .noneMatch(selectedUnitsOfMeasurement::contains)
                ).findAny().orElseGet(() -> {
            UserSession userSession = userSessions.getActiveUserSession();
            String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
            IndividualProduct individualProductThatDoNotContainSelectedUOMs = (IndividualProduct) productsManager.getTestProducts()
                    .stream()
                    .filter(product -> product instanceof IndividualProduct)
                    .filter(product -> ((IndividualProduct) product).getUnitsOfMeasurement()
                            .stream()
                            .noneMatch(selectedUnitsOfMeasurement::contains)
                    ).findAny().orElseGet(() -> {
                        throw new NullPointerException("No test products without selected UOMs: " + selectedUnitsOfMeasurement);
                    });
            supplyListsManager.createViaApi(userSession, newSupplyListName,
                    new ArrayList<IndividualProduct>() {{
                        add(individualProductThatDoNotContainSelectedUOMs);
                    }});
            return supplyListsManager.getSupplyListByName(newSupplyListName);
        });
    }
}

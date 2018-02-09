package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.models.products.*;
import com.sarnova.storefront.pages.ProductDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class ProductDetailsPageStepDefs extends AbstractStepDefs {

    @Autowired private ProductDetailsPage productDetailsPage;
    @Autowired private ProductsManager productsManager;
    @Autowired private SupplyListsManager supplyListsManager;

    @Given("^PDP for (.*) product.$")
    public void openPDPForProductType(String productType) {
        Product product = productsManager.getProductByProductTestType(ProductTestType.valueOf(productType));
        productDetailsPage.openPDPForProduct(product);
        threadVarsHashMap.put(TestKeyword.OPENED_PDP_PRODUCT, product);
    }

    @And("^Set QTY values for products to (\\d+).$")
    public void setQTYValuesForProductsTo(int qtyValueForAllProductsOnPDP) {
        Product product = (Product) threadVarsHashMap.get(TestKeyword.OPENED_PDP_PRODUCT);
        if (product instanceof IndividualProduct) {
            ((IndividualProduct) product).getUnitsOfMeasurement()
                    .forEach(uom -> productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAllProductsOnPDP));
        } else if (product instanceof GroupProduct) {
            ((GroupProduct) product).getIndividualProducts()
                    .stream()
                    .flatMap(individualProduct -> individualProduct.getUnitsOfMeasurement().stream())
                    .forEach(uom -> productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAllProductsOnPDP));
        }
    }

    @When("^Click on add to Supply list button.$")
    public void clickOnAddToSupplyListButton() {
        productDetailsPage.clickOnAddToSupplyListButton();
    }

    @Then("^Pop-up with (.*) message is opened.$")
    public void checkThatPopUpIsOpenedWithMessage(String message) {
        assertEquals(productDetailsPage.getAddToSupplyListPopUpContent(), message);
    }

    @And("^Set QTY (\\d+) to any product\\(UOM\\) from the list.$")
    public void selectAnyProductUOMFromTheList(int qtyValueForAnyProductOnPDP) {
        Product product = (Product) threadVarsHashMap.get(TestKeyword.OPENED_PDP_PRODUCT);
        ArrayList<UnitOfMeasure> unitsOfMeasurement = new ArrayList<>();
        if (product instanceof IndividualProduct) {
            ((IndividualProduct) product).getUnitsOfMeasurement()
                    .stream()
                    .findAny()
                    .ifPresent(uom -> {
                        unitsOfMeasurement.add(uom);
                        productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAnyProductOnPDP);
                        threadVarsHashMap.put(TestKeyword.SELECTED_ON_PDP_UOMS, unitsOfMeasurement);
                    });
        } else if (product instanceof GroupProduct) {
            ((GroupProduct) product).getIndividualProducts()
                    .stream()
                    .flatMap(individualProduct -> individualProduct.getUnitsOfMeasurement().stream())
                    .findAny()
                    .ifPresent(uom -> {
                        unitsOfMeasurement.add(uom);
                        productDetailsPage.setQTYForProductUOMToValue(uom, qtyValueForAnyProductOnPDP);
                        threadVarsHashMap.put(TestKeyword.SELECTED_ON_PDP_UOMS, unitsOfMeasurement);
                    });
        }
    }

    @And("^Select Create a Supply list radio button in Add to Supply list pop-up.$")
    public void selectCreateASupplyListRadioButtonInAddToSupplyListPopUp() {
        productDetailsPage.clickOnCreateNewSupplyListInAddToSupplyListPopUp();
    }

    @And("^Select Select a Supply list radio button in Add to Supply list pop-up.$")
    public void selectSelectASupplyListRadioButtonInAddToSupplyListPopUp() {
        productDetailsPage.clickOnSelectSupplyListInAddToSupplyListPopUp();
    }

    @And("^Enter alphanumeric text to name field in Add to Supply list pop-up.$")
    public void enterAlphanumericTextToNameFieldInAddToSupplyListPopUp() {
        String newSupplyListName = RandomStringUtils.randomAlphanumeric(10);
        threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, newSupplyListName);
        productDetailsPage.enterNewSupplyListNameText(newSupplyListName);
    }

    @And("^Click on Add to Supply list in Add to Supply list pop-up.$")
    public void clickOnAddToSupplyListInAddToSupplyListPopUp() {
        productDetailsPage.clickOnAddToSupplyListButtonInAddToSupplyListPopUp();

        String newSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        if (newSupplyListName != null && !newSupplyListName.isEmpty()) {
            ArrayList<UnitOfMeasure> selectedUnitsOfMeasurement = (ArrayList<UnitOfMeasure>) threadVarsHashMap.get(TestKeyword.SELECTED_ON_PDP_UOMS);
            ArrayList<IndividualProduct> selectedIndividualProducts = selectedUnitsOfMeasurement
                    .stream()
                    .map(unitOfMeasure -> productsManager.getProductByUOM(unitOfMeasure))
                    .collect(Collectors.toCollection(ArrayList::new));
            supplyListsManager.createInstance(userSessions.getActiveUserSession().getUser(), newSupplyListName, selectedIndividualProducts);
        }
    }

    @And("^Click on View Supply list in Add to Supply list pop-up.$")
    public void clickOnViewSupplyListInAddToSupplyListPopUp() {
        productDetailsPage.clickOnViewSupplyListButtonInAddToSupplyListPopUp();
    }

    @And("^Select existing Supply list in Add to Supply list pop-up.$")
    public void selectExistingSupplyListInAddToSupplyListPopUp() {
        String existingSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        productDetailsPage.clickOnSelectExistingSupplyListDropDown();
        if (existingSupplyListName == null) {
            existingSupplyListName = productDetailsPage.getAnyExistingSupplyListNameFromDropDown();
            if (existingSupplyListName != null) {
                threadVarsHashMap.put(TestKeyword.SUPPLY_LIST_NAME, existingSupplyListName);
            } else {
                throw new NullPointerException("Existing supply lists haven't been found for user: " + userSessions.getActiveUserSession().getUser());
            }
        }
        productDetailsPage.selectExistingSupplyListFromDropDownBySupplyListName(existingSupplyListName);
    }
}

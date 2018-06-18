package com.topcon.cucumber.definition_steps;

import com.topcon.helpers.models.Product;
import com.topcon.storefront.pages.CartPage;
import com.topcon.storefront.pages.CheckoutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static com.topcon.cucumber.definition_steps.TestKeyword.OPENED_PDP_PRODUCT;
import static org.testng.AssertJUnit.assertTrue;

public class CheckoutPageStepDefs extends AbstractStepDefs {

    @Autowired private CheckoutPage checkoutPage;
    @Autowired private CartPage cartPage;

    @And("^Click on Checkout button in the Cart window.$")
    public void clickOnCheckoutButtonInTheCartWindow() {
        cartPage.clickOnCheckoutButton();
    }

    @And("^Set the PO number.$")
    public void setPONumber(){
        String randomPONumber = RandomStringUtils.randomNumeric(10);
        threadVarsHashMap.put(TestKeyword.PO_NUMBER, randomPONumber);
        checkoutPage.fillPONumberField(randomPONumber);
    }

    @And("^Click the Ship to Accounts button.$")
    public void clickTheShipToAccountsButton() {
        checkoutPage.clickTheShipToAccountsButton();
    }

    @And("^Click the first Use this Address button.$")
    public void clickTheFirstUseThisAddressButton() {
        checkoutPage.clickTheFirstUseThisAddressButton();
    }

    @And("^Click the Next button.$")
    public void clickTheNextButton() {
        checkoutPage.clickTheNextButton();
    }

    @And("^Choose the first Shipment Method in the Shipping Method section.$")
    public void chooseTheFirstShipmentMethodInTheShippingMethodSection() {
        checkoutPage.chooseTheFirstShippingMethodInTheShippingMethodSection();
    }

    @And("^Choose the first Shipping Carrier in the Shipping Method section.$")
    public void chooseTheFirstShippingCarrierInTheShippingMethodSection() {
        checkoutPage.chooseTheFirstShippingCarrierInTheShippingCarrierSection();
    }

    @And("^Click the Next button in the Shipping Method section.$")
    public void clickTheNextButtonInTheShippingMethodSection() {
       checkoutPage.clickTheNextButtonInTheShippingMethodSection();
    }

    @And("^Click the confirmation Terms of Use checkbox.$")
    public void clickTheConfirmationTermsOfUseCheckbox() {
        checkoutPage.clickTheConfirmationTermsOfUseCheckbox();
    }

    @And("^Click the Place Order button.$")
    public void clickThePlaceOrderButton() {
        checkoutPage.clickThePlaceOrderButton();
    }

    @Then("^Check that order has been placed successfully.$")
    public void checkThatOrderHasBeenPlacedSuccessfully() {
        Product product = (Product) threadVarsHashMap.get(OPENED_PDP_PRODUCT);
        assertTrue(checkoutPage.successMessageAppeared());
    }
}

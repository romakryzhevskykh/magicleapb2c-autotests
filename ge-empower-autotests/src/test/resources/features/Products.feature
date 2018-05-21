Feature: Some actions on Products page

  Background:
    Given Switch to Storefront as smAdmin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Products page and correct header title is displayed
    And Products page is opened.
    Then All Products title is displayed on Products page.

  Scenario Outline: Check that user is able to place order from the Products pageAnd Account management page is opened.
    And Account management page is opened.
    When Choose <region> region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Products page is opened.
    Given Select test product for chosen region.
    When User search for a product by catalog No. on the Products page.
    Then Product sub-detail page is opened.
    When User select the product by Catalog No. from the products list on the Product Sub-Detail page.
    And Add all the chosen products to the My Cart.
    Then Check that count of added items is displayed on My Cart icon.
    When User clicks on My Cart icon.
    Then Correct Line Items is displayed in the Checkout pop-up on the Product Sub-Detail page.
    Then Correct Order Value is displayed in the Checkout pop-up on the Product Sub-Detail page.
    When User clicks on Checkout button.
    Then My Cart page is opened.
    Then Check that default quantity is equals to 1 on the My Cart page.
    When Quantity is changed to random quantity of items for each product on the My Cart page.
    And All products are selected on the My Cart page.
    And Update Price & Availability button is clicked on the My Cart page.
    Then Extend Price is changed to correct value on the My Cart page.
    When User clicks on the Next top button on the My Cart page.
    When User fills PO no. to the PO no. field at the OE 2 page.
    And Select Shipment Address from the existing addresses at the OE 2 page.
    Then Selected Shipment address is equal to Ship to field value.
    When User clicks on the Bottom Next button at the OE 2 page.
    Then Order Summary step is opened.
    Then PO no. is correct at the OE 3 page.
    When User clicks on Place Order button at the OE 3 page.
    And Terms and Conditions pop-up is confirmed.
    Then Order Successful pop-up appears at the OE 3 page.
    When User closes the pop-up.
    Then Orders Details page is opened.
    Then GE Order No. is correct.
    Then Total Net Price is equal to Extend Price.

    Examples:
      | region        |
      | North_America |
      | ASIA          |
      | EMEA          |
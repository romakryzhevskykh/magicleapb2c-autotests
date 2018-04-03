Feature: Some actions on Dashboard page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Dashboard page and verify that all widgets are present
    And Dashboard page is opened.
    When Order Status widget is displayed.
    And Featured Updates widget is displayed.
    And Order Search widget is displayed.
    And Price and Availability widget is displayed.
    And Recent Orders widget is displayed.
    Then Recent Lists widget is displayed.

  Scenario: Check that user is able to place order via Copy&Paste field using P&A block in North America region
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Dashboard page is opened.
    When Click on Skip button.
    Given Select test product for chosen region.
    When User set catalogueNo to Copy & Paste field.
    And Click on P&A button.
    And Price&Availability page is opened.
    Then Check that default quantity is equals to 1 on the Price&Availability page.
    Then Check that description, list price, final net price, availability are equal to data from PDP.
    When Quantity is changed to random quantity of items for each product.
    And All products are selected on P&A page.
    And Update Price & Availability button is clicked.
    Then Extend Price is changed to correct value.
    And All products are selected on P&A page.
    When User clicks on Add to Cart button.
    Then Check that count of added items is displayed on My Cart icon.
    When User clicks on My Cart icon.
    Then Correct Line Items is displayed in the Checkout pop-up.
    Then Correct Order Value is displayed in the Checkout pop-up.
    When User clicks on Checkout button.
    Then My Cart page is opened.
    Then All necessary elements are displayed on the My Cart page.
    When User clicks on the Next top button.
    Then Shipping And Billing step is opened.
    Then All necessary elements are displayed on the Order Details block.
    Then All necessary elements are displayed on the Address Details block.
    Then All necessary elements are displayed on the Shipment Details block.
    Then All necessary elements are displayed on the Product Details block.
    When User fills PO no.
    And Select Shipment Address.
    Then Selected Shipment address is equal to Ship to field value.
    When User clicks on the Bottom Next button.
    Then Order Summary step is opened.
    Then All necessary elements are displayed on the Order Summary block on Third Order Entry page.
    Then All necessary elements are displayed on the Address Details block on Third Order Entry page.
    Then All necessary elements are displayed on the Shipment Details block on Third Order Entry page.
    Then All necessary elements are displayed on the Product Details block on Third Order Entry page.
    Then PO no. is correct.
    When User clicks on Place Order button.
    And Terms and Conditions pop-up is confirmed.
    Then Order Successful pop-up appears.
    When User closes the pop-up.
    Then Orders Details page is opened.
    Then GE Order No. is correct.
    Then Total Net Price is equal to Extend Price.
    And User cancels the order by clicking on the Cancel button.

  Scenario: Check that user is able to place order via Product Number field using P&A block in North America region
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    Given Select test product for chosen region.
    When User set catalogNo to Product Number field.
    And Click on P&A button.
    Then Price&Availability page is opened.
    Then Check that default quantity is equals to 1 on the Price&Availability page.
    Then Check that description, list price, final net price, availability are equal to data from PDP.
    When Quantity is changed to random quantity of items for each product.
    And All products are selected on P&A page.
    And Update Price & Availability button is clicked.
    Then Extend Price is changed to correct value.
    And All products are selected on P&A page.
    When User clicks on Add to Cart button.
    Then Check that count of added items is displayed on My Cart icon.
    When User clicks on My Cart icon.
    Then Correct Line Items is displayed in the Checkout pop-up.
    Then Correct Order Value is displayed in the Checkout pop-up.
    When User clicks on Checkout button.
    Then My Cart page is opened.
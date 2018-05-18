Feature: Dashboard elements and widgets checking, Order creation via the P&A block.

  Background:
    Given Switch to Storefront as smAdmin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Dashboard page and verify that all widgets are present
    And Dashboard page is opened.
    When Order Status widget is displayed.
    And Featured Updates widget is displayed.
    And Order Search widget is displayed.
    And Price and Availability widget is displayed.
    And Recent Orders widget is displayed.
    Then Recent Lists widget is displayed.

  Scenario Outline: Check that user is able to place order via Copy&Paste field using P&A block in NA, EMEA, ASIA regions
    And Account management page is opened.
    When Choose <region> region.
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
    When User clicks on the Next top button on the My Cart page.
    Then All necessary elements are displayed on the Order Details block at OE 2 page.
    Then All necessary elements are displayed on the Address Details block at OE 2 page.
    Then All necessary elements are displayed on the Shipment Details block at OE 2 page.
    Then All necessary elements are displayed on the Product Details block at the OE 2 page.
    When User fills PO no. to the PO no. field at the OE 2 page.
    And Select Shipment Address from the existing addresses at the OE 2 page.
    Then Selected Shipment address is equal to Ship to field value.
    When User clicks on the Bottom Next button at the OE 2 page.
    Then Order Summary step is opened.
    Then All necessary elements are displayed on the Order Summary block on at OE 3 page.
    Then All necessary elements are displayed on the Address Details block at OE 3 page.
    Then All necessary elements are displayed on the Shipment Details block at OE 3 page.
    Then All necessary elements are displayed on the Product Details block at OE 3 page.
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
      | EMEA          |
      | ASIA          |

  Scenario Outline: Check that user is able to place order via Product Number field using P&A block in the Latin America region
    And Account management page is opened.
    When Choose Latin_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    Given Select test product for chosen region.
    When User set chosen catalogueNo to the Product Number field.
    And Click on P&A button.
    And Select address from address field.
    And Click on Submit button.
    Then Price&Availability page is opened.
    Then Check that default quantity is equals to <default quantity> on the Price&Availability page.
    Then Check that description, list price, final net price, availability are equal to data from PDP.
    And Put <default quantity> to the hashmap on P&A page.
    And All products are selected on P&A page.
    When User clicks on Add to Cart button.
    Then Check that count of added items is displayed on My Cart icon.
    When User clicks on My Cart icon.
    Then Correct Line Items is displayed in the Checkout pop-up.
    Then Correct Order Value is displayed in the Checkout pop-up.
    When User clicks on Checkout button.
    Then My Cart page is opened.
    When User clicks on the Next top button on the My Cart page.
    Then Payer and Shipment Addresses are correct at the OE 2 page.
    When User fills PO no. to the PO no. field at the OE 2 page.
    When User selects Carrier from drop-down at the OE 2 page.
    When User fill Carrier Account No. field at the OE 2 page.
    When User clicks on the Bottom Next button at the OE 2 page.
    And Click on Add More Items button in the Minimum Shipment Charges pop-up at the OE 2 page.
    When Quantity is changed to random quantity of items for each product on the My Cart page.
    And All products are selected on the My Cart page.
    And Update Price & Availability button is clicked on the My Cart page.
    Then Extend Price is changed to correct value on the My Cart page.
    When User clicks on the Next top button on the My Cart page.
    When User clicks on the Bottom Next button at the OE 2 page.
    Then Order Summary step is opened.
    Then Payer and Shipment Addresses are correct at the OE 3 page.
    When User clicks on Place Order button at the OE 3 page.
    And Terms and Conditions pop-up is confirmed.
    Then Order Successful pop-up appears at the OE 3 page.
    When User closes the pop-up.
    Then Orders Details page is opened.
    Then GE Order No. is correct.
    Then Total Net Price is equal to Extend Price.

    Examples:
      | default quantity |
      | 1                |

  Scenario Outline: Check that all the Global P&A error messages are shown on the P&A page - DE86025
    And Account management page is opened.
    When Choose North_America region.
    And Select account 3758J01.
    And Click on chosen account.
    Then Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    When User add list of <products> products to the Copy&Paste block.
    And Click on P&A button.
    Then Price&Availability page is opened.
    Then All the products from <products> are displayed on the P&A page.
    Then Appropriate 2 error messages are displayed on the P&A page.

    Examples:
      | products                                    |
      | 1017251, 1019603, 1021099, 1021136, 1022416 |

  Scenario Outline: While doing P&A Add Item, SPA# from previous P&A result is being sent in the web service Request - DE81550
    And Account management page is opened.
    When Choose <region> region.
    And Select account 1318501.
    And Click on account with <salesDivision> sales division.
    Then Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    When User add list of <products> products to the Copy&Paste block.
    And Click on P&A button.
    Then Price&Availability page is opened.
    When User select <spaNo> SPA No for all the product.
    Then All the products have <spaNo> spa no in the Special Pricing field.
    And Account management page is opened.
    When Choose <region> region.
    And Select account 4642301.
    And Click on account with <salesDivision> sales division.
    Then Dashboard page is opened.
    When User set THQL1115AF2 to Product Number field.
    And Click on P&A button.
    Then Price&Availability page is opened.
    When User Add new item TED134025WL on the P&A page.
    Then All the products have <standardSpaNo> spa no in the Special Pricing field.

    Examples:
      | region        | products                        | spaNo    | salesDivision | standardSpaNo |
      | North_America | THHQB1120AF2, TEY150, 9T21B9103 | 45003985 | USS1_10_10    | STANDARD      |


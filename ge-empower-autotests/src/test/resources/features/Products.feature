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
    Then Check that count of added items is displayed on My Cart icon in Header block.
    When User clicks on My Cart icon in Header block.
    Then Correct Line Items is displayed in the Checkout pop-up on the Product Sub-Detail page.
    Then Correct Order Value is displayed in the Checkout pop-up on the Product Sub-Detail page.
    When User clicks on Checkout button in Header block.
    Then My Cart page is opened.
    Then Check that default quantity is equals to 1 on the My Cart page.
    When Quantity is changed to random quantity of items for each product on the My Cart page.
    And All products are selected on the My Cart page.
    And Update Price & Availability button is clicked on the My Cart page.
    Then Extend Price is changed to correct value on the My Cart page.
    When User clicks on the Next top button on the My Cart page.
    When User fills PO no. to the PO no. field on the OE 2 page.
    And Select Shipment Address from the existing addresses on the OE 2 page.
    Then Selected Shipment address is equal to Ship to field value.
    When User clicks on the Bottom Next button on the OE 2 page.
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

  Scenario Outline: Check that user is able to open PDP and check Product Detail and P&A tabs.
    And Account management page is opened.
    When Choose <region> region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Products page is opened.
    Given Select test product for chosen region.
    When User search for a product by catalog No. on the Products page.
    Then Product sub-detail page is opened.
    When User clicks on catalogNo link.
    Then PDP page is opened.
    Then Is Catalog No. number header displayed on PDP page.
    Then Is Product Details panel title and image displayed in Product Details block on PDP page.
    Then Is Add to Cart button displayed in Product Details block on PDP page.
    Then Is active Product Details Tab Selected on PDP page.
    Then Is Product Summary header title in Product Detail tab displayed.
    Then Check that product details table contains correct titles <product_details_table_items>.
    When Click on Price and Availability tab on PDP page.
    Then Is active Price and Availability tab Selected on PDP page.
    Then Is Availability Details header title displayed in Price and Availability tab.
    Then Info table contains Distribution Warehouse and Product Availability headers in Price and Availability tab.
    Then Is Pricing Details header title and table displayed in Price and Availability tab.
    Then Check that Pricing details table contains correct titles <pricing_details_table_items>.

    Examples:
      | region        | product_details_table_items                                                                                                                                                                                           | pricing_details_table_items                                                                                                                                               |
      | North_America | Catalog No., Description, Std. Package Weight, Product Family, Restock Fee, Customer Reference No., Minimum Order Qty., UPC, GSA Compliance, Discount Schedule, CCC, Currency, Notes, Package Qty., Country of Origin | Agreement No., Agreement Type, Unit of Measure, Book Price, Book Multiplier, Standard Price, List Price, Agreement Factor, Factor Type, Claimback Amount, Final Net Price |
      | ASIA          | Catalog No., Description, Std. Package Weight, Product Family, Restock Fee, Customer Reference No., Minimum Order Qty., UPC, GSA Compliance, Discount Schedule, CCC, Currency, Notes, Package Qty., Country of Origin | Agreement No., Agreement Type, Unit of Measure, Book Price, Book Multiplier, Standard Price, List Price, Agreement Factor, Factor Type, Claimback Amount, Final Net Price |
      | EMEA          | Catalog No., Description, Std. Package Weight, Product Family, Restock Fee, Customer Reference No., Minimum Order Qty., UPC, GSA Compliance, Discount Schedule, CCC, Currency, Notes, Package Qty., Country of Origin | Agreement No., Agreement Type, Unit of Measure, Book Price, Book Multiplier, Standard Price, List Price, Agreement Factor, Factor Type, Claimback Amount, Final Net Price |
      | Latin_America | Catalog No., Description, Std. Package Weight, Product Family, Restock Fee, Customer Reference No., Minimum Order Qty., UPC, GSA Compliance, Discount Schedule, CCC, Currency, Notes, Package Qty., Country of Origin | Agreement No., Agreement Type, Unit of Measure, Book Price, Book Multiplier, Standard Price, List Price, Agreement Factor, Factor Type, Claimback Amount, Final Net Price |

  Scenario Outline: Check that user is able to open PDP and check Specification and Publication tabs.
    And Account management page is opened.
    When Choose <region> region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Products page is opened.
    Given Select test product for chosen region.
    When User search for a product by catalog No. on the Products page.
    Then Product sub-detail page is opened.
    When User clicks on catalogNo link.
    Then PDP page is opened.
    When User clicks on Specifications tab.
    Then Is active Specification tab selected on PDP page.
    Then Is General Characteristics , Dimensions and Classifications header titles in Specification tab displayed.
    Then Check that general characteristics table contains correct titles <general_characteristic_table_items> in Specification tab.
    When User clicks on Publications tab.
    Then Is active List of Publications tab selected on PDP page.
    Then Is List of Publications header title in Publications tab displayed.
    Then Is Publications table with correct headers <publication_table_titles> displayed.
    Then Is Publications table contains link http://apps.geindustrial.com/publibrary.

    Examples:
      | region        | general_characteristic_table_items                                                                                                                                                                                                                                                                                              | publication_table_titles                                     |
      | North_America | Category, GO Schedule, Amperage, Frame Type, Trip Style, System Voltage, Poles, Trip Function, Continuous Current Rated, 120 Vac Interrupting Rating, 120/240 Vac Interrupting Rating, Suitable for Reverse Feed, Product Line, Long Time, Instantaneous, Protective Relays, Current Metering, Special Markings, GSA Compliance | Title, Type of Doc., Date, Publication No., Publication Type |
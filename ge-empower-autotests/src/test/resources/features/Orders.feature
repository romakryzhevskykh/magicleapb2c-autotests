Feature: Some actions on Orders page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Orders page and correct header title is displayed
    And Orders page is opened.
    Then Orders title is displayed on Orders page.

  Scenario: Check that Invoice details pop-up is appeared and displayed correctly
    And Account management page is opened.
    When Choose Latin_America region.
    And Select account 1000839.
    And Click on chosen account.
    When Click on Skip button.
    And Orders page is opened.
    When All orders were sorted by orderStatus.
    When Admin opens order with status Shipped.
    And Expands the order details area.
    And Clicks on Invoice hyperlink.
    Then Invoice Details pop-up is appear with correct text and header.
    And Admin closes the pop-up.

  Scenario Outline: Check that Multiple BOL is displayed correctly
    And Account management page is opened.
    When Choose North_America region.
    And Select account <account>.
    And Click on account with <salesDivision> sales division.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    When User searches order by <orderNo> orderNo via Order Search field.
    Then Order by parameters page with appropriate <orderNo> is opened.
    When User clicks on appropriate <orderNo>.
    Then Orders Details page is opened.
    Then Tracking information is MULTIPLE.
    When User clicks on Multiple hyperlink.
    Then BOL and Tracking Numbers pop-up appears.
    Then More than one BOL are displayed in the pop-up.
    And User closes BOL and Tracking Numbers pop-up.
    When User expands order details section.
    Then Bill of landing is MULTIPLE.
    When User clicks on Multiple hyperlink on BOL.
    Then BOL and Tracking Numbers pop-up appears.
    Then More than one BOL are displayed in the pop-up.
    And User closes BOL and Tracking Numbers pop-up.

    Examples:
      | account | salesDivision | orderNo   |
      | 5093868 | USS1          | 150775814 |

  Scenario: Check that user can place order via Re-Order functionality
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Orders page is opened.
    When User clicks on random order No.
    Then Orders Details page is opened.
    When User selects random catalog No checkbox on Orders Details page.
    And User clicks on Reorder button on Order Details page.
    When User clicks on My Cart icon in Header block.
    When User clicks on Checkout button in Header block.
    Then My Cart page is opened.
    Then Is Qty value equal to value on the Order page.
    When User clicks on the Next top button on the My Cart page.
    When User fills PO no. to the PO no. field on the OE 2 page.
    And Select Shipment Address from the existing addresses on the OE 2 page.
    When User clicks on the Bottom Next button on the OE 2 page.
    When User clicks on Place Order button at the OE 3 page.
    And Terms and Conditions pop-up is confirmed.
    Then Order Successful pop-up appears at the OE 3 page.

  Scenario Outline: Check that user is able to request open order report with pricing/ without pricing.
    And Orders page is opened.
    Then <openOrderReportMessage> message is displayed.
    When User clicks on request open order report icon.
    Then Open Order Report window with appropriate title Open Orders Report opened.
    And User selects <pricingOption> option.
    And User clicks on generate now button.
    Then Correct date is displayed in Post date column.
    Then Pricing value is the same as <pricingOption>.
    Then Comment is equal to The request will be sent to <userEmail>.
    When User closes the Open Order Report window.
    And Refresh page.
    When User clicks on request open order report icon.
    Then Open order report is displayed with appropriate date and time.
    When User closes the Open Order Report window.

    Examples:
      | openOrderReportMessage                   | pricingOption   | userEmail            |
      | New! Download your open orders report -> | With Pricing    | rmautotest@gmail.com |
      | New! Download your open orders report -> | Without Pricing | rmautotest@gmail.com |

    Scenario Outline: Check that Total Net Price value is correctly after changing status boxes - DE95700
      And Account management page is opened.
      When Choose <region> region.
      And Search random account for chosen region.
      And Click on chosen account.
      And Orders page is opened.
      When User clicks on random order No.
      Then Orders Details page is opened.
      When Save total net price to hashmap.
      And Users clicks on random status box.
      And User clicks on All status box.
      Then Is Total Net Price value correct after changing status boxes.

      Examples:
        | region        |
        | North_America |
        | EMEA          |
        | ASIA          |
        | Latin_America |
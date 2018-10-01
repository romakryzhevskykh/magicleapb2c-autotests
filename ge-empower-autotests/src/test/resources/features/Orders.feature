Feature: Some actions on Orders page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
#
#  Scenario: Check that user able to open Orders page and correct header title is displayed
#    And Orders page is opened.
#    Then Orders title is displayed on Orders page.
#
#  Scenario: Check that Invoice details pop-up is appeared and displayed correctly
#    And Account management page is opened.
#    When Choose Latin_America region.
#    And Select account 1000839.
#    And Click on chosen account.
#    When Click on Skip button.
#    And Orders page is opened.
#    When All orders were sorted by orderStatus.
#    When Admin opens order with status Shipped.
#    And Expands the order details area.
#    And Clicks on Invoice hyperlink.
#    Then Invoice Details pop-up is appear with correct text and header.
#    And Admin closes the pop-up.
#
#  Scenario Outline: Check that Multiple BOL is displayed correctly
#    And Account management page is opened.
#    When Choose North_America region.
#    And Select account <account>.
#    And Click on account with <salesDivision> sales division.
#    And Dashboard page is opened.
#    When Click on Skip button.
#    When Close cookies pop-up.
#    When User searches order by <orderNo> orderNo via Order Search field.
#    Then Order by parameters page with appropriate <orderNo> is opened.
#    When User clicks on appropriate <orderNo>.
#    Then Orders Details page is opened.
#    Then Tracking information is MULTIPLE.
#    When User clicks on Multiple hyperlink.
#    Then BOL and Tracking Numbers pop-up appears.
#    Then More than one BOL are displayed in the pop-up.
#    And User closes BOL and Tracking Numbers pop-up.
#    When User expands order details section.
#    Then Bill of landing is MULTIPLE.
#    When User clicks on Multiple hyperlink on BOL.
#    Then BOL and Tracking Numbers pop-up appears.
#    Then More than one BOL are displayed in the pop-up.
#    And User closes BOL and Tracking Numbers pop-up.
#
#    Examples:
#      | account | salesDivision | orderNo   |
#      | 5093868 | USS1          | 150775814 |
#
#  Scenario: Check that user can place order via Re-Order functionality
#    And Account management page is opened.
#    When Choose EMEA region.
#    And Search random account for chosen region.
#    And Click on chosen account.
#    And Orders page is opened.
#    When User clicks on random order No.
#    Then Orders Details page is opened.
#    Then Is Table with products displayed.
#    And Focus on browser.
#    When User selects random catalog No checkbox on Orders Details page.
#    Then Is <-  Select items and Add to cart .New! title displayed near reorder button.
#    And User clicks on Reorder button on Order Details page.
#    When User clicks on My Cart icon in Header block.
#    When User clicks on Checkout button in Header block.
#    Then My Cart page is opened.
#    Then Is Qty value equal to value on the Order page.
#    When User clicks on the Next top button on the My Cart page.
#    When User fills PO no. to the PO no. field on the OE 2 page.
#    And Select Shipment Address from the existing addresses on the OE 2 page.
#    When User clicks on the Bottom Next button on the OE 2 page.
#    When User clicks on Place Order button at the OE 3 page.
#    And Terms and Conditions pop-up is confirmed.
#    Then Order Successful pop-up appears at the OE 3 page.
#
#  Scenario Outline: Check that Total Net Price value is correctly after changing status boxes - DE95700
#    And Account management page is opened.
#    When Choose <region> region.
#    And Search random account for chosen region.
#    And Click on chosen account.
#    And Orders page is opened.
#    When User clicks on random order No.
#    Then Orders Details page is opened.
#    And User clicks on random status box.
#    And User clicks on All status box.
#    Then Is Table with products displayed.
#    Then Is Total Net Price value correct after changing status boxes.
#
#    Examples:
#      | region        |
#      | North_America |
#      | ASIA          |
#      | Latin_America |
#
#  Scenario Outline: Check that user is able to request open order report with pricing/ without pricing.
#    And Orders page is opened.
#    Then <openOrderReportMessage> message is displayed.
#    When User clicks on request open order report icon.
#    Then Open Order Report window with appropriate title Open Orders Report opened.
#    And User selects <pricingOption> option.
#    And User clicks on generate now button.
#    Then Correct date is displayed in Post date column.
#    Then Pricing value is the same as <pricingOption>.
#    Then Comment is equal to The request will be sent to <userEmail>.
#    When User closes the Open Order Report window.
#    And Refresh page.
#    When User clicks on request open order report icon.
#    Then Open order report is displayed with appropriate date and time.
#    When User closes the Open Order Report window.
#
#    Examples:
#      | openOrderReportMessage                   | pricingOption   | userEmail            |
#      | New! Download your open orders report -> | With Pricing    | rmautotest@gmail.com |
#      | New! Download your open orders report -> | Without Pricing | rmautotest@gmail.com |

#  Scenario Outline: Check that user can open Detail Orders page and verify main elements
#    And Account management page is opened.
#    When Choose North_America region.
#    And Search random account for chosen region.
#    And Click on chosen account.
#    And Orders page is opened.
#    When User clicks on random order No.
#    Then Orders Details page is opened.
#    When User expands Quote Details block.
#    Then Is Opened Quote Details block is displayed.
#    Then Is Ordered On label contains date in Quote Details block.
#    Then Is Order Value label contains USD value in Quote Details block.
#    Then Is Ship To label contains value in Quote Details block.
#    Then Is Ship Method label contains value in Quote Details block.
#    Then Is Created by label contains @ email character in Quote Details block.
#    Then Is Tax Total label contains USD value in Quote Details block.
#    Then Is User No. and Quote No. labels displayed in Quote Details block.
#    And User closes Quote Details block.
#    Then Is Opened Quote Details block is not displayed.
#    When User expands/closes status boxes.
#    Then Is Expanded status box line displayed.
#    Then Is Correct <statusesList> statuses displayed in the status boxes.
#    When User expands/closes status boxes.
#    Then Is Expanded status box line not displayed.
#    Then Is Correct time statuses <timeStatusesList> displayed near color status icons.
#    When User click on time status drop down field.
#    Then Is Correct time statuses <timeStatusesList> displayed in the time status drop down field.
#    Then Is Detail Order table contains correct header <tableTitles> titles.
#    When User opens random product detail block.
#    Then Is Agreement Number label contains value in Product Details block.
#    Then Is Request Date label contains date in Product Details block.
#    Then Is Ship Method label contains value in Product Details block.
#    Then Is Ship Location label contains value in Product Details block.
#    Then Is Ship To label contains value in Product Details block.
#    Then Is Correct <productDetailLabels> labels displayed in Product Details block.
#    When User closes opened product detail block.
#    Then Is Total Net Price value is equal to sum of all ext. price in table.
#
#    Examples:
#      | statusesList                                                         | timeStatusesList                                                 | tableTitles                                                                                                             | productDetailLabels                                                         |
#      | To be Scheduled, Open, Prepared to Ship, On Hold, Shipped, Cancelled | On Time, Within 3 days of project deliverable, Late, Closed Late | Catalog No., Description & Marks, Orig. Scheduled Ship Date, Tracking Information, Qty., Unit Price, Ext. Price, Status | Carrier, Bill of Lading, Contact Name, Promotion Code, Invoice, Contact No. |


  Scenario Outline: Check that user can open Details PO page and verify main elements
    And Account management page is opened.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    And Orders page is opened.
    When User clicks on random PO no.
    Then PO Details page is opened.
    Then Is Purchase Order title displayed on Details PO Number page.
    Then Is PO title contains appropriate PO number.
    Then Is Email/Download icon displayed in right corner.

    When User expands/closes status boxes on PO Details page.
    Then Is Expanded status box line displayed on PO Details page.
    Then Is Correct <statusesList> statuses displayed in the status boxes on PO Details page.
    When User expands/closes status boxes on PO Details page.
    Then Is Expanded status box line not displayed on PO Details page.

#    Then Is Ordered On label contains date in PO Details block.
#    Then Is Order Value label contains USD value in Quote Details block.
#    Then Is Ship To label contains value in Quote Details block.
#    Then Is Ship Method label contains value in Quote Details block.
#    Then Is Created by label contains @ email character in Quote Details block.
#    Then Is Tax Total label contains USD value in Quote Details block.
#    Then Is User No. and Quote No. labels displayed in Quote Details block.

    Examples:
      | statusesList                                                         |
      | To be Scheduled, Open, Prepared to Ship, On Hold, Shipped, Cancelled |


#  Scenario Outline: Check that tracking info slider contains all necessary information.
#    And Account management page is opened.
#    When Choose North_America region.
#    And Select account 5093868.
#    And Click on account with USS1 sales division.
#    And Orders page is opened.
#    When User clicks on filter order icon.
#    And Set order number <orderNo> to the order number field.
#    And Click on apply filter button.
#    Then Appropriate order with order number <orderNo> is appeared on orders page.
#    When User clicks on found order.
#    Then Tracking information has MULTIPLE values.
#    When User clicks on tracking info hyperlink.
#    Then BOL and Tracking Numbers pop-up appears.
#    When User click on random tracking number.
#    Then Tracking details slider appears.
#    Then Tracking details slider contains all necessary texts and icons <sliderTitle>, <trackingErrorMessage>, <shipmentInfoSentStatus>, <inTransitStatus>, <deliveredStatus>.
#    When User goes to the next Tracking Details.
#    Then Tracking details slider appears.
#    Then Tracking details slider contains all necessary texts and icons <sliderTitle>, <trackingErrorMessage>, <shipmentInfoSentStatus>, <inTransitStatus>, <deliveredStatus>.
#    When User goes to the previous Tracking Details.
#    Then Tracking details slider appears.
#    Then Tracking details slider contains all necessary texts and icons <sliderTitle>, <trackingErrorMessage>, <shipmentInfoSentStatus>, <inTransitStatus>, <deliveredStatus>.
#
#    Examples:
#      | orderNo   | sliderTitle      | trackingErrorMessage                                                 | shipmentInfoSentStatus | inTransitStatus | deliveredStatus |
#      | 150775814 | Tracking Details | This tracking number has expired and details are no longer available | Shipment Info sent     | In Transit      | Delivered       |
#
#  Scenario: Check that orders filtering by PO number works properly.
#    And Account management page is opened.
#    When Choose North_America region.
#    And Select account 5093868.
#    And Click on account with USS1 sales division.
#    And Orders page is opened.
#    When User clicks on filter order icon.
#    And Set random PO number to the po number field.
#    And Click on apply filter button.
#    Then Appropriate order with po number is appeared on orders page.
#
#  Scenario: Check that orders filtering by Job name works properly.
#    And Account management page is opened.
#    When Choose North_America region.
#    And Select account 5093868.
#    And Click on account with USS1 sales division.
#    And Orders page is opened.
#    When User clicks on filter order icon.
#    And Set random Job name number to the job name field.
#    And Click on apply filter button.
#    Then Appropriate orders with job names are appeared on orders page.
#
#  Scenario: Check that orders filtering by Date works properly.
#    And Account management page is opened.
#    When Choose North_America region.
#    And Select account 5093868.
#    And Click on account with USS1 sales division.
#    And Orders page is opened.
#    When User clicks on filter order icon.
#    And Set random Date to the date from field.
#    And Click on apply filter button.
#    Then Appropriate orders with equal date or greater date are appeared on orders page.
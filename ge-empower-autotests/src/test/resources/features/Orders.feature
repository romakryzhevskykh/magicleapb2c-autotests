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
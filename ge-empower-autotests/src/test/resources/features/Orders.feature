Feature: Some actions on Orders page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

#  Scenario: Check that user able to open Orders page and correct header title is displayed
#    And Orders page is opened.
#    Then All Orders title is displayed on Orders page.

  Scenario: Check that Invoice details pop-up is appeared and displayed correctly
    And Account management page is opened.
    When Choose Latin_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    When Click on Skip button.
    And Orders page is opened.
    When All orders were sorted by orderStatus DESC.
    When Admin opens order with status Shipped.
    And Expands the order details area.
    And Clicks on Invoice hyperlink.
    Then Invoice Details pop-up is appear with correct text and header.
    And Admin closes the pop-up.

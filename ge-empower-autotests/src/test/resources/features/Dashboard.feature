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
    And Dashboard page is opened.
    When Click on Skip button.
    Given Select test product for chosen region.
    When User set catalogueNo to Copy & Paste field.
    And Click on P&A button.
    Then Price&Availability page is opened.

#  Scenario: Check that user is able to place order via Product Number field using P&A block in North America region
#    And Account management page is opened.
#    When Choose North_America region.
#    And Search random account for chosen region.
#    And Dashboard page is opened.
#    When User set catalogNo. to Product Number field.
#    And Click on P&A button.
#    Then Price&Availability page is opened.

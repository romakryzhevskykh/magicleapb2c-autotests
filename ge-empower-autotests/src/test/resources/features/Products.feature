Feature: Some actions on Products page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Products page is opened.

  Scenario: Check that user able to open Products page and correct header title is displayed
    Then All Products title is displayed on Products page.
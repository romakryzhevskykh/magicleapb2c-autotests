Feature: Some actions on Products page

  Scenario: Check that user able to open Products page and correct header title is displayed
    Given Switch to Storefront as smAdmin.
    And User is logged in to Storefront.
    And Products page is opened.
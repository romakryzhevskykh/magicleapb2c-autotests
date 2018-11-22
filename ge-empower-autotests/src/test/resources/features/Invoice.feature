Feature: Some actions on Invoice page

  Scenario: Check that user able to open Invoice page and correct header title is displayed
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Invoice page is opened.
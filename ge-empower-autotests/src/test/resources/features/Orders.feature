Feature: Some actions on Orders page

  Scenario: Check that user able to open Orders page and correct header title is displayed
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Orders page is opened.
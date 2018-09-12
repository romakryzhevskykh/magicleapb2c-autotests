Feature: Some actions on My Cart page

  Scenario: Check that user able to open My Cart page
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And My Cart page is opened.
Feature: Some actions on My Cart page

  Scenario: Check that user able to open My Cart page and correct header title is displayed
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And My Cart page is opened.
    Then My Cart title is displayed on My Cart page.
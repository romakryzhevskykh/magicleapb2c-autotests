Feature: Some actions on My Cart page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And My Cart page is opened.

  Scenario: Check that user able to open My Cart page and correct header title is displayed
    Then My Cart title is displayed on My Cart page.
Feature: Some actions on My Cart page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open My Cart page and correct header title is displayed
    And My Cart page is opened.
    Then My Cart title is displayed on My Cart page.
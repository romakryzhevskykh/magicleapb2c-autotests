Feature: Some actions on Returns page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Returns page is opened.

  Scenario: Check that user able to open Returns page and correct header title is displayed
    Then All Cases title is displayed on Returns page.
Feature: Some actions on Orders page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Orders page is opened.

  Scenario: Check that user able to open Orders page and correct header title is displayed
    Then All Orders title is displayed on Orders page.
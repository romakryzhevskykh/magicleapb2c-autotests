Feature: Some actions on Saved Items page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Saved Items page is opened.

  Scenario: Check that user able to open Saved Items page and correct header title is displayed
    Then All Items title is displayed on Saved Items page.
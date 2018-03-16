Feature: Some actions on Rebates page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Rebates page is opened.

  Scenario: Check that user able to open Rebates page and correct header title is displayed
    Then All Rebates title is displayed on Rebates page.
Feature: Some actions on Manage Users page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Manage Users page and correct header title is displayed
    And Profile page is opened.
    Then Manage Users title is displayed on Manage Users page.
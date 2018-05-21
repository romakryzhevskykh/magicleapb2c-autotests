Feature: Some actions on Profile page

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.
    And Profile page is opened.

  Scenario: Check that user able to open Profile page and correct header title is displayed
    Then Modify Profile title is displayed on Profile page.
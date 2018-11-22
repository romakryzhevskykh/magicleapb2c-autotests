Feature: Manage users on Pending Requests/ Users/ Revalidation tabs

  Scenario: Check that user able to open Manage Users page and correct header title is displayed
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    And Refresh page.
    When Admin opens Users tab.
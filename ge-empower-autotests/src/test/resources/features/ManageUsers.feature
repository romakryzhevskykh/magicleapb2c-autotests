Feature: Some actions on Manage Users page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Manage Users page is opened.

  Scenario: Check that user able to open Manage Users page and correct header title is displayed
    Then Manage Users title is displayed on Manage Users page.

  Scenario: Check that admin is able to find user by account
    When Admin opens Users tab.
    And Sets valid email to the email field.
    And Click on the Search button.
    Then Appropriate user with appropriate account is displayed in the users list.

  Scenario: Check that admin is able to find user by email
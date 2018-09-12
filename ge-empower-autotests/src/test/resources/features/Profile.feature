Feature: Open Profile and Notification preferences pages

  Background:
    Given Switch to Storefront as rmAdmin.
    And User is logged in to Storefront.

  Scenario: Check that user able to open Notification Center page
    And Notification Center page is opened.

  Scenario: Check that user able to open Profile page
    And Profile page is opened.

Feature: Account settings page is a page for account details and password management

  Background:
    Given Switch to Storefront shopper.

    Scenario: Check that logged in user can open Account Settings
    Given Opened Start page.
    When Login to Storefront.
    When Hover on User Account icon.
    And Click on Account Settings item in My Account dropdown.
    Then Check that Account Settings page is opened.

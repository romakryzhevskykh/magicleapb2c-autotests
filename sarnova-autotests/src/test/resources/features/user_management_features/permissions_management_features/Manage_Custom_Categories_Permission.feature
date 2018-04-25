Feature: Check user restrictions with SUPPLY LISTS PERMISSION and without it.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Valid test user is present.
    And Test user group is present.
    And Test user group has only MANAGE_CUSTOM_CATEGORIES permission.
    And Test user has only test user group assigned.

  Scenario: Check that user with only MANAGE CUSTOM CATEGORIES PERMISSION has access to Custom Category item in My Account drop-down in header.
    When Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    And Refresh page.
    When My Account menu is opened.
    Then Check that Custom Category item is present in My Account menu.

  Scenario: Check that user with only MANAGE CUSTOM CATEGORIES PERMISSION has access to Custom Category page.
    When Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    When Open Custom category page.
    Then Check that Custom Categories page is opened.
    And Check that Categories tree is visible on Custom categories page.

  Scenario: Check that user with only MANAGE CUSTOM CATEGORIES PERMISSION has access to Add new Custom Category functionality.
    When Switch to Storefront cockpit test user.
    And User is logged in to Storefront.
    When Open Custom category page.
    Then Check that new Custom Category name field is visible on Custom categories page.
    And Check that Add new Custom Category button is visible on Custom categories page.
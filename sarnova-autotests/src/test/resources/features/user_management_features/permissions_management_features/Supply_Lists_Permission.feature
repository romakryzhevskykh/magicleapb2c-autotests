Feature: Check user restrictions with SUPPLY LISTS PERMISSION and without it.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.

    Scenario: Check that user without SUPPLY LISTS PERMISSION has no access to Supply Lists page.
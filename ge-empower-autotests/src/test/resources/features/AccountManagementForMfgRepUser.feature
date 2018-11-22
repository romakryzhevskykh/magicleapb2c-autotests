Feature: Some actions on Account Management page as mfg. rep. user

  Scenario: Favorite accounts are not displayed for Mfg. Rep. users.
    Given Switch to Storefront as mfgRepUser.
    And User is logged in to Storefront.
    And Account management page is opened.
#Feature: Some actions on Account Management page as mfg. rep. user
#
#  Background:
#    Given Switch to Storefront as mfgRepUser.
#    And User is logged in to Storefront.
#    And Account management page is opened.
#
#  Scenario: Favorite accounts are not displayed for Mfg. Rep. users.
#    Then Request account button is not displayed on the page.
#    Then Favorite accounts tab is not displayed on the page.
#    Then Pending for approval tab is not displayed on the page.
#    Then Accounts tab is displayed on the page.
#    Then User is able to find all accounts in North_America region.
#    Then User is able to find all accounts in EMEA region.
#    Then User is able to find all accounts in Latin_America region.
#    Then User is able to find all accounts in ASIA region.
#    And Dashboard page is opened.
#    When Click on Skip button.
#    When Close cookies pop-up.
#    When User opens account info dropdown.
#    Then There is no favorite accounts in the account info dropdown.
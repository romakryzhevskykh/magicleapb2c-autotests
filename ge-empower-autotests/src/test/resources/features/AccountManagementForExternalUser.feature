Feature: Some actions on Account Management page as external user

  Background:
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Account management page is opened.

    Scenario: Check that user is able to request an account
      When Request account popup is opened.
      And Popup is filled by North_America, Latin_America, EMEA, ASIA accounts.
      And User send this requests for approval.
      When User switch to Pending for approval tab on Account management page.
      Then Requested accounts are displayed on Pending for approval tab.
      And All request were removed by User.

    Scenario: Check that user is able to mark any account as favorites and then find it in Favorites account section.
      When User switch to Approved Accounts tab on Account management page.
      And First account is stored to the threadVarsHashMap.
      When User marks first account as favorite on approved accounts tab.
      And User switch to Favorites Accounts tab on Account management page.
      Then Favorite account is present on the Favorites Accounts table.
      When User unmarks the account as favorite on favorites accounts tab.
      Then The account is not displayed more on the table.
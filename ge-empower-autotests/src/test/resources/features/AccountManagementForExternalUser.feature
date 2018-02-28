Feature: Some actions on Account Management page as external user

  Background:
    Given Switch to Storefront as shopper.
    And User is logged in to Storefront.
    And Account management page is opened.

    Scenario: Check that user is able to request an account
      When Request account popup is opened.
      And Popup is filled by North_America, Latin_America, EMEA, ASIA accounts.
      And User send this requests for approval.
      When User switch to Pending for approval tab on Account management page.
      Then Requested accounts are displayed on Pending for approval tab.
      And All request were removed by User.

Feature: Some actions on Account Management page as external user

  Scenario: Check that user is able to request an account
    Given Switch to Storefront as externalUser2.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Request account popup is opened.

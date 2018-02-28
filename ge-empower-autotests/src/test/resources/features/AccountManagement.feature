Feature: Some actions on Account Management page

  Background:
    Given Switch to Storefront admin.
    And User is logged in to Storefront.
    And Account management page is opened.

    Scenario: Check that user able to choose appropriate account
      When Choose North_America region.
      And Search random account for chosen region.
      And Click on chosen account.
      When Click on Skip button.
      Then Dashboard page is opened.
      Then Chosen account is displayed in account box on Dashboard page.
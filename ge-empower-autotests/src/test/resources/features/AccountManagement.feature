Feature: Some actions on Account Management page as admin

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Account management page is opened.

    Scenario: Check that user able to choose appropriate account
      Then Favourites tab is displayed by Default on Account Management page.
      When Choose North_America region.
      And Search random account for chosen region.
      And Click on chosen account.
      When Click on Skip button.
      Then Check that Dashboard page is opened.
      Then Chosen account is displayed in account box on Dashboard page.
Feature: Some actions on Account Management page as admin

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.

  Scenario: Check that user able to choose appropriate account
    And Account management page is opened.
    Then Is Favorites tab displayed by Default on Account Management page.
    When Choose North_America region.
    And Search random account for chosen region.
    And Click on chosen account.
    When Click on Skip button.
    Then Check that Dashboard page is opened.
    Then Chosen account is displayed in account box on Dashboard page.

  Scenario: Check that admin is able to mark any account as favorite and find it in dropdown on Dashboard page.
    And Account management page is opened.
    And Count of Favorites accounts is stored to the threadVarsHashMap.
    And User switch to Approved Accounts tab on Account management page.
    When User marks some account as favorite.
    And Dashboard page is opened.
    When Click on Skip button.
    When Close cookies pop-up.
    When User opens account info dropdown.
    Then Correct count of favorite accounts is displayed in the account info dropdown.
    Then Previously marked account is displayed in account info dropdown.
    And Account management page is opened.
    And Previously marked account is unmarked by user.
    Then Correct count of favorite account is displayed in Favorites tab.

  Scenario: Check that user is able to go into the favorite account.
    And Account management page is opened.
    And User switch to Favorites Accounts tab on Account management page.
    When User selects random favorites account.
    Then Dashboard page is opened.
    Then Previously chosen account is displayed on the account info dropdown.
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

  Scenario Outline: Check that Input field for Pre Authorization Code is available for user.
    Then <title> title is displayed on Pre Authorization Code section.
    When User sets some data to the Pre Authorization Code input.
    And Click on Go button.
    Then Empty table with necessary columns appears.
    When User clicks on Send request button.
    Then Table with accounts disappears.

    Examples:
      | title                                                                         |
      | Optional:  Input a Pre Authorization Code to view the Pre Authorized accounts |

  Scenario: Check that Help button works correctly on the Account Management page.
    And Help button is displayed.
    When User clicks on Help button.
    And Click on Sign in with your GE SSO Account button on Lessonly page.
    Then Check that Account management page is opened.
    When User clicks on Help button.
    Then Navigating Accounts tip is displayed on Lessonly widget.



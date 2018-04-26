Feature: Manage users on Pending Requests/ Users/ Revalidation tabs

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Manage Users page is opened.

  Scenario: Check that user able to open Manage Users page and correct header title is displayed
    Then Manage Users title is displayed on Manage Users page.

  Scenario Outline: Check that admin is able to find user by email
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.

    Examples:
      | email                       |
      | d.sanjarevskaya@megogo.net |

  Scenario Outline: Check that admin is able to find user by some account from each region
    When Admin opens Users tab.
    And Sets <account> account to the account field.
    And Clicks on the Search button.
    Then Users list is not empty.

    Examples:
      | account |
      | 1318501 |
      | 9006003 |
      | 9000048 |
      | 30006   |

  Scenario Outline: Check that admin is able to deactivate user and then deactivated user will see /userNotValid page
    And Profile page is opened.
    And Admin's name and last name are stored to threadVars.
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    Then User details block for chosen user with <userId> userId is opened.
    Then Chosen user has Active user status.
    When Admin opens Actions list.
    And Chooses Deactivate User option from the actions list.
    Then Chosen user's status has been changed to Inactive and sub-status details are correct.
    Given Switch to Storefront as shopper.
    And User is logged in to Storefront.
    Then User sees User not valid page.
    Then Appropriate text is displayed on the page.
    Given Switch to Storefront as admin.
    When Admin opens Actions list.
    And Chooses Reactivate User option from the actions list.
    Then Chosen user has Active user status.
    Given Switch to Storefront as shopper.
    Then User is able to use GE site.

    Examples:
      | userId      |
      | enrolltest2 |


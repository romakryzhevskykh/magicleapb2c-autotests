Feature: Some actions on Manage Users page

  Background:
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Manage Users page is opened.

#  Scenario: Check that user able to open Manage Users page and correct header title is displayed
#    Then Manage Users title is displayed on Manage Users page.
#
#  Scenario Outline: Check that admin is able to find user by email
#    When Admin opens Users tab.
#    And Sets <email> email to the email field.
#    And Click on the Search button.
#    Then Appropriate user with appropriate <email> email is displayed in the users list.
#
#    Examples:
#      | email                       |
#      | d.sanjarevskaya2@megogo.net |
#
#  Scenario: Check that admin is able to find user by account

  Scenario Outline: Check that admin is able to add SO code to the internal user
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Click on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Click on the user name in the table.
    When Click on Add account button in User Detail block.
    Then Add Account pop-up is displayed on Manage Users page.
    And Select North America in the Region field in the Add Account pop-up.
    And Set <soCode> SO code to the Second Sales Office Code field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Set <soCode> SO code to the Sales Office Code field in the Add Account pop-up.
    And Click on Modify button in the Add Account pop-up.
    And Expand Modify an Account tab in I Want To Block.
    Then Account from SO code is displayed in the the All Accounts tab.
    When Click on Sales Office Codes tab In Modify an Account Tab.
    Then Appropriate Sales Office Code is displayed in the SO Codes table.
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Account management page is opened.
    When Choose North_America region.
    And Search account from SO code.
    Then Appropriate account is displayed in the table on Account Management Page.
    Given Switch to Storefront as admin.
    And Select All Sales Office Codes checkbox in SO Codes tab.
    And Click on SO Codes Remove button in SO Codes tab.
    Then Remove Account pop-up is displayed on I Want To Block.
    And Click on Remove button in the Remove Account pop-up.
    Then No data available in table title is displayed in Sales Office Code table.

      Examples:
      | email                | soCode |
      | test123rest@ge.com   | USG2   |
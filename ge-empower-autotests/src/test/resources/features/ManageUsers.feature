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
      | email                      |
      | d.sanjarevskaya@megogo.net |

  Scenario Outline: Check that admin is able to add/remove SO code to the internal user
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Click on the first user name in the table.
    When Click on Add account button in User Detail block.
    Then Add Account pop-up is displayed on Manage Users page.
    And Select North America in the Region field in the Add Account pop-up.
    And Set <soCode> SO code to the Second Sales Office Code field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Set <soCode> SO code to the First Sales Office Code field in the Add Account pop-up.
    And Click on Modify button in the Add Account pop-up.
    And Expand Modify an Account tab in I Want To Block.
    Then Account from Add Account pop-up is displayed in the the All Accounts tab.
    When Click on Sales Office Codes tab In Modify an Account Tab.
    Then <soCode> Sales Office Code is displayed in the SO Codes table.
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Choose North_America region.
    And Search Account From Add Account Pop-Up.
    Then Appropriate account is displayed in the table on Account Management Page.
    Given Switch to Storefront as admin.
    And Select All Sales Office Codes checkbox in SO Codes tab.
    And Click on SO Codes Remove button in SO Codes tab.
    And Focus on browser.
    Then Remove Account pop-up is displayed on I Want To Block in SO codes tab.
    And Click on Remove button in the Remove Account pop-up on I Want To Block in SO codes tab.
    Then No data available in table title is displayed in Sales Office Code table.

    Examples:
      | email              | soCode |
      | test123rest@ge.com | USG2   |

  Scenario Outline: Check that admin is able to add/remove SE code to the internal user
    And Refresh page.
    And Focus on browser.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Click on the first user name in the table.
    When Click on Add account button in User Detail block.
    Then Add Account pop-up is displayed on Manage Users page.
    And Select North America in the Region field in the Add Account pop-up.
    And Set <seCode> SE code to the Second Sales Engineer Code field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Set <seCode> SE code to the First Sales Engineer Code field in the Add Account pop-up.
    And Click on Modify button in the Add Account pop-up.
    And Expand Modify an Account tab in I Want To Block.
    Then Account from Add Account pop-up is displayed in the the All Accounts tab.
    When Click on Sales Engineer Codes tab In Modify an Account Tab.
    Then <seCode> Sales Engineer Code is displayed in the SE Codes table.
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Choose North_America region.
    And Search Account From Add Account Pop-Up.
    Then Appropriate account is displayed in the table on Account Management Page.
    Given Switch to Storefront as admin.
    And Select All Sales Engineer Codes checkbox in SE Codes tab.
    And Click on SE Codes Remove button in SE Codes tab.
    And Focus on browser.
    Then Remove Account pop-up is displayed on I Want To Block in SE codes tab.
    And Click on Remove button in the Remove Account pop-up on I Want To Block in SE codes tab.
    Then No data available in table title is displayed in Sales Engineer Code table.

    Examples:
      | email              | seCode    |
      | test123rest@ge.com | 220028351 |

  Scenario Outline: Check that admin is able to find user by some account from each region
    And Refresh page.
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

  Scenario Outline: Check that admin is able to add/remove account to the internal user
    And Refresh page.
    And Focus on browser.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Click on the first user name in the table.
    When Click on Add account button in User Detail block.
    Then Add Account pop-up is displayed on Manage Users page.
    And Select EMEA in the Region field in the Add Account pop-up.
    And Set <account> to the Account field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Click on Select All checkbox in the Add Account pop-up.
    And Click on Add button in the Add Account pop-up.
    And Expand Modify an Account tab in I Want To Block.
    Then Account from Add Account pop-up is displayed in the the All Accounts tab.
    Given Switch to Storefront as internalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Choose EMEA region.
    And Search Account From Add Account Pop-Up.
    Then Appropriate account is displayed in the table on Account Management Page.
    Given Switch to Storefront as admin.
    When Click on <account> checkbox in I Want To Block in All Accounts tab.
    And Click on Remove button in All Accounts tab.
    And Focus on browser.
    Then Remove Account pop-up is displayed on I Want To Block in All Accounts tab.
    And Click on Remove button in the Remove Account pop-up on I Want To Block in All Accounts tab.
    Then Account from Add Account pop-up is not displayed in the the All Accounts tab.

    Examples:
      | email              | account   |
      | test123rest@ge.com |  1000827  |

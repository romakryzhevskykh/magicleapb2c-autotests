Feature: Manage users on Pending Requests/ Users/ Revalidation tabs

  Background:
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.

  Scenario: Check that user able to open Manage Users page and correct header title is displayed
    Then Manage Users title is displayed on Manage Users page.

  Scenario Outline: Check that admin is able to find user by email
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.

    Examples:
      | email                    |
      | externaluser1@zaelab.com |

  Scenario Outline: Check that admin is able to add/remove SO code to the internal user
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Sales Office Codes tab In Modify an Account Tab.
    And Prevent appearing of SO code in SO Codes tab.
    When Click on Add account button in User Detail block.
    Then Add Account pop-up is displayed on Manage Users page.
    And Select <region> in the Region field in the Add Account pop-up.
    And Set <soCode> SO code to the Second Sales Office Code field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Set <soCode> SO code to the First Sales Office Code field in the Add Account pop-up.
    And Click on Modify button in the Add Account pop-up.
    Then Account from Add Account pop-up is displayed in the All Accounts tab.
    When Click on Sales Office Codes tab In Modify an Account Tab.
    Then Is <soCode> Sales Office Code displayed in the Approved SO Codes table.
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Choose <region> region.
    And Search account from Add Account pop-up.
    Then Appropriate account is displayed in the table on Account Management Page.
    Given Switch to Storefront as secondEmpAdmin.
    And Select All Sales Office Codes checkbox in SO Codes tab.
    And Click on SO Codes Remove button in SO Codes tab.
    And Focus on browser.
    Then Remove Account pop-up is displayed on I Want To Block in SO codes tab.
    And Click on Remove button in the Remove Account pop-up on I Want To Block in SO codes tab.
    Then No data available in table title is displayed in Sales Office Code table.

    Examples:
      | email                 | soCode | region        |
      | andrii.zhukov@abb.com | USG2   | North_America |

  Scenario Outline: Check that admin is able to add/remove SE code to the internal user
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Sales Engineer Codes tab In Modify an Account Tab.
    And Prevent appearing of SE code in SE Codes tab.
    Then No data available in table title is displayed in Sales Engineer Code table.
    And Refresh page.
    And Focus on browser.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Add account button in User Detail block.
    Then Add Account pop-up is displayed on Manage Users page.
    And Select North_America in the Region field in the Add Account pop-up.
    And Set <seCode> SE code to the Second Sales Engineer Code field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Set <seCode> SE code to the First Sales Engineer Code field in the Add Account pop-up.
    And Click on Modify button in the Add Account pop-up.
    Then Is account from add account pop-up displayed in the all accounts tab.
    When Click on Sales Engineer Codes tab In Modify an Account Tab.
    Then <seCode> Sales Engineer Code is displayed in the Approved SE Codes table.
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Choose North_America region.
    And Search account from Add Account pop-up.
    Then Appropriate account is displayed in the table on Account Management Page.
    Given Switch to Storefront as secondEmpAdmin.
    And Select All Sales Engineer Codes checkbox in SE Codes tab.
    And Click on SE Codes Remove button in SE Codes tab.
    And Focus on browser.
    Then Remove Account pop-up is displayed on I Want To Block in SE codes tab.
    And Click on Remove button in the Remove Account pop-up on I Want To Block in SE codes tab.
    Then No data available in table title is displayed in Sales Engineer Code table.

    Examples:
      | email                 | seCode    |
      | andrii.zhukov@abb.com | 220028351 |

  Scenario Outline: Check that admin is able to find user by some account from each region
    And Refresh page.
    When Admin opens Users tab.
    And Sets <account> account to the account field.
    And Clicks on the Search button.
    Then Users list is not empty.
    And User cleans account field.

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
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Refresh page.
    Then User sees User not valid page.
    Then Appropriate text is displayed on the page.
    Given Switch to Storefront as secondEmpAdmin.
    When Admin opens Actions list.
    And Chooses Reactivate User option from the actions list.
    Then Chosen user has Active user status.
    Given Switch to Storefront as externalUser1.
    Then User is able to use GE site.

    Examples:
      | userId         |
      | externaluser01 |

  Scenario Outline: Check that admin is able Wipe All Accounts to user and user will see /userNotActive page
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    Then User details block for chosen user with <userId> userId is opened.
    When Admin opens Actions list.
    And Chooses Wipe All Accounts option from the actions list.
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Refresh page.
    Then User not active page is opened.
    Given Switch to Storefront as secondEmpAdmin.
    When Admin opens Actions list.
    And Expand Modify an Account tab in I Want To Block.
    Then No data available in table title is displayed in All Accounts table.
    When Click on Add account button in User Detail block.
    And Select ASIA in the Region field in the Add Account pop-up.
    And Set <account> to the Account field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Click on Select All checkbox in the Add Account pop-up.
    And Click on Add button in the Add Account pop-up.
    Then Is account <account> displayed in the All Accounts tab.

    Examples:
      | userId         | account |
      | externaluser01 | 9012306 |

  Scenario Outline: Check that user can request accounts on /userNotActive page and verify main elements on the second screen.
    And Profile page is opened.
    And Admin's name is stored to threadVars.
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    Then User details block for chosen user with <userId> userId is opened.
    When Admin opens Actions list.
    And Chooses Wipe All Accounts option from the actions list.
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Refresh page.
    Then User not active page is opened.
    When User sets <account> to the Account Number field.
    And Click on Submit for Approval button.
    Then Requested account fields contains <account> account.
    Then Is Appropriate text displayed in the main block on the second screen.
    When User clicks on Yes pre authorization code button.
    Then Is Pre Authorization Code title displayed in Pre Authorization Code pop-up.
    And User closes Pre Authorization Code pop-up.
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    And Refresh page.
    And Focus on browser.
    When Admin opens Users tab.
    And Sets externaluser1 email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table with pending accounts.
    Then Approve Pending Accounts section is displayed with appropriate count of accounts.
    When User expand the Approve Pending Accounts section.
    Then Appropriate count of pending requests are displayed in Pending accounts table.
    When Admin clicks on All accounts checkbox.
    And Click on Accept accounts button.
    And Accept the action in Accept Account pop-up.
    Then Pending accounts table became empty.
    And Expand Modify an Account tab in I Want To Block.
    Then Is account <account> displayed in the All Accounts tab.

    Examples:
      | userId         | account |
      | externaluser01 | 9012306 |

  Scenario Outline: Check that admin is able Wipe All Accounts & Deactivate to user and user will see /userNotActive page
    Given Set true value for lessonly.enabled property on HAC f1, HAC f2.
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Profile page is opened.
    And Admin's name and last name are stored to threadVars.
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    And Get user status in lessonly service for user by email <email>.
    Then User status in lessonly service corresponds to user status in Manage Users page.
    When Admin opens Actions list.
    And Chooses Wipe All Accounts & Deactivate User option from the actions list.
    Then Chosen user's status has been changed to Inactive and sub-status details are correct.
    And Get user status in lessonly service for user by email <email>.
    Then Is INACTIVE user status displayed in lessonly service.
    Given Switch to Storefront as externalUser3.
    And User is logged in to Storefront.
    And Refresh page.
    Then User not active page is opened.
    Given Switch to Storefront as secondEmpAdmin.
    When Admin opens Actions list.
    And Expand Modify an Account tab in I Want To Block.
    Then No data available in table title is displayed in All Accounts table.
    When Admin opens Actions list.
    And Chooses Reactivate User option from the actions list.
    Then Chosen user has Active user status.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Add account button in User Detail block.
    And Select ASIA in the Region field in the Add Account pop-up.
    And Set <account> to the Account field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Click on Select All checkbox in the Add Account pop-up.
    And Click on Add button in the Add Account pop-up.
    Then Is account <account> displayed in the All Accounts tab.
    When Clicks on the user name in the table.
    And Get user status in lessonly service for user by email <email>.
    Then Is ACTIVE user status displayed in lessonly service.
#    Given Set false value for lessonly.enabled property on HAC f1, HAC f2.

    Examples:
      | userId         | account | email                     |
      | externaluser02 | 9012306 | externaluser02@zaelab.com |

  Scenario Outline: Check that user can open /userNotActive page and verify main elements
    And Profile page is opened.
    And Admin's name is stored to threadVars.
    And Manage Users page is opened.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    Then User details block for chosen user with <userId> userId is opened.
    When Admin opens Actions list.
    And Chooses Wipe All Accounts option from the actions list.
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Refresh page.
    Then User not active page is opened.
    Then Is Account Management title displayed.
    Then Is Appropriate text displayed in the main block.
    Then Is Appropriate text displayed in the footer block.
    When User clicks on Request Account button.
    Then Is Request Account title displayed in request pop-up.
    And User closes Request Account pop-up.
    When User clicks on Add New Account field button.
    Then Is Appropriate 2 account No fields displayed.
    Given Switch to Storefront as secondEmpAdmin.
    When Admin opens Actions list.
    And Expand Modify an Account tab in I Want To Block.
    Then No data available in table title is displayed in All Accounts table.
    When Click on Add account button in User Detail block.
    And Select ASIA in the Region field in the Add Account pop-up.
    And Set <account> to the Account field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Click on Select All checkbox in the Add Account pop-up.
    And Click on Add button in the Add Account pop-up.
    Then Is account <account> displayed in the All Accounts tab.
    When Clicks on the user name in the table.
    Then Chosen user has Active user status.

    Examples:
      | userId         | account |
      | externaluser01 | 9012306 |

  Scenario: Check that admin is able to approve some account requests from external user
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Account management page is opened.
    When User switch to Approved Accounts tab on Account management page.
    And User deletes all unnecessary accounts from his profile except 9012306.
    When Request account popup is opened.
    And Popup is filled by North_America, ASIA accounts.
    And User send this requests for approval.
    When User switch to Pending for approval tab on Account management page.
    And All requested accounts are stored to the thread vars hashmap.
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    And Refresh page.
    And Focus on browser.
    When Admin opens Users tab.
    And Sets externaluser01 email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table with pending accounts.
    Then Approve Pending Accounts section is displayed with appropriate count of accounts.
    When User expand the Approve Pending Accounts section.
    Then Appropriate count of pending requests are displayed in Pending accounts table.
    When Admin clicks on All accounts checkbox.
    And Click on Accept accounts button.
    And Accept the action in Accept Account pop-up.
    Then Pending accounts table became empty.
    And Expand Modify an Account tab in I Want To Block.
    Then Appropriate accounts are displayed in All approved Accounts table.
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Account management page is opened.
    And Refresh page.
    When User switch to Approved Accounts tab on Account management page.
    Then All the requested accounts are displayed in the tab.
    When User switch to Approved Accounts tab on Account management page.
    And User deletes all requested accounts from his profile.

  Scenario: Check that admin is able to reject some requested accounts from external user
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Account management page is opened.
    When User switch to Approved Accounts tab on Account management page.
    And User deletes all unnecessary accounts from his profile except 9012306.
    When Refresh page.
    When Request account popup is opened.
    And Popup is filled by North_America, ASIA accounts.
    And User send this requests for approval.
    When User switch to Pending for approval tab on Account management page.
    And All requested accounts are stored to the thread vars hashmap.
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    And Refresh page.
    When Admin opens Users tab.
    And Sets externaluser01 email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table with pending accounts.
    Then Approve Pending Accounts section is displayed with appropriate count of accounts.
    When User expand the Approve Pending Accounts section.
    When Admin clicks on All accounts checkbox.
    And Click on Reject accounts button.
    And Accept the action in Reject Account pop-up.
    Then Pending accounts table became empty.
    And Expand Modify an Account tab in I Want To Block.
    Then Appropriate accounts are not displayed in All approved Accounts table.
    Given Switch to Storefront as externalUser1.
    And User is logged in to Storefront.
    And Account management page is opened.
    And Focus on browser.
    When User switch to Pending for approval tab on Account management page.
    Then List on Pending accounts is empty.
    Then Appropriate reject messages for each account are displayed.

  Scenario Outline: Check that admin is able to add/remove account to the internal user
    And Refresh page.
    And Focus on browser.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    And Expand Modify an Account tab in I Want To Block.
    Then Prevent appearing <account> in the All Accounts tab.
    When Click on Add account button in User Detail block.
    Then Add Account pop-up is displayed on Manage Users page.
    And Select EMEA in the Region field in the Add Account pop-up.
    And Set <account> to the Account field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    Then Add New Accounts table is displayed in the Add Account pop-up.
    When Click on Select All checkbox in the Add Account pop-up.
    And Click on Add button in the Add Account pop-up.
    Then Is account <account> displayed in the All Accounts tab.
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Choose EMEA region.
    And Search an account <account> on Account Management Page.
    Then Is account <account> displayed in the table on Account Management Page.
    Given Switch to Storefront as secondEmpAdmin.
    And Focus on browser.
    When Click on <account> checkbox in I Want To Block in All Accounts tab.
    And Click on Remove button in All Accounts tab.
    Then Remove Account pop-up is displayed on I Want To Block in All Accounts tab.
    And Click on Remove button in the Remove Account pop-up on I Want To Block in All Accounts tab.
    Then Is <account> account not displayed in the All Accounts tab.

    Examples:
      | email                 | account |
      | andrii.zhukov@abb.com | 1000827 |

  Scenario Outline: Check that admin is able to accept SO codes to the internal user
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Sales Office Codes tab In Modify an Account Tab.
    And Prevent appearing of SO code in SO Codes tab.
    Then No data available in table title is displayed in Sales Office Code table.
    And Refresh page.
    And Focus on browser.
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Request account popup is opened.
    When Set <soCode> SO code to the First Sales Office Code field in the Request Account pop-up.
    And Click on Modify button in the Request Account pop-up.
    Given Switch to Storefront as secondEmpAdmin.
    And Manage Users page is opened.
    And Focus on browser.
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    When User expand the Approve Pending Accounts section.
    When Click on Pending Sales Office Codes tab In Approve Pending Accounts Tab.
    Then <soCode> SO code is displayed in the Pending SO codes table.
    When Admin clicks on All Sales Office Codes checkbox in Pending SO Codes tab.
    And Click on Accept SO codes button.
    Then Accept Account pop-up is displayed on I Want To Block in Pending SO Codes tab.
    And Click on Accept button in the Accept Account pop-up on I Want To Block in Pending SO Codes tab.
    Then No data available in table title is displayed in Pending Sales Office Code table.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Sales Office Codes tab In Modify an Account Tab.
    Then Is <soCode> Sales Office Code displayed in the Approved SO Codes table.
    And Select All Sales Office Codes checkbox in SO Codes tab.
    And Click on SO Codes Remove button in SO Codes tab.
    And Focus on browser.
    Then Remove Account pop-up is displayed on I Want To Block in SO codes tab.
    And Click on Remove button in the Remove Account pop-up on I Want To Block in SO codes tab.
    Then No data available in table title is displayed in Sales Office Code table.

    Examples:
      | email                  | soCode |
      | randrii.zhukov@abb.com | USG4   |

  Scenario Outline: Check that admin is able to reject SO codes to the internal user
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Sales Office Codes tab In Modify an Account Tab.
    And Prevent appearing of SO code in SO Codes tab.
    Then No data available in table title is displayed in Sales Office Code table.
    And Refresh page.
    And Focus on browser.
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Refresh page.
    And Account management page is opened.
    When Request account popup is opened.
    When Set <soCode> SO code to the First Sales Office Code field in the Request Account pop-up.
    And Click on Modify button in the Request Account pop-up.
    Given Switch to Storefront as secondEmpAdmin.
    And Manage Users page is opened.
    And Focus on browser.
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    When User expand the Approve Pending Accounts section.
    When Click on Pending Sales Office Codes tab In Approve Pending Accounts Tab.
    Then <soCode> SO code is displayed in the Pending SO codes table.
    When Admin clicks on All Sales Office Codes checkbox in Pending SO Codes tab.
    And Click on Reject SO codes button.
    And Click on Reject button in the Reject Account pop-up on I Want To Block in Pending SO Codes tab.
    Then No data available in table title is displayed in Pending Sales Office Code table.

    Examples:
      | email                 | soCode |
      | andrii.zhukov@abb.com | USG5   |

  Scenario Outline: Check that admin is able to change admin privileges for external user and the user
  will see appropriate role in his profile and appropriate permissions will be available
    And Refresh page.
    And Focus on browser.
    When Admin opens Users tab.
    And Sets <sso> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    And Expand Change an empower Privilege/Role in I want to block.
    Then User has <role> role in each region.
    When Admin Set <newRole> role for each region to the user.
    And All new set roles are stored to threadVarsHashMap.
    And Clicks on Assign button.
    Given Switch to Storefront as testRoleUser.
    And Focus on browser.
    And User is logged in to Storefront.
    And Profile page is opened.
    And Refresh page.
    Then Admin Privileges are equal to roles which were set by Admin in each region.

    Examples:
      | sso          | role                       | newRole                    |
      | testRoleUser | User                       | CA (Customer Admin)        |
      | testRoleUser | CA (Customer Admin)        | SM/ SE (Sales Mgr.)        |
      | testRoleUser | SM/ SE (Sales Mgr.)        | RM/ RE (Sales Reg. Mgr.)   |
      | testRoleUser | RM/ RE (Sales Reg. Mgr.)   | emp RM (empower Reg. Mgr.) |
      | testRoleUser | emp RM (empower Reg. Mgr.) | CS (Customer Ser.)         |
      | testRoleUser | CS (Customer Ser.)         | HD (Help Desk)             |
      | testRoleUser | HD (Help Desk)             | User                       |

  Scenario Outline: Check that admin can open user details page and check appropriate data
    Given Switch to Storefront as thirdInternalUser.
    And User is logged in to Storefront.
    And Profile page is opened.
    And Create User instance.
    Given Switch to Storefront as secondEmpAdmin.
    And Focus on browser.
    And Refresh page.
    When Admin opens Users tab.
    And Sets <email> email to the email field.
    And Clicks on the Search button.
    Then Appropriate user with appropriate <email> email is displayed in the users list.
    When Clicks on the user name in the table.
    When Admin expands user details block.
    Then Is opened user details block displayed.
    Then Is Appropriate data from user profile displayed in user details block for user <email>.
    Then Is Appropriate year 2030 displayed under Revalidation Date label.
    When Admin closes user details block.
    Then Is open user details block not displayed.

    Examples:
      | email                 |
      | andrii.zhukov@abb.com |
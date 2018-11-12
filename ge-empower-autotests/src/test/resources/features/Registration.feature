Feature: Registration flow for external, mfgrep users.

  Scenario Outline: Check that user is able to register as external user and then delete himself from the user's profile.
    Given Switch to Storefront as newUser.
    And User is logged in to Storefront.
    Then Registration page is opened.
    Then First name is equal to <userName>.
    Then Last name is equal to <userLastName>.
    Then User ID is equal to <userId>.
    Then User email is equal to <userEmail>.
    When User fills Company Name <companyName>.
    When User fills Phone No <phoneNo>.
    When User selects random Region from regions list.
    When User selects random Country from countries list.
    When User selects <relationship> Relationship to Industrial Solutions.
    When User selects random Role.
    And Create User instance on registration page with values <companyName>, <userEmail>, <phoneNo>.
    And Click on register button.
    Then Registration successful pop-up is appeared with appropriate header Registration Successful.
    Then User sees User not active page.
    Given Switch to Storefront as secondEmpAdmin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    Then Pending requests tab is active.
    Then Admin is able to see user <userId> on the Pending requests tab with No Account label.
    When Admin clicks on envelope icon near the user <userId>.
    Then Confirmation Email sent pop-up is appeared.
    And Close Confirmation Email sent pop-up.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    When Clicks on the user name in the table.
    Then User details block for chosen user with <userId> userId is opened.
    And Expand Modify an Account tab in I Want To Block.
    When Click on Add account button in User Detail block.
    And Select ASIA in the Region field in the Add Account pop-up.
    And Set <account> to the Account field in the Add Account pop-up.
    And Click on the Search button in the Add Account pop-up.
    When Click on Select All checkbox in the Add Account pop-up.
    And Click on Add button in the Add Account pop-up.
    Given Switch to Storefront as newUser.
    When User clicks on the ABB logo on the userNotActive page.
    And Profile page is opened.
    When User clicks on Permanently delete button.
    And Confirm delete action in the Permanently delete user ID pop-up.
    And Wait for index_html login page is loaded.
    Then Login page is opened.
    Given Switch to Storefront as secondEmpAdmin.
    And Manage Users page is opened.
    And Refresh page.
    When Admin opens Users tab.
    And Sets <userId> email to the email field.
    And Clicks on the Search button.
    Then There is no user in the users list table.

    Examples:
      | userName | userLastName | userId          | userEmail                 | companyName      | phoneNo         | relationship | account |
      | Autotest | NewUser      | autotestnewuser | autotestnewuser@gmail.com | ABB test company | 645284-31234-32 | distributor  | 9012306 |

  Scenario Outline: Check that user is able to register as manufacturer representative user and then admin will delete the user via manage users.
    Given Switch to Storefront as mfgRepUser1.
    And User is logged in to Storefront.
    Then Registration page is opened.
    Then First name is equal to <userName>.
    Then Last name is equal to <userLastName>.
    Then User ID is equal to <userId>.
    Then User email is equal to <userEmail>.
    When User fills Company Name <companyName>.
    When User fills Phone No <phoneNo>.
    When User selects random Region from regions list.
    When User selects random Country from countries list.
    When User selects <relationship> Relationship to Industrial Solutions.
    When User selects appropriate Role <userRole>.
    Then Account information section is not displayed on the Registration page.
    And Create User instance on registration page with values <companyName>, <userEmail>, <phoneNo>.



    Examples:
      | userName | userLastName | userId      | userEmail             | companyName      | phoneNo         | relationship | userRole             |
      | autotest | mfgrep       | newmfguser1 | mfgrepuser@zaelab.com | ABB test company | 645284-31234-32 | manufacturer | zenithrepresentative |
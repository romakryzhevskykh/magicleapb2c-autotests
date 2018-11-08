Feature: Registration flow for external, mfg.rep. users.

  Scenario Outline:
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
    Given Switch to Storefront as admin.
    And User is logged in to Storefront.
    And Manage Users page is opened.
    Then Pending requests tab is active.
    Then Admin is able to see user <userId> on the Pending requests tab with No account label.
    When Admin clicks on envelope icon near the user.
    Then Confirmation Email sent pop-up is appeared.

    Examples:
      | userName | userLastName | userId          | userEmail                 | companyName      | phoneNo         | relationship |
      | Autotest | NewUser      | autotestNewUser | autotestnewuser@gmail.com | ABB test company | 645284-31234-32 | distributor  |



Feature: Check that owner role can create and manage user.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Open Users Management page.

    Scenario: Check user creation from Storefront.
      When Click on Add new user on Users page.
      And Select any title on Edit user page.
      And Fill First name field with a random text on Edit user page.
      And Fill Last name field with a random text on Edit user page.
      And Fill Email field with a random email on Edit user page.
      And Select any Parent unit on Edit user page.
      And Select any user Role on Edit user page.
      And Click on Save button on Edit user page.

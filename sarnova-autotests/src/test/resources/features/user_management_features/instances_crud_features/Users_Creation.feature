Feature: Check that owner role can create user.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.
    And Open Users Management page.

  Scenario: Check user creation from Storefront.
    When Click on Add new user on Users page.
    And Select any title on Create user page.
    And Fill First name field with a random text on Create user page.
    And Fill Last name field with a random text on Create user page.
    And Fill Email field with a random email on Create user page.
    And Select any Parent unit on Create user page.
    And Select any user Role on Create user page.
    And Click on Save button on Create user page.
    Then Check that User details page is opened.
    And Check that User title field is equal to set on User details page.
    And Check that User first name field is equal to set on User details page.
    And Check that User last name field is equal to set on User details page.
    And Check that User email field is equal to set on User details page.
    And Check that User parent unit field is equal to set on User details page.
    And Check that User roles are equal to set on User details page.
    And Check that User status is Enable on User details page.

#  Scenario: Check user creation with all roles from Storefront.
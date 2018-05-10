Feature: Check that owner role can edit user.

  Background:
    Given Switch to Storefront owner.
    And User is logged in to Storefront.

  Scenario: Check user editing from Storefront.
    When Test user is present.
    And Open Test user edit page.
    And Select any title on Edit user page.
    And Fill First name field with a random text on Edit user page.
    And Fill Last name field with a random text on Edit user page.
    And Fill Email field with a random email on Edit user page.
    And Fill Username field with a random email on Edit user page.
    And Select any Parent unit on Edit user page.
    And Click on Save button on Edit user page.
    Then Check that Test user details page is opened.
    And Check that User title field is equal to set on User details page.
    And Check that User first name field is equal to set on User details page.
    And Check that User last name field is equal to set on User details page.
    And Check that User email field is equal to set on User details page.
    And Check that User parent unit field is equal to set on User details page.
    And Check that User status is Enable on User details page.

  Scenario: Check that admin user can reset password to other user.
    When Test user is present.
    And Open Test user details page.
    And Click on Reset password button on User details page.
    And Set new password to New password field on Reset password page.
    And Set the same password to Confirm new password field on Reset password page.
    And Click on Update password button on Reset password page.
    And Switch to Storefront cockpit test user.
    And Opened Login page.
    And Login to Storefront.
    Then Check that Home page is opened.
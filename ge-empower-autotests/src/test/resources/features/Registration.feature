Feature: Registration flow for external, internal, mfgrep users.

  Scenario: Check that user is able to register as external user and then delete himself from the user's profile.
    Given Switch to Storefront as newUser.
    And User is logged in to Storefront.
    Then Registration page is opened.
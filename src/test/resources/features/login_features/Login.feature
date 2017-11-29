Feature: Login to TDSC

  Scenario: Login with positive credentials.
    Given Switch to Storefront shopper.
    Given Login page opened.
    When Fill login field with valid user email.
    And Fill password field with valid user password.
    And Click on submit/login button for valid user.
    Then Check that Home page is opened.

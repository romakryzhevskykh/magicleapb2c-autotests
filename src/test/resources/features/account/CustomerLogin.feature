Feature: Account: Customer logs in

  @Smoke
  Scenario: Customer logs in with valid credentials and logged out
    Given Customer opens Home page
    And Customer navigates to Login Register page
    When Customer logs in with email "sampleempb2bcustomer" and password "12341234"
    Then Customer sees logged in header
    And Customer logs out
    And Customer sees not logged in header

  @Smoke
  Scenario Outline: Customer tries to log in with <email> <password> creds
    Given Customer opens Login Register page
    When Customer logs with <email> and <password>
    Then Login page is opened
    And Error message for incorrect credentials is displayed

    Examples:
      | email                      | password  |
      | test@notExistedAccount.com | 12341234  |
      | sampleempb2bcustomer       | Wrong123. |






Feature: Login to Demo site

  Background:
    Given Switch to Storefront shopper.

  Scenario: USERNAME, PASSWORD fields, labels and LOG IN button are present, texts are equal to expected on Login page
    Given Opened Login page.
    Then Check that Username label is present.
    Then Check that Username label text equals to USERNAME.
    Then Check that Username field is present.
    Then Check that Password label is present.
    Then Check that Password label text equals to PASSWORD.
    Then Check that Password field is present.
    Then Check that Log in button is present.
    Then Check that Log in button text equals to Log In.

  Scenario: Possibility to login with username and password credentials
    Given Opened Login page.
    When Click on Sign in button.
    And Login to Storefront.
    Then Check that Home page is opened.

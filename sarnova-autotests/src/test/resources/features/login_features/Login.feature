Feature: Login to Demo site

  Scenario: Possibility to login with username and password credentials
    Given Switch to Storefront shopper.
    Given Opened Start page.
    When Click on Sign in button.
    And Login to Storefront.
    Then Check that Home page is opened.
